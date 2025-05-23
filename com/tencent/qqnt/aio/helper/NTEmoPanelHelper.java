package com.tencent.qqnt.aio.helper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.InputSimpleEventIntent;
import com.tencent.mobileqq.aio.event.ShortcutEventIntent;
import com.tencent.mobileqq.aio.event.c;
import com.tencent.mobileqq.aio.event.reserve.Reserve1Event;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emosm.emocompat.IHostEmoticonMainApi;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IApolloDependApi;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmotionPanelBusinessParam;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.event.b;
import com.tencent.mobileqq.guide.api.IEmoticonGuideBubbleManagerApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.NTEmoPanelHelper;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f*\u0001H\b\u0007\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J<\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020,H\u0016J\u0012\u0010/\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R0\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002070\u001ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000207` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010IR/\u0010P\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020E0L0K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010M\u001a\u0004\bN\u0010OR/\u0010S\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020H0L0K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010M\u001a\u0004\bR\u0010O\u00a8\u0006X"}, d2 = {"Lcom/tencent/qqnt/aio/helper/NTEmoPanelHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Landroid/os/Handler$Callback;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mvi/base/route/g;", "", "emoticonPanelType", "", "p", HippyTKDListViewAdapter.X, "y", "Loa1/b;", "bean", "", "B", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "r", "D", "E", "isSimple", "Landroid/view/ViewGroup;", "w", "Landroid/view/View;", "v", BdhLogUtil.LogTag.Tag_Conn, "", "drawableUrl", "nowThemeIsSimple", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "Landroid/os/Message;", "msg", "handleMessage", NodeProps.ON_CLICK, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "I", "mCachedPanelType", "Lcom/tencent/mobileqq/data/BaseEmotionPanelBusinessParam;", "f", "Ljava/util/HashMap;", "mBusinessParamMap", tl.h.F, "Landroid/view/View;", "mGuideBubbleView", "Lmqq/os/MqqHandler;", "i", "Lmqq/os/MqqHandler;", "mHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Loa1/b;", "mCacheEmoticonGuideConfBean", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction", "com/tencent/qqnt/aio/helper/NTEmoPanelHelper$c", "Lcom/tencent/qqnt/aio/helper/NTEmoPanelHelper$c;", "mActionR", "", "Lkotlin/Pair;", "Lkotlin/Lazy;", "getMsgList", "()Ljava/util/List;", TabPreloadItem.TAB_NAME_MESSAGE, UserInfo.SEX_FEMALE, "getMsgRList", "msgRList", "<init>", "()V", "G", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class NTEmoPanelHelper implements com.tencent.aio.main.businesshelper.h, Handler.Callback, View.OnClickListener, com.tencent.mvi.base.route.g {

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy msgList;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy msgRList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mGuideBubbleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MqqHandler mHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private oa1.b mCacheEmoticonGuideConfBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCachedPanelType = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, BaseEmotionPanelBusinessParam> mBusinessParamMap = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction = new b();

    /* renamed from: D, reason: from kotlin metadata */
    private final c mActionR = new c();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/NTEmoPanelHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof EmotionPanelMsgIntent.SetEmotionPanelDefaultType) {
                EmotionPanelMsgIntent.SetEmotionPanelDefaultType setEmotionPanelDefaultType = (EmotionPanelMsgIntent.SetEmotionPanelDefaultType) i3;
                NTEmoPanelHelper.this.mCachedPanelType = setEmotionPanelDefaultType.a();
                NTEmoPanelHelper.this.p(setEmotionPanelDefaultType.a());
                return;
            }
            if (i3 instanceof EmotionPanelMsgIntent.ShowGuideBubble) {
                NTEmoPanelHelper.this.y();
                return;
            }
            if (i3 instanceof EmotionPanelMsgIntent.RemoveGuideBubble) {
                NTEmoPanelHelper.this.x();
                return;
            }
            if (i3 instanceof EmotionPanelMsgIntent.SetEmotionPanelBusinessParam) {
                EmotionPanelMsgIntent.SetEmotionPanelBusinessParam setEmotionPanelBusinessParam = (EmotionPanelMsgIntent.SetEmotionPanelBusinessParam) i3;
                NTEmoPanelHelper.this.mBusinessParamMap.put(Integer.valueOf(setEmotionPanelBusinessParam.b()), setEmotionPanelBusinessParam.a());
            } else if (i3 instanceof EmotionPanelMsgIntent.RefreshEmotionPanel) {
                NTEmoPanelHelper.this.p(20);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/NTEmoPanelHelper$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        public com.tencent.mvi.base.route.k call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof EmotionPanelMsgIntent.GetAndResetEmotionPanelDefaultType) {
                int i16 = NTEmoPanelHelper.this.mCachedPanelType;
                NTEmoPanelHelper.this.mCachedPanelType = -1;
                return new b.c(i16);
            }
            if (i3 instanceof EmotionPanelMsgIntent.GetAndResetEmotionPanelBusinessParam) {
                HashMap hashMap = new HashMap(NTEmoPanelHelper.this.mBusinessParamMap);
                NTEmoPanelHelper.this.mBusinessParamMap.clear();
                return new b.C7509b(hashMap);
            }
            return b.a.f205393a;
        }
    }

    public NTEmoPanelHelper() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends Pair<? extends String, ? extends com.tencent.mvi.base.route.a>>>() { // from class: com.tencent.qqnt.aio.helper.NTEmoPanelHelper$msgList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Pair<? extends String, ? extends com.tencent.mvi.base.route.a>> invoke() {
                com.tencent.mvi.base.route.a aVar;
                com.tencent.mvi.base.route.a aVar2;
                com.tencent.mvi.base.route.a aVar3;
                com.tencent.mvi.base.route.a aVar4;
                com.tencent.mvi.base.route.a aVar5;
                List<? extends Pair<? extends String, ? extends com.tencent.mvi.base.route.a>> listOf;
                String qualifiedName = Reflection.getOrCreateKotlinClass(EmotionPanelMsgIntent.SetEmotionPanelDefaultType.class).getQualifiedName();
                aVar = NTEmoPanelHelper.this.mAction;
                String qualifiedName2 = Reflection.getOrCreateKotlinClass(EmotionPanelMsgIntent.SetEmotionPanelBusinessParam.class).getQualifiedName();
                aVar2 = NTEmoPanelHelper.this.mAction;
                String qualifiedName3 = Reflection.getOrCreateKotlinClass(EmotionPanelMsgIntent.RefreshEmotionPanel.class).getQualifiedName();
                aVar3 = NTEmoPanelHelper.this.mAction;
                String qualifiedName4 = Reflection.getOrCreateKotlinClass(EmotionPanelMsgIntent.ShowGuideBubble.class).getQualifiedName();
                aVar4 = NTEmoPanelHelper.this.mAction;
                String qualifiedName5 = Reflection.getOrCreateKotlinClass(EmotionPanelMsgIntent.RemoveGuideBubble.class).getQualifiedName();
                aVar5 = NTEmoPanelHelper.this.mAction;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(qualifiedName, aVar), new Pair(qualifiedName2, aVar2), new Pair(qualifiedName3, aVar3), new Pair(qualifiedName4, aVar4), new Pair(qualifiedName5, aVar5)});
                return listOf;
            }
        });
        this.msgList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends Pair<? extends String, ? extends c>>>() { // from class: com.tencent.qqnt.aio.helper.NTEmoPanelHelper$msgRList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Pair<? extends String, ? extends NTEmoPanelHelper.c>> invoke() {
                NTEmoPanelHelper.c cVar;
                NTEmoPanelHelper.c cVar2;
                List<? extends Pair<? extends String, ? extends NTEmoPanelHelper.c>> listOf;
                String qualifiedName = Reflection.getOrCreateKotlinClass(EmotionPanelMsgIntent.GetAndResetEmotionPanelDefaultType.class).getQualifiedName();
                cVar = NTEmoPanelHelper.this.mActionR;
                String qualifiedName2 = Reflection.getOrCreateKotlinClass(EmotionPanelMsgIntent.GetAndResetEmotionPanelBusinessParam.class).getQualifiedName();
                cVar2 = NTEmoPanelHelper.this.mActionR;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(qualifiedName, cVar), new Pair(qualifiedName2, cVar2)});
                return listOf;
            }
        });
        this.msgRList = lazy2;
    }

    private final void A() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            Object businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.emosm.IEmoticonHandler");
            ((com.tencent.mobileqq.emosm.o) businessHandler).y1(0, 0);
        }
    }

    private final boolean B(oa1.b bean) {
        boolean z16 = com.tencent.mobileqq.config.business.ba.INSTANCE.b().getBoolean("key_show_emoticon_guide", true);
        if (QLog.isColorLevel()) {
            QLog.d("NTEmoPanelHelper", 2, "[isAllowShowGuide] isShowGuide=" + z16 + ", emoticonGuideConfBean=" + bean);
        }
        return z16 && bean.b();
    }

    private final boolean C(oa1.b bean) {
        if (((IEmoticonGuideBubbleManagerApi) QRoute.api(IEmoticonGuideBubbleManagerApi.class)).isGradientBubbleAvailable()) {
            return true;
        }
        String str = bean.f422278c;
        if (QQTheme.isNowThemeIsNight()) {
            str = bean.f422279d;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (AbsDownloader.hasFile(str)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTEmoPanelHelper", 2, "file no download.");
        }
        URLDrawable.getDrawable(str).startDownload(false);
        return false;
    }

    private final void D() {
        QRoute.api(IEmosmService.class);
        QRoute.api(IApolloDependApi.class);
    }

    private final void E(oa1.b bean) {
        com.tencent.mvi.base.route.j e16;
        Fragment c16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (this.mAIOContext == null || peekAppRuntime == null || !B(bean) || ((IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class)).getMainPanel() == null) {
            return;
        }
        QLog.d("NTEmoPanelHelper", 2, "realShowGuideBubble start.");
        this.mCacheEmoticonGuideConfBean = bean;
        if (this.mGuideBubbleView == null) {
            QLog.d("NTEmoPanelHelper", 2, "showGuideBubble  mGuideBubbleView is new create.");
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar != null) {
                this.mGuideBubbleView = ((IEmoticonGuideBubbleManagerApi) QRoute.api(IEmoticonGuideBubbleManagerApi.class)).createEmoticonGuideBubble(aVar.c().getContext());
            }
        }
        View view = this.mGuideBubbleView;
        if (view != null) {
            view.setOnClickListener(this);
        }
        String drawableUrl = bean.f422278c;
        if (QQTheme.isNowThemeIsNight()) {
            drawableUrl = bean.f422279d;
        }
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        ViewGroup w3 = w(isNowSimpleUI);
        View v3 = v(isNowSimpleUI);
        IEmoticonGuideBubbleManagerApi iEmoticonGuideBubbleManagerApi = (IEmoticonGuideBubbleManagerApi) QRoute.api(IEmoticonGuideBubbleManagerApi.class);
        View view2 = this.mGuideBubbleView;
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        KeyEvent.Callback requireView = (aVar2 == null || (c16 = aVar2.c()) == null) ? null : c16.requireView();
        Intrinsics.checkNotNullExpressionValue(drawableUrl, "drawableUrl");
        View generateGuideBubble = iEmoticonGuideBubbleManagerApi.generateGuideBubble(view2, (ViewGroup) requireView, w3, v3, q(bean, drawableUrl, isNowSimpleUI));
        if (generateGuideBubble == null) {
            QLog.d("NTEmoPanelHelper", 2, "realShowGuideBubble end, showGuideBubble=null");
            return;
        }
        Reserve1Event.AddFloatView addFloatView = new Reserve1Event.AddFloatView(2, generateGuideBubble);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 != null && (e16 = aVar3.e()) != null) {
            e16.h(addFloatView);
        }
        QLog.d("NTEmoPanelHelper", 2, "realShowGuideBubble end, showGuideBubble=" + generateGuideBubble);
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
        com.tencent.mobileqq.config.business.ba.INSTANCE.b().edit().putBoolean("key_show_emoticon_guide", false).apply();
        MqqHandler mqqHandler = this.mHandler;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
            int i3 = bean.f422285j;
            mqqHandler.sendEmptyMessageDelayed(1, i3 <= 0 ? 3000L : i3 * 1000);
        }
    }

    private final void o() {
        AIOParam g16;
        Bundle l3;
        com.tencent.mvi.base.route.j messenger;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (l3 = g16.l()) == null || !l3.getBoolean(AppConstants.Key.KEY_SHOW_SEARCH_EMOJI)) {
            return;
        }
        String string = l3.getString(AppConstants.Key.KEY_SEARCH_EMOJI_TEXT);
        int i3 = l3.getInt(AppConstants.Key.KEY_SEARCH_EMOJI_DEFAULT_SELECT);
        l3.remove(AppConstants.Key.KEY_SHOW_SEARCH_EMOJI);
        l3.remove(AppConstants.Key.KEY_SEARCH_EMOJI_TEXT);
        l3.remove(AppConstants.Key.KEY_SEARCH_EMOJI_DEFAULT_SELECT);
        QLog.d("NTEmoPanelHelper", 1, "navigateToSearchEmojiPanel searchEmojiText=" + string + ", searchEmojiDefaultSelect=" + i3);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (messenger = aVar2.e()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(messenger, "messenger");
        this.mCachedPanelType = 18;
        SearchEmotionPanelBusinessParam searchEmotionPanelBusinessParam = new SearchEmotionPanelBusinessParam();
        searchEmotionPanelBusinessParam.searchWord = string;
        searchEmotionPanelBusinessParam.defaultSelectTabIndex = i3;
        this.mBusinessParamMap.put(18, searchEmotionPanelBusinessParam);
        messenger.h(new PanelContainerMsgIntent.ShowPanelMsgIntent("NTEmoPanelHelper", 1001, false, 0, 12, null));
    }

    private final HashMap<String, Object> q(oa1.b bean, String drawableUrl, boolean nowThemeIsSimple) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("now_theme_is_simple", Boolean.valueOf(nowThemeIsSimple));
        if (!TextUtils.isEmpty(drawableUrl)) {
            hashMap.put("drawable_url", drawableUrl);
        }
        hashMap.put("width", Integer.valueOf(bean.f422283h));
        hashMap.put("height", Integer.valueOf(bean.f422284i));
        List<Integer> list = bean.f422286k;
        if (list != null) {
            Intrinsics.checkNotNullExpressionValue(list, "bean.emojiList");
            hashMap.put("res_id_list", list);
        }
        if (!TextUtils.isEmpty(bean.f422287l)) {
            String str = bean.f422287l;
            Intrinsics.checkNotNullExpressionValue(str, "bean.tips");
            hashMap.put("text", str);
        }
        return hashMap;
    }

    private final void r() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.cg
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoPanelHelper.s(NTEmoPanelHelper.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(NTEmoPanelHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101220");
        if (QLog.isColorLevel()) {
            QLog.d("NTEmoPanelHelper", 2, "delayload config");
        }
        this$0.D();
    }

    private final void t() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.cf
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoPanelHelper.u(NTEmoPanelHelper.this);
            }
        }, 16, null, false);
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(NTEmoPanelHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    private final ViewGroup w(boolean isSimple) {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        if (isSimple) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            com.tencent.mvi.base.route.k k3 = (aVar == null || (e17 = aVar.e()) == null) ? null : e17.k(new InputSimpleEventIntent.OnGetShortCutLayoutViewIntent());
            if ((k3 instanceof c.a) || !(k3 instanceof c.C7243c)) {
                return null;
            }
            View a16 = ((c.C7243c) k3).a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type android.view.ViewGroup");
            return (ViewGroup) a16;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        com.tencent.mvi.base.route.k k16 = (aVar2 == null || (e16 = aVar2.e()) == null) ? null : e16.k(new ShortcutEventIntent.OnGetShortCutLayoutViewIntent());
        if ((k16 instanceof com.tencent.mobileqq.aio.event.f) || !(k16 instanceof com.tencent.mobileqq.aio.event.k)) {
            return null;
        }
        View a17 = ((com.tencent.mobileqq.aio.event.k) k16).a();
        Intrinsics.checkNotNull(a17, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) a17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        Fragment c16;
        View view = this.mGuideBubbleView;
        boolean z16 = false;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("NTEmoPanelHelper", 2, "removeGuideBubble ");
            }
            this.mCacheEmoticonGuideConfBean = null;
            IEmoticonGuideBubbleManagerApi iEmoticonGuideBubbleManagerApi = (IEmoticonGuideBubbleManagerApi) QRoute.api(IEmoticonGuideBubbleManagerApi.class);
            View view2 = this.mGuideBubbleView;
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            iEmoticonGuideBubbleManagerApi.removeGuideBubble(view2, (ViewGroup) ((aVar == null || (c16 = aVar.c()) == null) ? null : c16.requireView()));
        }
        MqqHandler mqqHandler = this.mHandler;
        Intrinsics.checkNotNull(mqqHandler);
        mqqHandler.removeCallbacksAndMessages(null);
        QLog.d("NTEmoPanelHelper", 2, "removeGuideBubble mGuideBubbleView=null");
        this.mGuideBubbleView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ce
            @Override // java.lang.Runnable
            public final void run() {
                NTEmoPanelHelper.z(NTEmoPanelHelper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(NTEmoPanelHelper this$0) {
        boolean isEmoReady;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.config.business.ba.INSTANCE.b().getBoolean("key_show_emoticon_guide", true)) {
            if (QLog.isColorLevel()) {
                QLog.d("NTEmoPanelHelper", 2, "handleShowGuideBubble return, isShowGuide = true.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTEmoPanelHelper", 2, "showGuideBubble start loadConObj.");
        }
        if (this$0.mAIOContext == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NTEmoPanelHelper", 2, "handleShowGuideBubble return, chat pie is null.");
                return;
            }
            return;
        }
        oa1.b a16 = oa1.b.a();
        Intrinsics.checkNotNullExpressionValue(a16, "getInfo()");
        if (QLog.isColorLevel()) {
            QLog.d("NTEmoPanelHelper", 2, "emoticonGuideConfBean=" + a16);
        }
        if (a16.b()) {
            if (!this$0.C(a16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("NTEmoPanelHelper", 2, "handleShowGuideBubble return, isDrawableAvailable(bean) = false.");
                    return;
                }
                return;
            }
            int i3 = a16.f422280e;
            int i16 = a16.f422281f;
            if (i16 != 1) {
                isEmoReady = i16 != 2 ? false : QQEmojiUtil.isEmoReady(QQEmojiUtil.getEmojiLocalId(i3));
            } else {
                isEmoReady = QQSysFaceUtil.isEmoReady(i3);
            }
            if (!isEmoReady) {
                if (QLog.isColorLevel()) {
                    QLog.d("NTEmoPanelHelper", 2, "handleShowGuideBubble return, emoReady = false. serverId =" + i3);
                    return;
                }
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = a16;
            MqqHandler mqqHandler = this$0.mHandler;
            Intrinsics.checkNotNull(mqqHandler);
            mqqHandler.sendMessage(obtain);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350668r0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.event.EmotionPanelMsgIntent.SetEmotionPanelDefaultType");
        hashSet.add("com.tencent.mobileqq.event.EmotionPanelMsgIntent.SetEmotionPanelBusinessParam");
        hashSet.add("com.tencent.mobileqq.event.EmotionPanelMsgIntent.RefreshEmotionPanel");
        hashSet.add("com.tencent.mobileqq.event.EmotionPanelMsgIntent.ShowGuideBubble");
        hashSet.add("com.tencent.mobileqq.event.EmotionPanelMsgIntent.RemoveGuideBubble");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.event.EmotionPanelMsgIntent.GetAndResetEmotionPanelDefaultType");
        hashSet.add("com.tencent.mobileqq.event.EmotionPanelMsgIntent.GetAndResetEmotionPanelBusinessParam");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "NTEmoPanelHelper";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            x();
        } else if (i3 == 2) {
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.config.business.bean.EmoticonGuideConfBean");
            E((oa1.b) obj);
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 != null && (e17 = a16.e()) != null) {
            e17.f(this, this.mAction);
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.l(this, this.mActionR);
        }
        this.mHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (e17 = aVar.e()) != null) {
            e17.i(this, this.mAction);
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            e16.e(this);
        }
        this.mAIOContext = null;
        this.mCachedPanelType = -1;
        x();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 4, 12};
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        oa1.b bVar;
        int convertToLocal;
        QLog.d("NTEmoPanelHelper", 2, "OnClick:" + v3);
        IEmoticonMainPanel mainPanel = ((IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class)).getMainPanel();
        if (mainPanel != null && (bVar = this.mCacheEmoticonGuideConfBean) != null) {
            Intrinsics.checkNotNull(bVar);
            int i3 = bVar.f422280e;
            oa1.b bVar2 = this.mCacheEmoticonGuideConfBean;
            Intrinsics.checkNotNull(bVar2);
            int i16 = bVar2.f422281f;
            if (i16 == 1) {
                convertToLocal = QQSysFaceUtil.convertToLocal(i3);
                if (!QQSysFaceUtil.isValidFaceId(convertToLocal)) {
                    return;
                }
            } else if (i16 != 2) {
                convertToLocal = -1;
            } else {
                convertToLocal = QQEmojiUtil.getEmojiLocalId(i3);
                if (!QQEmojiUtil.isValidEmojiId(convertToLocal)) {
                    return;
                }
            }
            if (convertToLocal != -1) {
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
                QLog.d("NTEmoPanelHelper", 2, "emoType=" + i16 + " localId=" + convertToLocal);
                mainPanel.switchSystemEmojiTabLocationPos(i16, convertToLocal);
            }
            x();
            return;
        }
        QLog.d("NTEmoPanelHelper", 2, "panel or confBean null");
        x();
    }

    private final View v(boolean isSimple) {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        if (isSimple) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            com.tencent.mvi.base.route.k k3 = (aVar == null || (e17 = aVar.e()) == null) ? null : e17.k(new InputSimpleEventIntent.OnGetEmoIconViewIntent());
            if (!(k3 instanceof c.a) && (k3 instanceof c.b)) {
                return ((c.b) k3).a();
            }
            return null;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        com.tencent.mvi.base.route.k k16 = (aVar2 == null || (e16 = aVar2.e()) == null) ? null : e16.k(new ShortcutEventIntent.OnGetEmoIconViewIntent());
        if (!(k16 instanceof com.tencent.mobileqq.aio.event.f) && (k16 instanceof com.tencent.mobileqq.aio.event.g)) {
            return ((com.tencent.mobileqq.aio.event.g) k16).a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(int emoticonPanelType) {
        if (emoticonPanelType == 20) {
            QLog.i("NTEmoPanelHelper", 1, "considerRefreshPanel  ai emoticon");
            IEmoticonMainPanel mainPanel = ((IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class)).getMainPanel();
            if (mainPanel == null) {
                return;
            }
            mainPanel.refreshEmoticonList(20);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            t();
        } else if (state == 4) {
            r();
        } else {
            if (state != 12) {
                return;
            }
            onDestroy();
        }
    }
}
