package com.tencent.robot.aio.actionbar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgItemMviUIState;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.l;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.robot.helper.RobotEventIntent;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import com.tencent.qqnt.aio.tts.TtsMsgIntent;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.audio.tts.ui.TtsView;
import com.tencent.qqnt.kernel.nativeinterface.AdelieActionBarElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$mAction$2;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001L\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B\u0017\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010>\u001a\u00020;\u00a2\u0006\u0004\bg\u0010hJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001dH\u0002J \u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\n2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0006H\u0016J\u001e\u00100\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00103\u001a\u000202H\u0016J\u0012\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000102H\u0016J\b\u00106\u001a\u00020\u0006H\u0016R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010-R\u0014\u0010B\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010-R\u0014\u0010D\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010-R\u0018\u0010G\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR2\u0010K\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00140Hj\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0014`I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010SR\u001b\u0010W\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010N\u001a\u0004\b4\u0010VR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010N\u001a\u0004\bX\u0010VR\u001b\u0010[\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010N\u001a\u0004\bZ\u0010VR\u001b\u0010_\u001a\u00020\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010N\u001a\u0004\b]\u0010^R\u001b\u0010c\u001a\u00020`8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010N\u001a\u0004\ba\u0010bR\u0016\u0010f\u001a\u0004\u0018\u00010(8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010e\u00a8\u0006i"}, d2 = {"Lcom/tencent/robot/aio/actionbar/RobotAIOMsgActionBarView;", "Lcom/tencent/mobileqq/aio/msg/action/c;", "Lcom/tencent/mvi/base/route/g;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "w", "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$OnTtsPlayStateChanged;", "y", "", "id", "Landroid/graphics/drawable/Drawable;", "p", "K", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "G", "needForceRefresh", "checkStreamState", "L", "B", UserInfo.SEX_FEMALE, "", "menuItemVisible", "E", "type", "", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "buttons", "", "o", "H", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "J", AdMetricTag.Report.TYPE, "reportButtonType", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "onCreate", "a", "getMinWidth", "Landroid/view/View;", "getRoot", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/msg/action/a;", "e", "Lcom/tencent/mobileqq/aio/msg/action/a;", "updater", "f", "iconPadding", h.F, "iconMargin", "i", "iconSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mCurrentMsgItem", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mIsReport", "com/tencent/robot/aio/actionbar/RobotAIOMsgActionBarView$mAction$2$a", "D", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/robot/aio/actionbar/RobotAIOMsgActionBarView$mAction$2$a;", "mAction", "Lcom/tencent/qqnt/audio/tts/ui/TtsView;", "Lcom/tencent/qqnt/audio/tts/ui/TtsView;", "playView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "shareView", "t", "regenerateView", ReportConstant.COSTREPORT_PREFIX, "moreView", "Landroid/widget/LinearLayout;", "u", "()Landroid/widget/LinearLayout;", "rightActionView", "Landroid/widget/RelativeLayout;", DomainData.DOMAIN_NAME, "()Landroid/widget/RelativeLayout;", "actionBarView", "r", "()Landroid/content/Context;", "mContext", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lcom/tencent/mobileqq/aio/msg/action/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAIOMsgActionBarView implements com.tencent.mobileqq.aio.msg.action.c, g, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, Boolean> mIsReport;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAction;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TtsView playView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy regenerateView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy moreView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy rightActionView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy actionBarView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.msg.action.a updater;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int iconPadding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int iconMargin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int iconSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem mCurrentMsgItem;

    public RobotAIOMsgActionBarView(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.mobileqq.aio.msg.action.a updater) {
        Lazy lazy;
        TtsView ttsView;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        int i3;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(updater, "updater");
        this.aioContext = aioContext;
        this.updater = updater;
        ViewUtils viewUtils = ViewUtils.f352270a;
        int b16 = viewUtils.b(5);
        this.iconPadding = b16;
        this.iconMargin = viewUtils.b(6);
        this.iconSize = viewUtils.b(28);
        this.mIsReport = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<RobotAIOMsgActionBarView$mAction$2.a>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$mAction$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/actionbar/RobotAIOMsgActionBarView$mAction$2$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements com.tencent.mvi.base.route.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RobotAIOMsgActionBarView f366824d;

                a(RobotAIOMsgActionBarView robotAIOMsgActionBarView) {
                    this.f366824d = robotAIOMsgActionBarView;
                }

                @Override // com.tencent.mvi.base.route.a
                public void call(@NotNull MsgIntent intent) {
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    this.f366824d.w(intent);
                }

                @Override // com.tencent.mvi.base.route.a
                public boolean sticky() {
                    return a.C9235a.a(this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotAIOMsgActionBarView.this);
            }
        });
        this.mAction = lazy;
        Context r16 = r();
        if (r16 != null) {
            ttsView = new TtsView(r16, null, 0, 6, null);
            ttsView.setBackgroundColor(0);
            ttsView.setContentDescription(ttsView.getContext().getString(R.string.f223626gq));
            ApngImage.resumeAll();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mPlayGifImage = true;
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = ttsView.getContext().getDrawable(R.drawable.qui_pause_filled_icon_white);
            Unit unit = Unit.INSTANCE;
            Drawable mutate = URLDrawable.getDrawable("https://bot-resource-1251316161.file.myqcloud.com/media/aio_audio_playing_1.png", obtain).mutate();
            Context context = aioContext.c().getContext();
            if (context != null) {
                i3 = context.getColor(R.color.qui_common_icon_primary);
            } else {
                i3 = 3092531;
            }
            mutate.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
            ttsView.setPauseIconDrawable(mutate);
            ttsView.removeView(ttsView.c());
            int b17 = com.tencent.qqnt.base.utils.c.f353052a.b(18);
            ttsView.setLoadingView(LoadingUtil.getLoadingView(ttsView.getContext(), b17, b17, 2));
            ttsView.addView(ttsView.c());
            ttsView.setPlayingIconDrawable(p(R.drawable.qui_voice_high));
            ttsView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            ttsView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.actionbar.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotAIOMsgActionBarView.D(RobotAIOMsgActionBarView.this, view);
                }
            });
            ttsView.setPadding(b16, b16, b16, b16);
            ttsView.setVisibility(8);
        } else {
            ttsView = null;
        }
        this.playView = ttsView;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$shareView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context r17;
                int i16;
                int i17;
                int i18;
                int i19;
                r17 = RobotAIOMsgActionBarView.this.r();
                ImageView imageView = new ImageView(r17);
                RobotAIOMsgActionBarView robotAIOMsgActionBarView = RobotAIOMsgActionBarView.this;
                imageView.setId(R.id.sju);
                imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getContext().getResources(), R.drawable.qui_share, imageView.getContext().getTheme()));
                imageView.setOnClickListener(robotAIOMsgActionBarView);
                i16 = robotAIOMsgActionBarView.iconPadding;
                i17 = robotAIOMsgActionBarView.iconPadding;
                i18 = robotAIOMsgActionBarView.iconPadding;
                i19 = robotAIOMsgActionBarView.iconPadding;
                imageView.setPadding(i16, i17, i18, i19);
                imageView.setVisibility(8);
                return imageView;
            }
        });
        this.shareView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$regenerateView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context r17;
                int i16;
                int i17;
                int i18;
                int i19;
                r17 = RobotAIOMsgActionBarView.this.r();
                ImageView imageView = new ImageView(r17);
                RobotAIOMsgActionBarView robotAIOMsgActionBarView = RobotAIOMsgActionBarView.this;
                imageView.setId(R.id.sjt);
                imageView.setContentDescription(imageView.getContext().getString(R.string.f222966ey));
                imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getContext().getResources(), R.drawable.qui_refresh, imageView.getContext().getTheme()));
                i16 = robotAIOMsgActionBarView.iconPadding;
                i17 = robotAIOMsgActionBarView.iconPadding;
                i18 = robotAIOMsgActionBarView.iconPadding;
                i19 = robotAIOMsgActionBarView.iconPadding;
                imageView.setPadding(i16, i17, i18, i19);
                imageView.setOnClickListener(robotAIOMsgActionBarView);
                imageView.setVisibility(8);
                return imageView;
            }
        });
        this.regenerateView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$moreView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context r17;
                int i16;
                int i17;
                int i18;
                int i19;
                r17 = RobotAIOMsgActionBarView.this.r();
                ImageView imageView = new ImageView(r17);
                RobotAIOMsgActionBarView robotAIOMsgActionBarView = RobotAIOMsgActionBarView.this;
                imageView.setId(R.id.f7622413);
                imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getContext().getResources(), R.drawable.qui_more, imageView.getContext().getTheme()));
                imageView.setOnClickListener(robotAIOMsgActionBarView);
                i16 = robotAIOMsgActionBarView.iconPadding;
                i17 = robotAIOMsgActionBarView.iconPadding;
                i18 = robotAIOMsgActionBarView.iconPadding;
                i19 = robotAIOMsgActionBarView.iconPadding;
                imageView.setPadding(i16, i17, i18, i19);
                imageView.setVisibility(8);
                return imageView;
            }
        });
        this.moreView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$rightActionView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                Context r17;
                ImageView v3;
                int i16;
                int i17;
                int i18;
                ImageView t16;
                int i19;
                int i26;
                int i27;
                ImageView s16;
                int i28;
                int i29;
                int i36;
                r17 = RobotAIOMsgActionBarView.this.r();
                LinearLayout linearLayout = new LinearLayout(r17);
                RobotAIOMsgActionBarView robotAIOMsgActionBarView = RobotAIOMsgActionBarView.this;
                linearLayout.setGravity(17);
                linearLayout.setOrientation(0);
                v3 = robotAIOMsgActionBarView.v();
                i16 = robotAIOMsgActionBarView.iconSize;
                i17 = robotAIOMsgActionBarView.iconSize;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i17);
                i18 = robotAIOMsgActionBarView.iconMargin;
                layoutParams.leftMargin = i18;
                Unit unit2 = Unit.INSTANCE;
                linearLayout.addView(v3, layoutParams);
                t16 = robotAIOMsgActionBarView.t();
                i19 = robotAIOMsgActionBarView.iconSize;
                i26 = robotAIOMsgActionBarView.iconSize;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i19, i26);
                i27 = robotAIOMsgActionBarView.iconMargin;
                layoutParams2.leftMargin = i27;
                linearLayout.addView(t16, layoutParams2);
                s16 = robotAIOMsgActionBarView.s();
                i28 = robotAIOMsgActionBarView.iconSize;
                i29 = robotAIOMsgActionBarView.iconSize;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i28, i29);
                i36 = robotAIOMsgActionBarView.iconMargin;
                layoutParams3.leftMargin = i36;
                linearLayout.addView(s16, layoutParams3);
                return linearLayout;
            }
        });
        this.rightActionView = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$actionBarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                Context r17;
                LinearLayout u16;
                int i16;
                TtsView ttsView2;
                int i17;
                int i18;
                int i19;
                r17 = RobotAIOMsgActionBarView.this.r();
                RelativeLayout relativeLayout = new RelativeLayout(r17);
                RobotAIOMsgActionBarView robotAIOMsgActionBarView = RobotAIOMsgActionBarView.this;
                com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
                relativeLayout.setPadding(0, cVar.b(7), 0, cVar.b(7));
                u16 = robotAIOMsgActionBarView.u();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(21);
                i16 = robotAIOMsgActionBarView.iconPadding;
                layoutParams.rightMargin = -i16;
                Unit unit2 = Unit.INSTANCE;
                relativeLayout.addView(u16, layoutParams);
                ttsView2 = robotAIOMsgActionBarView.playView;
                i17 = robotAIOMsgActionBarView.iconSize;
                i18 = robotAIOMsgActionBarView.iconSize;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i17, i18);
                i19 = robotAIOMsgActionBarView.iconPadding;
                layoutParams2.leftMargin = -i19;
                relativeLayout.addView(ttsView2, layoutParams2);
                relativeLayout.setClickable(true);
                relativeLayout.setVisibility(8);
                return relativeLayout;
            }
        });
        this.actionBarView = lazy6;
    }

    private final boolean A() {
        if (!com.tencent.mobileqq.aio.a.a(this.aioContext) && !com.tencent.mobileqq.aio.a.b(this.aioContext)) {
            return false;
        }
        return true;
    }

    private final boolean B() {
        long j3;
        a.C9495a c9495a;
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        if (aIOMsgItem != null) {
            j3 = aIOMsgItem.getMsgId();
        } else {
            j3 = 0;
        }
        k k3 = this.aioContext.e().k(new StreamMsgEvent.GetAnimStatus(Long.valueOf(j3)));
        if (k3 instanceof a.C9495a) {
            c9495a = (a.C9495a) k3;
        } else {
            c9495a = null;
        }
        if (c9495a != null) {
            return c9495a.a();
        }
        return false;
    }

    private final void C() {
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        if (aIOMsgItem == null) {
            return;
        }
        TtsView ttsView = this.playView;
        boolean z16 = false;
        if (ttsView != null && ttsView.f()) {
            z16 = true;
        }
        if (z16) {
            this.aioContext.e().h(new TtsMsgIntent.ActiveTriggerStopTtsMsgIntent(aIOMsgItem));
        } else {
            this.aioContext.e().h(new TtsMsgIntent.ActiveTriggerPlayTtsMsgIntent(aIOMsgItem));
        }
        I(1, "3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(RobotAIOMsgActionBarView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E(AIOMsgItem msgItem, Iterable<Integer> menuItemVisible) {
        ArrayList arrayList;
        String joinToString$default;
        ArrayList<InlineKeyboardRow> arrayList2;
        AdelieActionBarElement a16 = com.tencent.qqnt.aio.msg.d.a(msgItem);
        if (a16 != null && (arrayList2 = a16.rows) != null) {
            arrayList = new ArrayList();
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                ArrayList<InlineKeyboardButton> arrayList3 = ((InlineKeyboardRow) it.next()).buttons;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "it.buttons");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList3);
            }
        } else {
            arrayList = null;
        }
        String o16 = o(5, arrayList);
        String o17 = o(6, arrayList);
        long msgId = msgItem.getMsgId();
        boolean I = msgItem.I();
        boolean y06 = msgItem.y0();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(menuItemVisible, null, null, null, 0, null, new Function1<Integer, CharSequence>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$printActionBarButtonsLog$1
            @NotNull
            public final CharSequence invoke(int i3) {
                return String.valueOf(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
                return invoke(num.intValue());
            }
        }, 31, null);
        QLog.i("RobotAIOMsgActionBarView", 1, "refreshActionBarLayout: msg=" + msgId + ", isLast=" + I + ", supportTts=" + y06 + ", menuItemVisible=" + joinToString$default + ", feedback=" + o16 + ", tts=" + o17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View] */
    private final void F(AIOMsgItem msgItem) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (A()) {
            return;
        }
        HashMap<Integer, InlineKeyboardButton> b16 = com.tencent.qqnt.aio.msg.d.b(msgItem, "1");
        if (b16 != null && !msgItem.P0()) {
            boolean z19 = true;
            boolean containsKey = b16.containsKey(1);
            boolean containsKey2 = b16.containsKey(2);
            boolean W0 = msgItem.W0();
            boolean containsKey3 = b16.containsKey(6);
            if (msgItem.I() && b16.containsKey(5)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!containsKey && !containsKey2) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!W0 && !containsKey3 && !z16 && !z17) {
                z18 = false;
            } else {
                z18 = true;
            }
            TtsView ttsView = this.playView;
            if (ttsView != null) {
                Boolean valueOf = Boolean.valueOf(W0);
                ttsView.setVisibility(0);
                ?? r46 = (View) au.a(valueOf, ttsView);
                if (r46 == 0) {
                    ttsView.setVisibility(8);
                } else {
                    ttsView = r46;
                }
            }
            ImageView s16 = s();
            if (!containsKey && !containsKey2) {
                z19 = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z19);
            s16.setVisibility(0);
            if (((View) au.a(valueOf2, s16)) == null) {
                s16.setVisibility(8);
            }
            ImageView v3 = v();
            Boolean valueOf3 = Boolean.valueOf(containsKey3);
            v3.setVisibility(0);
            if (((View) au.a(valueOf3, v3)) == null) {
                v3.setVisibility(8);
            }
            ImageView t16 = t();
            Boolean valueOf4 = Boolean.valueOf(z16);
            t16.setVisibility(0);
            if (((View) au.a(valueOf4, t16)) == null) {
                t16.setVisibility(8);
            }
            RelativeLayout n3 = n();
            Boolean valueOf5 = Boolean.valueOf(z18);
            n3.setVisibility(0);
            if (((View) au.a(valueOf5, n3)) == null) {
                n3.setVisibility(8);
            }
            G(msgItem);
            Set<Integer> keySet = b16.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "menuItemVisible.keys");
            E(msgItem, keySet);
            return;
        }
        H();
    }

    private final void G(AIOMsgItem msgItem) {
        TtsView ttsView;
        String str;
        if (!A() && msgItem.W0() && (ttsView = this.playView) != null) {
            long msgId = msgItem.getMsgId();
            long msgId2 = msgItem.getMsgId();
            String valueOf = String.valueOf(msgItem.getMsgRecord().senderUin);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            ttsView.a(msgId, new com.tencent.qqnt.audio.tts.ui.b(msgId2, valueOf, str, msgItem.h2(), false, com.tencent.qqnt.aio.msg.d.i(msgItem), null, null, null, TroopInfo.PAY_PRIVILEGE_ALL, null));
        }
    }

    private final void H() {
        n().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(int reportType, String reportButtonType) {
        HashMap hashMap = new HashMap();
        hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, reportButtonType);
        if (reportType != 1) {
            if (reportType == 2) {
                Boolean bool = this.mIsReport.get(reportButtonType);
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                if (!bool.booleanValue()) {
                    this.mIsReport.put(reportButtonType, Boolean.TRUE);
                    com.tencent.mobileqq.aio.utils.b.q("em_bas_agent_message_operation_button", hashMap);
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.mobileqq.aio.utils.b.l("em_bas_agent_message_operation_button", hashMap);
    }

    private final void J(Context context, AIOMsgItem msgItem) {
        HashMap<Integer, InlineKeyboardButton> b16;
        if (!msgItem.isSelf() && msgItem.getMsgRecord().sendType != 3 && (b16 = com.tencent.qqnt.aio.msg.d.b(msgItem, g81.a.a(msgItem))) != null) {
            com.tencent.qqnt.aio.menu.ui.c cVar = new com.tencent.qqnt.aio.menu.ui.c();
            boolean containsKey = b16.containsKey(1);
            boolean containsKey2 = b16.containsKey(2);
            if (containsKey) {
                cVar.a(new f(context, msgItem, b16.get(1), new Function0<Unit>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$showMorePopup$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RobotAIOMsgActionBarView.this.I(1, "1");
                    }
                }));
            }
            if (containsKey2) {
                cVar.a(new d(context, msgItem, b16.get(2), new Function0<Unit>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$showMorePopup$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RobotAIOMsgActionBarView.this.I(1, "2");
                    }
                }));
            }
            if (cVar.d() > 0) {
                this.aioContext.e().h(new RobotEventIntent.ShowPopupMenu(s(), cVar));
                if (containsKey) {
                    I(2, "1");
                }
                if (containsKey2) {
                    I(2, "2");
                }
            }
        }
    }

    private final void K() {
        boolean z16;
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        if (aIOMsgItem != null) {
            if (com.tencent.qqnt.aio.msg.d.i(aIOMsgItem) && aIOMsgItem.I()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null) {
                this.aioContext.e().h(new TtsMsgIntent.TryToAutoTtsWelcomeMsg(aIOMsgItem));
            }
        }
    }

    private final void L(AIOMsgItem msgItem, boolean needForceRefresh, boolean checkStreamState) {
        String str = "[updateActionLayout]: refreshActionBarLayout msgId is " + msgItem.getMsgId();
        if (QLog.isDevelopLevel()) {
            QLog.i("RobotAIOMsgActionBarView", 4, str);
        }
        if (needForceRefresh) {
            F(msgItem);
            return;
        }
        int g16 = com.tencent.qqnt.aio.msg.d.g(msgItem);
        if (QLog.isDevelopLevel()) {
            QLog.i("RobotAIOMsgActionBarView", 4, "[updateActionLayout]: refreshActionBarLayout msgId is " + msgItem.getMsgId() + ", pushState is " + g16);
        }
        if (g16 == 0) {
            F(msgItem);
            return;
        }
        if (g16 != 1) {
            if (checkStreamState && B()) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("RobotAIOMsgActionBarView", 4, "[updateActionLayout]: msgId is " + msgItem.getMsgId() + ", streamRunning");
                    return;
                }
                return;
            }
            F(msgItem);
            return;
        }
        H();
    }

    static /* synthetic */ void M(RobotAIOMsgActionBarView robotAIOMsgActionBarView, AIOMsgItem aIOMsgItem, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        robotAIOMsgActionBarView.L(aIOMsgItem, z16, z17);
    }

    private final RelativeLayout n() {
        return (RelativeLayout) this.actionBarView.getValue();
    }

    private final String o(int type, List<InlineKeyboardButton> buttons) {
        String str;
        boolean z16;
        if (buttons != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : buttons) {
                if (((InlineKeyboardButton) obj).type == type) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<InlineKeyboardButton, CharSequence>() { // from class: com.tencent.robot.aio.actionbar.RobotAIOMsgActionBarView$getButtonsLogStr$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull InlineKeyboardButton it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    int i3 = it.feedBackData.opt;
                    long j3 = it.hideSeconds;
                    return i3 + "-" + j3 + "-" + (j3 < System.currentTimeMillis() / ((long) 1000));
                }
            }, 31, null);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final Drawable p(int id5) {
        Drawable mutate;
        Context context = this.aioContext.c().getContext();
        if (context == null) {
            return null;
        }
        int color = context.getColor(R.color.qui_common_icon_primary);
        Drawable drawable = ResourcesCompat.getDrawable(this.aioContext.c().getResources(), id5, null);
        if (drawable == null || (mutate = drawable.mutate()) == null) {
            return null;
        }
        mutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        return mutate;
    }

    private final RobotAIOMsgActionBarView$mAction$2.a q() {
        return (RobotAIOMsgActionBarView$mAction$2.a) this.mAction.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context r() {
        Fragment c16 = this.aioContext.c();
        if (c16 != null) {
            return c16.getContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView s() {
        return (ImageView) this.moreView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView t() {
        return (ImageView) this.regenerateView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout u() {
        return (LinearLayout) this.rightActionView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView v() {
        return (ImageView) this.shareView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(MsgIntent msgIntent) {
        if (msgIntent instanceof TtsMsgIntent.OnTtsPlayStateChanged) {
            y((TtsMsgIntent.OnTtsPlayStateChanged) msgIntent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean x(AIOMsgItem msgItem, List<Object> payloads) {
        l lVar;
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.LAST_RECEIVE_MSG_PAYLOAD) != null) {
                    M(this, msgItem, false, false, 6, null);
                }
                if (map.get(AIOMsgItemPayloadType.MSG_FEEDBACK_BAR_PAYLOAD) != null) {
                    M(this, msgItem, false, false, 6, null);
                }
                if (map.get(AIOMsgItemPayloadType.ADELIE_MSG_PUSH_STATE_PAYLOAD) != null) {
                    M(this, msgItem, false, false, 6, null);
                }
                if (map.get(AIOMsgItemPayloadType.SELECT_PAYLOAD) != null) {
                    M(this, msgItem, false, false, 6, null);
                }
                if (map.get(AIOMsgItemPayloadType.MARKDOWN_STREAM_RUNNING_PAYLOAD) != null) {
                    if (msgItem instanceof l) {
                        lVar = (l) msgItem;
                    } else {
                        lVar = null;
                    }
                    if (lVar != null && !lVar.d()) {
                        M(this, msgItem, false, false, 2, null);
                    }
                }
            }
        }
        return false;
    }

    private final void y(TtsMsgIntent.OnTtsPlayStateChanged msgIntent) {
        TtsView ttsView;
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        boolean z16 = false;
        if (aIOMsgItem != null && msgIntent.a() == aIOMsgItem.getMsgId()) {
            z16 = true;
        }
        if (z16 && (ttsView = this.playView) != null) {
            ttsView.l();
        }
    }

    private final boolean z(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((HashMap) it.next()).get(AIOMsgItemPayloadType.LOADING_CHANGE_PAYLOAD) != null) {
                G(msgItem);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.action.c
    public boolean a(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!msgItem.isSelf() && !msgItem.P0()) {
            this.mCurrentMsgItem = msgItem;
            if (msgItem.T0()) {
                return false;
            }
            if (x(msgItem, payloads)) {
                M(this, msgItem, false, false, 6, null);
            }
            if (z(msgItem, payloads)) {
                G(msgItem);
                K();
            }
            if (n().getVisibility() != 0) {
                return false;
            }
            return true;
        }
        H();
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.action.c
    public int getMinWidth() {
        HashMap<Integer, InlineKeyboardButton> b16;
        boolean z16;
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        int i3 = 0;
        if (aIOMsgItem == null || (b16 = com.tencent.qqnt.aio.msg.d.b(aIOMsgItem, "1")) == null) {
            return 0;
        }
        boolean W0 = aIOMsgItem.W0();
        boolean containsKey = b16.containsKey(6);
        boolean z17 = true;
        if (aIOMsgItem.I() && b16.containsKey(5)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!b16.containsKey(1) && !b16.containsKey(2)) {
            z17 = false;
        }
        if (W0) {
            i3 = 0 + this.iconSize;
        }
        if (containsKey) {
            i3 += this.iconSize + this.iconMargin;
        }
        if (z16) {
            i3 += this.iconSize + this.iconMargin;
        }
        if (z17) {
            i3 += this.iconSize + this.iconMargin;
        }
        if (containsKey || z16 || z17) {
            return i3 + com.tencent.qqnt.base.utils.c.f353052a.b(36);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.aio.msg.action.c
    @NotNull
    public View getRoot() {
        return n();
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.OnTtsPlayStateChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        Context r16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        if (aIOMsgItem != null) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.sjt) {
                this.updater.a(AIOMsgItemMviUIState.OnRegenerateClickUIState.f188273d);
                this.aioContext.e().h(new AIOMsgListEvent.RegenerateMsg(aIOMsgItem.getMsgRecord()));
                I(1, "4");
            } else if (num != null && num.intValue() == R.id.sju) {
                this.aioContext.e().h(new RobotMsgIntent.ShareSession(aIOMsgItem));
                I(1, "5");
            } else if (num != null && num.intValue() == R.id.f7622413 && (r16 = r()) != null) {
                J(r16, aIOMsgItem);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.aio.msg.action.c
    public void onCreate() {
        this.aioContext.e().f(this, q());
    }

    @Override // com.tencent.mobileqq.aio.msg.action.c
    public void onDestroy() {
        this.aioContext.e().i(this, q());
        this.mCurrentMsgItem = null;
        H();
    }
}
