package com.tencent.robot.timbre.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001LB9\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u0010-\u001a\u00020\"\u0012\u0006\u0010/\u001a\u00020\"\u0012\u0018\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000600\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J&\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R&\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u000bR\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\u000bR\u0016\u0010D\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\u000bR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/robot/timbre/setting/k;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$i;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "b0", "c0", "e0", "j0", "Z", "g0", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "Y", "Landroid/widget/ImageView;", "imageView", "p0", "l0", "k0", "", "position", "", "", "payloads", "P", "", "isSelected", "o0", QzoneWebMusicJsPlugin.EVENT_PLAYING, "n0", "i0", "", "currentSelectedTtsId", "m0", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "a0", "()Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "ttsInfo", "r", "Ljava/lang/String;", "initialSelectedTtsId", ReportConstant.COSTREPORT_PREFIX, "robotUin", "Lkotlin/Function2;", "t", "Lkotlin/jvm/functions/Function2;", "onPlayAndSelected", "Lcom/google/android/flexbox/FlexboxLayout;", "u", "Lcom/google/android/flexbox/FlexboxLayout;", "mFlexboxLayout", "v", "Landroid/widget/ImageView;", "mPlayView", "w", "isPlaying", "Lcom/tencent/image/URLDrawable;", HippyTKDListViewAdapter.X, "Lcom/tencent/image/URLDrawable;", "mPlayDrawable", "y", "isPlayOrSelectStateChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "ifFirstExposure", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "B", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k extends x<x.b.C8996b, x.c.i> {

    /* renamed from: A, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TtsInfo ttsInfo;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String initialSelectedTtsId;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<k, Boolean, Unit> onPlayAndSelected;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FlexboxLayout mFlexboxLayout;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mPlayView;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLDrawable mPlayDrawable;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayOrSelectStateChanged;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean ifFirstExposure;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k(@NotNull TtsInfo ttsInfo, @NotNull String initialSelectedTtsId, @NotNull String robotUin, @NotNull Function2<? super k, ? super Boolean, Unit> onPlayAndSelected) {
        super(new x.b.C8996b(r1, R.drawable.jtg), new x.c.i(Intrinsics.areEqual(ttsInfo.ttsId, initialSelectedTtsId), null, 2, null));
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        Intrinsics.checkNotNullParameter(initialSelectedTtsId, "initialSelectedTtsId");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(onPlayAndSelected, "onPlayAndSelected");
        String str = ttsInfo.ttsName;
        Intrinsics.checkNotNullExpressionValue(str, "ttsInfo.ttsName");
        this.ttsInfo = ttsInfo;
        this.initialSelectedTtsId = initialSelectedTtsId;
        this.robotUin = robotUin;
        this.onPlayAndSelected = onPlayAndSelected;
        this.ifFirstExposure = true;
    }

    private final ViewGroup Y(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.drawable.ljc);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(ViewUtils.dip2px(40.0f), ViewUtils.dip2px(40.0f));
        marginLayoutParams.leftMargin = ViewUtils.dip2px(12.0f);
        frameLayout.setLayoutParams(marginLayoutParams);
        return frameLayout;
    }

    private final void Z() {
        if (this.mPlayDrawable != null) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mPlayGifImage = true;
        Unit unit = Unit.INSTANCE;
        URLDrawable drawable = URLDrawable.getDrawable("https://static-res.qq.com/static-res/adelie/aio/aio_audio_playing.png", obtain);
        drawable.startDownload(true);
        this.mPlayDrawable = drawable;
    }

    private final void b0(QUISingleLineListItem view) {
        View childAt = view.getChildAt(0);
        if (childAt instanceof FlexboxLayout) {
            this.mFlexboxLayout = (FlexboxLayout) childAt;
        }
        FlexboxLayout flexboxLayout = this.mFlexboxLayout;
        if (flexboxLayout != null) {
            flexboxLayout.setClickable(true);
        }
    }

    private final void c0(QUISingleLineListItem view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f66173_x);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.timbre.setting.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k.d0(k.this, view2);
            }
        });
        if (!this.isPlaying) {
            imageView.setImageResource(R.drawable.jtg);
        } else {
            p0(imageView);
        }
        this.mPlayView = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e0() {
        O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.robot.timbre.setting.j
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                k.f0(k.this, view, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(k this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.j0();
    }

    private final void g0(QUISingleLineListItem view) {
        Boolean bool;
        Object tag = view.getTag(R.id.f923457m);
        ViewGroup viewGroup = null;
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            return;
        }
        view.setTag(R.id.f923457m, bool2);
        final View findViewById = view.findViewById(R.id.f66173_x);
        ViewParent parent = findViewById.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            ViewGroup Y = Y(context);
            Y.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.timbre.setting.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    k.h0(findViewById, view2);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dip2px(24.0f), ViewUtils.dip2px(24.0f));
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            Y.addView(findViewById, layoutParams);
            viewGroup.addView(Y, indexOfChild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        view.performClick();
        EventCollector.getInstance().onViewClicked(view2);
    }

    private final void j0() {
        if (this.isPlaying) {
            this.onPlayAndSelected.invoke(this, Boolean.TRUE);
            return;
        }
        QLog.i("RobotTimbreSettingItemConfig", 4, "onPlayAndSelectedClick: " + this.ttsInfo);
        this.onPlayAndSelected.invoke(this, Boolean.FALSE);
        k0();
    }

    private final void k0() {
        View view = this.rootView;
        if (view != null) {
            l lVar = l.f368635a;
            String str = this.initialSelectedTtsId;
            String str2 = this.ttsInfo.ttsId;
            Intrinsics.checkNotNullExpressionValue(str2, "ttsInfo.ttsId");
            lVar.a(view, str, str2);
        }
    }

    private final void l0() {
        View view = this.rootView;
        if (view != null) {
            l lVar = l.f368635a;
            String str = this.ttsInfo.ttsId;
            Intrinsics.checkNotNullExpressionValue(str, "ttsInfo.ttsId");
            lVar.b(view, str, this.initialSelectedTtsId);
        }
    }

    private final void p0(ImageView imageView) {
        Z();
        URLDrawable uRLDrawable = this.mPlayDrawable;
        if (uRLDrawable != null) {
            if (imageView != null) {
                imageView.setImageDrawable(uRLDrawable);
            }
            ApngImage.resumeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        this.rootView = view;
        g0(view);
        b0(view);
        c0(view);
        e0();
        this.isPlayOrSelectStateChanged = false;
        if (this.ifFirstExposure) {
            l0();
            this.ifFirstExposure = false;
        }
    }

    @NotNull
    /* renamed from: a0, reason: from getter */
    public final TtsInfo getTtsInfo() {
        return this.ttsInfo;
    }

    /* renamed from: i0, reason: from getter */
    public final boolean getIsPlayOrSelectStateChanged() {
        return this.isPlayOrSelectStateChanged;
    }

    public final void m0(@NotNull String currentSelectedTtsId) {
        Intrinsics.checkNotNullParameter(currentSelectedTtsId, "currentSelectedTtsId");
        View view = this.rootView;
        if (view != null) {
            l lVar = l.f368635a;
            String str = this.ttsInfo.ttsId;
            Intrinsics.checkNotNullExpressionValue(str, "ttsInfo.ttsId");
            lVar.c(view, str, currentSelectedTtsId);
        }
    }

    public final void n0(boolean playing) {
        if (this.isPlaying != playing) {
            this.isPlaying = playing;
            this.isPlayOrSelectStateChanged = true;
        }
    }

    public final void o0(boolean isSelected) {
        if (O().getIsSelected() != isSelected) {
            O().f(isSelected);
            this.isPlayOrSelectStateChanged = true;
        }
    }
}
