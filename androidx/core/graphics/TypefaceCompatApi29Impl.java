package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
@RequiresApi(29)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i3) {
        int i16;
        FontFamily build;
        Typeface.CustomFallbackBuilder style;
        Typeface build2;
        Font.Builder weight;
        Font.Builder slant;
        Font.Builder ttcIndex;
        Font.Builder fontVariationSettings;
        Font build3;
        try {
            FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
            int length = entries.length;
            int i17 = 0;
            FontFamily.Builder builder = null;
            int i18 = 0;
            while (true) {
                int i19 = 1;
                if (i18 >= length) {
                    break;
                }
                FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i18];
                try {
                    weight = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight());
                    if (!fontFileResourceEntry.isItalic()) {
                        i19 = 0;
                    }
                    slant = weight.setSlant(i19);
                    ttcIndex = slant.setTtcIndex(fontFileResourceEntry.getTtcIndex());
                    fontVariationSettings = ttcIndex.setFontVariationSettings(fontFileResourceEntry.getVariationSettings());
                    build3 = fontVariationSettings.build();
                    if (builder != null) {
                        builder.addFont(build3);
                    } else {
                        builder = new FontFamily.Builder(build3);
                    }
                } catch (IOException unused) {
                }
                i18++;
            }
            if (builder == null) {
                return null;
            }
            if ((i3 & 1) != 0) {
                i16 = 700;
            } else {
                i16 = 400;
            }
            if ((i3 & 2) != 0) {
                i17 = 1;
            }
            FontStyle fontStyle = new FontStyle(i16, i17);
            build = builder.build();
            style = new Typeface.CustomFallbackBuilder(build).setStyle(fontStyle);
            build2 = style.build();
            return build2;
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        int i16;
        FontFamily build;
        Typeface.CustomFallbackBuilder style;
        Typeface build2;
        ParcelFileDescriptor openFileDescriptor;
        Font.Builder weight;
        Font.Builder slant;
        Font.Builder ttcIndex;
        Font build3;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = fontInfoArr.length;
            int i17 = 0;
            FontFamily.Builder builder = null;
            int i18 = 0;
            while (true) {
                int i19 = 1;
                if (i18 < length) {
                    FontsContractCompat.FontInfo fontInfo = fontInfoArr[i18];
                    try {
                        openFileDescriptor = contentResolver.openFileDescriptor(fontInfo.getUri(), "r", cancellationSignal);
                    } catch (IOException unused) {
                    }
                    if (openFileDescriptor != null) {
                        try {
                            weight = new Font.Builder(openFileDescriptor).setWeight(fontInfo.getWeight());
                            if (!fontInfo.isItalic()) {
                                i19 = 0;
                            }
                            slant = weight.setSlant(i19);
                            ttcIndex = slant.setTtcIndex(fontInfo.getTtcIndex());
                            build3 = ttcIndex.build();
                            if (builder != null) {
                                builder.addFont(build3);
                            } else {
                                builder = new FontFamily.Builder(build3);
                            }
                        } catch (Throwable th5) {
                            try {
                                openFileDescriptor.close();
                            } catch (Throwable th6) {
                                th5.addSuppressed(th6);
                            }
                            throw th5;
                            break;
                        }
                    } else if (openFileDescriptor == null) {
                        i18++;
                    }
                    openFileDescriptor.close();
                    i18++;
                } else {
                    if (builder == null) {
                        return null;
                    }
                    if ((i3 & 1) != 0) {
                        i16 = 700;
                    } else {
                        i16 = 400;
                    }
                    if ((i3 & 2) != 0) {
                        i17 = 1;
                    }
                    FontStyle fontStyle = new FontStyle(i16, i17);
                    build = builder.build();
                    style = new Typeface.CustomFallbackBuilder(build).setStyle(fontStyle);
                    build2 = style.build();
                    return build2;
                }
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i3, String str, int i16) {
        Font build;
        FontFamily build2;
        FontStyle style;
        Typeface.CustomFallbackBuilder style2;
        Typeface build3;
        try {
            build = new Font.Builder(resources, i3).build();
            build2 = new FontFamily.Builder(build).build();
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(build2);
            style = build.getStyle();
            style2 = customFallbackBuilder.setStyle(style);
            build3 = style2.build();
            return build3;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
