package com.tencent.timi.game.liveroom.impl.room.view.head;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel;
import com.tencent.timi.game.liveroom.impl.room.toparea.a;
import com.tencent.timi.game.liveroom.impl.room.view.QQLiveCustomDialog;
import com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveCustomButtonView;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppActivity;
import mqq.app.Foreground;
import nr4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0002noB'\b\u0007\u0012\u0006\u0010g\u001a\u00020f\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h\u0012\b\b\u0002\u0010j\u001a\u00020J\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\f\u0010\u0014\u001a\u00020\u0003*\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0003J\b\u0010#\u001a\u00020\u0003H\u0014J\u000e\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0007J\"\u0010'\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010+\u001a\u00020\u0003J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010/\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u000bJ\u0006\u00100\u001a\u00020\u0003R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00100R\u0018\u00107\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00100R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010BR\u0016\u0010F\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010ER\u0016\u0010I\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00100R\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00100R\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010d\u00a8\u0006p"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "", BdhLogUtil.LogTag.Tag_Conn, "", "roomId", "", "isAnchor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "", "programId", "showGold", "showPraise", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "V", "W", "E", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel;", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, HippyTKDListViewAdapter.X, "Lnr4/d;", "fansGroupInfo", "T", "U", "vm", "setViewModel", "likeEnable", "Y", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycle", "X", NodeProps.ON_DETACHED_FROM_WINDOW, MiniChatConstants.MINI_APP_LANDSCAPE, "P", AppConstants.Key.KEY_QZONE_VIDEO_URL, "onPreload", "onPageIn", "onPageOut", "onEnterRoom", "setQQLive", "onExitRoom", "nickname", "avatar", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "d", "isDetachedFromWindow", "e", "hadEnterRoom", "f", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel;", "viewModel", tl.h.F, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "i", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isShowCoinNum", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "flipperRunnable", "D", "J", "curRoomCoinNum", "curRoomLikeNum", UserInfo.SEX_FEMALE, "enablePraise", "", "G", "I", "getRoomType", "()I", "setRoomType", "(I)V", "roomType", "H", "isRenewalTipsShowing", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "portraitIgv", "Landroid/widget/TextSwitcher;", "Landroid/widget/TextSwitcher;", "anchorLiveStatusTxv", "Landroid/view/View;", "K", "Landroid/view/View;", "placeHolderView", "Landroid/widget/TextView;", "L", "Landroid/widget/TextView;", "nameTxv", "Landroid/widget/LinearLayout;", "M", "Landroid/widget/LinearLayout;", "nameContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "a", "FlipperRunnable", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorTopHeadView extends FrameLayout implements IRoomWidget {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Runnable flipperRunnable;

    /* renamed from: D, reason: from kotlin metadata */
    private long curRoomCoinNum;

    /* renamed from: E, reason: from kotlin metadata */
    private long curRoomLikeNum;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean enablePraise;

    /* renamed from: G, reason: from kotlin metadata */
    private int roomType;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isRenewalTipsShowing;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerImageView portraitIgv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextSwitcher anchorLiveStatusTxv;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final View placeHolderView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TextView nameTxv;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout nameContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isDetachedFromWindow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hadEnterRoom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TopAreaViewModel viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IAegisLogApi mAegisLog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isShowCoinNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView$FlipperRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "Z", "showPraise", "e", "showGold", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "f", "Ljava/lang/ref/WeakReference;", "headViewRef", "anchorTopHeadView", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView;ZZ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class FlipperRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean showPraise;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean showGold;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<AnchorTopHeadView> headViewRef;

        public FlipperRunnable(@NotNull AnchorTopHeadView anchorTopHeadView, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(anchorTopHeadView, "anchorTopHeadView");
            this.showGold = z16;
            this.showPraise = z17;
            this.headViewRef = new WeakReference<>(anchorTopHeadView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AnchorTopHeadView anchorTopHeadView;
            TextView textView;
            String str;
            String str2;
            WeakReference<AnchorTopHeadView> weakReference = this.headViewRef;
            TextView textView2 = null;
            if (weakReference != null) {
                anchorTopHeadView = weakReference.get();
            } else {
                anchorTopHeadView = null;
            }
            if (anchorTopHeadView != null) {
                View childAt = anchorTopHeadView.anchorLiveStatusTxv.getChildAt(anchorTopHeadView.anchorLiveStatusTxv.getDisplayedChild());
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else {
                    textView = null;
                }
                if (textView != null) {
                    boolean z16 = false;
                    if (anchorTopHeadView.curRoomCoinNum <= 10000) {
                        str = anchorTopHeadView.curRoomCoinNum + " Q\u7c73";
                    } else {
                        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) anchorTopHeadView.curRoomCoinNum) / 10000.0f)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                        str = format + "\u4e07 Q\u7c73";
                    }
                    if (anchorTopHeadView.curRoomLikeNum <= 10000) {
                        str2 = anchorTopHeadView.curRoomLikeNum + " \u70b9\u8d5e";
                    } else {
                        String format2 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) anchorTopHeadView.curRoomLikeNum) / 10000.0f)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                        str2 = format2 + "\u4e07 \u70b9\u8d5e";
                    }
                    AegisLogger.INSTANCE.d("unknown|AnchorTopHeadView_", "flipperRunnable", "roomCoinText:" + str + " roomLikeText:" + str2);
                    int parseColor = Color.parseColor("#FFDC28");
                    int color = anchorTopHeadView.getResources().getColor(R.color.cli);
                    if (this.showPraise && anchorTopHeadView.curRoomLikeNum != -1 && anchorTopHeadView.enablePraise) {
                        z16 = true;
                    }
                    boolean z17 = this.showGold;
                    if (z17 && !z16) {
                        textView.setText(str);
                        textView.setTextColor(parseColor);
                        textView.setAlpha(0.6f);
                    } else if (!z17 && z16) {
                        textView.setText(str2);
                        textView.setTextColor(color);
                    } else if (z17 && z16) {
                        if (anchorTopHeadView.isShowCoinNum) {
                            View nextView = anchorTopHeadView.anchorLiveStatusTxv.getNextView();
                            if (nextView instanceof TextView) {
                                textView2 = (TextView) nextView;
                            }
                            if (textView2 != null) {
                                textView2.setTextColor(parseColor);
                                textView2.setAlpha(0.6f);
                            }
                            anchorTopHeadView.anchorLiveStatusTxv.setText(str);
                        } else {
                            View nextView2 = anchorTopHeadView.anchorLiveStatusTxv.getNextView();
                            if (nextView2 instanceof TextView) {
                                textView2 = (TextView) nextView2;
                            }
                            if (textView2 != null) {
                                textView2.setTextColor(color);
                            }
                            anchorTopHeadView.anchorLiveStatusTxv.setText(str2);
                        }
                    } else {
                        textView.setText("");
                        return;
                    }
                }
                anchorTopHeadView.isShowCoinNum = !anchorTopHeadView.isShowCoinNum;
                RFWThreadManager.getUIHandler().postDelayed(this, 5000L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView$b", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$b;", "Landroid/view/View;", "view", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements QQLiveCustomButtonView.Companion.b {
        b() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveCustomButtonView.Companion.b
        public void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TopAreaViewModel topAreaViewModel = AnchorTopHeadView.this.viewModel;
            if (topAreaViewModel != null) {
                Context context = AnchorTopHeadView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                topAreaViewModel.q(context, 2);
            }
            kj4.b.h();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView$c", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$b;", "Landroid/view/View;", "view", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements QQLiveCustomButtonView.Companion.b {
        c() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveCustomButtonView.Companion.b
        public void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TopAreaViewModel topAreaViewModel = AnchorTopHeadView.this.viewModel;
            if (topAreaViewModel != null) {
                Context context = AnchorTopHeadView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                topAreaViewModel.q(context, 1);
            }
            kj4.b.i();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView$d", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$c;", "Landroid/view/View;", "view", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements QQLiveCustomDialog.Companion.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nr4.d f378740b;

        d(nr4.d dVar) {
            this.f378740b = dVar;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.QQLiveCustomDialog.Companion.c
        public void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AegisLogger.INSTANCE.i("unknown|AnchorTopHeadView_", "showRenewalTipsDialog", "onCancel");
            AnchorTopHeadView.this.isRenewalTipsShowing = false;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.QQLiveCustomDialog.Companion.c
        public void b(@NotNull View view) {
            String str;
            Intrinsics.checkNotNullParameter(view, "view");
            AnchorTopHeadView.this.isRenewalTipsShowing = false;
            a.C10866a.C10867a c10867a = this.f378740b.f421217d.f421211g.f421198h.f421202d;
            if (c10867a != null) {
                str = c10867a.f421204b;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String url = kj4.a.b(str);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            StringsKt__StringsJVMKt.isBlank(url);
            kj4.a.f(AnchorTopHeadView.this.getContext(), url);
            AegisLogger.INSTANCE.i("unknown|AnchorTopHeadView_", "showRenewalTipsDialog", "onConfirm, url=" + url);
            kj4.b.c();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopHeadView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(long roomId, boolean isAnchor) {
        if (this.anchorLiveStatusTxv.getChildCount() == 0) {
            this.anchorLiveStatusTxv.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.c
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    View B;
                    B = AnchorTopHeadView.B(AnchorTopHeadView.this);
                    return B;
                }
            });
        }
        String w3 = com.tencent.mobileqq.qqlive.sail.c.w(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null);
        if (isAnchor) {
            y();
            int i3 = this.roomType;
            if (i3 == 0 || i3 == 1) {
                z(roomId, w3, true, true);
            }
        } else {
            int i16 = this.roomType;
            if (i16 == 0 || i16 == 1) {
                z(roomId, w3, false, true);
            }
        }
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View B(AnchorTopHeadView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = new TextView(this$0.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        textView.setTextSize(1, 9.0f);
        textView.setGravity(16);
        textView.setTextColor(this$0.getResources().getColor(R.color.cli));
        textView.setMaxLines(1);
        textView.setMaxEms(20);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private final void C() {
        RoundCornerImageView.setRadius$default(this.portraitIgv, fh4.b.d(16), 0.0f, 0.0f, fh4.b.d(16), 6, null);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopHeadView.D(AnchorTopHeadView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AnchorTopHeadView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TopAreaViewModel topAreaViewModel = this$0.viewModel;
        if (topAreaViewModel != null) {
            Activity d16 = com.tencent.timi.game.utils.b.d(this$0);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            topAreaViewModel.u0(d16, it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void E() {
        final TopAreaViewModel topAreaViewModel;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (topAreaViewModel = this.viewModel) != null) {
            topAreaViewModel.y().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.N((Integer) obj);
                }
            });
            topAreaViewModel.x().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.O(TopAreaViewModel.this, this, (Integer) obj);
                }
            });
            topAreaViewModel.z().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.F((Integer) obj);
                }
            });
            topAreaViewModel.E().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.G(AnchorTopHeadView.this, (Integer) obj);
                }
            });
            topAreaViewModel.D().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.H(AnchorTopHeadView.this, (String) obj);
                }
            });
            topAreaViewModel.B().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.I(TopAreaViewModel.this, this, (String) obj);
                }
            });
            topAreaViewModel.A().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.J(AnchorTopHeadView.this, (nr4.d) obj);
                }
            });
            topAreaViewModel.t().observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.K(AnchorTopHeadView.this, (TopAreaViewModel.a) obj);
                }
            });
            MutableLiveData<Long> G = topAreaViewModel.G();
            final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.AnchorTopHeadView$observeVm$1$1$9
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long praiseNum) {
                    long j3 = AnchorTopHeadView.this.curRoomLikeNum;
                    if (praiseNum != null && praiseNum.longValue() == j3) {
                        return;
                    }
                    AnchorTopHeadView anchorTopHeadView = AnchorTopHeadView.this;
                    Intrinsics.checkNotNullExpressionValue(praiseNum, "praiseNum");
                    anchorTopHeadView.curRoomLikeNum = praiseNum.longValue();
                    AnchorTopHeadView.this.V();
                }
            };
            G.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.L(Function1.this, obj);
                }
            });
            MutableLiveData<Long> u16 = topAreaViewModel.u();
            final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.AnchorTopHeadView$observeVm$1$1$10
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long coinNum) {
                    AnchorTopHeadView anchorTopHeadView = AnchorTopHeadView.this;
                    Intrinsics.checkNotNullExpressionValue(coinNum, "coinNum");
                    anchorTopHeadView.curRoomCoinNum = coinNum.longValue();
                }
            };
            u16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopHeadView.M(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AnchorTopHeadView this$0, Integer visible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.placeHolderView;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        view.setVisibility(visible.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(AnchorTopHeadView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.nameTxv.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(TopAreaViewModel this_apply, AnchorTopHeadView this$0, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this_apply.S()) {
            return;
        }
        RoundCornerImageView roundCornerImageView = this$0.portraitIgv;
        com.tencent.timi.game.utils.b.g(roundCornerImageView, str, this_apply.J(roundCornerImageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(AnchorTopHeadView this$0, nr4.d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dVar != null && dVar.f421217d != null) {
            this$0.T(dVar);
            this$0.U(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AnchorTopHeadView this$0, TopAreaViewModel.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(TopAreaViewModel this_apply, AnchorTopHeadView this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == 0) {
            this_apply.Z();
            this_apply.y().setValue(8);
            if (!this$0.hadEnterRoom) {
                this_apply.Y(true);
            }
        }
    }

    private final void R() {
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            Intrinsics.checkNotNull(topAreaViewModel);
            if (!topAreaViewModel.S()) {
                return;
            }
        }
        ViewGroup.LayoutParams layoutParams = this.portraitIgv.getLayoutParams();
        layoutParams.width = (int) fh4.b.d(32);
        layoutParams.height = (int) fh4.b.d(32);
        this.portraitIgv.setLayoutParams(layoutParams);
        this.portraitIgv.setRadius(fh4.b.d(16), fh4.b.d(16), fh4.b.d(16), fh4.b.d(16));
        this.portraitIgv.setImageResource(R.drawable.ovu);
    }

    private final void S(TopAreaViewModel topAreaViewModel) {
        int i3;
        int c16;
        if (topAreaViewModel.S()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.portraitIgv.setVisibility(i3);
        LinearLayout linearLayout = this.nameContainer;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (topAreaViewModel.S()) {
            c16 = com.tencent.mobileqq.util.x.c(getContext(), 38.0f);
        } else {
            c16 = com.tencent.mobileqq.util.x.c(getContext(), 12.0f);
        }
        marginLayoutParams.leftMargin = c16;
        linearLayout.setLayoutParams(marginLayoutParams);
        R();
    }

    private final void T(nr4.d fansGroupInfo) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        boolean K = com.tencent.mobileqq.qqlive.sail.c.K(cVar, cVar.p(), 0, 2, null);
        int i3 = fansGroupInfo.f421216c.f421220b;
        if (i3 > 0) {
            str = String.valueOf(i3);
        } else {
            str = null;
        }
        String str2 = str;
        int i16 = fansGroupInfo.f421217d.f421205a;
        if (i16 == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z28 = !z16;
        if (i16 == 2 && !K) {
            z17 = true;
        } else {
            z17 = false;
        }
        new QQLiveCustomButtonView.Companion.ButtonInfo(z16, z28, true, z17, str2, null, null, null, null, new c());
        nr4.a aVar = fansGroupInfo.f421217d.f421211g;
        if (aVar != null && aVar.f421191a) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            boolean z29 = aVar.f421197g;
            if (!aVar.f421195e && !K) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (!z29 && z19) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (!z29 && !z19) {
                z27 = true;
            } else {
                z27 = false;
            }
            new QQLiveCustomButtonView.Companion.ButtonInfo(z29, z26, false, z27, null, null, null, null, null, new b());
        }
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            topAreaViewModel.n0();
        }
    }

    private final void U(nr4.d fansGroupInfo) {
        if (this.isRenewalTipsShowing) {
            AegisLogger.INSTANCE.i("unknown|AnchorTopHeadView_", "showRenewalTipsDialog", "fail, isRenewalTipsShowing=true");
            return;
        }
        nr4.a aVar = fansGroupInfo.f421217d.f421211g;
        if (aVar != null && aVar.f421191a) {
            a.C10866a c10866a = aVar.f421198h;
            if (c10866a != null && !TextUtils.isEmpty(c10866a.f421200b)) {
                AegisLogger.INSTANCE.i("unknown|AnchorTopHeadView_", "showRenewalTipsDialog", "success, renewalTips={" + fansGroupInfo.f421217d.f421211g.f421198h + "}");
                QQLiveCustomDialog.Companion.C9957a a16 = QQLiveCustomDialog.INSTANCE.a();
                a.C10866a c10866a2 = fansGroupInfo.f421217d.f421211g.f421198h;
                a16.d(new QQLiveCustomDialog.Companion.DialogData(c10866a2.f421200b, c10866a2.f421201c, "\u53bb\u7eed\u8d39", "\u72e0\u5fc3\u62d2\u7edd"));
                a16.e(new d(fansGroupInfo));
                Activity topActivity = Foreground.getTopActivity();
                Intrinsics.checkNotNull(topActivity, "null cannot be cast to non-null type mqq.app.AppActivity");
                FragmentManager supportFragmentManager = ((AppActivity) topActivity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "Foreground.getTopActivit\u2026y).supportFragmentManager");
                a16.a().show(supportFragmentManager, "group_renewal_tips_dialog");
                this.isRenewalTipsShowing = true;
                kj4.b.d();
                return;
            }
            AegisLogger.INSTANCE.i("unknown|AnchorTopHeadView_", "showRenewalTipsDialog", "fail, no renewalTips");
            return;
        }
        AegisLogger.INSTANCE.i("unknown|AnchorTopHeadView_", "showRenewalTipsDialog", "fail, no diamondGroupInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        W();
        Runnable runnable = this.flipperRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().postDelayed(runnable, 0L);
        }
    }

    private final void W() {
        Runnable runnable = this.flipperRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
    }

    private final void y() {
        this.anchorLiveStatusTxv.setInAnimation(getContext(), R.anim.f154920tp);
        this.anchorLiveStatusTxv.setOutAnimation(getContext(), R.anim.f154921tq);
    }

    private final void z(long roomId, String programId, boolean showGold, boolean showPraise) {
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            topAreaViewModel.P(roomId, programId, showGold, showPraise);
        }
        this.flipperRunnable = new FlipperRunnable(this, showGold, showPraise);
    }

    public final void P(boolean isLandscape) {
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            topAreaViewModel.q0(isLandscape);
        }
    }

    public final void Q(@Nullable String nickname, @Nullable String avatar) {
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null && topAreaViewModel.U()) {
            topAreaViewModel.g0(nickname);
            topAreaViewModel.f0(avatar);
        }
    }

    public final void X() {
        TopAreaViewModel topAreaViewModel;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (topAreaViewModel = this.viewModel) != null) {
            topAreaViewModel.y().removeObservers(lifecycleOwner);
            topAreaViewModel.x().removeObservers(lifecycleOwner);
            topAreaViewModel.z().removeObservers(lifecycleOwner);
            topAreaViewModel.E().removeObservers(lifecycleOwner);
            topAreaViewModel.D().removeObservers(lifecycleOwner);
            topAreaViewModel.B().removeObservers(lifecycleOwner);
            topAreaViewModel.A().removeObservers(lifecycleOwner);
            topAreaViewModel.t().removeObservers(lifecycleOwner);
            topAreaViewModel.G().removeObservers(lifecycleOwner);
            topAreaViewModel.u().removeObservers(lifecycleOwner);
        }
        this.lifecycleOwner = null;
        TopAreaViewModel topAreaViewModel2 = this.viewModel;
        if (topAreaViewModel2 != null) {
            topAreaViewModel2.m0();
        }
    }

    public final void Y(boolean likeEnable) {
        this.mAegisLog.i("unknown|AnchorTopHeadView_", 1, "updateConfig likeEnable:" + likeEnable);
        this.enablePraise = likeEnable;
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            topAreaViewModel.w0(likeEnable);
        }
    }

    public final void Z() {
        this.mAegisLog.i("unknown|AnchorTopHeadView_", 1, "updateFollowState");
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            a.C9953a.a(topAreaViewModel, false, 1, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isDetachedFromWindow = true;
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            topAreaViewModel.n();
        }
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onEnterRoom(long roomId, boolean isAnchor) {
        String str;
        this.mAegisLog.i("unknown|AnchorTopHeadView_", 1, "onEnterRoom roomId:" + roomId + ", isAnchor:" + isAnchor);
        setVisibility(0);
        this.hadEnterRoom = true;
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            S(topAreaViewModel);
            topAreaViewModel.Q(roomId, this.roomType, isAnchor);
            topAreaViewModel.o();
            topAreaViewModel.a0(com.tencent.timi.game.utils.b.d(this));
            TopAreaViewModel topAreaViewModel2 = this.viewModel;
            if (topAreaViewModel2 != null) {
                str = topAreaViewModel2.getPlatform();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual("huya", str)) {
                this.anchorLiveStatusTxv.setVisibility(8);
            }
        }
        A(roomId, isAnchor);
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onExitRoom(long roomId) {
        this.mAegisLog.i("unknown|AnchorTopHeadView_", 1, "onExitRoom: viewModel:" + this.viewModel);
        this.mAegisLog.i("unknown|AnchorTopHeadView_", 1, "onExitRoom roomId:" + roomId);
        W();
        this.flipperRunnable = null;
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            topAreaViewModel.p();
        }
        x();
        this.hadEnterRoom = false;
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPreload(long roomId, boolean isAnchor, @Nullable String videoUrl) {
        TopAreaViewModel topAreaViewModel = this.viewModel;
        if (topAreaViewModel != null) {
            S(topAreaViewModel);
            topAreaViewModel.Q(roomId, this.roomType, isAnchor);
            topAreaViewModel.preload();
        }
        setVisibility(0);
    }

    public final void setLifecycle(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleOwner = owner;
        E();
    }

    public final void setQQLive() {
        R();
    }

    public final void setRoomType(int i3) {
        this.roomType = i3;
    }

    public final void setViewModel(@NotNull TopAreaViewModel vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.mAegisLog.i("unknown|AnchorTopHeadView_", 1, "setViewModel " + this);
        vm5.s0(this);
        this.viewModel = vm5;
        vm5.V();
        if (this.lifecycleOwner != null) {
            E();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopHeadView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorTopHeadView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopHeadView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.enablePraise = true;
        View.inflate(context, R.layout.htc, this);
        View findViewById = findViewById(R.id.f26470dm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.portraitIgv)");
        this.portraitIgv = (RoundCornerImageView) findViewById;
        View findViewById2 = findViewById(R.id.sne);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.anchorLiveStatusTxv)");
        this.anchorLiveStatusTxv = (TextSwitcher) findViewById2;
        View findViewById3 = findViewById(R.id.f25520b2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.placeHolderView)");
        this.placeHolderView = findViewById3;
        View findViewById4 = findViewById(R.id.f166375zm0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.nameTxv)");
        this.nameTxv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.zlx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.nameContainer)");
        this.nameContainer = (LinearLayout) findViewById5;
        setBackgroundResource(R.drawable.lqf);
        C();
    }

    private final void x() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Integer num) {
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageIn(long roomId) {
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageOut(long roomId) {
    }
}
