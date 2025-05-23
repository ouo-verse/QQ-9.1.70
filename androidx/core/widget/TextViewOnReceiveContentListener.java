package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static final class Api16Impl {
        Api16Impl() {
        }

        static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i3) {
            if ((i3 & 1) != 0) {
                CharSequence coerceToText = item.coerceToText(context);
                if (coerceToText instanceof Spanned) {
                    return coerceToText.toString();
                }
                return coerceToText;
            }
            return item.coerceToStyledText(context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class ApiImpl {
        ApiImpl() {
        }

        static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i3) {
            CharSequence coerceToText = item.coerceToText(context);
            if ((i3 & 1) != 0 && (coerceToText instanceof Spanned)) {
                return coerceToText.toString();
            }
            return coerceToText;
        }
    }

    private static CharSequence coerceToText(@NonNull Context context, @NonNull ClipData.Item item, int i3) {
        return Api16Impl.coerce(context, item, i3);
    }

    private static void replaceSelection(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(LOG_TAG, 3)) {
            Log.d(LOG_TAG, "onReceive: " + contentInfoCompat);
        }
        if (contentInfoCompat.getSource() == 2) {
            return contentInfoCompat;
        }
        ClipData clip = contentInfoCompat.getClip();
        int flags = contentInfoCompat.getFlags();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z16 = false;
        for (int i3 = 0; i3 < clip.getItemCount(); i3++) {
            CharSequence coerceToText = coerceToText(context, clip.getItemAt(i3), flags);
            if (coerceToText != null) {
                if (!z16) {
                    replaceSelection(editable, coerceToText);
                    z16 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), coerceToText);
                }
            }
        }
        return null;
    }
}
