package com.tencent.mtt.hippy.adapter.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyDrawable implements IDrawableTarget {
    private String imageType;
    private Bitmap mBitmap;
    protected Drawable mDrawable;
    private Movie mGifMovie;
    protected String mSource;

    @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
    public Object getExtraData() {
        return null;
    }

    public Movie getGIF() {
        return this.mGifMovie;
    }

    public int getHeight() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        Movie movie = this.mGifMovie;
        if (movie != null) {
            return movie.height();
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
    public String getImageType() {
        return this.imageType;
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
    public String getSource() {
        return this.mSource;
    }

    public int getWidth() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        Movie movie = this.mGifMovie;
        if (movie != null) {
            return movie.width();
        }
        return 0;
    }

    public boolean isAnimated() {
        if (this.mGifMovie != null) {
            return true;
        }
        return false;
    }

    public void setData(Bitmap bitmap) {
        this.mBitmap = bitmap;
        this.mGifMovie = null;
    }

    public boolean setDataForTarge28Assets(String str) {
        ImageDecoder.Source createSource;
        Bitmap decodeBitmap;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                createSource = ImageDecoder.createSource(ContextHolder.getAppContext().getAssets(), str.substring(9));
                decodeBitmap = ImageDecoder.decodeBitmap(createSource);
                this.mBitmap = decodeBitmap;
                return true;
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public void setDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void setImageType(String str) {
        this.imageType = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002f A[Catch: Exception -> 0x0033, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0033, blocks: (B:9:0x0019, B:22:0x002f), top: B:2:0x0001 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0034 -> B:10:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(File file, boolean z16) {
        FileInputStream fileInputStream = null;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    if (z16) {
                        this.mGifMovie = Movie.decodeStream(fileInputStream2);
                        this.mBitmap = null;
                    } else {
                        this.mBitmap = BitmapFactory.decodeStream(fileInputStream2);
                        this.mGifMovie = null;
                    }
                    fileInputStream2.close();
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            } catch (OutOfMemoryError e27) {
                e = e27;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public boolean setData(File file) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    LogUtils.d("HippyDrawable", "setData path: read total=" + fileInputStream2.read(bArr));
                    boolean data = setData(bArr);
                    try {
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    return data;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream == null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    public boolean setData(String str) {
        this.mSource = str;
        if (str.startsWith("data:")) {
            try {
                int indexOf = this.mSource.indexOf(";base64,");
                if (indexOf >= 0) {
                    byte[] decode = Base64.decode(this.mSource.substring(indexOf + 8), 0);
                    if (decode != null) {
                        return setData(decode);
                    }
                }
                return false;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        }
        if (this.mSource.startsWith("file://")) {
            return setData(new File(this.mSource.substring(7)));
        }
        if (!this.mSource.startsWith("assets://")) {
            return false;
        }
        InputStream inputStream = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    return setDataForTarge28Assets(this.mSource);
                }
                InputStream open = ContextHolder.getAppContext().getAssets().open(this.mSource.substring(9));
                byte[] bArr = new byte[open.available()];
                LogUtils.d("HippyDrawable", "setData source: read total=" + open.read(bArr));
                boolean data = setData(bArr);
                try {
                    open.close();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                return data;
            } catch (Exception e18) {
                e18.printStackTrace();
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public boolean setData(byte[] bArr) {
        try {
            Movie decodeByteArray = Movie.decodeByteArray(bArr, 0, bArr.length);
            this.mGifMovie = decodeByteArray;
            if (decodeByteArray == null) {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                return true;
            }
            this.mBitmap = null;
            return true;
        } catch (Exception | OutOfMemoryError e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
    public void onDrawableAttached() {
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
    public void onDrawableDetached() {
    }
}
