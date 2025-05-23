package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.internal.view.SupportMenu;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Comm_errKt;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ResourcesFactory {
    static IPatchRedirector $redirector_;
    public static final byte[] sBaseChunk;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(Comm_errKt.QZRetCode_QZ_VIDEO_TRANSCODING);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sBaseChunk = new byte[]{1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94, 0, 0, 0, 0, 0, 0, 0, 94, 0, 0, 0, 1, 0, 0, 0};
        }
    }

    public ResourcesFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SkinnableColorStateList createColorStateListFromXmlFile(SkinEngine skinEngine, Resources resources, File file, boolean z16) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (z16) {
            newPullParser = new AndroidXmlResourceParser();
        } else {
            newPullParser = Xml.newPullParser();
        }
        InputStream useCacheInputStream = skinEngine.useCacheInputStream(file.getAbsolutePath());
        if (useCacheInputStream == null) {
            useCacheInputStream = new FileInputStream(file);
        }
        newPullParser.setInput(useCacheInputStream, "UTF-8");
        SkinnableColorStateList createFromXml = SkinnableColorStateList.createFromXml(skinEngine, resources, newPullParser, z16);
        useCacheInputStream.close();
        if (SkinEngine.DEBUG) {
            Log.d(SkinEngine.TAG, "load colorList:" + file + " , cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
        }
        return createFromXml;
    }

    public static BaseConstantState createImageFromResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, String str, BitmapFactory.Options options, Rect rect, boolean z16) throws IOException {
        BitmapFactory.Options options2;
        Bitmap bitmap;
        Bitmap decodeResourceStream;
        Rect rect2;
        Rect rect3;
        byte[] bArr = null;
        if (inputStream == null) {
            return null;
        }
        if (options == null) {
            options2 = new BitmapFactory.Options();
        } else {
            options2 = options;
        }
        options2.inScreenDensity = resources.getDisplayMetrics().densityDpi;
        if (inputStream instanceof FileInputStream) {
            options2.inScaled = z16;
            decodeResourceStream = decodeResourceStream(resources, typedValue, inputStream, rect, options2);
        } else {
            try {
                decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options2);
            } catch (NullPointerException | OutOfMemoryError unused) {
                bitmap = null;
            }
        }
        bitmap = decodeResourceStream;
        boolean z17 = true;
        if (options2.inJustDecodeBounds) {
            int[] iArr = {options2.outWidth, options2.outHeight, options2.inDensity};
            if (str.endsWith(".9.png")) {
                SkinnableNinePatchDrawable.a aVar = new SkinnableNinePatchDrawable.a(null, null, new Rect(0, 0, 0, 0));
                aVar.mImageSizeWhenOOM = iArr;
                aVar.f376041f = resources.getDisplayMetrics().densityDpi;
                return aVar;
            }
            SkinnableBitmapDrawable.BitmapState bitmapState = new SkinnableBitmapDrawable.BitmapState((Bitmap) null);
            bitmapState.mImageSizeWhenOOM = iArr;
            bitmapState.mTargetDensity = resources.getDisplayMetrics().densityDpi;
            return bitmapState;
        }
        if (bitmap == null) {
            return null;
        }
        if (str.endsWith(".9.png")) {
            if (z16) {
                byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    z17 = false;
                    rect3 = rect;
                } else {
                    ninePatchChunk = makeChunk(bitmap);
                    rect3 = new Rect();
                    SkinEngine.getInstances();
                    if (SkinEngine.mThemeService != null) {
                        SkinEngine.getInstances();
                        SkinEngine.mThemeService.reportResInfo(str, 1, "9PatchError", "", "");
                    }
                }
                SkinnableNinePatchDrawable.a aVar2 = new SkinnableNinePatchDrawable.a(new NinePatch(bitmap, ninePatchChunk, str), bitmap, rect3);
                aVar2.f376041f = resources.getDisplayMetrics().densityDpi;
                aVar2.hasProblem = z17;
                return aVar2;
            }
            try {
                bArr = grabNinePatchChunk(bitmap, rect);
            } catch (IllegalArgumentException e16) {
                if (SkinEngine.DEBUG) {
                    Log.e(SkinEngine.TAG, "", e16);
                }
            }
            if (bArr != null && NinePatch.isNinePatchChunk(bArr)) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 1, 1, bitmap.getWidth() - 2, bitmap.getHeight() - 2);
                bitmap.recycle();
                bitmap = createBitmap;
                z17 = false;
                rect2 = rect;
            } else {
                byte[] makeChunk = makeChunk(bitmap);
                rect2 = new Rect();
                SkinEngine.getInstances();
                if (SkinEngine.mThemeService != null) {
                    SkinEngine.getInstances();
                    SkinEngine.mThemeService.reportResInfo(str, 1, "9PatchError", "", "");
                }
                bArr = makeChunk;
            }
            SkinnableNinePatchDrawable.a aVar3 = new SkinnableNinePatchDrawable.a(new NinePatch(bitmap, bArr, str), bitmap, rect2);
            aVar3.hasProblem = z17;
            aVar3.f376041f = resources.getDisplayMetrics().densityDpi;
            return aVar3;
        }
        SkinnableBitmapDrawable.BitmapState bitmapState2 = new SkinnableBitmapDrawable.BitmapState(bitmap);
        bitmapState2.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        return bitmapState2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BaseConstantState createImageFromXml(Resources resources, XmlPullParser xmlPullParser, XmlPullParser xmlPullParser2, boolean z16) throws XmlPullParserException, IOException {
        int next;
        int next2;
        SkinnableBitmapDrawable.BitmapState createImageFromXmlInner;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (xmlPullParser2 == null) {
            if (next == 2) {
                createImageFromXmlInner = createImageFromXmlInner(resources, xmlPullParser, asAttributeSet, null, z16);
            } else {
                throw new XmlPullParserException("No start tag found");
            }
        } else {
            AttributeSet asAttributeSet2 = Xml.asAttributeSet(xmlPullParser2);
            do {
                next2 = xmlPullParser2.next();
                if (next2 == 2) {
                    break;
                }
            } while (next2 != 1);
            if (next2 == 2) {
                createImageFromXmlInner = createImageFromXmlInner(resources, xmlPullParser, asAttributeSet, asAttributeSet2, z16);
            } else {
                throw new XmlPullParserException("No start tag found");
            }
        }
        if (createImageFromXmlInner != null) {
            return createImageFromXmlInner;
        }
        throw new RuntimeException("Unknown initial tag: " + xmlPullParser.getName());
    }

    static SkinnableBitmapDrawable.BitmapState createImageFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, AttributeSet attributeSet2, boolean z16) throws XmlPullParserException, IOException {
        boolean z17;
        String name = xmlPullParser.getName();
        if (name.equals(MimeHelper.IMAGE_SUBTYPE_BITMAP)) {
            SkinnableBitmapDrawable.BitmapState inflateBitmapState = SkinnableBitmapDrawable.inflateBitmapState(resources, xmlPullParser, attributeSet, attributeSet2, z16);
            int i3 = 0;
            if (attributeSet != null) {
                for (int i16 = 0; i16 < attributeSet.getAttributeCount(); i16++) {
                    if ("isNeedScale".equals(attributeSet.getAttributeName(i16))) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (!z17 && attributeSet2 != null) {
                while (true) {
                    if (i3 >= attributeSet2.getAttributeCount()) {
                        break;
                    }
                    if ("isNeedScale".equals(attributeSet2.getAttributeName(i3))) {
                        z17 = true;
                        break;
                    }
                    i3++;
                }
            }
            if (z17) {
                inflateBitmapState.bitmapType = 1;
            }
            return inflateBitmapState;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid drawable tag " + name);
    }

    static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i3 = typedValue.density;
            if (i3 == 0) {
                options.inDensity = 160;
            } else if (i3 != 65535) {
                options.inDensity = i3;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    static byte[] grabNinePatchChunk(Bitmap bitmap, Rect rect) throws IllegalArgumentException, IOException {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3;
        int i16;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 2 && height > 2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(83);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (int i17 = 0; i17 < 32; i17++) {
                dataOutputStream.write(0);
            }
            int i18 = width - 2;
            int[] iArr = new int[i18];
            bitmap.getPixels(iArr, 0, width, 1, 0, i18, 1);
            if (iArr[0] == -16777216) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (iArr[i18 - 1] == -16777216) {
                z17 = true;
            } else {
                z17 = false;
            }
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            while (true) {
                int i28 = SupportMenu.CATEGORY_MASK;
                if (i19 < i18) {
                    int i29 = iArr[i19];
                    if (i29 == -65536) {
                        i29 = 0;
                    }
                    if (i29 != -16777216 && i29 != 0) {
                        throw new IllegalArgumentException("Ticks in transparent frame must be black or red. Fount at pixel #" + (i19 + 1) + " along top edge");
                    }
                    if (i27 != i29) {
                        i26++;
                        dataOutputStream.writeInt(Integer.reverseBytes(i19));
                        i27 = i29;
                    }
                    i19++;
                } else {
                    if (z17) {
                        i26++;
                        dataOutputStream.writeInt(Integer.reverseBytes(i18));
                    }
                    int i36 = i26 + 1;
                    if (z16) {
                        i36--;
                    }
                    if (z17) {
                        i36--;
                    }
                    int i37 = height - 2;
                    int[] iArr2 = new int[i37];
                    bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i37);
                    if (iArr2[0] == -16777216) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (iArr2[i37 - 1] == -16777216) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    int i38 = 0;
                    int i39 = 0;
                    int i46 = 0;
                    while (i38 < i37) {
                        int i47 = iArr2[i38];
                        if (i47 == i28) {
                            i16 = 0;
                        } else {
                            i16 = i47;
                        }
                        if (i16 != -16777216 && i16 != 0) {
                            throw new IllegalArgumentException("Ticks in transparent frame must be black or red. Fount at pixel #" + (i38 + 1) + " along left edge");
                        }
                        if (i46 != i47) {
                            i39++;
                            dataOutputStream.writeInt(Integer.reverseBytes(i38));
                            i46 = iArr2[i38];
                        }
                        i38++;
                        i28 = SupportMenu.CATEGORY_MASK;
                    }
                    if (z19) {
                        i39++;
                        dataOutputStream.writeInt(Integer.reverseBytes(i37));
                    }
                    int i48 = i39 + 1;
                    if (z18) {
                        i48--;
                    }
                    if (z19) {
                        i48--;
                    }
                    int i49 = 0;
                    while (true) {
                        i3 = i36 * i48;
                        if (i49 >= i3) {
                            break;
                        }
                        dataOutputStream.writeInt(16777216);
                        i49++;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArray[0] = 1;
                    byteArray[1] = (byte) i26;
                    byteArray[2] = (byte) i39;
                    byteArray[3] = (byte) i3;
                    int width2 = bitmap.getWidth() - 2;
                    int[] iArr3 = new int[width2];
                    bitmap.getPixels(iArr3, 0, width2, 1, bitmap.getHeight() - 1, width2, 1);
                    int i56 = 0;
                    int i57 = -1;
                    int i58 = -1;
                    for (int i59 = 0; i59 < width2; i59++) {
                        int i65 = iArr3[i59];
                        if (i65 == -65536) {
                            i65 = 0;
                        }
                        if (i65 == -16777216 || i65 == 0) {
                            if (-16777216 == i65 && i65 != i56) {
                                if (i57 == -1) {
                                    i57 = i59;
                                } else {
                                    throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (i59 + 1) + " along bottom edge.");
                                }
                            } else if (i65 == 0 && i65 != i56) {
                                if (i58 == -1) {
                                    i58 = width2 - i59;
                                } else {
                                    throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (i59 + 1) + " along bottom edge.");
                                }
                            }
                            i56 = i65;
                        }
                    }
                    int height2 = bitmap.getHeight() - 2;
                    int[] iArr4 = new int[height2];
                    bitmap.getPixels(iArr4, 0, 1, bitmap.getWidth() - 1, 0, 1, height2);
                    int i66 = 0;
                    int i67 = -1;
                    int i68 = -1;
                    for (int i69 = 0; i69 < height2; i69++) {
                        int i75 = iArr4[i69];
                        if (i75 == -65536) {
                            i75 = 0;
                        }
                        if (i75 == -16777216 || i75 == 0) {
                            if (-16777216 == i75 && i75 != i66) {
                                if (i67 == -1) {
                                    i67 = i69;
                                } else {
                                    throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (i69 + 1) + " along right edge.");
                                }
                            } else if (i75 == 0 && i75 != i66) {
                                if (i68 == -1) {
                                    i68 = height2 - i69;
                                } else {
                                    throw new IllegalArgumentException("Can't have more than one marked region along edge.Found at pixel #" + (i69 + 1) + " along bottom edge.");
                                }
                            }
                            i66 = i75;
                        }
                    }
                    ByteBuffer wrap = ByteBuffer.wrap(byteArray);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    wrap.position(12);
                    wrap.putInt(i57);
                    wrap.putInt(i58);
                    wrap.putInt(i67);
                    wrap.putInt(i68);
                    rect.set(i57, i67, i58, i68);
                    return byteArray;
                }
            }
        } else {
            throw new IllegalArgumentException("not a nine-path bitmap");
        }
    }

    static byte[] makeChunk(Bitmap bitmap) {
        byte[] bArr = sBaseChunk;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        wrap.position(36);
        wrap.putInt(bitmap.getWidth());
        wrap.position(44);
        wrap.putInt(bitmap.getHeight());
        return bArr2;
    }
}
