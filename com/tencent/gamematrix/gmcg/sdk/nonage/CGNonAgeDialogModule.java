package com.tencent.gamematrix.gmcg.sdk.nonage;

import android.annotation.SuppressLint;
import android.app.Dialog;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNonAgeDialogModule {
    private SoftReference<Dialog> mCacheDialog;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class INNER {

        @SuppressLint({"StaticFieldLeak"})
        static CGNonAgeDialogModule INSTANCE = new CGNonAgeDialogModule();

        INNER() {
        }
    }

    public static CGNonAgeDialogModule getInstance() {
        return INNER.INSTANCE;
    }

    public Dialog getCacheDialog() {
        SoftReference<Dialog> softReference = this.mCacheDialog;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void setCacheDialog(Dialog dialog) {
        this.mCacheDialog = new SoftReference<>(dialog);
    }

    CGNonAgeDialogModule() {
        this.mCacheDialog = null;
    }
}
