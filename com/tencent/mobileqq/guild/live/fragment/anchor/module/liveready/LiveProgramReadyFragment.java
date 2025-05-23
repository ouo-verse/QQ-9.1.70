package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildLivePlayListDialogFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.j;
import com.tencent.mobileqq.guild.live.livemanager.player.l;
import com.tencent.mobileqq.guild.live.widget.GuildLiveProgramSourceBarLayout;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.api.IContainerViewCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.bl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0015\u001a\u00020\u0003H\u0014J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J$\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016R\u001c\u0010.\u001a\n +*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010,R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010,R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010-R\u0018\u0010?\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveProgramReadyFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "", "aj", "Xi", "", "jsonStr", "Oi", "url", "Mi", "", "show", "Vi", "Zi", "Wi", "", "getLayoutId", "Landroid/view/View;", "view", "initView", "initLiveDataObserver", "isFirstCreate", "onSelected", "d6", "Ai", "Wh", "pushType", "Sh", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "errMsg", "Rh", "vi", "Landroid/content/Intent;", "intent", "Sb", "onFinish", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFirstFrameCome", "onError", "kotlin.jvm.PlatformType", "Z", "Ljava/lang/String;", "mProtocolText", "a0", "mCurStreamUrl", "Lcom/tencent/mobileqq/qqguildsdk/data/bl;", "b0", "Lcom/tencent/mobileqq/qqguildsdk/data/bl;", "mProgramInfo", "c0", "mUserSelectedCover", "d0", "mUserHasInputName", "e0", "mPlayStreamUrlSuccess", "f0", "mProgramName", "g0", "Landroid/view/View;", "mVideoView", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "h0", "Lkotlin/Lazy;", "Ni", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mStartLiveDialog", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveProgramSourceBarLayout;", "i0", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveProgramSourceBarLayout;", "mVideoSourceInfoBar", "<init>", "()V", "j0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveProgramReadyFragment extends LiveReadyBaseFrag implements com.tencent.mobileqq.guild.live.livemanager.player.j {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private bl mProgramInfo;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mUserSelectedCover;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean mUserHasInputName;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean mPlayStreamUrlSuccess;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mVideoView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mStartLiveDialog;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private GuildLiveProgramSourceBarLayout mVideoSourceInfoBar;

    /* renamed from: Z, reason: from kotlin metadata */
    private final String mProtocolText = HardCodeUtil.qqStr(R.string.f148240z2);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurStreamUrl = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mProgramName = "";

    public LiveProgramReadyFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQProgressDialog>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveProgramReadyFragment$mStartLiveDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQProgressDialog invoke() {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(LiveProgramReadyFragment.this.getContext());
                qQProgressDialog.setCanceledOnTouchOutside(false);
                qQProgressDialog.setCancelable(false);
                return qQProgressDialog;
            }
        });
        this.mStartLiveDialog = lazy;
    }

    private final void Mi(String url) {
        FrameLayout frameLayout;
        this.mCurStreamUrl = url;
        View view = getView();
        View view2 = null;
        if (view != null) {
            frameLayout = (FrameLayout) view.findViewById(R.id.soz);
        } else {
            frameLayout = null;
        }
        if (frameLayout == null) {
            return;
        }
        View a16 = l.a.a(GLiveChannelCore.f226698a.m(), url, GuildLivePlayerTag.LIVE_PROGRAM_READY, 0, false, com.tencent.mobileqq.guild.live.config.a.b(), 12, null);
        this.mVideoView = a16;
        if (frameLayout.indexOfChild(a16) > -1) {
            QLog.i("QGL.LiveProgramReadyFragment", 1, "the same url and player video view, ignore");
            return;
        }
        this.mPlayStreamUrlSuccess = false;
        View view3 = this.mVideoView;
        Intrinsics.checkNotNull(view3);
        if (view3.getParent() instanceof ViewGroup) {
            View view4 = this.mVideoView;
            Intrinsics.checkNotNull(view4);
            ViewParent parent = view4.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.mVideoView);
        }
        frameLayout.addView(this.mVideoView, 0, new FrameLayout.LayoutParams(-1, -1));
        Wi(true);
        Vi(false);
        Zi();
        View view5 = getView();
        if (view5 != null) {
            view2 = view5.findViewById(R.id.f165551wm1);
        }
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final QQProgressDialog Ni() {
        return (QQProgressDialog) this.mStartLiveDialog.getValue();
    }

    private final void Oi(String jsonStr) {
        TextView textView;
        View view;
        QLog.i("QGL.LiveProgramReadyFragment", 1, "handleSelectProgramResult:" + jsonStr);
        if (TextUtils.isEmpty(jsonStr)) {
            QLog.e("QGL.LiveProgramReadyFragment", 1, "handleSelectProgramResult jsonStr is null !!!");
            return;
        }
        JSONObject jSONObject = new JSONObject(jsonStr);
        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout = null;
        if (!this.mUserSelectedCover && jSONObject.has("live_cover")) {
            String cover = jSONObject.getString("live_cover");
            Intrinsics.checkNotNullExpressionValue(cover, "cover");
            gi(cover);
            Ch().setVisibility(0);
            View view2 = getView();
            if (view2 != null) {
                view = view2.findViewById(R.id.ykr);
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            com.tencent.mobileqq.guild.u.q(getMCoverLocalPath(), Ch(), true);
        }
        if (!this.mUserHasInputName && jSONObject.has("live_name")) {
            String string = jSONObject.getString("live_name");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(PROGRAM_NAME)");
            this.mProgramName = string;
            Eh().setText(this.mProgramName);
            Ei(this.mProgramName);
        }
        if (jSONObject.has("stream_url")) {
            String string2 = jSONObject.getString("stream_url");
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(PROGRAM_STREAM_URL)");
            Mi(string2);
        } else {
            QLog.e("QGL.LiveProgramReadyFragment", 1, "PROGRAM_STREAM_URL not find.");
        }
        if (jSONObject.has("program_id") && jSONObject.has(com.qzone.widget.u.COLUMN_TAB_ID)) {
            this.mProgramInfo = new bl(jSONObject.getString("program_id"), (int) jSONObject.getLong(com.qzone.widget.u.COLUMN_TAB_ID));
        } else {
            QLog.e("QGL.LiveProgramReadyFragment", 1, "PROGRAM_ID || PROGRAM_TAB_ID not find.");
        }
        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout2 = this.mVideoSourceInfoBar;
        if (guildLiveProgramSourceBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceInfoBar");
            guildLiveProgramSourceBarLayout2 = null;
        }
        guildLiveProgramSourceBarLayout2.setVisibility(0);
        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout3 = this.mVideoSourceInfoBar;
        if (guildLiveProgramSourceBarLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceInfoBar");
        } else {
            guildLiveProgramSourceBarLayout = guildLiveProgramSourceBarLayout3;
        }
        if (jsonStr == null) {
            jsonStr = "";
        }
        guildLiveProgramSourceBarLayout.setVideoSourceData(jsonStr);
        aj();
        View view3 = getView();
        if (view3 != null && (textView = (TextView) view3.findViewById(R.id.f89174z2)) != null) {
            textView.setText(R.string.f1522319u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(LiveProgramReadyFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qi(LiveProgramReadyFragment this$0, Boolean bool) {
        CharSequence trim;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Editable text = this$0.Eh().getText();
        Intrinsics.checkNotNullExpressionValue(text, "mLiveName.text");
        trim = StringsKt__StringsKt.trim(text);
        if (!Intrinsics.areEqual(trim.toString(), this$0.mProgramName)) {
            this$0.mUserHasInputName = true;
        }
        this$0.aj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(LiveProgramReadyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("QGL.play_list")) {
            this$0.Xi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(LiveProgramReadyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mi(this$0.mCurStreamUrl);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(LiveProgramReadyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("QGL.play_list")) {
            this$0.Xi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(LiveProgramReadyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xh().m();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Vi(boolean show) {
        View view;
        int i3;
        View view2 = getView();
        if (view2 != null) {
            view = view2.findViewById(R.id.wmw);
        } else {
            view = null;
        }
        if (view != null) {
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private final void Wi(boolean show) {
        View view;
        int i3;
        View view2 = getView();
        if (view2 != null) {
            view = view2.findViewById(R.id.wmx);
        } else {
            view = null;
        }
        if (view != null) {
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private final void Xi() {
        Map mutableMapOf;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("guild_id", gLiveChannelCore.s().getGuildId()), TuplesKt.to("channel_id", gLiveChannelCore.s().getChannelId()));
        bl blVar = this.mProgramInfo;
        if (blVar != null) {
            Intrinsics.checkNotNull(blVar);
            mutableMapOf.put(com.qzone.widget.u.COLUMN_TAB_ID, String.valueOf(blVar.b()));
        }
        QQGuildLivePlayListDialogFragment yh5 = QQGuildLivePlayListDialogFragment.yh(mutableMapOf, new IContainerViewCallback() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.n
            @Override // com.tencent.mobileqq.mini.api.IContainerViewCallback
            public final void onMiniViewResult(String str) {
                LiveProgramReadyFragment.Yi(LiveProgramReadyFragment.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(yh5, "newInstance(enterMapPara\u2026Result(jsonStr)\n        }");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(yh5, childFragmentManager, QQGuildLivePlayListDialogFragment.class.getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yi(LiveProgramReadyFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Oi(str);
    }

    private final void Zi() {
        View view;
        View view2 = getView();
        if (view2 != null) {
            view = view2.findViewById(R.id.wnr);
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private final void aj() {
        boolean z16;
        if (this.mPlayStreamUrlSuccess && this.mProgramInfo != null) {
            Boolean value = Bh().getValue();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(value, bool)) {
                if (getMCoverLocalPath().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && Intrinsics.areEqual(Mh().getValue(), bool)) {
                    Ih().setVisibility(0);
                    Jh().setVisibility(8);
                    return;
                }
            }
        }
        Ih().setVisibility(8);
        Jh().setVisibility(0);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Ai() {
        boolean z16;
        QLog.d("QGL.LiveProgramReadyFragment", 1, "startLive");
        if (com.tencent.mobileqq.guild.util.o.c("QGL.start_live_click")) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.LiveReadyBaseFrag", 2, "click too fast return");
                return;
            }
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148380zf);
            return;
        }
        if (this.mProgramInfo == null) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148190yx);
            return;
        }
        Boolean value = Bh().getValue();
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.areEqual(value, bool)) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148180yw);
            return;
        }
        if (getMCoverLocalPath().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148200yy);
            return;
        }
        if (Intrinsics.areEqual(Mh().getValue(), bool)) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148010yf);
        } else if (!this.mPlayStreamUrlSuccess) {
            QLog.i("QGL.LiveProgramReadyFragment", 1, "mPlayStreamUrlSuccess is false.");
        } else {
            if (zi(2)) {
                return;
            }
            Wh();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public boolean Rh(int result, @Nullable IGProSecurityResult securityResult, @Nullable String errMsg) {
        Ni().dismiss();
        super.Rh(result, securityResult, errMsg);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void Sb(@NotNull Intent intent) {
        boolean z16;
        View view;
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.Sb(intent);
        if (getMCoverLocalPath().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            View view2 = getView();
            if (view2 != null) {
                view = view2.findViewById(R.id.ykr);
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            Ch().setVisibility(0);
            this.mUserSelectedCover = true;
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Sh(int pushType) {
        Ni().dismiss();
        super.Sh(pushType);
        finishActivityJudgePadWithoutAnim();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Wh() {
        super.Wh();
        Ni().show();
        Xh("0", 2, this.mProgramInfo);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void d6() {
        super.d6();
        QLog.i("QGL.LiveProgramReadyFragment", 1, "onUnSelected");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.f168120ex2;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        Mh().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveProgramReadyFragment.Pi(LiveProgramReadyFragment.this, (Boolean) obj);
            }
        });
        Bh().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveProgramReadyFragment.Qi(LiveProgramReadyFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        fi(view, 3);
        ei(view);
        View findViewById = view.findViewById(R.id.f165551wm1);
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        guildDTReportApiImpl.setElementExposureAndClickParams(findViewById, "em_sgrp_stream_add_show", null);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveProgramReadyFragment.Ri(LiveProgramReadyFragment.this, view2);
            }
        });
        View findViewById2 = view.findViewById(R.id.f165555wn0);
        guildDTReportApiImpl.setElementExposureAndClickParams(findViewById2, "em_sgrp_stream_refresh_button", null);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveProgramReadyFragment.Si(LiveProgramReadyFragment.this, view2);
            }
        });
        View findViewById3 = view.findViewById(R.id.wnr);
        guildDTReportApiImpl.setElementExposureAndClickParams(findViewById3, "em_sgrp_stream_change_show", null);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveProgramReadyFragment.Ti(LiveProgramReadyFragment.this, view2);
            }
        });
        view.findViewById(R.id.ykr).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveProgramReadyFragment.Ui(LiveProgramReadyFragment.this, view2);
            }
        });
        View findViewById4 = view.findViewById(R.id.f89194z4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.stream_source_info_bar)");
        this.mVideoSourceInfoBar = (GuildLiveProgramSourceBarLayout) findViewById4;
        GLiveChannelCore.f226698a.m().d(GuildLivePlayerTag.LIVE_PROGRAM_READY, this);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onCurrentLoopEnd() {
        j.a.a(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QGL.LiveProgramReadyFragment", 1, "onDestroy.");
        GLiveChannelCore.f226698a.m().b(GuildLivePlayerTag.LIVE_PROGRAM_READY);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.i("QGL.LiveProgramReadyFragment", 1, "onDestroyView.");
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onError() {
        ViewParent viewParent;
        QLog.e("QGL.LiveProgramReadyFragment", 1, "onError.");
        this.mPlayStreamUrlSuccess = false;
        Wi(false);
        Vi(true);
        View view = this.mVideoView;
        ViewGroup viewGroup = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this.mVideoView);
        }
        aj();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        GLiveChannelCore.f226698a.m().b(GuildLivePlayerTag.LIVE_PROGRAM_READY);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onFirstFrameCome() {
        QLog.i("QGL.LiveProgramReadyFragment", 1, "onFirstFrameCome.");
        this.mPlayStreamUrlSuccess = true;
        Vi(false);
        Wi(false);
        aj();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void onSelected(boolean isFirstCreate) {
        super.onSelected(isFirstCreate);
        QLog.i("QGL.LiveProgramReadyFragment", 1, "onSelected, isFirstCreate[" + isFirstCreate + "]");
        LiveReadyBaseFrag.INSTANCE.a(2);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onVideoSizeChanged(int i3, int i16) {
        j.a.c(this, i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void vi() {
        TextView Gh = Gh();
        String qqStr = HardCodeUtil.qqStr(R.string.f148220z0);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_live_protocol)");
        String mProtocolText = this.mProtocolText;
        Intrinsics.checkNotNullExpressionValue(mProtocolText, "mProtocolText");
        Gh.setText(yh(qqStr, mProtocolText, "https://qun.qq.com/guild/h5/static-pages/index.html?pageId=liveLicense"));
        Gh().setMovementMethod(LinkMovementMethod.getInstance());
        Gh().setHighlightColor(0);
    }
}
