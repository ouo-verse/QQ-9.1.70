package cooperation.qzone;

import android.view.View;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IQzoneGiftFullScreenViewController {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface GiftFullScreenPlayListener {
        void giftFullScreenPlayEnd();
    }

    boolean onBackEvent();

    View playMaigcface(String str, String str2, boolean z16, GiftFullScreenPlayListener giftFullScreenPlayListener);
}
