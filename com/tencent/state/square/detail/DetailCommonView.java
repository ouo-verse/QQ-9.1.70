package com.tencent.state.square.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.map.Location;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.avatar.filament.SquareAvatarFilamentView;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.MapResourceType;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.databinding.VasSquareDetailCommonBinding;
import com.tencent.state.square.detail.DetailCommonView;
import com.tencent.state.square.flower.FlowerLayoutView;
import com.tencent.state.square.flower.FlowerMedalTagView;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.like.IStickersChangedListener;
import com.tencent.state.square.location.LocationIconType;
import com.tencent.state.square.location.LocationView;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.PlayConfig;
import com.tencent.state.square.media.SquarePlayerPool;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.BaseAvatarAnimator;
import com.tencent.state.view.BubbleElementEventListener;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.IAvatarBubble;
import com.tencent.state.view.SquareImageView;
import hs4.t;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vs4.o;
import wx4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008b\u0001B\u0015\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001B\u001f\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0088\u0001B(\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001\u0012\u0007\u0010\u0089\u0001\u001a\u000202\u00a2\u0006\u0006\b\u0084\u0001\u0010\u008a\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0003J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0002J*\u0010&\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$J\u0018\u0010+\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020)J$\u00101\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020)2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/J,\u00108\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u0016\u0010:\u001a\u00020\u00042\u0006\u0010\r\u001a\u0002092\u0006\u00105\u001a\u00020\u001bJ\u0006\u0010;\u001a\u00020\u0004J\"\u0010>\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0016J$\u0010@\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020)2\b\u0010?\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010A\u001a\u00020\fJ\u0006\u0010B\u001a\u00020\fJ\u0006\u0010D\u001a\u00020CJ\u0006\u0010E\u001a\u00020CJ\u0006\u0010F\u001a\u00020\fJ\u0006\u0010G\u001a\u00020\fJ0\u0010M\u001a\u00020\u00042\u0006\u0010H\u001a\u0002022\b\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010K\u001a\u00020)2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015J\u000e\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020)J\b\u0010Q\u001a\u0004\u0018\u00010PJ\b\u0010R\u001a\u0004\u0018\u00010PJ\u0006\u0010S\u001a\u00020\u0018J\u0016\u0010W\u001a\u00020)2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020)J$\u0010[\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020X2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u00040ZJ\u0006\u0010]\u001a\u00020\\J\u0016\u0010a\u001a\u00020\u00042\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020)R\u0014\u0010b\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010eR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010iR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010jR\u0016\u0010l\u001a\u00020k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010u\u001a\u00020t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0017\u0010\u0080\u0001\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/state/square/detail/DetailCommonView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "Lcom/tencent/state/view/BubbleElementEventListener;", "", "checkNeedShowSettingTips", "", "duration", "showSettingTips", "hideSettingTips", "initTouchEvent", "initClickListener", "Landroid/view/View;", "view", "gotoProfile", "bindElement", "initUserInfoView", "initAvatar", "handleAvatarDoubleClick", "initHeadIcon", "initNick", "Lkotlin/Function0;", "callback", "startEnterAnima", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "createAvatarView", "", "", "", "getAvatarLocationReportData", "Lcom/tencent/state/square/data/SquareAvatarItem;", "data", "Lcom/tencent/state/square/detail/EntranceSource;", "entranceSource", "Lcom/tencent/state/square/detail/DetailCommonListener;", "socialStatusListener", "Lcom/tencent/state/square/detail/DetailCommonView$CommonListener;", "commonListener", "initView", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "inviteState", "", "isStatusPanelShown", "updatePartnerStatus", "Lcom/tencent/state/view/AvatarOnlineStatusDetailBubble;", "bubble", "forceShowBubble", "Lcom/tencent/state/square/like/IStickersChangedListener;", "stickersChangedListener", "initBubbleView", "", "remainingTasks", "type", "uin", "Landroid/graphics/Bitmap;", "avatar", "onDecodeTaskCompleted", "Landroid/widget/ImageView;", "setAvatarFace", "destroy", NodeProps.VISIBLE, "isPlaying", "onSongIconExpose", "songMid", "onSongIconClick", "getMultiTitleContainer", "getMultiParent", "Landroid/widget/TextView;", "getMultiCountDown", "getMultiTitle", "getSetting", "getPosterShare", "flowerCount", "Lcom/tencent/state/square/flower/data/MedalData;", "flowerMedal", "ignoreAnim", "onClickTag", "updateFlower", "isEnter", "startEditorAnima", "Lcom/tencent/state/map/Location;", "getEditorAvatarLocation", "getAvatarLocation", "getAvatarView", "Landroid/view/MotionEvent;", "e", "isEditor", "isClickAvatar", "Lcom/tencent/state/square/data/Resource;", "resource", "Lkotlin/Function1;", "updateAvatar", "Lcom/tencent/state/square/location/LocationView;", "getLocationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "location", "needOffset", "updateLocationView", "isFilamentOn", "Z", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/square/databinding/VasSquareDetailCommonBinding;", "binding", "Lcom/tencent/state/square/databinding/VasSquareDetailCommonBinding;", "Lcom/tencent/state/square/data/SquareAvatarItem;", "Lcom/tencent/state/square/detail/EntranceSource;", "Lcom/tencent/state/square/api/IFaceDecoder;", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "Lcom/tencent/state/square/IReporter;", "reporter", "Lcom/tencent/state/square/IReporter;", "Lcom/tencent/state/utils/FastClickUtils;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "Lcom/tencent/state/square/detail/DetailAnimaConfig;", "detailConfig", "Lcom/tencent/state/square/detail/DetailAnimaConfig;", "Lcom/tencent/state/square/detail/DetailAvatarAnimator;", "animator", "Lcom/tencent/state/square/detail/DetailAvatarAnimator;", "Lcom/tencent/state/square/detail/DetailMeSettingTipsBubble;", "settingTips", "Lcom/tencent/state/square/detail/DetailMeSettingTipsBubble;", "Lvs4/o;", "partner", "Lvs4/o;", "avatarView", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CommonListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailCommonView extends RelativeLayout implements IDecodeTaskCompletionListener, BubbleElementEventListener {
    private DetailAvatarAnimator animator;
    private IFaceDecoder avatarFaceDecoder;
    private final ISquareAvatarView avatarView;
    private final VasSquareDetailCommonBinding binding;
    private final FastClickUtils clickUtils;
    private WeakReference<CommonListener> commonListener;
    private SquareAvatarItem data;
    private DetailAnimaConfig detailConfig;
    private EntranceSource entranceSource;
    private final boolean isFilamentOn;
    private o partner;
    private final IReporter reporter;
    private DetailMeSettingTipsBubble settingTips;
    private WeakReference<DetailCommonListener> socialStatusListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/detail/DetailCommonView$CommonListener;", "", "onBackEvent", "", "onDecodeComplete", "uin", "", "avatar", "Landroid/graphics/Bitmap;", "onDoubleClickEvent", "e", "Landroid/view/MotionEvent;", "onEnterScaleAnimEnd", "onIsEditEnter", "", "onSingleClickEvent", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface CommonListener {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public static final class DefaultImpls {
            public static void onDoubleClickEvent(CommonListener commonListener) {
            }

            public static void onDoubleClickEvent(CommonListener commonListener, MotionEvent e16) {
                Intrinsics.checkNotNullParameter(e16, "e");
            }
        }

        void onBackEvent();

        void onDecodeComplete(String uin, Bitmap avatar);

        void onDoubleClickEvent();

        void onDoubleClickEvent(MotionEvent e16);

        void onEnterScaleAnimEnd();

        /* renamed from: onIsEditEnter */
        boolean getIsEditorPage();

        void onSingleClickEvent(MotionEvent e16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailCommonView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isFilamentOn = SquareSwitchUtils.INSTANCE.enableFilamentDetail();
        VasSquareDetailCommonBinding inflate = VasSquareDetailCommonBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailCommonBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Square square = Square.INSTANCE;
        this.avatarFaceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.reporter = square.getConfig().getReporter();
        this.clickUtils = new FastClickUtils(800L);
        this.detailConfig = DetailAvatarConfig.INSTANCE.defaultDetailConfig();
        ISquareAvatarView createAvatarView = createAvatarView();
        this.avatarView = createAvatarView;
        RelativeLayout relativeLayout = inflate.titleContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.titleContainer");
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Function0 function0 = null;
        boolean z16 = false;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 != null && getContext() != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            layoutParams2.topMargin = squareUtil.getStatusBarHeight(context2) + ViewExtensionsKt.dip(getContext(), 9.0f);
        }
        this.avatarFaceDecoder.setDecodeTaskCompletionListener(this);
        createAvatarView.setConfig(new AvatarAnimConfig(false, new SquarePlayerPool(function0, 1, z16 ? 1 : 0), new PlayConfig(-1, true, null, 4, null), true));
        inflate.avatarViewContent.addView((View) (createAvatarView instanceof View ? createAvatarView : null));
        initClickListener();
        setClipChildren(false);
        setClipToPadding(false);
        FlowerMedalTagView flowerMedalTagView = inflate.flowerMedalTag;
        FrameLayout frameLayout = inflate.flowerAnimationContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.flowerAnimationContainer");
        flowerMedalTagView.init(frameLayout);
    }

    private final void bindElement() {
        IReporter iReporter = this.reporter;
        FrameLayout frameLayout = this.binding.back;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.back");
        iReporter.setElementInfo(frameLayout, "em_zplan_back", new LinkedHashMap(), false, false);
        IReporter iReporter2 = this.reporter;
        CircleBoarderImageView circleBoarderImageView = this.binding.avatar;
        Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.avatar");
        iReporter2.setElementInfo(circleBoarderImageView, SquareReportConst.ElementId.ELEMENT_ID_AVATAR, new LinkedHashMap(), false, false);
        IReporter iReporter3 = this.reporter;
        TextView textView = this.binding.nick;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nick");
        iReporter3.setElementInfo(textView, SquareReportConst.ElementId.ELEMENT_ID_NICKNAME, new LinkedHashMap(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkNeedShowSettingTips() {
        CommonListener commonListener;
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem == null || !squareAvatarItem.isMe()) {
            return;
        }
        WeakReference<CommonListener> weakReference = this.commonListener;
        if (weakReference == null || (commonListener = weakReference.get()) == null || !commonListener.getIsEditorPage()) {
            if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.KEY_SHOW_SETTING_TIPS + SquareBaseKt.getSquareCommon().getCurrentAccountUin(), false, null, false, 12, null)) {
                return;
            }
            showSettingTips(8000L);
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.KEY_SHOW_SETTING_TIPS + SquareBaseKt.getSquareCommon().getCurrentAccountUin(), true, null, false, 12, null);
        }
    }

    private final ISquareAvatarView createAvatarView() {
        if (this.isFilamentOn) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SquareAvatarFilamentView squareAvatarFilamentView = new SquareAvatarFilamentView(context, null, 0, 6, null);
            squareAvatarFilamentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return squareAvatarFilamentView;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        SquareAvatarView squareAvatarView = new SquareAvatarView(context2, null, 0, null, 14, null);
        squareAvatarView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return squareAvatarView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getAvatarLocationReportData() {
        String str;
        Map<String, Object> mutableMapOf;
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem != null) {
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("zplan_other_user_qq", squareAvatarItem.getUin());
            AvatarLocationInfo locationInfo = squareAvatarItem.getLocationInfo();
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POI_ID, locationInfo != null ? locationInfo.getPoiId() : null);
            AvatarLocationInfo locationInfo2 = squareAvatarItem.getLocationInfo();
            pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POI_NAME, locationInfo2 != null ? locationInfo2.getPoi() : null);
            if (squareAvatarItem.isMe()) {
                str = SquareReportConst.PageId.PAGE_ID_HOST_DETAIL;
            } else {
                str = SquareReportConst.PageId.PAGE_ID_CUSTOM_DETAIL;
            }
            pairArr[3] = TuplesKt.to("pgid", str);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return mutableMapOf;
        }
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoProfile(View view) {
        WeakReference<DetailCommonListener> weakReference;
        DetailCommonListener detailCommonListener;
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.CLICK_USER_INFO, this.entranceSource, this.data, null, false, 24, null) || (weakReference = this.socialStatusListener) == null || (detailCommonListener = weakReference.get()) == null) {
            return;
        }
        detailCommonListener.goToProfile(view, this.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAvatarDoubleClick() {
        CommonListener commonListener;
        if (this.data != null) {
            WeakReference<CommonListener> weakReference = this.commonListener;
            if (weakReference != null && (commonListener = weakReference.get()) != null) {
                commonListener.onDoubleClickEvent();
            }
            Square.INSTANCE.getConfig().getCommonUtils().phoneVibrate(3, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideSettingTips() {
        DetailMeSettingTipsBubble detailMeSettingTipsBubble = this.settingTips;
        if (detailMeSettingTipsBubble != null) {
            detailMeSettingTipsBubble.dismiss();
            detailMeSettingTipsBubble.getBinding().getMRv().removeCallbacks(null);
            detailMeSettingTipsBubble.getBinding().getMRv().setOnClickListener(null);
        }
        this.settingTips = null;
    }

    private final void initAvatar() {
        SquareAvatarExtra extra;
        RelativeLayout relativeLayout = this.binding.avatarImage;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarImage");
        int i3 = 0;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.binding.avatarImage;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.avatarImage");
        ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
        layoutParams.width = this.detailConfig.getAvatarWidth();
        layoutParams.height = this.detailConfig.getAvatarHeight();
        FlowerLayoutView flowerLayoutView = this.binding.flowerView;
        Intrinsics.checkNotNullExpressionValue(flowerLayoutView, "binding.flowerView");
        com.tencent.state.ViewExtensionsKt.updateLayoutParams(flowerLayoutView, new Function1<ViewGroup.LayoutParams, Unit>() { // from class: com.tencent.state.square.detail.DetailCommonView$initAvatar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.LayoutParams layoutParams2) {
                invoke2(layoutParams2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGroup.LayoutParams receiver) {
                DetailAnimaConfig detailAnimaConfig;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                detailAnimaConfig = DetailCommonView.this.detailConfig;
                receiver.height = detailAnimaConfig.getAvatarWidth() / 3;
            }
        });
        FlowerLayoutView flowerLayoutView2 = this.binding.flowerView;
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null) {
            i3 = extra.getFlowerCount();
        }
        flowerLayoutView2.setFlowerCount(i3);
        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            final WeakReference weakReference = new WeakReference(this);
            ISquareAvatarView iSquareAvatarView = this.avatarView;
            if (!(iSquareAvatarView instanceof SquareAvatarFilamentView)) {
                iSquareAvatarView = null;
            }
            SquareAvatarFilamentView squareAvatarFilamentView = (SquareAvatarFilamentView) iSquareAvatarView;
            if (squareAvatarFilamentView != null) {
                squareAvatarFilamentView.setDoubleClickListener(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailCommonView$initAvatar$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        DetailCommonView detailCommonView = (DetailCommonView) weakReference.get();
                        if (detailCommonView != null) {
                            detailCommonView.handleAvatarDoubleClick();
                        }
                    }
                });
            }
        }
    }

    private final void initClickListener() {
        this.binding.avatar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                DetailCommonView detailCommonView = DetailCommonView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailCommonView.gotoProfile(it);
            }
        });
        this.binding.nick.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                DetailCommonView detailCommonView = DetailCommonView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailCommonView.gotoProfile(it);
            }
        });
        this.binding.setting.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initClickListener$3
            /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
            
                r1 = r0.this$0.socialStatusListener;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view) {
                FastClickUtils fastClickUtils;
                WeakReference weakReference;
                DetailCommonListener detailCommonListener;
                fastClickUtils = DetailCommonView.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick() || weakReference == null || (detailCommonListener = (DetailCommonListener) weakReference.get()) == null) {
                    return;
                }
                detailCommonListener.onMenuClick();
            }
        });
        this.binding.share.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initClickListener$4
            /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
            
                r1 = r0.this$0.socialStatusListener;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view) {
                FastClickUtils fastClickUtils;
                WeakReference weakReference;
                DetailCommonListener detailCommonListener;
                fastClickUtils = DetailCommonView.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick() || weakReference == null || (detailCommonListener = (DetailCommonListener) weakReference.get()) == null) {
                    return;
                }
                detailCommonListener.onSharePosterClick();
            }
        });
        this.binding.back.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initClickListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IReporter iReporter;
                WeakReference weakReference;
                DetailCommonView.CommonListener commonListener;
                iReporter = DetailCommonView.this.reporter;
                Intrinsics.checkNotNullExpressionValue(view, "view");
                iReporter.reportEvent("clck", view, new LinkedHashMap());
                weakReference = DetailCommonView.this.commonListener;
                if (weakReference == null || (commonListener = (DetailCommonView.CommonListener) weakReference.get()) == null) {
                    return;
                }
                commonListener.onBackEvent();
            }
        });
        this.binding.locationInfo.setTextColor(R.color.f81466);
        this.binding.locationInfo.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initClickListener$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareAvatarItem squareAvatarItem;
                IReporter iReporter;
                VasSquareDetailCommonBinding vasSquareDetailCommonBinding;
                Map<String, Object> avatarLocationReportData;
                squareAvatarItem = DetailCommonView.this.data;
                if (squareAvatarItem != null) {
                    IRouter router = Square.INSTANCE.getConfig().getRouter();
                    Context context = DetailCommonView.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    router.routeToMapPage(context, squareAvatarItem.getLocationInfo().getLongitude(), squareAvatarItem.getLocationInfo().getLatitude(), squareAvatarItem.getLocationInfo().getPoi(), squareAvatarItem.getLocationInfo().getPoiId(), squareAvatarItem.getLocationInfo().getPoiAddress());
                    iReporter = DetailCommonView.this.reporter;
                    vasSquareDetailCommonBinding = DetailCommonView.this.binding;
                    LocationView locationView = vasSquareDetailCommonBinding.locationInfo;
                    Intrinsics.checkNotNullExpressionValue(locationView, "binding.locationInfo");
                    avatarLocationReportData = DetailCommonView.this.getAvatarLocationReportData();
                    iReporter.reportEvent("clck", locationView, avatarLocationReportData);
                }
            }
        });
    }

    private final void initHeadIcon() {
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem != null) {
            if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_USER_INFO, this.entranceSource, squareAvatarItem, null, false, 24, null)) {
                CircleBoarderImageView circleBoarderImageView = this.binding.avatar;
                Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.avatar");
                circleBoarderImageView.setVisibility(4);
            } else {
                CircleBoarderImageView circleBoarderImageView2 = this.binding.avatar;
                Intrinsics.checkNotNullExpressionValue(circleBoarderImageView2, "binding.avatar");
                circleBoarderImageView2.setVisibility(0);
                CircleBoarderImageView circleBoarderImageView3 = this.binding.avatar;
                Intrinsics.checkNotNullExpressionValue(circleBoarderImageView3, "binding.avatar");
                setAvatarFace(circleBoarderImageView3, squareAvatarItem.getUin());
            }
        }
    }

    private final void initNick() {
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem != null) {
            if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_USER_INFO, this.entranceSource, squareAvatarItem, null, false, 24, null)) {
                TextView textView = this.binding.nick;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.nick");
                textView.setVisibility(4);
            } else {
                TextView textView2 = this.binding.nick;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.nick");
                textView2.setVisibility(0);
                TextView textView3 = this.binding.nick;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.nick");
                textView3.setText(squareAvatarItem.getNickName());
            }
        }
    }

    private final void initTouchEvent() {
        if (this.data != null) {
            final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initTouchEvent$$inlined$let$lambda$1
                /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
                
                    r0 = r1.this$0.commonListener;
                 */
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onDoubleTap(MotionEvent e16) {
                    WeakReference weakReference;
                    DetailCommonView.CommonListener commonListener;
                    if (e16 != null && !SquareSwitchUtils.INSTANCE.enableFilamentDetail() && weakReference != null && (commonListener = (DetailCommonView.CommonListener) weakReference.get()) != null) {
                        commonListener.onDoubleClickEvent(e16);
                    }
                    return super.onDoubleTap(e16);
                }

                /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
                
                    r0 = r1.this$0.commonListener;
                 */
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onSingleTapConfirmed(MotionEvent e16) {
                    WeakReference weakReference;
                    DetailCommonView.CommonListener commonListener;
                    if (e16 != null && weakReference != null && (commonListener = (DetailCommonView.CommonListener) weakReference.get()) != null) {
                        commonListener.onSingleClickEvent(e16);
                    }
                    return super.onSingleTapConfirmed(e16);
                }
            });
            final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initTouchEvent$$inlined$let$lambda$2
                /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:
                
                    r2 = r1.this$0.socialStatusListener;
                 */
                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onScaleEnd(ScaleGestureDetector detector) {
                    WeakReference weakReference;
                    DetailCommonListener detailCommonListener;
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    if (detector.getScaleFactor() >= 1.0f || weakReference == null || (detailCommonListener = (DetailCommonListener) weakReference.get()) == null) {
                        return;
                    }
                    detailCommonListener.onBackClick();
                }
            });
            setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.detail.DetailCommonView$initTouchEvent$$inlined$let$lambda$3
                /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
                
                    r2 = r3.data;
                 */
                @Override // android.view.View.OnTouchListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    EntranceSource entranceSource;
                    SquareAvatarItem squareAvatarItem;
                    SquareAvatarExtra extra;
                    entranceSource = this.entranceSource;
                    if (entranceSource != null && entranceSource.fromSquare() && squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null && extra.getInSquare()) {
                        scaleGestureDetector.onTouchEvent(motionEvent);
                    }
                    gestureDetector.onTouchEvent(motionEvent);
                    return true;
                }
            });
        }
    }

    private final void initUserInfoView() {
        initHeadIcon();
        initNick();
    }

    private final void showSettingTips(final long duration) {
        hideSettingTips();
        Context context = getContext();
        if (!(context instanceof FragmentActivity)) {
            context = null;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity == null || fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        DetailMeSettingTipsBubble detailMeSettingTipsBubble = new DetailMeSettingTipsBubble(fragmentActivity);
        detailMeSettingTipsBubble.getBinding().getMRv().postDelayed(new Runnable() { // from class: com.tencent.state.square.detail.DetailCommonView$showSettingTips$$inlined$apply$lambda$1
            @Override // java.lang.Runnable
            public final void run() {
                DetailCommonView detailCommonView = (DetailCommonView) weakReference.get();
                if (detailCommonView != null) {
                    detailCommonView.hideSettingTips();
                }
            }
        }, duration);
        detailMeSettingTipsBubble.getBinding().getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailCommonView$showSettingTips$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailCommonView detailCommonView = (DetailCommonView) weakReference.get();
                if (detailCommonView != null) {
                    detailCommonView.hideSettingTips();
                }
            }
        });
        detailMeSettingTipsBubble.showAsDropDown(getSetting(), 0, 0);
        Unit unit = Unit.INSTANCE;
        this.settingTips = detailMeSettingTipsBubble;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startEnterAnima(Function0<Unit> callback) {
        Resource stateResource;
        MapPlayableSource mapPlayableSource;
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem == null || (stateResource = SquareResourceManagerKt.getStateResource(squareAvatarItem)) == null) {
            return;
        }
        if (this.isFilamentOn) {
            MapResourceType mapResourceType = MapResourceType.Filament;
            String uin = squareAvatarItem.getUin();
            SquareAvatarItem squareAvatarItem2 = this.data;
            mapPlayableSource = SquareItemKt.toMapPlayableSource(stateResource, mapResourceType, uin, squareAvatarItem2 != null ? Integer.valueOf(squareAvatarItem2.getDefaultResourceId()) : null);
        } else {
            SquareAvatarItem squareAvatarItem3 = this.data;
            mapPlayableSource = SquareItemKt.toMapPlayableSource(stateResource, squareAvatarItem3 != null ? Integer.valueOf(squareAvatarItem3.getDefaultResourceId()) : null);
        }
        DetailAvatarAnimator detailAvatarAnimator = this.animator;
        if (detailAvatarAnimator != null) {
            detailAvatarAnimator.enterScaleAnim(mapPlayableSource, SquareResourceManagerKt.hasSpecialState(squareAvatarItem), callback);
        }
    }

    public final void destroy() {
        hideSettingTips();
        this.avatarFaceDecoder.destroy();
    }

    public final Location getAvatarLocation() {
        DetailAvatarAnimator detailAvatarAnimator;
        if (this.data == null || (detailAvatarAnimator = this.animator) == null) {
            return null;
        }
        return detailAvatarAnimator.getAvatarLocation();
    }

    public final ISquareAvatarView getAvatarView() {
        return this.avatarView;
    }

    public final Location getEditorAvatarLocation() {
        DetailAvatarAnimator detailAvatarAnimator = this.animator;
        if (detailAvatarAnimator != null) {
            return detailAvatarAnimator.getEditorAvatarLocation();
        }
        return null;
    }

    public final LocationView getLocationInfo() {
        LocationView locationView = this.binding.locationInfo;
        Intrinsics.checkNotNullExpressionValue(locationView, "binding.locationInfo");
        return locationView;
    }

    public final TextView getMultiCountDown() {
        TextView textView = this.binding.multiCountDown;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.multiCountDown");
        return textView;
    }

    public final View getMultiParent() {
        FrameLayout frameLayout = this.binding.multiParentView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.multiParentView");
        return frameLayout;
    }

    public final TextView getMultiTitle() {
        TextView textView = this.binding.multiTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.multiTitle");
        return textView;
    }

    public final View getMultiTitleContainer() {
        LinearLayout linearLayout = this.binding.multiTitleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.multiTitleContainer");
        return linearLayout;
    }

    public final View getPosterShare() {
        SquareImageView squareImageView = this.binding.share;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.share");
        return squareImageView;
    }

    public final View getSetting() {
        SquareImageView squareImageView = this.binding.setting;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.setting");
        return squareImageView;
    }

    public final void initView(SquareAvatarItem data, EntranceSource entranceSource, DetailCommonListener socialStatusListener, final CommonListener commonListener) {
        Intrinsics.checkNotNullParameter(socialStatusListener, "socialStatusListener");
        Intrinsics.checkNotNullParameter(commonListener, "commonListener");
        this.data = data;
        this.entranceSource = entranceSource;
        this.commonListener = new WeakReference<>(commonListener);
        this.socialStatusListener = new WeakReference<>(socialStatusListener);
        bindElement();
        initUserInfoView();
        initAvatar();
        initTouchEvent();
        post(new Runnable() { // from class: com.tencent.state.square.detail.DetailCommonView$initView$1
            @Override // java.lang.Runnable
            public final void run() {
                VasSquareDetailCommonBinding vasSquareDetailCommonBinding;
                ISquareAvatarView iSquareAvatarView;
                DetailAnimaConfig detailAnimaConfig;
                VasSquareDetailCommonBinding vasSquareDetailCommonBinding2;
                VasSquareDetailCommonBinding vasSquareDetailCommonBinding3;
                VasSquareDetailCommonBinding vasSquareDetailCommonBinding4;
                VasSquareDetailCommonBinding vasSquareDetailCommonBinding5;
                DetailCommonView detailCommonView = DetailCommonView.this;
                vasSquareDetailCommonBinding = DetailCommonView.this.binding;
                RelativeLayout relativeLayout = vasSquareDetailCommonBinding.avatarImage;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarImage");
                iSquareAvatarView = DetailCommonView.this.avatarView;
                int width = DetailCommonView.this.getWidth();
                int height = DetailCommonView.this.getHeight();
                detailAnimaConfig = DetailCommonView.this.detailConfig;
                detailCommonView.animator = new DetailAvatarAnimator(relativeLayout, iSquareAvatarView, width, height, detailAnimaConfig);
                DetailCommonView.this.startEnterAnima(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailCommonView$initView$1.1
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
                        commonListener.onEnterScaleAnimEnd();
                    }
                });
                vasSquareDetailCommonBinding2 = DetailCommonView.this.binding;
                RelativeLayout relativeLayout2 = vasSquareDetailCommonBinding2.avatarImage;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.avatarImage");
                int height2 = DetailCommonView.this.getHeight();
                vasSquareDetailCommonBinding3 = DetailCommonView.this.binding;
                Intrinsics.checkNotNullExpressionValue(vasSquareDetailCommonBinding3.avatarImage, "binding.avatarImage");
                relativeLayout2.setY((height2 - r2.getHeight()) / 2.0f);
                vasSquareDetailCommonBinding4 = DetailCommonView.this.binding;
                RelativeLayout relativeLayout3 = vasSquareDetailCommonBinding4.avatarImage;
                Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.avatarImage");
                int width2 = DetailCommonView.this.getWidth();
                vasSquareDetailCommonBinding5 = DetailCommonView.this.binding;
                Intrinsics.checkNotNullExpressionValue(vasSquareDetailCommonBinding5.avatarImage, "binding.avatarImage");
                relativeLayout3.setX((width2 - r3.getWidth()) / 2.0f);
                DetailCommonView.this.checkNeedShowSettingTips();
            }
        });
        IReporter iReporter = this.reporter;
        FrameLayout frameLayout = this.binding.back;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.back");
        iReporter.reportEvent("imp", frameLayout, new LinkedHashMap());
    }

    public final boolean isClickAvatar(MotionEvent e16, boolean isEditor) {
        Location avatarLocation;
        Intrinsics.checkNotNullParameter(e16, "e");
        if (isEditor) {
            avatarLocation = getEditorAvatarLocation();
        } else {
            avatarLocation = getAvatarLocation();
        }
        return avatarLocation != null && e16.getRawY() > ((float) avatarLocation.getY()) && e16.getRawY() < ((float) (avatarLocation.getY() + avatarLocation.getHeight())) && e16.getRawX() > ((float) avatarLocation.getX()) && e16.getRawX() < ((float) (avatarLocation.getX() + avatarLocation.getWidth()));
    }

    @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, final Bitmap avatar) {
        WeakReference<CommonListener> weakReference;
        CommonListener commonListener;
        SquareAvatarItem squareAvatarItem = this.data;
        if (Intrinsics.areEqual(uin, squareAvatarItem != null ? squareAvatarItem.getUin() : null)) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailCommonView$onDecodeTaskCompleted$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    VasSquareDetailCommonBinding vasSquareDetailCommonBinding;
                    vasSquareDetailCommonBinding = DetailCommonView.this.binding;
                    vasSquareDetailCommonBinding.avatar.setImageBitmap(avatar);
                }
            });
        }
        if ((uin == null || uin.length() == 0) || (weakReference = this.commonListener) == null || (commonListener = weakReference.get()) == null) {
            return;
        }
        commonListener.onDecodeComplete(uin, avatar);
    }

    public final void setAvatarFace(ImageView view, String uin) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Bitmap bitmapFromCache$default = IFaceDecoder.DefaultImpls.getBitmapFromCache$default(this.avatarFaceDecoder, uin, false, 2, null);
        if (bitmapFromCache$default != null) {
            view.setImageBitmap(bitmapFromCache$default);
        } else {
            IFaceDecoder.DefaultImpls.requestDecodeFace$default(this.avatarFaceDecoder, uin, false, 2, null);
            view.setImageResource(R.drawable.i9d);
        }
    }

    public final void startEditorAnima(boolean isEnter) {
        DetailAvatarAnimator detailAvatarAnimator;
        if (this.data == null || (detailAvatarAnimator = this.animator) == null) {
            return;
        }
        detailAvatarAnimator.doAvatarScaleAnim(isEnter);
    }

    public final void updateAvatar(Resource resource, Function1<? super Boolean, Unit> callback) {
        String uin;
        DetailAvatarAnimator detailAvatarAnimator;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_AVATAR_MOTION, this.entranceSource, this.data, null, false, 24, null)) {
            if (this.isFilamentOn) {
                SquareAvatarItem squareAvatarItem = this.data;
                if (squareAvatarItem == null || (uin = squareAvatarItem.getUin()) == null || (detailAvatarAnimator = this.animator) == null) {
                    return;
                }
                BaseAvatarAnimator.updateAvatarFilament$default(detailAvatarAnimator, resource, uin, callback, false, 8, null);
                return;
            }
            DetailAvatarAnimator detailAvatarAnimator2 = this.animator;
            if (detailAvatarAnimator2 != null) {
                detailAvatarAnimator2.updateAvatar(resource, callback);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        if (r0.isMe() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateFlower(int flowerCount, MedalData flowerMedal, boolean ignoreAnim, Function0<Unit> onClickTag) {
        SquareAvatarItem squareAvatarItem = this.data;
        boolean z16 = squareAvatarItem != null;
        this.binding.flowerMedalTag.bind(z16, flowerMedal, ignoreAnim, onClickTag);
        this.binding.flowerView.setFlowerCount(flowerCount);
    }

    public final void updateLocationView(AvatarLocationInfo location, boolean needOffset) {
        Intrinsics.checkNotNullParameter(location, "location");
        if (!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_LOCATION_INFO, this.entranceSource, this.data, null, false, 24, null)) {
            getLocationInfo().setVisibility(8);
            return;
        }
        String poi = location.getPoi();
        if (poi == null || poi.length() == 0) {
            getLocationInfo().setVisibility(8);
            return;
        }
        this.binding.locationInfo.setTextColor(R.color.f81264);
        this.binding.locationInfo.setText(location.getPoi());
        LocationView locationView = this.binding.locationInfo;
        Intrinsics.checkNotNullExpressionValue(locationView, "binding.locationInfo");
        locationView.setVisibility(0);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        LocationIconType locationIconType = LocationIconType.PROFILE_SINGLE;
        if (needOffset) {
            intRef.element = 24;
            locationIconType = LocationIconType.SQUARE_AND_PROFILE_DOUBLE;
        }
        this.binding.locationInfo.setIconType(locationIconType);
        LocationView locationView2 = this.binding.locationInfo;
        Intrinsics.checkNotNullExpressionValue(locationView2, "binding.locationInfo");
        com.tencent.state.ViewExtensionsKt.updateLayoutParams(locationView2, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.detail.DetailCommonView$updateLocationView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.topMargin = com.tencent.state.ViewExtensionsKt.dip((View) DetailCommonView.this, intRef.element);
            }
        });
        IReporter iReporter = this.reporter;
        LocationView locationView3 = this.binding.locationInfo;
        Intrinsics.checkNotNullExpressionValue(locationView3, "binding.locationInfo");
        iReporter.setElementInfo(locationView3, SquareReportConst.ElementId.ELEMENT_ID_ZPLAN_AVATAR_LOCATION, getAvatarLocationReportData(), false, false);
        IReporter iReporter2 = this.reporter;
        LocationView locationView4 = this.binding.locationInfo;
        Intrinsics.checkNotNullExpressionValue(locationView4, "binding.locationInfo");
        iReporter2.reportEvent("imp", locationView4, getAvatarLocationReportData());
    }

    @Override // com.tencent.state.view.BubbleElementEventListener
    public void onSongIconExpose(View view, boolean visible, boolean isPlaying) {
        Map<String, Object> mutableMapOf;
        if (view != null) {
            this.reporter.setElementInfo(view, SquareReportConst.ElementId.ELEMENT_ID_LISTEN_TO_MUSIC, new LinkedHashMap(), false, false);
            IReporter iReporter = this.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_button_display_type", String.valueOf(d.INSTANCE.b(isPlaying))));
            iReporter.reportEvent("imp", view, mutableMapOf);
        }
    }

    public final void updatePartnerStatus(SquareMultiMotionDetailData inviteState, boolean isStatusPanelShown) {
        OnlineStatus formatOnlineStatus;
        if (!isStatusPanelShown && inviteState != null) {
            boolean z16 = true;
            if (inviteState.isInviteSuccess()) {
                SquareAvatarItem squareAvatarItem = this.data;
                String str = null;
                o otherUser = inviteState.getOtherUser(squareAvatarItem != null ? squareAvatarItem.getUin() : null);
                this.partner = otherUser;
                if (otherUser == null) {
                    LinearLayout linearLayout = this.binding.partnerContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.partnerContainer");
                    linearLayout.setVisibility(8);
                    return;
                }
                t tVar = otherUser.f443331d;
                if (tVar != null && (formatOnlineStatus = UserFormatKt.formatOnlineStatus(tVar)) != null) {
                    str = formatOnlineStatus.getCustomText();
                }
                if (otherUser.f443330c == 1) {
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        LinearLayout linearLayout2 = this.binding.partnerContainer;
                        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.partnerContainer");
                        linearLayout2.setVisibility(0);
                        CircleBoarderImageView circleBoarderImageView = this.binding.partnerAvatar;
                        Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.partnerAvatar");
                        setAvatarFace(circleBoarderImageView, String.valueOf(otherUser.f443328a));
                        TextView textView = this.binding.partnerStatus;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.partnerStatus");
                        textView.setText(UserFormatKt.toNickName(otherUser.f443329b, otherUser.f443328a) + MsgSummary.STR_COLON + str);
                        return;
                    }
                }
                LinearLayout linearLayout3 = this.binding.partnerContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.partnerContainer");
                linearLayout3.setVisibility(8);
                return;
            }
        }
        LinearLayout linearLayout4 = this.binding.partnerContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.partnerContainer");
        linearLayout4.setVisibility(8);
    }

    public final void initBubbleView(final AvatarOnlineStatusDetailBubble bubble, boolean forceShowBubble, IStickersChangedListener stickersChangedListener) {
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem != null) {
            bubble.setVisibility(((!UIStrategy.ensure$default(UIStrategy.INSTANCE, EnsureType.SHOW_STATUS_BUBBLE, this.entranceSource, squareAvatarItem, null, false, 24, null) || squareAvatarItem.getExtra().getOnlineStatus() == null) && !forceShowBubble) ? 8 : 0);
            if (bubble.getVisibility() != 0) {
                return;
            }
            OnlineStatus onlineStatus = squareAvatarItem.getExtra().getOnlineStatus();
            if (onlineStatus == null) {
                onlineStatus = new OnlineStatus(0, 0, 0, null, null, null, null, null, null, null, 1023, null);
            }
            this.reporter.reportEvent("imp", bubble, new LinkedHashMap());
            bubble.setElementEventListener(this);
            IAvatarBubble.DefaultImpls.setData$default(bubble, squareAvatarItem.getUin(), onlineStatus, squareAvatarItem.getStickers(), stickersChangedListener, squareAvatarItem.getExtra().getRelationType(), false, false, null, 224, null);
            final SquareBubbleInfo bubbleInfo = squareAvatarItem.getExtra().getBubbleInfo();
            if (bubbleInfo != null) {
                if (SquareBubbleSkinKt.isReady(bubbleInfo)) {
                    bubble.updateBubbleSkin(bubbleInfo);
                } else {
                    BubbleSkinDownloadManager.INSTANCE.getBubbleSkinBitmap(bubbleInfo.getSkinLink(), new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.detail.DetailCommonView$initBubbleView$$inlined$let$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                            invoke2(bitmap);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Bitmap bubbleBitmap) {
                            Intrinsics.checkNotNullParameter(bubbleBitmap, "bubbleBitmap");
                            SquareBubbleInfo.this.setBitmap(bubbleBitmap);
                            bubble.updateBubbleSkin(SquareBubbleInfo.this);
                        }
                    });
                }
            }
            View mainContainer = bubble.getMainContainer();
            if (mainContainer != null) {
                this.reporter.setElementInfo(mainContainer, SquareReportConst.ElementId.ELEMENT_ID_TEXT_EDIT, new LinkedHashMap(), false, false);
            }
        }
    }

    @Override // com.tencent.state.view.BubbleElementEventListener
    public void onSongIconClick(View view, boolean isPlaying, String songMid) {
        Map<String, Object> mutableMapOf;
        if (songMid == null || songMid.length() == 0) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            commonUtils.showToast(context, "\u97f3\u4e50\u64ad\u653e\u51fa\u9519\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1);
        } else {
            IRouter router = Square.INSTANCE.getConfig().getRouter();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            router.routeToSongPage(context2, songMid);
        }
        if (view != null) {
            IReporter iReporter = this.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_button_display_type", String.valueOf(d.INSTANCE.b(isPlaying))));
            iReporter.reportEvent("clck", view, mutableMapOf);
        }
    }

    public static /* synthetic */ void initBubbleView$default(DetailCommonView detailCommonView, AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble, boolean z16, IStickersChangedListener iStickersChangedListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            iStickersChangedListener = null;
        }
        detailCommonView.initBubbleView(avatarOnlineStatusDetailBubble, z16, iStickersChangedListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailCommonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.isFilamentOn = SquareSwitchUtils.INSTANCE.enableFilamentDetail();
        VasSquareDetailCommonBinding inflate = VasSquareDetailCommonBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailCommonBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Square square = Square.INSTANCE;
        this.avatarFaceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.reporter = square.getConfig().getReporter();
        this.clickUtils = new FastClickUtils(800L);
        this.detailConfig = DetailAvatarConfig.INSTANCE.defaultDetailConfig();
        ISquareAvatarView createAvatarView = createAvatarView();
        this.avatarView = createAvatarView;
        RelativeLayout relativeLayout = inflate.titleContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.titleContainer");
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Function0 function0 = null;
        boolean z16 = false;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 != null && getContext() != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            layoutParams2.topMargin = squareUtil.getStatusBarHeight(context2) + ViewExtensionsKt.dip(getContext(), 9.0f);
        }
        this.avatarFaceDecoder.setDecodeTaskCompletionListener(this);
        createAvatarView.setConfig(new AvatarAnimConfig(false, new SquarePlayerPool(function0, 1, z16 ? 1 : 0), new PlayConfig(-1, true, null, 4, null), true));
        inflate.avatarViewContent.addView((View) (createAvatarView instanceof View ? createAvatarView : null));
        initClickListener();
        setClipChildren(false);
        setClipToPadding(false);
        FlowerMedalTagView flowerMedalTagView = inflate.flowerMedalTag;
        FrameLayout frameLayout = inflate.flowerAnimationContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.flowerAnimationContainer");
        flowerMedalTagView.init(frameLayout);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailCommonView(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.isFilamentOn = SquareSwitchUtils.INSTANCE.enableFilamentDetail();
        VasSquareDetailCommonBinding inflate = VasSquareDetailCommonBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailCommonBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Square square = Square.INSTANCE;
        this.avatarFaceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.reporter = square.getConfig().getReporter();
        this.clickUtils = new FastClickUtils(800L);
        this.detailConfig = DetailAvatarConfig.INSTANCE.defaultDetailConfig();
        ISquareAvatarView createAvatarView = createAvatarView();
        this.avatarView = createAvatarView;
        RelativeLayout relativeLayout = inflate.titleContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.titleContainer");
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Function0 function0 = null;
        boolean z16 = false;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 != null && getContext() != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            layoutParams2.topMargin = squareUtil.getStatusBarHeight(context2) + ViewExtensionsKt.dip(getContext(), 9.0f);
        }
        this.avatarFaceDecoder.setDecodeTaskCompletionListener(this);
        createAvatarView.setConfig(new AvatarAnimConfig(false, new SquarePlayerPool(function0, 1, z16 ? 1 : 0), new PlayConfig(-1, true, null, 4, null), true));
        inflate.avatarViewContent.addView((View) (createAvatarView instanceof View ? createAvatarView : null));
        initClickListener();
        setClipChildren(false);
        setClipToPadding(false);
        FlowerMedalTagView flowerMedalTagView = inflate.flowerMedalTag;
        FrameLayout frameLayout = inflate.flowerAnimationContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.flowerAnimationContainer");
        flowerMedalTagView.init(frameLayout);
    }
}
