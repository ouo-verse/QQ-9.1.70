package com.tencent.state.square.flower;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.state.VasExtensionsKt;
import com.tencent.state.decode.BitmapUtils;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.databinding.VasSquareFlowerDisplayBinding;
import com.tencent.state.square.flower.data.FlowerDisplayData;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.PlayConfig;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.square.resource.SimpleResourceManager;
import com.tencent.state.view.SquareImageView;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0002J(\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/square/flower/FlowerDisplayFragment;", "Lcom/tencent/state/square/flower/FlowerBaseFragment;", "Lcom/tencent/state/square/databinding/VasSquareFlowerDisplayBinding;", "()V", "avatarSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "getAvatarSource", "()Lcom/tencent/state/square/media/MapPlayableSource;", "flowerCount", "", "getFlowerCount", "()I", "bindProgressPanel", "", "data", "Lcom/tencent/state/square/flower/data/FlowerDisplayData;", "initSubViewBinding", "inflater", "Landroid/view/LayoutInflater;", "initView", "binding", "onDestroyView", "onFlowerDataLoaded", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "renderCurrentMedal", "medal", "Lcom/tencent/state/square/flower/data/MedalData;", "renderNextMedal", "nextMedal", "renderProgressInfo", "title", "", QQWinkConstants.TAB_SUBTITLE, "Landroid/text/Spannable;", "currentNum", "gapNum", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FlowerDisplayFragment extends FlowerBaseFragment<VasSquareFlowerDisplayBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_AVATAR_SOURCE = "key_avatar_source";
    private static final String KEY_FLOWER_COUNT = "key_flower_count";
    private static final String TAG = "FlowerDisplayFragment";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/flower/FlowerDisplayFragment$Companion;", "", "()V", "KEY_AVATAR_SOURCE", "", "KEY_FLOWER_COUNT", "TAG", "newInstance", "Lcom/tencent/state/square/flower/FlowerDisplayFragment;", "flowerCount", "", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", "from", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final FlowerDisplayFragment newInstance(int flowerCount, MapPlayableSource source, int from) {
            FlowerDisplayFragment flowerDisplayFragment = new FlowerDisplayFragment();
            flowerDisplayFragment.setArguments(VasExtensionsKt.bundleOf(TuplesKt.to(FlowerDisplayFragment.KEY_FLOWER_COUNT, Integer.valueOf(flowerCount)), TuplesKt.to(FlowerDisplayFragment.KEY_AVATAR_SOURCE, source), TuplesKt.to(FlowerBaseFragment.KEY_PAGE_SOURCE, Integer.valueOf(from))));
            return flowerDisplayFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void bindProgressPanel(FlowerDisplayData data) {
        List sortedWith;
        Object obj;
        MedalData medal = data.getMedal();
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(data.getMedalConfig(), new Comparator<T>() { // from class: com.tencent.state.square.flower.FlowerDisplayFragment$bindProgressPanel$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((MedalData) t16).getLevel()), Integer.valueOf(((MedalData) t17).getLevel()));
                return compareValues;
            }
        });
        Iterator it = sortedWith.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((MedalData) obj).getLevel() > (medal != null ? medal.getLevel() : -1)) {
                    break;
                }
            }
        }
        MedalData medalData = (MedalData) obj;
        renderCurrentMedal(medal);
        renderNextMedal(medalData);
        if (medal != null) {
            if (!(medal.getImageUrl().length() == 0)) {
                if (medalData != null) {
                    long target = medalData.getTarget() - data.getFlowerTotalNum();
                    String valueOf = String.valueOf(target);
                    SpannableString spannableString = new SpannableString("\u518d\u83b7\u5f97" + valueOf + "\u6735\u53ef\u5347\u7ea7");
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF49A5CC")), 3, valueOf.length() + 3, 33);
                    renderProgressInfo(medal.getName(), spannableString, data.getFlowerTotalNum(), target);
                    return;
                }
                renderProgressInfo(medal.getName(), new SpannableString("\u5df2\u5347\u7ea7\u5230\u6700\u9ad8\u7ea7\u52cb\u7ae0"), 1, 0L);
                return;
            }
        }
        long target2 = (medalData != null ? medalData.getTarget() : 0L) - data.getFlowerTotalNum();
        String valueOf2 = String.valueOf(target2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u518d\u83b7\u5f97");
        sb5.append(valueOf2);
        sb5.append("\u6735\u89e3\u9501");
        sb5.append(medalData != null ? medalData.getName() : null);
        SpannableString spannableString2 = new SpannableString(sb5.toString());
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FF49A5CC")), 3, valueOf2.length() + 3, 33);
        renderProgressInfo("\u79cd\u82b1\u82b1\u89e3\u9501\u52cb\u7ae0", spannableString2, data.getFlowerTotalNum(), target2);
    }

    private final MapPlayableSource getAvatarSource() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(KEY_AVATAR_SOURCE) : null;
        return (MapPlayableSource) (serializable instanceof MapPlayableSource ? serializable : null);
    }

    private final int getFlowerCount() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(KEY_FLOWER_COUNT);
        }
        return 0;
    }

    private final void initView(VasSquareFlowerDisplayBinding binding) {
        binding.flowerView.setFlowerCount(getFlowerCount());
        binding.avatar.setConfig(new AvatarAnimConfig(true, SquareMedia.INSTANCE.getCommonPlayerPool(), new PlayConfig(-1, true, null, 4, null), true));
        SquareAvatarView squareAvatarView = binding.avatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.avatar");
        new SimpleResourceManager(squareAvatarView).setAvatarResource(getAvatarSource(), new IAvatarAnimListener() { // from class: com.tencent.state.square.flower.FlowerDisplayFragment$initView$1
            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onFirstFrame() {
                SquareBaseKt.getSquareLog().i("FlowerDisplayFragment", "onFirstFrame");
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayEnd() {
                IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayError(int errorCode) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FlowerDisplayFragment", "onPlayError: errorCode=" + errorCode, null, 4, null);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayStart() {
                IAvatarAnimListener.DefaultImpls.onPlayStart(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onRemovedListener() {
                IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticFailed() {
                IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticSuccess() {
                IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void renderProgressInfo(String title, Spannable subTitle, int currentNum, long gapNum) {
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding != null && (textView2 = vasSquareFlowerDisplayBinding.medalTitle) != null) {
            textView2.setText(title);
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding2 = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding2 != null && (textView = vasSquareFlowerDisplayBinding2.medalSubTitle) != null) {
            textView.setText(subTitle);
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding3 = (VasSquareFlowerDisplayBinding) getBinding();
        ViewGroup.LayoutParams layoutParams = (vasSquareFlowerDisplayBinding3 == null || (view2 = vasSquareFlowerDisplayBinding3.medalProgressIndicator) == null) ? null : view2.getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.weight = currentNum;
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding4 = (VasSquareFlowerDisplayBinding) getBinding();
        ViewGroup.LayoutParams layoutParams3 = (vasSquareFlowerDisplayBinding4 == null || (view = vasSquareFlowerDisplayBinding4.medalProgressIndicatorEmpty) == null) ? null : view.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) (layoutParams3 instanceof LinearLayout.LayoutParams ? layoutParams3 : null);
        if (layoutParams4 != null) {
            layoutParams4.weight = (float) gapNum;
        }
    }

    @Override // com.tencent.state.square.flower.FlowerBaseFragment, com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SquareAvatarView squareAvatarView;
        super.onDestroyView();
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding == null || (squareAvatarView = vasSquareFlowerDisplayBinding.avatar) == null) {
            return;
        }
        squareAvatarView.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.flower.FlowerBaseFragment
    public void onFlowerDataLoaded(FlowerDisplayData data) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(data, "data");
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding != null && (textView2 = vasSquareFlowerDisplayBinding.todayCount) != null) {
            textView2.setText(String.valueOf(data.getFlowerTodayNum()));
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding2 = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding2 != null && (textView = vasSquareFlowerDisplayBinding2.totalCount) != null) {
            textView.setText(String.valueOf(data.getFlowerTotalNum()));
        }
        bindProgressPanel(data);
    }

    @Override // com.tencent.state.square.flower.FlowerBaseFragment, com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.square.flower.FlowerBaseFragment, com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.flower.FlowerBaseFragment, com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding != null) {
            vasSquareFlowerDisplayBinding.background.setOnClickListener(this);
            BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
            SquareImageView squareImageView = vasSquareFlowerDisplayBinding.background;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.background");
            bitmapUtils.setImageSource(squareImageView, FlowerManager.FLOWER_BACKGROUND_IMAGE_URL, FlowerManager.INSTANCE.getBackgroundImageFile());
            initView(vasSquareFlowerDisplayBinding);
        }
    }

    @Override // com.tencent.state.square.flower.FlowerBaseFragment, com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.square.flower.FlowerBaseFragment, com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    @Override // com.tencent.state.square.flower.FloatPanelBaseFragment
    public VasSquareFlowerDisplayBinding initSubViewBinding(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareFlowerDisplayBinding inflate = VasSquareFlowerDisplayBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFlowerDisplayBinding.inflate(inflater)");
        return inflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void renderCurrentMedal(final MedalData medal) {
        SquareImageView squareImageView;
        SquareImageView squareImageView2;
        SquareImageView squareImageView3;
        if (medal == null) {
            VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding = (VasSquareFlowerDisplayBinding) getBinding();
            if (vasSquareFlowerDisplayBinding == null || (squareImageView3 = vasSquareFlowerDisplayBinding.currentMedal) == null) {
                return;
            }
            squareImageView3.setVisibility(8);
            return;
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding2 = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding2 != null && (squareImageView2 = vasSquareFlowerDisplayBinding2.currentMedal) != null) {
            squareImageView2.setVisibility(0);
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding3 = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding3 == null || (squareImageView = vasSquareFlowerDisplayBinding3.currentMedal) == null) {
            return;
        }
        squareImageView.post(new Runnable() { // from class: com.tencent.state.square.flower.FlowerDisplayFragment$renderCurrentMedal$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                ImageService.Companion companion = ImageService.INSTANCE;
                ImageLoader loader = companion.getLoader();
                if (loader != null) {
                    String imageUrl = medal.getImageUrl();
                    VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding4 = (VasSquareFlowerDisplayBinding) FlowerDisplayFragment.this.getBinding();
                    loader.displayImage(imageUrl, new ImageViewAware(vasSquareFlowerDisplayBinding4 != null ? vasSquareFlowerDisplayBinding4.currentMedal : null), companion.getUniqueImageOptions(medal.getImageUrl()), null, null, null);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void renderNextMedal(final MedalData nextMedal) {
        SquareImageView squareImageView;
        SquareImageView squareImageView2;
        SquareImageView squareImageView3;
        if (nextMedal == null) {
            VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding = (VasSquareFlowerDisplayBinding) getBinding();
            if (vasSquareFlowerDisplayBinding == null || (squareImageView3 = vasSquareFlowerDisplayBinding.nextMedal) == null) {
                return;
            }
            squareImageView3.setVisibility(8);
            return;
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding2 = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding2 != null && (squareImageView2 = vasSquareFlowerDisplayBinding2.nextMedal) != null) {
            squareImageView2.setVisibility(0);
        }
        VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding3 = (VasSquareFlowerDisplayBinding) getBinding();
        if (vasSquareFlowerDisplayBinding3 == null || (squareImageView = vasSquareFlowerDisplayBinding3.nextMedal) == null) {
            return;
        }
        squareImageView.post(new Runnable() { // from class: com.tencent.state.square.flower.FlowerDisplayFragment$renderNextMedal$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                ImageService.Companion companion = ImageService.INSTANCE;
                ImageLoader loader = companion.getLoader();
                if (loader != null) {
                    String imageUrl = nextMedal.getImageUrl();
                    VasSquareFlowerDisplayBinding vasSquareFlowerDisplayBinding4 = (VasSquareFlowerDisplayBinding) FlowerDisplayFragment.this.getBinding();
                    loader.displayImage(imageUrl, new ImageViewAware(vasSquareFlowerDisplayBinding4 != null ? vasSquareFlowerDisplayBinding4.nextMedal : null), companion.getUniqueImageOptions(nextMedal.getImageUrl()), null, null, null);
                }
            }
        });
    }
}
