package com.tencent.mobileqq.guild.media.game.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import bt1.RoomAuthParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.IGuildClientAuthApi;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.game.widget.GuildMediaGameTeamBar;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.dq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs1.GuildAuthGameBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u001d\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019J\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0004H\u0007J\b\u0010$\u001a\u00020\u0004H\u0007J\u0006\u0010%\u001a\u00020\u0004R\u0014\u0010(\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010+\u001a\n )*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010'R\u001c\u0010-\u001a\n )*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010'R\u001c\u0010/\u001a\n )*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u001c\u00103\u001a\n )*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00105\u001a\n )*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00102R\u001c\u00109\u001a\n )*\u0004\u0018\u000106068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010:R\u001e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010?R\u0016\u0010B\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010AR\u0016\u0010C\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010AR\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010<\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "D", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/lifecycle/LifecycleOwner;", "lifeCycle", HippyTKDListViewAdapter.X, "v", "G", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/dq;", "gameModes", "I", "", ZPlanPublishSource.FROM_SCHEME, "from", "H", ReportConstant.COSTREPORT_PREFIX, "J", "Lbt1/h;", "vm", "Lmqq/util/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "activityReference", "E", "r", "Landroid/content/res/Configuration;", "newConfig", UserInfo.SEX_FEMALE, "Landroid/view/View;", NodeProps.ON_CLICK, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Landroid/view/View;", "mRootView", "kotlin.jvm.PlatformType", "e", "mRoot", "f", "mStartBtn", tl.h.F, "mClose", "Lcom/tencent/widget/RoundRectImageView;", "i", "Lcom/tencent/widget/RoundRectImageView;", "mGameIv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mGameBg", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mGameBgAnim", "Lbt1/h;", "roomViewModel", "Lmqq/util/WeakReference;", "mActivityReference", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamChooseModeDialog;", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamChooseModeDialog;", "mChooseDialog", "Ljava/lang/String;", "mBgUrl", "mAnimUrl", "lifecycleOwner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaGameTeamBar extends FrameLayout implements View.OnClickListener, LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView mGameBgAnim;

    /* renamed from: D, reason: from kotlin metadata */
    private bt1.h roomViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private WeakReference<FragmentActivity> mActivityReference;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private GuildTeamChooseModeDialog mChooseDialog;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mBgUrl;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mAnimUrl;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private WeakReference<LifecycleOwner> lifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View mRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View mStartBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View mClose;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final RoundRectImageView mGameIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RoundRectImageView mGameBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(GuildMediaGameTeamBar this$0, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.mGameBg.setImageBitmap(bitmap);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            final Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final GuildMediaGameTeamBar guildMediaGameTeamBar = GuildMediaGameTeamBar.this;
                    uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.game.widget.ae
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildMediaGameTeamBar.b.e(GuildMediaGameTeamBar.this, resultBitMap);
                        }
                    });
                    return;
                }
                GuildMediaGameTeamBar.this.mGameBg.setImageBitmap(resultBitMap);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar$c", "Llf4/a;", "", "onSuccess", "b", "onUserCancel", "a", "onFailed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements lf4.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f228850b;

        c(String str) {
            this.f228850b = str;
        }

        @Override // lf4.a
        public void a() {
            bt1.h hVar = GuildMediaGameTeamBar.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.Z1(this.f228850b);
            QLog.i("QMGame.GuildMediaGameTeamBar", 1, "launchGame onJumpForbidden");
        }

        @Override // lf4.a
        public void b() {
            QLog.i("QMGame.GuildMediaGameTeamBar", 1, "launchGame onAppNotInstalled");
            bt1.h hVar = GuildMediaGameTeamBar.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.Z1(this.f228850b);
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            QQToast.makeText(context, context.getString(R.string.f140010ct), 0).show();
        }

        @Override // lf4.a
        public void onFailed() {
            bt1.h hVar = GuildMediaGameTeamBar.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.Z1(this.f228850b);
            QLog.i("QMGame.GuildMediaGameTeamBar", 1, "launchGame onFailed");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            QQToast.makeText(context, context.getString(R.string.f140020cu), 0).show();
        }

        @Override // lf4.a
        public void onSuccess() {
            QLog.i("QMGame.GuildMediaGameTeamBar", 1, "launchGame onSuccess");
        }

        @Override // lf4.a
        public void onUserCancel() {
            bt1.h hVar = GuildMediaGameTeamBar.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.Z1(this.f228850b);
            QLog.i("QMGame.GuildMediaGameTeamBar", 1, "launchGame onUserCancel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaGameTeamBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void D() {
        this.mGameIv.setCornerRadiusAndMode(QQGuildUIUtil.f(7.0f), 1);
        this.mGameBg.setCornerRadiusAndMode(QQGuildUIUtil.f(4.0f), 1);
        com.tencent.mobileqq.guild.u.q("https://downv6.qq.com/innovate/guild/avatar_icon/guild_live_wz_icon.png", this.mGameIv, true);
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(this.mBgUrl), new b());
        com.tencent.mobileqq.guild.u.q("https://downv6.qq.com/innovate/guild/avatar_icon/guild_live_wz_icon.png", this.mGameIv, true);
        ImageView imageView = this.mGameBgAnim;
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        String str = this.mAnimUrl;
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(GuildMediaUtils.f227771a.n() ? 1 : 0);
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(iVasApngFactory.getDynamicDrawable(str, apngOptions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        ((IGuildClientAuthApi) QRoute.api(IGuildClientAuthApi.class)).openClientAuthorizationDialog(QBaseActivity.sTopActivity, new GuildClientParams().e0(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c())).f(com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c())).l("100001").l0(7).e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String scheme, String from) {
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getGameRoomHandler().a(scheme, this.mActivityReference.get(), new c(from));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(ArrayList<dq> gameModes) {
        this.mChooseDialog = new GuildTeamChooseModeDialog(gameModes);
        if (this.mActivityReference.get() != null) {
            GuildTeamChooseModeDialog guildTeamChooseModeDialog = this.mChooseDialog;
            Intrinsics.checkNotNull(guildTeamChooseModeDialog);
            FragmentActivity fragmentActivity = this.mActivityReference.get();
            Intrinsics.checkNotNull(fragmentActivity);
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "mActivityReference.get()!!.supportFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(guildTeamChooseModeDialog, supportFragmentManager, "QMGame.GuildMediaGameTeamBar");
            return;
        }
        if (QBaseActivity.sTopActivity != null) {
            GuildTeamChooseModeDialog guildTeamChooseModeDialog2 = this.mChooseDialog;
            Intrinsics.checkNotNull(guildTeamChooseModeDialog2);
            FragmentManager supportFragmentManager2 = QBaseActivity.sTopActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "sTopActivity.supportFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(guildTeamChooseModeDialog2, supportFragmentManager2, "QMGame.GuildMediaGameTeamBar");
            return;
        }
        QLog.d("QMGame.GuildMediaGameTeamBar", 1, "openGameModelDialog failed activity is null");
    }

    private final void J() {
        Map mapOf;
        View rootView = getRootView();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        Pair[] pairArr = new Pair[3];
        bt1.h hVar = this.roomViewModel;
        bt1.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        pairArr[0] = TuplesKt.to("sgrp_avchannel_gameplay_id", hVar.h2());
        bt1.h hVar3 = this.roomViewModel;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar3 = null;
        }
        pairArr[1] = TuplesKt.to("sgrp_team_state", Integer.valueOf(hVar3.q2()));
        bt1.h hVar4 = this.roomViewModel;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
        } else {
            hVar2 = hVar4;
        }
        pairArr[2] = TuplesKt.to("sgrp_room_users_number", Integer.valueOf(hVar2.j2()));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        ch.T0(rootView, "em_sgrp_honorofkings_game", clickPolicy, exposurePolicy, mapOf);
        ch.X0(this.mStartBtn, "em_sgrp_honorofkings_game_initiate_btn", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.game.widget.ac
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map K;
                K = GuildMediaGameTeamBar.K(GuildMediaGameTeamBar.this, str);
                return K;
            }
        });
        ch.X0(this.mClose, "em_sgrp_honorofkings_game_close_btn", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.game.widget.ad
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map L;
                L = GuildMediaGameTeamBar.L(GuildMediaGameTeamBar.this, str);
                return L;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map K(GuildMediaGameTeamBar this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bt1.h hVar = this$0.roomViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_user_segment", hVar.o2()));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map L(GuildMediaGameTeamBar this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("sgrp_game_team_id", "0");
        bt1.h hVar = this$0.roomViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        pairArr[1] = TuplesKt.to("sgrp_user_segment", hVar.o2());
        pairArr[2] = TuplesKt.to("sgrp_game_mode", "0");
        pairArr[3] = TuplesKt.to("sgrp_team_users_number", "0");
        pairArr[4] = TuplesKt.to("sgrp_segment_requirement", "");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void q() {
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        if (QQGuildUIUtil.A(getContext())) {
            i3 = (int) (i3 * com.tencent.mobileqq.pad.e.g());
        }
        ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mGameIv.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        QLog.i("QMGame.GuildMediaGameTeamBar", 1, "height: " + layoutParams.height);
        if (i3 >= 1500) {
            QLog.i("QMGame.GuildMediaGameTeamBar", 1, "is fold expand");
            this.mBgUrl = "https://downv6.qq.com/innovate/guild/media_game/background_fold.png";
            this.mAnimUrl = "https://downv6.qq.com/innovate/guild/media_game/guild_game_ready_fold.png";
            layoutParams.height = (i3 - 60) / 3;
            if (AppSetting.t(getContext())) {
                marginLayoutParams.topMargin = QQGuildUIUtil.f(22.0f);
            } else {
                marginLayoutParams.topMargin = QQGuildUIUtil.f(52.0f);
            }
        } else {
            this.mBgUrl = "https://downv6.qq.com/innovate/guild/media_game/background.png";
            this.mAnimUrl = "https://downv6.qq.com/innovate/guild/media_game/guild_game_ready.png";
            layoutParams.height = QQGuildUIUtil.f(177.0f);
            marginLayoutParams.topMargin = QQGuildUIUtil.f(22.0f);
        }
        this.mRoot.setLayoutParams(layoutParams);
        this.mGameIv.setLayoutParams(marginLayoutParams);
    }

    private final void s() {
        DialogUtil.createCustomDialog(getContext(), 230, null, "\u786e\u5b9a\u7ed3\u675f\u4e00\u8d77\u5f00\u9ed1\u5417\uff1f", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildMediaGameTeamBar.t(GuildMediaGameTeamBar.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildMediaGameTeamBar.u(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildMediaGameTeamBar this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bt1.h hVar = this$0.roomViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        hVar.y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void v() {
        RoomAuthParams roomAuthParams = new RoomAuthParams(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()), com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c()), 101, true, 1);
        bt1.h hVar = this.roomViewModel;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        hVar.R1(roomAuthParams);
    }

    private final void w() {
        this.mStartBtn.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    private final void x(LifecycleOwner lifeCycle) {
        bt1.h hVar = this.roomViewModel;
        bt1.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        MutableLiveData<Pair<Boolean, String>> g26 = hVar.g2();
        final Function1<Pair<? extends Boolean, ? extends String>, Unit> function1 = new Function1<Pair<? extends Boolean, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildMediaGameTeamBar$initObservers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, String> pair) {
                if (pair == null) {
                    return;
                }
                if (pair.getFirst().booleanValue()) {
                    QQToast.makeText(GuildMediaGameTeamBar.this.getContext(), R.string.f1493211z, 0).show();
                } else {
                    QQToast.makeText(GuildMediaGameTeamBar.this.getContext(), pair.getSecond(), 0).show();
                }
            }
        };
        g26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaGameTeamBar.y(Function1.this, obj);
            }
        });
        bt1.h hVar3 = this.roomViewModel;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar3 = null;
        }
        MutableLiveData<Pair<String, String>> n26 = hVar3.n2();
        final Function1<Pair<? extends String, ? extends String>, Unit> function12 = new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildMediaGameTeamBar$initObservers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends String> pair) {
                invoke2((Pair<String, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, String> pair) {
                if (pair == null || StringUtil.isEmpty(pair.getFirst())) {
                    return;
                }
                GuildMediaGameTeamBar.this.H(pair.getFirst(), pair.getSecond());
            }
        };
        n26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaGameTeamBar.z(Function1.this, obj);
            }
        });
        bt1.h hVar4 = this.roomViewModel;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar4 = null;
        }
        MutableLiveData<Pair<Boolean, String>> f26 = hVar4.f2();
        final Function1<Pair<? extends Boolean, ? extends String>, Unit> function13 = new Function1<Pair<? extends Boolean, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildMediaGameTeamBar$initObservers$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, String> pair) {
                GuildTeamChooseModeDialog guildTeamChooseModeDialog;
                if (pair == null) {
                    return;
                }
                if (!pair.getFirst().booleanValue()) {
                    QQToast.makeText(BaseApplication.context, pair.getSecond(), 0).show();
                }
                guildTeamChooseModeDialog = GuildMediaGameTeamBar.this.mChooseDialog;
                if (guildTeamChooseModeDialog != null) {
                    guildTeamChooseModeDialog.dismissAllowingStateLoss();
                }
            }
        };
        f26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaGameTeamBar.A(Function1.this, obj);
            }
        });
        bt1.h hVar5 = this.roomViewModel;
        if (hVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar5 = null;
        }
        MutableLiveData<GuildAuthGameBean> b26 = hVar5.b2();
        final Function1<GuildAuthGameBean, Unit> function14 = new Function1<GuildAuthGameBean, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildMediaGameTeamBar$initObservers$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildAuthGameBean guildAuthGameBean) {
                invoke2(guildAuthGameBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildAuthGameBean guildAuthGameBean) {
                if (guildAuthGameBean == null) {
                    return;
                }
                int state = guildAuthGameBean.getState();
                if (state != 1) {
                    if (state == 5) {
                        GuildMediaGameTeamBar.this.G();
                        return;
                    } else {
                        QQToast.makeText(GuildMediaGameTeamBar.this.getContext(), guildAuthGameBean.getTipsContent(), 0).show();
                        return;
                    }
                }
                if (guildAuthGameBean.a().size() > 0) {
                    GuildMediaGameTeamBar.this.I(guildAuthGameBean.a());
                } else {
                    QQToast.makeText(GuildMediaGameTeamBar.this.getContext(), R.string.f14937124, 0).show();
                }
            }
        };
        b26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaGameTeamBar.B(Function1.this, obj);
            }
        });
        bt1.h hVar6 = this.roomViewModel;
        if (hVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
        } else {
            hVar2 = hVar6;
        }
        MutableLiveData<Boolean> d26 = hVar2.d2();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildMediaGameTeamBar$initObservers$5
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
            public final void invoke2(Boolean it) {
                View view;
                View view2;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    view2 = GuildMediaGameTeamBar.this.mClose;
                    view2.setVisibility(0);
                } else {
                    view = GuildMediaGameTeamBar.this.mClose;
                    view.setVisibility(8);
                }
            }
        };
        d26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaGameTeamBar.C(Function1.this, obj);
            }
        });
        lifeCycle.getLifecycle().addObserver(this);
        this.lifecycleOwner = new WeakReference<>(lifeCycle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void E(@NotNull bt1.h vm5, @NotNull LifecycleOwner lifeCycle, @NotNull WeakReference<FragmentActivity> activityReference) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
        Intrinsics.checkNotNullParameter(activityReference, "activityReference");
        this.roomViewModel = vm5;
        this.mActivityReference = activityReference;
        q();
        D();
        w();
        x(lifeCycle);
        J();
    }

    public final void F(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        q();
        D();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!com.tencent.mobileqq.guild.util.o.d("QMGame.GuildMediaGameTeamBar", 1000L)) {
            if (Intrinsics.areEqual(v3, this.mStartBtn)) {
                v();
            } else if (Intrinsics.areEqual(v3, this.mClose)) {
                s();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void onDestroy() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference != null && (lifecycleOwner = weakReference.get()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        APNGDrawable aPNGDrawable;
        Drawable drawable = this.mGameBgAnim.getDrawable();
        if (drawable instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) drawable;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.pauseApng();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        APNGDrawable aPNGDrawable;
        Drawable drawable = this.mGameBgAnim.getDrawable();
        if (drawable instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) drawable;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.resumeApng();
        }
    }

    public final void r() {
        q();
        D();
        this.mStartBtn.setVisibility(8);
    }

    public /* synthetic */ GuildMediaGameTeamBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaGameTeamBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eyj, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026edia_game_team_bar, this)");
        this.mRootView = inflate;
        this.mRoot = inflate.findViewById(R.id.vju);
        this.mStartBtn = inflate.findViewById(R.id.z0_);
        this.mClose = inflate.findViewById(R.id.tzn);
        this.mGameIv = (RoundRectImageView) inflate.findViewById(R.id.vja);
        this.mGameBg = (RoundRectImageView) inflate.findViewById(R.id.vi6);
        this.mGameBgAnim = (ImageView) inflate.findViewById(R.id.vi7);
        this.mActivityReference = new WeakReference<>(null);
        this.mBgUrl = "https://downv6.qq.com/innovate/guild/media_game/background.png";
        this.mAnimUrl = "https://downv6.qq.com/innovate/guild/media_game/guild_game_ready.png";
    }
}
