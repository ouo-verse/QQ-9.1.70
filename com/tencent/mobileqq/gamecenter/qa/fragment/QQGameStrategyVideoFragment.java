package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.qa.view.bv;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyVideoFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/ViewGroup;", "contentView", "", "xh", "", "yh", "wh", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/gamecenter/qa/view/bv;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/gamecenter/qa/view/bv;", "videoDelegate", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "tvProgressTime", "E", "tvTotalTime", "Landroid/widget/SeekBar;", UserInfo.SEX_FEMALE, "Landroid/widget/SeekBar;", "seekBar", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "operatorBtn", "Landroid/widget/RelativeLayout;", "H", "Landroid/widget/RelativeLayout;", "rlContent", "I", "ivVideoPlay", "Ljava/lang/Runnable;", "J", "Ljava/lang/Runnable;", "mProgressChecker", "<init>", "()V", "K", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQGameStrategyVideoFragment extends QPublicBaseFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private bv videoDelegate;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView tvProgressTime;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView tvTotalTime;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private SeekBar seekBar;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView operatorBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout rlContent;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView ivVideoPlay;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Runnable mProgressChecker = new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyVideoFragment$mProgressChecker$1
        @Override // java.lang.Runnable
        public void run() {
            TextView textView;
            TextView textView2;
            boolean yh5;
            ImageView imageView;
            ImageView imageView2;
            ImageView imageView3;
            ImageView imageView4;
            SeekBar seekBar;
            bv bvVar = QQGameStrategyVideoFragment.this.videoDelegate;
            if (bvVar != null) {
                QQGameStrategyVideoFragment qQGameStrategyVideoFragment = QQGameStrategyVideoFragment.this;
                long c16 = bvVar.c();
                textView = qQGameStrategyVideoFragment.tvProgressTime;
                if (textView != null) {
                    textView.setText(com.tencent.richmediabrowser.utils.a.b(c16));
                }
                long d16 = bvVar.d();
                if (d16 < 1000 && d16 != 0) {
                    d16 = 1000;
                }
                textView2 = qQGameStrategyVideoFragment.tvTotalTime;
                if (textView2 != null) {
                    textView2.setText(com.tencent.richmediabrowser.utils.a.b(d16));
                }
                if (d16 != 0) {
                    int i3 = (int) (((((float) c16) * 1.0f) / ((float) d16)) * 10000);
                    seekBar = qQGameStrategyVideoFragment.seekBar;
                    if (seekBar != null) {
                        seekBar.setProgress(i3);
                    }
                }
                yh5 = qQGameStrategyVideoFragment.yh();
                if (!yh5) {
                    imageView3 = qQGameStrategyVideoFragment.operatorBtn;
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.drawable.f9n);
                    }
                    imageView4 = qQGameStrategyVideoFragment.ivVideoPlay;
                    if (imageView4 != null) {
                        imageView4.setVisibility(0);
                    }
                } else {
                    imageView = qQGameStrategyVideoFragment.operatorBtn;
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.f9o);
                    }
                    imageView2 = qQGameStrategyVideoFragment.ivVideoPlay;
                    if (imageView2 != null) {
                        imageView2.setVisibility(4);
                    }
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(this, 100L);
            }
        }
    };

    private final void wh() {
        if (!yh()) {
            bv bvVar = this.videoDelegate;
            if (bvVar != null) {
                bvVar.k();
                return;
            }
            return;
        }
        bv bvVar2 = this.videoDelegate;
        if (bvVar2 != null) {
            bvVar2.i();
        }
    }

    private final void xh(ViewGroup contentView) {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("intent_key_video_url");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            QLog.e(QPublicBaseFragment.TAG, 1, "videoUrl is empty");
            return;
        }
        bv bvVar = new bv((ViewGroup) contentView.findViewById(R.id.f760840p));
        this.videoDelegate = bvVar;
        Intrinsics.checkNotNull(str);
        bvVar.m(str);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mProgressChecker, 100L);
        ((ImageView) contentView.findViewById(R.id.cq7)).setOnClickListener(this);
        ImageView imageView = (ImageView) contentView.findViewById(R.id.fff);
        this.operatorBtn = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.tvProgressTime = (TextView) contentView.findViewById(R.id.g1m);
        this.tvTotalTime = (TextView) contentView.findViewById(R.id.jut);
        SeekBar seekBar = (SeekBar) contentView.findViewById(R.id.ilh);
        this.seekBar = seekBar;
        if (seekBar != null) {
            seekBar.setMax(10000);
        }
        SeekBar seekBar2 = this.seekBar;
        if (seekBar2 != null) {
            seekBar2.setOnSeekBarChangeListener(new b());
        }
        RelativeLayout relativeLayout = (RelativeLayout) contentView.findViewById(R.id.f166799ic3);
        this.rlContent = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
        this.ivVideoPlay = (ImageView) contentView.findViewById(R.id.dyu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean yh() {
        bv bvVar = this.videoDelegate;
        if (bvVar == null) {
            return false;
        }
        Intrinsics.checkNotNull(bvVar);
        return bvVar.f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.cq7) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            boolean z16 = true;
            if ((num == null || num.intValue() != R.id.fff) && (num == null || num.intValue() != R.id.f166799ic3)) {
                z16 = false;
            }
            if (z16) {
                wh();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ec9, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        xh(viewGroup);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        bv bvVar = this.videoDelegate;
        if (bvVar != null) {
            bvVar.j();
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mProgressChecker);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        bv bvVar = this.videoDelegate;
        if (bvVar != null) {
            bvVar.i();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        bv bvVar = this.videoDelegate;
        if (bvVar != null) {
            bvVar.k();
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QBaseActivity) activity);
        if (systemBarComp != null) {
            systemBarComp.setStatusBarVisible(2, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/fragment/QQGameStrategyVideoFragment$b", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int progress, boolean fromUser) {
            bv bvVar;
            if (fromUser && (bvVar = QQGameStrategyVideoFragment.this.videoDelegate) != null) {
                bvVar.l((progress * 1.0f) / 10000);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
        }
    }
}
