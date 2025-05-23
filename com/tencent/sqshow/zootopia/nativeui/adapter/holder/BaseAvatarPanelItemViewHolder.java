package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import b94.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import com.tencent.state.report.SquareReportConst;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import i94.CollectInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressCallbackData;
import m94.DressControllerInitData;
import m94.DressErrorMsg;
import org.json.JSONObject;
import uv4.az;
import uv4.be;
import uv4.bk;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u001e2\u00020\u0001:\u0002}~B\u0017\u0012\u0006\u0010z\u001a\u00020y\u0012\u0006\u0010T\u001a\u00020O\u00a2\u0006\u0004\b{\u0010|J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J \u0010\u0016\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010\u0017\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0016\u0010\u0019\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0002J\u0006\u0010$\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0012J\u001e\u0010+\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0006\u0010,\u001a\u00020\u0002J0\u00102\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\r2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0/j\b\u0012\u0004\u0012\u00020-`0J\u000e\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0014J\u000e\u00105\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0014J\b\u00106\u001a\u00020\u0002H\u0016J\u0010\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u000207H\u0014J\u001c\u0010=\u001a\u00020\u00022\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00120:H\u0014J\b\u0010>\u001a\u00020\u0002H\u0014J\b\u0010?\u001a\u00020\u0006H\u0014J\u0010\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\b\u0010A\u001a\u00020\u0002H\u0014J\u0016\u0010C\u001a\u00020\u00022\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H\u0014J\b\u0010D\u001a\u00020\u0006H\u0004J\b\u0010E\u001a\u00020;H\u0014J\n\u0010G\u001a\u0004\u0018\u00010FH&J2\u0010H\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\r2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0/j\b\u0012\u0004\u0012\u00020-`0H&J\b\u0010I\u001a\u00020\u0014H&J\b\u0010J\u001a\u00020\u0006H&J\b\u0010K\u001a\u00020\u0006H\u0014J\b\u0010L\u001a\u00020\u0002H\u0014J\b\u0010M\u001a\u00020\u0002H\u0014J\b\u0010N\u001a\u00020\u0006H\u0004R\u0017\u0010T\u001a\u00020O8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR \u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\n0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010ZR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u0002070X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010ZR\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00060X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010ZR&\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00120:0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010ZR$\u0010f\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010b\u001a\u0004\b`\u0010c\"\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010NR\u0016\u0010i\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010KR\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010KR\"\u0010o\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010K\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010s\u001a\u00020p8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b@\u0010q\u001a\u0004\bg\u0010rR\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010v\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "I0", "K0", "s0", "", "running", "j0", "r0", "Lm94/c;", "data", "o0", "", "clickItemId", "E0", "z0", "", "Luv4/az;", "storeItems", "", "stepCost", "y0", "x0", "A0", "C0", "", "", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "U", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder$b;", "listener", "G0", "m0", "onViewRecycled", "H0", "T", "storeItem", "H", "Lqu4/a;", "avatarCharacter", "storeItemList", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Luv4/bk;", "posInList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "totalData", "y", "msg", "b0", "a0", "q0", "Li94/a;", "collectInfo", "f0", "Ljava/util/concurrent/ConcurrentHashMap;", "", "adStoreItem", "p0", "k0", "d0", BdhLogUtil.LogTag.Tag_Req, "w", "idList", "i0", "W", "N", "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "O", "e0", "J0", "Y", "Z", HippyTKDListViewAdapter.X, "v", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "E", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "L", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder$b;", "removeListener", "Landroidx/lifecycle/Observer;", "G", "Landroidx/lifecycle/Observer;", "currentDressIdObserver", "renderingDressIdObserver", "I", "collectChangeObserver", "dressTaskRunningStatusChangeObserver", "K", "watchAdStoreItemObserver", "Luv4/bk;", "()Luv4/bk;", "D0", "(Luv4/bk;)V", "bindingData", "M", "dressUpStartTime", "isItemResouceDownloaded", "isFromClicked", "getNeedSetCameraAfterDressed", "()Z", "F0", "(Z)V", "needSetCameraAfterDressed", "Lm94/h;", "Lm94/h;", "()Lm94/h;", "dressCallback", "Ljava/lang/Runnable;", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Runnable;", "mShowLoadingTask", "mRunnableToRemove", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseAvatarPanelItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: U, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Boolean> V;

    /* renamed from: E, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: F, reason: from kotlin metadata */
    private b removeListener;

    /* renamed from: G, reason: from kotlin metadata */
    private final Observer<List<String>> currentDressIdObserver;

    /* renamed from: H, reason: from kotlin metadata */
    private final Observer<DressCallbackData> renderingDressIdObserver;

    /* renamed from: I, reason: from kotlin metadata */
    private final Observer<CollectInfo> collectChangeObserver;

    /* renamed from: J, reason: from kotlin metadata */
    private final Observer<Boolean> dressTaskRunningStatusChangeObserver;

    /* renamed from: K, reason: from kotlin metadata */
    private final Observer<ConcurrentHashMap<Long, az>> watchAdStoreItemObserver;

    /* renamed from: L, reason: from kotlin metadata */
    private bk bindingData;

    /* renamed from: M, reason: from kotlin metadata */
    private long dressUpStartTime;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isItemResouceDownloaded;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isFromClicked;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean needSetCameraAfterDressed;

    /* renamed from: R, reason: from kotlin metadata */
    private final m94.h dressCallback;

    /* renamed from: S, reason: from kotlin metadata */
    private final Runnable mShowLoadingTask;

    /* renamed from: T, reason: from kotlin metadata */
    private Runnable mRunnableToRemove;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder$a;", "", "", "enableCameraAnimation$delegate", "Lkotlin/Lazy;", "a", "()Z", "enableCameraAnimation", "", "LOADING_DELAY", "J", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((Boolean) BaseAvatarPanelItemViewHolder.V.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder$b;", "", "Luv4/az;", "storeItem", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(az storeItem);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder$c", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements m94.h {
        c() {
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder$Companion$enableCameraAnimation$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanQQMC.INSTANCE.enableCameraAnimation());
            }
        });
        V = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAvatarPanelItemViewHolder(View itemView, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.currentDressIdObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseAvatarPanelItemViewHolder.B(BaseAvatarPanelItemViewHolder.this, (List) obj);
            }
        };
        this.renderingDressIdObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseAvatarPanelItemViewHolder.w0(BaseAvatarPanelItemViewHolder.this, (DressCallbackData) obj);
            }
        };
        this.collectChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseAvatarPanelItemViewHolder.A(BaseAvatarPanelItemViewHolder.this, (CollectInfo) obj);
            }
        };
        this.dressTaskRunningStatusChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseAvatarPanelItemViewHolder.I(BaseAvatarPanelItemViewHolder.this, (Boolean) obj);
            }
        };
        this.watchAdStoreItemObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseAvatarPanelItemViewHolder.L0(BaseAvatarPanelItemViewHolder.this, (ConcurrentHashMap) obj);
            }
        };
        this.dressCallback = new c();
        this.mShowLoadingTask = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.f
            @Override // java.lang.Runnable
            public final void run() {
                BaseAvatarPanelItemViewHolder.c0(BaseAvatarPanelItemViewHolder.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(BaseAvatarPanelItemViewHolder this$0, CollectInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.f0(it);
    }

    private final void A0() {
        final WeakReference weakReference = new WeakReference(this);
        this.mRunnableToRemove = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.i
            @Override // java.lang.Runnable
            public final void run() {
                BaseAvatarPanelItemViewHolder.B0(weakReference);
            }
        }, 128, null, true, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(BaseAvatarPanelItemViewHolder this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.i0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(WeakReference reference) {
        List<az> R;
        Intrinsics.checkNotNullParameter(reference, "$reference");
        BaseAvatarPanelItemViewHolder baseAvatarPanelItemViewHolder = (BaseAvatarPanelItemViewHolder) reference.get();
        if (baseAvatarPanelItemViewHolder == null || (R = baseAvatarPanelItemViewHolder.R()) == null) {
            return;
        }
        baseAvatarPanelItemViewHolder.C0(R);
    }

    private final void C0(List<az> storeItems) {
        Map<String, Object> P = P(storeItems);
        VideoReport.reportEvent("ev_zplan_try_clothes_cost", null, P);
        QLog.i(J0(), 1, "handleTaskCostReport params:" + P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(BaseAvatarPanelItemViewHolder this$0, b94.d dressController, UEAvatarGender targetGender, List storeItemList, qu4.a avatarCharacter) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dressController, "$dressController");
        Intrinsics.checkNotNullParameter(targetGender, "$targetGender");
        Intrinsics.checkNotNullParameter(storeItemList, "$storeItemList");
        Intrinsics.checkNotNullParameter(avatarCharacter, "$avatarCharacter");
        this$0.b0("clickItem#doDressFullItemList  running");
        this$0.w();
        dressController.Bg(targetGender, storeItemList, avatarCharacter, this$0.dressCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(BaseAvatarPanelItemViewHolder this$0, Runnable dressTask) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dressTask, "$dressTask");
        this$0.v();
        dressTask.run();
    }

    private final void E0(int clickItemId) {
        if (INSTANCE.a() && this.needSetCameraAfterDressed && clickItemId != 0) {
            this.needSetCameraAfterDressed = false;
            bk bkVar = this.bindingData;
            az azVar = bkVar != null ? bkVar.f440366b : null;
            if (azVar != null && azVar.f440275b == clickItemId) {
                CameraKey cameraKey = new CameraKey(azVar.F, 0, 2, null);
                if (Intrinsics.areEqual(cameraKey, this.channel.getCameraController().k())) {
                    return;
                }
                com.tencent.sqshow.zootopia.nativeui.ue.e.q(this.channel.getCameraController(), cameraKey, "item click", false, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(BaseAvatarPanelItemViewHolder this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.j0(it.booleanValue());
    }

    private final void I0() {
        NativePanelLoadingIgv O = O();
        if (O == null) {
            return;
        }
        O.f();
        O.setVisibility(0);
    }

    private final void K0() {
        this.channel.l().removeObserver(this.currentDressIdObserver);
        g94.b.f401562a.g().removeObserver(this.collectChangeObserver);
        com.tencent.sqshow.zootopia.nativeui.ue.n nVar = com.tencent.sqshow.zootopia.nativeui.ue.n.f371383a;
        nVar.f().removeObserver(this.dressTaskRunningStatusChangeObserver);
        nVar.e().removeObserver(this.renderingDressIdObserver);
        this.channel.L().removeObserver(this.watchAdStoreItemObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(BaseAvatarPanelItemViewHolder this$0, ConcurrentHashMap it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p0(it);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, Object> P(List<az> storeItems) {
        String h16;
        Object orNull;
        String str;
        Object orNull2;
        int i3;
        Object orNull3;
        DressControllerInitData initData;
        ZootopiaSource source;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController == null || (initData = avatarDressController.getInitData()) == null || (source = initData.getSource()) == null || (h16 = com.tencent.sqshow.zootopia.utils.ah.b(source)) == null) {
            h16 = ZPlanAvatarPreDownloadManager.f371947a.h();
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, h16);
        orNull = CollectionsKt___CollectionsKt.getOrNull(storeItems, 0);
        az azVar = (az) orNull;
        if (azVar == null || (str = r94.b.K(azVar)) == null) {
            str = "";
        }
        hashMap.put("zplan_item_id", str);
        hashMap.put("zplan_gender", Integer.valueOf(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex()));
        hashMap.put("zplan_is_ai_sculpt", "0");
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(storeItems, 0);
        az azVar2 = (az) orNull2;
        if (azVar2 != null) {
            boolean k3 = ZPlanAvatarPreDownloadManager.f371947a.k(r94.b.M(azVar2), azVar2.f440275b);
            String jsonElement = r94.b.J(azVar2).toString();
            Intrinsics.checkNotNullExpressionValue(jsonElement, "it.reportExtInfoJson().toString()");
            hashMap.put("zplan_ext_info", jsonElement);
            i3 = k3;
        } else {
            i3 = 0;
        }
        hashMap.put("zplan_is_pre_download", Integer.valueOf(i3));
        hashMap.put("zplan_use_times", String.valueOf(System.currentTimeMillis() - this.dressUpStartTime));
        orNull3 = CollectionsKt___CollectionsKt.getOrNull(storeItems, 0);
        az azVar3 = (az) orNull3;
        String str2 = azVar3 != null ? azVar3.K : null;
        hashMap.put("zplan_try_clothes_source", str2 != null ? str2 : "");
        return hashMap;
    }

    private final String Q() {
        az azVar;
        bk bkVar = this.bindingData;
        be beVar = (bkVar == null || (azVar = bkVar.f440366b) == null) ? null : azVar.f440290q;
        if (beVar == null) {
            return "0";
        }
        int i3 = beVar.f440324a;
        if (i3 > 0) {
            return String.valueOf(i3);
        }
        String arrays = Arrays.toString(beVar.f440325b);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    private final boolean U() {
        be beVar;
        int[] iArr;
        bk bkVar = this.bindingData;
        az azVar = bkVar != null ? bkVar.f440366b : null;
        return (azVar == null || (beVar = azVar.f440290q) == null || (iArr = beVar.f440325b) == null || iArr.length <= 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(BaseAvatarPanelItemViewHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0();
    }

    private final void j0(boolean running) {
        r0();
    }

    private final void o0(DressCallbackData data) {
        r0();
        z0();
        JSONObject clickedItem = data.getClickedItem();
        E0(clickedItem != null ? clickedItem.optInt("item_id") : 0);
    }

    private final void r0() {
        if (d0()) {
            H0();
            if (Z() && !this.isFromClicked && this.dressUpStartTime == 0) {
                this.dressUpStartTime = System.currentTimeMillis();
                this.isItemResouceDownloaded = Y();
                return;
            }
            return;
        }
        T();
    }

    private final void s0() {
        Runnable runnable = this.mRunnableToRemove;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 128);
            this.mRunnableToRemove = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(BaseAvatarPanelItemViewHolder this$0, DressCallbackData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        this$0.o0(data);
    }

    private final void x0(List<az> storeItems) {
        s0();
        Map<String, Object> P = P(storeItems);
        VideoReport.reportEvent("ev_zplan_try_clothes_success", null, P);
        VideoReport.reportEvent("ev_zplan_try_clothes_cost", null, P);
        QLog.i(J0(), 1, "handleTaskSucceedReport params:" + P);
    }

    private final void y0(List<az> storeItems, String stepCost) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(System.currentTimeMillis() - this.dressUpStartTime));
        String str = "1";
        if (this.channel.getEngineApi().getType() == AvatarEngineType.FILAMENT) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("is_filament", obj);
        if (this.isItemResouceDownloaded) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("downloaded", obj2);
        hashMap.put("file_size", String.valueOf(N()));
        if (U()) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        hashMap.put("is_set_clothes", obj3);
        if (this instanceof t) {
            obj4 = "1";
        } else {
            obj4 = "0";
        }
        hashMap.put("is_self_outfit", obj4);
        if (!this.isFromClicked) {
            str = "0";
        }
        hashMap.put("is_from_click", str);
        hashMap.put(MiniAppReportManager2.KEY_SLOT_ID, Q());
        hashMap.put("item_id", r94.b.p(storeItems));
        Map<String, String> a16 = com.tencent.zplan.common.utils.h.f385294a.a(stepCost);
        if (a16 != null) {
            hashMap.putAll(a16);
        }
        t74.r.e(null, "zplan_portal_try_clothes_cost", hashMap, 1, null);
        QLog.i(J0(), 1, "reportDressUpCost, params=" + hashMap);
    }

    private final void z0() {
        List<String> emptyList;
        List<az> R = R();
        if (R == null) {
            return;
        }
        DressCallbackData value = com.tencent.sqshow.zootopia.nativeui.ue.n.f371383a.e().getValue();
        if (value == null || (emptyList = value.b()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!r94.b.v(R, emptyList) || this.dressUpStartTime <= 0) {
            return;
        }
        y0(R, value != null ? value.getStep() : null);
        x0(R);
        this.dressUpStartTime = 0L;
        this.isFromClicked = false;
    }

    public void C(final qu4.a avatarCharacter, final List<az> storeItemList) {
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        Intrinsics.checkNotNullParameter(storeItemList, "storeItemList");
        UEAvatarGender n3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n();
        boolean B = r94.b.B(n3, Integer.valueOf(avatarCharacter.f429576e));
        if (B) {
            UEAvatarGender uEAvatarGender = UEAvatarGender.FEMALE;
            n3 = n3 == uEAvatarGender ? UEAvatarGender.MALE : uEAvatarGender;
        }
        b0("clickItem#doDressFullItemList - size = " + storeItemList.size() + ", needSwitchGender = " + B);
        final b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController != null) {
            final UEAvatarGender uEAvatarGender2 = n3;
            final Runnable runnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.g
                @Override // java.lang.Runnable
                public final void run() {
                    BaseAvatarPanelItemViewHolder.D(BaseAvatarPanelItemViewHolder.this, avatarDressController, uEAvatarGender2, storeItemList, avatarCharacter);
                }
            };
            if (!B) {
                runnable.run();
                return;
            }
            x();
            b94.d avatarDressController2 = this.channel.getAvatarDressController();
            if (avatarDressController2 != null) {
                d.a.b(avatarDressController2, n3, null, new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAvatarPanelItemViewHolder.E(BaseAvatarPanelItemViewHolder.this, runnable);
                    }
                }, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D0(bk bkVar) {
        this.bindingData = bkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F0(boolean z16) {
        this.needSetCameraAfterDressed = z16;
    }

    public final void G0(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.removeListener = listener;
    }

    public final void H(az storeItem) {
        Intrinsics.checkNotNullParameter(storeItem, "storeItem");
        b0("clickItem#doDressNewClothes - " + storeItem.f440274a + " - " + storeItem.f440277d);
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController != null) {
            w();
            avatarDressController.Lf(storeItem, this.dressCallback, NormalDressStrategy.ON_OR_OFF);
        }
    }

    public final void H0() {
        String J0 = J0();
        bk bkVar = this.bindingData;
        QLog.i(J0, 1, "showLoading item:" + (bkVar != null ? r94.b.Q(bkVar) : null));
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mShowLoadingTask, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean J() {
        return this.channel.getEngineApi().getType() != AvatarEngineType.UE_SMALL_HOME;
    }

    public abstract String J0();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: from getter */
    public final bk getBindingData() {
        return this.bindingData;
    }

    /* renamed from: L, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getChannel() {
        return this.channel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: M, reason: from getter */
    public final m94.h getDressCallback() {
        return this.dressCallback;
    }

    protected long N() {
        az azVar;
        bk bkVar = this.bindingData;
        be beVar = null;
        if ((bkVar != null ? bkVar.f440366b : null) == null) {
            return 0L;
        }
        if (bkVar != null && (azVar = bkVar.f440366b) != null) {
            beVar = azVar.f440290q;
        }
        if (beVar == null) {
            return 0L;
        }
        FilamentUrlTemplate a16 = this.channel.getEngineApi().a();
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
        String N0 = zPlanAvatarResourceHelper.N0(zPlanAvatarResourceHelper.p0(beVar.f440324a, r2.f440275b, a16), a16);
        if (N0 == null || N0.length() == 0) {
            return 0L;
        }
        return FileUtils.getFileOrFolderSize(N0);
    }

    public abstract NativePanelLoadingIgv O();

    protected List<az> R() {
        List<az> listOf;
        bk bkVar = this.bindingData;
        az azVar = bkVar != null ? bkVar.f440366b : null;
        if (azVar == null) {
            return null;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(azVar);
        return listOf;
    }

    public final void T() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mShowLoadingTask);
        NativePanelLoadingIgv O = O();
        if (O == null) {
            return;
        }
        O.setVisibility(8);
        O.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean W() {
        List<az> R = R();
        if (R == null) {
            return false;
        }
        return r94.b.v(R, this.channel.l().getValue());
    }

    public abstract boolean Y();

    protected boolean Z() {
        return false;
    }

    public final void a0(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e(J0(), 1, msg2);
    }

    public final void b0(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i(J0(), 1, msg2);
    }

    protected boolean d0() {
        List<String> emptyList;
        List<az> R = R();
        if (R == null) {
            return false;
        }
        List<String> value = this.channel.l().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        com.tencent.sqshow.zootopia.nativeui.ue.n nVar = com.tencent.sqshow.zootopia.nativeui.ue.n.f371383a;
        DressCallbackData value2 = nVar.e().getValue();
        if (value2 == null || (emptyList = value2.b()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        Boolean value3 = nVar.f().getValue();
        if (value3 == null) {
            value3 = Boolean.FALSE;
        }
        return value3.booleanValue() && r94.b.v(R, value) && !r94.b.v(R, emptyList);
    }

    public abstract void e0(bk data, int posInList, ArrayList<bk> totalData);

    protected void f0(CollectInfo collectInfo) {
        Intrinsics.checkNotNullParameter(collectInfo, "collectInfo");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0(List<String> idList) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        r0();
    }

    public final void m0() {
        az azVar;
        b bVar;
        bk bkVar = this.bindingData;
        if (bkVar == null || (azVar = bkVar.f440366b) == null || (bVar = this.removeListener) == null) {
            return;
        }
        bVar.a(azVar);
    }

    public final void onViewRecycled() {
        K0();
        s0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0(ConcurrentHashMap<Long, az> adStoreItem) {
        Intrinsics.checkNotNullParameter(adStoreItem, "adStoreItem");
    }

    public void q0() {
        s0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        if (!W()) {
            this.dressUpStartTime = System.currentTimeMillis();
            this.isItemResouceDownloaded = Y();
            s0();
            A0();
            return;
        }
        this.dressUpStartTime = 0L;
    }

    public final void y(bk data, int posInList, ArrayList<bk> totalData) {
        Intrinsics.checkNotNullParameter(totalData, "totalData");
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController != null) {
            avatarDressController.ce(this.dressCallback);
        }
        this.bindingData = data;
        r0();
        e0(data, posInList, totalData);
        this.dressUpStartTime = 0L;
    }

    public final void z() {
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        this.channel.l().observe(lifecycleOwner, this.currentDressIdObserver);
        g94.b.f401562a.g().observe(lifecycleOwner, this.collectChangeObserver);
        com.tencent.sqshow.zootopia.nativeui.ue.n nVar = com.tencent.sqshow.zootopia.nativeui.ue.n.f371383a;
        nVar.f().observe(lifecycleOwner, this.dressTaskRunningStatusChangeObserver);
        nVar.e().observe(lifecycleOwner, this.renderingDressIdObserver);
        this.channel.L().observe(lifecycleOwner, this.watchAdStoreItemObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0() {
        this.isFromClicked = true;
        r0();
    }

    protected void v() {
    }

    protected void x() {
    }
}
