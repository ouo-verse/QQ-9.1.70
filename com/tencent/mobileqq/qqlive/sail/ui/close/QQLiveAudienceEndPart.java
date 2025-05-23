package com.tencent.mobileqq.qqlive.sail.ui.close;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.close.a;
import com.tencent.mobileqq.qqlive.sail.ui.orientation.OrientationViewModel;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001kB\u000f\u0012\u0006\u00106\u001a\u000201\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u001b\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u0014\u0010\"\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0012\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\u0012\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010 H\u0016J*\u00103\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u00106\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010\u0019\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010DR\u0018\u0010J\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010DR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010TR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010WR\u001e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^R\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAudienceEndPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$b;", "", "initView", "Lst3/b;", "data", "sa", "", "uv", "", "Ea", "ta", "Lkotlinx/coroutines/Job;", "wa", "", "isFollowed", "Da", "va", "Lcom/tencent/mobileqq/qqlive/sail/model/b;", DownloadInfo.spKey_Config, "ra", "(Lcom/tencent/mobileqq/qqlive/sail/model/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hint", "millisUntilFinished", "", "xa", "ua", "Ba", "", "Lqr4/b;", "feeds", "Ca", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "U9", "V9", "v", NodeProps.ON_CLICK, "feed", "p5", "uid", "followedId", "", "roomId", "onFollowStateChange", "e", "I", "position", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "uiRoot", tl.h.F, "Landroid/view/View;", "closeBtn", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "avatar", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "nickname", BdhLogUtil.LogTag.Tag_Conn, "D", "totalUV", "E", "follow", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/a;", "G", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/a;", "recommendAdapter", "H", "J", "roomID", "anchorUID", "Ljava/util/List;", "recommendFeeds", "Lkotlinx/coroutines/flow/MutableStateFlow;", "K", "Lkotlinx/coroutines/flow/MutableStateFlow;", "followFlow", "L", "Lkotlinx/coroutines/Job;", "followFlowJob", "M", "autoSwitchRoomJob", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel;", "N", "Lkotlin/Lazy;", "za", "()Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel;", "closeViewModel", "<init>", "(I)V", "P", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceEndPart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, IQQLiveFollowApi.IQQLiveFollowStateListener, a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView hint;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView totalUV;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView follow;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private a recommendAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private long roomID;

    /* renamed from: I, reason: from kotlin metadata */
    private long anchorUID;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private List<qr4.b> recommendFeeds;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private MutableStateFlow<Boolean> followFlow;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Job followFlowJob;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Job autoSwitchRoomJob;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy closeViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup uiRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View closeBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView avatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nickname;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAudienceEndPart$a;", "", "", "AVATAR_SIZE", "I", "RECOMMEND_ITEM_COUNT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceEndPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAudienceEndPart$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IQQLiveCheckFollowCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceEndPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            AegisLogger.INSTANCE.w("Audience|QQLiveAudienceEndPart", "checkFollow", "roomId=" + QQLiveAudienceEndPart.this.roomID + ", errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isFollow);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|QQLiveAudienceEndPart", "checkFollow", "roomId=" + QQLiveAudienceEndPart.this.roomID + ", isFollow=" + isFollow);
            }
            MutableStateFlow mutableStateFlow = QQLiveAudienceEndPart.this.followFlow;
            if (mutableStateFlow != null) {
                boolean z16 = true;
                if (isFollow != 1) {
                    z16 = false;
                }
                mutableStateFlow.tryEmit(Boolean.valueOf(z16));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceEndPart(int i3) {
        List<qr4.b> emptyList;
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.position = i3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.recommendFeeds = emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CloseViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceEndPart$closeViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceEndPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CloseViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (CloseViewModel) QQLiveAudienceEndPart.this.getViewModel(CloseViewModel.class) : (CloseViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.closeViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ba() {
        String str;
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        aVar.i("pgin", aVar.f(this.roomID).a());
        HashMap hashMap = new HashMap();
        ImageView imageView = this.avatar;
        if (imageView != null) {
            aVar.b(imageView, false, null, "em_qqlive_anchor_inf", hashMap);
            aVar.h("imp", imageView, hashMap);
        }
        TextView textView = this.totalUV;
        if (textView != null) {
            aVar.b(textView, false, null, "em_qqlive_datamodule", hashMap);
            aVar.h("imp", textView, hashMap);
        }
        TextView textView2 = this.follow;
        if (textView2 != null) {
            QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
            if (TGLiveFollowManager.f377684a.n(this.anchorUID)) {
                str = "1";
            } else {
                str = "0";
            }
            qQLiveDaTongParams.t(str);
            HashMap<String, String> a16 = qQLiveDaTongParams.a();
            aVar.b(textView2, false, null, "em_qqlive_follow", a16);
            aVar.h("imp", textView2, a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da(boolean isFollowed) {
        if (isFollowed) {
            TextView textView = this.follow;
            if (textView != null) {
                textView.setText(getContext().getText(R.string.f210635in));
            }
            TextView textView2 = this.follow;
            if (textView2 != null) {
                textView2.setBackgroundResource(R.drawable.l2i);
            }
        } else {
            TextView textView3 = this.follow;
            if (textView3 != null) {
                textView3.setText(getContext().getText(R.string.f210625im));
            }
            TextView textView4 = this.follow;
            if (textView4 != null) {
                textView4.setBackgroundResource(R.drawable.l2h);
            }
        }
        TextView textView5 = this.follow;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
    }

    private final String Ea(long uv5) {
        if (uv5 <= 0) {
            return "--";
        }
        if (uv5 > 10000) {
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.CHINA, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) uv5) / 10000.0f)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                return format + "\u4e07";
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Audience|QQLiveAudienceEndPart", "transformUV", "error, ", e16);
                return "";
            }
        }
        return String.valueOf(uv5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        ViewGroup viewGroup;
        if (this.uiRoot != null) {
            return;
        }
        View partRootView = getPartRootView();
        if (partRootView != null) {
            viewGroup = (ViewGroup) partRootView.findViewById(R.id.f60242uw);
        } else {
            viewGroup = null;
        }
        this.uiRoot = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h9m, viewGroup, false), -1, -1);
            View findViewById = viewGroup.findViewById(R.id.f60142um);
            this.closeBtn = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
            this.avatar = (ImageView) viewGroup.findViewById(R.id.f60132ul);
            this.nickname = (TextView) viewGroup.findViewById(R.id.f60162uo);
            this.hint = (TextView) viewGroup.findViewById(R.id.f60172up);
            this.totalUV = (TextView) viewGroup.findViewById(R.id.f60222uu);
            TextView textView = (TextView) viewGroup.findViewById(R.id.f60152un);
            this.follow = textView;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            this.recyclerView = (RecyclerView) viewGroup.findViewById(R.id.f60202us);
            Ba();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[LOOP:0: B:11:0x004d->B:23:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object ra(com.tencent.mobileqq.qqlive.sail.model.b bVar, Continuation<? super Unit> continuation) {
        QQLiveAudienceEndPart$beginCountdownTime$1 qQLiveAudienceEndPart$beginCountdownTime$1;
        Object coroutine_suspended;
        int i3;
        long elapsedRealtime;
        long c16;
        QQLiveAudienceEndPart qQLiveAudienceEndPart;
        TextView textView;
        TextView textView2;
        if (continuation instanceof QQLiveAudienceEndPart$beginCountdownTime$1) {
            qQLiveAudienceEndPart$beginCountdownTime$1 = (QQLiveAudienceEndPart$beginCountdownTime$1) continuation;
            int i16 = qQLiveAudienceEndPart$beginCountdownTime$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qQLiveAudienceEndPart$beginCountdownTime$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qQLiveAudienceEndPart$beginCountdownTime$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQLiveAudienceEndPart$beginCountdownTime$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        long j3 = qQLiveAudienceEndPart$beginCountdownTime$1.J$1;
                        long j16 = qQLiveAudienceEndPart$beginCountdownTime$1.J$0;
                        bVar = (com.tencent.mobileqq.qqlive.sail.model.b) qQLiveAudienceEndPart$beginCountdownTime$1.L$1;
                        qQLiveAudienceEndPart = (QQLiveAudienceEndPart) qQLiveAudienceEndPart$beginCountdownTime$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        elapsedRealtime = j16;
                        c16 = j3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    c16 = bVar.c();
                    qQLiveAudienceEndPart = this;
                }
                while (JobKt.isActive(qQLiveAudienceEndPart$beginCountdownTime$1.get$context()) && c16 >= 0) {
                    c16 = bVar.c() - (SystemClock.elapsedRealtime() - elapsedRealtime);
                    CharSequence xa5 = qQLiveAudienceEndPart.xa(bVar.b(), c16);
                    textView2 = qQLiveAudienceEndPart.hint;
                    if (textView2 != null) {
                        textView2.setText(xa5);
                    }
                    qQLiveAudienceEndPart$beginCountdownTime$1.L$0 = qQLiveAudienceEndPart;
                    qQLiveAudienceEndPart$beginCountdownTime$1.L$1 = bVar;
                    qQLiveAudienceEndPart$beginCountdownTime$1.J$0 = elapsedRealtime;
                    qQLiveAudienceEndPart$beginCountdownTime$1.J$1 = c16;
                    qQLiveAudienceEndPart$beginCountdownTime$1.label = 1;
                    if (DelayKt.delay(300L, qQLiveAudienceEndPart$beginCountdownTime$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                textView = qQLiveAudienceEndPart.hint;
                if (textView != null) {
                    textView.setText(R.string.f1627721b);
                }
                SimpleEventBus.getInstance().dispatchEvent(new EndLiveAutoSwitchEvent(qQLiveAudienceEndPart.position));
                return Unit.INSTANCE;
            }
        }
        qQLiveAudienceEndPart$beginCountdownTime$1 = new QQLiveAudienceEndPart$beginCountdownTime$1(this, continuation);
        Object obj2 = qQLiveAudienceEndPart$beginCountdownTime$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQLiveAudienceEndPart$beginCountdownTime$1.label;
        if (i3 == 0) {
        }
        while (JobKt.isActive(qQLiveAudienceEndPart$beginCountdownTime$1.get$context())) {
            c16 = bVar.c() - (SystemClock.elapsedRealtime() - elapsedRealtime);
            CharSequence xa52 = qQLiveAudienceEndPart.xa(bVar.b(), c16);
            textView2 = qQLiveAudienceEndPart.hint;
            if (textView2 != null) {
            }
            qQLiveAudienceEndPart$beginCountdownTime$1.L$0 = qQLiveAudienceEndPart;
            qQLiveAudienceEndPart$beginCountdownTime$1.L$1 = bVar;
            qQLiveAudienceEndPart$beginCountdownTime$1.J$0 = elapsedRealtime;
            qQLiveAudienceEndPart$beginCountdownTime$1.J$1 = c16;
            qQLiveAudienceEndPart$beginCountdownTime$1.label = 1;
            if (DelayKt.delay(300L, qQLiveAudienceEndPart$beginCountdownTime$1) != coroutine_suspended) {
            }
        }
        textView = qQLiveAudienceEndPart.hint;
        if (textView != null) {
        }
        SimpleEventBus.getInstance().dispatchEvent(new EndLiveAutoSwitchEvent(qQLiveAudienceEndPart.position));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void sa(st3.b data) {
        String str;
        long j3;
        TextView textView;
        Job job;
        Job job2;
        st3.c cVar;
        st3.d dVar;
        st3.f[] fVarArr;
        st3.f fVar;
        boolean z16;
        String str2;
        st3.g gVar;
        st3.g gVar2;
        Option failedDrawableId = Option.obtain().setRequestWidth(wi2.c.b(65)).setRequestHeight(wi2.c.b(65)).setLoadingDrawableId(R.drawable.nmi).setFailedDrawableId(R.drawable.nmi);
        if (data != null && (gVar2 = data.f434719b) != null) {
            str = gVar2.f434732a;
        } else {
            str = null;
        }
        QCircleFeedPicLoader.g().loadImage(failedDrawableId.setUrl(str).setTargetView(this.avatar));
        TextView textView2 = this.nickname;
        if (textView2 != null) {
            if (data != null && (gVar = data.f434719b) != null) {
                str2 = gVar.f434733b;
            } else {
                str2 = null;
            }
            textView2.setText(str2);
        }
        if (data != null && (cVar = data.f434718a) != null && (dVar = cVar.f434722c) != null && (fVarArr = dVar.f434724a) != null) {
            int length = fVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    fVar = fVarArr[i3];
                    if (fVar.f434729a == 3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    fVar = null;
                    break;
                }
            }
            if (fVar != null) {
                j3 = fVar.f434731c;
                textView = this.totalUV;
                if (textView != null) {
                    textView.setText(Ea(j3));
                }
                job = this.followFlowJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.followFlowJob = wa();
                if (this.anchorUID > 0) {
                    ta();
                }
                TGLiveFollowManager.f377684a.u(this);
                if (this.recommendAdapter == null) {
                    a aVar = new a();
                    this.recommendAdapter = aVar;
                    RecyclerView recyclerView = this.recyclerView;
                    if (recyclerView != null) {
                        recyclerView.setAdapter(aVar);
                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                        recyclerView.addItemDecoration(new com.tencent.mobileqq.qqlive.sail.ui.close.b());
                    }
                    a aVar2 = this.recommendAdapter;
                    if (aVar2 != null) {
                        aVar2.m0(this);
                    }
                    a aVar3 = this.recommendAdapter;
                    if (aVar3 != null) {
                        aVar3.setData(this.recommendFeeds);
                    }
                }
                job2 = this.autoSwitchRoomJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.autoSwitchRoomJob = va();
            }
        }
        j3 = 0;
        textView = this.totalUV;
        if (textView != null) {
        }
        job = this.followFlowJob;
        if (job != null) {
        }
        this.followFlowJob = wa();
        if (this.anchorUID > 0) {
        }
        TGLiveFollowManager.f377684a.u(this);
        if (this.recommendAdapter == null) {
        }
        job2 = this.autoSwitchRoomJob;
        if (job2 != null) {
        }
        this.autoSwitchRoomJob = va();
    }

    private final void ta() {
        TGLiveFollowManager.f377684a.f(null, this.anchorUID, new b());
    }

    private final void ua() {
        Job job = this.followFlowJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.autoSwitchRoomJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        TGLiveFollowManager.f377684a.w(this);
    }

    private final Job va() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLiveAudienceEndPart$createAutoSwitchRoomJob$1(this, null), 3, null);
        return launch$default;
    }

    private final Job wa() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLiveAudienceEndPart$createFollowFlowJob$1(this, null), 3, null);
        return launch$default;
    }

    private final CharSequence xa(String hint, long millisUntilFinished) {
        int indexOf$default;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FFFFFF"));
        StyleSpan styleSpan = new StyleSpan(1);
        String valueOf = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(hint, Arrays.copyOf(new Object[]{valueOf}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        SpannableString spannableString = new SpannableString(format);
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString, valueOf, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
            return spannableString;
        }
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
        spannableString.setSpan(styleSpan, indexOf$default, valueOf.length() + indexOf$default, 33);
        return spannableString;
    }

    private final CloseViewModel za() {
        Object value = this.closeViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-closeViewModel>(...)");
        return (CloseViewModel) value;
    }

    public final void Ca(@NotNull List<qr4.b> feeds) {
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) feeds);
            return;
        }
        Intrinsics.checkNotNullParameter(feeds, "feeds");
        int i3 = this.position + 1;
        if (i3 < feeds.size()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.position + 4 + 1, feeds.size());
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|QQLiveAudienceEndPart", "setFeeds", "fromIndex=" + i3 + ", toIndex=" + coerceAtMost);
            }
            this.recommendFeeds = feeds.subList(i3, coerceAtMost);
            return;
        }
        AegisLogger.INSTANCE.w("Audience|QQLiveAudienceEndPart", "setFeeds", "roomId=" + this.roomID + ", not enough feeds, position=" + this.position + ", size=" + feeds.size());
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.U9();
        this.anchorUID = C9();
        if (this.follow != null) {
            ta();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.V9();
        Job job = this.autoSwitchRoomJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        TextView textView = this.hint;
        if (textView != null) {
            textView.setText(R.string.f1627721b);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60142um) {
                Activity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else if (num != null && num.intValue() == R.id.f60152un) {
                TGLiveFollowManager tGLiveFollowManager = TGLiveFollowManager.f377684a;
                if (tGLiveFollowManager.n(this.anchorUID)) {
                    TGLiveFollowManager.l(tGLiveFollowManager, null, this.anchorUID, this.roomID, null, 8, null);
                } else {
                    TGLiveFollowManager.i(tGLiveFollowManager, null, this.anchorUID, this.roomID, null, 8, null);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener
    public void onFollowStateChange(long uid, long followedId, int isFollowed, @Nullable String roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(uid), Long.valueOf(followedId), Integer.valueOf(isFollowed), roomId);
            return;
        }
        if (followedId == this.anchorUID && Intrinsics.areEqual(roomId, String.valueOf(this.roomID))) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceEndPart", "onFollowStateChange", "roomId=" + roomId + ", isFollowed=" + isFollowed);
            MutableStateFlow<Boolean> mutableStateFlow = this.followFlow;
            if (mutableStateFlow != null) {
                if (isFollowed == 1) {
                    z16 = true;
                }
                mutableStateFlow.tryEmit(Boolean.valueOf(z16));
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        this.roomID = H9();
        LiveData<st3.b> O1 = za().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<st3.b, Unit> function1 = new Function1<st3.b, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceEndPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceEndPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(st3.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable st3.b bVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceEndPart", "endPageDataChanged", "roomId=" + QQLiveAudienceEndPart.this.roomID + ", " + (bVar != null ? Integer.valueOf(bVar.hashCode()) : null));
                ((OrientationViewModel) QQLiveAudienceEndPart.this.getViewModel(OrientationViewModel.class)).L1(OrientationViewModel.RequestedOrientation.PORTRAIT);
                QQLiveAudienceEndPart.this.initView();
                QQLiveAudienceEndPart.this.sa(bVar);
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceEndPart.Aa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            ua();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.ui.close.a.b
    public void p5(@Nullable qr4.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) feed);
            return;
        }
        Intent intent = getPartHost().getHostActivity().getIntent();
        Unit unit = null;
        byte[] bArr = null;
        if (intent != null) {
            Intent intent2 = new Intent(intent);
            if (feed != null) {
                bArr = com.tencent.mobileqq.qqlive.sail.model.c.d(feed);
            }
            intent2.putExtra("key_launch_feed_bytes", bArr);
            getContext().startActivity(intent2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Audience|QQLiveAudienceEndPart", "onItemClick", "roomId=" + this.roomID + ", no host intent");
        }
    }
}
