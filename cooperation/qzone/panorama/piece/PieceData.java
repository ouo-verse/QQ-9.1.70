package cooperation.qzone.panorama.piece;

import android.graphics.Bitmap;
import cooperation.qzone.panorama.util.TextureUtil;

/* loaded from: classes28.dex */
public class PieceData {
    private Bitmap orgBitmap;
    private int pieceIndex;
    private int textureOrgObjectId = -1;

    public Bitmap getOrgBitmap() {
        return this.orgBitmap;
    }

    public int getPieceIndex() {
        return this.pieceIndex;
    }

    public int getTextureOrgObjectId() {
        return this.textureOrgObjectId;
    }

    public void notifyTextureChange() {
        Bitmap bitmap = this.orgBitmap;
        if (bitmap != null && this.textureOrgObjectId <= 0) {
            this.textureOrgObjectId = TextureUtil.genTextureId(bitmap, true);
        }
    }

    public void recycleOrgTexture() {
        Bitmap bitmap = this.orgBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.orgBitmap = null;
        }
        TextureUtil.deleteTexture(this.textureOrgObjectId);
        this.textureOrgObjectId = -1;
    }

    public void setOrgBitmap(Bitmap bitmap) {
        this.orgBitmap = bitmap;
    }

    public void setPieceIndex(int i3) {
        this.pieceIndex = i3;
    }

    public int sizeOf() {
        Bitmap bitmap = this.orgBitmap;
        if (bitmap != null) {
            return bitmap.getByteCount();
        }
        return 0;
    }
}
