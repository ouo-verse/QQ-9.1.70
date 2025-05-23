package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.data.e;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private final InternalRewinder f31566a;

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class InternalRewinder {

        /* renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f31567a;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f31567a = parcelFileDescriptor;
        }

        ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.f31567a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f31567a;
            } catch (ErrnoException e16) {
                throw new IOException(e16);
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e<ParcelFileDescriptor> build(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    @RequiresApi(21)
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f31566a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean b() {
        return true;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    @RequiresApi(21)
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor a() throws IOException {
        return this.f31566a.rewind();
    }

    @Override // com.bumptech.glide.load.data.e
    public void cleanup() {
    }
}
