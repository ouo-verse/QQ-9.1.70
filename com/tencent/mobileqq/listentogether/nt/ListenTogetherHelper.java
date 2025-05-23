package com.tencent.mobileqq.listentogether.nt;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.d;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qqnt.aio.helper.cw;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001N\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"J\b\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\b\u0010+\u001a\u00020*H\u0016J7\u00102\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00072\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001000/\"\u0004\u0018\u000100H\u0016\u00a2\u0006\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010>R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010AR\u0016\u0010E\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010DR\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/listentogether/nt/ListenTogetherHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mobileqq/aio/notification/e;", "", "isMultiSelect", "", BdhLogUtil.LogTag.Tag_Conn, "", "state", "B", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", ReportConstant.COSTREPORT_PREFIX, "o", "u", "r", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "uiModel", "event", "w", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "v", "D", HippyTKDListViewAdapter.X, "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/aio/api/runtime/a;", "aioContext", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onMoveToState", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", h.F, "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "e", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", "eventType", "", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/listentogether/ui/BaseListenTogetherPanel;", "f", "Lcom/tencent/mobileqq/listentogether/ui/BaseListenTogetherPanel;", "mListenTogetherPanel", "I", "mChatType", "i", "Z", "mIsPanelShow", "isSelectedMode", "Ljava/lang/String;", "curMusicTitle", "Lcom/tencent/mobileqq/aio/notification/c;", "E", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "simpleUIModel", "Lcom/tencent/mvi/base/route/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mvi/base/route/a;", "mAction1", "com/tencent/mobileqq/listentogether/nt/ListenTogetherHelper$c", "G", "Lcom/tencent/mobileqq/listentogether/nt/ListenTogetherHelper$c;", "mTipBarStatusListener", "<init>", "()V", "H", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes33.dex */
public final class ListenTogetherHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mobileqq.aio.notification.e {

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.aio.notification.c notificationManager;

    /* renamed from: E, reason: from kotlin metadata */
    private IAIONotificationUIModel.b simpleUIModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BaseListenTogetherPanel mListenTogetherPanel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mChatType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPanelShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectedMode;

    /* renamed from: C, reason: from kotlin metadata */
    private String curMusicTitle = "";

