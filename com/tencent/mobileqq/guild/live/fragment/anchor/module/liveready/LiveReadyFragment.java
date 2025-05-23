package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.anchor.GLiveRoomInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ff;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.FileReaderHelper;
import com.tenpay.sdk.QWalletFakeUrl;
import e12.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 w2\u00020\u0001:\u0001xB\u0007\u00a2\u0006\u0004\bu\u0010vJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J-\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0006H\u0014J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0014J\b\u0010%\u001a\u00020\u0004H\u0014J\u001a\u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0006H\u0016J$\u00101\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\u0002H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0002H\u0016J\b\u0010<\u001a\u00020\u0004H\u0016J\b\u0010=\u001a\u00020\u0004H\u0016R\u0017\u0010C\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010FR\"\u0010b\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b]\u0010Y\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010j\u001a\n g*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\"\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020c0k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u001b\u0010t\u001a\u00020o8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\u00a8\u0006y"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag;", "", NodeProps.VISIBLE, "", "Pi", "", "startLiveState", "Yi", "(Ljava/lang/Integer;)V", "ij", "hasStreamInfo", "hj", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPrepare;", "it", "Ni", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "pushInfo", "Ri", "thirdPushChecked", "protocolChecked", QWalletFakeUrl.FAKEURL_PARAM_FILL_NAME, "gj", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Mi", "", FileReaderHelper.TXT_EXT, "Ti", "Si", "fj", "Xi", "Ui", "Qi", "getLayoutId", "Landroid/view/View;", "view", "initView", "initLiveDataObserver", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "di", "vi", "pushType", "Sh", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "errMsg", "Rh", "v", NodeProps.ON_CLICK, "isWrapContent", "Ai", "Wh", "onDestroyView", "needImmersive", "ei", "isFirstCreate", "onSelected", "d6", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/g;", "Z", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/g;", "getMAnchorRoomMgr", "()Lcom/tencent/mobileqq/guild/live/livemanager/anchor/g;", "mAnchorRoomMgr", "Landroid/widget/TextView;", "a0", "Landroid/widget/TextView;", "mLiveSerAddr", "b0", "mLiveSecretKey", "Landroid/widget/FrameLayout;", "c0", "Landroid/widget/FrameLayout;", "mVideoPre", "Landroid/widget/ImageView;", "d0", "Landroid/widget/ImageView;", "mCopySerAddr", "e0", "mCopySecretKey", "Landroid/view/ViewGroup;", "f0", "Landroid/view/ViewGroup;", "mStreamInfoLayout", "g0", "Landroid/view/View;", "mShareLayout", "h0", "mTeachTv", "i0", "Vi", "()Landroid/view/View;", "ej", "(Landroid/view/View;)V", "mNetLoadingView", "", "j0", "J", "mRoomID", "kotlin.jvm.PlatformType", "k0", "Ljava/lang/String;", "mProtocolText", "Lkotlin/Pair;", "l0", "Lkotlin/Pair;", "mLastClipRecord", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "m0", "Lkotlin/Lazy;", "Wi", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mStartLiveDialog", "<init>", "()V", "n0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveReadyFragment extends LiveReadyBaseFrag {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private TextView mLiveSerAddr;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TextView mLiveSecretKey;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mVideoPre;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ImageView mCopySerAddr;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ImageView mCopySecretKey;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mStreamInfoLayout;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private View mShareLayout;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private TextView mTeachTv;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    public View mNetLoadingView;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private long mRoomID;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mStartLiveDialog;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.live.livemanager.anchor.g mAnchorRoomMgr = GLiveChannelCore.f226698a.n();

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final String mProtocolText = HardCodeUtil.qqStr(R.string.f148240z2);

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<String, Long> mLastClipRecord = new Pair<>("", 0L);

    public LiveReadyFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQProgressDialog>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment$mStartLiveDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQProgressDialog invoke() {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(LiveReadyFragment.this.getContext());
                qQProgressDialog.setCanceledOnTouchOutside(false);
                qQProgressDialog.setCancelable(false);
                return qQProgressDialog;
            }
        });
        this.mStartLiveDialog = lazy;
    }

    private final void Mi() {
        View x16 = this.mAnchorRoomMgr.x();
        if (x16.getParent() != null && (x16.getParent() instanceof ViewGroup)) {
            QLog.d("QGL.LiveReadyFragment", 1, "preView.parent is ViewGroup remove");
            ViewParent parent = x16.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(x16);
        }
        FrameLayout frameLayout = this.mVideoPre;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPre");
            frameLayout = null;
        }
        frameLayout.addView(x16);
    }

    private final void Ni(QQLiveAnchorDataPrepare it) {
        if (it != null && it.isSuccess) {
            QLog.d("QGL.LiveReadyFragment", 1, "anchorPrepareRoom suc");
            this.mAnchorRoomMgr.g(0);
            QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = it.roomInfo;
            if (qQLiveAnchorDataRoomInfo == null) {
                QLog.d("QGL.LiveReadyFragment", 1, "configRoomInfo it.roomInfo = null");
                return;
            }
            this.mRoomID = qQLiveAnchorDataRoomInfo.f271212id;
            e12.e<ff> A = GLiveChannelCore.f226698a.t().A();
            Intrinsics.checkNotNullExpressionValue(A, "GLiveChannelCore.uiData.pushLiveRoomInfo");
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            e12.d.c(A, viewLifecycleOwner, new Function1<ff, Unit>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment$anchorRoomHasPrepared$1
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
                    LiveReadyFragment.this.Eh().setText(ffVar.a());
                    LiveReadyFragment.this.Ei(ffVar.a());
                    if (TextUtils.isEmpty(ffVar.getCoverUrl())) {
                        LiveReadyFragment.this.Ch().setImageDrawable(LiveReadyFragment.this.Ph());
                    } else {
                        com.tencent.mobileqq.guild.u.q(ffVar.getCoverUrl(), LiveReadyFragment.this.Ch(), true);
                    }
                }
            });
            this.mAnchorRoomMgr.y().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LiveReadyFragment.Oi(LiveReadyFragment.this, (QQLiveAnchorDataPushInfo) obj);
                }
            });
            return;
        }
        QLog.d("QGL.LiveReadyFragment", 1, "anchorPrepareRoom it == null or it.isSuccess = false");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(LiveReadyFragment this$0, QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ri(qQLiveAnchorDataPushInfo);
    }

    private final void Pi(boolean visible) {
        if (visible) {
            Vi().setVisibility(0);
        } else {
            Vi().setVisibility(8);
        }
    }

    private final void Qi() {
        QLog.d("QGL.LiveReadyFragment", 1, "checkTeachVideo");
        cx.c(getContext(), URLUtil.guessUrl("https://qun.qq.com/vision/liveguide-channel/index.html"), getGuildId());
    }

    private final void Ri(QQLiveAnchorDataPushInfo pushInfo) {
        if (pushInfo != null && pushInfo.isSuccess) {
            QLog.d("QGL.LiveReadyFragment", 1, "configPushInfo mLiveSecretKey: " + pushInfo.streamParam);
            TextView textView = this.mLiveSerAddr;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLiveSerAddr");
                textView = null;
            }
            textView.setText(pushInfo.serverPart);
            TextView textView3 = this.mLiveSecretKey;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLiveSecretKey");
            } else {
                textView2 = textView3;
            }
            textView2.setText(pushInfo.streamParam);
            Mi();
            return;
        }
        QLog.d("QGL.LiveReadyFragment", 1, "configPushInfo pushInfo = null or pushInfo.isSuccess = false");
    }

    private final boolean Si() {
        TextView textView = this.mLiveSerAddr;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLiveSerAddr");
            textView = null;
        }
        return TextUtils.isEmpty(textView.getText().toString());
    }

    private final void Ti(String txt) {
        if (!Si() && !com.tencent.mobileqq.guild.util.o.c(txt)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!Intrinsics.areEqual(this.mLastClipRecord.getFirst(), txt) || Intrinsics.compare(this.mLastClipRecord.getSecond().longValue(), currentTimeMillis - 10000) < 0) {
                this.mLastClipRecord = new Pair<>(txt, Long.valueOf(currentTimeMillis));
                QLog.d("QGL.LiveReadyFragment", 1, "copyPlainText: accessing clipboard at " + currentTimeMillis);
                Object systemService = requireContext().getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipData newPlainText = ClipData.newPlainText("label", txt);
                Intrinsics.checkNotNullExpressionValue(newPlainText, "newPlainText(\"label\", txt)");
                ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, newPlainText);
            }
            QQToast.makeText(getContext(), R.string.f148440zl, 0).show();
        }
    }

    private final void Ui() {
        this.mAnchorRoomMgr.w();
        hi(true);
    }

    private final QQProgressDialog Wi() {
        return (QQProgressDialog) this.mStartLiveDialog.getValue();
    }

    private final String Xi() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getString(R.string.f148320z_));
        sb5.append("\uff1a");
        sb5.append("\n");
        TextView textView = this.mLiveSerAddr;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLiveSerAddr");
            textView = null;
        }
        sb5.append(textView.getText().toString());
        sb5.append("\n");
        sb5.append("\n");
        sb5.append(getString(R.string.f148310z9));
        sb5.append("\uff1a");
        sb5.append("\n");
        TextView textView3 = this.mLiveSecretKey;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLiveSecretKey");
        } else {
            textView2 = textView3;
        }
        sb5.append(textView2.getText().toString());
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "shareTxtBuilder.toString()");
        return sb6;
    }

    private final void Yi(Integer startLiveState) {
        if (startLiveState != null && startLiveState.intValue() == 2) {
            LiveReadyBaseFrag.Yh(this, String.valueOf(this.mRoomID), 0, null, 4, null);
            return;
        }
        if (startLiveState != null && startLiveState.intValue() == 0) {
            if (Wi().isShowing()) {
                Wi().dismiss();
            }
        } else if (startLiveState != null && startLiveState.intValue() == 1 && !Wi().isShowing()) {
            Wi().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zi(LiveReadyFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetworkAvailable()) {
            this$0.Pi(Intrinsics.areEqual(bool, Boolean.TRUE));
        } else {
            this$0.mAnchorRoomMgr.f226765c.setValue(Boolean.valueOf(Intrinsics.areEqual(bool, Boolean.FALSE)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aj(LiveReadyFragment this$0, QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ni(qQLiveAnchorDataPrepare);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bj(LiveReadyFragment this$0, Boolean bool, Boolean bool2, Boolean bool3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gj(bool, bool2, bool3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dj(LiveReadyFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Yi(num);
    }

    private final void fj() {
        if (Si()) {
            return;
        }
        String Xi = Xi();
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        String guildId = gLiveChannelCore.s().getGuildId();
        String channelId = gLiveChannelCore.s().getChannelId();
        if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("pindao_livepush")) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            new l02.d(requireActivity, Xi, guildId, channelId).e();
            return;
        }
        new l02.b(requireActivity(), Xi, guildId).h();
    }

    private final void gj(Boolean thirdPushChecked, Boolean protocolChecked, Boolean fillName) {
        if (QLog.isColorLevel()) {
            QLog.d("QGL.LiveReadyFragment", 2, "GuildLiveDataUtils 1. " + thirdPushChecked + " + 2. " + protocolChecked + " 3. " + fillName);
        }
        Intrinsics.checkNotNull(thirdPushChecked);
        ViewGroup viewGroup = null;
        if (thirdPushChecked.booleanValue()) {
            ViewGroup viewGroup2 = this.mStreamInfoLayout;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreamInfoLayout");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(8);
        } else {
            ViewGroup viewGroup3 = this.mStreamInfoLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreamInfoLayout");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.setVisibility(0);
        }
        hj(thirdPushChecked.booleanValue());
        if (thirdPushChecked.booleanValue()) {
            Intrinsics.checkNotNull(protocolChecked);
            if (protocolChecked.booleanValue()) {
                Intrinsics.checkNotNull(fillName);
                if (fillName.booleanValue()) {
                    Ih().setVisibility(0);
                    Jh().setVisibility(8);
                    Vi().setVisibility(8);
                }
            }
        }
        Ih().setVisibility(8);
        Jh().setVisibility(0);
        Vi().setVisibility(8);
    }

    private final void hj(boolean hasStreamInfo) {
        if (hasStreamInfo) {
            Nh().setText(HardCodeUtil.qqStr(R.string.f148410zi));
        } else {
            Nh().setText(HardCodeUtil.qqStr(R.string.f148420zj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ij() {
        if (getContext() == null) {
            return;
        }
        float f16 = (com.tencent.mobileqq.util.x.f(getContext()).f185860a * 9.0f) / 16;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cgo);
        if (f16 >= dimensionPixelSize) {
            return;
        }
        float f17 = f16 / dimensionPixelSize;
        ViewGroup viewGroup = this.mStreamInfoLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreamInfoLayout");
            viewGroup = null;
        }
        viewGroup.getLayoutParams().height = (int) f16;
        ViewGroup viewGroup2 = this.mStreamInfoLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreamInfoLayout");
            viewGroup2 = null;
        }
        int childCount = viewGroup2.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewGroup viewGroup3 = this.mStreamInfoLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreamInfoLayout");
                viewGroup3 = null;
            }
            QQGuildUIUtil.B(viewGroup3.getChildAt(i3), f17);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Ai() {
        QLog.d("QGL.LiveReadyFragment", 1, "startLive");
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
        Boolean value = this.mAnchorRoomMgr.f226765c.getValue();
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.areEqual(value, bool)) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148020yg);
            return;
        }
        if (Intrinsics.areEqual(Bh().getValue(), bool)) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148180yw);
        } else if (Intrinsics.areEqual(Mh().getValue(), bool)) {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f148010yf);
        } else {
            if (zi(0)) {
                return;
            }
            Wh();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public boolean Rh(int result, @Nullable IGProSecurityResult securityResult, @Nullable String errMsg) {
        if (Wi().isShowing()) {
            Wi().dismiss();
        }
        if (super.Rh(result, securityResult, errMsg)) {
            return true;
        }
        if (result == 22002) {
            GLiveChannelCore.f226698a.g().x0();
            finishActivityJudgePadWithoutAnim();
        }
        FrameLayout frameLayout = this.mVideoPre;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPre");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        GLiveChannelCore.f226698a.t().r0(Boolean.FALSE);
        this.mAnchorRoomMgr.w();
        return true;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Sh(int pushType) {
        LiveReadyBaseFrag.ci(this, pushType, 0, null, 6, null);
        super.Sh(pushType);
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        tq1.b t16 = gLiveChannelCore.t();
        Boolean bool = Boolean.TRUE;
        t16.r0(bool);
        gLiveChannelCore.t().c0(bool);
        this.mAnchorRoomMgr.disableViewCallback();
        FrameLayout frameLayout = this.mVideoPre;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPre");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        gLiveChannelCore.t().l0(this.mAnchorRoomMgr.x(), this.mAnchorRoomMgr);
        if (Wi() != null && Wi().isShowing()) {
            Wi().dismiss();
        }
        finishActivityJudgePadWithoutAnim();
    }

    @NotNull
    public final View Vi() {
        View view = this.mNetLoadingView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mNetLoadingView");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void Wh() {
        super.Wh();
        ai(0);
        QLog.d("QGL.LiveReadyFragment", 1, "realStartLive");
        this.mAnchorRoomMgr.e(0, new GLiveRoomInfo(Eh().getText().toString(), ""), 0, null);
        this.mAnchorRoomMgr.A();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void d6() {
        super.d6();
        QLog.d("QGL.LiveReadyFragment", 1, "onUnSelected removeObserver");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void di() {
        super.di();
        TextView textView = this.mTeachTv;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTeachTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        View view = this.mShareLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareLayout");
            view = null;
        }
        view.setOnClickListener(this);
        ImageView imageView2 = this.mCopySerAddr;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCopySerAddr");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.mCopySecretKey;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCopySecretKey");
        } else {
            imageView = imageView3;
        }
        imageView.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void ei(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.ei(view);
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        guildDTReportApiImpl.setElementExposureAndClickParams(view.findViewById(R.id.u9o), "em_stream_star_copy", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(view.findViewById(R.id.u9n), "em_stream_star_copy", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(view.findViewById(R.id.wn9), "em_stream_star_share", null);
    }

    public final void ej(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mNetLoadingView = view;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ex6;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        GLiveChannelCore.f226698a.t().x().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveReadyFragment.Zi(LiveReadyFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        View findViewById = view.findViewById(R.id.f166083ym4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.live_server_addr)");
        this.mLiveSerAddr = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f166082ym3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.live_secret_key)");
        this.mLiveSecretKey = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.u9o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.copy_server_addr)");
        this.mCopySerAddr = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.u9n);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.copy_secret_key)");
        this.mCopySecretKey = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.soy);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.anchor_pre)");
        this.mVideoPre = (FrameLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.f89164z1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.stream_info_layout)");
        this.mStreamInfoLayout = (ViewGroup) findViewById6;
        View findViewById7 = view.findViewById(R.id.wn9);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.g\u2026ive_stream_info_share_ll)");
        this.mShareLayout = findViewById7;
        View findViewById8 = view.findViewById(R.id.tvf);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.check_teach_video)");
        this.mTeachTv = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.zoy);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.net_loading)");
        ej(findViewById9);
        ViewGroup viewGroup = this.mStreamInfoLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreamInfoLayout");
            viewGroup = null;
        }
        viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.t
            @Override // java.lang.Runnable
            public final void run() {
                LiveReadyFragment.this.ij();
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        super.onClick(v3);
        int id5 = v3.getId();
        TextView textView = null;
        if (id5 == R.id.u9o) {
            TextView textView2 = this.mLiveSerAddr;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLiveSerAddr");
            } else {
                textView = textView2;
            }
            Ti(textView.getText().toString());
        } else if (id5 == R.id.u9n) {
            TextView textView3 = this.mLiveSecretKey;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLiveSecretKey");
            } else {
                textView = textView3;
            }
            Ti(textView.getText().toString());
        } else if (id5 == R.id.wn9) {
            fj();
        } else if (id5 == R.id.tvf) {
            Qi();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QGL.LiveReadyFragment", 1, "onDestroy.");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.i("QGL.LiveReadyFragment", 1, "onDestroyView.");
        if (!getMHasExited() && !Intrinsics.areEqual(GLiveChannelCore.f226698a.t().D().getValue(), Boolean.TRUE)) {
            Ui();
        }
        FrameLayout frameLayout = this.mVideoPre;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPre");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void onSelected(boolean isFirstCreate) {
        super.onSelected(isFirstCreate);
        QLog.i("QGL.LiveReadyFragment", 1, "onSelected, isFirstCreate[" + isFirstCreate + "]");
        LiveReadyBaseFrag.INSTANCE.a(0);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        hj(false);
        this.mAnchorRoomMgr.f226767e.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveReadyFragment.aj(LiveReadyFragment.this, (QQLiveAnchorDataPrepare) obj);
            }
        });
        e12.b.c(this.mAnchorRoomMgr.f226765c, Mh(), Bh(), new b.g() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.v
            @Override // e12.b.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                Unit bj5;
                bj5 = LiveReadyFragment.bj(LiveReadyFragment.this, (Boolean) obj, (Boolean) obj2, (Boolean) obj3);
                return bj5;
            }
        }).observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveReadyFragment.cj((Unit) obj);
            }
        });
        this.mAnchorRoomMgr.f226766d.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveReadyFragment.dj(LiveReadyFragment.this, (Integer) obj);
            }
        });
        fi(view, 1);
        ei(view);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cj(Unit unit) {
    }
}
