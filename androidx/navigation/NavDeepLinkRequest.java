package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes.dex */
public class NavDeepLinkRequest {
    private final String mAction;
    private final String mMimeType;
    private final Uri mUri;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String mAction;
        private String mMimeType;
        private Uri mUri;

        Builder() {
        }

        @NonNull
        public static Builder fromAction(@NonNull String str) {
            if (!str.isEmpty()) {
                Builder builder = new Builder();
                builder.setAction(str);
                return builder;
            }
            throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
        }

        @NonNull
        public static Builder fromMimeType(@NonNull String str) {
            Builder builder = new Builder();
            builder.setMimeType(str);
            return builder;
        }

        @NonNull
        public static Builder fromUri(@NonNull Uri uri) {
            Builder builder = new Builder();
            builder.setUri(uri);
            return builder;
        }

        @NonNull
        public NavDeepLinkRequest build() {
            return new NavDeepLinkRequest(this.mUri, this.mAction, this.mMimeType);
        }

        @NonNull
        public Builder setAction(@NonNull String str) {
            if (!str.isEmpty()) {
                this.mAction = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
        }

        @NonNull
        public Builder setMimeType(@NonNull String str) {
            if (Pattern.compile("^[-\\w*.]+/[-\\w+*.]+$").matcher(str).matches()) {
                this.mMimeType = str;
                return this;
            }
            throw new IllegalArgumentException("The given mimeType " + str + " does not match to required \"type/subtype\" format");
        }

        @NonNull
        public Builder setUri(@NonNull Uri uri) {
            this.mUri = uri;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavDeepLinkRequest(@NonNull Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    @Nullable
    public String getAction() {
        return this.mAction;
    }

    @Nullable
    public String getMimeType() {
        return this.mMimeType;
    }

    @Nullable
    public Uri getUri() {
        return this.mUri;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("NavDeepLinkRequest");
        sb5.append("{");
        if (this.mUri != null) {
            sb5.append(" uri=");
            sb5.append(this.mUri.toString());
        }
        if (this.mAction != null) {
            sb5.append(" action=");
            sb5.append(this.mAction);
        }
        if (this.mMimeType != null) {
            sb5.append(" mimetype=");
            sb5.append(this.mMimeType);
        }
        sb5.append(" }");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavDeepLinkRequest(@Nullable Uri uri, @Nullable String str, @Nullable String str2) {
        this.mUri = uri;
        this.mAction = str;
        this.mMimeType = str2;
    }
}
