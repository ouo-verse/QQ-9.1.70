package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod;

    public SVGImageView(Context context) {
        super(context);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    private void init(AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i3, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                if (internalSetImageURI(Uri.parse(string), false)) {
                } else {
                    setImageAsset(string);
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private boolean internalSetImageURI(Uri uri, boolean z16) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = getContext().getContentResolver().openInputStream(uri);
                SVG fromInputStream = SVG.getFromInputStream(inputStream);
                setSoftwareLayerType();
                setImageDrawable(new PictureDrawable(fromInputStream.renderToPicture()));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return true;
                    } catch (IOException unused) {
                        return true;
                    }
                }
                return true;
            } catch (SVGParseException e16) {
                Log.e("SVGImageView", "Error loading file " + uri + MsgSummary.STR_COLON + e16.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return false;
            } catch (FileNotFoundException unused3) {
                if (z16) {
                    Log.e("SVGImageView", "File not found: " + uri);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th5;
        }
    }

    private void setSoftwareLayerType() {
        if (setLayerTypeMethod == null) {
            return;
        }
        try {
            setLayerTypeMethod.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e16) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e16);
        }
    }

    public void setImageAsset(String str) {
        try {
            SVG fromAsset = SVG.getFromAsset(getContext().getAssets(), str);
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(fromAsset.renderToPicture()));
        } catch (SVGParseException e16) {
            Log.e("SVGImageView", "Error loading file " + str + MsgSummary.STR_COLON + e16.getMessage());
        } catch (FileNotFoundException unused) {
            Log.e("SVGImageView", "File not found: " + str);
        } catch (IOException e17) {
            Log.e("SVGImageView", "Unable to load asset file: " + str, e17);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        try {
            SVG fromResource = SVG.getFromResource(getContext(), i3);
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(fromResource.renderToPicture()));
        } catch (SVGParseException e16) {
            Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(i3), e16.getMessage()));
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        internalSetImageURI(uri, true);
    }

    public void setSVG(SVG svg) {
        if (svg != null) {
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(svg.renderToPicture()));
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        init(attributeSet, 0);
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        init(attributeSet, i3);
    }
}