    /* renamed from: F, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1 = new b();

    /* renamed from: G, reason: from kotlin metadata */
    private final c mTipBarStatusListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/listentogether/nt/ListenTogetherHelper$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
                ListenTogetherHelper.this.C(((AIOMsgListEvent.MultiSelectModeChangeEvent) i3).b());
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean isMultiSelect) {
        this.isSelectedMode = isMultiSelect;
        if (isMultiSelect) {
            this.mTipBarStatusListener.onHide(false);
        } else if (y()) {
            this.mTipBarStatusListener.a(false);
        }
    }

    private final void o() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        baseListenTogetherPanel.A();
    }

    private final void p() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        baseListenTogetherPanel.p();
    }

    private final void q() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        baseListenTogetherPanel.q();
    }

    private final void r() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        baseListenTogetherPanel.s();
    }

    private final void s() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        baseListenTogetherPanel.x();
    }

    private final void t() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        baseListenTogetherPanel.z();
    }

    private final void u() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        baseListenTogetherPanel.B();
    }

    public final void A(com.tencent.aio.api.runtime.a aioContext) {
        BaseListenTogetherPanel bVar;
        j e16;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.mAIOContext = aioContext;
        com.tencent.mobileqq.listentogether.nt.c.f241083a.a(aioContext.g().r().c().j(), this);
        FragmentActivity activity = aioContext.c().getActivity();
        if (activity == null) {
            activity = QBaseActivity.sTopActivity;
        }
        this.mContext = activity;
        int e17 = aioContext.g().r().c().e();
        this.mChatType = e17;
        if (e17 == 2) {
            bVar = new com.tencent.mobileqq.listentogether.ui.c(aioContext, this.mContext);
            bVar.E(this.mTipBarStatusListener);
        } else {
            bVar = new com.tencent.mobileqq.listentogether.ui.b(aioContext, this.mContext);
            bVar.E(this.mTipBarStatusListener);
        }
        this.mListenTogetherPanel = bVar;
        if (this.notificationManager != null || (e16 = aioContext.e()) == null) {
            return;
        }
        e16.d(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
        Unit unit = Unit.INSTANCE;
    }

    public final void D() {
        this.mTipBarStatusListener.a(true);
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    public IAIONotificationUIModel e() {
        if (this.simpleUIModel == null) {
            this.simpleUIModel = new IAIONotificationUIModel.b(AIONotificationBusiId.LISTEN_MUSIC_TOGETHER, this.curMusicTitle, IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, "", 0, new Function2<IAIONotificationUIModel, Integer, Unit>() { // from class: com.tencent.mobileqq.listentogether.nt.ListenTogetherHelper$getNotificationUIModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                    invoke(iAIONotificationUIModel, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(IAIONotificationUIModel uiModel, int i3) {
                    Intrinsics.checkNotNullParameter(uiModel, "uiModel");
                    ListenTogetherHelper.this.w((IAIONotificationUIModel.b) uiModel, i3);
                }
            });
        }
        IAIONotificationUIModel.b bVar = this.simpleUIModel;
        if (bVar != null) {
            BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
            if (baseListenTogetherPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
                baseListenTogetherPanel = null;
            }
            String i3 = baseListenTogetherPanel.i();
            Intrinsics.checkNotNullExpressionValue(i3, "mListenTogetherPanel.curListenerCountTitle");
            bVar.h(i3);
        }
        IAIONotificationUIModel.b bVar2 = this.simpleUIModel;
        if (bVar2 != null) {
            bVar2.g(IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW);
        }
        IAIONotificationUIModel.b bVar3 = this.simpleUIModel;
        Intrinsics.checkNotNull(bVar3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationUIModel");
        return bVar3;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.R;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "ListenTogetherHelper";
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(AIONotificationBusiId.LISTEN_MUSIC_TOGETHER);
        return listOf;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, Object... params) {
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        this.notificationManager = notificationManager;
        if ((notificationManager instanceof com.tencent.qqnt.aio.toptips.c) && (this.mAIOContext == null || this.mContext == null)) {
            A(notificationManager.a());
        }
        onMoveToState(eventType);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        A(param.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        if (r0 == null) goto L12;
     */
    @Override // com.tencent.aio.main.businesshelper.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDestroy() {
        j e16;
        Unit unit;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null) {
            com.tencent.mobileqq.listentogether.nt.c.f241083a.b(aVar.g().r().c().j());
        }
        com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
        if (cVar != null) {
            IAIONotificationUIModel.b bVar = this.simpleUIModel;
            if (bVar != null) {
                cVar.g(bVar.getToken());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
            Unit unit2 = Unit.INSTANCE;
        }
        this.notificationManager = null;
        this.mAIOContext = null;
        this.mContext = null;
        h.a.b(this);
        this.mChatType = 0;
        this.mIsPanelShow = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        B(state);
        if (state == 12) {
            q();
        } else if (state == com.tencent.mobileqq.aio.notification.d.INSTANCE.c()) {
            q();
        }
    }

    public final String v() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        String k3 = baseListenTogetherPanel.k(this.mIsPanelShow);
        if (k3 == null) {
            k3 = "";
        }
        if (!TextUtils.isEmpty(k3)) {
            return k3;
        }
        if (this.mIsPanelShow) {
            String qqStr = HardCodeUtil.qqStr(R.string.isv);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.listen_together_subtitle_hide)");
            return qqStr;
        }
        String qqStr2 = HardCodeUtil.qqStr(R.string.isw);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.listen_together_subtitle_show)");
        return qqStr2;
    }

    public final void x() {
        this.mTipBarStatusListener.onHide(true);
    }

    public final boolean y() {
        BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
        if (baseListenTogetherPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
            baseListenTogetherPanel = null;
        }
        return baseListenTogetherPanel.n();
    }

    /* renamed from: z, reason: from getter */
    public final boolean getMIsPanelShow() {
        return this.mIsPanelShow;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/listentogether/nt/ListenTogetherHelper$c", "Lcom/tencent/mobileqq/listentogether/nt/e;", "", "forceUpdate", "", "a", "onHide", "c", "d", "", "musicTitle", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements e {
        c() {
        }

        @Override // com.tencent.mobileqq.listentogether.nt.e
        public void a(boolean forceUpdate) {
            com.tencent.mobileqq.aio.notification.c cVar = ListenTogetherHelper.this.notificationManager;
            if (cVar != null) {
                cVar.c(ListenTogetherHelper.this.e());
            }
            ListenTogetherHelper.this.mIsPanelShow = true;
        }

        @Override // com.tencent.mobileqq.listentogether.nt.e
        public boolean c() {
            return ListenTogetherHelper.this.mIsPanelShow;
        }

        @Override // com.tencent.mobileqq.listentogether.nt.e
        public void d() {
            j e16;
            com.tencent.mobileqq.aio.notification.c cVar = ListenTogetherHelper.this.notificationManager;
            if (cVar == null) {
                com.tencent.aio.api.runtime.a aVar = ListenTogetherHelper.this.mAIOContext;
                if (aVar == null || (e16 = aVar.e()) == null) {
                    return;
                }
                e16.h(new AIOTitleEvent.SubTitleRequestEvent(0));
                return;
            }
            ListenTogetherHelper listenTogetherHelper = ListenTogetherHelper.this;
            IAIONotificationUIModel e17 = listenTogetherHelper.e();
            if (listenTogetherHelper.mIsPanelShow) {
                cVar.j(e17.getToken(), e17);
            }
        }

        @Override // com.tencent.mobileqq.listentogether.nt.e
        public void onHide(boolean forceUpdate) {
            IAIONotificationUIModel.b bVar;
            com.tencent.mobileqq.aio.notification.c cVar = ListenTogetherHelper.this.notificationManager;
            if (cVar != null && (bVar = ListenTogetherHelper.this.simpleUIModel) != null) {
                cVar.g(bVar.getToken());
            }
            ListenTogetherHelper.this.mIsPanelShow = false;
        }

        @Override // com.tencent.mobileqq.listentogether.nt.e
        public void b(String musicTitle) {
            Unit unit;
            if (musicTitle != null) {
                ListenTogetherHelper.this.curMusicTitle = musicTitle;
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ListenTogetherHelper.this.curMusicTitle = "";
            }
            com.tencent.mobileqq.aio.notification.c cVar = ListenTogetherHelper.this.notificationManager;
            if (cVar != null) {
                ListenTogetherHelper listenTogetherHelper = ListenTogetherHelper.this;
                IAIONotificationUIModel e16 = listenTogetherHelper.e();
                if (listenTogetherHelper.mIsPanelShow) {
                    cVar.j(e16.getToken(), e16);
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12, 3, 4, 8, 9, 11};
    }

    private final void B(int state) {
        if (state == 0) {
            p();
            return;
        }
        if (state == 3) {
            t();
            return;
        }
        if (state == 8) {
            s();
            return;
        }
        if (state == 4) {
            o();
            return;
        }
        if (state == 9) {
            u();
            return;
        }
        if (state == 11) {
            r();
            return;
        }
        d.Companion companion = com.tencent.mobileqq.aio.notification.d.INSTANCE;
        if (state == companion.a()) {
            p();
            return;
        }
        if (state == companion.e()) {
            t();
            return;
        }
        if (state == companion.d()) {
            s();
            return;
        }
        if (state == companion.b()) {
            o();
        } else if (state == companion.g()) {
            u();
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(IAIONotificationUIModel.b uiModel, int event) {
        if (event == 1 || event == 2) {
            BaseListenTogetherPanel baseListenTogetherPanel = this.mListenTogetherPanel;
            if (baseListenTogetherPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListenTogetherPanel");
                baseListenTogetherPanel = null;
            }
            baseListenTogetherPanel.v();
        }
    }
}
