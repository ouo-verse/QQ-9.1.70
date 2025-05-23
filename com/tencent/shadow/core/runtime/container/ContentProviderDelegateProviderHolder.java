package com.tencent.shadow.core.runtime.container;

/* loaded from: classes25.dex */
public class ContentProviderDelegateProviderHolder {
    static ContentProviderDelegateProvider contentProviderDelegateProvider;
    private static DelegateProviderHolderPrepareListener sPrepareListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public interface DelegateProviderHolderPrepareListener {
        void onPrepare();
    }

    private static void notifyDelegateProviderHolderPrepare() {
        DelegateProviderHolderPrepareListener delegateProviderHolderPrepareListener = sPrepareListener;
        if (delegateProviderHolderPrepareListener != null) {
            delegateProviderHolderPrepareListener.onPrepare();
        }
    }

    public static void setContentProviderDelegateProvider(ContentProviderDelegateProvider contentProviderDelegateProvider2) {
        contentProviderDelegateProvider = contentProviderDelegateProvider2;
        notifyDelegateProviderHolderPrepare();
    }

    public static void setDelegateProviderHolderPrepareListener(DelegateProviderHolderPrepareListener delegateProviderHolderPrepareListener) {
        sPrepareListener = delegateProviderHolderPrepareListener;
    }
}
