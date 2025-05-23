package com.tencent.mobileqq.aio.input.at.business;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.at.a;
import com.tencent.mobileqq.aio.input.at.common.e;
import com.tencent.mobileqq.aio.input.at.common.launch.a;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.robot.api.IRobotAtApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00eb\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007*\u0005rux{~\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0002\u0083\u0001B!\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010T\u001a\u00020Q\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002JZ\u0010\u0017\u001aF\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u0013j\b\u0012\u0004\u0012\u00020\t`\u0014\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00120\u0013j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0012`\u00140\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J(\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020(H\u0002J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0016H\u0002J \u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00162\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0016H\u0002J\b\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020\u0003H\u0002J$\u00106\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00162\b\u00103\u001a\u0004\u0018\u00010\u00152\b\u00105\u001a\u0004\u0018\u000104H\u0002J\b\u00107\u001a\u00020\u0003H\u0002J\n\u00109\u001a\u0004\u0018\u000108H\u0002J\b\u0010;\u001a\u00020:H\u0002J\u0016\u0010<\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010?\u001a\u00020\f2\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010@\u001a\u00020\f2\u0006\u0010>\u001a\u00020=H\u0002J\b\u0010A\u001a\u00020\fH\u0002J\b\u0010B\u001a\u00020\u0003H\u0016J\b\u0010C\u001a\u00020\u0003H\u0016J\u001e\u0010G\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0015J\u000e\u0010H\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u0015R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR$\u0010[\u001a\u0012\u0012\u0004\u0012\u00020X0\u0013j\b\u0012\u0004\u0012\u00020X`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR0\u0010a\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020]0\\j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020]`^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010dR\u0018\u0010j\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010VR\u0016\u0010l\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010dR\u0016\u0010m\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\u001dR\u0016\u0010o\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010nR\u0016\u0010p\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0016\u0010q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001dR\u0014\u0010t\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010sR\u0014\u0010w\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010vR\u0014\u0010z\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010yR\u0014\u0010}\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010|R\u0015\u0010\u0080\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u007f\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase;", "Lcom/tencent/mobileqq/aio/input/at/business/h;", "Lcom/tencent/mvi/base/route/g;", "", "n0", "f0", "J", "o0", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", VideoTemplateParser.ITEM_LIST, "l0", "", "b0", "newItemList", "L", UserInfo.SEX_FEMALE, "N", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "", "j0", "", "", "G", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "role", "Z", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "W", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$DispatchKeyBackEventInPreIme;", "U", "Lcom/tencent/mvi/base/route/k;", "T", "K", "Lcom/tencent/mobileqq/aio/input/at/common/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/text/Spanned;", "editable", "selectionStart", "e0", "lastAtIndex", "k0", "g0", BdhLogUtil.LogTag.Tag_Req, "errCode", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberListResult;", "result", "V", "h0", "Lcom/tencent/qqnt/kernel/api/s;", "P", "Landroid/content/Context;", "O", "c0", "Lcom/tencent/mobileqq/aio/input/at/business/o;", "itemData", "Y", "M", "a0", "d0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "uid", "uin", "nickname", "X", "H", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Landroid/view/View;", "e", "Landroid/view/View;", "mAnchor", "Landroid/widget/EditText;", "f", "Landroid/widget/EditText;", "mEditText", tl.h.F, "Ljava/lang/String;", "mSceneId", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberInfoListId;", "i", "Ljava/util/ArrayList;", "mIdList", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "mMemberInfoMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsPullNextList", "D", "mIsEndOfPage", "E", "Lcom/tencent/mobileqq/aio/input/at/common/f;", "mListDialogProvider", "mSearchKeywords", "mIsSearchMode", "mIsChangeSpan", "I", "mCurAtIndex", "mReadyToShow", "mWillDialogDismissAfterInsertAtSpan", "com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$d", "Lcom/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$d;", "mDialogListener", "com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$mMemberListListener$1", "Lcom/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$mMemberListListener$1;", "mMemberListListener", "com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$b", "Lcom/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$b;", "mAction1", "com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$c", "Lcom/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$c;", "mActionR1", "com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$e", "Lcom/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$e;", "mDrawerFrameScrollListener", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;Landroid/widget/EditText;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOAtSelectMemberUseCase implements h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean mIsPullNextList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean mIsEndOfPage;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.input.at.common.f mListDialogProvider;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String mSearchKeywords;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean mIsSearchMode;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsChangeSpan;

    /* renamed from: I, reason: from kotlin metadata */
    private int mCurAtIndex;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile boolean mReadyToShow;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mWillDialogDismissAfterInsertAtSpan;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final d mDialogListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final AIOAtSelectMemberUseCase$mMemberListListener$1 mMemberListListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final b mAction1;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final c mActionR1;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final e mDrawerFrameScrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText mEditText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mSceneId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<GroupMemberInfoListId> mIdList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, MemberInfo> mMemberInfoMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$a;", "", "", "CONFIG_KEY", "Ljava/lang/String;", "", "INVALID_VALUE", "I", "ONCE_PULL_NUM", "SCENE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOAtSelectMemberUseCase.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOAtSelectMemberUseCase.this.S(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOAtSelectMemberUseCase.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return AIOAtSelectMemberUseCase.this.T(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$d", "Lcom/tencent/mobileqq/aio/input/at/common/e;", "", "d", "onShow", "onDismiss", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "itemData", "a", "b", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.mobileqq.aio.input.at.common.e {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOAtSelectMemberUseCase.this);
            }
        }

        private final void d() {
            try {
                if (AIOAtSelectMemberUseCase.this.mEditText.getContext() == null) {
                    return;
                }
                Object systemService = AIOAtSelectMemberUseCase.this.mEditText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                if (!((InputMethodManager) systemService).showSoftInput(AIOAtSelectMemberUseCase.this.mEditText, 0)) {
                    QLog.w("AIOAtUseCase", 1, "showSoftInput fail");
                }
            } catch (Exception e16) {
                QLog.e("AIOAtUseCase", 1, "[showSoftInput] exception, " + e16, e16);
            }
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.e
        public void a(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) itemData);
                return;
            }
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            AIOAtSelectMemberUseCase.this.mIsChangeSpan = true;
            AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase = AIOAtSelectMemberUseCase.this;
            com.tencent.mobileqq.aio.input.at.common.f fVar = aIOAtSelectMemberUseCase.mListDialogProvider;
            if (fVar != null) {
                z16 = fVar.a();
            } else {
                z16 = false;
            }
            aIOAtSelectMemberUseCase.mWillDialogDismissAfterInsertAtSpan = true ^ z16;
            if (itemData instanceof m) {
                AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase2 = AIOAtSelectMemberUseCase.this;
                String c16 = itemData.c();
                String string = AIOAtSelectMemberUseCase.this.O().getString(R.string.f1624120c);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ng.list_item_at_all_name)");
                aIOAtSelectMemberUseCase2.X(c16, "0", string);
            } else if (itemData instanceof o) {
                o oVar = (o) itemData;
                if (!AIOAtSelectMemberUseCase.this.Y(oVar)) {
                    MemberInfo j3 = oVar.j();
                    CharSequence qQTextPurePlainText = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getQQTextPurePlainText(AtUtils.f189228a.d(j3), 16);
                    AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase3 = AIOAtSelectMemberUseCase.this;
                    String str = j3.uid;
                    Intrinsics.checkNotNullExpressionValue(str, "memberInfo.uid");
                    aIOAtSelectMemberUseCase3.X(str, String.valueOf(j3.uin), qQTextPurePlainText.toString());
                }
            }
            AIOAtSelectMemberUseCase.this.mWillDialogDismissAfterInsertAtSpan = false;
            AIOAtSelectMemberUseCase.this.mIsChangeSpan = false;
            d();
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.e
        public void b(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) itemData);
                return;
            }
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            AIOAtSelectMemberUseCase.this.mIsChangeSpan = true;
            AIOAtSelectMemberUseCase.this.H(itemData.c());
            AIOAtSelectMemberUseCase.this.mIsChangeSpan = false;
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.e
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            e.a.b(this);
            if (!AIOAtSelectMemberUseCase.this.mIsSearchMode.get()) {
                AIOAtSelectMemberUseCase.this.R();
            }
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.e
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            e.a.a(this);
            AIOAtSelectMemberUseCase.this.mIsEndOfPage.set(false);
            AIOAtSelectMemberUseCase.this.mIsPullNextList.set(false);
            AIOAtSelectMemberUseCase.this.mIsSearchMode.set(false);
            AIOAtSelectMemberUseCase.this.mReadyToShow = false;
            com.tencent.mobileqq.aio.input.at.common.f fVar = AIOAtSelectMemberUseCase.this.mListDialogProvider;
            if (fVar != null) {
                fVar.onDestroy();
            }
            AIOAtSelectMemberUseCase.this.mListDialogProvider = null;
            AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase = AIOAtSelectMemberUseCase.this;
            synchronized (aIOAtSelectMemberUseCase) {
                aIOAtSelectMemberUseCase.mIdList.clear();
                aIOAtSelectMemberUseCase.mMemberInfoMap.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.e
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                e.a.c(this);
                AIOAtSelectMemberUseCase.this.mContext.e().h(InputAtMsgIntent.OnShowDialog.f189188d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$e", "Lcom/tencent/aio/frame/api/d;", "", "scrollX", "oldScrollX", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements com.tencent.aio.frame.api.d {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOAtSelectMemberUseCase.this);
            }
        }

        @Override // com.tencent.aio.frame.api.d
        public void b(int scrollX, int oldScrollX) {
            com.tencent.mobileqq.aio.input.at.common.f fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(scrollX), Integer.valueOf(oldScrollX));
            } else if (oldScrollX == 0 && (fVar = AIOAtSelectMemberUseCase.this.mListDialogProvider) != null) {
                fVar.dismissDialog();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/at/business/AIOAtSelectMemberUseCase$f", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetailInfo", "", "onGroupDetailInfoChange", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class f implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f189223d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIOAtSelectMemberUseCase f189224e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<com.tencent.mobileqq.aio.input.at.common.list.data.b> f189225f;

        /* JADX WARN: Multi-variable type inference failed */
        f(s sVar, AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase, List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> list) {
            this.f189223d = sVar;
            this.f189224e = aIOAtSelectMemberUseCase;
            this.f189225f = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, sVar, aIOAtSelectMemberUseCase, list);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
            am.a(this, j3, str, groupBulletinListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAdd(long j3) {
            am.b(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
            am.c(this, groupAllInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
            am.d(this, j3, groupArkInviteStateInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
            am.e(this, j3, groupBulletin);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
            am.f(this, j3, remindGroupBulletinMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.g(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.h(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
            am.i(this, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupDetailInfoChange(@Nullable GroupDetailInfo groupDetailInfo) {
            MemberRole memberRole;
            List<com.tencent.mobileqq.aio.input.at.common.list.data.b> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupDetailInfo);
                return;
            }
            this.f189223d.x0(this);
            AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase = this.f189224e;
            if (groupDetailInfo != null) {
                memberRole = groupDetailInfo.cmdUinPrivilege;
            } else {
                memberRole = null;
            }
            if (aIOAtSelectMemberUseCase.Z(memberRole) && this.f189224e.c0(this.f189225f)) {
                ArrayList arrayList = new ArrayList();
                AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase2 = this.f189224e;
                List<com.tencent.mobileqq.aio.input.at.common.list.data.b> list2 = this.f189225f;
                if (aIOAtSelectMemberUseCase2.b0()) {
                    arrayList.add(new m("0"));
                }
                arrayList.addAll(list2);
                list = arrayList;
            } else {
                list = this.f189225f;
            }
            this.f189224e.L(list);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupEssenceListChange(long j3) {
            am.k(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
            am.l(this, groupExtListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
            am.m(this, firstGroupBulletinInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListInited(boolean z16) {
            am.n(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
            am.o(this, groupListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
            am.p(this, j3, groupMemberLevelInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
            am.q(this, z16, j3, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
            am.r(this, z16, j3, i3, i16, i17, i18);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
            am.s(this, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            am.t(this, z16, j3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
            am.u(this, z16, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
            am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
            am.w(this, j3, groupStatisticInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
            am.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
            am.y(this, j3, z16, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
            am.z(this, joinGroupNotifyMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
            am.A(this, j3, dataSource, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
            am.B(this, groupMemberListChangeInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
            am.C(this, str, str2, arrayList, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            am.D(this, j3, arrayList);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$mMemberListListener$1] */
    public AIOAtSelectMemberUseCase(@NotNull com.tencent.aio.api.runtime.a mContext, @NotNull View mAnchor, @NotNull EditText mEditText) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mAnchor, "mAnchor");
        Intrinsics.checkNotNullParameter(mEditText, "mEditText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, mAnchor, mEditText);
            return;
        }
        this.mContext = mContext;
        this.mAnchor = mAnchor;
        this.mEditText = mEditText;
        this.mSceneId = "";
        this.mIdList = new ArrayList<>();
        this.mMemberInfoMap = new HashMap<>();
        this.mIsPullNextList = new AtomicBoolean(false);
        this.mIsEndOfPage = new AtomicBoolean(false);
        this.mSearchKeywords = "";
        this.mIsSearchMode = new AtomicBoolean(false);
        this.mCurAtIndex = 1;
        this.mDialogListener = new d();
        this.mMemberListListener = new IKernelGroupListener() { // from class: com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$mMemberListListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOAtSelectMemberUseCase.this);
                }
            }

            private final void a(GroupMemberListChangeInfo info) {
                Lifecycle lifecycle = AIOAtSelectMemberUseCase.this.mContext.d().getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycleOwner.lifecycle");
                BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getIO(), null, new AIOAtSelectMemberUseCase$mMemberListListener$1$updateAtInteractionDataBusinessLogic$1(AIOAtSelectMemberUseCase.this, info, null), 2, null);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
                am.a(this, j3, str, groupBulletinListResult);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupAdd(long j3) {
                am.b(this, j3);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
                am.c(this, groupAllInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
                am.d(this, j3, groupArkInviteStateInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
                am.e(this, j3, groupBulletin);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
                am.f(this, j3, remindGroupBulletinMsg);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
                am.g(this, bulletinFeedsDownloadInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
                am.h(this, bulletinFeedsDownloadInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
                am.i(this, j3, arrayList);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
                am.j(this, groupDetailInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupEssenceListChange(long j3) {
                am.k(this, j3);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
                am.l(this, groupExtListUpdateType, arrayList);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
                am.m(this, firstGroupBulletinInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupListInited(boolean z16) {
                am.n(this, z16);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
                am.o(this, groupListUpdateType, arrayList);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
                am.p(this, j3, groupMemberLevelInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
                am.q(this, z16, j3, i3);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
                am.r(this, z16, j3, i3, i16, i17, i18);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
                am.s(this, z16, arrayList);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
                am.t(this, z16, j3, arrayList, arrayList2);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
                am.u(this, z16, j3, arrayList);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
                am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
                am.w(this, j3, groupStatisticInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
                am.x(this, arrayList);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
                am.y(this, j3, z16, z17);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
                am.z(this, joinGroupNotifyMsg);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
                am.A(this, j3, dataSource, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public void onMemberListChange(@Nullable GroupMemberListChangeInfo info) {
                String str;
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) info);
                    return;
                }
                if (info != null) {
                    str = AIOAtSelectMemberUseCase.this.mSceneId;
                    if (Intrinsics.areEqual(str, info.sceneId)) {
                        z16 = AIOAtSelectMemberUseCase.this.mReadyToShow;
                        if (z16) {
                            QLog.d("AIOAtUseCase", 1, "onMemberListChange size = " + info.ids.size());
                            AIOAtSelectMemberUseCase.this.mIsPullNextList.set(false);
                            AIOAtSelectMemberUseCase.this.mIsEndOfPage.set(info.hasNext ^ true);
                            a(info);
                        }
                    }
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
                am.C(this, str, str2, arrayList, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
            public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
                am.D(this, j3, arrayList);
            }
        };
        this.mAction1 = new b();
        this.mActionR1 = new c();
        this.mDrawerFrameScrollListener = new e();
    }

    private final void F(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        Pair<ArrayList<com.tencent.mobileqq.aio.input.at.common.list.data.b>, ArrayList<Pair<String, Integer>>> j06 = j0(N(itemList));
        ArrayList<com.tencent.mobileqq.aio.input.at.common.list.data.b> component1 = j06.component1();
        ArrayList<Pair<String, Integer>> component2 = j06.component2();
        Lifecycle lifecycle = this.mContext.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycleOwner.lifecycle");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new AIOAtSelectMemberUseCase$buildIndexAndSubmit$1(this, component1, component2, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        if (r5 != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, List<com.tencent.mobileqq.aio.input.at.common.list.data.b>> G(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        boolean z16;
        boolean z17;
        boolean z18;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (com.tencent.mobileqq.aio.input.at.common.list.data.b bVar : itemList) {
            String str = "\u2605";
            if (!(bVar instanceof m)) {
                if (bVar instanceof o) {
                    o oVar = (o) bVar;
                    if (!oVar.j().isSpecialConcerned) {
                        String pinyinFirst = ChnToSpell.d(AtUtils.f189228a.h(oVar.j()).toString(), 2);
                        if (pinyinFirst != null && pinyinFirst.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            char charAt = pinyinFirst.charAt(0);
                            if ('A' <= charAt && charAt < '[') {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                char charAt2 = pinyinFirst.charAt(0);
                                if ('a' <= charAt2 && charAt2 < '{') {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                            }
                            Intrinsics.checkNotNullExpressionValue(pinyinFirst, "pinyinFirst");
                            String substring = pinyinFirst.substring(0, 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            str = substring.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                        }
                    }
                }
                str = "#";
            }
            if (linkedHashMap.get(str) == null) {
                linkedHashMap.put(str, new ArrayList());
            }
            Object obj = linkedHashMap.get(str);
            Intrinsics.checkNotNull(obj);
            ((List) obj).add(bVar);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int I(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final void J() {
        s P;
        if (!TextUtils.isEmpty(this.mSceneId) && (P = P()) != null) {
            P.destroyMemberListScene(this.mSceneId);
        }
        s P2 = P();
        if (P2 != null) {
            P2.x0(this.mMemberListListener);
        }
        this.mSceneId = "";
    }

    private final boolean K() {
        com.tencent.mobileqq.aio.input.at.common.f fVar = this.mListDialogProvider;
        if (fVar != null) {
            boolean isShowing = fVar.isShowing();
            fVar.dismissDialog();
            return isShowing;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> newItemList) {
        if (newItemList.isEmpty()) {
            Lifecycle lifecycle = this.mContext.d().getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycleOwner.lifecycle");
            BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new AIOAtSelectMemberUseCase$dismissOrShowDialog$1(this, null), 3, null);
            return;
        }
        F(newItemList);
    }

    private final boolean M(final o itemData) {
        return AtUtils.f189228a.i(this.mEditText.getEditableText(), 0, this.mEditText.length(), new Function1<com.tencent.qqnt.aio.at.c, Boolean>() { // from class: com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$existAtMemberSpan$existAtSpan$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.aio.at.c it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.k().equals(String.valueOf(o.this.j().uin)));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<com.tencent.mobileqq.aio.input.at.common.list.data.b> N(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        final IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class);
        List<com.tencent.qqnt.aio.at.c> g16 = AtUtils.f189228a.g(this.mEditText.getEditableText(), 0, this.mEditText.length(), new Function1<com.tencent.qqnt.aio.at.c, Boolean>() { // from class: com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$filterRobotInListIfNeeded$robotAtSpanUinList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.aio.at.c atTroopMemberSpan) {
                Intrinsics.checkNotNullParameter(atTroopMemberSpan, "atTroopMemberSpan");
                return Boolean.valueOf(IRobotServiceApi.this.isRobotUin(atTroopMemberSpan.k()));
            }
        });
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = g16.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.qqnt.aio.at.c) it.next()).k());
        }
        if (arrayList.isEmpty()) {
            return itemList;
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() < ((IRobotAtApi) QRoute.api(IRobotAtApi.class)).getAtRobotLimit()) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : itemList) {
                    com.tencent.mobileqq.aio.input.at.common.list.data.b bVar = (com.tencent.mobileqq.aio.input.at.common.list.data.b) obj;
                    if ((bVar instanceof o) && arrayList.contains(String.valueOf(((o) bVar).j().uin))) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : itemList) {
                com.tencent.mobileqq.aio.input.at.common.list.data.b bVar2 = (com.tencent.mobileqq.aio.input.at.common.list.data.b) obj2;
                if ((bVar2 instanceof o) && iRobotServiceApi.isRobotUin(String.valueOf(((o) bVar2).j().uin))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    arrayList3.add(obj2);
                }
            }
            return arrayList3;
        }
        return itemList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context O() {
        Context context = this.mAnchor.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mAnchor.context");
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s P() {
        IKernelService iKernelService;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime != null && (iKernelService = (IKernelService) waitAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getGroupService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.input.at.common.f Q() {
        if (this.mListDialogProvider == null) {
            com.tencent.mobileqq.aio.input.at.common.launch.b bVar = new com.tencent.mobileqq.aio.input.at.common.launch.b();
            a.C7255a a16 = new a.C7255a().a(this.mAnchor);
            Context context = this.mAnchor.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mAnchor.context");
            a.C7255a e16 = a16.d(context).c(new a()).e(this.mDialogListener);
            AIOParam g16 = this.mContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            this.mListDialogProvider = bVar.a(e16.f(new com.tencent.mobileqq.aio.input.at.business.b(g16)).b());
        }
        com.tencent.mobileqq.aio.input.at.common.f fVar = this.mListDialogProvider;
        Intrinsics.checkNotNull(fVar);
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        Object lastOrNull;
        QLog.d("AIOAtUseCase", 1, "getNextMemberList begin");
        if (!this.mIsEndOfPage.get() && this.mIsPullNextList.compareAndSet(false, true)) {
            synchronized (this) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.mIdList);
                Unit unit = Unit.INSTANCE;
            }
            s P = P();
            if (P != null) {
                P.getNextMemberList(this.mSceneId, (GroupMemberInfoListId) lastOrNull, 40, new IGroupMemberListCallback() { // from class: com.tencent.mobileqq.aio.input.at.business.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                    public final void onResult(int i3, String str, GroupMemberListResult groupMemberListResult) {
                        AIOAtSelectMemberUseCase.this.V(i3, str, groupMemberListResult);
                    }
                });
                return;
            }
            return;
        }
        QLog.d("AIOAtUseCase", 1, "mIsPullNextList true return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(MsgIntent msgIntent) {
        if (msgIntent instanceof InputAtMsgIntent.OnTextChangedForAtDialog) {
            InputAtMsgIntent.OnTextChangedForAtDialog onTextChangedForAtDialog = (InputAtMsgIntent.OnTextChangedForAtDialog) msgIntent;
            Spanned b16 = onTextChangedForAtDialog.b();
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.text.Editable");
            e0((Editable) b16, onTextChangedForAtDialog.a());
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            W((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent);
        } else if (msgIntent instanceof InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) {
            U((InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) msgIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k T(MsgIntent msgIntent) {
        boolean z16;
        if (msgIntent instanceof InputAtMsgIntent.DismissAtDialog) {
            return new a.b(K());
        }
        if (msgIntent instanceof InputAtMsgIntent.GetAtDialogState) {
            boolean z17 = false;
            if (!this.mWillDialogDismissAfterInsertAtSpan) {
                com.tencent.mobileqq.aio.input.at.common.f fVar = this.mListDialogProvider;
                if (fVar != null) {
                    z16 = fVar.isShowing();
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            return new a.c(z17, this.mIsChangeSpan);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void U(InputEditTextMsgIntent.DispatchKeyBackEventInPreIme msgIntent) {
        if (K()) {
            msgIntent.b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(int errCode, String errMsg, GroupMemberListResult result) {
        Lifecycle lifecycle = this.mContext.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycleOwner.lifecycle");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getIO(), null, new AIOAtSelectMemberUseCase$handleOnGetNextMemberList$1(errCode, errMsg, this, result, null), 2, null);
    }

    private final void W(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent msgIntent) {
        com.tencent.mobileqq.aio.input.at.common.f fVar;
        if (msgIntent.b() && (fVar = this.mListDialogProvider) != null) {
            fVar.dismissDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y(o itemData) {
        if (!((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotUin(String.valueOf(itemData.j().uin))) {
            return false;
        }
        if (!M(itemData) && !a0()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z(MemberRole role) {
        if (role != MemberRole.OWNER && role != MemberRole.ADMIN) {
            return false;
        }
        return true;
    }

    private final boolean a0() {
        IRobotAtApi iRobotAtApi = (IRobotAtApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotAtApi.class);
        if (iRobotAtApi.getAtRobotSpanCount(this.mEditText.getEditableText()) >= iRobotAtApi.getAtRobotLimit()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b0() {
        if (this.mIsSearchMode.get() && !TextUtils.isEmpty(this.mSearchKeywords)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c0(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        boolean z16;
        if (!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_at_check_member_list_905_116340601", true)) {
            return true;
        }
        List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> list = itemList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    private final void e0(Spanned editable, int selectionStart) {
        int lastIndexOf$default;
        if (this.mIsChangeSpan) {
            return;
        }
        AtUtils atUtils = AtUtils.f189228a;
        int e16 = atUtils.e(editable, selectionStart);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) editable, '\n', selectionStart - 1, false, 4, (Object) null);
        if (lastIndexOf$default > e16) {
            e16 = -1;
        }
        if (e16 > atUtils.b(editable, selectionStart) && e16 >= 0) {
            k0(e16, editable, selectionStart);
            return;
        }
        com.tencent.mobileqq.aio.input.at.common.f fVar = this.mListDialogProvider;
        if (fVar != null) {
            fVar.dismissDialog();
        }
        this.mIsPullNextList.set(false);
    }

    private final void f0() {
        this.mContext.e().f(this, this.mAction1);
        this.mContext.e().l(this, this.mActionR1);
        com.tencent.aio.frame.api.e eVar = (com.tencent.aio.frame.api.e) this.mContext.b().b(com.tencent.aio.frame.api.e.class);
        if (eVar != null) {
            eVar.a(this.mDrawerFrameScrollListener);
        }
    }

    private final void g0() {
        boolean z16;
        if (this.mSearchKeywords.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mIsEndOfPage.set(false);
        synchronized (this) {
            this.mIdList.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void h0() {
        if (b0()) {
            QLog.d("AIOAtUseCase", 1, "searchMemberList error, mSceneId = " + this.mSceneId + " mSearchKeywords = " + this.mSearchKeywords);
            return;
        }
        s P = P();
        if (P != null) {
            P.D(new IKernelGroupListener() { // from class: com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$searchMemberList$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOAtSelectMemberUseCase.this);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
                    am.a(this, j3, str, groupBulletinListResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupAdd(long j3) {
                    am.b(this, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
                    am.c(this, groupAllInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
                    am.d(this, j3, groupArkInviteStateInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
                    am.e(this, j3, groupBulletin);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
                    am.f(this, j3, remindGroupBulletinMsg);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
                    am.g(this, bulletinFeedsDownloadInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
                    am.h(this, bulletinFeedsDownloadInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
                    am.i(this, j3, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
                    am.j(this, groupDetailInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupEssenceListChange(long j3) {
                    am.k(this, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
                    am.l(this, groupExtListUpdateType, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
                    am.m(this, firstGroupBulletinInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupListInited(boolean z16) {
                    am.n(this, z16);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
                    am.o(this, groupListUpdateType, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
                    am.p(this, j3, groupMemberLevelInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
                    am.q(this, z16, j3, i3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
                    am.r(this, z16, j3, i3, i16, i17, i18);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
                    am.s(this, z16, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
                    am.t(this, z16, j3, arrayList, arrayList2);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
                    am.u(this, z16, j3, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
                    am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
                    am.w(this, j3, groupStatisticInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
                    am.x(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
                    am.y(this, j3, z16, z17);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
                    am.z(this, joinGroupNotifyMsg);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
                    am.A(this, j3, dataSource, hashMap);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
                    am.B(this, groupMemberListChangeInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public void onSearchMemberChange(@Nullable String sceneId, @Nullable String keyword, @Nullable ArrayList<GroupMemberInfoListId> ids, @Nullable HashMap<String, MemberInfo> infos) {
                    s P2;
                    String str;
                    String str2;
                    Integer num;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        P2 = AIOAtSelectMemberUseCase.this.P();
                        if (P2 != null) {
                            P2.x0(this);
                        }
                        str = AIOAtSelectMemberUseCase.this.mSceneId;
                        if (Intrinsics.areEqual(str, sceneId) && AIOAtSelectMemberUseCase.this.mIsSearchMode.get()) {
                            str2 = AIOAtSelectMemberUseCase.this.mSearchKeywords;
                            if (Intrinsics.areEqual(str2, keyword)) {
                                if (ids != null) {
                                    num = Integer.valueOf(ids.size());
                                } else {
                                    num = null;
                                }
                                QLog.d("AIOAtUseCase", 1, "onSearchMemberChange begin size = " + num);
                                LifecycleOwner d16 = AIOAtSelectMemberUseCase.this.mContext.d();
                                Intrinsics.checkNotNullExpressionValue(d16, "mContext.lifecycleOwner");
                                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getIO(), null, new AIOAtSelectMemberUseCase$searchMemberList$1$1$onSearchMemberChange$1(ids, AIOAtSelectMemberUseCase.this, infos, null), 2, null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, this, sceneId, keyword, ids, infos);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
                    am.D(this, j3, arrayList);
                }
            });
        }
        s P2 = P();
        if (P2 != null) {
            P2.searchMember(this.mSceneId, this.mSearchKeywords, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.input.at.business.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AIOAtSelectMemberUseCase.i0(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(int i3, String str) {
        QLog.d("AIOAtUseCase", 1, "searchMemberList result = " + i3 + " errMsg = " + str);
    }

    private final Pair<ArrayList<com.tencent.mobileqq.aio.input.at.common.list.data.b>, ArrayList<Pair<String, Integer>>> j0(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        ArrayList arrayList = new ArrayList(itemList.size());
        Map<String, List<com.tencent.mobileqq.aio.input.at.common.list.data.b>> G = G(itemList);
        ArrayList arrayList2 = new ArrayList(G.size());
        List<com.tencent.mobileqq.aio.input.at.common.list.data.b> list = G.get("\u2605");
        int i3 = 0;
        if (list != null) {
            arrayList.addAll(list);
            arrayList2.add(new Pair("\u2605", 0));
            i3 = 0 + list.size();
        }
        for (char c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 < '['; c16 = (char) (c16 + 1)) {
            List<com.tencent.mobileqq.aio.input.at.common.list.data.b> list2 = G.get(String.valueOf(c16));
            if (list2 != null) {
                arrayList.addAll(list2);
                arrayList2.add(new Pair(String.valueOf(c16), Integer.valueOf(i3)));
                i3 += list2.size();
            }
        }
        List<com.tencent.mobileqq.aio.input.at.common.list.data.b> list3 = G.get("#");
        if (list3 != null) {
            arrayList.addAll(list3);
            arrayList2.add(new Pair("#", Integer.valueOf(i3)));
        }
        return new Pair<>(arrayList, arrayList2);
    }

    private final void k0(int lastAtIndex, Spanned editable, int selectionStart) {
        boolean z16;
        QLog.i("AIOAtUseCase", 2, "[startAtInteraction] editable:" + ((Object) editable));
        n0();
        this.mCurAtIndex = lastAtIndex;
        String obj = editable.subSequence(lastAtIndex + 1, selectionStart).toString();
        this.mSearchKeywords = obj;
        AtomicBoolean atomicBoolean = this.mIsSearchMode;
        if (obj.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        atomicBoolean.set(z16);
        g0();
        this.mReadyToShow = true;
        if (this.mIsSearchMode.get()) {
            h0();
        } else {
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        s P = P();
        if (P != null) {
            P.D(new f(P, this, itemList));
            P.getGroupDetailInfo(Long.parseLong(this.mContext.g().r().c().j()), GroupInfoSource.KAIO, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.input.at.business.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AIOAtSelectMemberUseCase.m0(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(int i3, String str) {
        QLog.d("AIOAtUseCase", 1, "getGroupDetailInfo result = " + i3 + " errMsg = " + str);
    }

    @UiThread
    private final void n0() {
        boolean z16;
        String str;
        if (this.mSceneId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        try {
            s P = P();
            if (P != null) {
                str = P.createMemberListScene(Long.parseLong(this.mContext.g().r().c().j()), "AIOAtUseCase");
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                this.mSceneId = str;
                s P2 = P();
                if (P2 != null) {
                    P2.D(this.mMemberListListener);
                }
            }
        } catch (Exception e16) {
            QLog.e("AIOAtUseCase", 1, e16.getMessage());
        }
    }

    private final void o0() {
        this.mContext.e().i(this, this.mAction1);
        this.mContext.e().e(this);
        com.tencent.aio.frame.api.e eVar = (com.tencent.aio.frame.api.e) this.mContext.b().b(com.tencent.aio.frame.api.e.class);
        if (eVar != null) {
            eVar.c(this.mDrawerFrameScrollListener);
        }
    }

    public final void H(@NotNull String uid) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        final Editable editableText = this.mEditText.getEditableText();
        com.tencent.qqnt.aio.at.c[] cVarArr = (com.tencent.qqnt.aio.at.c[]) editableText.getSpans(0, this.mEditText.getSelectionStart(), com.tencent.qqnt.aio.at.c.class);
        if (cVarArr != null) {
            if (cVarArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                final Function2<com.tencent.qqnt.aio.at.c, com.tencent.qqnt.aio.at.c, Integer> function2 = new Function2<com.tencent.qqnt.aio.at.c, com.tencent.qqnt.aio.at.c, Integer>(editableText) { // from class: com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$deleteAtSpan$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Editable $editable;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$editable = editableText;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) editableText);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @NotNull
                    public final Integer invoke(com.tencent.qqnt.aio.at.c cVar, com.tencent.qqnt.aio.at.c cVar2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(this.$editable.getSpanStart(cVar2) - this.$editable.getSpanStart(cVar)) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2);
                    }
                };
                Arrays.sort(cVarArr, new Comparator() { // from class: com.tencent.mobileqq.aio.input.at.business.f
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int I;
                        I = AIOAtSelectMemberUseCase.I(Function2.this, obj, obj2);
                        return I;
                    }
                });
                for (com.tencent.qqnt.aio.at.c cVar : cVarArr) {
                    if (Intrinsics.areEqual(cVar.h(), uid)) {
                        int spanStart = editableText.getSpanStart(cVar);
                        cVar.h();
                        editableText.delete(spanStart, cVar.F + spanStart);
                        return;
                    }
                }
            }
        }
    }

    public final void X(@NotNull String uid, @NotNull String uin, @NotNull String nickname) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, uin, nickname);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        SpannableString q16 = com.tencent.qqnt.aio.at.a.q(this.mAnchor.getContext(), uid, uin, nickname, nickname, this.mEditText, 0, false);
        if (q16 == null) {
            QLog.e("AIOAtUseCase", 1, "atSpan is null, uid=" + uid + " uin=" + uin + " nick=" + nickname);
            return;
        }
        if (this.mCurAtIndex != -1) {
            this.mEditText.getEditableText().replace(this.mCurAtIndex, this.mEditText.getSelectionStart(), q16);
            this.mCurAtIndex = -1;
        } else {
            this.mEditText.getEditableText().insert(this.mEditText.getSelectionStart(), q16);
        }
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            f0();
        }
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.at.InputAtMsgIntent.OnTextChangedForAtDialog");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.DispatchKeyBackEventInPreIme");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.at.InputAtMsgIntent.DismissAtDialog");
        hashSet.add("com.tencent.mobileqq.aio.input.at.InputAtMsgIntent.GetAtDialogState");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.input.at.business.h
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        o0();
        com.tencent.mobileqq.aio.input.at.common.f fVar = this.mListDialogProvider;
        if (fVar != null) {
            fVar.dismissDialog();
        }
        com.tencent.mobileqq.aio.input.at.common.f fVar2 = this.mListDialogProvider;
        if (fVar2 != null) {
            fVar2.onDestroy();
        }
        this.mListDialogProvider = null;
        J();
    }
}
