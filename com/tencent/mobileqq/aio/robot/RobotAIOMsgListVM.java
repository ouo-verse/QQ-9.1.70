package com.tencent.mobileqq.aio.robot;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.factory.param.o;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgListMviIntent;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVM;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.uistate.AIOMsgListViewState;
import com.tencent.mobileqq.aio.msglist.w;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.robot.helper.RobotEventIntent;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.aio.background.a;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.kernel.nativeinterface.AioConfig;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002NR\u0018\u0000 /2\u00020\u0001:\u0002deB\u000f\u0012\u0006\u0010a\u001a\u00020`\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H\u0002J\u001e\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001c\u001a\u00020\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016J\u0018\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020(2\u0006\u0010-\u001a\u00020,H\u0014J\b\u00100\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u000201H\u0016J\b\u00104\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u000205H\u0016J\u0010\u00108\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u000207H\u0016R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\u001fR\u0016\u0010K\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010\u001fR\u0016\u0010M\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010DR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR<\u0010\\\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020Y0W0Vj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020Y0W`Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010[R<\u0010_\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020]0W0Vj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020]0W`Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010[\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/RobotAIOMsgListVM;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM;", "", "S0", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListMviIntent$k;", "intent", "b1", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListMviIntent$j;", "V0", "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Lcom/tencent/mobileqq/aio/event/RobotMsgIntent$GetRobotQAMsgList;", "Lcom/tencent/mobileqq/aio/event/e$d;", "U0", "Lcom/tencent/mobileqq/aio/event/RobotMsgIntent$GetLatestRobotMsg;", "Lcom/tencent/mobileqq/aio/event/e$b;", "T0", "Lcom/tencent/mobileqq/aio/event/RobotMsgIntent$SetShotMsgList;", "W0", "Lcom/tencent/mobileqq/aio/robot/helper/RobotEventIntent$ShowPopupMenu;", "X0", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "displayList", "", "msgId", "", "Q0", "index", "R0", "Lcom/tencent/mvi/base/route/k;", "I", "Y0", "Z0", "", "halfMode", "withAnim", "c1", "enableImmersive", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "b0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lat/b;", "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$b;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", "Lcom/tencent/mobileqq/aio/robot/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "P0", "()Lcom/tencent/mobileqq/aio/robot/d;", "mAIOMsgRepo", "Lw71/a;", BdhLogUtil.LogTag.Tag_Req, "Lw71/a;", "mBottomMaskBinding", ExifInterface.LATITUDE_SOUTH, "Z", "mSupportHalfMode", "T", "mIsHalfMode", "U", "mListHeight", "V", "mHalfListHeight", "W", "mScrollFromDragging", "com/tencent/mobileqq/aio/robot/RobotAIOMsgListVM$c", "X", "Lcom/tencent/mobileqq/aio/robot/RobotAIOMsgListVM$c;", "mAction", "com/tencent/mobileqq/aio/robot/RobotAIOMsgListVM$d", "Y", "Lcom/tencent/mobileqq/aio/robot/RobotAIOMsgListVM$d;", "mActionR", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lcom/tencent/mvi/base/route/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mMessageList", "Lcom/tencent/mvi/base/route/b;", "a0", "mMessageListR", "Lcom/tencent/mobileqq/aio/msglist/w;", "mListFetcher", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/w;)V", "a", "b", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotAIOMsgListVM extends AIOMsgListVM {

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAIOMsgRepo;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private w71.a mBottomMaskBinding;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mSupportHalfMode;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mIsHalfMode;

    /* renamed from: U, reason: from kotlin metadata */
    private int mListHeight;

    /* renamed from: V, reason: from kotlin metadata */
    private int mHalfListHeight;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mScrollFromDragging;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final c mAction;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final d mActionR;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Pair<String, com.tencent.mvi.base.route.a>> mMessageList;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Pair<String, com.tencent.mvi.base.route.b>> mMessageListR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\r\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/RobotAIOMsgListVM$b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "getDefaultStrategy", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "defaultStrategy", "<init>", "(Lcom/tencent/mobileqq/aio/robot/RobotAIOMsgListVM;Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private final class b implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d defaultStrategy;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RobotAIOMsgListVM f193511b;

        public b(@NotNull RobotAIOMsgListVM robotAIOMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d defaultStrategy) {
            Intrinsics.checkNotNullParameter(defaultStrategy, "defaultStrategy");
            this.f193511b = robotAIOMsgListVM;
            this.defaultStrategy = defaultStrategy;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            if (((com.tencent.aio.api.runtime.a) this.f193511b.getMContext()).g().l().getBoolean("key_hide_history_msg")) {
                QLog.d("RobotAIOMsgListVM", 1, "enableRefresh false, needHideHistoryMsg");
                return false;
            }
            return this.defaultStrategy.a(displayList, lastMsg, firstMsg);
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            return this.defaultStrategy.b(displayList, lastMsg, firstMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/robot/RobotAIOMsgListVM$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotAIOMsgListVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/robot/RobotAIOMsgListVM$d", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.mvi.base.route.b {
        d() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return RobotAIOMsgListVM.this.I(intent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotAIOMsgListVM(@NotNull w mListFetcher) {
        super(mListFetcher);
        Lazy lazy;
        ArrayList<Pair<String, com.tencent.mvi.base.route.a>> arrayListOf;
        ArrayList<Pair<String, com.tencent.mvi.base.route.b>> arrayListOf2;
        Intrinsics.checkNotNullParameter(mListFetcher, "mListFetcher");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.aio.robot.d>() { // from class: com.tencent.mobileqq.aio.robot.RobotAIOMsgListVM$mAIOMsgRepo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) RobotAIOMsgListVM.this.getMContext();
                CoroutineScope vmScope = RobotAIOMsgListVM.this.vmScope();
                WeakReference weakReference = new WeakReference(RobotAIOMsgListVM.this);
                ts.b a16 = ts.c.a((com.tencent.aio.api.runtime.a) RobotAIOMsgListVM.this.getMContext());
                return new d(aVar, vmScope, weakReference, a16 instanceof o ? (o) a16 : null);
            }
        });
        this.mAIOMsgRepo = lazy;
        c cVar = new c();
        this.mAction = cVar;
        d dVar = new d();
        this.mActionR = dVar;
        j jVar = j.f352301a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MsgNavigationEvent.NavigateBySeqEvent.class)), cVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MsgNavigationEvent.NavigateByIdEvent.class)), cVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MsgNavigationEvent.NavigateByTimeEvent.class)), cVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.SetShotMsgList.class)), cVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotEventIntent.ShowPopupMenu.class)), cVar));
        this.mMessageList = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.GetSupportHalfScreen.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOBackgroundMsgIntent.GetBottomMaskView.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.GetRobotQAMsgList.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.GetLatestRobotMsg.class)), dVar));
        this.mMessageListR = arrayListOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        boolean z16;
        boolean z17;
        if (intent instanceof MsgNavigationEvent.NavigateBySeqEvent) {
            z16 = true;
        } else {
            z16 = intent instanceof MsgNavigationEvent.NavigateByIdEvent;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = intent instanceof MsgNavigationEvent.NavigateByTimeEvent;
        }
        if (z17) {
            if (this.mIsHalfMode) {
                c1(false, true);
            }
        } else if (intent instanceof RobotMsgIntent.SetShotMsgList) {
            W0((RobotMsgIntent.SetShotMsgList) intent);
        } else if (intent instanceof RobotEventIntent.ShowPopupMenu) {
            X0((RobotEventIntent.ShowPopupMenu) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent intent) {
        View view;
        if (intent instanceof AIOMsgListEvent.GetSupportHalfScreen) {
            return new z.j(this.mSupportHalfMode);
        }
        if (intent instanceof AIOBackgroundMsgIntent.GetBottomMaskView) {
            w71.a aVar = this.mBottomMaskBinding;
            if (aVar != null) {
                view = aVar.f444710b;
            } else {
                view = null;
            }
            return new a.d(view);
        }
        if (intent instanceof RobotMsgIntent.GetRobotQAMsgList) {
            return U0((RobotMsgIntent.GetRobotQAMsgList) intent);
        }
        if (intent instanceof RobotMsgIntent.GetLatestRobotMsg) {
            return T0((RobotMsgIntent.GetLatestRobotMsg) intent);
        }
        return z.k.f192765a;
    }

    private final com.tencent.mobileqq.aio.robot.d P0() {
        return (com.tencent.mobileqq.aio.robot.d) this.mAIOMsgRepo.getValue();
    }

    private final int Q0(List<? extends AIOMsgItem> displayList, long msgId) {
        boolean z16;
        if (!(!displayList.isEmpty())) {
            return -1;
        }
        Iterator<? extends AIOMsgItem> it = displayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (msgId == it.next().getMsgId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<AIOMsgItem> R0(int index, List<? extends AIOMsgItem> displayList) {
        List<AIOMsgItem> emptyList;
        List<AIOMsgItem> listOf;
        List<AIOMsgItem> listOf2;
        List<AIOMsgItem> listOf3;
        List<AIOMsgItem> listOf4;
        List<AIOMsgItem> listOf5;
        List<AIOMsgItem> listOf6;
        if (index < 0 || index >= displayList.size()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        AIOMsgItem aIOMsgItem = displayList.get(index);
        if (aIOMsgItem.isSelf()) {
            if (index == displayList.size() - 1) {
                listOf6 = CollectionsKt__CollectionsJVMKt.listOf(aIOMsgItem);
                return listOf6;
            }
            AIOMsgItem aIOMsgItem2 = displayList.get(index + 1);
            String valueOf = String.valueOf(aIOMsgItem2.getMsgRecord().senderUin);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (!Intrinsics.areEqual(valueOf, su3.c.b(g16))) {
                listOf4 = CollectionsKt__CollectionsJVMKt.listOf(aIOMsgItem);
                return listOf4;
            }
            listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new AIOMsgItem[]{aIOMsgItem, aIOMsgItem2});
            return listOf5;
        }
        if (index == 0) {
            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(aIOMsgItem);
            return listOf3;
        }
        AIOMsgItem aIOMsgItem3 = displayList.get(index - 1);
        if (!aIOMsgItem3.isSelf()) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(aIOMsgItem);
            return listOf;
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new AIOMsgItem[]{aIOMsgItem3, aIOMsgItem});
        return listOf2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S0() {
        Bundle l3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().l();
        long j3 = l3.getLong("key_navigate_msgid", -1L);
        long j16 = l3.getLong("key_navigate_msgseq", -1L);
        long j17 = l3.getLong("key_navigate_time", -1L);
        if (j3 < 0 && j16 < 0 && j17 < 0) {
            c1(true, false);
        }
    }

    private final e.b T0(RobotMsgIntent.GetLatestRobotMsg intent) {
        Object lastOrNull;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        Intrinsics.checkNotNull(l3, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.AIOMsgItem>");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) l3);
        return new e.b((AIOMsgItem) lastOrNull);
    }

    private final e.d U0(RobotMsgIntent.GetRobotQAMsgList intent) {
        List<com.tencent.aio.data.msglist.a> l3 = l();
        Intrinsics.checkNotNull(l3, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.AIOMsgItem>");
        return new e.d(R0(Q0(l3, intent.a()), l3));
    }

    private final void V0(AIOMsgListMviIntent.j intent) {
        if (!this.mIsHalfMode && intent.c() == 1 && intent.a() < 0 && intent.b() < 0.0f) {
            c1(true, true);
        } else if (this.mIsHalfMode && intent.c() == 1 && intent.a() > 0 && intent.b() > 0.0f) {
            c1(false, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W0(RobotMsgIntent.SetShotMsgList intent) {
        com.tencent.mvi.base.route.j e16;
        List<AIOMsgItem> a16 = intent.a();
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new CreateHelperIntent.CreateHelperRealIntent(3, new LongShotMsgIntent.CompleteShotAndShare(a16, intent.b()), null, 4, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X0(RobotEventIntent.ShowPopupMenu intent) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(1, new AIOMsgListEvent.NormalMenuShowEvent(intent.getAnchor(), intent.getMenu()), null, 4, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y0() {
        String str;
        Map<String, ? extends Object> mapOf;
        com.tencent.mobileqq.aio.panel.c cVar = com.tencent.mobileqq.aio.panel.c.f193019a;
        if (!cVar.a((com.tencent.aio.api.runtime.a) getMContext()) && !cVar.b((com.tencent.aio.api.runtime.a) getMContext())) {
            c1(!this.mIsHalfMode, true);
            if (this.mSupportHalfMode) {
                AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
                if (this.mIsHalfMode) {
                    str = "2";
                } else {
                    str = "1";
                }
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                mapOf = MapsKt__MapsKt.mapOf(new Pair("agent_name", c16.g()), new Pair("agent_id", c16.j()), new Pair("agent_uin", su3.c.b(g16)), new Pair("after_click_state", str));
                com.tencent.mobileqq.aio.utils.b.f194119a.o("ev_bas_agent_switches_screen", mapOf);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Z0() {
        Intent intent;
        int i3;
        AioConfig aioConfig;
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        boolean z16 = false;
        if (intent.hasExtra("key_support_half_screen")) {
            z16 = intent.getBooleanExtra("key_support_half_screen", false);
        } else {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            RobotCoreInfo robotCoreInfoFromFriendsCache = ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).getRobotCoreInfoFromFriendsCache(su3.c.b(g16));
            if (robotCoreInfoFromFriendsCache != null && (aioConfig = robotCoreInfoFromFriendsCache.aioConfig) != null) {
                i3 = aioConfig.supportHalfScreenSwitch;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                z16 = true;
            }
        }
        this.mSupportHalfMode = z16;
        QLog.d("RobotAIOMsgListVM", 1, "supportHalfMode=" + z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a1(boolean enableImmersive) {
        Context context;
        if (enableImmersive) {
            if (this.mBottomMaskBinding != null || (context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext()) == null) {
                return;
            }
            LayoutInflater from = LayoutInflater.from(context);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
            gradientDrawable.setShape(0);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setColors(new int[]{context.getColor(R.color.qui_common_bg_nav_bottom_aio), 0});
            w71.a g16 = w71.a.g(from, null, false);
            g16.f444710b.setBackground(gradientDrawable);
            FrameLayout root = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "root");
            updateUI(new AIOMsgListViewState.AddAIOBackgroundView(root));
            this.mBottomMaskBinding = g16;
            return;
        }
        updateUI(AIOMsgListViewState.RemoveAIOBackgroundView.f192731d);
        this.mBottomMaskBinding = null;
    }

    private final void b1(AIOMsgListMviIntent.k intent) {
        int a16 = intent.a();
        this.mListHeight = a16;
        int max = Math.max((int) (a16 * 0.5d), ViewUtils.f352270a.b(200));
        if (max > this.mHalfListHeight) {
            this.mHalfListHeight = max;
        }
    }

    private final void c1(boolean halfMode, boolean withAnim) {
        boolean z16;
        boolean z17 = this.mSupportHalfMode;
        if (!z17 && !this.mIsHalfMode) {
            return;
        }
        if (z17 && halfMode) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsHalfMode = z16;
        if (z16) {
            updateUI(new AIOMsgListViewState.SetTopTransparent(Math.max(this.mListHeight - this.mHalfListHeight, 0), withAnim));
        } else {
            updateUI(new AIOMsgListViewState.SetTopTransparent(0, withAnim));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d F() {
        return new b(this, super.F());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM
    @NotNull
    public AIOMsgRepo b0(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return P0();
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull at.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            S0();
            super.handleIntent(intent);
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.c) {
            Y0();
            super.handleIntent(AIOMsgListMviIntent.c.f190348d);
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.j) {
            super.handleIntent(intent);
            V0((AIOMsgListMviIntent.j) intent);
        } else {
            if (intent instanceof AIOMsgListMviIntent.k) {
                b1((AIOMsgListMviIntent.k) intent);
                if (this.mIsHalfMode) {
                    c1(true, false);
                    return;
                }
                return;
            }
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM, com.tencent.mobileqq.aio.msglist.BaseMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.mMessageListR.iterator();
        while (it5.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) ((Pair) it5.next()).getFirst());
        }
        this.mIsHalfMode = false;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void p(@NotNull MsgListIntent.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.p(intent);
        if (!this.mIsHalfMode && intent.g() && this.mScrollFromDragging) {
            c1(true, true);
        } else if (this.mIsHalfMode && intent.f() == MsgListIntent.ScrollType.UP.ordinal()) {
            c1(false, true);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void s(@NotNull MsgListIntent.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.s(intent);
        if (intent.a() == 1) {
            this.mScrollFromDragging = true;
        } else if (intent.a() == 0) {
            this.mScrollFromDragging = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.mMessageListR.iterator();
        while (it5.hasNext()) {
            Pair pair2 = (Pair) it5.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().j((String) pair2.getFirst(), (com.tencent.mvi.base.route.b) pair2.getSecond());
        }
        boolean c16 = AIOUtil.f194084a.c((com.tencent.aio.api.runtime.a) getMContext());
        Z0();
        a1(c16);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.ImmersiveAreaEvent(c16));
    }
}
