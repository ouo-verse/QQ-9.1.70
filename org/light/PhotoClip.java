package org.light;

import android.os.Bundle;
import android.os.Parcel;
import org.light.shared.SharedBytes;
import org.light.shared.SharedTexture;

/* loaded from: classes29.dex */
public class PhotoClip extends ClipAsset {
    private static final String KEY_sharedBytes = "sharedBytes";
    private static final String KEY_sharedTexture = "sharedTexture";
    private Bundle bundle;
    public byte[] bytes;
    public int height;
    public String photoEffectPath;
    private SharedBytes sharedBytes;
    private SharedTexture sharedTexture;
    public int texId;
    public int width;

    public PhotoClip() {
        this.photoEffectPath = "";
        this.texId = -1;
        this.width = 0;
        this.height = 0;
        this.bundle = null;
        this.sharedBytes = null;
        this.sharedTexture = null;
        this.type = ClipAsset.PHOTO;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        SharedBytes sharedBytes = this.sharedBytes;
        if (sharedBytes != null) {
            sharedBytes.release();
            this.sharedBytes = null;
        }
        SharedTexture sharedTexture = this.sharedTexture;
        if (sharedTexture != null) {
            sharedTexture.release();
            this.sharedTexture = null;
        }
    }

    protected PhotoClip(Parcel parcel) {
        super(parcel);
        this.photoEffectPath = "";
        this.texId = -1;
        this.width = 0;
        this.height = 0;
        this.bundle = null;
        this.sharedBytes = null;
        this.sharedTexture = null;
        this.photoEffectPath = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        this.bundle = readBundle;
        if (readBundle != null) {
            SharedBytes sharedBytes = (SharedBytes) readBundle.getParcelable(KEY_sharedBytes);
            this.sharedBytes = sharedBytes;
            if (sharedBytes != null) {
                this.bytes = sharedBytes.getBytes();
            }
            SharedTexture sharedTexture = (SharedTexture) this.bundle.getParcelable(KEY_sharedTexture);
            this.sharedTexture = sharedTexture;
            if (sharedTexture != null) {
                this.texId = sharedTexture.getTexture();
            }
        }
    }
}
