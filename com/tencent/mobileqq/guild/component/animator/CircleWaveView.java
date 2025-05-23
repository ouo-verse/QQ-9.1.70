package com.tencent.mobileqq.guild.component.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.widget.TabContainer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsListener;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import kotlin.C11734b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 f2\u00020\u0001:\u0005ghijkB\u001d\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u00a2\u0006\u0004\bd\u0010eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0016\u001a\u00020\u0004J(\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0014J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0014J\b\u0010\u001f\u001a\u00020\u0004H\u0014J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0002J,\u0010&\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020\u0013H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00103\u001a\u000202H\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u00020\u0004H\u0002J\b\u0010:\u001a\u00020\u0004H\u0002R\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010<R\u0016\u0010A\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020*0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010CR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020*0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010CR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u0002050B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010CR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020.0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010KR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010CR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b[\u0010\\*\u0004\b]\u0010^\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$a;", "listener", "", tl.h.F, "u", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$WaveSize;", "size", "setWaveSize", "", "avatarSize", "setAvatarSize", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$WaveColor;", "color", "setWaveColor", "waveCountPerGroup", "Lkotlin/Function0;", "", "intervalPerGroup", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "intervalPerWave", "waveCount", "y", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;", "wavParam", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "D", "startTimeMillis", "Lcom/tencent/mobileqq/guild/component/animator/d;", "r", WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE, "t", "Landroid/animation/ValueAnimator;", "j", ReportConstant.COSTREPORT_PREFIX, "p", "", "i", DomainData.DOMAIN_NAME, "Landroid/view/View;", "l", "Landroid/graphics/drawable/GradientDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "G", "d", "I", "e", "f", "circleColor", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;", "waveParam", "", "Ljava/util/List;", "mCircleList", "mCircleCaches", "mCircleViewCaches", "Lkotlin/Lazy;", "Lkotlin/Lazy;", "animatorDelegate", "Landroid/view/animation/Interpolator;", "Landroid/view/animation/Interpolator;", "interpolator", "animationListeners", "Landroid/graphics/Path;", "H", "Landroid/graphics/Path;", "clipWavePath", "Z", "isPlayingGroupByGroup", "Ljava/lang/Runnable;", "J", "Ljava/lang/Runnable;", "nextGroupAnimationTask", "K", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$a;", "animationListenerForGroup", "o", "()Landroid/animation/ValueAnimator;", "getAnimator$delegate", "(Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView;)Ljava/lang/Object;", "animator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "L", "a", "b", "WaveColor", "c", "WaveSize", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class CircleWaveView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Circle> mCircleCaches;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<View> mCircleViewCaches;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy<ValueAnimator> animatorDelegate;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Interpolator interpolator;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<a> animationListeners;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Path clipWavePath;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isPlayingGroupByGroup;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Runnable nextGroupAnimationTask;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private a animationListenerForGroup;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int waveCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int intervalPerWave;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int avatarSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int circleColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WaveParam waveParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Circle> mCircleList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$WaveColor;", "", "color", "", "(Ljava/lang/String;II)V", "getColor$qqguild_component_release", "()I", TabContainer.Tab.MALE, TabContainer.Tab.FEMALE, "WHITE", "qqguild-component_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public enum WaveColor {
        MALE(Color.parseColor("#00B7FF")),
        FEMALE(Color.parseColor("#FF79D1")),
        WHITE(Color.parseColor("#FFFFFF"));

        private final int color;

        WaveColor(int i3) {
            this.color = i3;
        }

        /* renamed from: getColor$qqguild_component_release, reason: from getter */
        public final int getColor() {
            return this.color;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$WaveSize;", "", "endSizeTime", "", "(Ljava/lang/String;IF)V", "getEndSizeTime$qqguild_component_release", "()F", "SMALL", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "BIG", "qqguild-component_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public enum WaveSize {
        SMALL(0.8f),
        NORMAL(1.0f),
        BIG(1.2f);

        private final float endSizeTime;

        WaveSize(float f16) {
            this.endSizeTime = f16;
        }

        /* renamed from: getEndSizeTime$qqguild_component_release, reason: from getter */
        public final float getEndSizeTime() {
            return this.endSizeTime;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\b\b\u0080\b\u0018\u0000 !2\u00020\u0001:\u0001\nBW\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020#\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b!\u0010\u000fR\"\u0010(\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010$\u001a\u0004\b\n\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "g", "()F", "setStartSizeRate", "(F)V", "startSizeRate", "b", "c", "setEndSizeRate", "endSizeRate", tl.h.F, "setStartStrokeRate", "startStrokeRate", "d", "e", "setEndStrokeRate", "endStrokeRate", "f", "setStartAlphaRate", "startAlphaRate", "setEndAlphaRate", "endAlphaRate", "i", "endSizeTime", "", "J", "()J", "setDuration", "(J)V", "duration", "<init>", "(FFFFFFFJ)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.animator.CircleWaveView$c, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class WaveParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private float startSizeRate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private float endSizeRate;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private float startStrokeRate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private float endStrokeRate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private float startAlphaRate;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private float endAlphaRate;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private float endSizeTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private long duration;

        public WaveParam() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 255, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: b, reason: from getter */
        public final float getEndAlphaRate() {
            return this.endAlphaRate;
        }

        /* renamed from: c, reason: from getter */
        public final float getEndSizeRate() {
            return this.endSizeRate;
        }

        /* renamed from: d, reason: from getter */
        public final float getEndSizeTime() {
            return this.endSizeTime;
        }

        /* renamed from: e, reason: from getter */
        public final float getEndStrokeRate() {
            return this.endStrokeRate;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WaveParam)) {
                return false;
            }
            WaveParam waveParam = (WaveParam) other;
            if (Float.compare(this.startSizeRate, waveParam.startSizeRate) == 0 && Float.compare(this.endSizeRate, waveParam.endSizeRate) == 0 && Float.compare(this.startStrokeRate, waveParam.startStrokeRate) == 0 && Float.compare(this.endStrokeRate, waveParam.endStrokeRate) == 0 && Float.compare(this.startAlphaRate, waveParam.startAlphaRate) == 0 && Float.compare(this.endAlphaRate, waveParam.endAlphaRate) == 0 && Float.compare(this.endSizeTime, waveParam.endSizeTime) == 0 && this.duration == waveParam.duration) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final float getStartAlphaRate() {
            return this.startAlphaRate;
        }

        /* renamed from: g, reason: from getter */
        public final float getStartSizeRate() {
            return this.startSizeRate;
        }

        /* renamed from: h, reason: from getter */
        public final float getStartStrokeRate() {
            return this.startStrokeRate;
        }

        public int hashCode() {
            return (((((((((((((Float.floatToIntBits(this.startSizeRate) * 31) + Float.floatToIntBits(this.endSizeRate)) * 31) + Float.floatToIntBits(this.startStrokeRate)) * 31) + Float.floatToIntBits(this.endStrokeRate)) * 31) + Float.floatToIntBits(this.startAlphaRate)) * 31) + Float.floatToIntBits(this.endAlphaRate)) * 31) + Float.floatToIntBits(this.endSizeTime)) * 31) + androidx.fragment.app.a.a(this.duration);
        }

        public final void i(float f16) {
            this.endSizeTime = f16;
        }

        @NotNull
        public String toString() {
            return "WaveParam(startSizeRate=" + this.startSizeRate + ", endSizeRate=" + this.endSizeRate + ", startStrokeRate=" + this.startStrokeRate + ", endStrokeRate=" + this.endStrokeRate + ", startAlphaRate=" + this.startAlphaRate + ", endAlphaRate=" + this.endAlphaRate + ", endSizeTime=" + this.endSizeTime + ", duration=" + this.duration + ")";
        }

        public WaveParam(float f16, float f17, float f18, float f19, float f26, float f27, float f28, long j3) {
            this.startSizeRate = f16;
            this.endSizeRate = f17;
            this.startStrokeRate = f18;
            this.endStrokeRate = f19;
            this.startAlphaRate = f26;
            this.endAlphaRate = f27;
            this.endSizeTime = f28;
            this.duration = j3;
        }

        public /* synthetic */ WaveParam(float f16, float f17, float f18, float f19, float f26, float f27, float f28, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0.9f : f16, (i3 & 2) != 0 ? 1.62f : f17, (i3 & 4) != 0 ? 0.1f : f18, (i3 & 8) != 0 ? 0.0f : f19, (i3 & 16) != 0 ? 1.0f : f26, (i3 & 32) == 0 ? f27 : 0.0f, (i3 & 64) != 0 ? WaveSize.NORMAL.getEndSizeTime() : f28, (i3 & 128) != 0 ? 1000L : j3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements Animator.AnimatorListener {
        public d(CircleWaveView circleWaveView) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            Iterator it = CircleWaveView.this.animationListeners.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            Iterator it = CircleWaveView.this.animationListeners.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onAnimationStart();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/component/animator/CircleWaveView$e", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$a;", "", "onAnimationEnd", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f215560b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<Long> f215561c;

        e(int i3, Function0<Long> function0) {
            this.f215560b = i3;
            this.f215561c = function0;
        }

        @Override // com.tencent.mobileqq.guild.component.animator.CircleWaveView.a
        public void onAnimationEnd() {
            if (CircleWaveView.this.isPlayingGroupByGroup) {
                CircleWaveView.this.waveCount = this.f215560b;
                CircleWaveView circleWaveView = CircleWaveView.this;
                circleWaveView.postDelayed(circleWaveView.nextGroupAnimationTask, this.f215561c.invoke().longValue());
            }
        }

        @Override // com.tencent.mobileqq.guild.component.animator.CircleWaveView.a
        public void onAnimationStart() {
            a.C7699a.a(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleWaveView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void B(CircleWaveView circleWaveView, int i3, Function0 function0, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 3;
            }
            if ((i16 & 2) != 0) {
                function0 = new Function0<Long>() { // from class: com.tencent.mobileqq.guild.component.animator.CircleWaveView$startAnimationGroupByGroup$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Long invoke() {
                        return Long.valueOf((long) (new Random(System.currentTimeMillis()).nextDouble() * 250));
                    }
                };
            }
            circleWaveView.A(i3, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAnimationGroupByGroup");
    }

    private final void D() {
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isColorLevel()) {
            QLog.w("Guild.component.GuildWavView", 2, "stopAnimation", null);
        }
        Iterator<T> it = this.mCircleList.iterator();
        while (it.hasNext()) {
            t((Circle) it.next());
        }
        this.mCircleList.clear();
        if (this.animatorDelegate.isInitialized() && o().isRunning()) {
            o().cancel();
        }
        n();
    }

    private final void E() {
        if (!this.isPlayingGroupByGroup) {
            return;
        }
        this.isPlayingGroupByGroup = false;
        removeCallbacks(this.nextGroupAnimationTask);
        a aVar = this.animationListenerForGroup;
        if (aVar != null) {
            u(aVar);
            this.animationListenerForGroup = null;
        }
    }

    private final void F() {
        GradientDrawable gradientDrawable;
        for (View view : this.mCircleViewCaches) {
            int i3 = this.avatarSize;
            view.setLayoutParams(new FrameLayout.LayoutParams(i3, i3, 17));
            Drawable background = view.getBackground();
            if (background instanceof GradientDrawable) {
                gradientDrawable = (GradientDrawable) background;
            } else {
                gradientDrawable = null;
            }
            if (gradientDrawable == null) {
                gradientDrawable = m();
                view.setBackground(gradientDrawable);
            }
            gradientDrawable.setColor(this.circleColor);
        }
    }

    private final void G() {
        this.clipWavePath.reset();
        this.clipWavePath.addCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.avatarSize / 2.0f, Path.Direction.CW);
    }

    private final boolean i() {
        return this.mCircleList.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.component.animator.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircleWaveView.k(CircleWaveView.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofFloat, "this");
        ofFloat.addListener(new d(this));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 1f).apply {\n\u2026\n            })\n        }");
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(CircleWaveView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
    }

    private final View l() {
        final Context context = getContext();
        View view = new View(context) { // from class: com.tencent.mobileqq.guild.component.animator.CircleWaveView$createCircleView$circleView$1
            @Override // android.view.View
            public void setBackground(@Nullable Drawable background) {
                if (background == null) {
                    C11734b c11734b = C11734b.f433780a;
                    QLog.e("Guild.component.GuildWavView", 1, "\u610f\u6599\u4e4b\u5916\u7684\u573a\u666f\uff0c\u4e0d\u5e94\u8be5\u88ab\u8bbe\u7f6e\u4e3anull\uff0c\u8bf7\u68c0\u67e5", new Exception("\u4e0d\u5e94\u8be5\u88ab\u8bbe\u7f6e\u4e3anull"));
                }
                super.setBackground(background);
            }
        };
        int i3 = this.avatarSize;
        view.setLayoutParams(new FrameLayout.LayoutParams(i3, i3, 17));
        view.setBackground(m());
        addView(view);
        this.mCircleViewCaches.add(view);
        return view;
    }

    private final GradientDrawable m() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke((int) (this.avatarSize * this.waveParam.getStartStrokeRate()), this.circleColor);
        return gradientDrawable;
    }

    private final void n() {
        View l3;
        GradientDrawable gradientDrawable;
        long p16 = p();
        ListIterator<Circle> listIterator = this.mCircleList.listIterator();
        int i3 = 0;
        while (listIterator.hasNext()) {
            Circle next = listIterator.next();
            if (next.g(p16)) {
                if (next.f(p16)) {
                    listIterator.remove();
                    t(next);
                } else {
                    if (!next.getIsAnimating()) {
                        next.h(true);
                        int i16 = this.waveCount;
                        if (i16 > 0) {
                            this.waveCount = i16 - 1;
                        }
                        if (this.waveCount != 0) {
                            listIterator.add(r(this.intervalPerWave + p16));
                        }
                    }
                    if (i3 < this.mCircleViewCaches.size()) {
                        l3 = this.mCircleViewCaches.get(i3);
                    } else {
                        l3 = l();
                    }
                    Drawable background = l3.getBackground();
                    if (background instanceof GradientDrawable) {
                        gradientDrawable = (GradientDrawable) background;
                    } else {
                        gradientDrawable = null;
                    }
                    if (gradientDrawable == null) {
                        gradientDrawable = m();
                        l3.setBackground(gradientDrawable);
                    }
                    gradientDrawable.setStroke((int) (next.d(p16) * this.avatarSize), this.circleColor);
                    l3.setAlpha(next.a(p16));
                    l3.setScaleX(next.c(p16));
                    l3.setScaleY(next.c(p16));
                    l3.setVisibility(0);
                    i3++;
                }
            }
        }
        if (i3 < this.mCircleViewCaches.size()) {
            int size = this.mCircleViewCaches.size();
            while (i3 < size) {
                this.mCircleViewCaches.get(i3).setVisibility(8);
                i3++;
            }
        }
    }

    private final ValueAnimator o() {
        return this.animatorDelegate.getValue();
    }

    private final long p() {
        if (this.animatorDelegate.isInitialized()) {
            return o().getCurrentPlayTime();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(CircleWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isPlayingGroupByGroup) {
            this$0.y(this$0.intervalPerWave, this$0.waveCount);
        }
    }

    private final Circle r(long startTimeMillis) {
        Object removeFirstOrNull;
        removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(this.mCircleCaches);
        Circle circle = (Circle) removeFirstOrNull;
        if (circle != null) {
            circle.j(startTimeMillis);
            circle.k(this.waveParam);
            circle.i(this.interpolator);
            circle.h(false);
            return circle;
        }
        return new Circle(startTimeMillis, this.waveParam, this.interpolator);
    }

    private final void s() {
        if (i()) {
            D();
        }
        n();
    }

    private final void t(Circle circle) {
        this.mCircleCaches.add(circle);
    }

    private final void v(int color) {
        this.circleColor = color;
        F();
    }

    private final void w(WaveParam wavParam) {
        this.waveParam = wavParam;
    }

    private final void y(int intervalPerWave, int waveCount) {
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isColorLevel()) {
            QLog.w("Guild.component.GuildWavView", 2, QZoneJsConstants.ACTION_START_ANIMATION, null);
        }
        this.waveCount = waveCount;
        this.intervalPerWave = intervalPerWave;
        if (o().isStarted()) {
            D();
        }
        this.mCircleList.add(r(p()));
        if (!this.animatorDelegate.isInitialized() || !o().isRunning()) {
            o().start();
            if (QLog.isColorLevel()) {
                QLog.w("Guild.component.GuildWavView", 2, "startAnimation start", null);
            }
        }
    }

    private final void z(int intervalPerWave, int waveCountPerGroup, Function0<Long> intervalPerGroup) {
        this.isPlayingGroupByGroup = true;
        e eVar = new e(waveCountPerGroup, intervalPerGroup);
        h(eVar);
        this.animationListenerForGroup = eVar;
        y(intervalPerWave, waveCountPerGroup);
    }

    public final void A(int waveCountPerGroup, @NotNull Function0<Long> intervalPerGroup) {
        Intrinsics.checkNotNullParameter(intervalPerGroup, "intervalPerGroup");
        z(TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR, waveCountPerGroup, intervalPerGroup);
    }

    public final void C() {
        E();
        D();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutPath(this.clipWavePath);
            } else {
                canvas.clipPath(this.clipWavePath, Region.Op.DIFFERENCE);
            }
            super.dispatchDraw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public final void h(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.animationListeners.add(listener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!i() && this.animatorDelegate.isInitialized() && !o().isRunning()) {
            o().start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.animatorDelegate.isInitialized()) {
            o().cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        G();
    }

    public final void setAvatarSize(int avatarSize) {
        if (avatarSize == this.avatarSize) {
            return;
        }
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.GuildWavView", 2, "setAvatarSize\uff1a" + this.avatarSize + " -> " + avatarSize, (Throwable) null);
        }
        this.avatarSize = avatarSize;
        G();
        F();
    }

    public final void setWaveColor(@NotNull WaveColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        v(color.getColor());
    }

    public final void setWaveSize(@NotNull WaveSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.waveParam.i(size.getEndSizeTime());
        w(this.waveParam);
    }

    public final void u(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.animationListeners.contains(listener)) {
            this.animationListeners.remove(listener);
        }
    }

    public final void x() {
        y(this.intervalPerWave, this.waveCount);
    }

    public /* synthetic */ CircleWaveView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleWaveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy<ValueAnimator> lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.waveCount = -1;
        this.intervalPerWave = TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR;
        kotlin.g gVar = kotlin.g.f433789a;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.avatarSize = gVar.b(37.0f, resources);
        this.circleColor = WaveColor.MALE.getColor();
        this.waveParam = new WaveParam(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 255, null);
        this.mCircleList = new ArrayList();
        this.mCircleCaches = new LinkedList();
        this.mCircleViewCaches = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ValueAnimator>() { // from class: com.tencent.mobileqq.guild.component.animator.CircleWaveView$animatorDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ValueAnimator invoke() {
                ValueAnimator j3;
                j3 = CircleWaveView.this.j();
                return j3;
            }
        });
        this.animatorDelegate = lazy;
        this.interpolator = new LinearInterpolator();
        this.animationListeners = new ArrayList();
        this.clipWavePath = new Path();
        this.nextGroupAnimationTask = new Runnable() { // from class: com.tencent.mobileqq.guild.component.animator.f
            @Override // java.lang.Runnable
            public final void run() {
                CircleWaveView.q(CircleWaveView.this);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.component.b.Y);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026styleable.CircleWaveView)");
        int i3 = obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.component.b.f215622a0, -1);
        if (i3 == 0) {
            setWaveSize(WaveSize.SMALL);
        } else if (i3 == 1) {
            setWaveSize(WaveSize.NORMAL);
        } else if (i3 == 2) {
            setWaveSize(WaveSize.BIG);
        }
        setAvatarSize(obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.Z, this.avatarSize));
        obtainStyledAttributes.recycle();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$a;", "", "", "onAnimationEnd", "onAnimationStart", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();

        void onAnimationStart();

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.guild.component.animator.CircleWaveView$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C7699a {
            public static void a(@NotNull a aVar) {
            }
        }
    }
}
