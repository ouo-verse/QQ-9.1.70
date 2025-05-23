package com.tencent.mobileqq.wink.picker.core.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkAlbumListViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.view.WinkCompoundButton;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaAlbumTitleBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "arrowDown", "", "E9", "F9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkAlbumListViewModel;", "d", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkAlbumListViewModel;", "albumListViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "e", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedViewModel", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleAlbumName", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "titleAlbumIcon", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "titleLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "titleBtnLeft", BdhLogUtil.LogTag.Tag_Conn, "Z", "isArrowDown", "<init>", "()V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaAlbumTitleBarPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isArrowDown = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAlbumListViewModel albumListViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSelectedMediaViewModel selectedViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleAlbumName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView titleAlbumIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout titleLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View titleBtnLeft;

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(boolean arrowDown) {
        float f16;
        if (this.isArrowDown == arrowDown) {
            return;
        }
        this.isArrowDown = arrowDown;
        float f17 = 180.0f;
        if (arrowDown) {
            f16 = 180.0f;
        } else {
            f16 = 0.0f;
        }
        if (arrowDown) {
            f17 = 360.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f16, f17, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        ImageView imageView = this.titleAlbumIcon;
        if (imageView != null) {
            imageView.startAnimation(rotateAnimation);
        }
    }

    private final void F9() {
        TextView textView = this.titleAlbumName;
        boolean z16 = false;
        if (textView != null && textView.isSelected()) {
            z16 = true;
        }
        if (z16) {
            WinkAlbumListViewModel winkAlbumListViewModel = this.albumListViewModel;
            if (winkAlbumListViewModel != null) {
                winkAlbumListViewModel.b2();
                return;
            }
            return;
        }
        TextView textView2 = this.titleAlbumName;
        if (textView2 != null) {
            textView2.setSelected(true);
        }
        ImageView imageView = this.titleAlbumIcon;
        if (imageView != null) {
            imageView.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(WinkMediaAlbumTitleBarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this$0);
        if (b16 != null) {
            b16.onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(WinkMediaAlbumTitleBarPart this$0, View it) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.picker.report.a.j(it, WinkDaTongReportConstant.ElementId.EM_QZ_SELECT_ALBUM);
        this$0.F9();
        com.tencent.mobileqq.wink.picker.h hVar = com.tencent.mobileqq.wink.picker.h.f324861a;
        WinkSelectedMediaViewModel winkSelectedMediaViewModel = this$0.selectedViewModel;
        int i16 = 0;
        if (winkSelectedMediaViewModel != null) {
            i3 = winkSelectedMediaViewModel.X1();
        } else {
            i3 = 0;
        }
        WinkSelectedMediaViewModel winkSelectedMediaViewModel2 = this$0.selectedViewModel;
        if (winkSelectedMediaViewModel2 != null) {
            i16 = winkSelectedMediaViewModel2.W1();
        }
        hVar.f(i3, i16);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMediaAlbumTitleBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        WinkCompoundButton winkCompoundButton;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.ivTitleBtnLeft);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ivTitleBtnLeft)");
        this.titleBtnLeft = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBtnLeft");
            findViewById = null;
        }
        if (findViewById instanceof WinkCompoundButton) {
            winkCompoundButton = (WinkCompoundButton) findViewById;
        } else {
            winkCompoundButton = null;
        }
        if (winkCompoundButton != null) {
            winkCompoundButton.setForegroundResource(R.drawable.qui_close);
        }
        View view2 = this.titleBtnLeft;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBtnLeft");
        } else {
            view = view2;
        }
        com.tencent.mobileqq.wink.picker.report.a.r(view);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WinkMediaAlbumTitleBarPart.G9(WinkMediaAlbumTitleBarPart.this, view3);
            }
        });
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
        if (b16 != null) {
            this.albumListViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.c(b16);
            this.selectedViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
            WinkAlbumListViewModel winkAlbumListViewModel = this.albumListViewModel;
            Intrinsics.checkNotNull(winkAlbumListViewModel);
            LiveData<QQAlbumInfo> U1 = winkAlbumListViewModel.U1();
            LifecycleOwner viewLifecycleOwner = b16.getViewLifecycleOwner();
            final Function1<QQAlbumInfo, Unit> function1 = new Function1<QQAlbumInfo, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaAlbumTitleBarPart$onInitView$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQAlbumInfo qQAlbumInfo) {
                    invoke2(qQAlbumInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(QQAlbumInfo qQAlbumInfo) {
                    TextView textView;
                    textView = WinkMediaAlbumTitleBarPart.this.titleAlbumName;
                    if (textView == null) {
                        return;
                    }
                    textView.setText(qQAlbumInfo.name);
                }
            };
            U1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaAlbumTitleBarPart.H9(Function1.this, obj);
                }
            });
            LiveData<Boolean> T1 = winkAlbumListViewModel.T1();
            LifecycleOwner viewLifecycleOwner2 = b16.getViewLifecycleOwner();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaAlbumTitleBarPart$onInitView$2$1$2
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
                public final void invoke2(Boolean bool) {
                    WinkMediaAlbumTitleBarPart.this.E9(!bool.booleanValue());
                }
            };
            T1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaAlbumTitleBarPart.I9(Function1.this, obj);
                }
            });
        }
        this.titleLayout = (LinearLayout) rootView.findViewById(R.id.jnz);
        TextView textView = (TextView) rootView.findViewById(R.id.ivTitleName);
        this.titleAlbumName = textView;
        if (textView != null) {
            textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        ImageView imageView = (ImageView) rootView.findViewById(R.id.dta);
        this.titleAlbumIcon = imageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_chevron_down);
        }
        LinearLayout linearLayout = this.titleLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WinkMediaAlbumTitleBarPart.J9(WinkMediaAlbumTitleBarPart.this, view3);
                }
            });
        }
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        z93.e h16 = Wink.INSTANCE.h();
        if (h16 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            z16 = h16.a(context);
        } else {
            z16 = false;
        }
        if (z16) {
            LinearLayout linearLayout = this.titleLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.titleLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(4);
        }
    }
}
