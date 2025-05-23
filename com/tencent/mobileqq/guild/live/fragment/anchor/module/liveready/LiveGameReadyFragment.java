package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.anchor.GameLiveStartParams;
import com.tencent.mobileqq.guild.live.livemanager.player.GamePlayTogetherMgr;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ff;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH\u0016J$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010 \u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001e\u00107\u001a\n 4*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveGameReadyFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag;", "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton$a;", "", "Li", "Ki", "Qi", "Oi", "Pi", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/b;", "Ii", "", "getH5Url", "", "getLayoutId", "Landroid/view/View;", "view", "initView", "Ai", "Wh", "vi", "Qh", "pushType", "Sh", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "errMsg", "", "Rh", "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton;", "isChecked", "onCheckedChanged", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isFirstCreate", "onSelected", "d6", "ei", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "Z", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "Ji", "()Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "mGameLiveAnchorMgr", "a0", "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton;", "mJoinGameSwitch", "Landroid/widget/ImageView;", "b0", "Landroid/widget/ImageView;", "mWzIcon", "kotlin.jvm.PlatformType", "c0", "Ljava/lang/String;", "mProtocolText", "Lkf4/a;", "d0", "Lkf4/a;", "mGuildIdInfo", "Lgq1/a;", "e0", "Lgq1/a;", "mProtocolUlrClkListener", "<init>", "()V", "f0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveGameReadyFragment extends LiveReadyBaseFrag implements GuildSwitchButton.a {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.live.livemanager.anchor.e mGameLiveAnchorMgr;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private GuildSwitchButton mJoinGameSwitch;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView mWzIcon;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String mProtocolText;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final kf4.a mGuildIdInfo;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gq1.a mProtocolUlrClkListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveGameReadyFragment$b", "Lnf4/a;", "Lnf4/j;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements nf4.a<nf4.j> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f226516b;

        b(int i3) {
            this.f226516b = i3;
        }

        @Override // nf4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable nf4.j result) {
            if (result != null && result.f420106a) {
                GamePlayTogetherMgr a16 = GamePlayTogetherMgr.INSTANCE.a();
                GuildSwitchButton guildSwitchButton = LiveGameReadyFragment.this.mJoinGameSwitch;
                if (guildSwitchButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mJoinGameSwitch");
                    guildSwitchButton = null;
                }
                a16.g(guildSwitchButton.isChecked(), null);
            }
            LiveGameReadyFragment.this.finishActivityJudgePadWithoutAnim();
            LiveReadyBaseFrag.ci(LiveGameReadyFragment.this, this.f226516b, 0, null, 6, null);
        }

        @Override // nf4.a
        public void onError(int errorCode, @Nullable String errorMessage) {
            LiveGameReadyFragment.this.getMGameLiveAnchorMgr().d();
            QLog.e("QGL.LiveGameReadyFragment", 1, "startGameLive error:" + errorCode + " msg:" + errorMessage);
            LiveGameReadyFragment.this.bi(this.f226516b, errorCode, "startGameLive error:" + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveGameReadyFragment$c", "Lef4/a;", "", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ef4.a {
        c() {
        }

        @Override // ef4.a
        public void hideLoading() {
            QQProgressDialog mLoadingDialog = LiveGameReadyFragment.this.getMLoadingDialog();
            if (mLoadingDialog != null) {
                mLoadingDialog.hide();
            }
        }

        @Override // ef4.a
        public void showLoading() {
            if (LiveGameReadyFragment.this.getMLoadingDialog() == null) {
                LiveGameReadyFragment.this.qi(new QQProgressDialog(LiveGameReadyFragment.this.getContext()));
            }
            QQProgressDialog mLoadingDialog = LiveGameReadyFragment.this.getMLoadingDialog();
            Intrinsics.checkNotNull(mLoadingDialog);
            mLoadingDialog.show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveGameReadyFragment$d", "Lof4/a;", "", "c", "b", "Lkf4/a;", "guildIdInfo", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements of4.a {
        d() {
        }

        @Override // of4.a
        public void a(@Nullable kf4.a guildIdInfo) {
            LiveGameReadyFragment.this.Ci(true);
        }

        @Override // of4.a
        public void b() {
            com.tencent.mobileqq.guild.util.aa.a(R.string.f147790xu);
            LiveGameReadyFragment.this.finishActivityJudgePadWithAnim();
        }

        @Override // of4.a
        public void c() {
            LiveGameReadyFragment.this.finishActivityJudgePadWithAnim();
        }
    }

    public LiveGameReadyFragment() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        this.mGameLiveAnchorMgr = gLiveChannelCore.h();
        this.mProtocolText = HardCodeUtil.qqStr(R.string.f148230z1);
        this.mGuildIdInfo = new kf4.a(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId());
        this.mProtocolUlrClkListener = new gq1.a() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.f
            @Override // gq1.a
            public final void onCloseLiveAgreement() {
                LiveGameReadyFragment.Ni(LiveGameReadyFragment.this);
            }
        };
    }

    private final GameLiveStartParams Ii() {
        return new GameLiveStartParams(this.mGuildIdInfo, 1, Eh().getText().toString(), "", this.mGameLiveAnchorMgr.a(), this.mGameLiveAnchorMgr.i());
    }

    private final void Ki() {
        this.mGameLiveAnchorMgr.c(new d());
    }

    private final void Li() {
        LiveData a16 = e12.b.a(Mh(), Bh());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Pair<Boolean, Boolean>, Unit> function1 = new Function1<Pair<Boolean, Boolean>, Unit>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveGameReadyFragment$initStartBtn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<Boolean, Boolean> pair) {
                invoke2(pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, Boolean> pair) {
                ImageView Hh = LiveGameReadyFragment.this.Hh();
                Object obj = pair.first;
                Intrinsics.checkNotNullExpressionValue(obj, "it.first");
                Hh.setSelected(((Boolean) obj).booleanValue());
                Object obj2 = pair.first;
                Intrinsics.checkNotNullExpressionValue(obj2, "it.first");
                if (((Boolean) obj2).booleanValue()) {
                    Object obj3 = pair.second;
                    Intrinsics.checkNotNullExpressionValue(obj3, "it.second");
                    if (((Boolean) obj3).booleanValue()) {
                        LiveGameReadyFragment.this.Ih().setVisibility(0);
                        LiveGameReadyFragment.this.Jh().setVisibility(8);
                        return;
                    }
                }
                LiveGameReadyFragment.this.Ih().setVisibility(8);
                LiveGameReadyFragment.this.Jh().setVisibility(0);
            }
        };
        a16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGameReadyFragment.Mi(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(LiveGameReadyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mh().postValue(Boolean.TRUE);
        bw.L().encodeBool("select_agree", true);
        this$0.vi();
    }

    private final void Oi() {
        GuildSwitchButton guildSwitchButton = this.mJoinGameSwitch;
        GuildSwitchButton guildSwitchButton2 = null;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinGameSwitch");
            guildSwitchButton = null;
        }
        guildSwitchButton.setOnCheckedChangeListener(this);
        boolean decodeBool = bw.L().decodeBool("can_play_together", false);
        QLog.d("QGL.LiveGameReadyFragment", 1, "[setCanPlayTogether] defaultStatus- " + decodeBool);
        GuildSwitchButton guildSwitchButton3 = this.mJoinGameSwitch;
        if (guildSwitchButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinGameSwitch");
        } else {
            guildSwitchButton2 = guildSwitchButton3;
        }
        guildSwitchButton2.setChecked(decodeBool);
    }

    private final void Pi() {
        Mh().setValue(Boolean.FALSE);
        ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).addCloseLiveAgreementListener(this.mProtocolUlrClkListener);
    }

    private final void Qi() {
        this.mGameLiveAnchorMgr.g(1);
        e12.e<ff> h16 = GLiveChannelCore.f226698a.t().h();
        Intrinsics.checkNotNullExpressionValue(h16, "uiData.gameLiveRoomInfo");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        e12.d.c(h16, viewLifecycleOwner, new Function1<ff, Unit>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveGameReadyFragment$setRoomInfoObs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ff ffVar) {
                invoke2(ffVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ff ffVar) {
                LiveGameReadyFragment.this.Eh().setText(ffVar.a());
                LiveGameReadyFragment.this.Ei(ffVar.a());
                com.tencent.mobileqq.guild.u.q(ffVar.getCoverUrl(), LiveGameReadyFragment.this.Ch(), true);
            }
        });
    }

    private final String getH5Url() {
        return "https://qun.qq.com/qunpro/live/agreement?_wv=3&readState=" + (bw.L().decodeBool("select_agree", false) ? 1 : 0);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Ai() {
        QLog.d("QGL.LiveGameReadyFragment", 1, "startLive");
        if (com.tencent.mobileqq.guild.util.o.c("QGL.start_live_click")) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.LiveReadyBaseFrag", 2, "click too fast return");
            }
        } else {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                com.tencent.mobileqq.guild.util.aa.d(R.string.f148380zf);
                return;
            }
            Boolean value = Bh().getValue();
            Boolean bool = Boolean.FALSE;
            if (Intrinsics.areEqual(value, bool)) {
                com.tencent.mobileqq.guild.util.aa.d(R.string.f148180yw);
            } else if (Intrinsics.areEqual(Mh().getValue(), bool)) {
                com.tencent.mobileqq.guild.util.aa.d(R.string.f148010yf);
            } else {
                if (zi(1)) {
                    return;
                }
                Wh();
            }
        }
    }

    @NotNull
    /* renamed from: Ji, reason: from getter */
    public final com.tencent.mobileqq.guild.live.livemanager.anchor.e getMGameLiveAnchorMgr() {
        return this.mGameLiveAnchorMgr;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Qh() {
        boolean z16 = false;
        if (!bw.L().decodeBool("select_agree", false) && !Intrinsics.areEqual(Mh().getValue(), Boolean.TRUE)) {
            Vh(getH5Url());
            return;
        }
        Boolean value = Mh().getValue();
        if (value != null) {
            z16 = value.booleanValue();
        }
        Mh().setValue(Boolean.valueOf(!z16));
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public boolean Rh(int result, @Nullable IGProSecurityResult securityResult, @Nullable String errMsg) {
        if (super.Rh(result, securityResult, errMsg)) {
            return true;
        }
        finishActivityJudgePadWithoutAnim();
        return true;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Sh(int pushType) {
        super.Sh(pushType);
        MMKVOptionEntity L = bw.L();
        GuildSwitchButton guildSwitchButton = this.mJoinGameSwitch;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinGameSwitch");
            guildSwitchButton = null;
        }
        L.encodeBool("can_play_together", guildSwitchButton.isChecked());
        this.mGameLiveAnchorMgr.b(Ii(), new b(pushType), new c());
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Wh() {
        super.Wh();
        LiveReadyBaseFrag.Yh(this, "0", 1, null, 4, null);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void d6() {
        super.d6();
        QLog.d("QGL.LiveGameReadyFragment", 1, "onUnSelected removeObserver");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void ei(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.ei(view);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_live_game_id", "wangzhe");
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        ImageView imageView = this.mWzIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWzIcon");
            imageView = null;
        }
        guildDTReportApiImpl.setElementParams(imageView, hashMap);
        ImageView imageView2 = this.mWzIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWzIcon");
            imageView2 = null;
        }
        guildDTReportApiImpl.setElementReport(imageView2, "em_sgrp_stream_start_choose_game", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
        GuildSwitchButton guildSwitchButton = this.mJoinGameSwitch;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinGameSwitch");
            guildSwitchButton = null;
        }
        guildDTReportApiImpl.setElementExposureAndClickParams(guildSwitchButton, "em_sgrp_stream_start_join_team", null);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ewv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        View findViewById = view.findViewById(R.id.ylq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.live_game_join_switch)");
        this.mJoinGameSwitch = (GuildSwitchButton) findViewById;
        View findViewById2 = view.findViewById(R.id.f125677mp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.wz_icon)");
        this.mWzIcon = (ImageView) findViewById2;
        Li();
        Ki();
        Qi();
        Oi();
        Pi();
        ImageView imageView = this.mWzIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWzIcon");
            imageView = null;
        }
        com.tencent.mobileqq.guild.u.q("https://downv6.qq.com/innovate/guild/avatar_icon/guild_live_wz_icon.png", imageView, true);
        fi(view, 2);
        ei(view);
    }

    @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
    public void onCheckedChanged(@Nullable GuildSwitchButton view, boolean isChecked) {
        int i3;
        QLog.d("QGL.LiveGameReadyFragment", 4, "onCheckedChanged " + isChecked);
        HashMap hashMap = new HashMap();
        if (isChecked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_switch", Integer.valueOf(i3));
        GuildSwitchButton guildSwitchButton = this.mJoinGameSwitch;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinGameSwitch");
            guildSwitchButton = null;
        }
        VideoReport.reportEvent("clck", guildSwitchButton, hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QGL.LiveGameReadyFragment", 1, "onDestroy.");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.i("QGL.LiveGameReadyFragment", 1, "onDestroyView.");
        GuildSwitchButton guildSwitchButton = this.mJoinGameSwitch;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinGameSwitch");
            guildSwitchButton = null;
        }
        guildSwitchButton.setOnCheckedChangeListener(null);
        ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).removeCloseLiveAgreementListener(this.mProtocolUlrClkListener);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void onSelected(boolean isFirstCreate) {
        super.onSelected(isFirstCreate);
        QLog.i("QGL.LiveGameReadyFragment", 1, "onSelected, isFirstCreate[" + isFirstCreate + "]");
        LiveReadyBaseFrag.INSTANCE.a(1);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void vi() {
        TextView Gh = Gh();
        String qqStr = HardCodeUtil.qqStr(R.string.f147800xv);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_live_game_protocol)");
        String mProtocolText = this.mProtocolText;
        Intrinsics.checkNotNullExpressionValue(mProtocolText, "mProtocolText");
        Gh.setText(yh(qqStr, mProtocolText, getH5Url()));
        Gh().setMovementMethod(LinkMovementMethod.getInstance());
        Gh().setHighlightColor(0);
    }
}
