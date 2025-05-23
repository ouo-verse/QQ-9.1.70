package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface AudioAttributesImpl extends VersionedParcelable {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Builder {
        @NonNull
        AudioAttributesImpl build();

        @NonNull
        Builder setContentType(int i3);

        @NonNull
        Builder setFlags(int i3);

        @NonNull
        Builder setLegacyStreamType(int i3);

        @NonNull
        Builder setUsage(int i3);
    }

    @Nullable
    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();
}
