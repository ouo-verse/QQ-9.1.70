package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishBubbleViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishSettingItemState;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.panorama.util.PanoramaConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u001c\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R#\u0010!\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R#\u0010&\u001a\n \u001c*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R#\u0010+\u001a\n \u001c*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00101R\u0018\u0010:\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0018\u0010<\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0014\u0010?\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R#\u0010C\u001a\n \u001c*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010\u001e\u001a\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishTroopPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "", "initViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTroopViewModel$b;", "it", "W9", "Landroid/view/View;", "anchor", "U9", "R9", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "B9", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "M9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "partStateViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTroopViewModel;", "e", "O9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTroopViewModel;", "troopViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "f", "N9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "publishViewModel", tl.h.F, "Landroid/view/View;", "troopLayout", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "troopTitle", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "troopIcon", BdhLogUtil.LogTag.Tag_Conn, "troopName", "D", "troopRemove", "E", "troopRightIcon", UserInfo.SEX_FEMALE, "I", "troopIconSize", "G", "L9", "()Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, "<init>", "()V", "H", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishTroopPart extends j {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView troopName;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView troopRemove;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView troopRightIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private final int troopIconSize;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy currentUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy partStateViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy publishViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View troopLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView troopTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView troopIcon;

    public PublishTroopPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PartsStateViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTroopPart$partStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PartsStateViewModel invoke() {
                return (PartsStateViewModel) PublishTroopPart.this.getViewModel(PartsStateViewModel.class);
            }
        });
        this.partStateViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PublishTroopViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTroopPart$troopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishTroopViewModel invoke() {
                return (PublishTroopViewModel) PublishTroopPart.this.getViewModel(PublishTroopViewModel.class);
            }
        });
        this.troopViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PublishViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTroopPart$publishViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishViewModel invoke() {
                return (PublishViewModel) PublishTroopPart.this.getViewModel(PublishViewModel.class);
            }
        });
        this.publishViewModel = lazy3;
        this.troopIconSize = ViewExKt.d(24);
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTroopPart$currentUin$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return com.tencent.mobileqq.wink.b.b().getCurrentAccountUin();
            }
        });
        this.currentUin = lazy4;
    }

    private final String L9() {
        return (String) this.currentUin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PartsStateViewModel M9() {
        return (PartsStateViewModel) this.partStateViewModel.getValue();
    }

    private final PublishViewModel N9() {
        return (PublishViewModel) this.publishViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PublishTroopViewModel O9() {
        return (PublishTroopViewModel) this.troopViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R9() {
        PublishSettingItemState value = O9().b2().getValue();
        boolean z16 = false;
        if (value != null && value.getSelectable()) {
            z16 = true;
        }
        if (!z16) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            com.tencent.mobileqq.wink.publish.util.f.a(context, M9().k2());
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(getActivity(), "com.tencent.biz.qqcircle.activity.QCircleFragmentActivity");
        intent.putExtra("public_fragment_class", "com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedBindQQGroupFragment");
        intent.putExtra("uin", L9());
        PublishTroopViewModel.TroopInfo value2 = O9().c2().getValue();
        if (value2 != null) {
            intent.putExtra("troop_id", value2.getTroopId());
        }
        getActivity().startActivityForResult(intent, 200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(PublishTroopPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PublishTroopViewModel troopViewModel = this$0.O9();
        Intrinsics.checkNotNullExpressionValue(troopViewModel, "troopViewModel");
        PublishTroopViewModel.i2(troopViewModel, 0L, null, null, 6, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(PublishTroopPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void U9(final View anchor) {
        if (!PublishBubbleViewModel.INSTANCE.h()) {
            return;
        }
        anchor.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.bx
            @Override // java.lang.Runnable
            public final void run() {
                PublishTroopPart.V9(PublishTroopPart.this, anchor);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(PublishTroopPart this$0, View anchor) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anchor, "$anchor");
        QUIDefaultBubbleTip.r(this$0.getContext()).S(anchor).k0(3).R(0).o0("\u4f5c\u54c1\u5c55\u793aQQ\u7fa4\uff0c\u4e0e\u7c89\u4e1d\u66f4\u597d\u4e92\u52a8").m0(3).f0(false).f(new b()).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(PublishTroopViewModel.TroopInfo it) {
        if (it.getTroopId() == 0) {
            N9().G0 = null;
            M9().T2(false);
            ImageView imageView = this.troopIcon;
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            TextView textView = this.troopName;
            if (textView != null) {
                textView.setText("");
            }
            ImageView imageView2 = this.troopRemove;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
                return;
            }
            return;
        }
        N9().G0 = it;
        M9().T2(true);
        ImageView imageView3 = this.troopIcon;
        if (imageView3 != null) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(it.getTroopIconUrl()).setTargetView(imageView3).setRequestWidth(this.troopIconSize).setRequestHeight(this.troopIconSize));
        }
        ImageView imageView4 = this.troopRemove;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        TextView textView2 = this.troopName;
        if (textView2 != null) {
            textView2.setText(it.getTroopName());
        }
        TextView textView3 = this.troopName;
        if (textView3 != null) {
            textView3.requestLayout();
        }
    }

    private final void initViewModel() {
        O9().d2(N9().H);
        O9().f2(M9().m2());
        LiveData<PublishSettingItemState> b26 = O9().b2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<PublishSettingItemState, Unit> function1 = new Function1<PublishSettingItemState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTroopPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItemState publishSettingItemState) {
                invoke2(publishSettingItemState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItemState publishSettingItemState) {
                PartsStateViewModel M9;
                TextView textView;
                TextView textView2;
                PublishTroopViewModel O9;
                if (publishSettingItemState.getVisible()) {
                    PublishBubbleViewModel.INSTANCE.j();
                    M9 = PublishTroopPart.this.M9();
                    M9.U2();
                    PublishTroopPart.this.startInit();
                    if (publishSettingItemState.getSelectable()) {
                        textView2 = PublishTroopPart.this.troopTitle;
                        if (textView2 != null) {
                            textView2.setTextColor(ie0.a.f().g(PublishTroopPart.this.getContext(), R.color.qui_common_text_primary, 1000));
                        }
                        O9 = PublishTroopPart.this.O9();
                        PublishTroopViewModel.TroopInfo value = O9.c2().getValue();
                        if (value != null) {
                            PublishTroopPart.this.W9(value);
                            return;
                        }
                        return;
                    }
                    textView = PublishTroopPart.this.troopTitle;
                    if (textView != null) {
                        textView.setTextColor(ie0.a.f().g(PublishTroopPart.this.getContext(), R.color.qui_common_text_secondary, 1000));
                    }
                }
            }
        };
        b26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bt
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishTroopPart.P9(Function1.this, obj);
            }
        });
        LiveData<PublishTroopViewModel.TroopInfo> c26 = O9().c2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<PublishTroopViewModel.TroopInfo, Unit> function12 = new Function1<PublishTroopViewModel.TroopInfo, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTroopPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishTroopViewModel.TroopInfo troopInfo) {
                invoke2(troopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishTroopViewModel.TroopInfo it) {
                PublishTroopPart publishTroopPart = PublishTroopPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                publishTroopPart.W9(it);
            }
        };
        c26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bu
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishTroopPart.Q9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishTroopPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f29290l9;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == -1 && data != null) {
            O9().h2(data.getLongExtra("troop_id", 0L), data.getStringExtra("troop_name"), data.getStringExtra("troop_avatar_url"));
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f29290l9);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById.findViewById(R.id.f29280l8);
            Intrinsics.checkNotNullExpressionValue(textView, "this");
            U9(textView);
            this.troopTitle = textView;
            this.troopIcon = (ImageView) findViewById.findViewById(R.id.f29240l4);
            this.troopName = (TextView) findViewById.findViewById(R.id.f29250l5);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.f29260l6);
            imageView.setVisibility(4);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.bv
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishTroopPart.S9(PublishTroopPart.this, view);
                }
            });
            this.troopRemove = imageView;
            this.troopRightIcon = (ImageView) findViewById.findViewById(R.id.f29270l7);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.bw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishTroopPart.T9(PublishTroopPart.this, view);
                }
            });
            VideoReport.setElementId(findViewById, WinkDaTongReportConstant.ElementId.EM_XSJ_BIND_QQ_GROUP_BUTTON);
            VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_ALL);
        } else {
            findViewById = null;
        }
        this.troopLayout = findViewById;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        initViewModel();
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/publish/part/PublishTroopPart$b", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements a.b {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            PublishBubbleViewModel.INSTANCE.k();
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
        }
    }
}
