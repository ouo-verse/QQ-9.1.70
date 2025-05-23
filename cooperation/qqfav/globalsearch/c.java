package cooperation.qqfav.globalsearch;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import qn2.f;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c extends f {

    /* renamed from: e, reason: collision with root package name */
    private BitmapFactory.Options f390640e;

    public c(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
        this.f390640e = new BitmapFactory.Options();
    }

    private boolean n(b bVar) {
        if ((bVar != null && 5 == bVar.U) || bVar.V) {
            return true;
        }
        return false;
    }

    @Override // qn2.f, qn2.c
    /* renamed from: i */
    public void c(y yVar, sn2.c cVar) {
        cVar.b().setMaxWidth(800);
        b bVar = (b) yVar;
        ImageView f16 = cVar.f();
        f16.setScaleType(ImageView.ScaleType.CENTER_CROP);
        BitmapDrawable bitmapDrawable = null;
        if (n(bVar) && 6 != bVar.U) {
            f16.setImageResource(R.drawable.qfav_list_music_play);
        } else {
            f16.setImageDrawable(null);
            f16.setBackgroundDrawable(null);
        }
        if (bVar.Q != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = cVar.f().getHeight();
            obtain.mRequestWidth = cVar.f().getWidth();
            if (n(bVar)) {
                f16.setBackgroundDrawable(URLDrawable.getDrawable(bVar.Q, obtain));
                return;
            }
            try {
                f16.setImageDrawable(URLDrawable.getDrawable(bVar.Q, obtain));
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + e16.toString());
                    return;
                }
                return;
            }
        }
        if (bVar.R != 0) {
            if (n(bVar)) {
                f16.setBackgroundResource(bVar.R);
                return;
            } else {
                f16.setImageResource(bVar.R);
                return;
            }
        }
        byte[] bArr = bVar.S;
        if (bArr != null) {
            BitmapFactory.Options options = this.f390640e;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            BitmapFactory.Options options2 = this.f390640e;
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = options2.outWidth / cVar.f().getMeasuredWidth();
            try {
                byte[] bArr2 = bVar.S;
                bitmapDrawable = new BitmapDrawable((Resources) null, BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, this.f390640e));
            } catch (OutOfMemoryError unused) {
            }
            if (n(bVar)) {
                f16.setBackgroundDrawable(bitmapDrawable);
                return;
            } else {
                f16.setImageDrawable(bitmapDrawable);
                return;
            }
        }
        super.c(yVar, cVar);
    }
}
