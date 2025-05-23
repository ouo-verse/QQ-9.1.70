package com.tencent.icgame.game.liveroom.impl.room.toparea;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.icgame.game.liveroom.impl.room.livewebdialog.f;
import com.tencent.icgame.game.liveroom.impl.room.toparea.OnlinePlayerInfoModelImpl;
import com.tencent.icgame.game.liveroom.impl.room.toparea.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.IQQLiveFollowStateListener;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 %2\u00020\u0001:\u0001/B\t\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u001b\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u000e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fJ\u0018\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0004J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u000bH\u0004J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000bJ\u0016\u0010+\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0014J\b\u0010,\u001a\u00020\u000bH\u0004J\u0006\u0010-\u001a\u00020\u0002R\"\u00105\u001a\u00020.8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\"\u0010\b\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010-\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010\n\u001a\u00020\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010C\u001a\u0004\bH\u0010E\"\u0004\bI\u0010GR*\u0010K\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010C\u001a\u0004\bK\u0010E\"\u0004\bL\u0010GR\"\u0010O\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010-\u001a\u0004\bM\u0010<\"\u0004\bN\u0010>R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR(\u0010^\u001a\b\u0012\u0004\u0012\u00020\t0X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\bQ\u0010[\"\u0004\b\\\u0010]R(\u0010a\u001a\b\u0012\u0004\u0012\u00020\t0X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010Z\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]R(\u0010e\u001a\b\u0012\u0004\u0012\u00020\t0X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010Z\u001a\u0004\bc\u0010[\"\u0004\bd\u0010]R(\u0010h\u001a\b\u0012\u0004\u0012\u00020\t0X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010Z\u001a\u0004\bU\u0010[\"\u0004\bg\u0010]R(\u0010k\u001a\b\u0012\u0004\u0012\u00020\t0X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010Z\u001a\u0004\bf\u0010[\"\u0004\bj\u0010]R(\u0010n\u001a\b\u0012\u0004\u0012\u00020\t0X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010Z\u001a\u0004\bl\u0010[\"\u0004\bm\u0010]R(\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010Z\u001a\u0004\bb\u0010[\"\u0004\bp\u0010]R(\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00140X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010Z\u001a\u0004\bY\u0010[\"\u0004\br\u0010]R(\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00070X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010Z\u001a\u0004\bi\u0010[\"\u0004\bt\u0010]R\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020w0v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010xR\u001d\u0010~\u001a\b\u0012\u0004\u0012\u00020w0z8\u0006\u00a2\u0006\f\n\u0004\b+\u0010{\u001a\u0004\b|\u0010}R*\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\r\u0010Z\u001a\u0004\b\u007f\u0010[\"\u0005\b\u0080\u0001\u0010]R+\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R+\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u0083\u0001\u001a\u0006\b\u008a\u0001\u0010\u0085\u0001\"\u0006\b\u008b\u0001\u0010\u0087\u0001R+\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u0083\u0001\u001a\u0006\b\u008e\u0001\u0010\u0085\u0001\"\u0006\b\u008f\u0001\u0010\u0087\u0001R\u0017\u0010\u0093\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0005\u0010\u0092\u0001R\u0015\u0010\u0094\u0001\u001a\u00020\u00078DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bo\u0010<\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/toparea/e;", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/a;", "", "H", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", "", "roomId", "", "roomType", "", "mIsAnchor", "v", "e", "f", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, BdhLogUtil.LogTag.Tag_Conn, "", "name", "G", "headUrl", UserInfo.SEX_FEMALE, "Landroid/view/View;", "view", "P", "B", "I", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/image/URLImageView;", "igv", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "r", QCircleDaTongConstant.ElementParamValue.FOLLOWED, "needReport", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isFollow", "L", "E", "currRoomId", "programId", "u", "l", "J", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "g", "()Lcom/tencent/icgame/common/api/IAegisLogApi;", "setAegisLog", "(Lcom/tencent/icgame/common/api/IAegisLogApi;)V", "aegisLog", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/OnlinePlayerInfoModelImpl;", "b", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/OnlinePlayerInfoModelImpl;", "onlinePlayerInfoModelImpl", "c", "p", "()J", "setRoomId", "(J)V", "getRoomType", "()I", "setRoomType", "(I)V", "Z", "isAnchor", "()Z", "setAnchor", "(Z)V", "isRelease", "setRelease", "value", MiniChatConstants.MINI_APP_LANDSCAPE, "M", h.F, "setAnchorId", "anchorId", "Landroid/graphics/drawable/ColorDrawable;", "i", "Landroid/graphics/drawable/ColorDrawable;", "defaultColorDrawable", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "j", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "currentLiveUserInfo", "Landroidx/lifecycle/MutableLiveData;", "k", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "setFollowTxvVisible", "(Landroidx/lifecycle/MutableLiveData;)V", "followTxvVisible", ReportConstant.COSTREPORT_PREFIX, "setUnfollowTxvVisible", "unfollowTxvVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getFollowPagAnimVisible", "setFollowPagAnimVisible", "followPagAnimVisible", DomainData.DOMAIN_NAME, "setFollowedIgvVisible", "followedIgvVisible", "o", "setPlaceHolderViewVisible", "placeHolderViewVisible", "getFollowFlVisible", "setFollowFlVisible", "followFlVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setNameLiveData", "nameLiveData", "setHeadUrlLiveData", "headUrlLiveData", "setPlayerNumLiveData", "playerNumLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lmz0/e;", "Landroidx/lifecycle/MediatorLiveData;", "_fansQQGroupData", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "getFansQQGroupData", "()Landroidx/lifecycle/LiveData;", "fansQQGroupData", "getFollowState", "setFollowState", "followState", "w", "Landroid/view/View;", "getReportTopHeadView", "()Landroid/view/View;", "O", "(Landroid/view/View;)V", "reportTopHeadView", HippyTKDListViewAdapter.X, "getReportFansGroupFlView", "N", "reportFansGroupFlView", "y", "getReportFollowTxvView", "setReportFollowTxvView", "reportFollowTxvView", "Lcom/tencent/mobileqq/icgame/api/IQQLiveFollowStateListener;", "Lcom/tencent/mobileqq/icgame/api/IQQLiveFollowStateListener;", "qqLiveFollowStateListener", "selfUid", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class e implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IAegisLogApi aegisLog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OnlinePlayerInfoModelImpl onlinePlayerInfoModelImpl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isRelease;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long anchorId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorDrawable defaultColorDrawable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LiveUserInfo currentLiveUserInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followTxvVisible;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> unfollowTxvVisible;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followPagAnimVisible;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followedIgvVisible;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> placeHolderViewVisible;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followFlVisible;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<String> nameLiveData;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<String> headUrlLiveData;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> playerNumLiveData;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<mz0.e> _fansQQGroupData;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<mz0.e> fansQQGroupData;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> followState;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View reportTopHeadView;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View reportFansGroupFlView;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View reportFollowTxvView;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveFollowStateListener qqLiveFollowStateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/toparea/e$b", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/OnlinePlayerInfoModelImpl$b;", "", "roomId", WidgetCacheConstellationData.NUM, "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements OnlinePlayerInfoModelImpl.b {
        b() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.toparea.OnlinePlayerInfoModelImpl.b
        public void a(long roomId, long num) {
            if (roomId == e.this.getRoomId()) {
                e.this.o().setValue(Long.valueOf(num));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/toparea/e$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements IQQLiveFollowCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            QQToast.makeText(BaseApplication.getContext(), "\u53d6\u6d88\u6536\u85cf\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff08" + errCode + "\uff09", 0).show();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            e.this.E(false, false);
        }
    }

    public e() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.roomId = -1L;
        this.defaultColorDrawable = new ColorDrawable(0);
        this.currentLiveUserInfo = new LiveUserInfo();
        this.followTxvVisible = new MutableLiveData<>();
        this.unfollowTxvVisible = new MutableLiveData<>();
        this.followPagAnimVisible = new MutableLiveData<>();
        this.followedIgvVisible = new MutableLiveData<>();
        this.placeHolderViewVisible = new MutableLiveData<>();
        this.followFlVisible = new MutableLiveData<>();
        this.nameLiveData = new MutableLiveData<>();
        this.headUrlLiveData = new MutableLiveData<>();
        this.playerNumLiveData = new MutableLiveData<>();
        MediatorLiveData<mz0.e> mediatorLiveData = new MediatorLiveData<>();
        this._fansQQGroupData = mediatorLiveData;
        this.fansQQGroupData = mediatorLiveData;
        this.followState = new MutableLiveData<>(Boolean.FALSE);
        this.qqLiveFollowStateListener = new IQQLiveFollowStateListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.toparea.d
            @Override // com.tencent.mobileqq.icgame.api.IQQLiveFollowStateListener
            public final void onFollowStateChange(long j3, long j16, int i3, String str) {
                e.D(e.this, j3, j16, i3, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0095, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r13, java.lang.String.valueOf(r7.roomId)) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x007a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r13, java.lang.String.valueOf(r7.roomId)) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0097, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void D(e this$0, long j3, long j16, int i3, String roomId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        this$0.aegisLog.i("ICGameAudience|ICGameTopAreaViewModel", 1, "qqLiveFollowStateListener uid:" + j3 + " followedId:" + j16 + ", isFollowed:" + i3 + ",roomId:" + roomId + ", selfUid:" + this$0.q() + ", mRoomId:" + this$0.roomId);
        if (this$0.roomType == 2) {
            Intrinsics.checkNotNullExpressionValue(roomId, "roomId");
            if (j16 == Long.parseLong(roomId)) {
                if (j3 == this$0.q()) {
                }
                z16 = false;
                if (!z16) {
                    if (i3 != 1) {
                        z17 = false;
                    }
                    this$0.E(z17, false);
                    return;
                }
                return;
            }
        }
        if (this$0.anchorId == j16) {
            if (j3 == this$0.q()) {
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final void K() {
        Object obj;
        View view = this.reportFollowTxvView;
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!this.isAnchor) {
            String str = "1";
            if (Intrinsics.areEqual(this.followState.getValue(), Boolean.TRUE)) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("icgame_follow_status", obj);
            if (!this.isLandscape) {
                str = "0";
            }
            hashMap.put("icgame_screen_orientation", str);
            hashMap.put("zengzhi_moduleid", "em_icgame_anchor_inf");
            mm4.a b16 = qx0.a.b(ru0.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11162a.a((ru0.a) b16, view, false, null, "em_icgame_follow", hashMap, 6, null);
        }
    }

    private final void t() {
        this.followTxvVisible.setValue(8);
        this.unfollowTxvVisible.setValue(8);
        this.followedIgvVisible.setValue(8);
        this.followPagAnimVisible.setValue(8);
        this.placeHolderViewVisible.setValue(8);
    }

    private final void z() {
        if (!l()) {
            this.aegisLog.e("ICGameAudience|ICGameTopAreaViewModel", 1, "loadingData initLiveRoom error!");
            return;
        }
        r42.b bVar = r42.b.f430720a;
        long h16 = r42.b.h(bVar, this.roomId, 0, 2, null);
        this.anchorId = h16;
        if (h16 <= 0) {
            this.aegisLog.w("ICGameAudience|ICGameTopAreaViewModel", 1, "[loadingData] invalid anchorUid, " + h16);
            return;
        }
        this.nameLiveData.setValue(r42.b.d(bVar, this.roomId, 0, 2, null));
        this.headUrlLiveData.setValue(r42.b.b(bVar, this.roomId, 0, 2, null));
        LiveUserInfo liveUserInfo = this.currentLiveUserInfo;
        liveUserInfo.uid = this.anchorId;
        liveUserInfo.nick = this.nameLiveData.getValue();
        this.currentLiveUserInfo.headUrl = this.headUrlLiveData.getValue();
        this.currentLiveUserInfo.sex = r42.b.f(bVar, this.roomId, 0, 2, null);
        if (this.isAnchor) {
            L(false);
            t();
        } else {
            a.C5841a.a(this, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(boolean followed, boolean needReport) {
        if (needReport) {
            L(followed);
        }
        if (followed && Intrinsics.areEqual(this.followState.getValue(), Boolean.TRUE)) {
            return;
        }
        this.followState.setValue(Boolean.valueOf(followed));
        E(followed, needReport);
    }

    public final void B() {
        b(new c());
    }

    public final void C(@Nullable Activity activity) {
        if (activity != null) {
            f.k(activity, cw0.a.a(this.anchorId, q(), 3));
        }
    }

    public final void E(boolean isFollow, boolean needReport) {
        this.followState.setValue(Boolean.valueOf(isFollow));
        this.placeHolderViewVisible.setValue(8);
        this.followFlVisible.setValue(8);
        this.followPagAnimVisible.setValue(8);
        if (needReport) {
            K();
        }
        if (isFollow) {
            this.followTxvVisible.setValue(8);
            this.followedIgvVisible.setValue(8);
            this.unfollowTxvVisible.setValue(0);
        } else {
            this.followTxvVisible.setValue(0);
            this.followedIgvVisible.setValue(8);
            this.unfollowTxvVisible.setValue(8);
        }
    }

    public final void F(@Nullable String headUrl) {
        this.aegisLog.i("ICGameAudience|ICGameTopAreaViewModel", "refreshHeadUrl url:" + headUrl);
        if (headUrl != null && !TextUtils.equals(this.headUrlLiveData.getValue(), headUrl)) {
            this.headUrlLiveData.setValue(headUrl);
        }
    }

    public final void G(@Nullable String name) {
        this.aegisLog.i("ICGameAudience|ICGameTopAreaViewModel", "refreshAudienceRoomAnchorInfo name:" + name);
        if (name != null && !TextUtils.equals(this.nameLiveData.getValue(), name)) {
            this.nameLiveData.setValue(name);
        }
    }

    public void I() {
        Q();
        H();
        TGLiveFollowManager.f115307a.p(this.qqLiveFollowStateListener);
    }

    public final void J() {
        this.isRelease = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(boolean isFollow) {
        Object obj;
        View view = this.reportTopHeadView;
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!this.isAnchor) {
            String str = "1";
            if (isFollow) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("icgame_follow_status", obj);
            if (!this.isLandscape) {
                str = "0";
            }
            hashMap.put("icgame_screen_orientation", str);
            mm4.a b16 = qx0.a.b(ru0.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11162a.a((ru0.a) b16, view, false, null, "em_icgame_anchor_inf", hashMap, 6, null);
            return;
        }
        mm4.a b17 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        a.C11162a.a((ru0.a) b17, view, false, null, "em_icgame_anchor_inf", hashMap, 6, null);
    }

    public final void M(boolean z16) {
        this.isLandscape = z16;
        Boolean value = this.followState.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        L(value.booleanValue());
    }

    public final void N(@Nullable View view) {
        this.reportFansGroupFlView = view;
    }

    public final void O(@Nullable View view) {
        this.reportTopHeadView = view;
    }

    public final void P(@Nullable Activity activity, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void Q() {
        TGLiveFollowManager.f115307a.r(this.qqLiveFollowStateListener);
    }

    public final void d() {
        Q();
    }

    public void e() {
        z();
        I();
    }

    public final void f() {
        OnlinePlayerInfoModelImpl onlinePlayerInfoModelImpl = this.onlinePlayerInfoModelImpl;
        if (onlinePlayerInfoModelImpl != null) {
            onlinePlayerInfoModelImpl.j();
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: g, reason: from getter */
    public final IAegisLogApi getAegisLog() {
        return this.aegisLog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final long getAnchorId() {
        return this.anchorId;
    }

    @NotNull
    public final MutableLiveData<Integer> i() {
        return this.followTxvVisible;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.followedIgvVisible;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.headUrlLiveData;
    }

    protected final boolean l() {
        return r42.b.q(r42.b.f430720a, this.roomId, 0, 2, null);
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.nameLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.placeHolderViewVisible;
    }

    @NotNull
    public final MutableLiveData<Long> o() {
        return this.playerNumLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    protected final long q() {
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo("1078", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            return loginInfo.getUid();
        }
        return 0L;
    }

    @NotNull
    public final URLDrawable.URLDrawableOptions r(@NotNull URLImageView igv) {
        Drawable drawable;
        Drawable drawable2;
        Intrinsics.checkNotNullParameter(igv, "igv");
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        if (igv.getDrawable() != null) {
            drawable = igv.getDrawable();
        } else {
            drawable = this.defaultColorDrawable;
        }
        options.mLoadingDrawable = drawable;
        if (igv.getDrawable() != null) {
            drawable2 = igv.getDrawable();
        } else {
            drawable2 = this.defaultColorDrawable;
        }
        options.mFailedDrawable = drawable2;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    @NotNull
    public final MutableLiveData<Integer> s() {
        return this.unfollowTxvVisible;
    }

    public final void u(long currRoomId, @NotNull String programId) {
        Intrinsics.checkNotNullParameter(programId, "programId");
        OnlinePlayerInfoModelImpl onlinePlayerInfoModelImpl = this.onlinePlayerInfoModelImpl;
        if (onlinePlayerInfoModelImpl != null) {
            onlinePlayerInfoModelImpl.h(currRoomId, programId, new b());
        }
    }

    public final void v(long roomId, int roomType, boolean mIsAnchor) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.isAnchor = mIsAnchor;
        if (this.onlinePlayerInfoModelImpl == null) {
            this.onlinePlayerInfoModelImpl = new OnlinePlayerInfoModelImpl();
        }
    }

    public boolean w() {
        return a.C5841a.b(this);
    }

    public boolean x() {
        return a.C5841a.c(this);
    }

    public boolean y() {
        return a.C5841a.d(this);
    }

    private final void H() {
    }
}
