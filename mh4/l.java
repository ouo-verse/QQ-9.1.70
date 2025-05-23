package mh4;

import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\b*\u0002;?\u0018\u0000 E2\u00020\u0001:\u0001 B)\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u0012\b\u0010.\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\bC\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lmh4/l;", "", "", "r", BdhLogUtil.LogTag.Tag_Conn, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "guildId", "", "channelIds", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "result", "y", "Lgh4/c;", "joinListener", "w", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "D", "E", "", "errorCode", "errorMsg", "t", "Lrr1/i;", "data", "p", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lgh4/e;", "a", "Lgh4/e;", "mHall", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "mRootView", "Lcom/tencent/mobileqq/app/QBaseActivity;", "c", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "d", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "mHallListener", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "e", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "mLaunchParam", "Lkh4/b;", "f", "Lkh4/b;", "expandHallGMManager", "Lmh4/h;", "g", "Lmh4/h;", "mGuildExpandHelper", "mh4/l$e", tl.h.F, "Lmh4/l$e;", "mAbsGestureListener", "mh4/l$b", "i", "Lmh4/l$b;", "gpServiceObserver", "<init>", "(Lgh4/e;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/timi/game/api/cb/ExpandHallListener;)V", "j", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class l {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    private static boolean f416821k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.e mHall;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mRootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity qBaseActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ExpandHallListener mHallListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExpandHallLaunchParam mLaunchParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private kh4.b expandHallGMManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private h mGuildExpandHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e mAbsGestureListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gpServiceObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lmh4/l$a;", "", "", "isGMWhiteUser", "Z", "()Z", "a", "(Z)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mh4.l$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z16) {
            l.f416821k = z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\"\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0014\u00a8\u0006\n"}, d2 = {"mh4/l$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "guildId", "", "channelIds", "onPushChannelDestroy", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            boolean z16;
            com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onChannelInfoUpdated channelUin:" + channelUin + ", param=" + l.this.mLaunchParam.C);
            if (channelUin != null && channelUin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && Intrinsics.areEqual(channelUin, l.this.mLaunchParam.C)) {
                l.this.mHall.Zg(channelUin);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@Nullable String guildId, @Nullable List<String> channelIds) {
            boolean z16;
            super.onPushChannelDestroy(guildId, channelIds);
            com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onPushChannelDestroy guildId:" + guildId + ", channelIds=" + channelIds + ", channelUin=" + l.this.mLaunchParam.C);
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && Intrinsics.areEqual(guildId, String.valueOf(l.this.mLaunchParam.f376304h)) && channelIds != null && channelIds.contains(l.this.mLaunchParam.C)) {
                l.this.z(guildId, channelIds);
                com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "auto finish by ChannelDestroy");
                Object obj = l.this.mHall;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
                ((TimiGameBaseFragment) obj).qh(4);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"mh4/l$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomInfo result) {
            gh4.d mReporterHelper;
            ExpandHallListener expandHallListener = l.this.mHallListener;
            if (expandHallListener != null) {
                expandHallListener.a(l.this.mLaunchParam.F, l.this.mLaunchParam);
            }
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null && (mReporterHelper = I0.getMReporterHelper()) != null) {
                mReporterHelper.U(l.this.mLaunchParam.F);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            gh4.d mReporterHelper;
            ExpandHallListener expandHallListener = l.this.mHallListener;
            if (expandHallListener != null) {
                expandHallListener.d(l.this.mLaunchParam.F, l.this.mLaunchParam, errorCode, errorMessage);
            }
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null && (mReporterHelper = I0.getMReporterHelper()) != null) {
                mReporterHelper.U(l.this.mLaunchParam.F);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"mh4/l$d", "Lgh4/c;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "Lhh4/a;", "info", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements gh4.c<YoloRoomOuterClass$YoloRoomInfo> {
        d() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomInfo result) {
            com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "joinRoom onSuccess result = " + result);
            Object obj = l.this.mHall;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
            ((TimiGameBaseFragment) obj).hideLoadingView();
            if (result == null) {
                l.this.t(0, "");
            } else {
                l.this.y(result);
            }
        }

        @Override // gh4.c
        public void b(@Nullable hh4.a info) {
            boolean z16;
            Object obj = l.this.mHall;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
            if (!((TimiGameBaseFragment) obj).isDetached()) {
                Companion companion = l.INSTANCE;
                if (info != null) {
                    z16 = info.c();
                } else {
                    z16 = false;
                }
                companion.a(z16);
                l.this.expandHallGMManager.f(l.this.mRootView.findViewById(R.id.vqk), l.this.mLaunchParam, info);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "joinRoom onError errorCode = " + errorCode + " errMessage = " + errorMessage);
            Object obj = l.this.mHall;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
            ((TimiGameBaseFragment) obj).hideLoadingView();
            l.this.t(errorCode, errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"mh4/l$e", "Lrr1/a;", "Landroid/view/MotionEvent;", "event", "", "b", "Lrr1/i;", "notifyData", "", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e extends rr1.a {
        e() {
        }

        @Override // rr1.a
        public boolean b(@Nullable MotionEvent event) {
            if (event == null) {
                return false;
            }
            return l.this.mHall.Ke(event);
        }

        @Override // rr1.a
        public void c(@Nullable rr1.i notifyData) {
            int i3;
            if (notifyData != null) {
                i3 = notifyData.e();
            } else {
                i3 = -2;
            }
            com.tencent.timi.game.utils.l.i("AbsGestureListener", String.valueOf(i3));
            if (notifyData != null) {
                l lVar = l.this;
                lVar.p(notifyData);
                lVar.o(notifyData);
                lVar.mGuildExpandHelper.l(notifyData);
            }
            l.this.mHall.n7(notifyData);
        }
    }

    public l(@NotNull gh4.e mHall, @NotNull ViewGroup mRootView, @NotNull QBaseActivity qBaseActivity, @Nullable ExpandHallListener expandHallListener) {
        Intrinsics.checkNotNullParameter(mHall, "mHall");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        this.mHall = mHall;
        this.mRootView = mRootView;
        this.qBaseActivity = qBaseActivity;
        this.mHallListener = expandHallListener;
        this.mLaunchParam = mHall.O();
        this.expandHallGMManager = new kh4.b();
        this.mGuildExpandHelper = new h(mHall);
        this.mAbsGestureListener = new e();
        this.gpServiceObserver = new b();
    }

    private final void D() {
        ((IGPSService) this.qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).addObserver(this.gpServiceObserver);
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).addGestureListener(this.mAbsGestureListener);
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "registerGuildObserver finish");
    }

    private final void E() {
        ((IGPSService) this.qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).deleteObserver(this.gpServiceObserver);
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).removeGestureListener(this.mAbsGestureListener);
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "unRegisterGuildObserver finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(rr1.i data) {
        if (th4.l.a(data)) {
            boolean t26 = this.mHall.t2();
            WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf mHallInfo = this.mHall.getMHallInfo();
            com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "handleAutoExitTask Total collapse. data.curMoveState = " + data.f() + ", data.curMoveProgress=" + data.e() + " micSwitch=" + t26 + ", mHallInfo:" + mHallInfo);
            if (mHallInfo != null && !t26) {
                this.mGuildExpandHelper.c();
            } else {
                this.mGuildExpandHelper.e(this.qBaseActivity);
                this.mGuildExpandHelper.n();
            }
            this.mGuildExpandHelper.m();
            return;
        }
        if (th4.l.b(data)) {
            this.mGuildExpandHelper.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(rr1.i data) {
        if (this.mGuildExpandHelper.i() && th4.l.b(data)) {
            com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "data.curMoveState = " + data.f() + ", data.curMoveProgress=" + data.e());
            this.mGuildExpandHelper.o();
            com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "mDelayJoinRoomTask task handled");
        }
    }

    private final void q() {
        gh4.d mReporterHelper;
        if (this.mLaunchParam.G) {
            com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "handleLaunchParamOnJoinSucceed autoShowTeamList");
            this.mHall.Kc();
        }
        int a16 = gh4.b.a(this.mLaunchParam);
        long j3 = this.mLaunchParam.F;
        if (j3 != 0) {
            com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "handleLaunchParamOnJoinSucceed auto join team(" + j3 + ")");
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null && (mReporterHelper = I0.getMReporterHelper()) != null) {
                ExpandHallLaunchParam expandHallLaunchParam = this.mLaunchParam;
                long j16 = expandHallLaunchParam.F;
                String str = expandHallLaunchParam.D;
                Intrinsics.checkNotNullExpressionValue(str, "mLaunchParam.fromScene");
                mReporterHelper.a0(j16, str);
            }
            int J = ((ag4.h) mm4.b.b(ag4.h.class)).J(this.mLaunchParam.f376303f);
            if (J == 0) {
                J = 1;
            }
            com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
            dVar.f379324a = this.mLaunchParam.F;
            dVar.f379325b = a16;
            dVar.f379326c = 1;
            dVar.f379328e = J;
            dVar.f379329f = this.mHall.getMReporterHelper().i();
            dVar.f379327d = false;
            dVar.f379330g = this.mHall.getMRoomIdFromServer();
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar = new com.tencent.timi.game.room.impl.util.c();
            cVar.f379322a = 0;
            cVar.f379323b = new ArrayList();
            ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, this.qBaseActivity, dVar, cVar, new c());
        }
    }

    private final void s(gh4.c<YoloRoomOuterClass$YoloRoomInfo> joinListener) {
        YoloRoomOuterClass$YoloRoomInfo roomInfo;
        long mHallState = this.mHall.getMHallState();
        if (mHallState != 3 && mHallState != 4) {
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.mHall.getMReporterHelper().getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String().H);
            if (K0 != null && (roomInfo = K0.getRoomInfo()) != null) {
                joinListener.onSuccess(roomInfo);
                com.tencent.timi.game.utils.l.h("ExpandHallJoinRoomHelper_", 1, "joinRoom#from room:" + this.mHall.getMReporterHelper().getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String().H + " already exits!");
                return;
            }
            this.mHall.getMReporterHelper().T();
            com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
            ExpandHallLaunchParam expandHallLaunchParam = this.mLaunchParam;
            dVar.f379324a = expandHallLaunchParam.H;
            dVar.f379325b = com.tencent.timi.game.utils.b.h(expandHallLaunchParam.f376301d);
            dVar.f379326c = 1;
            dVar.f379328e = 5;
            dVar.f379329f = null;
            dVar.f379327d = false;
            dVar.f379330g = 0L;
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar = new com.tencent.timi.game.room.impl.util.c();
            cVar.f379322a = 0;
            cVar.f379323b = null;
            ((fm4.g) mm4.b.b(fm4.g.class)).P(this.qBaseActivity, dVar, cVar, joinListener);
            return;
        }
        com.tencent.timi.game.utils.l.c("ExpandHallGuildUtil_", 1, "already destroyed, give up mDelayJoinRoomTask");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int errorCode, String errorMsg) {
        String str;
        String str2;
        gh4.d mReporterHelper = this.mHall.getMReporterHelper();
        String str3 = "";
        if (errorMsg == null) {
            str = "";
        } else {
            str = errorMsg;
        }
        boolean z16 = false;
        mReporterHelper.R(false, errorCode, str);
        long mHallState = this.mHall.getMHallState();
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "joinRoomFailed errorCode:" + errorCode + ", errorMsg:" + errorMsg + ", mHallState:" + mHallState);
        gh4.d mReporterHelper2 = this.mHall.getMReporterHelper();
        if (errorMsg == null) {
            str2 = "";
        } else {
            str2 = errorMsg;
        }
        mReporterHelper2.X(str2);
        boolean z17 = true;
        if (mHallState != 3 && mHallState != 4) {
            gh4.f fVar = (gh4.f) mm4.b.b(gh4.f.class);
            if (errorMsg != null) {
                str3 = errorMsg;
            }
            fVar.P2(errorCode, str3, this.mHall);
            ExpandHallListener expandHallListener = this.mHallListener;
            if (expandHallListener != null) {
                ExpandHallLaunchParam expandHallLaunchParam = this.mLaunchParam;
                expandHallListener.b(expandHallLaunchParam.H, expandHallLaunchParam, errorCode, errorMsg);
            }
            if (920020 != errorCode && 920022 != errorCode) {
                QQToast.makeText(this.qBaseActivity, "\u8fdb\u623f\u5931\u8d25", 0).show();
                e.a aVar = new e.a(this.qBaseActivity);
                if (com.tencent.timi.game.utils.n.f380308a.a()) {
                    aVar.k(17);
                    if (errorMsg == null || errorMsg.length() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        errorMsg = "\u597d\u50cf\u8ff7\u8def\u4e86\uff0c\u6ca1\u80fd\u6b63\u5e38\u8fdb\u5165\u623f\u95f4";
                    }
                } else {
                    aVar.k(8388611);
                    errorMsg = "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u4f60\u7684\u7f51\u7edc\u8bbe\u7f6e\uff0c\u70b9\u51fb\u91cd\u8bd5";
                }
                aVar.j(errorMsg);
                aVar.p("\u5237\u65b0\u4e00\u4e0b");
                aVar.o(new DialogInterface.OnClickListener() { // from class: mh4.j
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        l.u(l.this, dialogInterface, i3);
                    }
                });
                aVar.n("\u9000\u51fa\u5927\u5385");
                aVar.m(new DialogInterface.OnClickListener() { // from class: mh4.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        l.v(l.this, dialogInterface, i3);
                    }
                });
                aVar.i(true);
                aVar.c().show();
                return;
            }
            if (errorMsg != null && errorMsg.length() != 0) {
                z17 = false;
            }
            if (z17) {
                errorMsg = "\u7531\u4e8e\u5e10\u6237\u5f02\u5e38\uff0c\u4f60\u6682\u65f6\u65e0\u6cd5\u4f7f\u7528\u5f00\u9ed1\u4ea4\u53cb\u5927\u5385\u529f\u80fd";
            }
            QQToast.makeText(this.qBaseActivity, errorMsg, 0).show();
            Object obj = this.mHall;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
            ((TimiGameBaseFragment) obj).qh(3);
            return;
        }
        com.tencent.timi.game.utils.l.c("ExpandHallFragment_", 1, "joinRoomFailed hall already destroyed!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(l this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(l this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        Object obj = this$0.mHall;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
        ((TimiGameBaseFragment) obj).qh(2);
    }

    private final void w(gh4.c<YoloRoomOuterClass$YoloRoomInfo> joinListener) {
        PBInt32Field pBInt32Field;
        boolean z16;
        boolean z17;
        YoloRoomOuterClass$YoloRoomDataInfo yoloRoomOuterClass$YoloRoomDataInfo;
        PBInt32Field pBInt32Field2;
        YoloRoomOuterClass$YoloRoomDataInfo yoloRoomOuterClass$YoloRoomDataInfo2;
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        View view = null;
        if (j06 != null && (yoloRoomOuterClass$YoloRoomDataInfo2 = j06.room_data_info) != null) {
            pBInt32Field = yoloRoomOuterClass$YoloRoomDataInfo2.create_from;
        } else {
            pBInt32Field = null;
        }
        com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "joinRoomNormal, currentRoomInfo:" + j06 + ", create_from:" + pBInt32Field);
        if (j06 != null && (yoloRoomOuterClass$YoloRoomDataInfo = j06.room_data_info) != null && (pBInt32Field2 = yoloRoomOuterClass$YoloRoomDataInfo.create_from) != null && pBInt32Field2.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.mLaunchParam.f376303f;
        if (j06 != null && z16 && (i3 == 0 || i3 == ((fm4.g) mm4.b.b(fm4.g.class)).t2(j06))) {
            ExpandHallLaunchParam expandHallLaunchParam = this.mLaunchParam;
            if (expandHallLaunchParam.I && expandHallLaunchParam.H == j06.room_id.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 || !this.mLaunchParam.I) {
                joinListener.onSuccess(j06);
                com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "joinRoom#from expand, room existed, auto onSuccess!");
                if (f416821k) {
                    kh4.b bVar = this.expandHallGMManager;
                    ViewGroup viewGroup = this.mRootView;
                    if (viewGroup != null) {
                        view = viewGroup.findViewById(R.id.vqk);
                    }
                    bVar.d(view, this.mLaunchParam);
                    return;
                }
                return;
            }
        }
        this.mHall.getMReporterHelper().T();
        if (this.mLaunchParam.I) {
            com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "joinRoom#from AssignedRoom");
            com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
            dVar.f379324a = this.mLaunchParam.H;
            dVar.f379325b = 1;
            dVar.f379326c = 1;
            dVar.f379328e = 5;
            dVar.f379329f = this.mHall.getMReporterHelper().i();
            dVar.f379327d = false;
            dVar.f379330g = 0L;
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar = new com.tencent.timi.game.room.impl.util.c();
            cVar.f379322a = 0;
            cVar.f379323b = null;
            ((fm4.g) mm4.b.b(fm4.g.class)).P(this.qBaseActivity, dVar, cVar, joinListener);
            this.expandHallGMManager.h(this.mRootView.findViewById(R.id.vqk), this.mLaunchParam);
            return;
        }
        ((fm4.g) mm4.b.b(fm4.g.class)).Y0(i3, this.qBaseActivity, 1, joinListener);
    }

    private final void x(gh4.c<YoloRoomOuterClass$YoloRoomInfo> joinListener) {
        com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "joinRoom#from guild. param:" + this.mLaunchParam);
        this.mGuildExpandHelper.g(joinListener, this.qBaseActivity);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(YoloRoomOuterClass$YoloRoomInfo result) {
        gh4.d.S(this.mHall.getMReporterHelper(), true, 0, null, 6, null);
        this.mHall.Gb(result);
        ((fm4.g) mm4.b.b(fm4.g.class)).K0(result.room_id.get()).o(this.mHall.getMReporterHelper());
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String guildId, List<String> channelIds) {
        fm4.c G;
        boolean z16;
        YoloRoomOuterClass$YoloRoomInfo z17 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z17 == null || (G = ((fm4.g) mm4.b.b(fm4.g.class)).K0(z17.room_id.get()).G()) == null) {
            return;
        }
        if (Intrinsics.areEqual(String.valueOf(G.f399871a), guildId) && channelIds.contains(String.valueOf(G.f399872b))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((fm4.g) mm4.b.b(fm4.g.class)).T2(z17.room_id.get(), true, 0, null, false);
        }
    }

    public final void A() {
        h hVar = this.mGuildExpandHelper;
        if (hVar != null) {
            hVar.j();
        }
    }

    public final void B() {
        E();
    }

    public final void C() {
        this.mGuildExpandHelper.k();
    }

    public final void r() {
        com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "joinRoom mRoomId:" + this.mLaunchParam.H);
        Object obj = this.mHall;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
        ((TimiGameBaseFragment) obj).showLoadingView();
        d dVar = new d();
        int i3 = this.mLaunchParam.f376301d;
        if (i3 != 2) {
            if (i3 != 3) {
                w(dVar);
                return;
            } else {
                s(dVar);
                return;
            }
        }
        x(dVar);
    }
}
