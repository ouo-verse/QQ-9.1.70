package com.tencent.qqnt.emotion.relatedemo.logic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.temp.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult;
import com.tencent.qqnt.emotion.relatedemo.RelatedEmoSearchEmoticonInfo;
import com.tencent.qqnt.emotion.relatedemo.ui.NTRelatedEmotionPanel;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ww3.a;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00102\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u000f\u0012\u0006\u0010,\u001a\u00020*\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0015\u0010\t\u001a\u0004\u0018\u00010\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010(\u001a\u00020'H\u0016R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010.R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00100R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0018\u0010:\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R#\u0010A\u001a\n <*\u0004\u0018\u00010;0;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010ER\u0014\u0010G\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/logic/NTAIORelatedEmotionPanelProvider;", "Lww3/a;", "Lcom/tencent/qqnt/emotion/relatedemo/a;", "Lcom/tencent/qqnt/emotion/relatedemo/b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/emotion/relatedemo/ui/NTRelatedEmotionPanel;", "k", "Lcom/tencent/image/URLDrawable;", DomainData.DOMAIN_NAME, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Lkotlin/Pair;", "", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "l", "r", "imagePath", "", "j", "", "o", "offset", "p", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "a", "Lww3/a$a;", "callback", "c", "onDismiss", "onShow", "onClosePanel", "", Element.ELEMENT_NAME_DISTANCE, "b", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emotionInfo", "send", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mMsgItem", "I", "HEIGHT_OFFSET", "d", "mBottomLayoutHeight", "e", "mDefaultPanelContainerHeight", "f", "mExternalPanelContainerHeight", "g", "Lww3/a$a;", "mEmoCallback", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", h.F, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lmqq/app/AppRuntime;", "appRuntime", "i", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/qqnt/emotion/relatedemo/ui/NTRelatedEmotionPanel;", "mEmotionSearchPanelNT", "mMaxPanelHeight", "<init>", "(Landroid/content/Context;)V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTAIORelatedEmotionPanelProvider implements ww3.a, com.tencent.qqnt.emotion.relatedemo.a, com.tencent.qqnt.emotion.relatedemo.b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AIOMsgItem mMsgItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int HEIGHT_OFFSET;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mBottomLayoutHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mDefaultPanelContainerHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mExternalPanelContainerHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.InterfaceC11515a mEmoCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy appRuntime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NTRelatedEmotionPanel mEmotionSearchPanelNT;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int mMaxPanelHeight;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/logic/NTAIORelatedEmotionPanelProvider$a;", "", "", "DEFAULT_INPUT_HEIGHT", "I", "DEFAULT_SHORTCUT_HEIGHT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.relatedemo.logic.NTAIORelatedEmotionPanelProvider$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTAIORelatedEmotionPanelProvider(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.HEIGHT_OFFSET = ViewUtils.f352270a.b(9);
        lazy = LazyKt__LazyJVMKt.lazy(NTAIORelatedEmotionPanelProvider$appRuntime$2.INSTANCE);
        this.appRuntime = lazy;
        this.mMaxPanelHeight = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.6d);
    }

    private final boolean j(String imagePath) {
        if (imagePath != null && new File(imagePath).exists()) {
            return true;
        }
        return false;
    }

    private final NTRelatedEmotionPanel k() {
        if (this.mEmotionSearchPanelNT == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIORelatedEmotionPanelProvider", 4, "panelProvider createPanel");
            }
            View inflate = View.inflate(this.context, R.layout.f168351fq3, null);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.qqnt.emotion.relatedemo.ui.NTRelatedEmotionPanel");
            NTRelatedEmotionPanel nTRelatedEmotionPanel = (NTRelatedEmotionPanel) inflate;
            this.mEmotionSearchPanelNT = nTRelatedEmotionPanel;
            if (nTRelatedEmotionPanel != null) {
                AppRuntime m3 = m();
                Intrinsics.checkNotNull(m3, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
                nTRelatedEmotionPanel.o((BaseQQAppInterface) m3, this, this);
            }
        }
        return this.mEmotionSearchPanelNT;
    }

    private final Pair<String, URLDrawable.URLDrawableOptions> l(PicElement picElement) {
        Bitmap bitmap;
        Bitmap bitmap2;
        String r16 = r(picElement);
        int i3 = picElement.picWidth;
        int i16 = picElement.picHeight;
        Resources resources = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getContext().resources");
        Drawable drawable = ContextCompat.getDrawable(BaseApplication.context, R.drawable.aio_image_default_round);
        if (drawable != null) {
            bitmap = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        } else {
            bitmap = null;
        }
        com.tencent.mobileqq.qqui.widget.a aVar = new com.tencent.mobileqq.qqui.widget.a(resources, bitmap, i3, i16, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR, 0.0f);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i16;
        obtain.mPlayGifImage = true;
        obtain.mLoadingDrawable = aVar;
        Resources resources2 = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getContext().resources");
        Drawable drawable2 = ContextCompat.getDrawable(BaseApplication.context, R.drawable.oj_);
        if (drawable2 != null) {
            bitmap2 = DrawableKt.toBitmap$default(drawable2, 0, 0, null, 7, null);
        } else {
            bitmap2 = null;
        }
        obtain.mFailedDrawable = new com.tencent.mobileqq.qqui.widget.a(resources2, bitmap2, i3, i16, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR, 0.0f);
        if (r16 == null) {
            r16 = "";
        }
        return new Pair<>(r16, obtain);
    }

    private final AppRuntime m() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(Continuation<? super URLDrawable> continuation) {
        NTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1 nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1;
        Object coroutine_suspended;
        int i3;
        PicElement picElement;
        MarketFaceElement marketFaceElement;
        com.tencent.qqnt.msg.api.c cVar;
        if (continuation instanceof NTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1) {
            nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1 = (NTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1) continuation;
            int i16 = nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AIOMsgItem aIOMsgItem = this.mMsgItem;
                    if (aIOMsgItem == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgItem");
                        aIOMsgItem = null;
                    }
                    MsgElement firstTypeElement = aIOMsgItem.getFirstTypeElement(2);
                    if (firstTypeElement != null) {
                        picElement = firstTypeElement.picElement;
                    } else {
                        picElement = null;
                    }
                    if (picElement != null) {
                        Pair<String, URLDrawable.URLDrawableOptions> l3 = l(picElement);
                        String first = l3.getFirst();
                        URLDrawable drawable = URLDrawable.getDrawable(HippyBridge.URI_SCHEME_FILE + first, l3.getSecond());
                        drawable.downloadImediatly(true);
                        return drawable;
                    }
                    AIOMsgItem aIOMsgItem2 = this.mMsgItem;
                    if (aIOMsgItem2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgItem");
                        aIOMsgItem2 = null;
                    }
                    if (aIOMsgItem2.getMsgRecord().msgType == 17) {
                        AIOMsgItem aIOMsgItem3 = this.mMsgItem;
                        if (aIOMsgItem3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMsgItem");
                            aIOMsgItem3 = null;
                        }
                        MsgElement firstTypeElement2 = aIOMsgItem3.getFirstTypeElement(11);
                        if (firstTypeElement2 != null) {
                            marketFaceElement = firstTypeElement2.marketFaceElement;
                        } else {
                            marketFaceElement = null;
                        }
                        if (marketFaceElement == null) {
                            return null;
                        }
                        IMarketFaceApi iMarketFaceApi = (IMarketFaceApi) QRoute.api(IMarketFaceApi.class);
                        nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1.label = 1;
                        obj = iMarketFaceApi.fetchMarketFaceInfoSuspend(marketFaceElement, nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (!QLog.isDevelopLevel()) {
                            return null;
                        }
                        QLog.e("AIORelatedEmotionPanelProvider", 4, "unknown type");
                        return null;
                    }
                }
                cVar = (com.tencent.qqnt.msg.api.c) obj;
                if (!cVar.d()) {
                    IPicEmoticonInfo a16 = ((com.tencent.qqnt.emotion.adapter.api.a) cVar.a()).a();
                    if (a16 == null) {
                        return null;
                    }
                    return a16.getLoadingDrawable(EmotionConstants.FROM_AIO, true);
                }
                QLog.i("AIORelatedEmotionPanelProvider", 1, "fetchMarketFaceInfoSuspend fail msg=" + cVar.b());
                return null;
            }
        }
        nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1 = new NTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1(this, continuation);
        Object obj2 = nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1.label;
        if (i3 == 0) {
        }
        cVar = (com.tencent.qqnt.msg.api.c) obj2;
        if (!cVar.d()) {
        }
    }

    private final void o() {
        if (this.mEmotionSearchPanelNT == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "resetLastStatus");
        }
        p(0);
    }

    private final void p(int offset) {
        int i3;
        int i16 = this.HEIGHT_OFFSET;
        if (offset > i16) {
            i3 = offset - i16;
        } else {
            i3 = 0;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent("AIORelatedEmotionPanelProvider", i3, false));
    }

    private final int q() {
        if (QQTheme.isNowSimpleUI()) {
            return ViewUtils.f352270a.b(48);
        }
        return ViewUtils.f352270a.b(88);
    }

    private final String r(PicElement picElement) {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{720, 0, 198});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            String b16 = aj.b(picElement, ((Number) it.next()).intValue());
            if (j(b16)) {
                return b16;
            }
        }
        String a16 = aj.a(picElement);
        if (!j(a16)) {
            return null;
        }
        return a16;
    }

    @Override // ww3.a
    public void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.aio.data.msglist.a msgItem) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        this.mAIOContext = aioContext;
        this.mMsgItem = (AIOMsgItem) msgItem;
        this.mBottomLayoutHeight = q();
        if (this.mEmotionSearchPanelNT == null) {
            this.mEmotionSearchPanelNT = k();
        } else if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "mEmotionSearchPanel not null");
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        h.b bVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        k k3 = aVar.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d);
        if (k3 instanceof h.b) {
            bVar = (h.b) k3;
        }
        int i16 = 0;
        if (bVar != null) {
            i3 = bVar.b();
        } else {
            i3 = 0;
        }
        this.mDefaultPanelContainerHeight = i3;
        if (bVar != null) {
            i16 = bVar.a();
        }
        this.mExternalPanelContainerHeight = i16;
        if (QLog.isColorLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 2, "panelProvider bindView: msgItem:" + msgItem + ", bottomHeight: " + this.mBottomLayoutHeight);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 2, "\u9762\u677f\u9ed8\u8ba4\u9ad8\u5ea6:" + this.mDefaultPanelContainerHeight + ", \u5f53\u524d\u9ad8\u5ea6:" + this.mExternalPanelContainerHeight);
        }
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.a
    public void b(float distance) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(distance));
            return;
        }
        if (this.mEmotionSearchPanelNT == null) {
            return;
        }
        int i16 = this.mMaxPanelHeight;
        int i17 = (int) (i16 - distance);
        if (i17 < i16) {
            if (i17 < 0) {
                i16 = 0;
            } else {
                i16 = i17;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "\u66f4\u65b0\u76f8\u5173\u8868\u60c5\u9762\u677f\u9ad8\u5ea6:" + i16);
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        h.b bVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        k k3 = aVar.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d);
        if (k3 instanceof h.b) {
            bVar = (h.b) k3;
        }
        if (bVar != null) {
            i3 = bVar.a();
        } else {
            i3 = -1;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "\u5f53\u524d\u9762\u677f\u5bb9\u5668\u9ad8\u5ea6:" + i3);
        }
        if (i3 < 0) {
            return;
        }
        int i18 = this.mExternalPanelContainerHeight;
        if (i18 > 0) {
            if (i16 >= i18 && i3 <= this.mMaxPanelHeight) {
                int i19 = i16 - i18;
                if (QLog.isDevelopLevel()) {
                    QLog.i("AIORelatedEmotionPanelProvider", 4, "\u521d\u59cb\u9762\u677f\u5bb9\u5668\u5c55\u5f00\uff0c\u8c03\u6574\u9ad8\u5ea6:" + i19);
                }
                p(i19);
                return;
            }
            int i26 = this.mDefaultPanelContainerHeight;
            if (i16 <= i26 && i3 != i26) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("AIORelatedEmotionPanelProvider", 4, "\u521d\u59cb\u9762\u677f\u5bb9\u5668\u5c55\u5f00\uff0c\u76f8\u5173\u9762\u677f\u4f4e\u4e8e\u5bb9\u5668\u9ad8\u5ea6\uff0c\u91cd\u7f6e\u5bb9\u5668\u9ad8\u5ea6");
                }
                p(0);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "\u521d\u59cb\u9762\u677f\u5bb9\u5668\u672a\u5c55\u5f00\uff0c\u76f4\u63a5\u8bbe\u7f6e\u9ad8\u5ea6:" + i16);
        }
        p(i16);
    }

    @Override // ww3.a
    public void c(@NotNull a.InterfaceC11515a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mEmoCallback = callback;
        }
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.a
    public void onClosePanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgListEvent.InputToolBarChanged(false));
        o();
        this.mEmotionSearchPanelNT = null;
    }

    @Override // ww3.a
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "panelProvider onDismiss");
        }
        NTRelatedEmotionPanel nTRelatedEmotionPanel = this.mEmotionSearchPanelNT;
        if (nTRelatedEmotionPanel != null) {
            nTRelatedEmotionPanel.r();
        }
    }

    @Override // ww3.a
    public void onShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgListEvent.InputToolBarChanged(true));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new NTAIORelatedEmotionPanelProvider$onShow$1(this, null), 3, null);
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.b
    public void send(@NotNull EmoticonInfo emotionInfo) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) emotionInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(emotionInfo, "emotionInfo");
        if (!(emotionInfo instanceof RelatedEmoSearchEmoticonInfo)) {
            return;
        }
        NTRelatedEmotionSearchResult.SearchResultItem c16 = ((RelatedEmoSearchEmoticonInfo) emotionInfo).c();
        if (c16 != null) {
            str = c16.b();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.e("AIORelatedEmotionPanelProvider", 4, "emotionInfo file no exist");
            }
            QQToast.makeText(this.context, R.string.fkh, 0).show();
            return;
        }
        File file = AbsDownloader.getFile(str);
        if (file != null && file.exists()) {
            a.InterfaceC11515a interfaceC11515a = this.mEmoCallback;
            if (interfaceC11515a != null) {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                a.InterfaceC11515a.C11516a.a(interfaceC11515a, absolutePath, 10, null, null, 12, null);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("AIORelatedEmotionPanelProvider", 4, "emotionInfo file no exist");
        }
        QQToast.makeText(this.context, R.string.fkh, 0).show();
    }
}
