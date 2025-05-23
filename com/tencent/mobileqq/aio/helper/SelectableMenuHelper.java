package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.GestureEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.menu.MenuWrapper;
import com.tencent.qqnt.aio.menu.m;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001:\b\u0007\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u00011B\u0019\u0012\u0006\u0010f\u001a\u00020e\u0012\b\u00104\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u0013\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0012\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\fH\u0002J(\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J\b\u0010\"\u001a\u00020\u0003H\u0002J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0012\u0010%\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u0003H\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0002J\u0016\u0010-\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020(0+H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020/H\u0002J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0016J\b\u00103\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H\u0016J\b\u00105\u001a\u00020\fH\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u00020\u0003H\u0016J\b\u00109\u001a\u00020\u0015H\u0016R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R&\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020:0>0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010LR\u0016\u0010N\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010LR\u0016\u0010O\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010*R\u0016\u0010P\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010*R\u0016\u0010Q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u001b\u0010U\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010R\u001a\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0004R\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0004R\u001b\u0010\\\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010R\u001a\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010LR\u0018\u0010_\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010^R\u0016\u0010b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010*R\u0016\u0010d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010*\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/SelectableMenuHelper;", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/b;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "J", "P", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "v", "Landroid/view/MotionEvent;", "event", "D", "", "u", "Lnv3/b;", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "selectedMenu", "o", "M", "", "needAnimation", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "newState", "isApiScroll", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "left", "top", "right", "bottom", "L", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, "B", "N", "K", "Lcom/tencent/aio/data/msglist/a;", "msg", "I", "", TabPreloadItem.TAB_NAME_MESSAGE, "G", "E", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnRevokeEvent;", "H", "a", tl.h.F, "g", "msgIntent", "getId", "", "getTag", "b", "onBackEvent", "com/tencent/mobileqq/aio/helper/SelectableMenuHelper$b", "f", "Lcom/tencent/mobileqq/aio/helper/SelectableMenuHelper$b;", "mAction", "Lkotlin/Pair;", "Ljava/util/List;", "mMessageList", "Landroid/content/Context;", "i", "Landroid/content/Context;", "mContext", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[I", "mInputLocation", BdhLogUtil.LogTag.Tag_Conn, "Lnv3/b;", "mComponent", "Z", "mIsSelect", "mHasNotTouchSelectComponent", "mPreState", "mPreX", "mPreY", "Lkotlin/Lazy;", "t", "()I", "mScrollThreshold", "", "mSelectAttachTime", "mAttachTime", "Lcom/tencent/qqnt/aio/menu/MenuWrapper;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/qqnt/aio/menu/MenuWrapper;", "mMenuWrapper", "mShowMenuMainThread", "Lcom/tencent/qqnt/aio/menu/ui/c;", "mMenu", "mSelectMenu", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mListScrollState", BdhLogUtil.LogTag.Tag_Req, "mBounceScrollState", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "<init>", "(Lcom/tencent/aio/main/businesshelper/b;Lcom/tencent/mvi/base/route/MsgIntent;)V", ExifInterface.LATITUDE_SOUTH, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class SelectableMenuHelper extends com.tencent.mobileqq.aio.helper.LateInitHelper.b implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private nv3.b mComponent;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsSelect;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mHasNotTouchSelectComponent;

    /* renamed from: F, reason: from kotlin metadata */
    private int mPreState;

    /* renamed from: G, reason: from kotlin metadata */
    private int mPreX;

    /* renamed from: H, reason: from kotlin metadata */
    private int mPreY;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mScrollThreshold;

    /* renamed from: J, reason: from kotlin metadata */
    private long mSelectAttachTime;

    /* renamed from: K, reason: from kotlin metadata */
    private long mAttachTime;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMenuWrapper;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mShowMenuMainThread;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.menu.ui.c mMenu;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.menu.ui.c mSelectMenu;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mListScrollState;

    /* renamed from: R, reason: from kotlin metadata */
    private int mBounceScrollState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] mInputLocation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/SelectableMenuHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.SelectableMenuHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/SelectableMenuHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectableMenuHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                SelectableMenuHelper.this.v(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52146);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectableMenuHelper(@NotNull com.tencent.aio.main.businesshelper.b helperParam, @Nullable MsgIntent msgIntent) {
        super(helperParam, msgIntent);
        List<Pair<String, b>> listOf;
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helperParam, (Object) msgIntent);
            return;
        }
        b bVar = new b();
        this.mAction = bVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(GestureEvent.DispatchTouchEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.SelectEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.CancleSelectEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.DismissSelectMenu.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ReappearSelectMenu.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ListScrollStateChanged.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.BounceScrollStateChanged.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.NormalMenuShowEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.SelectAll.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnReceiveMsgs.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.MsgOnRevokeEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnMsgTailChanged.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LifeCycleEvent.OnPause.class)), bVar)});
        this.mMessageList = listOf;
        this.mPreX = -1;
        this.mPreY = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.aio.helper.SelectableMenuHelper$mScrollThreshold$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableMenuHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int u16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                u16 = SelectableMenuHelper.this.u();
                return Integer.valueOf(u16);
            }
        });
        this.mScrollThreshold = lazy;
        this.mSelectAttachTime = -1L;
        this.mAttachTime = -1L;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MenuWrapper>() { // from class: com.tencent.mobileqq.aio.helper.SelectableMenuHelper$mMenuWrapper$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/SelectableMenuHelper$mMenuWrapper$2$a", "Lcom/tencent/qqnt/aio/menu/w;", "", "needAnimation", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes10.dex */
            public static final class a implements com.tencent.qqnt.aio.menu.w {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ SelectableMenuHelper f188935a;

                a(SelectableMenuHelper selectableMenuHelper) {
                    this.f188935a = selectableMenuHelper;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectableMenuHelper);
                    }
                }

                @Override // com.tencent.qqnt.aio.menu.w
                public void a(boolean needAnimation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        this.f188935a.q(needAnimation);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, needAnimation);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectableMenuHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MenuWrapper invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new MenuWrapper(2, new a(SelectableMenuHelper.this), null) : (MenuWrapper) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mMenuWrapper = lazy2;
        this.mShowMenuMainThread = true;
    }

    private final void A() {
        if (this.mComponent == null) {
            return;
        }
        if (this.mBounceScrollState == 0 && this.mListScrollState == 0) {
            return;
        }
        if (this.mHasNotTouchSelectComponent) {
            r(this, false, 1, null);
        } else {
            MenuWrapper.i(s(), false, 1, null);
        }
    }

    private final void B(boolean isApiScroll) {
        nv3.b bVar = this.mComponent;
        if (bVar != null && this.mBounceScrollState == 0 && this.mListScrollState == 0 && !this.mHasNotTouchSelectComponent) {
            Intrinsics.checkNotNull(bVar);
            View f16 = bVar.f();
            if (f16 != null) {
                int dip2px = ViewUtils.dip2px(50.0f);
                int[] iArr = new int[2];
                f16.getLocationInWindow(iArr);
                if ((iArr[1] + f16.getMeasuredHeight()) - f16.getPaddingBottom() < dip2px + ImmersiveUtils.statusHeight) {
                    r(this, false, 1, null);
                    return;
                }
                int[] iArr2 = this.mInputLocation;
                if (iArr2 != null) {
                    int i3 = iArr[1];
                    Intrinsics.checkNotNull(iArr2);
                    if (i3 > iArr2[1]) {
                        r(this, false, 1, null);
                        return;
                    }
                }
                if (!isApiScroll) {
                    N();
                }
            }
        }
    }

    static /* synthetic */ void C(SelectableMenuHelper selectableMenuHelper, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        selectableMenuHelper.B(z16);
    }

    private final void D(MotionEvent event) {
        if (!this.mIsSelect) {
            return;
        }
        int action = event.getAction();
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return;
                    }
                } else {
                    if (this.mHasNotTouchSelectComponent && Math.pow(this.mPreX - rawX, 2.0d) + Math.pow(this.mPreY - rawY, 2.0d) > t()) {
                        this.mPreState = 2;
                        return;
                    }
                    return;
                }
            }
            if (this.mHasNotTouchSelectComponent) {
                QLog.i("SelectableMenuHelper", 1, "mHasNotTouchSelectComponent");
                if (this.mPreState == 0) {
                    long j3 = this.mAttachTime;
                    long j16 = this.mSelectAttachTime;
                    if (j16 != -1 && j3 != -1) {
                        if (j16 == j3) {
                            r(this, false, 1, null);
                        }
                    } else {
                        r(this, false, 1, null);
                    }
                }
                this.mPreState = 1;
                this.mHasNotTouchSelectComponent = false;
                this.mSelectAttachTime = -1L;
                return;
            }
            return;
        }
        boolean z16 = !F(rawX, rawY);
        this.mHasNotTouchSelectComponent = z16;
        this.mSelectAttachTime = this.mAttachTime;
        if (z16) {
            this.mPreX = rawX;
            this.mPreY = rawY;
            if (!com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
                r(this, false, 1, null);
            }
        } else {
            this.mPreX = -1;
            this.mPreY = -1;
        }
        this.mPreState = 0;
        s().s(new PointF(event.getRawX(), event.getRawY()));
    }

    private final boolean E() {
        AIOMsgListEvent.GetCurFocusIndex getCurFocusIndex = new AIOMsgListEvent.GetCurFocusIndex(0L, 1, null);
        c().a().e().h(getCurFocusIndex);
        if (getCurFocusIndex.a() == -1) {
            return true;
        }
        return false;
    }

    private final boolean F(int x16, int y16) {
        View f16;
        nv3.b bVar = this.mComponent;
        if (bVar == null || (f16 = bVar.f()) == null) {
            return false;
        }
        int[] iArr = new int[2];
        f16.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = f16.getMeasuredWidth() + i3;
        int measuredHeight = f16.getMeasuredHeight() + i16;
        if (x16 < i3 || x16 > measuredWidth || y16 < i16 || y16 > measuredHeight) {
            return false;
        }
        return true;
    }

    private final void G(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String str;
        String str2;
        AIOSession r16;
        AIOContact c16;
        if (!s().l() || msgList == null || msgList.size() <= 0 || !E()) {
            return;
        }
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            AIOParam g16 = c().a().g();
            if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                str = c16.j();
            } else {
                str = null;
            }
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            MsgRecord msgRecord = ((AIOMsgItem) aVar).getMsgRecord();
            if (msgRecord != null) {
                str2 = msgRecord.peerUid;
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                r(this, false, 1, null);
                return;
            }
        }
    }

    private final void H(AIOMsgSendEvent.MsgOnRevokeEvent intent) {
        com.tencent.qqnt.aio.menu.ui.c cVar;
        if (!s().l() || (cVar = this.mMenu) == null || cVar.d() == 0) {
            return;
        }
        long msgId = cVar.b(0).d().getMsgId();
        if (msgId == intent.a()) {
            QLog.i("SelectableMenuHelper", 1, "[onMsgRevoke]: dismiss menu, msgId is " + msgId);
            r(this, false, 1, null);
        }
    }

    private final void I(com.tencent.aio.data.msglist.a msg2) {
        String str;
        String str2;
        AIOSession r16;
        AIOContact c16;
        if (!s().l()) {
            return;
        }
        AIOParam g16 = c().a().g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        MsgRecord msgRecord = ((AIOMsgItem) msg2).getMsgRecord();
        if (msgRecord != null) {
            str2 = msgRecord.peerUid;
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            r(this, false, 1, null);
        }
    }

    private final void J() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c().a().e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        c().a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }

    private final void K() {
        nv3.b bVar = this.mComponent;
        if (bVar != null) {
            bVar.g();
            N();
        }
    }

    private final void L(int left, int top, int right, int bottom) {
        this.mInputLocation = r4;
        Intrinsics.checkNotNull(r4);
        int[] iArr = {left};
        int[] iArr2 = this.mInputLocation;
        Intrinsics.checkNotNull(iArr2);
        iArr2[1] = bottom;
        if (QLog.isColorLevel()) {
            QLog.i("SelectableMenuHelper", 1, "[setMenuContainerBottom]: containerBottom top is " + top + ", bottom is " + bottom);
        }
        s().q(bottom);
    }

    private final void M() {
        m.e eVar;
        com.tencent.mvi.base.route.k k3 = c().a().e().k(AIOTitleContainerMsgIntent.GetTitleLocation.f193798d);
        if (k3 instanceof m.e) {
            eVar = (m.e) k3;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            s().r(eVar.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.tencent.qqnt.aio.menu.m] */
    private final void N() {
        boolean z16;
        boolean z17;
        com.tencent.qqnt.aio.menu.ui.c cVar;
        if (this.mMenu != null && this.mSelectMenu != null && this.mComponent != null) {
            a.C9495a c9495a = null;
            com.tencent.mvi.base.route.k k3 = c().a().e().k(new StreamMsgEvent.GetAnimStatus(null));
            if (k3 instanceof a.C9495a) {
                c9495a = (a.C9495a) k3;
            }
            if (c9495a != null && c9495a.a()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            nv3.b bVar = this.mComponent;
            Intrinsics.checkNotNull(bVar);
            int contentLength = bVar.contentLength();
            nv3.b bVar2 = this.mComponent;
            Intrinsics.checkNotNull(bVar2);
            if (contentLength > bVar2.l()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                cVar = this.mSelectMenu;
            } else {
                cVar = this.mMenu;
            }
            Intrinsics.checkNotNull(cVar);
            com.tencent.qqnt.aio.menu.ui.c cVar2 = cVar;
            MenuWrapper s16 = s();
            MenuWrapper menuWrapper = s16;
            if (!z17) {
                menuWrapper = com.tencent.qqnt.aio.menu.ui.b.a(s16, c().a(), cVar2, new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.helper.be
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SelectableMenuHelper.O(SelectableMenuHelper.this, view);
                    }
                });
            }
            MenuWrapper menuWrapper2 = menuWrapper;
            nv3.b bVar3 = this.mComponent;
            Intrinsics.checkNotNull(bVar3);
            com.tencent.qqnt.aio.menu.al d16 = bVar3.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mComponent!!.selectLocation");
            nv3.b bVar4 = this.mComponent;
            Intrinsics.checkNotNull(bVar4);
            View f16 = bVar4.f();
            Intrinsics.checkNotNullExpressionValue(f16, "mComponent!!.view()");
            m.a.b(menuWrapper2, d16, f16, cVar2, null, z17, 8, null);
            this.mShowMenuMainThread = Looper.getMainLooper().isCurrentThread();
            c().a().e().h(AIOMsgListEvent.SelectMenuShowEvent.f188379d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(SelectableMenuHelper this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r(this$0, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c().a().e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        c().a().b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    private final void o(nv3.b component, com.tencent.qqnt.aio.menu.ui.c menu, com.tencent.qqnt.aio.menu.ui.c selectedMenu) {
        nv3.b bVar;
        Unit unit = null;
        if (!Intrinsics.areEqual(component, this.mComponent) && (bVar = this.mComponent) != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.i();
            MenuWrapper.i(s(), false, 1, null);
        }
        InputEvent.GetInputLayoutRect getInputLayoutRect = new InputEvent.GetInputLayoutRect(null, 1, null);
        c().a().e().h(getInputLayoutRect);
        Rect a16 = getInputLayoutRect.a();
        if (a16 != null) {
            L(a16.left, a16.top, a16.right, a16.bottom);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            s().q(com.tencent.mobileqq.aio.utils.e.f194142a.b());
        }
        M();
        this.mComponent = component;
        this.mMenu = menu;
        this.mSelectMenu = selectedMenu;
        com.tencent.qqnt.aio.menu.m a17 = com.tencent.qqnt.aio.menu.ui.b.a(s(), c().a(), menu, new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.helper.bd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectableMenuHelper.p(SelectableMenuHelper.this, view);
            }
        });
        nv3.b bVar2 = this.mComponent;
        Intrinsics.checkNotNull(bVar2);
        com.tencent.qqnt.aio.menu.al d16 = bVar2.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mComponent!!.selectLocation");
        nv3.b bVar3 = this.mComponent;
        Intrinsics.checkNotNull(bVar3);
        View f16 = bVar3.f();
        Intrinsics.checkNotNullExpressionValue(f16, "mComponent!!.view()");
        m.a.b(a17, d16, f16, menu, null, false, 24, null);
        this.mIsSelect = true;
        this.mAttachTime = System.currentTimeMillis();
        this.mShowMenuMainThread = Looper.getMainLooper().isCurrentThread();
        c().a().e().h(AIOMsgListEvent.SelectMenuShowEvent.f188379d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(SelectableMenuHelper this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r(this$0, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(boolean needAnimation) {
        c().a().e().h(new AIOMsgListEvent.SetBottomPaddingIncrement(0));
        s().h(needAnimation);
        nv3.b bVar = this.mComponent;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.i();
            this.mComponent = null;
            this.mIsSelect = false;
            this.mAttachTime = -1L;
        }
    }

    static /* synthetic */ void r(SelectableMenuHelper selectableMenuHelper, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        selectableMenuHelper.q(z16);
    }

    private final MenuWrapper s() {
        return (MenuWrapper) this.mMenuWrapper.getValue();
    }

    private final int t() {
        return ((Number) this.mScrollThreshold.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int u() {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        return viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(MsgIntent intent) {
        if (intent instanceof GestureEvent.DispatchTouchEvent) {
            D(((GestureEvent.DispatchTouchEvent) intent).a());
            return;
        }
        if (intent instanceof LifeCycleEvent.OnPause) {
            r(this, false, 1, null);
            return;
        }
        if (intent instanceof AIOMsgListEvent.SelectEvent) {
            AIOMsgListEvent.SelectEvent selectEvent = (AIOMsgListEvent.SelectEvent) intent;
            o(selectEvent.a(), selectEvent.b(), selectEvent.c());
            return;
        }
        if (intent instanceof AIOMsgListEvent.CancleSelectEvent) {
            r(this, false, 1, null);
            return;
        }
        if (intent instanceof AIOMsgListEvent.ListScrollStateChanged) {
            AIOMsgListEvent.ListScrollStateChanged listScrollStateChanged = (AIOMsgListEvent.ListScrollStateChanged) intent;
            z(listScrollStateChanged.a(), listScrollStateChanged.b());
            return;
        }
        if (intent instanceof AIOMsgListEvent.BounceScrollStateChanged) {
            w(((AIOMsgListEvent.BounceScrollStateChanged) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.NormalMenuShowEvent) {
            y();
            return;
        }
        if (intent instanceof AIOMsgListEvent.DismissSelectMenu) {
            s().h(((AIOMsgListEvent.DismissSelectMenu) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.ReappearSelectMenu) {
            N();
            return;
        }
        if (intent instanceof AIOMsgListEvent.SelectAll) {
            K();
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnReceiveMsgs) {
            G(((AIOMsgListEvent.OnReceiveMsgs) intent).a());
            return;
        }
        if (intent instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            H((AIOMsgSendEvent.MsgOnRevokeEvent) intent);
        } else if (intent instanceof AIOMsgListEvent.OnMsgTailChanged) {
            I(((AIOMsgListEvent.OnMsgTailChanged) intent).a());
        } else if (intent instanceof AIOMsgListEvent.MenuDismissEvent) {
            r(this, false, 1, null);
        }
    }

    private final void w(int newState) {
        this.mBounceScrollState = newState;
        if (newState != 0) {
            if (newState == 1) {
                A();
                return;
            }
            return;
        }
        C(this, false, 1, null);
    }

    private final void y() {
        if (!this.mIsSelect) {
            return;
        }
        r(this, false, 1, null);
    }

    private final void z(int newState, boolean isApiScroll) {
        this.mListScrollState = newState;
        if (newState != 0) {
            if (newState == 1) {
                A();
                return;
            }
            return;
        }
        B(isApiScroll);
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("SelectableMenuHelper", 1, OperateCustomButton.OPERATE_CREATE);
        Context requireContext = c().a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "helperParam.aioContext.fragment.requireContext()");
        this.mContext = requireContext;
        if (e() != null) {
            x(e());
        }
        J();
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("SelectableMenuHelper", 1, "destroy");
        P();
        this.mIsSelect = false;
        this.mHasNotTouchSelectComponent = false;
        this.mPreState = 0;
        this.mPreX = -1;
        this.mPreY = -1;
        this.mSelectAttachTime = -1L;
        this.mAttachTime = -1L;
        this.mMenu = null;
        this.mSelectMenu = null;
        this.mListScrollState = 0;
        this.mBounceScrollState = 0;
        if (s().l()) {
            r(this, false, 1, null);
        }
        this.mComponent = null;
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "SelectableMenuHelper";
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        try {
            if (!s().l()) {
                return false;
            }
            r(this, false, 1, null);
            return true;
        } catch (Exception e16) {
            QLog.i("SelectableMenuHelper", 1, "onBackEvent:" + e16);
            throw new IllegalStateException("SelectableMenuHelper, call OnBackEvent from illegal thread, isMainThread " + Looper.getMainLooper().isCurrentThread() + ", showMenuMainThread " + this.mShowMenuMainThread);
        }
    }

    public void x(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            v(msgIntent);
        }
    }
}
