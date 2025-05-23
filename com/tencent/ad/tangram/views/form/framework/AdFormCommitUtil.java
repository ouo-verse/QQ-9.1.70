package com.tencent.ad.tangram.views.form.framework;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.form.AdReporterForDMPWithForm;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.AdFormError;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFormCommitUtil {
    private static final String TAG = "AdFormCommitUtil";

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static AdFormError commit(Context context, @Nullable Ad ad5, @Nullable AdFormData adFormData) {
        if (ad5 != null && ad5.isValid() && adFormData != null && adFormData.isValid()) {
            AdFormPrefetchTokenUtil.prefetch(context, ad5, adFormData);
            AdFormError upload = AdFormUploadUtil.upload(adFormData);
            if (upload != null && upload.type == 1) {
                AdReporterForDMPWithForm.reportUpload(context, ad5, adFormData);
            }
            return upload;
        }
        AdLog.e(TAG, "commit error");
        return new AdFormError(4, -1, null);
    }

    public static void commitAsync(final Context context, final Ad ad5, final AdFormData adFormData, @Nullable final WeakReference<AdFormCommitListener> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            weakReference.get().beforeCommit();
        }
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.form.framework.AdFormCommitUtil.1
            @Override // java.lang.Runnable
            public void run() {
                final AdFormError commit = AdFormCommitUtil.commit(context, ad5, adFormData);
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null && weakReference2.get() != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.ad.tangram.views.form.framework.AdFormCommitUtil.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WeakReference weakReference3 = weakReference;
                            if (weakReference3 != null && weakReference3.get() != null) {
                                ((AdFormCommitListener) weakReference.get()).afterCommit(commit);
                            }
                        }
                    });
                }
            }
        }, 3);
    }
}
