package com.tencent.state.square.avatar.filament;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.data.FilamentMapPlayableSource;
import com.tencent.state.square.data.MultiMotionUser;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.view.SquareImageView;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import dl0.d;
import dl0.k;
import fl0.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001c\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0001pB'\b\u0007\u0012\u0006\u0010i\u001a\u00020\\\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010j\u0012\b\b\u0002\u0010m\u001a\u00020l\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0014J\b\u0010\u001b\u001a\u00020\u0003H\u0014J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\"\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0007H\u0016J9\u0010\"\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010'JB\u0010,\u001a\u00020\u00032:\u0010+\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010(J\u001a\u0010.\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u0007H\u0016J\"\u00100\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010/\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0016J\b\u00103\u001a\u00020\u0003H\u0016J\u0014\u00104\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011J\u0016\u00105\u001a\u00020\u00032\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011J\u000e\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\t098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR \u0010U\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR \u0010W\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010VR\u0016\u0010X\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010ZR$\u0010^\u001a\u0010\u0012\f\u0012\n ]*\u0004\u0018\u00010\\0\\0[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\"\u0010`\u001a\u0010\u0012\f\u0012\n ]*\u0004\u0018\u00010B0B0[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010_RJ\u0010a\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bf\u0010g\u00a8\u0006q"}, d2 = {"Lcom/tencent/state/square/avatar/filament/SquareAvatarFilamentView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "", "initFilament", "Lcom/tencent/state/square/media/MapPlayableSource;", "source", "", "checkSourceChange", "", "data", "Lcom/tencent/state/square/avatar/filament/RenderFailReason;", "reason", "renderFailTips", "Landroid/view/View;", "view", ViewStickEventHelper.IS_SHOW, "Lkotlin/Function0;", "animationEnd", "startAlphaAnimation", "Lcom/tencent/state/square/avatar/filament/RenderResult;", "renderType", "renderFailReason", "reportFirstRender", "Lcom/tencent/state/square/data/FilamentMapPlayableSource;", "getCurrentSource", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "setImageViewVisibility", "setVideoViewVisibility", "getView", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "listener", "needAnim", "setAnimSource", "", "hostUin", "guestUin", "url", "(JLjava/lang/Long;Ljava/lang/String;Lcom/tencent/state/square/avatar/IAvatarAnimListener;Z)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cb", "setCustomRenderFailHandler", NodeProps.VISIBLE, "setStaticSource", "needCleanAll", "changeSourceWithAnim", "resume", "pause", "destroy", "setDoubleClickListener", "setTapClickListener", "Lcom/tencent/state/square/avatar/filament/IActionHelper;", "actionHelper", "setActionHelper", "", "filamentEvents", "Ljava/util/List;", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "filamentApp", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "Lcom/tencent/zplan/zplantracing/b;", "filamentSpan", "Lcom/tencent/zplan/zplantracing/b;", "Lcom/tencent/state/view/SquareImageView;", "imageView", "Lcom/tencent/state/view/SquareImageView;", "loadingView", "Landroid/widget/FrameLayout;", "startTime", "J", "initializerTime", "Ljava/lang/Long;", "playListener", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "currentSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "currentMoodConfig", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "currentPlayData", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "doubleClickListener", "Lkotlin/jvm/functions/Function0;", "tapClickListener", "isFirstFrameRendered", "Z", "Lcom/tencent/state/square/avatar/filament/IActionHelper;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "weakContext", "Ljava/lang/ref/WeakReference;", "weakImageView", "customRenderFailHandler", "Lkotlin/jvm/functions/Function2;", "com/tencent/state/square/avatar/filament/SquareAvatarFilamentView$filamentEventListener$1", "filamentEventListener", "Lcom/tencent/state/square/avatar/filament/SquareAvatarFilamentView$filamentEventListener$1;", "getTimeAfterCreate", "()J", "timeAfterCreate", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarFilamentView extends FrameLayout implements ISquareAvatarView {
    private static final int FPS = 24;
    private static final String TAG = "SquareAvatarFilamentView";
    private IActionHelper actionHelper;
    private MoodConfig currentMoodConfig;
    private SquareAvatarData currentPlayData;
    private MapPlayableSource currentSource;
    private Function2<? super String, ? super RenderFailReason, Unit> customRenderFailHandler;
    private Function0<Unit> doubleClickListener;
    private IFilamentNativeAppV2305 filamentApp;
    private final SquareAvatarFilamentView$filamentEventListener$1 filamentEventListener;
    private final List<String> filamentEvents;
    private b filamentSpan;
    private final SquareImageView imageView;
    private Long initializerTime;
    private boolean isFirstFrameRendered;
    private final FrameLayout loadingView;
    private IAvatarAnimListener playListener;
    private long startTime;
    private Function0<Unit> tapClickListener;
    private WeakReference<Context> weakContext;
    private final WeakReference<SquareImageView> weakImageView;

    public SquareAvatarFilamentView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final boolean checkSourceChange(MapPlayableSource source) {
        FilamentMapPlayableSource currentSource;
        if (!(source instanceof FilamentMapPlayableSource)) {
            source = null;
        }
        FilamentMapPlayableSource filamentMapPlayableSource = (FilamentMapPlayableSource) source;
        if (filamentMapPlayableSource == null || (currentSource = getCurrentSource()) == null) {
            return false;
        }
        if (!(!Intrinsics.areEqual(filamentMapPlayableSource.getRemoteUrl(), currentSource.getRemoteUrl())) && !(!Intrinsics.areEqual(filamentMapPlayableSource.getUin(), currentSource.getUin()))) {
            MultiMotionUser multiMotionUser = filamentMapPlayableSource.getMultiMotionUser();
            String selectUin = multiMotionUser != null ? multiMotionUser.getSelectUin() : null;
            if (!(!Intrinsics.areEqual(selectUin, currentSource.getMultiMotionUser() != null ? r2.getSelectUin() : null))) {
                return false;
            }
        }
        return true;
    }

    private final FilamentMapPlayableSource getCurrentSource() {
        MapPlayableSource mapPlayableSource = this.currentSource;
        if (!(mapPlayableSource instanceof FilamentMapPlayableSource)) {
            mapPlayableSource = null;
        }
        return (FilamentMapPlayableSource) mapPlayableSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getTimeAfterCreate() {
        return System.currentTimeMillis() - this.startTime;
    }

    private final void initFilament() {
        FilamentReportHelper.INSTANCE.markUsedFilament();
        FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a aVar = a.f399763a;
        try {
            IFilamentNativeAppV2305 c16 = FilamentRenderFactory.f105773b.c(new sk0.a(F, true, context, 24, (k) aVar.a(k.class), (d) aVar.a(d.class), null, 64, null));
            this.filamentApp = c16;
            TextureView view = c16.getView();
            addView(view, new FrameLayout.LayoutParams(-1, -1));
            view.setAlpha(0.0f);
            Iterator<T> it = this.filamentEvents.iterator();
            while (it.hasNext()) {
                c16.addEventListener((String) it.next(), this.filamentEventListener);
            }
            b bVar = this.filamentSpan;
            c16.startWithEntry(bVar != null ? bVar.c() : null, "bundle/scenes/square_avatar/main.js");
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "initFilament error", th5);
            renderFailTips(th5.toString(), RenderFailReason.INIT_FAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderFailTips(String data, RenderFailReason reason) {
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "renderFailed, err:" + data + " cost:" + getTimeAfterCreate(), null, 4, null);
        reportFirstRender(RenderResult.FAIL, reason);
        Function2<? super String, ? super RenderFailReason, Unit> function2 = this.customRenderFailHandler;
        if (function2 == null) {
            SquareBaseKt.getSquareThread().postOnUi(new SquareAvatarFilamentView$renderFailTips$1(this));
        } else if (function2 != null) {
            function2.invoke(data, reason);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportFirstRender(RenderResult renderType, RenderFailReason renderFailReason) {
        String str;
        String str2;
        String str3;
        Map<String, Object> mutableMapOf;
        SquareAvatarData.AvatarData host;
        SquareAvatarData squareAvatarData = this.currentPlayData;
        if (squareAvatarData != null && (host = squareAvatarData.getHost()) != null && CommonDataKt.isMe(host.getUin())) {
            str = SquareReportConst.PageId.PAGE_ID_HOST_DETAIL;
        } else {
            str = SquareReportConst.PageId.PAGE_ID_CUSTOM_DETAIL;
        }
        Long l3 = this.initializerTime;
        if (l3 != null) {
            long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
            boolean isFirstFilamentAfterInstall = FilamentReportHelper.INSTANCE.isFirstFilamentAfterInstall();
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            Pair[] pairArr = new Pair[7];
            pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IMP_STATE, renderType.getValue());
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_FAIL_REASON, renderFailReason.getValue());
            pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IMP_USE_TIMES, Long.valueOf(currentTimeMillis));
            MoodConfig moodConfig = this.currentMoodConfig;
            if (moodConfig != null && moodConfig.getFromCache()) {
                str2 = "yes";
            } else {
                str2 = "no";
            }
            pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_READ_RENDER_DATA_FROM_CACHE, str2);
            FilamentMapPlayableSource currentSource = getCurrentSource();
            if (currentSource != null && currentSource.isMe()) {
                str3 = "host";
            } else {
                str3 = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
            }
            pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HOST_GUEST_LOAD_FIRST_FRAME, str3);
            pairArr[5] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PG_ID, str);
            pairArr[6] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_INSTALL_FIRST_ACT, Integer.valueOf(isFirstFilamentAfterInstall ? 1 : 0));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FILAMENT_FIRST_FRAME_IMP, mutableMapOf);
            SquareBaseKt.getSquareLog().w(TAG, "report page init filament timeAfter: " + currentTimeMillis);
            this.initializerTime = null;
        }
        FilamentReportHelper.INSTANCE.setUsedFilamentAfterInstall();
    }

    private final void startAlphaAnimation(final View view, final boolean isShow, final Function0<Unit> animationEnd) {
        Object tag = view.getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        view.setTag(AnimationUtils.INSTANCE.startAlphaAnimation(view, isShow, 400L, new AnimatorListenerAdapter() { // from class: com.tencent.state.square.avatar.filament.SquareAvatarFilamentView$startAlphaAnimation$alpha$1
            private boolean isCancel;

            /* renamed from: isCancel, reason: from getter */
            public final boolean getIsCancel() {
                return this.isCancel;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (this.isCancel) {
                    return;
                }
                view.setTag(null);
                Function0 function0 = animationEnd;
                if (function0 != null) {
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                view.setAlpha(isShow ? 0.0f : 1.0f);
                this.isCancel = false;
            }

            public final void setCancel(boolean z16) {
                this.isCancel = z16;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                this.isCancel = true;
                view.setTag(null);
            }
        }));
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void addListener(IAvatarAnimListener iAvatarAnimListener) {
        ISquareAvatarView.DefaultImpls.addListener(this, iAvatarAnimListener);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void addListeners(Set<? extends IAvatarAnimListener> listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        ISquareAvatarView.DefaultImpls.addListeners(this, listeners);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void changeSourceWithAnim(MapPlayableSource source, IAvatarAnimListener listener, boolean needCleanAll) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (listener != null) {
            this.playListener = listener;
        }
        if (checkSourceChange(source)) {
            if (needCleanAll) {
                setVideoViewVisibility(false);
                IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
                if (iFilamentNativeAppV2305 != null) {
                    b bVar = this.filamentSpan;
                    iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, "SquareAvatarScene.EVENT_CLEAN_ALL", "");
                }
            }
            IAvatarAnimView.DefaultImpls.setAnimSource$default(this, source, listener, false, 4, null);
            return;
        }
        if (this.isFirstFrameRendered) {
            IAvatarAnimListener iAvatarAnimListener = this.playListener;
            if (iAvatarAnimListener != null) {
                iAvatarAnimListener.onFirstFrame();
                return;
            }
            return;
        }
        IAvatarAnimListener iAvatarAnimListener2 = this.playListener;
        if (iAvatarAnimListener2 != null) {
            iAvatarAnimListener2.onStaticSuccess();
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void clearListeners() {
        ISquareAvatarView.DefaultImpls.clearListeners(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public CopyOnWriteArraySet<IAvatarAnimListener> getListeners() {
        return ISquareAvatarView.DefaultImpls.getListeners(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public boolean isPlaying() {
        return ISquareAvatarView.DefaultImpls.isPlaying(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        addView(this.imageView, new FrameLayout.LayoutParams(-1, -1));
        addView(this.loadingView, new FrameLayout.LayoutParams(-1, -1));
        initFilament();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroy();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void pause() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void removeListener(IAvatarAnimListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ISquareAvatarView.DefaultImpls.removeListener(this, listener);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void resume() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    public final void setActionHelper(IActionHelper actionHelper) {
        Intrinsics.checkNotNullParameter(actionHelper, "actionHelper");
        this.actionHelper = actionHelper;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setAnimSource(MapPlayableSource source, IAvatarAnimListener listener, boolean needAnim) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(source instanceof FilamentMapPlayableSource)) {
            source = null;
        }
        FilamentMapPlayableSource filamentMapPlayableSource = (FilamentMapPlayableSource) source;
        this.currentSource = filamentMapPlayableSource != null ? filamentMapPlayableSource.copy() : null;
        FilamentMapPlayableSource currentSource = getCurrentSource();
        if (currentSource != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(currentSource.getRemoteUrl());
            if (!isBlank) {
                if (currentSource.isSingleAction()) {
                    setAnimSource(Long.parseLong(currentSource.getUin()), null, currentSource.getRemoteUrl(), null, true);
                } else {
                    MultiMotionUser multiMotionUser = currentSource.getMultiMotionUser();
                    if (multiMotionUser != null) {
                        long parseLong = Long.parseLong(multiMotionUser.getUin());
                        String selectUin = multiMotionUser.getSelectUin();
                        if (selectUin == null) {
                            selectUin = multiMotionUser.getToUin();
                        }
                        setAnimSource(parseLong, Long.valueOf(Long.parseLong(selectUin)), currentSource.getRemoteUrl(), null, true);
                    }
                }
            }
        }
        if (listener != null) {
            this.playListener = listener;
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setAutoShowStatic(boolean z16) {
        ISquareAvatarView.DefaultImpls.setAutoShowStatic(this, z16);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setConfig(AvatarAnimConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        ISquareAvatarView.DefaultImpls.setConfig(this, config);
    }

    public final void setCustomRenderFailHandler(Function2<? super String, ? super RenderFailReason, Unit> cb5) {
        this.customRenderFailHandler = cb5;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setData(MapPlayableItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ISquareAvatarView.DefaultImpls.setData(this, data);
    }

    public final void setDoubleClickListener(Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.doubleClickListener = cb5;
    }

    @Override // com.tencent.state.square.avatar.ISquareAvatarView
    public void setImageViewVisibility(boolean isShow) {
        this.imageView.setVisibility(isShow ? 0 : 4);
        this.imageView.setAlpha(isShow ? 1.0f : 0.0f);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void setLoopPlay(boolean z16) {
        ISquareAvatarView.DefaultImpls.setLoopPlay(this, z16);
    }

    @Override // com.tencent.state.square.avatar.ISquareAvatarView
    public void setStaticSource(MapPlayableSource source, boolean visible) {
        PlayerSourceHelper.setStaticImage$default(PlayerSourceHelper.INSTANCE, this.imageView, source, null, 4, null);
        setImageViewVisibility(visible);
    }

    public final void setTapClickListener(Function0<Unit> cb5) {
        this.tapClickListener = cb5;
    }

    @Override // com.tencent.state.square.avatar.ISquareAvatarView
    public void setVideoViewVisibility(boolean isShow) {
        TextureView view;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 == null || (view = iFilamentNativeAppV2305.getView()) == null) {
            return;
        }
        view.setAlpha(isShow ? 1.0f : 0.0f);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void start() {
        ISquareAvatarView.DefaultImpls.start(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void stop() {
        ISquareAvatarView.DefaultImpls.stop(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void updateAnimSource(MapPlayableSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        ISquareAvatarView.DefaultImpls.updateAnimSource(this, source);
    }

    public SquareAvatarFilamentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public void destroy() {
        this.doubleClickListener = null;
        this.tapClickListener = null;
        ViewExtensionsKt.setVisibility(this.loadingView, false);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.destroy();
        }
        this.filamentApp = null;
    }

    public /* synthetic */ SquareAvatarFilamentView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarFilamentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<String> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"onFilamentRenderFail", "SquareAvatarScene.EVENT_FIRST_FRAME_RENDERED_AFTER_LOAD", "SquareAvatarScene.DOUBLE_CLICK", "SquareAvatarScene.TAP_CLICK"});
        this.filamentEvents = listOf;
        this.filamentSpan = ZPlanSpanFactory.INSTANCE.startRootSpan(TAG);
        SquareImageView squareImageView = new SquareImageView(context);
        this.imageView = squareImageView;
        this.loadingView = new FrameLayout(context);
        this.startTime = System.currentTimeMillis();
        this.initializerTime = Long.valueOf(System.currentTimeMillis());
        this.actionHelper = SquareActionHelper.INSTANCE;
        this.weakContext = new WeakReference<>(context);
        this.weakImageView = new WeakReference<>(squareImageView);
        this.filamentEventListener = new SquareAvatarFilamentView$filamentEventListener$1(this);
    }

    static /* synthetic */ void renderFailTips$default(SquareAvatarFilamentView squareAvatarFilamentView, String str, RenderFailReason renderFailReason, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        squareAvatarFilamentView.renderFailTips(str, renderFailReason);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startAlphaAnimation$default(SquareAvatarFilamentView squareAvatarFilamentView, View view, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        squareAvatarFilamentView.startAlphaAnimation(view, z16, function0);
    }

    public final void setAnimSource(final long hostUin, final Long guestUin, final String url, IAvatarAnimListener listener, boolean needAnim) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.startTime = System.currentTimeMillis();
        SquareBaseKt.getSquareLog().d(TAG, "setAnimSource, uin:" + hostUin + ", guestUin:" + guestUin + " url:" + url + ", time:" + getTimeAfterCreate());
        Function2<CoroutineContext, Throwable, Unit> function2 = new Function2<CoroutineContext, Throwable, Unit>() { // from class: com.tencent.state.square.avatar.filament.SquareAvatarFilamentView$setAnimSource$handleException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(CoroutineContext coroutineContext, Throwable th5) {
                invoke2(coroutineContext, th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CoroutineContext coroutineContext, Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareAvatarFilamentView", "loadActionData failed, uin:" + hostUin + ", guestUin:" + guestUin + ", url:" + url + ", e:" + throwable, null, 4, null);
                SquareAvatarFilamentView.this.renderFailTips(throwable.toString(), RenderFailReason.LOAD_FAIL);
            }
        };
        SquareActionHelperKt.launchCoroutine(Dispatchers.getIO(), function2, new SquareAvatarFilamentView$setAnimSource$3(this, hostUin, guestUin, url, function2, null));
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimView
    public View getView() {
        return this;
    }
}
