package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
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
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0002`aB\u000f\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\b]\u0010^J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J0\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u0003J\b\u0010\u0011\u001a\u00020\u0005H\u0002J4\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016J\"\u0010(\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u001eH\u0016R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/g;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "coverUrl", "", "O9", "title", "P9", "Lcom/tencent/image/URLImageView;", "imageView", "", "viewWidth", "viewHeight", "url", "defaultImgId", "K9", "J9", "tip", "positiveTxt", "Landroid/content/DialogInterface$OnClickListener;", "positiveClickListener", "negativeTxt", "negativeClickListener", "T9", "R9", "W9", "X9", "N9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "newIntent", "onNewIntent", "onPartDestroy", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/g$b;", "d", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/g$b;", "avatarPartAdapter", "e", "Lcom/tencent/image/URLImageView;", "coverImageView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "editTextIcon", "Landroid/widget/EditText;", tl.h.F, "Landroid/widget/EditText;", "titleEditText", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "locationLayout", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "locationTextView", "Lcom/tencent/mobileqq/qqlive/base/permission/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/base/permission/a;", "permissionManager", "Landroid/net/Uri;", "D", "Landroid/net/Uri;", "uploadPathUri", "", "E", "Z", "hasSelectedPhoto", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "viewModel", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "G", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "qqCustomDialog", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "H", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/g$b;)V", "I", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.permission.a permissionManager;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Uri uploadPathUri;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasSelectedPhoto;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.prepare.k viewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog qqCustomDialog;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b avatarPartAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLImageView coverImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView editTextIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText titleEditText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout locationLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView locationTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/g$a;", "", "", "DP_COVER_HEIGHT", "I", "DP_COVER_WIDTH", "REQUEST_CODE_EDIT_PHOTO", "REQUEST_CODE_FOR_TAKE_PICTURE_FROM_CAMERA", "TITLE_MAX_LENGTH", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.rtmp.g$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/g$b;", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/g$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                g.this.R9();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@NotNull List<String> permissions, @NotNull List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
            QQToast.makeText(g.this.getActivity(), g.this.getContext().getText(R.string.f210375hy), 1).show();
            QLog.d(g.this.getTAG(), 1, "the initial permission read write storage was been denied");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/g$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements TextWatcher {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            if (!TextUtils.isEmpty(s16.toString())) {
                ImageView imageView = g.this.editTextIcon;
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(8);
            } else {
                ImageView imageView2 = g.this.editTextIcon;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setVisibility(0);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            EditText editText = g.this.titleEditText;
            Intrinsics.checkNotNull(editText);
            Editable text = editText.getText();
            if (text.length() > 15) {
                int selectionEnd = Selection.getSelectionEnd(text);
                String substring = text.toString().substring(0, 15);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                EditText editText2 = g.this.titleEditText;
                Intrinsics.checkNotNull(editText2);
                editText2.setText(substring);
                EditText editText3 = g.this.titleEditText;
                Intrinsics.checkNotNull(editText3);
                text = editText3.getText();
                if (selectionEnd > text.length()) {
                    selectionEnd = text.length();
                }
                Selection.setSelection(text, selectionEnd);
            }
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = g.this.viewModel;
            if (kVar != null) {
                kVar.p2(text.toString());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/g$e", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            g.this.uploadPathUri = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(g.this.getActivity(), 1);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@NotNull List<String> permissions, @NotNull List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
            AegisLogger.INSTANCE.e(g.this.getTAG(), "takePhotoFromCamera", "permission denied");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull b avatarPartAdapter) {
        Intrinsics.checkNotNullParameter(avatarPartAdapter, "avatarPartAdapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) avatarPartAdapter);
            return;
        }
        this.avatarPartAdapter = avatarPartAdapter;
        this.permissionManager = new com.tencent.mobileqq.qqlive.base.permission.a();
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
    }

    private final void J9() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            if (kVar.k2()) {
                String string = getActivity().getResources().getString(R.string.f210545ie);
                Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ng.qqlive_face_auth_fail)");
                String string2 = getActivity().getResources().getString(R.string.f169272hw);
                Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt\u2026ulti_link_mic_preview_ok)");
                T9(string, string2, null, "", null);
                return;
            }
            if (kVar.l2()) {
                String string3 = getActivity().getResources().getString(R.string.f210295hq);
                Intrinsics.checkNotNullExpressionValue(string3, "activity.resources.getSt\u2026_anchor_center_under_age)");
                String string4 = getActivity().getResources().getString(R.string.f169272hw);
                Intrinsics.checkNotNullExpressionValue(string4, "activity.resources.getSt\u2026ulti_link_mic_preview_ok)");
                T9(string3, string4, null, "", null);
                return;
            }
        }
        this.permissionManager.g(getActivity(), new c());
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void K9(URLImageView imageView, int viewWidth, int viewHeight, String url, int defaultImgId) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (defaultImgId != 0 && getActivity().getResources() != null) {
                obtain.mFailedDrawable = getActivity().getResources().getDrawable(defaultImgId);
            }
            int dip2px = ViewUtils.dip2px(viewWidth);
            int dip2px2 = ViewUtils.dip2px(viewHeight);
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            drawable.setTag(new int[]{dip2px, dip2px2});
            drawable.setDecodeHandler(com.tencent.mobileqq.qqlive.room.prepare.b.f271920m);
            imageView.setImageDrawable(drawable);
        } catch (Exception e16) {
            this.aegisLog.e(getTAG(), 1, e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(g this$0, CoverInfo coverInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (coverInfo != null) {
            str = coverInfo.roomLogo16v9;
        } else {
            str = null;
        }
        this$0.O9(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(g this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9(str);
    }

    private final void N9() {
        Long l3;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        Uri uri = this.uploadPathUri;
        if (uri != null) {
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(getContext(), uri);
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
            if (kVar != null && (qQLiveAnchorDataPrepare = kVar.f271954i) != null && (qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr) != null) {
                l3 = Long.valueOf(qQLiveAnchorDataRoomAttr.roomId);
            } else {
                l3 = null;
            }
            String valueOf = String.valueOf(l3);
            if (!TextUtils.isEmpty(realPathFromContentURI) && !TextUtils.isEmpty(valueOf)) {
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterCropFragment(getActivity(), realPathFromContentURI, valueOf, 2);
            }
        }
    }

    private final void O9(String coverUrl) {
        if (TextUtils.isEmpty(coverUrl)) {
            this.aegisLog.i(getTAG(), 1, "coverUrl is empty");
            return;
        }
        this.aegisLog.i(getTAG(), 1, "upload success cover url is " + coverUrl);
        URLImageView uRLImageView = this.coverImageView;
        Intrinsics.checkNotNull(uRLImageView);
        Intrinsics.checkNotNull(coverUrl);
        K9(uRLImageView, 85, 120, coverUrl, R.drawable.nmi);
    }

    private final void P9(String title) {
        final EditText editText = this.titleEditText;
        if (editText != null) {
            if (TextUtils.isEmpty(title)) {
                editText.setText("");
                editText.setHint(getActivity().getResources().getString(R.string.f210365hx));
                editText.clearFocus();
                URLImageView uRLImageView = this.coverImageView;
                if (uRLImageView != null) {
                    uRLImageView.requestFocus();
                }
                ImageView imageView = this.editTextIcon;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.editTextIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            editText.setText(title);
            editText.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.Q9(editText);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(EditText it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Editable text = it.getText();
        Selection.setSelection(text, text.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f199844qi, 5);
        actionSheet.addButton(R.string.f199834qh, 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.e
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                g.S9(g.this, actionSheet, view, i3);
            }
        });
        if (!actionSheet.isShowing()) {
            actionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(g this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.X9();
            }
        } else {
            this$0.W9();
        }
        actionSheet.dismiss();
    }

    private final void T9(String tip, String positiveTxt, final DialogInterface.OnClickListener positiveClickListener, String negativeTxt, final DialogInterface.OnClickListener negativeClickListener) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        Activity activity = getActivity();
        boolean z16 = true;
        if (activity != null && !activity.isFinishing()) {
            if (this.qqCustomDialog == null) {
                if (TextUtils.isEmpty(positiveTxt) && positiveClickListener == null) {
                    onClickListener = null;
                } else {
                    onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.c
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            g.U9(positiveClickListener, dialogInterface, i3);
                        }
                    };
                }
                if (TextUtils.isEmpty(negativeTxt) && negativeClickListener == null) {
                    onClickListener2 = null;
                } else {
                    onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.d
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            g.V9(negativeClickListener, dialogInterface, i3);
                        }
                    };
                }
                this.qqCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, tip, negativeTxt, positiveTxt, onClickListener, onClickListener2);
            }
            QQCustomDialog qQCustomDialog = this.qqCustomDialog;
            if (qQCustomDialog == null || qQCustomDialog.isShowing()) {
                z16 = false;
            }
            if (z16) {
                QQCustomDialog qQCustomDialog2 = this.qqCustomDialog;
                if (qQCustomDialog2 != null) {
                    qQCustomDialog2.setMessage(tip);
                }
                QQCustomDialog qQCustomDialog3 = this.qqCustomDialog;
                if (qQCustomDialog3 != null) {
                    qQCustomDialog3.show();
                    return;
                }
                return;
            }
            return;
        }
        QLog.i(getTAG(), 1, "[showTipDialog] the activity is null or is finished ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i3);
        }
    }

    private final void W9() {
        this.permissionManager.b(getHostFragment(), new e());
    }

    private final void X9() {
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getActivity().getClass().getName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", getActivity().getPackageName());
        bundle.putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        getActivity().overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoList(getActivity(), bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveRtmpPrepareAvatarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar;
        MutableLiveData<CoverInfo> mutableLiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1) {
            if (requestCode == 2) {
                this.hasSelectedPhoto = false;
                if (data == null) {
                    return;
                }
                CoverInfo coverInfo = (CoverInfo) data.getSerializableExtra(IQQLiveUtil.COVER_INFO_KEY);
                Unit unit = null;
                if (coverInfo != null && (kVar = this.viewModel) != null && (mutableLiveData = kVar.E) != null) {
                    mutableLiveData.setValue(coverInfo);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    int intExtra = data.getIntExtra(IQQLiveUtil.UPLOAD_ERROR_CODE, 0);
                    if (intExtra != 0) {
                        QQToast.makeText(getActivity(), getActivity().getResources().getString(R.string.f210215hi), 1).show();
                    }
                    this.aegisLog.i(getTAG(), 1, "onActivityResult[REQUEST_CODE_EDIT_PHOTO] error code " + intExtra + " errorMsg " + data.getStringExtra(IQQLiveUtil.UPLOAD_ERROR_MESSAGE));
                    return;
                }
                return;
            }
            return;
        }
        N9();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60752w_) {
                J9();
            } else if (num != null && num.intValue() == R.id.f61362xx) {
                ImageView imageView = this.editTextIcon;
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(8);
            } else if ((num == null || num.intValue() != R.id.f60932wr) && num != null) {
                num.intValue();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            this.coverImageView = (URLImageView) rootView.findViewById(R.id.f60752w_);
            this.editTextIcon = (ImageView) rootView.findViewById(R.id.f61362xx);
            this.titleEditText = (EditText) rootView.findViewById(R.id.f60932wr);
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.f60812wf);
            this.locationLayout = linearLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            this.locationTextView = (TextView) rootView.findViewById(R.id.f60792wd);
        }
        URLImageView uRLImageView = this.coverImageView;
        if (uRLImageView != null) {
            uRLImageView.setOnClickListener(this);
        }
        ImageView imageView = this.editTextIcon;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        EditText editText = this.titleEditText;
        if (editText != null) {
            editText.setOnClickListener(this);
        }
        LinearLayout linearLayout2 = this.locationLayout;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this);
        }
        EditText editText2 = this.titleEditText;
        if (editText2 != null) {
            editText2.addTextChangedListener(new d());
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = (com.tencent.mobileqq.qqlive.room.prepare.k) new ViewModelProvider(getHostFragment(), com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        this.viewModel = kVar;
        if (kVar != null) {
            kVar.E.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.L9(g.this, (CoverInfo) obj);
                }
            });
            kVar.F.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.M9(g.this, (String) obj);
                }
            });
        }
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.coverImageView, "em_qqlive_cover_edit", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.titleEditText, "em_qqlive_title_edit", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.locationLayout, "em_qqlive_mylocation", hashMap);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(@Nullable Intent newIntent) {
        String str;
        ArrayList<String> arrayList;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newIntent);
            return;
        }
        super.onNewIntent(newIntent);
        this.aegisLog.i(getTAG(), 1, "onNewIntent function");
        Long l3 = null;
        if (newIntent != null) {
            str = newIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (newIntent == null || (arrayList = newIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS")) == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.size() > 0) {
            String str3 = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(str3, "pathList[0]");
            str2 = str3;
        } else if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        if (TextUtils.isEmpty(str2)) {
            this.aegisLog.i(getTAG(), 1, "the path is empty");
            return;
        }
        if (!this.hasSelectedPhoto) {
            this.hasSelectedPhoto = true;
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
            if (kVar != null && (qQLiveAnchorDataPrepare = kVar.f271954i) != null && (qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr) != null) {
                l3 = Long.valueOf(qQLiveAnchorDataRoomAttr.roomId);
            }
            String valueOf = String.valueOf(l3);
            if (!TextUtils.isEmpty(valueOf)) {
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterCropFragment(getActivity(), str2, valueOf, 2);
            } else {
                this.aegisLog.i(getTAG(), 1, "[onNewIntent] the roomId is empty");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onPartDestroy(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onPartResume(activity);
        }
    }
}
