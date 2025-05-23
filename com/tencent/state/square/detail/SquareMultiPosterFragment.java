package com.tencent.state.square.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.event.SquareSharePosterEvent;
import com.tencent.state.privacy.StrangerPrivacyManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasSquareStrangerPrivacyService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IShareUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.databinding.VasSquareMultiPosterFragmentBinding;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.SquareImageView;
import com.tencent.state.view.VasSquareDetailPosterView;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import ne0.a;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/detail/SquareMultiPosterFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareMultiPosterFragmentBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "ownItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "posterFile", "Ljava/io/File;", "reporter", "Lcom/tencent/state/square/IReporter;", "show", "", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "hideNick", "", "initReport", "initView", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onReceiveEvent", "event", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "resizePoster", "share", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMultiPosterFragment extends VasBaseSubFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SquareMultiPosterFragment";
    private VasSquareMultiPosterFragmentBinding binding;
    private SquareMultiMotionDetailData inviteState;
    private SquareAvatarItem ownItem;
    private File posterFile;
    private IReporter reporter;
    private boolean show = true;
    private final FastClickUtils clickUtils = new FastClickUtils(800);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/detail/SquareMultiPosterFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/tencent/state/square/detail/SquareMultiPosterFragment;", "squareAvatarItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final SquareMultiPosterFragment newInstance(SquareAvatarItem squareAvatarItem, SquareMultiMotionDetailData inviteState) {
            SquareMultiPosterFragment squareMultiPosterFragment = new SquareMultiPosterFragment();
            squareMultiPosterFragment.ownItem = squareAvatarItem;
            squareMultiPosterFragment.inviteState = inviteState;
            return squareMultiPosterFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideNick() {
        VasSquareMultiPosterFragmentBinding vasSquareMultiPosterFragmentBinding = this.binding;
        if (vasSquareMultiPosterFragmentBinding != null) {
            boolean z16 = !this.show;
            this.show = z16;
            if (z16) {
                vasSquareMultiPosterFragmentBinding.hideIc.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.iak));
                TextView textView = vasSquareMultiPosterFragmentBinding.hideTip;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.hideTip");
                textView.setText("\u9690\u85cf\u6635\u79f0");
            } else {
                vasSquareMultiPosterFragmentBinding.hideIc.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.iao));
                TextView textView2 = vasSquareMultiPosterFragmentBinding.hideTip;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.hideTip");
                textView2.setText("\u5c55\u793a\u6635\u79f0");
            }
            vasSquareMultiPosterFragmentBinding.posterView.updateNickVisible(this.show);
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                LinearLayout linearLayout = vasSquareMultiPosterFragmentBinding.hideNick;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.hideNick");
                iReporter.reportEvent("clck", linearLayout, new LinkedHashMap());
            }
        }
    }

    private final void initView() {
        final VasSquareMultiPosterFragmentBinding vasSquareMultiPosterFragmentBinding = this.binding;
        if (vasSquareMultiPosterFragmentBinding != null) {
            LinearLayout linearLayout = vasSquareMultiPosterFragmentBinding.hideNick;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.hideNick");
            SquareMultiMotionDetailData squareMultiMotionDetailData = this.inviteState;
            linearLayout.setVisibility((squareMultiMotionDetailData == null || !squareMultiMotionDetailData.isInviteSuccess()) ? 8 : 0);
            VasSquareStrangerPrivacyService.INSTANCE.getStrangerVisible(new ResultCallback<Boolean>() { // from class: com.tencent.state.square.detail.SquareMultiPosterFragment$initView$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
                    onResultSuccess(bool.booleanValue());
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    TextView textView = VasSquareMultiPosterFragmentBinding.this.title;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
                    textView.setVisibility(0);
                }

                public void onResultSuccess(boolean result) {
                    TextView textView = VasSquareMultiPosterFragmentBinding.this.title;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
                    textView.setVisibility(result ? 8 : 0);
                }
            });
        }
    }

    private final void resizePoster() {
        final VasSquareMultiPosterFragmentBinding vasSquareMultiPosterFragmentBinding = this.binding;
        if (vasSquareMultiPosterFragmentBinding != null) {
            vasSquareMultiPosterFragmentBinding.posterView.post(new Runnable() { // from class: com.tencent.state.square.detail.SquareMultiPosterFragment$resizePoster$1
                @Override // java.lang.Runnable
                public final void run() {
                    VasSquareDetailPosterView vasSquareDetailPosterView = VasSquareMultiPosterFragmentBinding.this.posterView;
                    Intrinsics.checkNotNullExpressionValue(vasSquareDetailPosterView, "binding.posterView");
                    int width = vasSquareDetailPosterView.getWidth();
                    View view = VasSquareMultiPosterFragmentBinding.this.preview;
                    Intrinsics.checkNotNullExpressionValue(view, "binding.preview");
                    int width2 = view.getWidth();
                    if (width < width2) {
                        float f16 = width2 / width;
                        VasSquareDetailPosterView vasSquareDetailPosterView2 = VasSquareMultiPosterFragmentBinding.this.posterView;
                        Intrinsics.checkNotNullExpressionValue(vasSquareDetailPosterView2, "binding.posterView");
                        vasSquareDetailPosterView2.setScaleX(f16);
                        VasSquareDetailPosterView vasSquareDetailPosterView3 = VasSquareMultiPosterFragmentBinding.this.posterView;
                        Intrinsics.checkNotNullExpressionValue(vasSquareDetailPosterView3, "binding.posterView");
                        vasSquareDetailPosterView3.setScaleY(f16);
                        return;
                    }
                    VasSquareDetailPosterView vasSquareDetailPosterView4 = VasSquareMultiPosterFragmentBinding.this.posterView;
                    Intrinsics.checkNotNullExpressionValue(vasSquareDetailPosterView4, "binding.posterView");
                    int height = vasSquareDetailPosterView4.getHeight();
                    View view2 = VasSquareMultiPosterFragmentBinding.this.preview;
                    Intrinsics.checkNotNullExpressionValue(view2, "binding.preview");
                    int height2 = view2.getHeight();
                    if (height > height2) {
                        float f17 = height2 / height;
                        VasSquareDetailPosterView vasSquareDetailPosterView5 = VasSquareMultiPosterFragmentBinding.this.posterView;
                        Intrinsics.checkNotNullExpressionValue(vasSquareDetailPosterView5, "binding.posterView");
                        vasSquareDetailPosterView5.setScaleX(f17);
                        VasSquareDetailPosterView vasSquareDetailPosterView6 = VasSquareMultiPosterFragmentBinding.this.posterView;
                        Intrinsics.checkNotNullExpressionValue(vasSquareDetailPosterView6, "binding.posterView");
                        vasSquareDetailPosterView6.setScaleY(f17);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void share() {
        Bitmap convertToBitMap;
        Map<String, Object> mutableMapOf;
        VasSquareMultiPosterFragmentBinding vasSquareMultiPosterFragmentBinding = this.binding;
        if (vasSquareMultiPosterFragmentBinding == null || (convertToBitMap = vasSquareMultiPosterFragmentBinding.posterView.convertToBitMap()) == null) {
            return;
        }
        vasSquareMultiPosterFragmentBinding.posterView.getPosterTempFile(convertToBitMap, new Function1<File, Unit>() { // from class: com.tencent.state.square.detail.SquareMultiPosterFragment$share$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(File file) {
                File file2;
                File file3;
                String str;
                Intrinsics.checkNotNullParameter(file, "file");
                SquareMultiPosterFragment.this.posterFile = file;
                file2 = SquareMultiPosterFragment.this.posterFile;
                if (file2 != null && file2.exists()) {
                    IShareUtils squareShareUtil = SquareBaseKt.getSquareShareUtil();
                    file3 = SquareMultiPosterFragment.this.posterFile;
                    if (file3 == null || (str = file3.getAbsolutePath()) == null) {
                        str = "";
                    }
                    IShareUtils.DefaultImpls.doShare$default(squareShareUtil, null, str, 0, null, null, 1, 29, null);
                    return;
                }
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareMultiPosterFragment", "file load fail", null, 4, null);
            }
        });
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            TextView textView = vasSquareMultiPosterFragmentBinding.share;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.share");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HIDE_NICK, Integer.valueOf(1 ^ (this.show ? 1 : 0))));
            iReporter.reportEvent("clck", textView, mutableMapOf);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(SquareSharePosterEvent.class);
        return arrayList;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        hideFragment(this);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareMultiPosterFragmentBinding inflate = VasSquareMultiPosterFragmentBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMultiPosterFrag\u2026 binding = this\n        }");
        RelativeLayout mContainer = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "VasSquareMultiPosterFrag\u2026ing = this\n        }.root");
        return mContainer;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        VasSquareDetailPosterView vasSquareDetailPosterView;
        super.onDestroy();
        VasSquareMultiPosterFragmentBinding vasSquareMultiPosterFragmentBinding = this.binding;
        if (vasSquareMultiPosterFragmentBinding != null && (vasSquareDetailPosterView = vasSquareMultiPosterFragmentBinding.posterView) != null) {
            vasSquareDetailPosterView.clearPosterTempFile();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        SquareBaseKt.getSquareLog().i(TAG, "[SquareSharePosterEvent] onReceiveEvent: " + event);
        if ((event instanceof SquareSharePosterEvent) && ((SquareSharePosterEvent) event).getIsShare()) {
            StrangerPrivacyManager.setStrangerVisible$default(StrangerPrivacyManager.INSTANCE, true, false, null, 4, null);
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final VasSquareMultiPosterFragmentBinding vasSquareMultiPosterFragmentBinding = this.binding;
        if (vasSquareMultiPosterFragmentBinding != null) {
            view.setClickable(true);
            Context it = getContext();
            if (it != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                SquareUtil squareUtil = SquareUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(squareUtil.getStatusBarHeight(it), ViewExtensionsKt.dip((Fragment) this, 25.0f));
                layoutParams.topMargin = coerceAtLeast;
                RelativeLayout relativeLayout = vasSquareMultiPosterFragmentBinding.titleContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.titleContainer");
                relativeLayout.setLayoutParams(layoutParams);
            }
            initReport();
            SimpleEventBus.getInstance().registerReceiver(this);
            SquareAvatarItem squareAvatarItem = this.ownItem;
            if (squareAvatarItem != null) {
                vasSquareMultiPosterFragmentBinding.posterView.bindPosterView(squareAvatarItem, this.inviteState);
            }
            vasSquareMultiPosterFragmentBinding.hideNick.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.SquareMultiPosterFragment$onViewCreated$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SquareMultiPosterFragment.this.hideNick();
                }
            });
            vasSquareMultiPosterFragmentBinding.share.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.SquareMultiPosterFragment$onViewCreated$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FastClickUtils fastClickUtils;
                    fastClickUtils = SquareMultiPosterFragment.this.clickUtils;
                    if (fastClickUtils.isFastDoubleClick()) {
                        return;
                    }
                    SquareMultiPosterFragment.this.share();
                }
            });
            vasSquareMultiPosterFragmentBinding.back.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.SquareMultiPosterFragment$onViewCreated$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    IReporter iReporter;
                    SquareMultiPosterFragment.this.onBackPressed();
                    iReporter = SquareMultiPosterFragment.this.reporter;
                    if (iReporter != null) {
                        SquareImageView squareImageView = vasSquareMultiPosterFragmentBinding.back;
                        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.back");
                        iReporter.reportEvent("clck", squareImageView, new LinkedHashMap());
                    }
                }
            });
            initView();
            resizePoster();
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    private final void initReport() {
        Map<String, Object> mutableMapOf;
        VasSquareMultiPosterFragmentBinding vasSquareMultiPosterFragmentBinding = this.binding;
        if (vasSquareMultiPosterFragmentBinding != null) {
            IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
            this.reporter = reporter;
            if (reporter != null) {
                RelativeLayout mContainer = vasSquareMultiPosterFragmentBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
                reporter.setPageInfo(this, mContainer, SquareReportConst.PageId.PAGE_ID_POSTER_SHARE, new LinkedHashMap());
            }
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                LinearLayout linearLayout = vasSquareMultiPosterFragmentBinding.hideNick;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.hideNick");
                iReporter.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_POSTER_HIDE_NICK, new LinkedHashMap(), false, false);
            }
            IReporter iReporter2 = this.reporter;
            if (iReporter2 != null) {
                TextView textView = vasSquareMultiPosterFragmentBinding.share;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.share");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HIDE_NICK, Integer.valueOf(1 ^ (this.show ? 1 : 0))));
                iReporter2.setElementInfo(textView, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, mutableMapOf, false, false);
            }
            IReporter iReporter3 = this.reporter;
            if (iReporter3 != null) {
                SquareImageView squareImageView = vasSquareMultiPosterFragmentBinding.back;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.back");
                iReporter3.setElementInfo(squareImageView, "em_zplan_back", new LinkedHashMap(), false, false);
            }
            IReporter iReporter4 = this.reporter;
            if (iReporter4 != null) {
                TextView textView2 = vasSquareMultiPosterFragmentBinding.share;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.share");
                iReporter4.reportEvent("imp", textView2, new LinkedHashMap());
            }
            IReporter iReporter5 = this.reporter;
            if (iReporter5 != null) {
                LinearLayout linearLayout2 = vasSquareMultiPosterFragmentBinding.hideNick;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.hideNick");
                iReporter5.reportEvent("imp", linearLayout2, new LinkedHashMap());
            }
            IReporter iReporter6 = this.reporter;
            if (iReporter6 != null) {
                SquareImageView squareImageView2 = vasSquareMultiPosterFragmentBinding.back;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.back");
                iReporter6.reportEvent("imp", squareImageView2, new LinkedHashMap());
            }
        }
    }
}
