package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i3, Bundle bundle);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i3, @Nullable Bundle bundle) {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean commitContent;
        ClipDescription description = inputContentInfoCompat.getDescription();
        String[] contentMimeTypes = EditorInfoCompat.getContentMimeTypes(editorInfo);
        int length = contentMimeTypes.length;
        boolean z17 = false;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                if (description.hasMimeType(contentMimeTypes[i16])) {
                    z16 = true;
                    break;
                }
                i16++;
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 25) {
            commitContent = inputConnection.commitContent((InputContentInfo) inputContentInfoCompat.unwrap(), i3, bundle);
            return commitContent;
        }
        int protocol2 = EditorInfoCompat.getProtocol(editorInfo);
        if (protocol2 != 2) {
            if (protocol2 != 3 && protocol2 != 4) {
                return false;
            }
        } else {
            z17 = true;
        }
        Bundle bundle2 = new Bundle();
        if (z17) {
            str = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
        } else {
            str = COMMIT_CONTENT_CONTENT_URI_KEY;
        }
        bundle2.putParcelable(str, inputContentInfoCompat.getContentUri());
        if (z17) {
            str2 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
        } else {
            str2 = COMMIT_CONTENT_DESCRIPTION_KEY;
        }
        bundle2.putParcelable(str2, inputContentInfoCompat.getDescription());
        if (z17) {
            str3 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
        } else {
            str3 = COMMIT_CONTENT_LINK_URI_KEY;
        }
        bundle2.putParcelable(str3, inputContentInfoCompat.getLinkUri());
        if (z17) {
            str4 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
        } else {
            str4 = COMMIT_CONTENT_FLAGS_KEY;
        }
        bundle2.putInt(str4, i3);
        if (z17) {
            str5 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
        } else {
            str5 = COMMIT_CONTENT_OPTS_KEY;
        }
        bundle2.putParcelable(str5, bundle);
        if (z17) {
            str6 = COMMIT_CONTENT_INTEROP_ACTION;
        } else {
            str6 = COMMIT_CONTENT_ACTION;
        }
        return inputConnection.performPrivateCommand(str6, bundle2);
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull final OnCommitContentListener onCommitContentListener) {
        if (inputConnection != null) {
            if (editorInfo != null) {
                if (onCommitContentListener != null) {
                    boolean z16 = false;
                    if (Build.VERSION.SDK_INT >= 25) {
                        return new InputConnectionWrapper(inputConnection, z16) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.1
                            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                            public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
                                if (onCommitContentListener.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i3, bundle)) {
                                    return true;
                                }
                                return super.commitContent(inputContentInfo, i3, bundle);
                            }
                        };
                    }
                    if (EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0) {
                        return inputConnection;
                    }
                    return new InputConnectionWrapper(inputConnection, z16) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.2
                        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                        public boolean performPrivateCommand(String str, Bundle bundle) {
                            if (InputConnectionCompat.handlePerformPrivateCommand(str, bundle, onCommitContentListener)) {
                                return true;
                            }
                            return super.performPrivateCommand(str, bundle);
                        }
                    };
                }
                throw new IllegalArgumentException("onCommitContentListener must be non-null");
            }
            throw new IllegalArgumentException("editorInfo must be non-null");
        }
        throw new IllegalArgumentException("inputConnection must be non-null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean handlePerformPrivateCommand(@Nullable String str, @NonNull Bundle bundle, @NonNull OnCommitContentListener onCommitContentListener) {
        boolean z16;
        String str2;
        ResultReceiver resultReceiver;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ?? r06 = 0;
        r06 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, str)) {
            z16 = false;
        } else {
            if (!TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, str)) {
                return false;
            }
            z16 = true;
        }
        if (z16) {
            str2 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
        } else {
            str2 = COMMIT_CONTENT_RESULT_RECEIVER_KEY;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(str2);
            if (z16) {
                str3 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
            } else {
                str3 = COMMIT_CONTENT_CONTENT_URI_KEY;
            }
        } catch (Throwable th5) {
            th = th5;
            resultReceiver = 0;
        }
        try {
            Uri uri = (Uri) bundle.getParcelable(str3);
            if (z16) {
                str4 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
            } else {
                str4 = COMMIT_CONTENT_DESCRIPTION_KEY;
            }
            ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(str4);
            if (z16) {
                str5 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
            } else {
                str5 = COMMIT_CONTENT_LINK_URI_KEY;
            }
            Uri uri2 = (Uri) bundle.getParcelable(str5);
            if (z16) {
                str6 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
            } else {
                str6 = COMMIT_CONTENT_FLAGS_KEY;
            }
            int i3 = bundle.getInt(str6);
            if (z16) {
                str7 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
            } else {
                str7 = COMMIT_CONTENT_OPTS_KEY;
            }
            Bundle bundle2 = (Bundle) bundle.getParcelable(str7);
            if (uri != null && clipDescription != null) {
                r06 = onCommitContentListener.onCommitContent(new InputContentInfoCompat(uri, clipDescription, uri2), i3, bundle2);
            }
            if (resultReceiver != 0) {
                resultReceiver.send(r06, null);
            }
            return r06;
        } catch (Throwable th6) {
            th = th6;
            if (resultReceiver != 0) {
                resultReceiver.send(0, null);
            }
            throw th;
        }
    }
}
