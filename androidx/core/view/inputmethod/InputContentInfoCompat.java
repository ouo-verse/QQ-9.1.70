package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InputContentInfoCompat {
    private final InputContentInfoCompatImpl mImpl;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private interface InputContentInfoCompatImpl {
        @NonNull
        Uri getContentUri();

        @NonNull
        ClipDescription getDescription();

        @Nullable
        Object getInputContentInfo();

        @Nullable
        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.mImpl = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.mImpl = new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
    }

    @NonNull
    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }

    /* compiled from: P */
    @RequiresApi(25)
    /* loaded from: classes.dex */
    private static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {

        @NonNull
        final InputContentInfo mObject;

        InputContentInfoCompatApi25Impl(@NonNull Object obj) {
            this.mObject = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public Uri getContentUri() {
            Uri contentUri;
            contentUri = this.mObject.getContentUri();
            return contentUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public ClipDescription getDescription() {
            ClipDescription description;
            description = this.mObject.getDescription();
            return description;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @Nullable
        public Object getInputContentInfo() {
            return this.mObject;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @Nullable
        public Uri getLinkUri() {
            Uri linkUri;
            linkUri = this.mObject.getLinkUri();
            return linkUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
            this.mObject.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
            this.mObject.requestPermission();
        }

        InputContentInfoCompatApi25Impl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.mObject = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    InputContentInfoCompat(@NonNull InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompatImpl;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {

        @NonNull
        private final Uri mContentUri;

        @NonNull
        private final ClipDescription mDescription;

        @Nullable
        private final Uri mLinkUri;

        InputContentInfoCompatBaseImpl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.mContentUri = uri;
            this.mDescription = clipDescription;
            this.mLinkUri = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public Uri getContentUri() {
            return this.mContentUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public ClipDescription getDescription() {
            return this.mDescription;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @Nullable
        public Object getInputContentInfo() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @Nullable
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
        }
    }
}
