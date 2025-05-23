package cooperation.vip.ad;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.vip.ad.GrowHalfLayerTechReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\t*\u0001E\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0014J\b\u0010\u001b\u001a\u00020\u000bH\u0014J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010<R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010@R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcooperation/vip/ad/GrowHalfLayerContainerFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "Bh", "contentView", "", "xh", "setFullScreen", "Ah", OcrConfig.CHINESE, "Landroid/os/Bundle;", "vh", "Lcom/tencent/hippy/qq/utils/SerializableMap;", "wh", "Hh", "Fh", "Eh", Constants.FILE_INSTANCE_STATE, "onCreateView", "onDestroyView", "doResume", "doPause", "needDispatchTouchEvent", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onBackEvent", "isWrapContent", "isAllowLandscape", "overrideFinish", "Lcom/tencent/mobileqq/widget/RoundCorneredRelativeLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/RoundCorneredRelativeLayout;", "hippyContainerConnerLayout", "D", "Landroid/view/View;", "hippyContainerView", "Landroid/view/GestureDetector;", "E", "Landroid/view/GestureDetector;", "gestureDetector", "Lcooperation/vip/ad/GrowHalfLayerInfo;", UserInfo.SEX_FEMALE, "Lcooperation/vip/ad/GrowHalfLayerInfo;", "growHalfLayerInfo", "Lcooperation/vip/ad/GrowHalfLayerTechInfo;", "G", "Lcooperation/vip/ad/GrowHalfLayerTechInfo;", "growHalfLayerTechInfo", "", "H", "I", "hippyContainerWidth", "hippyContainerHeight", "", "J", "pageStartTimestamp", "K", "Z", "handledJumpUrl", "cooperation/vip/ad/GrowHalfLayerContainerFragment$c", "L", "Lcooperation/vip/ad/GrowHalfLayerContainerFragment$c;", "simpleEventReceiver", "<init>", "()V", "M", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class GrowHalfLayerContainerFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private RoundCorneredRelativeLayout hippyContainerConnerLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private View hippyContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GestureDetector gestureDetector;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private GrowHalfLayerInfo growHalfLayerInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GrowHalfLayerTechInfo growHalfLayerTechInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private int hippyContainerWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private int hippyContainerHeight;

    /* renamed from: J, reason: from kotlin metadata */
    private long pageStartTimestamp;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean handledJumpUrl;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final c simpleEventReceiver = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"cooperation/vip/ad/GrowHalfLayerContainerFragment$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "velocityX", "velocityY", "", "onFling", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            Object obj;
            if (e26 != null && e16 != null && e26.getRawY() - e16.getRawY() > 200.0f) {
                GrowHalfLayerContainerFragment.this.requireActivity().finish();
                GrowHalfLayerTechReporter growHalfLayerTechReporter = GrowHalfLayerTechReporter.f391039a;
                GrowHalfLayerInfo growHalfLayerInfo = GrowHalfLayerContainerFragment.this.growHalfLayerInfo;
                if (growHalfLayerInfo != null) {
                    obj = Integer.valueOf(growHalfLayerInfo.getAdId());
                } else {
                    obj = "";
                }
                growHalfLayerTechReporter.a(String.valueOf(obj), GrowHalfLayerTechReporter.DismissReason.SlideClose, System.currentTimeMillis());
                return true;
            }
            return super.onFling(e16, e26, velocityX, velocityY);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"cooperation/vip/ad/GrowHalfLayerContainerFragment$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcooperation/vip/ad/VideoMessage;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public static final class c implements SimpleEventReceiver<VideoMessage> {
        c() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<VideoMessage>> getEventClass() {
            ArrayList<Class<VideoMessage>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(VideoMessage.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            int i3;
            Integer intOrNull;
            GrowHalfLayerInfo growHalfLayerInfo;
            if (event instanceof VideoMessage) {
                VideoMessage videoMessage = (VideoMessage) event;
                int i16 = videoMessage.messageCode;
                if (i16 != 1) {
                    if (i16 == 2) {
                        GrowHalfLayerInfo growHalfLayerInfo2 = GrowHalfLayerContainerFragment.this.growHalfLayerInfo;
                        if (growHalfLayerInfo2 != null) {
                            w.n(String.valueOf(growHalfLayerInfo2.getAdId()), 102, growHalfLayerInfo2.getTraceInfo(), growHalfLayerInfo2.getAdSpaceId());
                            return;
                        }
                        return;
                    }
                    String str = "";
                    if (i16 != 3) {
                        if (i16 == 6) {
                            GrowHalfLayerInfo growHalfLayerInfo3 = GrowHalfLayerContainerFragment.this.growHalfLayerInfo;
                            if (growHalfLayerInfo3 != null) {
                                String message = videoMessage.message;
                                if (message != null) {
                                    Intrinsics.checkNotNullExpressionValue(message, "message");
                                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(message);
                                    if (intOrNull != null) {
                                        i3 = intOrNull.intValue();
                                        w.n(String.valueOf(growHalfLayerInfo3.getAdId()), i3, growHalfLayerInfo3.getTraceInfo(), growHalfLayerInfo3.getAdSpaceId());
                                        return;
                                    }
                                }
                                i3 = 0;
                                w.n(String.valueOf(growHalfLayerInfo3.getAdId()), i3, growHalfLayerInfo3.getTraceInfo(), growHalfLayerInfo3.getAdSpaceId());
                                return;
                            }
                            return;
                        }
                        if (i16 == 7 && (growHalfLayerInfo = GrowHalfLayerContainerFragment.this.growHalfLayerInfo) != null) {
                            GrowHalfLayerTechReporter growHalfLayerTechReporter = GrowHalfLayerTechReporter.f391039a;
                            String valueOf = String.valueOf(growHalfLayerInfo.getAdId());
                            String message2 = videoMessage.getMessage();
                            String str2 = str;
                            if (message2 != null) {
                                Intrinsics.checkNotNullExpressionValue(message2, "event.getMessage() ?: \"\"");
                                str2 = message2;
                            }
                            growHalfLayerTechReporter.b(valueOf, str2);
                            return;
                        }
                        return;
                    }
                    FragmentActivity activity = GrowHalfLayerContainerFragment.this.getActivity();
                    if (activity != null) {
                        GrowHalfLayerContainerFragment.this.handledJumpUrl = true;
                        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                        i.h((QQAppInterface) runtime, activity, videoMessage.getMessage(), 4009);
                    }
                    GrowHalfLayerTechReporter growHalfLayerTechReporter2 = GrowHalfLayerTechReporter.f391039a;
                    GrowHalfLayerInfo growHalfLayerInfo4 = GrowHalfLayerContainerFragment.this.growHalfLayerInfo;
                    Object obj = str;
                    if (growHalfLayerInfo4 != null) {
                        obj = Integer.valueOf(growHalfLayerInfo4.getAdId());
                    }
                    growHalfLayerTechReporter2.a(String.valueOf(obj), GrowHalfLayerTechReporter.DismissReason.ContentClick, System.currentTimeMillis());
                    return;
                }
                FragmentActivity activity2 = GrowHalfLayerContainerFragment.this.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"cooperation/vip/ad/GrowHalfLayerContainerFragment$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            GrowHalfLayerContainerFragment.this.pageStartTimestamp = SystemClock.uptimeMillis();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    private final void Ah() {
        GrowHalfLayerInfo growHalfLayerInfo = this.growHalfLayerInfo;
        if (growHalfLayerInfo == null) {
            return;
        }
        int hippyHeightStrategy = growHalfLayerInfo.getHippyHeightStrategy();
        int screenWidth = ImmersiveUtils.getScreenWidth();
        this.hippyContainerWidth = screenWidth;
        if (hippyHeightStrategy != 1) {
            if (hippyHeightStrategy == 2) {
                this.hippyContainerHeight = (int) (screenWidth / growHalfLayerInfo.getHippyAspectRatio());
            }
        } else {
            this.hippyContainerHeight = LayoutAttrsKt.getDp(growHalfLayerInfo.getHippyHeight() / 2);
        }
        View view = this.hippyContainerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hippyContainerView");
            view = null;
        }
        View view3 = this.hippyContainerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hippyContainerView");
        } else {
            view2 = view3;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.width = this.hippyContainerWidth;
        layoutParams.height = this.hippyContainerHeight + ScreenUtil.getNavigationBarHeight(getContext());
        view.setLayoutParams(layoutParams);
        QLog.i("GrowHalfLayerContainerFragment", 1, "initLayerSize, strategy=" + hippyHeightStrategy + ", containerWidth=" + this.hippyContainerWidth + ", containerHeight=" + this.hippyContainerHeight + " " + ScreenUtil.getNavigationBarHeight(getContext()));
    }

    private final View Bh(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.e_4, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        TriggerRunnerKt.b(view, 1000L, new View.OnClickListener() { // from class: cooperation.vip.ad.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GrowHalfLayerContainerFragment.Ch(GrowHalfLayerContainerFragment.this, view2);
            }
        });
        View findViewById = view.findViewById(R.id.x_y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<RoundC\u2026_container_corner_layout)");
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById;
        this.hippyContainerConnerLayout = roundCorneredRelativeLayout;
        if (roundCorneredRelativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hippyContainerConnerLayout");
            roundCorneredRelativeLayout = null;
        }
        roundCorneredRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: cooperation.vip.ad.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GrowHalfLayerContainerFragment.Dh(view2);
            }
        });
        View findViewById2 = view.findViewById(R.id.x_x);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.hippy_container)");
        this.hippyContainerView = findViewById2;
        Ah();
        if (ImmersiveUtils.isSupporImmersive() != 0) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.activity.QPublicFragmentActivity");
            SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QPublicFragmentActivity) activity);
            if (systemBarComp != null) {
                systemBarComp.init();
                systemBarComp.setStatusBarMask(new PorterDuffColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP));
            }
        }
        setFullScreen();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
        GrowHalfLayerHippyFragment growHalfLayerHippyFragment = new GrowHalfLayerHippyFragment();
        growHalfLayerHippyFragment.setArguments(vh());
        beginTransaction.replace(R.id.x_x, growHalfLayerHippyFragment);
        beginTransaction.commitAllowingStateLoss();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(GrowHalfLayerContainerFragment this$0, View view) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GrowHalfLayerInfo growHalfLayerInfo = this$0.growHalfLayerInfo;
        boolean z16 = false;
        if (growHalfLayerInfo != null && growHalfLayerInfo.getClickOtherNoDismiss()) {
            z16 = true;
        }
        if (!z16) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
            GrowHalfLayerTechReporter growHalfLayerTechReporter = GrowHalfLayerTechReporter.f391039a;
            GrowHalfLayerInfo growHalfLayerInfo2 = this$0.growHalfLayerInfo;
            if (growHalfLayerInfo2 != null) {
                obj = Integer.valueOf(growHalfLayerInfo2.getAdId());
            } else {
                obj = "";
            }
            growHalfLayerTechReporter.a(String.valueOf(obj), GrowHalfLayerTechReporter.DismissReason.BackgroundClick, System.currentTimeMillis());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Eh() {
        QPublicFragmentActivity qPublicFragmentActivity;
        FragmentActivity activity = getActivity();
        if (activity instanceof QPublicFragmentActivity) {
            qPublicFragmentActivity = (QPublicFragmentActivity) activity;
        } else {
            qPublicFragmentActivity = null;
        }
        if (qPublicFragmentActivity != null) {
            qPublicFragmentActivity.superFinish();
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    private final void Fh() {
        GrowHalfLayerInfo growHalfLayerInfo;
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setFillAfter(true);
        View view = this.hippyContainerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hippyContainerView");
            view = null;
        }
        view.startAnimation(translateAnimation);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: cooperation.vip.ad.e
            @Override // java.lang.Runnable
            public final void run() {
                GrowHalfLayerContainerFragment.Gh(GrowHalfLayerContainerFragment.this);
            }
        }, 250L);
        if (this.pageStartTimestamp > 0) {
            int uptimeMillis = (int) (SystemClock.uptimeMillis() - this.pageStartTimestamp);
            GrowHalfLayerInfo growHalfLayerInfo2 = this.growHalfLayerInfo;
            if (growHalfLayerInfo2 != null) {
                w.m(String.valueOf(growHalfLayerInfo2.getAdId()), 133, uptimeMillis, growHalfLayerInfo2.getTraceInfo(), growHalfLayerInfo2.getAdSpaceId());
            }
        }
        if (!this.handledJumpUrl && (growHalfLayerInfo = this.growHalfLayerInfo) != null) {
            w.n(String.valueOf(growHalfLayerInfo.getAdId()), 122, growHalfLayerInfo.getTraceInfo(), growHalfLayerInfo.getAdSpaceId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(GrowHalfLayerContainerFragment this$0) {
        boolean z16;
        QPublicFragmentActivity qPublicFragmentActivity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 instanceof QPublicFragmentActivity) {
                qPublicFragmentActivity = (QPublicFragmentActivity) activity2;
            } else {
                qPublicFragmentActivity = null;
            }
            if (qPublicFragmentActivity != null) {
                qPublicFragmentActivity.superFinish();
            }
            FragmentActivity activity3 = this$0.getActivity();
            if (activity3 != null) {
                activity3.overridePendingTransition(0, 0);
            }
        }
    }

    private final void Hh() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setAnimationListener(new d());
        View view = this.hippyContainerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hippyContainerView");
            view = null;
        }
        view.startAnimation(translateAnimation);
    }

    private final void setFullScreen() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.getDecorView().setSystemUiVisibility(1792);
            window.setNavigationBarColor(Color.parseColor("#01000000"));
        }
    }

    private final Bundle vh() {
        Bundle bundle = new Bundle();
        GrowHalfLayerInfo growHalfLayerInfo = this.growHalfLayerInfo;
        if (growHalfLayerInfo != null) {
            bundle.putString("bundleName", growHalfLayerInfo.getHippyJsBundleName());
            bundle.putString("framework", growHalfLayerInfo.getHippyJsBundleType());
        }
        bundle.putInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, 1);
        bundle.putString("domain", FlockBaseRequest.QUN_DOMAIN);
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        bundle.putSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP, wh());
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("params", bundle);
        return bundle2;
    }

    private final SerializableMap wh() {
        JSONObject jSONObject;
        String str;
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("__VASCustomViewWidth__", String.valueOf(com.tencent.mobileqq.util.x.h(BaseApplication.context, this.hippyContainerWidth)));
        hashMap.put("__VASCustomViewHeight__", String.valueOf(com.tencent.mobileqq.util.x.h(BaseApplication.context, this.hippyContainerHeight)));
        try {
            GrowHalfLayerInfo growHalfLayerInfo = this.growHalfLayerInfo;
            if (growHalfLayerInfo == null || (str2 = growHalfLayerInfo.getAllAdJsonInfoStr()) == null) {
                str2 = "{}";
            }
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "allAdJsonInfo.keys()");
        while (keys.hasNext()) {
            Object next = keys.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) next;
            String optString = jSONObject.optString(str3);
            Intrinsics.checkNotNullExpressionValue(optString, "allAdJsonInfo.optString(key)");
            hashMap.put(str3, optString);
        }
        GrowHalfLayerTechInfo growHalfLayerTechInfo = this.growHalfLayerTechInfo;
        if (growHalfLayerTechInfo != null) {
            hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_TIANSHU_AD_ID, String.valueOf(growHalfLayerTechInfo.getAdId()));
            hashMap.put("last_load_time", String.valueOf(growHalfLayerTechInfo.getLastStartDuration()));
            hashMap.put("pre_load_start", String.valueOf(growHalfLayerTechInfo.getLoadResourceStartTime()));
            hashMap.put("pre_load_end", String.valueOf(growHalfLayerTechInfo.getLoadResourceEndTime()));
            hashMap.put("request_num", String.valueOf(growHalfLayerTechInfo.getRequestNum()));
        }
        GrowHalfLayerInfo growHalfLayerInfo2 = this.growHalfLayerInfo;
        if (growHalfLayerInfo2 == null || (str = growHalfLayerInfo2.getTraceId()) == null) {
            str = "";
        }
        hashMap.put("trace_id", str);
        QLog.i("GrowHalfLayerContainerFragment", 1, "buildHippyParamMap, data=" + hashMap);
        SerializableMap serializableMap = new SerializableMap();
        serializableMap.wrapMap(hashMap);
        return serializableMap;
    }

    private final void xh(View contentView) {
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, "pg_bas_half_screen_pop_floating_layer");
        GrowHalfLayerInfo growHalfLayerInfo = this.growHalfLayerInfo;
        if (growHalfLayerInfo != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("advertising_id", String.valueOf(growHalfLayerInfo.getAdId())), TuplesKt.to("trace_info", growHalfLayerInfo.getTraceInfo()));
            VideoReport.setPageParams(contentView, new PageParams((Map<String, ?>) mapOf));
        }
    }

    private final boolean yh() {
        GrowHalfLayerInfo growHalfLayerInfo;
        Intent intent;
        Intent intent2;
        Intent intent3;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent3 = activity.getIntent()) != null) {
            intent3.setExtrasClassLoader(GrowHalfLayerContainerFragment.class.getClassLoader());
        }
        FragmentActivity activity2 = getActivity();
        GrowHalfLayerTechInfo growHalfLayerTechInfo = null;
        if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
            growHalfLayerInfo = (GrowHalfLayerInfo) intent2.getParcelableExtra("grow_half_layer_info");
        } else {
            growHalfLayerInfo = null;
        }
        this.growHalfLayerInfo = growHalfLayerInfo;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null) {
            growHalfLayerTechInfo = (GrowHalfLayerTechInfo) intent.getParcelableExtra("grow_half_layer_tech_info");
        }
        this.growHalfLayerTechInfo = growHalfLayerTechInfo;
        if (this.growHalfLayerInfo != null) {
            return true;
        }
        return false;
    }

    private final void zh() {
        this.gestureDetector = new GestureDetector(requireActivity(), new b());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void doPause() {
        super.doPause();
        ApngImage.pauseAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void doResume() {
        super.doResume();
        ApngImage.resumeAll();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        activity.overridePendingTransition(0, 0);
        Window window = activity.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(1711276032));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View Bh;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        if (!yh()) {
            Eh();
            QLog.e("GrowHalfLayerContainerFragment", 1, "initData error finish");
            Bh = null;
        } else {
            Bh = Bh(inflater, container);
            zh();
            xh(Bh);
            Hh();
            SimpleEventBus.getInstance().registerReceiver(this.simpleEventReceiver);
            GrowHalfLayerInfo growHalfLayerInfo = this.growHalfLayerInfo;
            if (growHalfLayerInfo != null) {
                w.n(String.valueOf(growHalfLayerInfo.getAdId()), 101, growHalfLayerInfo.getTraceInfo(), growHalfLayerInfo.getAdSpaceId());
                GrowHalfLayerTechReporter.f391039a.g(growHalfLayerInfo.getTraceId(), growHalfLayerInfo.getAdId());
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, Bh);
        return Bh;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        GrowHalfLayerInfo growHalfLayerInfo = this.growHalfLayerInfo;
        if (growHalfLayerInfo != null) {
            GrowHalfLayerTechReporter.f391039a.f(growHalfLayerInfo.getTraceId(), growHalfLayerInfo.getAdId());
        }
        GrowHalfLayerHelper.f391021a.o();
        SimpleEventBus.getInstance().unRegisterReceiver(this.simpleEventReceiver);
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        Fh();
        return true;
    }
}
