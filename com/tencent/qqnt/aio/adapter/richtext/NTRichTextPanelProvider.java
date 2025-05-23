package com.tencent.qqnt.aio.adapter.richtext;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.EmosmEmoticonConstant;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emosm.s;
import com.tencent.mobileqq.emoticonview.EmoticonCallbackWithShowPanel;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IHotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonDelApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.panel.RichTextPanel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.aio.api.e;
import com.tencent.qqnt.emotion.api.IEmoticonMarketFace;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicEmojiType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextMallEmojiInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000\u00a7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001P\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001aB\u000f\u0012\u0006\u0010>\u001a\u00020<\u00a2\u0006\u0004\bY\u0010ZJ\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0007J\b\u0010#\u001a\u00020\tH\u0007J\b\u0010$\u001a\u00020\tH\u0007J\b\u0010%\u001a\u00020\tH\u0016J\u0012\u0010'\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\u0012\u0010(\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010,\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u00102\b\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010 \u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010-\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010.\u001a\u00020\tH\u0016J\b\u0010/\u001a\u00020\tH\u0016J\u0010\u00102\u001a\u00020\t2\u0006\u00101\u001a\u000200H\u0016J2\u00109\u001a\u00020\t2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u000200H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010=R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010AR\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010CR#\u0010J\u001a\n F*\u0004\u0018\u00010E0E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010G\u001a\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR(\u0010X\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0004\u0012\u00020P0U0T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/richtext/NTRichTextPanelProvider;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/emosm/s;", "Lcom/tencent/qqnt/aio/api/e;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallbackWithShowPanel;", "Lcom/tencent/mobileqq/panel/RichTextPanel;", "f", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "i", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "j", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "searchItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoInfo", "", "k", h.F, "l", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/widget/EditText;", "editText", "a", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Lcom/tencent/qqnt/aio/api/e$a;", "callback", "b", "d", "c", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "delete", "info", "send", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "", "panelType", "showEmoticonPanel", NodeProps.VISIBLE, "bottom", "clearWord", "", "word", "width", "setEmotionSearchPanelVisible", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "getEmoPanel", "Landroid/content/Context;", "Landroid/content/Context;", "context", "e", "Lcom/tencent/aio/api/runtime/a;", "Landroid/widget/EditText;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "panelContainer", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "g", "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/panel/RichTextPanel;", "richTextPanel", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/api/e$a;", "emoCallbackDelegate", "com/tencent/qqnt/aio/adapter/richtext/NTRichTextPanelProvider$b", "D", "Lcom/tencent/qqnt/aio/adapter/richtext/NTRichTextPanelProvider$b;", "mAction", "", "Lkotlin/Pair;", "E", "Ljava/util/List;", "messageList", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTRichTextPanelProvider implements LifecycleObserver, s, e, EmoticonCallbackWithShowPanel {

    /* renamed from: C, reason: from kotlin metadata */
    private e.a emoCallbackDelegate;

    /* renamed from: D, reason: from kotlin metadata */
    private final b mAction;

    /* renamed from: E, reason: from kotlin metadata */
    private final List<Pair<String, b>> messageList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private EditText editText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup panelContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy appRuntime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RichTextPanel richTextPanel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/richtext/NTRichTextPanelProvider$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            NTRichTextPanelProvider.this.i(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public NTRichTextPanelProvider(Context context) {
        Lazy lazy;
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.qqnt.aio.adapter.richtext.NTRichTextPanelProvider$appRuntime$2
            @Override // kotlin.jvm.functions.Function0
            public final AppRuntime invoke() {
                return MobileQQ.sMobileQQ.peekAppRuntime();
            }
        });
        this.appRuntime = lazy;
        b bVar = new b();
        this.mAction = bVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class).getQualifiedName(), bVar));
        this.messageList = listOf;
    }

    private final RichTextPanel f() {
        if (this.richTextPanel == null) {
            QLog.i("NTRichTextPanelProvider", 4, "createPanel");
            RichTextPanel richTextPanel = new RichTextPanel(this.context);
            this.richTextPanel = richTextPanel;
            Context context = this.context;
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            EditText editText = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            EditText editText2 = this.editText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
            } else {
                editText = editText2;
            }
            richTextPanel.f(context, aVar, editText, this);
        }
        return this.richTextPanel;
    }

    private final AppRuntime g() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    private final EmotionSearchItem h(EmoticonInfo emoInfo) {
        EmotionSearchItem searchItem = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getSearchItem(emoInfo);
        Intrinsics.checkNotNullExpressionValue(searchItem, "api(IEmoticonBusinessPro\u2026a).getSearchItem(emoInfo)");
        return searchItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(MsgIntent msgIntent) {
        if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            j((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent);
        }
    }

    private final void j(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent msgIntent) {
        int a16 = msgIntent.a();
        boolean b16 = msgIntent.b();
        if (a16 == 1007) {
            if (b16) {
                RichTextPanel richTextPanel = this.richTextPanel;
                if (richTextPanel != null) {
                    richTextPanel.l();
                }
                RichTextPanel richTextPanel2 = this.richTextPanel;
                if (richTextPanel2 != null) {
                    richTextPanel2.k(true);
                    return;
                }
                return;
            }
            RichTextPanel richTextPanel3 = this.richTextPanel;
            if (richTextPanel3 != null) {
                richTextPanel3.j(false);
            }
            RichTextPanel richTextPanel4 = this.richTextPanel;
            if (richTextPanel4 != null) {
                richTextPanel4.k(false);
            }
        }
    }

    private final boolean k(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isHotPicType(emoInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l(EmoticonInfo emoInfo) {
        if (emoInfo instanceof IHotPicSearchEmoticonInfo) {
            ((IHotPicSearchEmoticonInfo) emoInfo).report(g());
        }
    }

    private final void m(EmotionSearchItem searchItem) {
        String str = null;
        com.tencent.aio.api.runtime.a aVar = null;
        if (searchItem.emojiType == EmojiHotPicEmojiType.KMALL.ordinal()) {
            if (searchItem.mallEmojiInfo != null) {
                IEmoticonMarketFace iEmoticonMarketFace = (IEmoticonMarketFace) QRoute.api(IEmoticonMarketFace.class);
                com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                } else {
                    aVar = aVar2;
                }
                EmojiHotPicSearchTextMallEmojiInfo emojiHotPicSearchTextMallEmojiInfo = searchItem.mallEmojiInfo;
                int i3 = emojiHotPicSearchTextMallEmojiInfo.mallEmojiPackId;
                String str2 = emojiHotPicSearchTextMallEmojiInfo.mallEmojiPicId;
                Intrinsics.checkNotNullExpressionValue(str2, "searchItem.mallEmojiInfo.mallEmojiPicId");
                iEmoticonMarketFace.sendMarketFace(aVar, i3, str2);
                return;
            }
            QLog.i("NTRichTextPanelProvider", 1, "is mall emoticon but info is null");
            return;
        }
        File diskFile = com.tencent.mobileqq.hotpic.b.getDiskFile(searchItem.originalUrl);
        if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
            str = diskFile.getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.d("NTRichTextPanelProvider", 2, "senHotPic, urlHotPicOringinal = " + searchItem.originalUrl + ", paths = " + str);
            }
        } else if (((IHotPicPageApi) QRoute.api(IHotPicPageApi.class)).checkAndDownLoadHotPic(searchItem) == 0) {
            str = com.tencent.mobileqq.hotpic.b.getDiskFile(searchItem.url).getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.d("NTRichTextPanelProvider", 2, "senHotPic, urlHotPic = " + searchItem.url + ", paths = " + str);
            }
        }
        String str3 = str;
        if (str3 == null) {
            QQToast.makeText(BaseApplication.getContext(), R.string.fkh, 0).show();
            return;
        }
        e.a aVar3 = this.emoCallbackDelegate;
        if (aVar3 != null) {
            e.a.C9450a.a(aVar3, str3, 2, null, null, null, 28, null);
        }
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void a(com.tencent.aio.api.runtime.a aioContext, EditText editText) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(editText, "editText");
        if (QLog.isDevelopLevel()) {
            QLog.i("NTRichTextPanelProvider", 4, "bindView");
        }
        this.aioContext = aioContext;
        this.editText = editText;
        com.tencent.aio.api.runtime.a aVar = null;
        if (this.richTextPanel == null) {
            RichTextPanel f16 = f();
            if (f16 != null) {
                ViewGroup viewGroup = this.panelContainer;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                    viewGroup = null;
                }
                viewGroup.removeAllViews();
                ViewGroup viewGroup2 = this.panelContainer;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                    viewGroup2 = null;
                }
                viewGroup2.addView(f16);
            } else {
                f16 = null;
            }
            this.richTextPanel = f16;
        }
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            aioContext.e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        aVar.d().getLifecycle().addObserver(this);
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void b(e.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.emoCallbackDelegate = callback;
    }

    @Override // com.tencent.mobileqq.emosm.s
    /* renamed from: d, reason: from getter */
    public e.a getEmoCallbackDelegate() {
        return this.emoCallbackDelegate;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IEmoticonDelApi iEmoticonDelApi = (IEmoticonDelApi) QRoute.api(IEmoticonDelApi.class);
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        iEmoticonDelApi.delete(editText);
    }

    @Override // com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper
    /* renamed from: getEmoPanel */
    public IEmoticonMainPanel getMainPanel() {
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo info) {
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("NTRichTextPanelProvider", 4, "onResume");
        if (this.richTextPanel == null) {
            QLog.w("NTRichTextPanelProvider", 4, "richTextPanel == null!!!!!");
        }
        RichTextPanel richTextPanel = this.richTextPanel;
        if (richTextPanel != null) {
            richTextPanel.k(true);
        }
        c();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo info) {
        if (info == null) {
            return;
        }
        if (k(info)) {
            m(h(info));
            l(info);
            return;
        }
        AppRuntime g16 = g();
        Context context = this.context;
        EditText editText = this.editText;
        com.tencent.aio.api.runtime.a aVar = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        AIOParam g17 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        info.send(g16, context, editText, su3.b.a(g17));
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest((Activity) context, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY);
        activityURIRequest.extra().putInt(EmosmEmoticonConstant.EXTRA_LAUNCH_SOURCE, 1);
        activityURIRequest.extra().putInt("extra_launch_mode", 2);
        ReportController.o(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallbackWithShowPanel
    public void showEmoticonPanel(int panelType) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("NTRichTextPanelProvider", 1007, false, 0, 12, null));
    }

    @Override // com.tencent.qqnt.aio.api.e
    public View createView() {
        QLog.i("NTRichTextPanelProvider", 4, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        FrameLayout frameLayout = new FrameLayout(this.context);
        this.panelContainer = frameLayout;
        return frameLayout;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        com.tencent.aio.api.runtime.a aVar;
        QLog.i("NTRichTextPanelProvider", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Iterator<T> it = this.messageList.iterator();
        while (true) {
            aVar = null;
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        RichTextPanel richTextPanel = this.richTextPanel;
        if (richTextPanel != null) {
            richTextPanel.h();
        }
        this.richTextPanel = null;
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar3;
        }
        aVar.d().getLifecycle().removeObserver(this);
        QQEmoticonPicLoader.f356316a.b().release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        QLog.i("NTRichTextPanelProvider", 4, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        RichTextPanel richTextPanel = this.richTextPanel;
        if (richTextPanel != null) {
            richTextPanel.i();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo oldInfo, EmoticonInfo newInfo, Drawable d16) {
        boolean z16 = false;
        if (newInfo != 0 && newInfo.type == 6) {
            IPicEmoticonInfo iPicEmoticonInfo = newInfo instanceof IPicEmoticonInfo ? (IPicEmoticonInfo) newInfo : null;
            if (iPicEmoticonInfo != null && iPicEmoticonInfo.isSound()) {
                z16 = true;
            }
            if (z16) {
                MediaPlayerManager.q(g()).D(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        e.a aVar = this.emoCallbackDelegate;
        if (aVar != null) {
            aVar.send();
        }
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void c() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo info) {
    }

    @Override // com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper
    public void setEmotionSearchPanelVisible(boolean visible, int bottom, boolean clearWord, String word, int width) {
    }
}
