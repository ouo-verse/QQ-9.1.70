package com.tencent.mobileqq.friend.alphabet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListAdapter;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.friend.alphabet.NTAlphabetFriendFragment;
import com.tencent.mobileqq.friend.util.GroupCacheHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.report.ProfilePerformanceHelper;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.util.QQToastUtil;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import od2.a;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_contact", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00a1\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0005\u00a2\u0001\u00a3\u0001+B\t\u00a2\u0006\u0006\b\u009f\u0001\u0010\u00a0\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J \u00100\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0006H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020%H\u0016J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020,H\u0016J\u0010\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020,H\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020,H\u0016J\u0018\u0010?\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020,H\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\fH\u0016J\b\u0010B\u001a\u00020\u0006H\u0016R\u0016\u0010E\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR$\u0010N\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010^\u001a\u0004\u0018\u00010W8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010f\u001a\u0004\u0018\u00010_8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010IR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u00060mR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010t\u001a\u00060qR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR \u0010{\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u000e0y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010zR \u0010}\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u000e0y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010zR\u0017\u0010\u0080\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010DR\u0018\u0010\u008a\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010DR!\u0010\u008f\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0091\u0001\u001a\u000b\u0012\u0004\u0012\u00020*\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u008e\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010DR\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009e\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u00a8\u0006\u00a4\u0001"}, d2 = {"Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment;", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsBaseFragment;", "Landroid/view/View$OnClickListener;", "Lod2/a;", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar$a;", "Landroid/os/Handler$Callback;", "", "ai", "hi", "fi", "gi", "Xh", "", "delay", "", "load", "ci", "Yh", "loadData", "", "obj", "Zh", "ei", "di", "Landroid/os/Message;", "msg", "handleMessage", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "doOnDestroy", "xh", "tabChange", "rh", "qh", "refresh", "resetData", "Landroid/view/View;", "getScrollableView", "Landroid/view/LayoutInflater;", "inflater", "uh", "", "c", "", "action", "", com.tencent.luggage.wxa.c8.c.G, "p1", "touching", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ph", "Ah", "v", NodeProps.ON_CLICK, "bindState", "Ug", "percentage", "T2", "flag", "L1", "beAdded", "count", "e7", "newBits", "B7", DKHippyEvent.EVENT_STOP, "N", "Z", "mRefreshCompleted", "P", "mRefreshRequested", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRootView", "Lcom/tencent/mobileqq/widget/PinnedDividerListView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/PinnedDividerListView;", "getMListView", "()Lcom/tencent/mobileqq/widget/PinnedDividerListView;", "setMListView", "(Lcom/tencent/mobileqq/widget/PinnedDividerListView;)V", "mListView", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "getMIndexView", "()Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "setMIndexView", "(Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;)V", "mIndexView", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;", "T", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;", "getMIndexTipsView", "()Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;", "setMIndexTipsView", "(Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;)V", "mIndexTipsView", "U", "mFooterView", "Ltc1/e;", "V", "Ltc1/e;", "mAdapterNT", "Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$c;", "W", "Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$c;", "mStatusIconListener", "Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$b;", "X", "Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$b;", "mFriendListObserver", "Lmqq/os/MqqHandler;", "Y", "Lmqq/os/MqqHandler;", "mHandler", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "mSlideUpMap", "a0", "mSlideDownMap", "b0", "I", "lastVisibleItemPosition", "Lzc1/a;", "c0", "Lzc1/a;", "mDrawPerformancePart", "d0", "mScrollPerformancePart", "e0", "mCategoryDataFirstCallback", "f0", "mIsLogOpen", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "g0", "Lhx3/b;", "mQueryGeneralDataCallback", "h0", "mAnyFriendDataCallback", "i0", "needTabRefresh", "Landroid/os/Vibrator;", "j0", "Landroid/os/Vibrator;", "mVibrator", "Ljava/lang/Runnable;", "k0", "Ljava/lang/Runnable;", "mVibratorRunnable", "l0", "Ljava/lang/String;", "selectedIndexStr", "<init>", "()V", "m0", "a", "b", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NTAlphabetFriendFragment extends ContactsBaseFragment implements View.OnClickListener, a, IndexBar.a, Handler.Callback {

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mRefreshRequested;

    /* renamed from: Q, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: R, reason: from kotlin metadata */
    private PinnedDividerListView mListView;

    /* renamed from: S, reason: from kotlin metadata */
    private IndexBar mIndexView;

    /* renamed from: T, reason: from kotlin metadata */
    private IndexBarTipsLayout mIndexTipsView;

    /* renamed from: U, reason: from kotlin metadata */
    private View mFooterView;

    /* renamed from: V, reason: from kotlin metadata */
    private tc1.e mAdapterNT;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int lastVisibleItemPosition;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private zc1.a mDrawPerformancePart;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private zc1.a mScrollPerformancePart;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private Vibrator mVibrator;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mRefreshCompleted = true;

    /* renamed from: W, reason: from kotlin metadata */
    private final c mStatusIconListener = new c();

    /* renamed from: X, reason: from kotlin metadata */
    private final b mFriendListObserver = new b();

    /* renamed from: Y, reason: from kotlin metadata */
    private final MqqHandler mHandler = new MqqHandler(Looper.getMainLooper(), this);

    /* renamed from: Z, reason: from kotlin metadata */
    private final HashMap<Integer, Boolean> mSlideUpMap = new HashMap<>();

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, Boolean> mSlideDownMap = new HashMap<>();

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mCategoryDataFirstCallback = true;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLogOpen = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> mQueryGeneralDataCallback = new f();

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private hx3.b<String> mAnyFriendDataCallback = new e();

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean needTabRefresh = true;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final Runnable mVibratorRunnable = new Runnable() { // from class: tc1.f
        @Override // java.lang.Runnable
        public final void run() {
            NTAlphabetFriendFragment.bi(NTAlphabetFriendFragment.this);
        }
    };

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private String selectedIndexStr = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$b;", "Lcom/tencent/mobileqq/app/ar;", "", "isSuccess", "", "", "data", "", "onSetSpecialCareSwitch_global", "(Z[Ljava/lang/Object;)V", "<init>", "(Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment;)V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public final class b extends ar {
        public b() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_global(boolean isSuccess, Object[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (QLog.isColorLevel()) {
                QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + isSuccess);
            }
            NTAlphabetFriendFragment nTAlphabetFriendFragment = NTAlphabetFriendFragment.this;
            if (nTAlphabetFriendFragment.H && nTAlphabetFriendFragment.mAdapterNT != null) {
                NTAlphabetFriendFragment.this.loadData();
            }
            if (NTAlphabetFriendFragment.this.isResumed() && isSuccess && NTAlphabetFriendFragment.this.H) {
                try {
                    Object obj = data[1];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    Object obj2 = data[2];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.BooleanArray");
                    boolean[] zArr = (boolean[]) obj2;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onSetSpecialCareSwitch_global uinArray= stateArray=");
                    String arrays = Arrays.toString((String[]) obj);
                    Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                    sb5.append(arrays);
                    sb5.append(Arrays.toString(zArr));
                    QLog.i("contacts.fragment.NTAlphabetFriendFragment", 1, sb5.toString());
                    if (!(zArr.length == 0)) {
                        if (zArr[0]) {
                            QQToastUtil.showQQToastInUiThread(2, HardCodeUtil.qqStr(R.string.jd9));
                        } else {
                            QQToastUtil.showQQToastInUiThread(2, HardCodeUtil.qqStr(R.string.jd_));
                        }
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("contacts.fragment.NTAlphabetFriendFragment", 1, "onSetSpecialCareSwitch_global fail!", e16);
                    return;
                }
            }
            QLog.e("contacts.fragment.NTAlphabetFriendFragment", 1, "onSetSpecialCareSwitch_global fail, isResume=" + NTAlphabetFriendFragment.this.isResumed() + ", isSuccess=" + isSuccess);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$c;", "Lcom/tencent/mobileqq/richstatus/e;", "", "actionId", "size", "Landroid/graphics/Bitmap;", "icon", "", "onGetIcon", "<init>", "(Lcom/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment;)V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public final class c implements com.tencent.mobileqq.richstatus.e {
        public c() {
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int actionId, int size, Bitmap icon) {
            boolean unused = NTAlphabetFriendFragment.this.mRefreshCompleted;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$e", "Lhx3/b;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e implements hx3.b<String> {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(NTAlphabetFriendFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            tc1.e eVar = this$0.mAdapterNT;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
        }

        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> responseData) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final NTAlphabetFriendFragment nTAlphabetFriendFragment = NTAlphabetFriendFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: tc1.g
                @Override // java.lang.Runnable
                public final void run() {
                    NTAlphabetFriendFragment.e.b(NTAlphabetFriendFragment.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$f", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class f implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar, NTAlphabetFriendFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (eVar.b() != null) {
                this$0.mRefreshCompleted = true;
                if (this$0.mRefreshRequested && this$0.mRefreshCompleted) {
                    this$0.mRefreshRequested = false;
                    if (((ContactsBaseFragment) this$0).C != null) {
                        ((ContactsBaseFragment) this$0).C.c(this$0.th(), true, null);
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("mQueryGeneralDataCallback responseData.data.size is ");
                ArrayList b16 = eVar.b();
                sb5.append(b16 != null ? Integer.valueOf(b16.size()) : null);
                QLog.i("contacts.fragment.NTAlphabetFriendFragment", 1, sb5.toString());
                tc1.e eVar2 = this$0.mAdapterNT;
                if (eVar2 != null) {
                    ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b17 = eVar.b();
                    if (b17 == null) {
                        b17 = new ArrayList<>();
                    }
                    eVar2.v(b17);
                    return;
                }
                return;
            }
            QLog.i("contacts.fragment.NTAlphabetFriendFragment", 1, "mQueryGeneralDataCallback responseData.data is null!");
        }

        @Override // hx3.b
        public void onQueryResult(final com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData) {
            if (responseData == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "mAdapterNT == null or responseData == null");
                }
                com.tencent.mobileqq.activity.contacts.report.d.f181714a.g(RelationListReqType.LETTER, 1);
            } else {
                if (responseData.a() == 0) {
                    if (NTAlphabetFriendFragment.this.mCategoryDataFirstCallback) {
                        NTAlphabetFriendFragment.this.mCategoryDataFirstCallback = false;
                        GroupCacheHelper.f211730a.b(responseData.b());
                    }
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final NTAlphabetFriendFragment nTAlphabetFriendFragment = NTAlphabetFriendFragment.this;
                    uIHandlerV2.post(new Runnable() { // from class: tc1.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            NTAlphabetFriendFragment.f.b(com.tencent.qqnt.ntrelation.friendsinfo.bean.e.this, nTAlphabetFriendFragment);
                        }
                    });
                    com.tencent.mobileqq.activity.contacts.report.d.f181714a.g(RelationListReqType.LETTER, 0);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "responseData.getCode() != 0");
                }
                com.tencent.mobileqq.activity.contacts.report.d.f181714a.g(RelationListReqType.LETTER, 1);
            }
        }
    }

    private final void Xh() {
        PinnedDividerListView pinnedDividerListView = this.mListView;
        if (pinnedDividerListView == null || pinnedDividerListView.getFooterViewsCount() > 0) {
            return;
        }
        if (this.mFooterView == null) {
            if (getActivity() == null) {
                QLog.e("contacts.fragment.NTAlphabetFriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
                return;
            }
            this.mFooterView = LayoutInflater.from(getActivity()).inflate(QUITokenResUtil.getResId(R.layout.f167782hb, R.layout.e3d), (ViewGroup) pinnedDividerListView, false);
        }
        pinnedDividerListView.addFooterView(this.mFooterView);
    }

    private final void Yh(boolean load) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "<<--doRefreshBuddyList, load=" + load + ", mIsTabSelected=" + this.H + ",needTabRefresh =" + this.needTabRefresh);
        }
        if (!this.H) {
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "<<--doRefreshBuddyList, return mIsTabSelected =" + this.H);
            }
            this.needTabRefresh = true;
            return;
        }
        tc1.e eVar = this.mAdapterNT;
        if (eVar != null) {
            if (load) {
                loadData();
            } else if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
        }
        zc1.a aVar = this.mDrawPerformancePart;
        if (aVar != null) {
            aVar.B9("ALPHABET_LIST_ANDROID");
        }
        zc1.a aVar2 = this.mDrawPerformancePart;
        if (aVar2 != null) {
            aVar2.x9(this.K, ProfilePerformanceHelper.keyFpsOnDraw);
        }
    }

    private final boolean Zh(Object obj) {
        if (obj instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onItemClick:");
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj;
                sb5.append(dVar.r());
                sb5.append(dVar.getUid());
                QLog.d("Hyim", 2, sb5.toString());
            }
            AllInOne allInOne = new AllInOne(((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj).x(), 1);
            allInOne.profileEntryType = 59;
            allInOne.chatEntrance = 2;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 52);
            ProfileUtils.openProfileCard(this.K, allInOne);
            return true;
        }
        if (!(obj instanceof String)) {
            return false;
        }
        AllInOne allInOne2 = new AllInOne(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid((String) obj), 1);
        allInOne2.profileEntryType = 59;
        allInOne2.chatEntrance = 2;
        allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
        allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 51);
        ProfileUtils.openProfileCard(this.K, allInOne2);
        return true;
    }

    private final void ai() {
        zc1.a aVar = new zc1.a();
        this.mDrawPerformancePart = aVar;
        aVar.z9("ALPHABET_LIST_ANDROID");
        zc1.a aVar2 = this.mDrawPerformancePart;
        if (aVar2 != null) {
            aVar2.startMonitor(this.K, ProfilePerformanceHelper.keyFpsOnDraw);
        }
        zc1.a aVar3 = new zc1.a();
        this.mScrollPerformancePart = aVar3;
        aVar3.z9("ALPHABET_LIST_ANDROID");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(NTAlphabetFriendFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.mVibrator == null) {
                FragmentActivity activity = this$0.getActivity();
                Object systemService = activity != null ? activity.getSystemService("vibrator") : null;
                this$0.mVibrator = systemService instanceof Vibrator ? (Vibrator) systemService : null;
            }
            Vibrator vibrator = this$0.mVibrator;
            if (vibrator != null) {
                vibrator.vibrate(20L);
            }
        } catch (Exception e16) {
            QLog.e("contacts.fragment.NTAlphabetFriendFragment", 2, "Vibrator exception.");
            e16.printStackTrace();
        }
    }

    private final void ci(long delay, boolean load) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "refreshBuddyList, delay=" + delay + ", load=" + load);
        }
        this.mHandler.removeMessages(4);
        if (load) {
            this.mHandler.removeMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION);
        } else if (this.mHandler.hasMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION)) {
            return;
        }
        if (delay == 0) {
            Yh(load);
        } else {
            this.mHandler.sendEmptyMessageDelayed(load ? 9527 : 4, delay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di() {
        if (com.tencent.mobileqq.app.friendlist.b.a()) {
            zc1.a aVar = this.mScrollPerformancePart;
            if (aVar != null) {
                aVar.B9("ALPHABET_LIST_ANDROID");
            }
            zc1.a aVar2 = this.mScrollPerformancePart;
            if (aVar2 != null) {
                aVar2.x9(this.K, ProfilePerformanceHelper.keyFpsOnScroll);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei() {
        zc1.a aVar;
        if (!com.tencent.mobileqq.app.friendlist.b.a() || (aVar = this.mScrollPerformancePart) == null) {
            return;
        }
        aVar.startMonitor(this.K, ProfilePerformanceHelper.keyFpsOnScroll);
    }

    private final void fi() {
        IndexBarTipsLayout indexBarTipsLayout;
        if (this.mIndexTipsView == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_alphabet_friend_index_view_token_refresh", false) || (indexBarTipsLayout = this.mIndexTipsView) == null) {
            return;
        }
        indexBarTipsLayout.b();
    }

    private final void gi() {
        QQAppInterface qQAppInterface;
        if (this.mIndexView == null || (qQAppInterface = this.E) == null) {
            return;
        }
        if (ThemeUtil.isNowThemeIsSimple(qQAppInterface, false, null)) {
            IndexBar indexBar = this.mIndexView;
            if (indexBar != null) {
                indexBar.setSelectPaintColor(ThemeUtil.isNowThemeIsNight(this.E, false, null) ? -1 : -16777216, Color.parseColor("#CCCCCC"));
                return;
            }
            return;
        }
        IndexBar indexBar2 = this.mIndexView;
        if (indexBar2 != null) {
            indexBar2.setSelectPaintColor(Color.parseColor("#0099FF"), Color.parseColor("#b0b3bf"));
        }
    }

    private final void hi() {
        Resources resources = getResources();
        IndexBar indexBar = this.mIndexView;
        if (indexBar == null || resources == null || indexBar == null) {
            return;
        }
        indexBar.setSelectPaintColor(resources.getColor(R.color.qui_common_brand_standard, null), resources.getColor(R.color.qui_common_text_secondary, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> bVar = this.mQueryGeneralDataCallback;
        if (bVar != null) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryCacheInfoV2(RelationListReqType.LETTER, true, "contacts.fragment.NTAlphabetFriendFragment", false, bVar);
        }
        hx3.b<String> bVar2 = this.mAnyFriendDataCallback;
        if (bVar2 != null) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).addChangeFriendUidsCallBack("contacts.fragment.NTAlphabetFriendFragment", bVar2);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void Ah() {
        this.E.removeObserver(this.mFriendListObserver);
        Manager manager = this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.richstatus.StatusManager");
        ((StatusManager) manager).b0(this.mStatusIconListener);
        IRuntimeService runtimeService = this.E.getRuntimeService(IPhoneContactService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(\n\u2026ssConstant.MAIN\n        )");
        ((IPhoneContactService) runtimeService).removeListener(this);
    }

    @Override // od2.a
    public void Ug(int bindState) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "onBindStateChanged bindState=" + bindState);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "doOnDestroy.");
        }
        this.mHandler.removeCallbacksAndMessages(null);
        Ah();
        tc1.e eVar = this.mAdapterNT;
        if (eVar != null) {
            eVar.destroy();
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).unregisterFriendCategoryInfoV2Callback(RelationListReqType.LETTER, "contacts.fragment.NTAlphabetFriendFragment", this.mQueryGeneralDataCallback);
        this.mAnyFriendDataCallback = null;
        zc1.a aVar = this.mDrawPerformancePart;
        if (aVar != null) {
            aVar.onPartDestroy(this.K);
        }
        this.mDrawPerformancePart = null;
        zc1.a aVar2 = this.mScrollPerformancePart;
        if (aVar2 != null) {
            aVar2.onPartDestroy(this.K);
        }
        this.mScrollPerformancePart = null;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.activity.contacts.base.h.a
    public View getScrollableView() {
        return this.mListView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 == 9527) {
                    ci(0L, true);
                }
            } else if (this.mRefreshCompleted) {
                ci(0L, false);
            }
        } else if (this.mRefreshCompleted) {
            ci(0L, false);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        v3.getId();
        if (Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, v3.getTag())) {
            return;
        }
        Object tag = v3.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag");
        Object obj = ((c.C7154c) tag).f181513m;
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "tag.item");
            Zh(obj);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ai();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        di();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void ph() {
        this.E.addObserver(this.mFriendListObserver);
        Manager manager = this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.richstatus.StatusManager");
        ((StatusManager) manager).C(this.mStatusIconListener);
        IRuntimeService runtimeService = this.E.getRuntimeService(IPhoneContactService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(\n\u2026ssConstant.MAIN\n        )");
        ((IPhoneContactService) runtimeService).addListener(this);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean tabChange) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "doOnPause.");
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "refresh");
        }
        if (this.mRefreshCompleted) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).requestAllCategoriesInfo("contacts.fragment.NTAlphabetFriendFragment");
        }
        this.mRefreshRequested = true;
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "updateBuddyList succeeded");
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "resetData");
        }
        IndexBar indexBar = this.mIndexView;
        if (indexBar != null && indexBar != null) {
            indexBar.setLetters(null);
        }
        tc1.e eVar = this.mAdapterNT;
        if (eVar != null) {
            if (eVar != null) {
                eVar.i();
            }
            tc1.e eVar2 = this.mAdapterNT;
            if (eVar2 != null) {
                eVar2.x();
            }
            tc1.e eVar3 = this.mAdapterNT;
            if (eVar3 != null) {
                eVar3.destroy();
            }
            if (this.mListView != null) {
                Context activity = getActivity();
                if (activity == null) {
                    activity = BaseApplication.context;
                }
                Context context = activity;
                Intrinsics.checkNotNullExpressionValue(context, "activity ?: BaseApplicationImpl.context");
                QQAppInterface mApp = this.E;
                Intrinsics.checkNotNullExpressionValue(mApp, "mApp");
                this.mAdapterNT = new tc1.e(context, mApp, this.mListView, this.mIndexView, this);
                Xh();
                tc1.e eVar4 = this.mAdapterNT;
                if (eVar4 != null) {
                    eVar4.u(this.mFooterView);
                }
                PinnedDividerListView pinnedDividerListView = this.mListView;
                if (pinnedDividerListView == null) {
                    return;
                }
                pinnedDividerListView.setAdapter((ListAdapter) this.mAdapterNT);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean tabChange) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "doOnResume. tabChange:" + tabChange + ",mListView=" + this.mListView + ", mAdapterNT=" + this.mAdapterNT + ", needTabRefresh=" + this.needTabRefresh);
        }
        if (this.mListView == null) {
            return;
        }
        if (QUITokenResUtil.useQUIToken()) {
            hi();
            fi();
        } else {
            gi();
        }
        if (this.mAdapterNT == null) {
            Context activity = getActivity();
            if (activity == null) {
                activity = BaseApplication.context;
            }
            Context context = activity;
            Intrinsics.checkNotNullExpressionValue(context, "activity ?: BaseApplicationImpl.context");
            QQAppInterface mApp = this.E;
            Intrinsics.checkNotNullExpressionValue(mApp, "mApp");
            this.mAdapterNT = new tc1.e(context, mApp, this.mListView, this.mIndexView, this);
            Xh();
            tc1.e eVar = this.mAdapterNT;
            if (eVar != null) {
                eVar.u(this.mFooterView);
            }
            PinnedDividerListView pinnedDividerListView = this.mListView;
            if (pinnedDividerListView != null) {
                pinnedDividerListView.setAdapter((ListAdapter) this.mAdapterNT);
            }
        }
        ci(300L, true);
        BusinessHandler businessHandler = this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
        ((FriendListHandler) businessHandler).getOnlineFriend(this.E.getCurrentAccountUin(), (byte) 1);
        if (!this.mHandler.hasMessages(5)) {
            this.mHandler.sendEmptyMessageDelayed(5, com.tencent.mobileqq.mutualmark.oldlogic.a.h() * 1000);
        }
        Manager manager = this.E.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        ((FriendsManager) manager).E(true);
        ReportController.o(null, "dc00898", "", "", "0X800A1F7", "0X800A1F7", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater inflater, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.NTAlphabetFriendFragment", 2, "getView ");
        }
        View view = this.mRootView;
        if (view == null) {
            View inflate = inflater.inflate(QUITokenResUtil.getResId(R.layout.f167791hm, R.layout.e3w), (ViewGroup) null, false);
            this.mRootView = inflate;
            View findViewById = inflate != null ? inflate.findViewById(R.id.f164304rm) : null;
            PinnedDividerListView pinnedDividerListView = findViewById instanceof PinnedDividerListView ? (PinnedDividerListView) findViewById : null;
            this.mListView = pinnedDividerListView;
            if (pinnedDividerListView != null) {
                pinnedDividerListView.mForContacts = true;
            }
            View view2 = this.mRootView;
            View findViewById2 = view2 != null ? view2.findViewById(R.id.djh) : null;
            this.mIndexView = findViewById2 instanceof IndexBar ? (IndexBar) findViewById2 : null;
            View view3 = this.mRootView;
            View findViewById3 = view3 != null ? view3.findViewById(R.id.dji) : null;
            this.mIndexTipsView = findViewById3 instanceof IndexBarTipsLayout ? (IndexBarTipsLayout) findViewById3 : null;
            IndexBar indexBar = this.mIndexView;
            if (indexBar != null) {
                indexBar.setOnIndexBarTouchListener(this);
            }
            QRouteApi api = QRoute.api(IFriendsTABService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(\n                IFr\u2026:class.java\n            )");
            IFriendsTABService iFriendsTABService = (IFriendsTABService) api;
            if (iFriendsTABService.isNtDataService()) {
                int cacheFriendCount = iFriendsTABService.getCacheFriendCount();
                int i3 = cacheFriendCount / 2;
                PinnedDividerListView pinnedDividerListView2 = this.mListView;
                if (pinnedDividerListView2 != null) {
                    pinnedDividerListView2.addOnScrollListener(new d(iFriendsTABService, cacheFriendCount, i3));
                }
            }
        } else {
            ViewParent parent = view != null ? view.getParent() : null;
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mRootView);
            }
        }
        return this.mRootView;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/friend/alphabet/NTAlphabetFriendFragment$d", "Lcom/tencent/widget/AbsListView$OnScrollListener;", "Lcom/tencent/widget/AbsListView;", "view", "", HippyTKDListViewAdapter.SCROLL_STATE, "", "onScrollStateChanged", "firstVisibleItem", "visibleItemCount", "totalItemCount", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements AbsListView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IFriendsTABService f211542e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f211543f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f211544h;

        d(IFriendsTABService iFriendsTABService, int i3, int i16) {
            this.f211542e = iFriendsTABService;
            this.f211543f = i3;
            this.f211544h = i16;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            int coerceAtLeast;
            if (this.f211542e.isNtDataService() && NTAlphabetFriendFragment.this.mAdapterNT != null) {
                tc1.e eVar = NTAlphabetFriendFragment.this.mAdapterNT;
                ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList = new ArrayList<>(eVar != null ? eVar.n() : null);
                if (arrayList.size() == 0) {
                    return;
                }
                if (NTAlphabetFriendFragment.this.mIsLogOpen) {
                    QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, " firstVisibleItem = " + firstVisibleItem + " visibleItemCount = " + visibleItemCount + "totalItemCount :" + totalItemCount);
                }
                int i3 = this.f211543f;
                int i16 = firstVisibleItem / i3;
                int i17 = i3 / 4;
                int i18 = (i16 + 1) * this.f211544h;
                if (firstVisibleItem > NTAlphabetFriendFragment.this.lastVisibleItemPosition) {
                    if (NTAlphabetFriendFragment.this.mIsLogOpen) {
                        QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "\u5411\u4e0a\u6ed1\u52a8");
                    }
                    if (firstVisibleItem >= i18) {
                        if (NTAlphabetFriendFragment.this.mSlideUpMap.containsKey(Integer.valueOf(i16))) {
                            if (NTAlphabetFriendFragment.this.mIsLogOpen) {
                                QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "sectionIndex = " + i16 + "\u5df2\u7ecf\u8fdb\u884c\u9884\u52a0\u8f7d");
                                return;
                            }
                            return;
                        }
                        NTAlphabetFriendFragment.this.mSlideUpMap.clear();
                        NTAlphabetFriendFragment.this.mSlideUpMap.put(Integer.valueOf(i16), Boolean.TRUE);
                        if (NTAlphabetFriendFragment.this.mIsLogOpen) {
                            QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "\u5411\u4e0a\u6ed1\u52a8\uff0c\u5230\u8fbe\u4e34\u754c\u503c firstVisibleItem = " + firstVisibleItem + " loadSectionIndex = " + i18);
                        }
                        GroupCacheHelper.f211730a.c(arrayList, firstVisibleItem - i17, Math.min((this.f211543f - i17) + firstVisibleItem, totalItemCount));
                    }
                }
                if (firstVisibleItem < NTAlphabetFriendFragment.this.lastVisibleItemPosition) {
                    if (NTAlphabetFriendFragment.this.mIsLogOpen) {
                        QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "\u5411\u4e0b\u6ed1\u52a8");
                    }
                    if (firstVisibleItem <= i18) {
                        if (NTAlphabetFriendFragment.this.mSlideDownMap.containsKey(Integer.valueOf(i16))) {
                            if (NTAlphabetFriendFragment.this.mIsLogOpen) {
                                QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "sectionIndex = " + i16 + "\u5df2\u7ecf\u8fdb\u884c\u9884\u52a0\u8f7d");
                                return;
                            }
                            return;
                        }
                        NTAlphabetFriendFragment.this.mSlideDownMap.clear();
                        NTAlphabetFriendFragment.this.mSlideDownMap.put(Integer.valueOf(i16), Boolean.TRUE);
                        if (NTAlphabetFriendFragment.this.mIsLogOpen) {
                            QLog.i("contacts.fragment.NTAlphabetFriendFragment", 2, "\u5411\u4e0b\u6ed1\u52a8\uff0c\u5230\u8fbe\u4e34\u754c\u503c firstVisibleItem = " + firstVisibleItem + " loadSectionIndex = " + i18);
                        }
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, firstVisibleItem - i17);
                        GroupCacheHelper.f211730a.c(arrayList, coerceAtLeast, (this.f211543f - i17) + firstVisibleItem);
                    }
                }
                if (firstVisibleItem == NTAlphabetFriendFragment.this.lastVisibleItemPosition) {
                    return;
                }
                NTAlphabetFriendFragment.this.lastVisibleItemPosition = firstVisibleItem;
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 0) {
                NTAlphabetFriendFragment.this.di();
            } else {
                NTAlphabetFriendFragment.this.ei();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void m(boolean touching) {
        if (!touching) {
            this.selectedIndexStr = "";
        }
        IndexBarTipsLayout indexBarTipsLayout = this.mIndexTipsView;
        if (indexBarTipsLayout == null || indexBarTipsLayout == null) {
            return;
        }
        indexBarTipsLayout.setVisibility(touching ? 0 : 4);
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void p1(String c16, int action, float pos) {
        PinnedDividerListView pinnedDividerListView;
        Intrinsics.checkNotNullParameter(c16, "c");
        ContactsBaseFragment.c cVar = this.C;
        if (cVar != null && action == 0) {
            cVar.b();
        }
        ReportController.o(null, "dc00898", "", "", "0X800A1F8", "0X800A1F8", 0, 0, "", "", "", "");
        IndexBarTipsLayout indexBarTipsLayout = this.mIndexTipsView;
        if (indexBarTipsLayout != null && indexBarTipsLayout != null) {
            indexBarTipsLayout.setText(c16, pos);
        }
        if (Intrinsics.areEqual(this.selectedIndexStr, c16)) {
            return;
        }
        this.selectedIndexStr = c16;
        if (Intrinsics.areEqual("\u2605", c16)) {
            PinnedDividerListView pinnedDividerListView2 = this.mListView;
            if (pinnedDividerListView2 != null) {
                pinnedDividerListView2.setSelection(0);
            }
        } else {
            tc1.e eVar = this.mAdapterNT;
            int m3 = eVar != null ? eVar.m(c16) : -1;
            if (m3 != -1 && (pinnedDividerListView = this.mListView) != null) {
                pinnedDividerListView.setSelection(m3 + (pinnedDividerListView != null ? pinnedDividerListView.getHeaderViewsCount() : 0));
            }
        }
        Runnable runnable = this.mVibratorRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            ThreadManagerV2.excute(this.mVibratorRunnable, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void xh() {
    }

    @Override // od2.a
    public void e7(boolean beAdded, int count) {
    }

    @Override // od2.a
    public void B7(long newBits) {
    }

    @Override // od2.a
    public void L1(int flag) {
    }

    @Override // od2.a
    public void T2(int percentage) {
    }
}
