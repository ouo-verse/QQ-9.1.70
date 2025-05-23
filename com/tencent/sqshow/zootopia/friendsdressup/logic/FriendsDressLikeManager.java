package com.tencent.sqshow.zootopia.friendsdressup.logic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;
import zb3.FriendsDressUpData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000 ^2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b\\\u0010]J+\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\f\u0010\u0015\u001a\u00020\u0014*\u00020\u0003H\u0002J\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u000fH\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000fJ$\u0010\u001f\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rJ\u0014\u0010 \u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aJ\u0006\u0010!\u001a\u00020\u0007R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00102\u001a\n /*\u0004\u0018\u00010.0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001c\u00106\u001a\n /*\u0004\u0018\u000103038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\nR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\fR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010C\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\fR\u0014\u0010E\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bD\u0010\nR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bJ\u0010;R\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006_"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/logic/FriendsDressLikeManager;", "", "Lkotlin/Function1;", "Lcom/tencent/common/app/AppInterface;", "Lkotlin/ParameterName;", "name", "app", "", "invoke", "N", "I", "appInterface", "J", "", "msg", "", "iconType", "D", "G", UserInfo.SEX_FEMALE, "", "B", "Lzb3/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "position", "M", "", "avatarActionList", "", "vipMaxVoteNum", "vipFriendsMaxVotesNotice", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "Landroid/view/View;", "a", "Landroid/view/View;", "rlLike", "Lcom/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment;", "b", "Lcom/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment;", "fragment", "", "c", "Ljava/util/List;", "data", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "d", "Landroid/widget/TextView;", "tvLike", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivLike", "f", "curPosition", "g", h.F, "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mOpenSVipPay", "j", "mNeedSVipDialog", "k", IProfileProtocolConst.PARAM_TARGET_UIN, "l", "SUB_THREAD_MSG_REQ_FAVORITE", "Lcom/tencent/util/WeakReferenceHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/util/WeakReferenceHandler;", "mSubHandler", DomainData.DOMAIN_NAME, "CMD_REQ_FAVORITE", "Ljava/util/concurrent/atomic/AtomicInteger;", "o", "Ljava/util/concurrent/atomic/AtomicInteger;", "mCacheVoteNum", "Landroid/os/Handler$Callback;", "p", "Landroid/os/Handler$Callback;", "mSubCallback", "Lid3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lid3/d;", "dtReporter", "Lcom/tencent/mobileqq/app/SVIPObserver;", "r", "Lcom/tencent/mobileqq/app/SVIPObserver;", "mSVipObserver", "<init>", "(Landroid/view/View;Lcom/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment;)V", ReportConstant.COSTREPORT_PREFIX, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class FriendsDressLikeManager {

    /* renamed from: s, reason: collision with root package name */
    private static final a f370590s = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View rlLike;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FriendsDressUpFragment fragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<FriendsDressUpData> data;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView tvLike;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivLike;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long vipMaxVoteNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String vipFriendsMaxVotesNotice;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mOpenSVipPay;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mNeedSVipDialog;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private volatile long targetUin;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int SUB_THREAD_MSG_REQ_FAVORITE;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private WeakReferenceHandler mSubHandler;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final String CMD_REQ_FAVORITE;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger mCacheVoteNum;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Handler.Callback mSubCallback;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final id3.d dtReporter;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final SVIPObserver mSVipObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/logic/FriendsDressLikeManager$a;", "", "", "CARDPROFILE_REQFAORITE_DELAY", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public FriendsDressLikeManager(View rlLike, FriendsDressUpFragment fragment) {
        Intrinsics.checkNotNullParameter(rlLike, "rlLike");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.rlLike = rlLike;
        this.fragment = fragment;
        this.data = new ArrayList();
        this.tvLike = (TextView) rlLike.findViewById(R.id.qto);
        this.ivLike = (ImageView) rlLike.findViewById(R.id.f163438q43);
        this.curPosition = -1;
        this.vipFriendsMaxVotesNotice = "";
        this.mOpenSVipPay = new AtomicBoolean(false);
        this.mNeedSVipDialog = new AtomicBoolean(true);
        this.SUB_THREAD_MSG_REQ_FAVORITE = 1;
        this.CMD_REQ_FAVORITE = "VisitorSvc.ReqFavorite";
        this.mCacheVoteNum = new AtomicInteger(0);
        Handler.Callback callback = new Handler.Callback() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean C;
                C = FriendsDressLikeManager.C(FriendsDressLikeManager.this, message);
                return C;
            }
        };
        this.mSubCallback = callback;
        this.dtReporter = new id3.d(null, 1, null);
        this.mSubHandler = new WeakReferenceHandler(ThreadManagerV2.getQQCommonThreadLooper(), callback);
        rlLike.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendsDressLikeManager.e(FriendsDressLikeManager.this, view);
            }
        });
        this.mSVipObserver = new SVIPObserver() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager$mSVipObserver$1
            @Override // com.tencent.mobileqq.app.SVIPObserver
            public void onVipStatusChanged() {
                final FriendsDressLikeManager friendsDressLikeManager = FriendsDressLikeManager.this;
                friendsDressLikeManager.N(new Function1<AppInterface, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager$mSVipObserver$1$onVipStatusChanged$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppInterface appInterface) {
                        invoke2(appInterface);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppInterface it) {
                        boolean B;
                        AtomicBoolean atomicBoolean;
                        AtomicBoolean atomicBoolean2;
                        FriendsDressUpFragment friendsDressUpFragment;
                        AtomicBoolean atomicBoolean3;
                        Intrinsics.checkNotNullParameter(it, "it");
                        B = FriendsDressLikeManager.this.B(it);
                        if (B) {
                            if (QLog.isColorLevel()) {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                atomicBoolean3 = FriendsDressLikeManager.this.mOpenSVipPay;
                                String format = String.format("onVipStatusChanged mOpenSVipPay=%s", Arrays.copyOf(new Object[]{atomicBoolean3}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                                QLog.d("FriendsDressLikeManager", 2, format);
                            }
                            atomicBoolean = FriendsDressLikeManager.this.mNeedSVipDialog;
                            if (atomicBoolean.compareAndSet(true, false)) {
                                atomicBoolean2 = FriendsDressLikeManager.this.mOpenSVipPay;
                                if (atomicBoolean2.get()) {
                                    IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                                    friendsDressUpFragment = FriendsDressLikeManager.this.fragment;
                                    Context requireContext = friendsDressUpFragment.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                                    iZPlanApi.showOpenVipSuccessDialog(requireContext);
                                }
                            }
                            it.removeObserver(this);
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B(AppInterface appInterface) {
        return VasUtil.getSignedService(appInterface).getVipStatus().isSVip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(FriendsDressLikeManager this$0, Message message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.what != this$0.SUB_THREAD_MSG_REQ_FAVORITE) {
            return true;
        }
        this$0.G();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(String msg2, int iconType) {
        QQToast.makeText(BaseApplication.getContext(), iconType, msg2, 0).show();
    }

    private final void F() {
        WeakReferenceHandler weakReferenceHandler = this.mSubHandler;
        if (weakReferenceHandler != null) {
            Intrinsics.checkNotNull(weakReferenceHandler);
            if (weakReferenceHandler.hasMessages(this.SUB_THREAD_MSG_REQ_FAVORITE)) {
                WeakReferenceHandler weakReferenceHandler2 = this.mSubHandler;
                Intrinsics.checkNotNull(weakReferenceHandler2);
                weakReferenceHandler2.removeMessages(this.SUB_THREAD_MSG_REQ_FAVORITE);
                G();
            }
        }
    }

    private final void G() {
        N(new Function1<AppInterface, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager$sendLikeRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppInterface appInterface) {
                invoke2(appInterface);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppInterface app) {
                AtomicInteger atomicInteger;
                AtomicInteger atomicInteger2;
                String str;
                long j3;
                Intrinsics.checkNotNullParameter(app, "app");
                String selfUin = app.getCurrentAccountUin();
                atomicInteger = FriendsDressLikeManager.this.mCacheVoteNum;
                int i3 = atomicInteger.get();
                atomicInteger2 = FriendsDressLikeManager.this.mCacheVoteNum;
                atomicInteger2.set(0);
                if (QLog.isColorLevel()) {
                    QLog.d("FriendsDressLikeManager", 2, "reqFavorite cacheVoteNum = " + i3);
                }
                if (i3 > 0) {
                    str = FriendsDressLikeManager.this.CMD_REQ_FAVORITE;
                    ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", selfUin, str);
                    Bundle bundle = toServiceMsg.extraData;
                    Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
                    bundle.putLong("selfUin", Long.parseLong(selfUin));
                    Bundle bundle2 = toServiceMsg.extraData;
                    j3 = FriendsDressLikeManager.this.targetUin;
                    bundle2.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, j3);
                    toServiceMsg.extraData.putByteArray("vCookies", null);
                    toServiceMsg.extraData.putInt("favoriteSource", 70);
                    toServiceMsg.extraData.putInt(FloatCacheData.ICOUNT, i3);
                    toServiceMsg.extraData.putInt("from", 3);
                    app.sendToService(toServiceMsg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        N(new Function1<AppInterface, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager$showLimitTip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppInterface appInterface) {
                invoke2(appInterface);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppInterface it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!VasUtil.getSignedService(it).getVipStatus().isSVip()) {
                    FriendsDressLikeManager.this.J(it);
                    return;
                }
                FriendsDressLikeManager friendsDressLikeManager = FriendsDressLikeManager.this;
                str = friendsDressLikeManager.vipFriendsMaxVotesNotice;
                friendsDressLikeManager.D(str, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(FragmentActivity mActivity, AppInterface appInterface, View view) {
        String str;
        Intrinsics.checkNotNullParameter(mActivity, "$mActivity");
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        if (QLog.isColorLevel()) {
            QLog.d("FriendsDressLikeManager", 2, "ZanDoubleDialog: onLeftClick: ");
        }
        if (mActivity.getIntent().hasExtra("troopUin")) {
            str = "1";
        } else {
            str = "0";
        }
        VasWebviewUtil.reportCommercialDrainage(appInterface.getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", str, "");
        Intent intent = new Intent(mActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragmentStyle", 3);
        intent.putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
        intent.putExtra("isTransparentTitle", true);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        mActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(Function1<? super AppInterface, Unit> invoke) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            invoke.invoke(appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final FriendsDressLikeManager this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final FriendsDressUpData A = this$0.A(this$0.curPosition);
        if (A != null) {
            this$0.N(new Function1<AppInterface, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AppInterface appInterface) {
                    invoke2(appInterface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppInterface it) {
                    boolean B;
                    long j3;
                    boolean B2;
                    id3.d dVar;
                    View view2;
                    Map<String, Object> mutableMapOf;
                    int i3;
                    AtomicInteger atomicInteger;
                    WeakReferenceHandler weakReferenceHandler;
                    int i16;
                    int i17;
                    WeakReferenceHandler weakReferenceHandler2;
                    long j16;
                    FriendsDressUpFragment friendsDressUpFragment;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                        B = FriendsDressLikeManager.this.B(it);
                        j3 = FriendsDressLikeManager.this.vipMaxVoteNum;
                        com.tencent.sqshow.zootopia.friendsdressup.a.b("FriendsDressLikeManager", " isVip " + B + "  vipMaxVoteNum " + j3 + "  todayVailableVotedCount " + A.getTodayVailableVotedCount() + "  todayVotedCount " + A.getTodayVotedCount() + " ");
                        B2 = FriendsDressLikeManager.this.B(it);
                        if (B2) {
                            j16 = FriendsDressLikeManager.this.vipMaxVoteNum;
                            long todayVailableVotedCount = (j16 - A.getTodayVailableVotedCount()) - A.getTodayVotedCount();
                            if (todayVailableVotedCount > 0) {
                                A.i(todayVailableVotedCount);
                            }
                            if (A.getTodayVailableVotedCount() == 0) {
                                FriendsDressLikeManager.this.I();
                                return;
                            }
                        } else if (A.getTodayVailableVotedCount() == 0) {
                            FriendsDressLikeManager.this.I();
                            return;
                        }
                        dVar = FriendsDressLikeManager.this.dtReporter;
                        view2 = FriendsDressLikeManager.this.rlLike;
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", Long.valueOf(A.getUin())));
                        dVar.c("clck", view2, mutableMapOf);
                        FriendsDressUpData friendsDressUpData = A;
                        friendsDressUpData.k(friendsDressUpData.getTotalVoted() + 1);
                        FriendsDressUpData friendsDressUpData2 = A;
                        friendsDressUpData2.j(friendsDressUpData2.getTodayVotedCount() + 1);
                        A.i(r11.getTodayVailableVotedCount() - 1);
                        FriendsDressLikeManager friendsDressLikeManager = FriendsDressLikeManager.this;
                        i3 = friendsDressLikeManager.curPosition;
                        friendsDressLikeManager.M(i3);
                        atomicInteger = FriendsDressLikeManager.this.mCacheVoteNum;
                        atomicInteger.incrementAndGet();
                        FriendsDressLikeManager.this.targetUin = A.getUin();
                        weakReferenceHandler = FriendsDressLikeManager.this.mSubHandler;
                        Intrinsics.checkNotNull(weakReferenceHandler);
                        i16 = FriendsDressLikeManager.this.SUB_THREAD_MSG_REQ_FAVORITE;
                        if (weakReferenceHandler.hasMessages(i16)) {
                            return;
                        }
                        Message obtain = Message.obtain();
                        i17 = FriendsDressLikeManager.this.SUB_THREAD_MSG_REQ_FAVORITE;
                        obtain.what = i17;
                        weakReferenceHandler2 = FriendsDressLikeManager.this.mSubHandler;
                        Intrinsics.checkNotNull(weakReferenceHandler2);
                        weakReferenceHandler2.sendMessageDelayed(obtain, 2000L);
                        return;
                    }
                    FriendsDressLikeManager friendsDressLikeManager2 = FriendsDressLikeManager.this;
                    friendsDressUpFragment = friendsDressLikeManager2.fragment;
                    friendsDressLikeManager2.D(friendsDressUpFragment.getString(R.string.xhp), 1);
                }
            });
        }
    }

    public final void E() {
        N(new Function1<AppInterface, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager$onDestroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppInterface appInterface) {
                invoke2(appInterface);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppInterface it) {
                SVIPObserver sVIPObserver;
                Intrinsics.checkNotNullParameter(it, "it");
                sVIPObserver = FriendsDressLikeManager.this.mSVipObserver;
                it.removeObserver(sVIPObserver);
            }
        });
        F();
        this.dtReporter.c("imp_end", this.rlLike, new LinkedHashMap());
    }

    public final void H(List<FriendsDressUpData> avatarActionList, long vipMaxVoteNum, String vipFriendsMaxVotesNotice) {
        Intrinsics.checkNotNullParameter(avatarActionList, "avatarActionList");
        Intrinsics.checkNotNullParameter(vipFriendsMaxVotesNotice, "vipFriendsMaxVotesNotice");
        this.vipMaxVoteNum = vipMaxVoteNum;
        this.vipFriendsMaxVotesNotice = vipFriendsMaxVotesNotice;
        this.data.clear();
        this.data.addAll(avatarActionList);
        M(0);
        N(new Function1<AppInterface, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager$setNewData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppInterface appInterface) {
                invoke2(appInterface);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppInterface it) {
                SVIPObserver sVIPObserver;
                Intrinsics.checkNotNullParameter(it, "it");
                sVIPObserver = FriendsDressLikeManager.this.mSVipObserver;
                it.addObserver(sVIPObserver);
            }
        });
    }

    public final void M(int position) {
        boolean z16 = this.curPosition != position;
        this.curPosition = position;
        this.rlLike.setVisibility(0);
        FriendsDressUpData A = A(position);
        if (A != null) {
            this.tvLike.setText(String.valueOf(A.getTotalVoted()));
            try {
                this.ivLike.setImageDrawable(ie0.a.f().o(BaseApplication.getContext(), A.getTodayVotedCount() <= 0 ? R.drawable.qui_like : R.drawable.qui_like_filled, A.getTodayVotedCount() <= 0 ? R.color.qui_common_icon_primary : R.color.qui_common_brand_standard, 1001));
            } catch (Exception e16) {
                this.ivLike.setImageResource(A.getTodayVotedCount() <= 0 ? R.drawable.ilh : R.drawable.ili);
                QLog.d("FriendsDressLikeManager", 1, "updateLikeUI setDrawable error = " + e16);
            }
        }
        if (z16) {
            F();
        }
    }

    public final void z(List<FriendsDressUpData> avatarActionList) {
        Intrinsics.checkNotNullParameter(avatarActionList, "avatarActionList");
        this.data.addAll(avatarActionList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(FragmentActivity mActivity, AppInterface appInterface, FriendsDressLikeManager this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(mActivity, "$mActivity");
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("FriendsDressLikeManager", 2, "ZanDoubleDialog: onRightClick: ");
        }
        if (mActivity.getIntent().hasExtra("troopUin")) {
            str = "1";
        } else {
            str = "0";
        }
        VasWebviewUtil.reportCommercialDrainage(appInterface.getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", str, "");
        VasH5PayUtil.openH5Pay((Context) mActivity, "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
        this$0.mOpenSVipPay.set(true);
    }

    private final FriendsDressUpData A(int i3) {
        if (i3 + 1 > this.data.size() || i3 < 0) {
            return null;
        }
        return this.data.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(final AppInterface appInterface) {
        String str;
        String str2;
        final FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        QRouteApi api = QRoute.api(IZPlanFriendApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanFriendApi::class.java)");
        IZPlanFriendApi iZPlanFriendApi = (IZPlanFriendApi) api;
        if (iZPlanFriendApi.shouldShowDoubleZanPopWindow(appInterface)) {
            iZPlanFriendApi.showDoubleZanDialog(requireActivity, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendsDressLikeManager.K(FragmentActivity.this, appInterface, view);
                }
            }, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.logic.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendsDressLikeManager.L(FragmentActivity.this, appInterface, this, view);
                }
            });
            if (requireActivity.getIntent().hasExtra("troopUin")) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            VasWebviewUtil.reportCommercialDrainage(appInterface.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", str2, "");
            return;
        }
        if (requireActivity.getIntent().hasExtra("troopUin")) {
            str = "1";
        } else {
            str = "0";
        }
        VasWebviewUtil.reportCommercialDrainage(appInterface.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", str, "");
        D("\u975eSVIP\u7528\u6237\u6bcf\u5929\u53ea\u80fd\u70b910\u4e2a\u8d5e\u54e6\uff5e", 0);
    }
}
