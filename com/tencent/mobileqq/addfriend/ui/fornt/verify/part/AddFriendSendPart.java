package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.AddFriendVerifyFragmentForNT;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FriendPermissionsSwitch;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ef\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001v\u0018\u0000 |2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001}B\u0007\u00a2\u0006\u0004\bz\u0010{J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J$\u0010\u001d\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"H\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010GR\u0018\u0010Z\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010GR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR$\u0010r\u001a\u0012\u0012\u0004\u0012\u00020n0\"j\b\u0012\u0004\u0012\u00020n`o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR&\u0010u\u001a\u0012\u0012\u0004\u0012\u00020s0\"j\b\u0012\u0004\u0012\u00020s`o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010qR\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010x\u00a8\u0006~"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendSendPart;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendSendEvent;", "", "ua", "sa", "initData", "Aa", "ta", "Ca", "za", "", "Ba", "", "code", "", "msg", "xa", "va", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "", PreloadTRTCPlayerParams.KEY_SIG, "ticket", "Ea", "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f;", "mAddFriendSendViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/a;", "mAddFriendGroupViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g;", "mAddFriendVerifyMsgViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/c;", "T", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/c;", "mAddFriendPermissionViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/d;", "U", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/d;", "mAddFriendRemarkViewModel", "Lcom/tencent/mobileqq/addfriend/part/b;", "V", "Lcom/tencent/mobileqq/addfriend/part/b;", "mOpenAddFriendViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "W", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "mAddFriendHeaderViewModel", "", "X", "J", "mStartAddFriendRequestTime", "Landroid/widget/LinearLayout;", "Y", "Landroid/widget/LinearLayout;", "groupAndRemarkLayout", "Landroid/widget/TextView;", "Z", "Landroid/widget/TextView;", "mRequestInfoTxt", "a0", "leftView", "Landroid/widget/EditText;", "b0", "Landroid/widget/EditText;", "mRequestInfoEt", "Landroid/widget/Button;", "c0", "Landroid/widget/Button;", "mCompleteBtn", "d0", "mAnswerCorrectLl", "e0", "mAnswerCheckLl", "Lcom/tencent/mobileqq/widget/FriendPermissionsSwitch;", "f0", "Lcom/tencent/mobileqq/widget/FriendPermissionsSwitch;", "mFriendPermissionsSwitch", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "g0", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mDlgProgress", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "h0", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "mEtRemark", "Landroid/widget/RelativeLayout;", "i0", "Landroid/widget/RelativeLayout;", "titleRoot", "j0", "Landroid/os/Bundle;", "mLastReqData", "Lcom/tencent/mobileqq/data/PhoneContact;", "Lkotlin/collections/ArrayList;", "k0", "Ljava/util/ArrayList;", "mMultiAddedContacts", "Lcom/tencent/mobileqq/addfriend/processor/a;", "l0", "mBusinessProcessors", "com/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendSendPart$b", "m0", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendSendPart$b;", "mAddFriendObserver", "<init>", "()V", "n0", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddFriendSendPart extends v implements SimpleEventReceiver<AddFriendSendEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f mAddFriendSendViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a mAddFriendGroupViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g mAddFriendVerifyMsgViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c mAddFriendPermissionViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d mAddFriendRemarkViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.part.b mOpenAddFriendViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b mAddFriendHeaderViewModel;

    /* renamed from: X, reason: from kotlin metadata */
    private long mStartAddFriendRequestTime;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private LinearLayout groupAndRemarkLayout;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private TextView mRequestInfoTxt;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView leftView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mRequestInfoEt;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button mCompleteBtn;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mAnswerCorrectLl;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mAnswerCheckLl;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FriendPermissionsSwitch mFriendPermissionsSwitch;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProgressDialog mDlgProgress;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ClearableEditText mEtRemark;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout titleRoot;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle mLastReqData;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<PhoneContact> mMultiAddedContacts;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.addfriend.processor.a> mBusinessProcessors;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAddFriendObserver;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendSendPart$a;", "", "", "MAX_ANSWER_BYTES", "I", "REQUEST_CODE_SECCHECK_H5_PAGE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendSendPart$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u001a\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendSendPart$b", "Lcom/tencent/mobileqq/addfriend/observer/a;", "", "isSuccess", "addSuccess", com.tencent.mobileqq.friend.observer.a.ADD_DIRECT, "", "reqUin", "Landroid/os/Bundle;", "bundle", "", tl.h.F, "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/app/AddBatchPhoneFriendResult;", "data", "c", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendSendPart.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        public void c(boolean isSuccess, @Nullable ArrayList<AddBatchPhoneFriendResult> data) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSuccess), data);
                return;
            }
            if (AddFriendSendPart.this.W9()) {
                return;
            }
            if (QLog.isColorLevel()) {
                if (data != null) {
                    i3 = data.size();
                } else {
                    i3 = -1;
                }
                QLog.d("AddFriendSendPart", 2, "onAddBatchPhoneFriend success=" + isSuccess + ", added count=" + i3);
            }
            if (isSuccess) {
                QQProgressDialog qQProgressDialog = AddFriendSendPart.this.mDlgProgress;
                if (qQProgressDialog != null) {
                    qQProgressDialog.dismiss();
                }
                AddFriendSendPart addFriendSendPart = AddFriendSendPart.this;
                QQToast makeText = QQToast.makeText(addFriendSendPart.getActivity(), 2, R.string.hei, 0);
                Intrinsics.checkNotNullExpressionValue(makeText, "makeText(activity, QQToa\u2026d_ok, Toast.LENGTH_SHORT)");
                addFriendSendPart.aa(makeText, true);
                Intent intent = new Intent();
                intent.putExtra("result", data);
                AddFriendSendPart.this.getActivity().setResult(-1, intent);
                AddFriendSendPart.this.getActivity().finish();
                return;
            }
            QQProgressDialog qQProgressDialog2 = AddFriendSendPart.this.mDlgProgress;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.dismiss();
            }
            AddFriendSendPart.this.mMultiAddedContacts.clear();
            AddFriendSendPart addFriendSendPart2 = AddFriendSendPart.this;
            QQToast makeText2 = QQToast.makeText(addFriendSendPart2.getActivity(), 1, R.string.f173065h22, 0);
            Intrinsics.checkNotNullExpressionValue(makeText2, "makeText(\n              \u2026ORT\n                    )");
            addFriendSendPart2.aa(makeText2, true);
            AddFriendSendPart.this.getActivity().setResult(0);
            AddFriendSendPart.this.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        protected void d(boolean isSuccess, @Nullable Bundle bundle) {
            String str;
            QBaseFragment qBaseFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), bundle);
                return;
            }
            if (AddFriendSendPart.this.W9()) {
                return;
            }
            String str2 = "";
            if (isSuccess && bundle != null) {
                AddFriendSendPart.this.mLastReqData = bundle;
                String string = bundle.getString("security_check_url", "");
                String string2 = bundle.getString("security_check_buffer", "");
                IAddFriendTempApi iAddFriendTempApi = (IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class);
                AppInterface z95 = AddFriendSendPart.this.z9();
                Activity activity = AddFriendSendPart.this.getActivity();
                IPartHost partHost = AddFriendSendPart.this.getPartHost();
                if (partHost instanceof QBaseFragment) {
                    qBaseFragment = (QBaseFragment) partHost;
                } else {
                    qBaseFragment = null;
                }
                iAddFriendTempApi.openSecCheckWebForFragment(z95, activity, qBaseFragment, 1004, string, string2);
                str = string2;
                str2 = string;
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendSendPart", 2, "onAddFriendSecCheck, isSuccess=" + isSuccess + ',' + TextUtils.isEmpty(str2) + ',' + TextUtils.isEmpty(str));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.addfriend.observer.a
        protected void h(boolean isSuccess, boolean addSuccess, boolean addDirect, @Nullable String reqUin, @NotNull Bundle bundle) {
            Editable editable;
            String string;
            int i3;
            byte b16;
            CharSequence trim;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Boolean.valueOf(addSuccess), Boolean.valueOf(addDirect), reqUin, bundle);
                return;
            }
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (TextUtils.equals(reqUin, AddFriendSendPart.this.D9()) && !AddFriendSendPart.this.W9()) {
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = null;
                Editable editable2 = null;
                String str = null;
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar2 = null;
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar3 = null;
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar4 = null;
                if (!isSuccess) {
                    AddFriendSendPart.this.ua();
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar5 = AddFriendSendPart.this.mAddFriendSendViewModel;
                    if (fVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                    } else {
                        fVar = fVar5;
                    }
                    fVar.c2(AddFriendSendPart.this.getString(R.string.f173065h22));
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendSendPart", 2, "add friend response error and isSuccuss = NO");
                    }
                    com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendSendPart.this.mStartAddFriendRequestTime, false, AddFriendSendPart.this.S9(0));
                    return;
                }
                int i16 = bundle.getInt("friend_setting");
                if (i16 == 3) {
                    if (addSuccess) {
                        AddFriendSendPart addFriendSendPart = AddFriendSendPart.this;
                        EditText editText = addFriendSendPart.mRequestInfoEt;
                        if (editText != null) {
                            editable2 = editText.getText();
                        }
                        trim = StringsKt__StringsKt.trim((CharSequence) String.valueOf(editable2));
                        addFriendSendPart.Ea(trim.toString(), bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG), bundle.getString("security_ticket", ""));
                        AddFriendSendPart.this.xa(0, "");
                    } else {
                        String string2 = bundle.getString("ErrorString");
                        if (string2 != null) {
                            int length = string2.length() - 1;
                            int i17 = 0;
                            byte b17 = false;
                            while (i17 <= length) {
                                if (b17 == false) {
                                    i3 = i17;
                                } else {
                                    i3 = length;
                                }
                                if (Intrinsics.compare((int) string2.charAt(i3), 32) <= 0) {
                                    b16 = true;
                                } else {
                                    b16 = false;
                                }
                                if (b17 == false) {
                                    if (b16 == false) {
                                        b17 = true;
                                    } else {
                                        i17++;
                                    }
                                } else if (b16 != true) {
                                    break;
                                } else {
                                    length--;
                                }
                            }
                            str = string2.subSequence(i17, length + 1).toString();
                        }
                        if (!Intrinsics.areEqual(str, "")) {
                            string = bundle.getString("ErrorString");
                        } else {
                            string = AddFriendSendPart.this.getString(R.string.f170344mw);
                        }
                        AddFriendSendPart addFriendSendPart2 = AddFriendSendPart.this;
                        QQToast makeText = QQToast.makeText(addFriendSendPart2.getActivity(), 1, string, 1);
                        Intrinsics.checkNotNullExpressionValue(makeText, "makeText(activity, QQToa\u2026orStr, Toast.LENGTH_LONG)");
                        addFriendSendPart2.aa(makeText, true);
                    }
                    com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendSendPart.this.mStartAddFriendRequestTime, true, AddFriendSendPart.this.S9(0));
                    return;
                }
                if (bundle.getInt(QzoneIPCModule.RESULT_CODE) != 0) {
                    AddFriendSendPart.this.ua();
                    int i18 = bundle.getInt("error_code", 0);
                    String string3 = bundle.getString("ErrorString");
                    if (string3 == null) {
                        string3 = AddFriendSendPart.this.getString(R.string.ykb);
                    }
                    Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(FriendC\u2026ing.add_default_erro_msg)");
                    if (i18 == 168) {
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar6 = AddFriendSendPart.this.mAddFriendSendViewModel;
                        if (fVar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                        } else {
                            fVar2 = fVar6;
                        }
                        fVar2.d2(bundle);
                    } else if (i18 == 167) {
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar7 = AddFriendSendPart.this.mAddFriendSendViewModel;
                        if (fVar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                        } else {
                            fVar3 = fVar7;
                        }
                        fVar3.e2(string3);
                    } else if (i18 >= 176) {
                        QQToastUtil.showQQToastInUiThread(1, string3);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendSendPart", 2, "add friend response error and ErroString = " + string3);
                        }
                        if (TextUtils.isEmpty(string3)) {
                            string3 = AddFriendSendPart.this.getString(R.string.f173065h22);
                        }
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar8 = AddFriendSendPart.this.mAddFriendSendViewModel;
                        if (fVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                        } else {
                            fVar4 = fVar8;
                        }
                        fVar4.c2(string3);
                    }
                    com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendSendPart.this.mStartAddFriendRequestTime, false, AddFriendSendPart.this.S9(i18));
                    return;
                }
                bundle.getInt("friend_setting");
                bundle.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
                if (i16 == 0 || i16 == 100) {
                    AddFriendSendPart.this.ua();
                    AddFriendSendPart addFriendSendPart3 = AddFriendSendPart.this;
                    QQToast makeText2 = QQToast.makeText(addFriendSendPart3.getActivity(), 2, R.string.f170041dp, 0);
                    Intrinsics.checkNotNullExpressionValue(makeText2, "makeText(\n              \u2026                        )");
                    addFriendSendPart3.aa(makeText2, true);
                    if (Utils.G(reqUin)) {
                        ClearableEditText clearableEditText = AddFriendSendPart.this.mEtRemark;
                        if (clearableEditText != null) {
                            editable = clearableEditText.getText();
                        } else {
                            editable = null;
                        }
                        String valueOf = String.valueOf(editable);
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b bVar = AddFriendSendPart.this.mAddFriendHeaderViewModel;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendHeaderViewModel");
                            bVar = null;
                        }
                        String L1 = bVar.L1();
                        if (TextUtils.isEmpty(valueOf)) {
                            valueOf = L1;
                        }
                        Intent m3 = BaseAIOUtils.m(new Intent(), null);
                        Intrinsics.checkNotNullExpressionValue(m3, "setOpenAIOIntent(intent, null)");
                        m3.putExtra("uin", reqUin);
                        m3.putExtra("uintype", 0);
                        m3.putExtra("uinname", valueOf);
                        ActivityURIRequest activityURIRequest = new ActivityURIRequest(AddFriendSendPart.this.getActivity(), RouterConstants.UI_ROUTER_SPLASH);
                        activityURIRequest.extra().putAll(m3.getExtras());
                        activityURIRequest.setFlags(m3.getFlags());
                        QRoute.startUri(activityURIRequest);
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendAddFriendNoticeForBaby(AddFriendSendPart.this.z9(), m3);
                    } else {
                        AddFriendSendPart.this.va();
                    }
                } else {
                    AddFriendSendPart.this.ua();
                    AddFriendSendPart addFriendSendPart4 = AddFriendSendPart.this;
                    QQToast makeText3 = QQToast.makeText(addFriendSendPart4.getActivity(), 2, R.string.h1z, 0);
                    Intrinsics.checkNotNullExpressionValue(makeText3, "makeText(\n              \u2026                        )");
                    addFriendSendPart4.aa(makeText3, true);
                    AddFriendSendPart.this.va();
                }
                com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendSendPart.this.mStartAddFriendRequestTime, true, AddFriendSendPart.this.S9(0));
                AddFriendSendPart.this.xa(0, "");
                return;
            }
            com.tencent.relation.common.report.a.c("relation_addfriend_send_request", System.currentTimeMillis() - AddFriendSendPart.this.mStartAddFriendRequestTime, false, AddFriendSendPart.this.S9(0));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddFriendSendPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mStartAddFriendRequestTime = System.currentTimeMillis();
        this.mMultiAddedContacts = new ArrayList<>();
        this.mBusinessProcessors = new ArrayList<>();
        this.mAddFriendObserver = new b();
    }

    private final void Aa() {
        int dimensionPixelSize;
        QIphoneTitleBarFragment qIphoneTitleBarFragment;
        TextView textView;
        QIphoneTitleBarFragment qIphoneTitleBarFragment2;
        Activity activity = getActivity();
        QBaseActivity R9 = R9();
        if (R9 != null) {
            dimensionPixelSize = R9.getTitleBarHeight();
        } else {
            dimensionPixelSize = getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, dimensionPixelSize);
        this.mDlgProgress = qQProgressDialog;
        qQProgressDialog.setMessage(R.string.f170716zu);
        this.mCompleteBtn = (Button) getPartRootView().findViewById(R.id.tdp);
        this.groupAndRemarkLayout = (LinearLayout) getPartRootView().findViewById(R.id.cxh);
        this.mRequestInfoEt = (EditText) getPartRootView().findViewById(R.id.f166785i82);
        this.mRequestInfoTxt = (TextView) getPartRootView().findViewById(R.id.f166786i83);
        this.mAnswerCorrectLl = (LinearLayout) getPartRootView().findViewById(R.id.f6v);
        this.mAnswerCheckLl = (LinearLayout) getPartRootView().findViewById(R.id.f164345si);
        this.mFriendPermissionsSwitch = (FriendPermissionsSwitch) getPartRootView().findViewById(R.id.f68983hi);
        IPartHost partHost = getPartHost();
        RelativeLayout relativeLayout = null;
        if (partHost instanceof QIphoneTitleBarFragment) {
            qIphoneTitleBarFragment = (QIphoneTitleBarFragment) partHost;
        } else {
            qIphoneTitleBarFragment = null;
        }
        if (qIphoneTitleBarFragment != null) {
            textView = qIphoneTitleBarFragment.leftView;
        } else {
            textView = null;
        }
        this.leftView = textView;
        this.mEtRemark = (ClearableEditText) getPartRootView().findViewById(R.id.bz4);
        IPartHost partHost2 = getPartHost();
        if (partHost2 instanceof QIphoneTitleBarFragment) {
            qIphoneTitleBarFragment2 = (QIphoneTitleBarFragment) partHost2;
        } else {
            qIphoneTitleBarFragment2 = null;
        }
        if (qIphoneTitleBarFragment2 != null) {
            relativeLayout = qIphoneTitleBarFragment2.titleRoot;
        }
        this.titleRoot = relativeLayout;
    }

    private final boolean Ba() {
        if (!K9() && !J9() && !H9()) {
            return false;
        }
        return true;
    }

    private final void Ca() {
        LifecycleOwner lifecycleOwner;
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null) {
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = this.mAddFriendSendViewModel;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                fVar = null;
            }
            MutableLiveData<String> T1 = fVar.T1();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendSendPart$observeH5Ticket$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendSendPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:21:0x00bf  */
                /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(@Nullable String str) {
                    boolean z16;
                    Bundle bundle;
                    Bundle bundle2;
                    Bundle bundle3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                        return;
                    }
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar2 = null;
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar3 = null;
                    if (str != null) {
                        bundle = AddFriendSendPart.this.mLastReqData;
                        if (bundle != null) {
                            bundle2 = AddFriendSendPart.this.mLastReqData;
                            String string = bundle2 != null ? bundle2.getString("msg", "") : null;
                            bundle3 = AddFriendSendPart.this.mLastReqData;
                            AddFriendSendPart.this.Ea(string, bundle3 != null ? bundle3.getByteArray(PreloadTRTCPlayerParams.KEY_SIG) : null, str);
                            z16 = true;
                            if (QLog.isColorLevel()) {
                                return;
                            }
                            QLog.d("AddFriendSendPart", 2, "REQUEST_CODE_SECCHECK_H5_PAGE, isSuccess=" + z16);
                            return;
                        }
                        AddFriendSendPart.this.ua();
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar4 = AddFriendSendPart.this.mAddFriendSendViewModel;
                        if (fVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                            fVar4 = null;
                        }
                        fVar4.c2(AddFriendSendPart.this.getString(R.string.f173065h22));
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar5 = AddFriendSendPart.this.mAddFriendSendViewModel;
                        if (fVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                        } else {
                            fVar3 = fVar5;
                        }
                        fVar3.X1(AddFriendSendPart.this.getActivity(), AddFriendSendPart.this.getIntent());
                    } else {
                        AddFriendSendPart.this.ua();
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar6 = AddFriendSendPart.this.mAddFriendSendViewModel;
                        if (fVar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                            fVar6 = null;
                        }
                        fVar6.c2(AddFriendSendPart.this.getString(R.string.f173065h22));
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar7 = AddFriendSendPart.this.mAddFriendSendViewModel;
                        if (fVar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                        } else {
                            fVar2 = fVar7;
                        }
                        fVar2.X1(AddFriendSendPart.this.getActivity(), AddFriendSendPart.this.getIntent());
                    }
                    z16 = false;
                    if (QLog.isColorLevel()) {
                    }
                }
            };
            T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AddFriendSendPart.Da(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(AddFriendSendPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mDlgProgress = null;
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(AddFriendSendViewModel::class.java)");
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f) viewModel;
        this.mAddFriendSendViewModel = fVar;
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
            fVar = null;
        }
        fVar.Z1(H9());
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar3 = this.mAddFriendSendViewModel;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
            fVar3 = null;
        }
        fVar3.a2(J9());
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar4 = this.mAddFriendSendViewModel;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
        } else {
            fVar2 = fVar4;
        }
        fVar2.b2(K9());
        ViewModel viewModel2 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(AddFriendVe\u2026MsgViewModel::class.java)");
        this.mAddFriendVerifyMsgViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g) viewModel2;
        ViewModel viewModel3 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(AddFriendGroupViewModel::class.java)");
        this.mAddFriendGroupViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a) viewModel3;
        ViewModel viewModel4 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "getViewModel(AddFriendPe\u2026ionViewModel::class.java)");
        this.mAddFriendPermissionViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c) viewModel4;
        ViewModel viewModel5 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel5, "getViewModel(AddFriendRemarkViewModel::class.java)");
        this.mAddFriendRemarkViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d) viewModel5;
        ViewModel viewModel6 = getViewModel(com.tencent.mobileqq.addfriend.part.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel6, "getViewModel(OpenAddFriendViewModel::class.java)");
        this.mOpenAddFriendViewModel = (com.tencent.mobileqq.addfriend.part.b) viewModel6;
        ViewModel viewModel7 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel7, "getViewModel(AddFriendHeaderViewModel::class.java)");
        this.mAddFriendHeaderViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b) viewModel7;
        ArrayList<com.tencent.mobileqq.addfriend.processor.a> a16 = new com.tencent.mobileqq.addfriend.helper.a().a(z9());
        Intrinsics.checkNotNullExpressionValue(a16, "mInjectHelper.getProcessors(getAppInterface())");
        this.mBusinessProcessors = a16;
        if (getIntent().hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
            Z9((KplRoleInfo.WZRYUIinfo) getIntent().getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA));
        }
    }

    private final void sa() {
        AppInterface z95 = z9();
        if (z95 == null) {
            return;
        }
        z95.addObserver(this.mAddFriendObserver);
    }

    private final void ta() {
        za();
        Ca();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua() {
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null) {
            if (qQProgressDialog != null) {
                qQProgressDialog.cancel();
            }
            this.mDlgProgress = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.t
            @Override // java.lang.Runnable
            public final void run() {
                AddFriendSendPart.wa(AddFriendSendPart.this);
            }
        }, 900L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(AddFriendSendPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = this$0.mAddFriendSendViewModel;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
            fVar = null;
        }
        int L9 = this$0.L9();
        Intent intent = this$0.getIntent();
        Activity activity = this$0.getActivity();
        String D9 = this$0.D9();
        if (D9 == null) {
            D9 = "";
        }
        fVar.U1(L9, intent, activity, D9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(int code, String msg2) {
        com.tencent.mobileqq.addfriend.part.b bVar = this.mOpenAddFriendViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenAddFriendViewModel");
            bVar = null;
        }
        bVar.L1(code, msg2);
    }

    private final void za() {
        Button button = this.mCompleteBtn;
        if (button == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.titleRoot, "pg_add_user");
        HashMap hashMap = new HashMap();
        hashMap.put("add_user_to_uin", D9());
        hashMap.put("add_user_sourceid", Integer.valueOf(L9()));
        hashMap.put("add_user_subsourceid", Integer.valueOf(M9()));
        hashMap.put("user_request_sourceid", Integer.valueOf(L9()));
        hashMap.put("user_request_subsourceid", Integer.valueOf(M9()));
        hashMap.put("algo_id", getIntent().getStringExtra("algo_id"));
        if (!TextUtils.isEmpty(O9())) {
            hashMap.put("recom_trace", O9());
        }
        Integer P9 = P9();
        if (P9 != null && P9.intValue() == 3) {
            hashMap.put("add_user_appid", getIntent().getStringExtra("extra"));
            hashMap.put("add_user_to_openid", D9());
        }
        VideoReport.setPageParams(this.titleRoot, new PageParams(hashMap));
        VideoReport.setElementId(button, "em_add_user_send_request");
        VideoReport.setElementExposePolicy(button, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(button, ClickPolicy.REPORT_NONE);
    }

    public final void Ea(@Nullable String msg2, @Nullable byte[] sig, @Nullable String ticket) {
        boolean z16;
        int i3;
        Editable editable;
        Editable editable2;
        IAddFriendServiceApi iAddFriendServiceApi;
        NTAddFriendHandler B9;
        Editable editable3;
        int i16;
        int dimensionPixelSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msg2, sig, ticket);
            return;
        }
        AppInterface z95 = z9();
        if (W9()) {
            return;
        }
        if (!NetworkUtil.isNetSupport(getActivity()) && z95 != null) {
            QQToast makeText = QQToast.makeText(z95.getApp(), 1, getActivity().getString(R.string.cjm), 0);
            Intrinsics.checkNotNullExpressionValue(makeText, "makeText(\n              \u2026H_SHORT\n                )");
            aa(makeText, true);
            return;
        }
        if (this.mDlgProgress == null) {
            Activity activity = getActivity();
            QBaseActivity R9 = R9();
            if (R9 != null) {
                dimensionPixelSize = R9.getTitleBarHeight();
            } else {
                dimensionPixelSize = getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, dimensionPixelSize);
            this.mDlgProgress = qQProgressDialog;
            qQProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.u
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AddFriendSendPart.Fa(AddFriendSendPart.this, dialogInterface);
                }
            });
        }
        QQProgressDialog qQProgressDialog2 = this.mDlgProgress;
        if (qQProgressDialog2 != null) {
            qQProgressDialog2.setMessage(R.string.hex);
        }
        QQProgressDialog qQProgressDialog3 = this.mDlgProgress;
        if (qQProgressDialog3 != null) {
            qQProgressDialog3.setCancelable(true);
        }
        QQProgressDialog qQProgressDialog4 = this.mDlgProgress;
        if (qQProgressDialog4 != null) {
            qQProgressDialog4.setCanceledOnTouchOutside(false);
        }
        try {
            QQProgressDialog qQProgressDialog5 = this.mDlgProgress;
            if (qQProgressDialog5 != null) {
                qQProgressDialog5.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendSendPart", 2, e16.toString());
            }
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("sub_source_id", 0);
        int intExtra2 = intent.getIntExtra("friend_setting", 0);
        if (intExtra2 == 3) {
            intExtra2 = 100;
        }
        int i17 = intExtra2;
        boolean booleanExtra = intent.getBooleanExtra("contact_bothway", false);
        String stringExtra = intent.getStringExtra("src_name");
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c cVar = this.mAddFriendPermissionViewModel;
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendPermissionViewModel");
            cVar = null;
        }
        if (!cVar.L1()) {
            FriendPermissionsSwitch friendPermissionsSwitch = this.mFriendPermissionsSwitch;
            if (friendPermissionsSwitch != null) {
                i16 = friendPermissionsSwitch.i();
            } else {
                i16 = 0;
            }
            Bundle bundleExtra = intent.getBundleExtra("flc_extra_param");
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            bundleExtra.putInt("friend_permission", i16);
            getIntent().putExtra("flc_extra_param", bundleExtra);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startAddFriend sig = ");
            String arrays = Arrays.toString(sig);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            sb5.append(arrays);
            sb5.append('}');
            QLog.i("AddFriendSendPart", 2, sb5.toString());
        }
        if (B9() != null && (B9 = B9()) != null) {
            String A9 = A9();
            String D9 = D9();
            String stringExtra2 = intent.getStringExtra("extra");
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar = this.mAddFriendGroupViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                aVar = null;
            }
            int M1 = aVar.M1();
            int L9 = L9();
            byte[] N9 = N9();
            ClearableEditText clearableEditText = this.mEtRemark;
            if (clearableEditText != null) {
                editable3 = clearableEditText.getText();
            } else {
                editable3 = null;
            }
            z16 = booleanExtra;
            i3 = i17;
            B9.L2(A9, D9, stringExtra2, i17, M1, msg2, L9, intExtra, N9, true, sig, z16, String.valueOf(editable3), stringExtra, intent.getByteExtra("show_my_card", (byte) 0), ticket, intent.getExtras(), true, intent.getByteArrayExtra("flc_add_frd_token"));
        } else {
            z16 = booleanExtra;
            i3 = i17;
        }
        if (!com.tencent.mobileqq.addfriend.utils.a.d(i3, L9(), z16) && z95 != null && (iAddFriendServiceApi = (IAddFriendServiceApi) z95.getRuntimeService(IAddFriendServiceApi.class, "")) != null) {
            iAddFriendServiceApi.setAddFriendReqStatus(D9(), true);
        }
        ClearableEditText clearableEditText2 = this.mEtRemark;
        if (clearableEditText2 != null) {
            editable = clearableEditText2.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar2 = this.mAddFriendRemarkViewModel;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
            dVar2 = null;
        }
        if (!Intrinsics.areEqual(valueOf, dVar2.L1())) {
            ClearableEditText clearableEditText3 = this.mEtRemark;
            if (clearableEditText3 != null) {
                editable2 = clearableEditText3.getText();
            } else {
                editable2 = null;
            }
            String valueOf2 = String.valueOf(editable2);
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar3 = this.mAddFriendRemarkViewModel;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
            } else {
                dVar = dVar3;
            }
            if (!Intrinsics.areEqual(valueOf2, dVar.M1())) {
                ReportController.o(z95, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
            }
        }
        if (intent.getIntExtra("sort_id", 0) == 3090) {
            ReportController.o(z95, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
        }
        Iterator<com.tencent.mobileqq.addfriend.processor.a> it = this.mBusinessProcessors.iterator();
        while (it.hasNext()) {
            it.next().b(D9(), L9(), intExtra, E9());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<AddFriendSendEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList<Class<AddFriendSendEvent>> arrayList = new ArrayList<>();
        arrayList.add(AddFriendSendEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        sa();
        initData();
        Aa();
        ta();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = this.mAddFriendSendViewModel;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
            fVar = null;
        }
        fVar.M1();
        AppInterface z95 = z9();
        if (z95 != null) {
            z95.removeObserver(this.mAddFriendObserver);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0156, code lost:
    
        if (r1.M1(r16) == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015e, code lost:
    
        r1 = r15.mAddFriendSendViewModel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0160, code lost:
    
        if (r1 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0162, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0166, code lost:
    
        r2 = getIntent();
        r6 = r15.mAddFriendRemarkViewModel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x016c, code lost:
    
        if (r6 != null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016e, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0173, code lost:
    
        r13 = r1.O1(r2, r16, r12.O1(getIntent()), r5, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0182, code lost:
    
        r1 = r15.mRequestInfoEt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0184, code lost:
    
        if (r1 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0186, code lost:
    
        r1.setText(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0172, code lost:
    
        r12 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x015c, code lost:
    
        if (Ba() == false) goto L112;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPartResume(@NotNull Activity activity) {
        String str;
        String str2;
        String str3;
        byte b16;
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar;
        Editable text;
        EditText editText;
        Editable editable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        if (W9()) {
            return;
        }
        Integer P9 = P9();
        if (P9 == null || P9.intValue() != 4) {
            int intExtra = getIntent().getIntExtra("friend_setting", 0);
            String str4 = "";
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar = null;
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar2 = null;
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = null;
            if (intExtra != 0) {
                if (intExtra == 1) {
                    String string = getString(R.string.axv);
                    if (getIntent().getBooleanExtra("_FROM_QLINK_", false)) {
                        str = string + getString(R.string.f4f) + TokenParser.SP + com.tencent.mobileqq.addfriend.utils.a.g(MobileQQ.sMobileQQ.peekAppRuntime());
                        EditText editText2 = this.mRequestInfoEt;
                        if (editText2 != null) {
                            editText2.setHint(str);
                        }
                    } else {
                        EditText editText3 = this.mRequestInfoEt;
                        if (editText3 != null) {
                            editText3.setHint("");
                        }
                        str = string;
                    }
                    EditText editText4 = this.mRequestInfoEt;
                    if (editText4 != null) {
                        editText4.setVisibility(0);
                    }
                    TextView textView = this.mRequestInfoTxt;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    if (AddFriendVerifyFragmentForNT.T && (editText = this.mRequestInfoEt) != null) {
                        if (editText != null) {
                            editable = editText.getText();
                        } else {
                            editable = null;
                        }
                        editText.setContentDescription(String.valueOf(editable));
                    }
                    EditText editText5 = this.mRequestInfoEt;
                    if (editText5 == null || (text = editText5.getText()) == null || (str2 = text.toString()) == null) {
                        str2 = "";
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        QLog.d("AddFriendSendPart", 2, "verifyMsg is not null");
                        return;
                    }
                    Integer P92 = P9();
                    if (P92 != null && P92.intValue() == 3) {
                        String stringExtra = getIntent().getStringExtra("msg");
                        if (stringExtra == null) {
                            str2 = "";
                        } else {
                            str2 = stringExtra;
                        }
                    } else if (Q9() != null) {
                        KplRoleInfo.WZRYUIinfo Q9 = Q9();
                        if (Q9 != null) {
                            str3 = Q9.verifyMsg;
                        } else {
                            str3 = null;
                        }
                        if (str3 == null) {
                            str2 = "";
                        } else {
                            str2 = str3;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            b16 = false;
                            if (TextUtils.isEmpty(str2)) {
                                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar2 = this.mAddFriendVerifyMsgViewModel;
                                if (gVar2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                                    gVar2 = null;
                                }
                                String L1 = gVar2.L1(activity, false);
                                if (L1 != null) {
                                    str4 = L1;
                                }
                                str2 = str4;
                            }
                            if (TextUtils.isEmpty(str2)) {
                                str2 = str;
                            }
                            if (b16 != false && Intrinsics.areEqual(string, str2)) {
                                gVar = this.mAddFriendVerifyMsgViewModel;
                                if (gVar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                                    gVar = null;
                                }
                            }
                        }
                    }
                    b16 = true;
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (b16 != false) {
                        gVar = this.mAddFriendVerifyMsgViewModel;
                        if (gVar == null) {
                        }
                    }
                }
            } else if (L9() == 3078 || L9() == 3079 || L9() == 3912) {
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar3 = this.mAddFriendVerifyMsgViewModel;
                if (gVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                    gVar3 = null;
                }
                String L12 = gVar3.L1(activity, false);
                if (L12 == null) {
                    L12 = "";
                }
                String string2 = activity.getString(R.string.axv);
                Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t\u2026.enter_add_failed_reason)");
                if (TextUtils.isEmpty(L12)) {
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar4 = this.mAddFriendVerifyMsgViewModel;
                    if (gVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                        gVar4 = null;
                    }
                    if (gVar4.M1(activity) && !Ba()) {
                        if (J9()) {
                            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar2 = this.mAddFriendSendViewModel;
                            if (fVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                            } else {
                                fVar = fVar2;
                            }
                            L12 = fVar.N1(getIntent(), string2, string2);
                        } else {
                            L12 = string2;
                        }
                    } else {
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar3 = this.mAddFriendSendViewModel;
                        if (fVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                            fVar3 = null;
                        }
                        Intent intent = getIntent();
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar3 = this.mAddFriendRemarkViewModel;
                        if (dVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
                        } else {
                            dVar = dVar3;
                        }
                        L12 = fVar3.O1(intent, activity, dVar.O1(getIntent()), string2, string2);
                    }
                }
                if (I9() && (L12 = getIntent().getStringExtra("msg")) == null) {
                    L12 = "";
                }
                EditText editText6 = this.mRequestInfoEt;
                if (editText6 != null) {
                    editText6.setHint("");
                }
                EditText editText7 = this.mRequestInfoEt;
                if (editText7 != null) {
                    editText7.setText(L12);
                }
            }
        }
        com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - getIntent().getLongExtra("startAddFriendCheckFragment", 0L), true, S9(0));
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddFriendExposure(E9());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else if (event instanceof AddFriendSendEvent) {
            AddFriendSendEvent addFriendSendEvent = (AddFriendSendEvent) event;
            Ea(addFriendSendEvent.getMsg(), addFriendSendEvent.getSig(), addFriendSendEvent.getTicket());
        } else {
            QLog.i("AddFriendSendPart", 1, "onReceiveEvent error type event");
        }
    }
}
