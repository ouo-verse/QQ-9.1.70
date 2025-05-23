package b7;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qzone.homepage.diy.LocalVideoView;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private LocalVideoView f28033a;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends e15.f {
        private boolean C;
        private String D;

        public a(String str, View view) {
            super(str, view);
            this.C = true;
        }

        private void u(String str) {
            ((LocalVideoView) this.f395367e).setVideoFrame(str);
        }

        private void v() {
            if (TextUtils.isEmpty(this.D)) {
                QZLog.e("JsonInflateViewModel", 1, "startPlayVideo video url = null ");
                return;
            }
            LocalVideoView localVideoView = (LocalVideoView) this.f395367e;
            localVideoView.setLoop(this.C);
            File file = new File(c7.a.c().b(this.D));
            if (QZLog.isColorLevel()) {
                QZLog.i("QzoneDIY", 2, "startPlayVideo file exist = " + file.exists());
            }
            if (!file.exists()) {
                localVideoView.e(this.D);
            } else {
                localVideoView.e(file.getPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e15.f
        public void m() {
            super.m();
            v();
        }

        @Override // e15.f
        public void n() {
            super.n();
            View view = this.f395367e;
            if (view != null) {
                ((LocalVideoView) view).c();
            }
        }

        @Override // e15.f
        public void o() {
            super.o();
            View view = this.f395367e;
            if (view != null) {
                ((LocalVideoView) view).d();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e15.f
        public void q(String str, String str2) {
            super.q(str, str2);
            if (this.f395367e instanceof LocalVideoView) {
                if ("content".equals(str)) {
                    this.D = str2;
                } else if ("video_frame".equals(str)) {
                    u(str2);
                } else if ("loop".equals(str)) {
                    this.C = Integer.parseInt(str2) == 1;
                }
            }
        }
    }

    public e(Context context) {
        this.f28033a = new LocalVideoView(context);
    }

    public View a() {
        return this.f28033a;
    }
}
