package com.tencent.mobileqq.aio.msglist.holder.base.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.w;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.aio.api.IFlashPicApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"JH\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J&\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/util/c;", "", "Landroid/widget/ImageView;", "picView", "loadingView", "", "imagePath", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "picSize", "", "decodeWidth", "decodeHeight", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "d", "Lcom/tencent/libra/request/Option;", "option", "Landroid/graphics/Bitmap;", "c", "flashPicView", ToastView.ICON_LOADING, "Lcom/tencent/mobileqq/aio/msg/PicMsgItem;", "f", "Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "b", "Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "picApi", "I", "thumbWith", "thumbHeight", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f190636a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IPicAIOApi picApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int thumbWith;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int thumbHeight;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f190636a = new c();
        QRouteApi api = QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPicAIOApi::class.java)");
        picApi = (IPicAIOApi) api;
        thumbWith = ViewUtils.dpToPx(130.0f);
        thumbHeight = ViewUtils.dpToPx(102.0f);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bitmap c(Option option) {
        Bitmap b16;
        if (option.getResultBitMap() != null) {
            b16 = option.getResultBitMap();
            Intrinsics.checkNotNullExpressionValue(b16, "{\n            option.resultBitMap\n        }");
        } else if (option.getAnimatable() instanceof GifDrawable) {
            QLog.i("FlashPicViewUtil", 1, "flash pic is gif");
            Animatable animatable = option.getAnimatable();
            Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.libra.extension.gif.GifDrawable");
            b16 = ((GifDrawable) animatable).b();
            Intrinsics.checkNotNullExpressionValue(b16, "{\n            QLog.i(TAG\u2026e).currentFrame\n        }");
        } else {
            QLog.e("FlashPicViewUtil", 1, "no result bitmap");
            return null;
        }
        Bitmap bitmap = b16;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(130.0f / width, 102.0f / height);
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        int width2 = resizeBmp.getWidth() / 8;
        if (width2 == 0) {
            width2 = 16;
        }
        QLog.d("FlashPicViewUtil", 1, "reqWidth: 130.0, reqHeight: 102.0, bmp w: " + width + ", bmp h: " + height + ", resizeBmp w: " + resizeBmp.getWidth() + ", h: " + resizeBmp.getHeight());
        try {
            IFlashPicApi iFlashPicApi = (IFlashPicApi) QRoute.api(IFlashPicApi.class);
            Intrinsics.checkNotNullExpressionValue(resizeBmp, "resizeBmp");
            return iFlashPicApi.getMosaicBitmap(resizeBmp, width2);
        } catch (Exception unused) {
            QLog.e("FlashPicViewUtil", 1, "fail to get mosaic");
            return null;
        }
    }

    @MainThread
    private final void d(final ImageView picView, final ImageView loadingView, String imagePath, final PicSize picSize, int decodeWidth, int decodeHeight, final MsgElement msgElement, final AIOMsgItem msgItem) {
        IPicAIOApi iPicAIOApi = picApi;
        Option obtain = Option.obtain();
        if (QLog.isColorLevel()) {
            QLog.d("FlashPicViewUtil", 2, "[loadFlashImage] seq=" + obtain.getSeq() + " msgId=" + msgItem.getMsgId() + " msgElementId=" + msgElement.elementId);
        }
        obtain.setUrl(imagePath);
        obtain.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(imagePath)).build());
        obtain.setRequestWidth(decodeWidth);
        obtain.setRequestHeight(decodeHeight);
        obtain.setLocalPath(imagePath);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("picMsgElement", msgElement);
        concurrentHashMap.put("aioMsgItem", msgItem);
        concurrentHashMap.put("picType", AIOPicDownloader.f190570a.m(picSize));
        obtain.setExtraData(concurrentHashMap);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026          }\n            }");
        iPicAIOApi.loadPic(obtain, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.util.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                c.e(loadingView, msgItem, msgElement, picSize, picView, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ImageView loadingView, AIOMsgItem msgItem, MsgElement msgElement, PicSize picSize, ImageView picView, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(loadingView, "$loadingView");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullParameter(picSize, "$picSize");
        Intrinsics.checkNotNullParameter(picView, "$picView");
        if (loadState.isFinishSuccess()) {
            loadingView.setVisibility(8);
            if (msgItem instanceof w) {
                ((w) msgItem).l2(msgElement.elementId, 4, option.getLocalPath(), picSize);
            }
            c cVar = f190636a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            Bitmap c16 = cVar.c(option);
            if (c16 == null) {
                return;
            }
            picView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            picView.setImageBitmap(c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(PicMsgItem msgItem, ImageView loading, ImageView flashPicView, MsgElement msgElement, Ref.ObjectRef thumbPath, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(loading, "$loading");
        Intrinsics.checkNotNullParameter(flashPicView, "$flashPicView");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullParameter(thumbPath, "$thumbPath");
        if (!msgItem.s2() && loading.getVisibility() == 8) {
            try {
                ((IFlashPicApi) QRoute.api(IFlashPicApi.class)).enterFlashPicPreview(flashPicView, msgItem.q0(), msgItem.r0(), msgElement, msgItem.isSelf(), (String) thumbPath.element);
            } catch (Exception unused) {
                QLog.e("FlashPicViewUtil", 1, "fail to enter preview");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    public final void f(@NotNull final ImageView flashPicView, @NotNull final ImageView loading, @NotNull final PicMsgItem msgItem, @NotNull final MsgElement msgElement) {
        ArrayList<PicSize> arrayListOf;
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, flashPicView, loading, msgItem, msgElement);
            return;
        }
        Intrinsics.checkNotNullParameter(flashPicView, "flashPicView");
        Intrinsics.checkNotNullParameter(loading, "loading");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        flashPicView.getLayoutParams().width = thumbWith;
        flashPicView.getLayoutParams().height = thumbHeight;
        flashPicView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.util.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.g(PicMsgItem.this, loading, flashPicView, msgElement, objectRef, view);
            }
        });
        PicSize picSize = PicSize.PIC_DOWNLOAD_THUMB;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(picSize, PicSize.PIC_DOWNLOAD_ORI);
        Pair<PicSize, String> j26 = msgItem.j2(msgElement.elementId, arrayListOf);
        if (j26 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashPicViewUtil", 2, "[applyFlashPicView] load from cache, msgId=" + msgItem.getMsgId() + ", picSize=" + j26.getFirst() + ", path=" + ((Object) j26.getSecond()));
            }
            objectRef.element = j26.getSecond();
            f190636a.d(flashPicView, loading, j26.getSecond(), j26.getFirst(), thumbWith, thumbHeight, msgElement, msgItem);
            return;
        }
        AIOPicDownloader aIOPicDownloader = AIOPicDownloader.f190570a;
        PicElement picElement = msgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "msgElement.picElement");
        ?? l3 = aIOPicDownloader.l(picElement, picSize);
        if (l3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashPicViewUtil", 2, "[applyFlashPicView] need download, msgId=" + msgItem.getMsgId() + ", picSize=" + picSize);
            }
            objectRef.element = l3;
            f190636a.d(flashPicView, loading, l3, picSize, thumbWith, thumbHeight, msgElement, msgItem);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("FlashPicViewUtil", 1, "[applyFlashPicView] error, msgId=" + msgItem.getMsgId() + ", thumbPath is empty, picSize=" + picSize);
        }
    }
}
