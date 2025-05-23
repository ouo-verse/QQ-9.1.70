package com.qzone.reborn.feedpro.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.qzone.reborn.layer.part.QZoneBasePictureViewerPart;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPDecoderWrapper;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import libavif.AvifDecoder;
import libavif.AvifImage;
import oo.b;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J.\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J,\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J:\u0010\u0019\u001a\u00020\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010!\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010&\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/QzoneFeedProLongPicUtils;", "", "", "Lge/i;", "shareItemBeans", "Lkotlin/Pair;", "", DomainData.DOMAIN_NAME, "downloadPicList", "localPathUrlList", "Lcom/qzone/reborn/feedpro/utils/QzoneFeedProLongPicUtils$a;", "callback", "", "p", "fileList", "Landroid/graphics/Bitmap;", "g", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "filePaths", "fileTypes", "", "heightList", "screenWidth", "l", "downloadUrl", "picLoaderPath", "tempFilePath", "", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mediaInfos", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "TAG", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProLongPicUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final QzoneFeedProLongPicUtils f54255a = new QzoneFeedProLongPicUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QzoneFeedProLongPicUtils";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/QzoneFeedProLongPicUtils$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "onFail", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a {
        void a(Bitmap bitmap);

        void onFail();
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/utils/QzoneFeedProLongPicUtils$b", "Loo/b$b;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "urlList", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements b.InterfaceC10931b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f54257a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f54258b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f54259c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f54260d;

        b(String str, List<String> list, List<String> list2, a aVar) {
            this.f54257a = str;
            this.f54258b = list;
            this.f54259c = list2;
            this.f54260d = aVar;
        }

        @Override // oo.b.InterfaceC10931b
        public void a(ArrayList<String> urlList) {
            Intrinsics.checkNotNullParameter(urlList, "urlList");
            if (ArrayUtils.isOutOfArrayIndex(0, urlList)) {
                QzoneFeedProLongPicUtils qzoneFeedProLongPicUtils = QzoneFeedProLongPicUtils.f54255a;
                RFWLog.e(qzoneFeedProLongPicUtils.o(), RFWLog.USR, "saveLongPic byWatermarkManger return invalid result,originUrl:" + this.f54257a);
                qzoneFeedProLongPicUtils.p(this.f54258b, this.f54259c, this.f54260d);
                return;
            }
            String str = urlList.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "urlList[0]");
            String str2 = str;
            QzoneFeedProLongPicUtils qzoneFeedProLongPicUtils2 = QzoneFeedProLongPicUtils.f54255a;
            RFWLog.d(qzoneFeedProLongPicUtils2.o(), RFWLog.USR, "saveLongPic byWatermarkManger,originUrl:", this.f54257a, ",replaceUrl:", str2);
            List<String> list = this.f54258b;
            list.set(list.size() - 1, str2);
            List<String> list2 = this.f54259c;
            list2.set(list2.size() - 1, "");
            qzoneFeedProLongPicUtils2.p(this.f54258b, this.f54259c, this.f54260d);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/utils/QzoneFeedProLongPicUtils$c", "Loo/b$a;", "", "retCode", "", "errorMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f54261a;

        c(a aVar) {
            this.f54261a = aVar;
        }

        @Override // oo.b.a
        public void a(long retCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            RFWLog.d(QzoneFeedProLongPicUtils.f54255a.o(), RFWLog.USR, "saveLongPic byWatermarkManger error:" + retCode + ",msg:" + errorMsg);
            this.f54261a.onFail();
        }
    }

    QzoneFeedProLongPicUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap g(List<String> fileList) {
        int size;
        Bitmap c16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (Object obj : fileList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (str != null) {
                String Ua = QZoneBasePictureViewerPart.Ua(str);
                if (Ua != null) {
                    arrayList2.add(str);
                    arrayList.add(Ua);
                } else {
                    RFWLog.e(TAG, RFWLog.USR, "doBuildLongPic error: postFix is null " + str);
                }
            }
            i3 = i16;
        }
        int i17 = RFWApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
        ArrayList arrayList3 = new ArrayList();
        long m3 = m();
        int l3 = l(arrayList2, arrayList, arrayList3, i17);
        int i18 = i17 * l3 * 2;
        while (true) {
            if ((l3 > 29999 || i18 > m3 * 0.85d) && (size = arrayList2.size() - 1) > 0) {
                l3 -= arrayList3.get(size).intValue();
                i18 -= (arrayList3.get(size).intValue() * i17) * 2;
                String remove = arrayList2.remove(size);
                arrayList.remove(size);
                arrayList3.remove(size);
                QZLog.i(TAG, "remove for length limit:" + remove);
            }
        }
        Bitmap longBitmap = Bitmap.createBitmap(i17, l3, Bitmap.Config.RGB_565);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;
        int size2 = arrayList.size();
        int i19 = 0;
        for (int i26 = 0; i26 < size2; i26++) {
            try {
                String str2 = arrayList2.get(i26);
                if (Intrinsics.areEqual("sharpp", arrayList.get(i26))) {
                    QZLog.i(TAG, "sharpp file");
                    c16 = SharpPUtils.decodeSharpP(str2);
                } else if (Intrinsics.areEqual(arrayList.get(i26), "avif")) {
                    QZLog.i(TAG, "avif file");
                    c16 = com.tencent.qzone.image.api.a.c().a(new File(str2), str2, 0, 0);
                } else {
                    c16 = com.qzone.util.image.c.c(BitmapFactory.decodeFile(str2, options), 90);
                }
                if (c16 != null && i26 < arrayList3.size() && arrayList3.get(i26).intValue() > 0) {
                    PhotoUtils.drawBitmap(longBitmap, com.qzone.util.image.c.F(c16, i17 / c16.getWidth()), i19);
                    i19 += arrayList3.get(i26).intValue();
                }
            } catch (Throwable th5) {
                QZLog.w(TAG, "copy picture error ", th5);
            }
        }
        Intrinsics.checkNotNullExpressionValue(longBitmap, "longBitmap");
        return longBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<String> fileList) {
        for (String str : fileList) {
            if (str != null) {
                try {
                    FileUtils.deleteFile(new File(str));
                } catch (Exception e16) {
                    QZLog.w(TAG, "doDeleteTempFile error:" + e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final CompletableDeferred deferredResult, String downloadUrl, final String tempFilePath, LoadState state, Option option) {
        Intrinsics.checkNotNullParameter(deferredResult, "$deferredResult");
        Intrinsics.checkNotNullParameter(downloadUrl, "$downloadUrl");
        Intrinsics.checkNotNullParameter(tempFilePath, "$tempFilePath");
        Intrinsics.checkNotNullParameter(state, "state");
        final String localPath = option != null ? option.getLocalPath() : null;
        if (state.isFinishSuccess()) {
            if (!(localPath == null || localPath.length() == 0)) {
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.feedpro.utils.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        QzoneFeedProLongPicUtils.k(localPath, tempFilePath, deferredResult);
                    }
                });
                return;
            }
        }
        if (state.isFinishError()) {
            deferredResult.complete(Boolean.FALSE);
            RFWLog.d(TAG, RFWLog.USR, "realSaveLongPic error:" + downloadUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String str, String tempFilePath, CompletableDeferred deferredResult) {
        Intrinsics.checkNotNullParameter(tempFilePath, "$tempFilePath");
        Intrinsics.checkNotNullParameter(deferredResult, "$deferredResult");
        deferredResult.complete(Boolean.valueOf(FileUtils.copyFile(new File(str), new File(tempFilePath))));
    }

    private final int l(List<String> filePaths, List<String> fileTypes, List<Integer> heightList, int screenWidth) {
        int i3;
        int i16;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int size = fileTypes.size();
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            if (Intrinsics.areEqual(fileTypes.get(i18), "sharpp")) {
                SharpPDecoderWrapper.SharpPFeatureWrapper featureInfo = new SharpPDecoderHelper(filePaths.get(i18)).getFeatureInfo();
                if (featureInfo != null) {
                    i3 = featureInfo.getWidth();
                    i16 = featureInfo.getHeight();
                } else {
                    i3 = -1;
                    i16 = -1;
                }
            } else if (Intrinsics.areEqual(fileTypes.get(i18), "avif")) {
                byte[] readFile = FileUtils.readFile(filePaths.get(i18));
                Intrinsics.checkNotNullExpressionValue(readFile, "readFile(filePaths[i])");
                AvifImage g16 = AvifDecoder.c(readFile).g();
                Intrinsics.checkNotNullExpressionValue(g16, "decoder.image");
                i3 = g16.b();
                i16 = g16.a();
            } else {
                BitmapFactory.decodeFile(filePaths.get(i18), options);
                i3 = options.outWidth;
                i16 = options.outHeight;
            }
            if (i3 > 0 && i16 > 0) {
                int i19 = (int) ((i16 * screenWidth) / i3);
                heightList.add(Integer.valueOf(i19));
                i17 += i19;
            } else {
                heightList.add(0);
            }
        }
        return i17;
    }

    private final long m() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }

    private final Pair<List<String>, List<String>> n(List<ge.i> shareItemBeans) {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerPicInfo layerPicInfo2;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ge.i iVar : shareItemBeans) {
            RFWLayerItemMediaInfo mediaInfo = iVar.getMediaInfo();
            String str = null;
            String url = (mediaInfo == null || (layerPicInfo2 = mediaInfo.getLayerPicInfo()) == null || (currentPicInfo2 = layerPicInfo2.getCurrentPicInfo()) == null) ? null : currentPicInfo2.getUrl();
            RFWLayerItemMediaInfo mediaInfo2 = iVar.getMediaInfo();
            if (mediaInfo2 != null && (layerPicInfo = mediaInfo2.getLayerPicInfo()) != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null) {
                str = currentPicInfo.getLocalPath();
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (!TextUtils.isEmpty(url)) {
                Intrinsics.checkNotNull(url);
                arrayList.add(url);
                Intrinsics.checkNotNull(str);
                arrayList2.add(str);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(List<String> downloadPicList, List<String> localPathUrlList, a callback) {
        if (downloadPicList.size() == localPathUrlList.size()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getDefault(), null, new QzoneFeedProLongPicUtils$realSaveLongPic$1(downloadPicList, callback, localPathUrlList, null), 2, null);
        } else {
            RFWLog.d(TAG, RFWLog.USR, "realSaveLongPic size not equals");
            callback.onFail();
        }
    }

    public final String o() {
        return TAG;
    }

    public final void q(List<ge.i> mediaInfos, a callback) {
        List listOf;
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Pair<List<String>, List<String>> n3 = n(mediaInfos);
        List<String> first = n3.getFirst();
        List<String> second = n3.getSecond();
        if (first.isEmpty()) {
            RFWLog.e(TAG, RFWLog.USR, "saveLongPic urlList is empty");
            callback.onFail();
        }
        if (oo.b.l()) {
            String str = first.get(first.size() - 1);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
            oo.b.g(null, 1, listOf, new b(str, first, second, callback), new c(callback));
            return;
        }
        p(first, second, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(final String str, String str2, final String str3, Continuation<? super Boolean> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setLocalPath(str2).setNeedShowLoadingDrawable(false).setTargetView(null).setRequestWidth(ImmersiveUtils.getScreenWidth()), new IPicLoadStateListener() { // from class: com.qzone.reborn.feedpro.utils.s
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QzoneFeedProLongPicUtils.j(CompletableDeferred.this, str, str3, loadState, option);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }
}
