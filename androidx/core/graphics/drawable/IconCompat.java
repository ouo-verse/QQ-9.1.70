package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;

    @VisibleForTesting
    static final String EXTRA_INT1 = "int1";

    @VisibleForTesting
    static final String EXTRA_INT2 = "int2";

    @VisibleForTesting
    static final String EXTRA_OBJ = "obj";

    @VisibleForTesting
    static final String EXTRA_STRING1 = "string1";

    @VisibleForTesting
    static final String EXTRA_TINT_LIST = "tint_list";

    @VisibleForTesting
    static final String EXTRA_TINT_MODE = "tint_mode";

    @VisibleForTesting
    static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] mData;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt2;
    Object mObj1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable mParcelable;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mString1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList mTintList;
    PorterDuff.Mode mTintMode;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mTintModeStr;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mType;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface IconType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    @Nullable
    public static IconCompat createFromBundle(@NonNull Bundle bundle) {
        int i3 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i3);
        iconCompat.mInt1 = bundle.getInt(EXTRA_INT1);
        iconCompat.mInt2 = bundle.getInt(EXTRA_INT2);
        iconCompat.mString1 = bundle.getString(EXTRA_STRING1);
        if (bundle.containsKey(EXTRA_TINT_LIST)) {
            iconCompat.mTintList = (ColorStateList) bundle.getParcelable(EXTRA_TINT_LIST);
        }
        if (bundle.containsKey(EXTRA_TINT_MODE)) {
            iconCompat.mTintMode = PorterDuff.Mode.valueOf(bundle.getString(EXTRA_TINT_MODE));
        }
        switch (i3) {
            case -1:
            case 1:
            case 5:
                iconCompat.mObj1 = bundle.getParcelable(EXTRA_OBJ);
                return iconCompat;
            case 0:
            default:
                Log.w(TAG, "Unknown type " + i3);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.mObj1 = bundle.getString(EXTRA_OBJ);
                return iconCompat;
            case 3:
                iconCompat.mObj1 = bundle.getByteArray(EXTRA_OBJ);
                return iconCompat;
        }
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat createFromIcon(@NonNull Context context, @NonNull Icon icon) {
        Preconditions.checkNotNull(icon);
        int type = getType(icon);
        if (type == 2) {
            String resPackage = getResPackage(icon);
            try {
                return createWithResource(getResources(context, resPackage), resPackage, getResId(icon));
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        }
        if (type == 4) {
            return createWithContentUri(getUri(icon));
        }
        if (type != 6) {
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.mObj1 = icon;
            return iconCompat;
        }
        return createWithAdaptiveBitmapContentUri(getUri(icon));
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon icon) {
        if (getType(icon) == 2 && getResId(icon) == 0) {
            return null;
        }
        return createFromIcon(icon);
    }

    @VisibleForTesting
    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z16) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f16 = min;
        float f17 = 0.5f * f16;
        float f18 = ICON_DIAMETER_FACTOR * f17;
        if (z16) {
            float f19 = BLUR_FACTOR * f16;
            paint.setColor(0);
            paint.setShadowLayer(f19, 0.0f, f16 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
            canvas.drawCircle(f17, f17, f18, paint);
            paint.setShadowLayer(f19, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f17, f17, f18, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f17, f17, f18, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(5);
            iconCompat.mObj1 = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(6);
            iconCompat.mObj1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.mObj1 = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat createWithContentUri(String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.mObj1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithData(byte[] bArr, int i3, int i16) {
        if (bArr != null) {
            IconCompat iconCompat = new IconCompat(3);
            iconCompat.mObj1 = bArr;
            iconCompat.mInt1 = i3;
            iconCompat.mInt2 = i16;
            return iconCompat;
        }
        throw new IllegalArgumentException("Data must not be null.");
    }

    public static IconCompat createWithResource(Context context, @DrawableRes int i3) {
        if (context != null) {
            return createWithResource(context.getResources(), context.getPackageName(), i3);
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    private static Resources getResources(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo == null) {
                return null;
            }
            return packageManager.getResourcesForApplication(applicationInfo);
        } catch (PackageManager.NameNotFoundException e16) {
            Log.e(TAG, String.format("Unable to find pkg=%s for icon", str), e16);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Drawable loadDrawableInner(Context context) {
        switch (this.mType) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.mObj1);
            case 2:
                String resPackage = getResPackage();
                if (TextUtils.isEmpty(resPackage)) {
                    resPackage = context.getPackageName();
                }
                try {
                    return ResourcesCompat.getDrawable(getResources(context, resPackage), this.mInt1, context.getTheme());
                } catch (RuntimeException e16) {
                    Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.mInt1), this.mObj1), e16);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
            case 4:
                InputStream uriInputStream = getUriInputStream(context);
                if (uriInputStream != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream));
                }
                return null;
            case 5:
                return new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
            case 6:
                InputStream uriInputStream2 = getUriInputStream(context);
                if (uriInputStream2 != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return new AdaptiveIconDrawable(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream2)));
                    }
                    return new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(uriInputStream2), false));
                }
                return null;
            default:
                return null;
        }
    }

    private static String typeToString(int i3) {
        switch (i3) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addToShortcutIntent(@NonNull Intent intent, @Nullable Drawable drawable, @NonNull Context context) {
        Bitmap bitmap;
        checkResource(context);
        int i3 = this.mType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 5) {
                    bitmap = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
                } else {
                    throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
                }
            } else {
                try {
                    Context createPackageContext = context.createPackageContext(getResPackage(), 0);
                    if (drawable == null) {
                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(createPackageContext, this.mInt1));
                        return;
                    }
                    Drawable drawable2 = ContextCompat.getDrawable(createPackageContext, this.mInt1);
                    if (drawable2.getIntrinsicWidth() > 0 && drawable2.getIntrinsicHeight() > 0) {
                        bitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                        drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        drawable2.draw(new Canvas(bitmap));
                    }
                    int launcherLargeIconSize = ((ActivityManager) createPackageContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getLauncherLargeIconSize();
                    bitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                    drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    drawable2.draw(new Canvas(bitmap));
                } catch (PackageManager.NameNotFoundException e16) {
                    throw new IllegalArgumentException("Can't find package " + this.mObj1, e16);
                }
            }
        } else {
            bitmap = (Bitmap) this.mObj1;
            if (drawable != null) {
                bitmap = bitmap.copy(bitmap.getConfig(), true);
            }
        }
        if (drawable != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmap));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@NonNull Context context) {
        Object obj;
        if (this.mType == 2 && (obj = this.mObj1) != null) {
            String str = (String) obj;
            if (!str.contains(":")) {
                return;
            }
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                Log.i(TAG, "Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            String resPackage = getResPackage();
            int identifier = getResources(context, resPackage).getIdentifier(str4, str3, str5);
            if (this.mInt1 != identifier) {
                Log.i(TAG, "Id has changed for " + resPackage + " " + str);
                this.mInt1 = identifier;
            }
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap getBitmap() {
        int i3 = this.mType;
        if (i3 == -1) {
            Object obj = this.mObj1;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i3 == 1) {
            return (Bitmap) this.mObj1;
        }
        if (i3 == 5) {
            return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    @IdRes
    public int getResId() {
        int i3 = this.mType;
        if (i3 == -1) {
            return getResId((Icon) this.mObj1);
        }
        if (i3 == 2) {
            return this.mInt1;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String getResPackage() {
        int i3 = this.mType;
        if (i3 == -1) {
            return getResPackage((Icon) this.mObj1);
        }
        if (i3 == 2) {
            if (TextUtils.isEmpty(this.mString1)) {
                return ((String) this.mObj1).split(":", -1)[0];
            }
            return this.mString1;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int i3 = this.mType;
        return i3 == -1 ? getType((Icon) this.mObj1) : i3;
    }

    @NonNull
    public Uri getUri() {
        int i3 = this.mType;
        if (i3 == -1) {
            return getUri((Icon) this.mObj1);
        }
        if (i3 != 4 && i3 != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.mObj1);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream getUriInputStream(@NonNull Context context) {
        Uri uri = getUri();
        String scheme = uri.getScheme();
        if (!"content".equals(scheme) && !"file".equals(scheme)) {
            try {
                return new FileInputStream(new File((String) this.mObj1));
            } catch (FileNotFoundException e16) {
                Log.w(TAG, "Unable to load image from path: " + uri, e16);
                return null;
            }
        }
        try {
            return context.getContentResolver().openInputStream(uri);
        } catch (Exception e17) {
            Log.w(TAG, "Unable to load image from URI: " + uri, e17);
            return null;
        }
    }

    @Nullable
    public Drawable loadDrawable(@NonNull Context context) {
        checkResource(context);
        return toIcon(context).loadDrawable(context);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch (this.mType) {
            case -1:
                Parcelable parcelable = this.mParcelable;
                if (parcelable != null) {
                    this.mObj1 = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.mParcelable;
                if (parcelable2 != null) {
                    this.mObj1 = parcelable2;
                    return;
                }
                byte[] bArr = this.mData;
                this.mObj1 = bArr;
                this.mType = 3;
                this.mInt1 = 0;
                this.mInt2 = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.mData, Charset.forName("UTF-16"));
                this.mObj1 = str;
                if (this.mType == 2 && this.mString1 == null) {
                    this.mString1 = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.mObj1 = this.mData;
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z16) {
        this.mTintModeStr = this.mTintMode.name();
        switch (this.mType) {
            case -1:
                if (!z16) {
                    this.mParcelable = (Parcelable) this.mObj1;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z16) {
                    Bitmap bitmap = (Bitmap) this.mObj1;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.mData = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.mParcelable = (Parcelable) this.mObj1;
                return;
            case 2:
                this.mData = ((String) this.mObj1).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.mData = (byte[]) this.mObj1;
                return;
            case 4:
            case 6:
                this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public IconCompat setTint(@ColorInt int i3) {
        return setTintList(ColorStateList.valueOf(i3));
    }

    public IconCompat setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        switch (this.mType) {
            case -1:
                bundle.putParcelable(EXTRA_OBJ, (Parcelable) this.mObj1);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable(EXTRA_OBJ, (Bitmap) this.mObj1);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString(EXTRA_OBJ, (String) this.mObj1);
                break;
            case 3:
                bundle.putByteArray(EXTRA_OBJ, (byte[]) this.mObj1);
                break;
        }
        bundle.putInt("type", this.mType);
        bundle.putInt(EXTRA_INT1, this.mInt1);
        bundle.putInt(EXTRA_INT2, this.mInt2);
        bundle.putString(EXTRA_STRING1, this.mString1);
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            bundle.putParcelable(EXTRA_TINT_LIST, colorStateList);
        }
        PorterDuff.Mode mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            bundle.putString(EXTRA_TINT_MODE, mode.name());
        }
        return bundle;
    }

    @NonNull
    @RequiresApi(23)
    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    @NonNull
    public String toString() {
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder sb5 = new StringBuilder("Icon(typ=");
        sb5.append(typeToString(this.mType));
        switch (this.mType) {
            case 1:
            case 5:
                sb5.append(" size=");
                sb5.append(((Bitmap) this.mObj1).getWidth());
                sb5.append(HippyTKDListViewAdapter.X);
                sb5.append(((Bitmap) this.mObj1).getHeight());
                break;
            case 2:
                sb5.append(" pkg=");
                sb5.append(this.mString1);
                sb5.append(" id=");
                sb5.append(String.format("0x%08x", Integer.valueOf(getResId())));
                break;
            case 3:
                sb5.append(" len=");
                sb5.append(this.mInt1);
                if (this.mInt2 != 0) {
                    sb5.append(" off=");
                    sb5.append(this.mInt2);
                    break;
                }
                break;
            case 4:
            case 6:
                sb5.append(" uri=");
                sb5.append(this.mObj1);
                break;
        }
        if (this.mTintList != null) {
            sb5.append(" tint=");
            sb5.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            sb5.append(" mode=");
            sb5.append(this.mTintMode);
        }
        sb5.append(")");
        return sb5.toString();
    }

    @NonNull
    @RequiresApi(23)
    public Icon toIcon(@Nullable Context context) {
        Icon createWithBitmap;
        switch (this.mType) {
            case -1:
                return (Icon) this.mObj1;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.mObj1);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(getResPackage(), this.mInt1);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.mObj1);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.mObj1);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
                    break;
                }
            case 6:
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 30) {
                    createWithBitmap = Icon.createWithAdaptiveBitmapContentUri(getUri());
                    break;
                } else if (context != null) {
                    InputStream uriInputStream = getUriInputStream(context);
                    if (uriInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + getUri());
                    }
                    if (i3 >= 26) {
                        createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(uriInputStream));
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(uriInputStream), false));
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + getUri());
                }
        }
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createWithResource(Resources resources, String str, @DrawableRes int i3) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i3 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.mInt1 = i3;
            if (resources != null) {
                try {
                    iconCompat.mObj1 = resources.getResourceName(i3);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.mObj1 = str;
            }
            iconCompat.mString1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    @RequiresApi(23)
    private static int getType(@NonNull Icon icon) {
        int type;
        if (Build.VERSION.SDK_INT >= 28) {
            type = icon.getType();
            return type;
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e16) {
            Log.e(TAG, "Unable to get icon type " + icon, e16);
            return -1;
        } catch (NoSuchMethodException e17) {
            Log.e(TAG, "Unable to get icon type " + icon, e17);
            return -1;
        } catch (InvocationTargetException e18) {
            Log.e(TAG, "Unable to get icon type " + icon, e18);
            return -1;
        }
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull Uri uri) {
        if (uri != null) {
            return createWithAdaptiveBitmapContentUri(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithContentUri(Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    @DrawableRes
    @IdRes
    @RequiresApi(23)
    private static int getResId(@NonNull Icon icon) {
        int resId;
        if (Build.VERSION.SDK_INT >= 28) {
            resId = icon.getResId();
            return resId;
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e16) {
            Log.e(TAG, "Unable to get icon resource", e16);
            return 0;
        } catch (NoSuchMethodException e17) {
            Log.e(TAG, "Unable to get icon resource", e17);
            return 0;
        } catch (InvocationTargetException e18) {
            Log.e(TAG, "Unable to get icon resource", e18);
            return 0;
        }
    }

    @Nullable
    @RequiresApi(23)
    private static Uri getUri(@NonNull Icon icon) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 28) {
            uri = icon.getUri();
            return uri;
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e16) {
            Log.e(TAG, "Unable to get icon uri", e16);
            return null;
        } catch (NoSuchMethodException e17) {
            Log.e(TAG, "Unable to get icon uri", e17);
            return null;
        } catch (InvocationTargetException e18) {
            Log.e(TAG, "Unable to get icon uri", e18);
            return null;
        }
    }

    @Nullable
    @RequiresApi(23)
    private static String getResPackage(@NonNull Icon icon) {
        String resPackage;
        if (Build.VERSION.SDK_INT >= 28) {
            resPackage = icon.getResPackage();
            return resPackage;
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e16) {
            Log.e(TAG, "Unable to get icon package", e16);
            return null;
        } catch (NoSuchMethodException e17) {
            Log.e(TAG, "Unable to get icon package", e17);
            return null;
        } catch (InvocationTargetException e18) {
            Log.e(TAG, "Unable to get icon package", e18);
            return null;
        }
    }

    IconCompat(int i3) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = i3;
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIcon(@NonNull Icon icon) {
        Preconditions.checkNotNull(icon);
        int type = getType(icon);
        if (type == 2) {
            return createWithResource(null, getResPackage(icon), getResId(icon));
        }
        if (type == 4) {
            return createWithContentUri(getUri(icon));
        }
        if (type != 6) {
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.mObj1 = icon;
            return iconCompat;
        }
        return createWithAdaptiveBitmapContentUri(getUri(icon));
    }
}
