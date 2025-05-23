package n1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class a implements e {

        /* renamed from: a, reason: collision with root package name */
        private Messenger f417973a;

        public a(Messenger messenger) {
            this.f417973a = messenger;
        }

        private void c(int i3, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i3);
            obtain.setData(bundle);
            try {
                this.f417973a.send(obtain);
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }

        @Override // n1.e
        public void a(int i3) {
            Bundle bundle = new Bundle(1);
            bundle.putInt("newState", i3);
            c(10, bundle);
        }

        @Override // n1.e
        public void b(DownloadProgressInfo downloadProgressInfo) {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("progress", downloadProgressInfo);
            c(11, bundle);
        }
    }

    public static e a(Messenger messenger) {
        return new a(messenger);
    }
}
