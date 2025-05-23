package a0;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import java.io.ByteArrayOutputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f25292a;

    /* renamed from: b, reason: collision with root package name */
    private final int f25293b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // a0.e
    @Nullable
    public q<byte[]> a(@NonNull q<Bitmap> qVar, @NonNull com.bumptech.glide.load.e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        qVar.get().compress(this.f25292a, this.f25293b, byteArrayOutputStream);
        qVar.recycle();
        return new w.b(byteArrayOutputStream.toByteArray());
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i3) {
        this.f25292a = compressFormat;
        this.f25293b = i3;
    }
}
