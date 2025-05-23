package com.tencent.sqshow.zootopia.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ZplanImageDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGText;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J=\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/k;", "", "", "path", "Landroid/graphics/Bitmap;", "b", "Lorg/libpag/PAGFile;", "pagFile", "", NodeProps.VISIBLE, "", "layerIndex", "", "i", "imageUrl", "Lcom/tencent/sqshow/zootopia/utils/k$a;", "listener", "c", MimeHelper.IMAGE_SUBTYPE_BITMAP, "d", "text", "textColor", "bold", "e", "(Lorg/libpag/PAGFile;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "g", tl.h.F, "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f373283a = new k();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/k$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/utils/k$b", "Lcom/tencent/sqshow/zootopia/utils/ZplanImageDownloader$a;", "", "url", "filePath", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ZplanImageDownloader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f373284a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f373285b;

        b(String str, a aVar) {
            this.f373284a = str;
            this.f373285b = aVar;
        }

        @Override // com.tencent.sqshow.zootopia.utils.ZplanImageDownloader.a
        public void a(String url, String filePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            if (Intrinsics.areEqual(this.f373284a, url)) {
                QLog.d("pagViewHelper", 1, "onImageDownloaded  " + url + "  ||| " + filePath + " ");
                this.f373285b.a(k.f373283a.b(filePath));
                ZplanImageDownloader.f373239a.j(this);
            }
        }
    }

    k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap b(String path) {
        if (path.length() == 0) {
            return null;
        }
        try {
            return BitmapFactory.decodeFile(path);
        } catch (Exception e16) {
            QLog.e("pagViewHelper", 1, "decode file error ", e16);
            return null;
        }
    }

    public final void c(String imageUrl, a listener) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("pagViewHelper", 1, "get drawable by url  " + imageUrl + " ");
        ZplanImageDownloader zplanImageDownloader = ZplanImageDownloader.f373239a;
        String g16 = zplanImageDownloader.g(imageUrl);
        if (g16 != null) {
            if (g16.length() > 0) {
                QLog.d("pagViewHelper", 1, "get image from cache  " + imageUrl + " ||| " + g16 + " ");
                listener.a(BitmapFactory.decodeFile(g16));
                return;
            }
        }
        zplanImageDownloader.d(new b(imageUrl, listener));
    }

    public final boolean d(PAGFile pagFile, int layerIndex, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(pagFile, "pagFile");
        int numImages = pagFile.numImages();
        if (layerIndex >= 0 && layerIndex < numImages) {
            if (bitmap != null) {
                pagFile.replaceImage(layerIndex, PAGImage.FromBitmap(bitmap));
                i(pagFile, true, layerIndex);
            } else {
                i(pagFile, false, layerIndex);
            }
            return true;
        }
        QLog.e("pagViewHelper", 1, " layerIndex is invalid " + layerIndex + " " + numImages);
        return false;
    }

    public final void e(PAGFile pagFile, int layerIndex, String text, String textColor, Boolean bold) {
        Intrinsics.checkNotNullParameter(pagFile, "pagFile");
        int numTexts = pagFile.numTexts();
        if (layerIndex >= 0 && layerIndex < numTexts) {
            PAGText textData = pagFile.getTextData(layerIndex);
            textData.text = text;
            if (bold != null) {
                bold.booleanValue();
                textData.fauxBold = bold.booleanValue();
            }
            boolean z16 = false;
            if (textColor != null) {
                try {
                    if (textColor.length() > 0) {
                        z16 = true;
                    }
                } catch (Exception unused) {
                    QLog.e("pagViewHelper", 1, "invalid color params " + textColor);
                }
            }
            if (z16) {
                textData.fillColor = Color.parseColor(textColor);
            }
            i(pagFile, true, layerIndex);
            pagFile.replaceText(layerIndex, textData);
            return;
        }
        QLog.e("pagViewHelper", 1, "handleTextLayer layerIndex is invalid " + layerIndex + " " + numTexts);
    }

    public final String g(PAGFile pagFile, int layerIndex) {
        Intrinsics.checkNotNullParameter(pagFile, "pagFile");
        QLog.d("pagViewHelper", 1, "get textLayer " + layerIndex);
        PAGText textData = pagFile.getTextData(layerIndex);
        if (textData == null) {
            return null;
        }
        return textData.text;
    }

    public final void h(PAGFile pagFile, int layerIndex, boolean visible) {
        Intrinsics.checkNotNullParameter(pagFile, "pagFile");
        int numImages = pagFile.numImages();
        if (layerIndex >= 0 && layerIndex < numImages) {
            i(pagFile, visible, layerIndex);
            return;
        }
        QLog.e("pagViewHelper", 1, "handleTextLayer layerIndex is invalid " + numImages);
    }

    private final void i(PAGFile pagFile, boolean visible, int layerIndex) {
        PAGLayer pAGLayer;
        PAGLayer[] layersByEditableIndex = pagFile.getLayersByEditableIndex(layerIndex, 5);
        if (layersByEditableIndex != null) {
            if (!(!(layersByEditableIndex.length == 0)) || (pAGLayer = layersByEditableIndex[0]) == null) {
                return;
            }
            pAGLayer.setVisible(visible);
        }
    }

    public static /* synthetic */ void f(k kVar, PAGFile pAGFile, int i3, String str, String str2, Boolean bool, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            bool = Boolean.FALSE;
        }
        kVar.e(pAGFile, i3, str, str2, bool);
    }
}
