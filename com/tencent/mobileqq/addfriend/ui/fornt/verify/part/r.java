package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FriendPermissionsSwitch;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 v2\u00020\u0001:\u0006wxyz{|B\u0007\u00a2\u0006\u0004\bt\u0010uJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001bJ$\u0010!\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\fR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010KR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010GR\u0018\u0010\\\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010GR\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR$\u0010q\u001a\u0012\u0012\u0004\u0012\u00020Q0mj\b\u0012\u0004\u0012\u00020Q`n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR$\u0010s\u001a\u0012\u0012\u0004\u0012\u00020I0mj\b\u0012\u0004\u0012\u00020I`n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010p\u00a8\u0006}"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "", "initData", "ta", "qa", "va", "ua", "xa", "za", "Ba", "sa", "", "from", "Aa", "", "type", "ra", "result", "r2", "Ea", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "msg", "", "isTroop", "Ca", "", PreloadTRTCPlayerParams.KEY_SIG, "ticket", "Da", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/f;", "mAddFriendSendViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/a;", "mAddFriendGroupViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g;", "mAddFriendVerifyMsgViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/c;", "T", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/c;", "mAddFriendPermissionViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/d;", "U", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/d;", "mAddFriendRemarkViewModel", "Lcom/tencent/mobileqq/addfriend/part/b;", "V", "Lcom/tencent/mobileqq/addfriend/part/b;", "mOpenAddFriendViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "W", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "mAddFriendHeaderViewModel", "X", "I", "friendSetting", "", "Y", "J", "mStartAddFriendRequestTime", "Landroid/widget/LinearLayout;", "Z", "Landroid/widget/LinearLayout;", "groupAndRemarkLayout", "Landroid/widget/TextView;", "a0", "Landroid/widget/TextView;", "mRequestInfoTxt", "b0", "leftView", "c0", "mReportText", "Landroid/widget/EditText;", "d0", "Landroid/widget/EditText;", "mRequestInfoEt", "Landroid/widget/Button;", "e0", "Landroid/widget/Button;", "mCompleteBtn", "f0", "mAnswerCorrectLl", "g0", "mAnswerCheckLl", "Lcom/tencent/mobileqq/widget/FriendPermissionsSwitch;", "h0", "Lcom/tencent/mobileqq/widget/FriendPermissionsSwitch;", "mFriendPermissionsSwitch", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/w;", "i0", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/w;", "mAnswerCorrectTW", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "j0", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "mEtRemark", "Landroid/widget/RelativeLayout;", "k0", "Landroid/widget/RelativeLayout;", "titleRoot", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "l0", "Ljava/util/ArrayList;", "mAnswerArray", "m0", "mQuestion", "<init>", "()V", "n0", "a", "b", "c", "d", "e", "f", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class r extends v {
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
    private int friendSetting;

    /* renamed from: Y, reason: from kotlin metadata */
    private long mStartAddFriendRequestTime;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private LinearLayout groupAndRemarkLayout;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mRequestInfoTxt;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView leftView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mReportText;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mRequestInfoEt;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button mCompleteBtn;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mAnswerCorrectLl;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mAnswerCheckLl;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FriendPermissionsSwitch mFriendPermissionsSwitch;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private w mAnswerCorrectTW;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ClearableEditText mEtRemark;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout titleRoot;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<EditText> mAnswerArray;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<TextView> mQuestion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00a6\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "<init>", "(Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public abstract class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                r.this.sa();
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.r$b, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$c;", "Lcom/tencent/mobileqq/addfriend/strategy/IAddAcceptBlockStrategy$a;", "", "onSuccess", "", "a", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "msg", "<init>", "(Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;Ljava/lang/String;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public final class c implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String msg;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f187559b;

        public c(@NotNull r rVar, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.f187559b = rVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) rVar, (Object) msg2);
            } else {
                this.msg = msg2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
        
            if (r3 == null) goto L22;
         */
        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSuccess() {
            boolean z16;
            String str;
            String obj;
            CharSequence trim;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (this.f187559b.X9() && this.f187559b.getActivity() != null) {
                this.f187559b.Ba();
                int i3 = 0;
                while (true) {
                    if (i3 < this.f187559b.mAnswerArray.size()) {
                        Object obj2 = this.f187559b.mAnswerArray.get(i3);
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.widget.EditText");
                        Editable text = ((EditText) obj2).getText();
                        if (text != null && (obj = text.toString()) != null) {
                            trim = StringsKt__StringsKt.trim((CharSequence) obj);
                            str = trim.toString();
                        }
                        str = "";
                        if (Intrinsics.areEqual("", str)) {
                            z16 = true;
                            break;
                        }
                        String quoteReplacement = Matcher.quoteReplacement(str);
                        Intrinsics.checkNotNullExpressionValue(quoteReplacement, "quoteReplacement(answerString)");
                        this.msg = new Regex("\\$\\{answer\\}").replaceFirst(this.msg, quoteReplacement);
                        i3++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = null;
                if (z16) {
                    r rVar = this.f187559b;
                    QQToast makeText = QQToast.makeText(rVar.getActivity(), 0, this.f187559b.getActivity().getString(R.string.f170345mx), 0);
                    Intrinsics.checkNotNullExpressionValue(makeText, "makeText(\n              \u2026ORT\n                    )");
                    rVar.aa(makeText, true);
                } else {
                    this.f187559b.Da(this.msg, null, "");
                }
                this.f187559b.Aa("NeedAnswerAndCheckIdentitySuccess");
                this.f187559b.Ea("NeedAnswerAndCheckIdentitySuccess", 0, "");
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar2 = this.f187559b.mAddFriendSendViewModel;
                if (fVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                } else {
                    fVar = fVar2;
                }
                fVar.P1(this.f187559b.getActivity(), this.f187559b.getIntent(), this.f187559b.L9(), this.f187559b.friendSetting);
                return;
            }
            QLog.e("AddFriendSendButtonPart", 1, "isAdded false or getActivity null");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$d;", "Lcom/tencent/mobileqq/addfriend/strategy/IAddAcceptBlockStrategy$a;", "", "onSuccess", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "a", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "answerEt", "<init>", "(Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;Lcom/tencent/mobileqq/widget/ClearableEditText;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public final class d implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ClearableEditText answerEt;

        public d(@Nullable ClearableEditText clearableEditText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this, (Object) clearableEditText);
            } else {
                this.answerEt = clearableEditText;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0172  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSuccess() {
            String str;
            int i3;
            NTAddFriendHandler B9;
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar;
            Editable text;
            String obj;
            CharSequence trim;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (r.this.X9() && r.this.getActivity() != null) {
                r.this.Ba();
                ClearableEditText clearableEditText = this.answerEt;
                if (clearableEditText != null && (text = clearableEditText.getText()) != null && (obj = text.toString()) != null) {
                    trim = StringsKt__StringsKt.trim((CharSequence) obj);
                    String obj2 = trim.toString();
                    if (obj2 != null) {
                        str = obj2;
                        int i16 = 0;
                        if (!Intrinsics.areEqual("", str)) {
                            r rVar = r.this;
                            QQToast makeText = QQToast.makeText(rVar.getActivity(), 0, r.this.getActivity().getString(R.string.f170345mx), 0);
                            Intrinsics.checkNotNullExpressionValue(makeText, "makeText(\n              \u2026ORT\n                    )");
                            rVar.aa(makeText, true);
                        } else {
                            if (NetworkUtil.isNetSupport(r.this.getActivity())) {
                                String stringExtra = r.this.getIntent().getStringExtra("extra");
                                String stringExtra2 = r.this.getIntent().getStringExtra("src_name");
                                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c cVar = r.this.mAddFriendPermissionViewModel;
                                if (cVar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendPermissionViewModel");
                                    cVar = null;
                                }
                                if (!cVar.L1()) {
                                    FriendPermissionsSwitch friendPermissionsSwitch = r.this.mFriendPermissionsSwitch;
                                    if (friendPermissionsSwitch != null) {
                                        i16 = friendPermissionsSwitch.i();
                                    }
                                    Bundle bundleExtra = r.this.getIntent().getBundleExtra("flc_extra_param");
                                    if (bundleExtra == null) {
                                        bundleExtra = new Bundle();
                                    }
                                    bundleExtra.putInt("friend_permission", i16);
                                    r.this.getIntent().putExtra("flc_extra_param", bundleExtra);
                                }
                                if (r.this.B9() != null && (B9 = r.this.B9()) != null) {
                                    B9.L2(r.this.A9(), r.this.D9(), stringExtra, r.this.friendSetting, 0, str, r.this.L9(), r.this.M9(), null, false, null, false, null, stringExtra2, (byte) 0, "", r.this.getIntent().getBundleExtra("flc_extra_param"), true, r.this.getIntent().getByteArrayExtra("flc_add_frd_token"));
                                    i3 = 1;
                                }
                            } else {
                                r rVar2 = r.this;
                                i3 = 1;
                                QQToast makeText2 = QQToast.makeText(rVar2.getActivity(), 1, r.this.getActivity().getString(R.string.f171139ci4), 0);
                                Intrinsics.checkNotNullExpressionValue(makeText2, "makeText(\n              \u2026                        )");
                                rVar2.aa(makeText2, true);
                            }
                            r.this.Aa("NeedAnswerIdentitySuccess");
                            r.this.Ea("NeedAnswerIdentitySuccess", i3, "");
                            fVar = r.this.mAddFriendSendViewModel;
                            if (fVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                                fVar = null;
                            }
                            fVar.P1(r.this.getActivity(), r.this.getIntent(), r.this.L9(), r.this.friendSetting);
                            return;
                        }
                        i3 = 1;
                        r.this.Aa("NeedAnswerIdentitySuccess");
                        r.this.Ea("NeedAnswerIdentitySuccess", i3, "");
                        fVar = r.this.mAddFriendSendViewModel;
                        if (fVar == null) {
                        }
                        fVar.P1(r.this.getActivity(), r.this.getIntent(), r.this.L9(), r.this.friendSetting);
                        return;
                    }
                }
                str = "";
                int i162 = 0;
                if (!Intrinsics.areEqual("", str)) {
                }
                i3 = 1;
                r.this.Aa("NeedAnswerIdentitySuccess");
                r.this.Ea("NeedAnswerIdentitySuccess", i3, "");
                fVar = r.this.mAddFriendSendViewModel;
                if (fVar == null) {
                }
                fVar.P1(r.this.getActivity(), r.this.getIntent(), r.this.L9(), r.this.friendSetting);
                return;
            }
            QLog.e("AddFriendSendButtonPart", 1, "isAdded false or getActivity null");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$e;", "Lcom/tencent/mobileqq/addfriend/strategy/IAddAcceptBlockStrategy$a;", "", "onSuccess", "<init>", "(Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public final class e implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        public void onSuccess() {
            Editable editable;
            CharSequence trim;
            Editable editable2;
            CharSequence trim2;
            String str;
            String str2;
            Editable editable3;
            boolean equals$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (r.this.X9() && r.this.getActivity() != null) {
                r.this.Ba();
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar = r.this.mAddFriendVerifyMsgViewModel;
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = null;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                    gVar = null;
                }
                String L1 = gVar.L1(r.this.getActivity(), false);
                if (L1 == null) {
                    L1 = "";
                }
                EditText editText = r.this.mRequestInfoEt;
                if (editText != null) {
                    editable = editText.getText();
                } else {
                    editable = null;
                }
                trim = StringsKt__StringsKt.trim((CharSequence) String.valueOf(editable));
                String obj = trim.toString();
                if (obj != null && !Intrinsics.areEqual(obj, L1)) {
                    ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
                }
                r.this.Ca(obj, false);
                String string = r.this.getActivity().getString(R.string.axv);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026.enter_add_failed_reason)");
                if (Intrinsics.areEqual(string, obj)) {
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar2 = r.this.mAddFriendVerifyMsgViewModel;
                    if (gVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                        gVar2 = null;
                    }
                    if (!gVar2.M1(r.this.getActivity())) {
                        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar3 = r.this.mAddFriendVerifyMsgViewModel;
                        if (gVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                            gVar3 = null;
                        }
                        gVar3.N1(r.this.getActivity());
                    }
                }
                if (r.this.Q9() != null) {
                    ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
                    KplRoleInfo.WZRYUIinfo Q9 = r.this.Q9();
                    if (Q9 != null) {
                        str = Q9.verifyMsg;
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        KplRoleInfo.WZRYUIinfo Q92 = r.this.Q9();
                        if (Q92 != null) {
                            str2 = Q92.verifyMsg;
                        } else {
                            str2 = null;
                        }
                        EditText editText2 = r.this.mRequestInfoEt;
                        if (editText2 != null) {
                            editable3 = editText2.getText();
                        } else {
                            editable3 = null;
                        }
                        equals$default = StringsKt__StringsJVMKt.equals$default(str2, String.valueOf(editable3), false, 2, null);
                        if (!equals$default) {
                            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
                        }
                    }
                }
                r rVar = r.this;
                EditText editText3 = rVar.mRequestInfoEt;
                if (editText3 != null) {
                    editable2 = editText3.getText();
                } else {
                    editable2 = null;
                }
                trim2 = StringsKt__StringsKt.trim((CharSequence) String.valueOf(editable2));
                rVar.Da(trim2.toString(), null, "");
                r.this.Aa("NeedVerifyIdentitySuccess");
                r.this.Ea("NeedVerifyIdentitySuccess", 0, "1");
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar2 = r.this.mAddFriendSendViewModel;
                if (fVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                } else {
                    fVar = fVar2;
                }
                fVar.P1(r.this.getActivity(), r.this.getIntent(), r.this.L9(), r.this.friendSetting);
                return;
            }
            QLog.e("AddFriendSendButtonPart", 1, "isAdded false or getActivity null");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$f;", "Lcom/tencent/mobileqq/addfriend/strategy/IAddAcceptBlockStrategy$a;", "", "onSuccess", "<init>", "(Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public final class f implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (r.this.X9() && r.this.getActivity() != null) {
                r.this.Ba();
                r.this.Da("", null, "");
                r.this.Aa("RefuseOrAllowAllIdentitySuccess");
                if (Utils.G(r.this.D9())) {
                    ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X8008275", "0X8008275", 0, 0, "", "", "", "");
                }
                r.this.Ea("RefuseOrAllowAllIdentitySuccess", 0, "1");
                return;
            }
            QLog.e("AddFriendSendButtonPart", 1, "isAdded false or getActivity null");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$g", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$a;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class g extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ClearableEditText f187565f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ClearableEditText clearableEditText) {
            super();
            this.f187565f = clearableEditText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this, (Object) clearableEditText);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.r.a, android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                r.this.mStartAddFriendRequestTime = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(MobileQQ.sMobileQQ.peekAppRuntime(), 10005, r.this.getContext(), new d(this.f187565f));
                super.onClick(v3);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$h", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$a;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class h extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ StringBuffer f187567f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(StringBuffer stringBuffer) {
            super();
            this.f187567f = stringBuffer;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this, (Object) stringBuffer);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.r.a, android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                r.this.mStartAddFriendRequestTime = System.currentTimeMillis();
                IAddAcceptBlockStrategy iAddAcceptBlockStrategy = (IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Context context = r.this.getContext();
                r rVar = r.this;
                String stringBuffer = this.f187567f.toString();
                Intrinsics.checkNotNullExpressionValue(stringBuffer, "sb.toString()");
                iAddAcceptBlockStrategy.checkAccountIdentity(peekAppRuntime, 10005, context, new c(rVar, stringBuffer));
                super.onClick(v3);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$i", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$a;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class i extends a {
        static IPatchRedirector $redirector_;

        i() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.r.a, android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                r.this.mStartAddFriendRequestTime = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(MobileQQ.sMobileQQ.peekAppRuntime(), 10005, r.this.getContext(), new e());
                super.onClick(v3);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$j", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r$a;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/r;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class j extends a {
        static IPatchRedirector $redirector_;

        j() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.r.a, android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                r.this.mStartAddFriendRequestTime = System.currentTimeMillis();
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(MobileQQ.sMobileQQ.peekAppRuntime(), 10005, r.this.getContext(), new f());
                super.onClick(v3);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mStartAddFriendRequestTime = System.currentTimeMillis();
        this.mAnswerArray = new ArrayList<>();
        this.mQuestion = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa(String from) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(L9()), String.valueOf(M9()), "", "");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendSendButtonPart", 2, "reportClickEvent action: 0X80077B4 sourceId = " + L9() + " subSourceId = " + M9() + " from " + from);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ba() {
        if (getActivity() == null) {
            return;
        }
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).reportExtendFriend(L9(), D9(), getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea(String from, int result, String r26) {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendSendButtonPart", 2, "click onSuccess report for " + from + " webId:" + T9());
        }
        if (!TextUtils.isEmpty(T9())) {
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, result, r26, "", "", "");
        }
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
        if (getIntent().hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
            Z9((KplRoleInfo.WZRYUIinfo) getIntent().getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA));
        }
        this.friendSetting = getIntent().getIntExtra("friend_setting", 0);
    }

    private final void qa() {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendSendButtonPart", 2, "friend setting:" + this.friendSetting);
        }
        int i3 = this.friendSetting;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            va();
                            return;
                        }
                        return;
                    }
                    ua();
                    return;
                }
            } else {
                xa();
                return;
            }
        }
        za();
    }

    private final void ra(String from, int type) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X80077AF", "0X80077AF", type, 0, String.valueOf(L9()), String.valueOf(M9()), "", "");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendSendButtonPart", 2, "reportClickEvent action: 0X80077AF  sourceId = " + L9() + " subSourceId = " + M9() + " from = " + from + " type = " + type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
        Integer num;
        Button button = this.mCompleteBtn;
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c cVar = this.mAddFriendPermissionViewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendPermissionViewModel");
            cVar = null;
        }
        if (!cVar.L1()) {
            FriendPermissionsSwitch friendPermissionsSwitch = this.mFriendPermissionsSwitch;
            if (friendPermissionsSwitch != null) {
                num = Integer.valueOf(friendPermissionsSwitch.h());
            } else {
                num = null;
            }
            hashMap.put("kl_new_add_request", num);
        }
        VideoReport.setElementParams(button, hashMap);
        VideoReport.reportEvent("clck", button, null);
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddFriendClick(E9());
    }

    private final void ta() {
        QIphoneTitleBarFragment qIphoneTitleBarFragment;
        TextView textView;
        QIphoneTitleBarFragment qIphoneTitleBarFragment2;
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
        this.mReportText = (TextView) getPartRootView().findViewById(R.id.sd8);
    }

    private final void ua() {
        ArrayList<String> arrayList;
        String str;
        TextView textView;
        ClearableEditText clearableEditText;
        Object obj;
        Bundle extras = getIntent().getExtras();
        RelativeLayout.LayoutParams layoutParams = null;
        if (extras != null) {
            arrayList = extras.getStringArrayList("user_question");
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        LinearLayout linearLayout = this.mAnswerCorrectLl;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView2 = this.mReportText;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (arrayList.size() > 0) {
            str = arrayList.get(0);
        } else {
            str = "";
        }
        LinearLayout linearLayout2 = this.mAnswerCorrectLl;
        if (linearLayout2 != null) {
            textView = (TextView) linearLayout2.findViewById(R.id.textView1);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(String.format("%s:%s", getActivity().getString(R.string.g3d), str));
            this.mQuestion.add(textView);
            if (AppSetting.f99565y) {
                textView.setContentDescription(getActivity().getString(R.string.g3d) + ':' + str);
            }
        }
        LinearLayout linearLayout3 = this.mAnswerCorrectLl;
        if (linearLayout3 != null) {
            clearableEditText = (ClearableEditText) linearLayout3.findViewById(R.id.dmu);
        } else {
            clearableEditText = null;
        }
        if (clearableEditText != null) {
            clearableEditText.setSingleLine(true);
            this.mAnswerArray.add(clearableEditText);
            w wVar = new w(50, clearableEditText);
            this.mAnswerCorrectTW = wVar;
            clearableEditText.addTextChangedListener(wVar);
            if (AppSetting.f99565y) {
                clearableEditText.setContentDescription(getActivity().getString(R.string.f170050e0));
            }
        }
        Button button = this.mCompleteBtn;
        if (button != null) {
            button.setOnClickListener(new g(clearableEditText));
        }
        LinearLayout linearLayout4 = this.groupAndRemarkLayout;
        if (linearLayout4 != null) {
            obj = linearLayout4.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) obj;
        }
        LinearLayout linearLayout5 = this.mAnswerCorrectLl;
        if (linearLayout5 != null) {
            int id5 = linearLayout5.getId();
            if (layoutParams != null) {
                layoutParams.addRule(3, id5);
            }
        }
        LinearLayout linearLayout6 = this.groupAndRemarkLayout;
        if (linearLayout6 != null) {
            linearLayout6.setLayoutParams(layoutParams);
        }
        ra("needAnswer", 3);
    }

    private final void va() {
        ArrayList<String> arrayList;
        boolean z16;
        Object obj;
        String string;
        TextView textView;
        Bundle extras = getIntent().getExtras();
        RelativeLayout.LayoutParams layoutParams = null;
        if (extras != null) {
            arrayList = extras.getStringArrayList("user_question");
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        LinearLayout linearLayout = this.mAnswerCheckLl;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView2 = this.mReportText;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (arrayList.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        string = getActivity().getString(R.string.g3d);
                    } else {
                        string = getActivity().getString(R.string.g3h);
                    }
                } else {
                    string = getActivity().getString(R.string.g3g);
                }
            } else if (z16) {
                string = getActivity().getString(R.string.g3e);
            } else {
                string = getActivity().getString(R.string.g3f);
            }
            View inflate = getActivity().getWindow().getLayoutInflater().inflate(R.layout.h7x, (ViewGroup) this.mAnswerCheckLl, false);
            View inflate2 = getActivity().getWindow().getLayoutInflater().inflate(R.layout.h7w, (ViewGroup) this.mAnswerCheckLl, false);
            if (i3 > 0) {
                ViewGroup.LayoutParams layoutParams2 = inflate.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                inflate.setLayoutParams((LinearLayout.LayoutParams) layoutParams2);
            }
            LinearLayout linearLayout2 = this.mAnswerCheckLl;
            if (linearLayout2 != null) {
                linearLayout2.addView(inflate);
            }
            LinearLayout linearLayout3 = this.mAnswerCheckLl;
            if (linearLayout3 != null) {
                linearLayout3.addView(inflate2);
            }
            String str = arrayList.get(i3);
            View findViewById = inflate.findViewById(R.id.textView1);
            if (findViewById instanceof TextView) {
                textView = (TextView) findViewById;
            } else {
                textView = null;
            }
            if (textView != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s%s", Arrays.copyOf(new Object[]{string, str}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView.setText(format);
            }
            View findViewById2 = inflate2.findViewById(R.id.dmu);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.EditText");
            EditText editText = (EditText) findViewById2;
            editText.addTextChangedListener(new w(50, editText));
            this.mAnswerArray.add(editText);
            if (textView != null) {
                this.mQuestion.add(textView);
            }
            if (AppSetting.f99565y) {
                if (textView != null) {
                    textView.setContentDescription(string + str);
                }
                this.mAnswerArray.get(i3).setContentDescription(getActivity().getString(R.string.f170050e0));
            }
            i3++;
            stringBuffer.append(getActivity().getString(R.string.g3d) + i3 + ':' + str);
            stringBuffer.append("\n");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getActivity().getString(R.string.f170342mu));
            sb5.append(":${answer}");
            stringBuffer.append(sb5.toString());
            if (i3 != arrayList.size()) {
                stringBuffer.append("\n");
            }
        }
        Button button = this.mCompleteBtn;
        if (button != null) {
            button.setOnClickListener(new h(stringBuffer));
        }
        getPartRootView().findViewById(R.id.idg).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.q
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean wa5;
                wa5 = r.wa(r.this, view, motionEvent);
                return wa5;
            }
        });
        getActivity().getWindow().setSoftInputMode(4);
        LinearLayout linearLayout4 = this.groupAndRemarkLayout;
        if (linearLayout4 != null) {
            obj = linearLayout4.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) obj;
        }
        LinearLayout linearLayout5 = this.mAnswerCheckLl;
        if (linearLayout5 != null) {
            int id5 = linearLayout5.getId();
            if (layoutParams != null) {
                layoutParams.addRule(3, id5);
            }
        }
        LinearLayout linearLayout6 = this.groupAndRemarkLayout;
        if (linearLayout6 != null) {
            linearLayout6.setLayoutParams(layoutParams);
        }
        ra("needAnswerAndCheck", 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean wa(r this$0, View view, MotionEvent motionEvent) {
        IBinder iBinder;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        TextView textView = this$0.leftView;
        if (textView != null) {
            iBinder = textView.getWindowToken();
        } else {
            iBinder = null;
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 2);
        return false;
    }

    private final void xa() {
        Object obj;
        EditText editText;
        Editable editable;
        TextView textView = this.mRequestInfoTxt;
        if (textView != null) {
            textView.setVisibility(0);
        }
        EditText editText2 = this.mRequestInfoEt;
        if (editText2 != null) {
            editText2.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = null;
        if (AppSetting.f99565y && (editText = this.mRequestInfoEt) != null) {
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            editText.setContentDescription(String.valueOf(editable));
        }
        Button button = this.mCompleteBtn;
        if (button != null) {
            button.setOnClickListener(new i());
        }
        LinearLayout linearLayout = this.groupAndRemarkLayout;
        if (linearLayout != null) {
            obj = linearLayout.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) obj;
        }
        EditText editText3 = this.mRequestInfoEt;
        if (editText3 != null) {
            int id5 = editText3.getId();
            if (layoutParams != null) {
                layoutParams.addRule(3, id5);
            }
        }
        LinearLayout linearLayout2 = this.groupAndRemarkLayout;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams);
        }
        ra("needVerify", 1);
    }

    private final void za() {
        Object obj;
        RelativeLayout.LayoutParams layoutParams = null;
        if (L9() != 3078 && L9() != 3079) {
            Button button = this.mCompleteBtn;
            if (button != null) {
                button.setOnClickListener(new j());
            }
            ra("refuseOrAllowAll", this.friendSetting);
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f fVar = this.mAddFriendSendViewModel;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSendViewModel");
                fVar = null;
            }
            fVar.P1(getActivity(), getIntent(), L9(), this.friendSetting);
        }
        LinearLayout linearLayout = this.groupAndRemarkLayout;
        if (linearLayout != null) {
            obj = linearLayout.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) obj;
        }
        if (layoutParams != null) {
            layoutParams.addRule(3, R.id.f26490do);
        }
        LinearLayout linearLayout2 = this.groupAndRemarkLayout;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams);
        }
    }

    public final void Ca(@Nullable String msg2, boolean isTroop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, msg2, Boolean.valueOf(isTroop));
            return;
        }
        if (getActivity() != null && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            if (Q9() == null && L9() != 3016 && L9() != 3103) {
                if (!K9() && !J9() && !I9() && !H9()) {
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar = this.mAddFriendVerifyMsgViewModel;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                        gVar = null;
                    }
                    Activity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    gVar.O1(activity, msg2, isTroop);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendSendButtonPart", 2, "saveVerifyMsg return from wzry");
            }
        }
    }

    public final void Da(@Nullable String msg2, @Nullable byte[] sig, @Nullable String ticket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msg2, sig, ticket);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new AddFriendSendEvent(msg2, sig, ticket));
        }
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
        initData();
        ta();
        qa();
    }
}
