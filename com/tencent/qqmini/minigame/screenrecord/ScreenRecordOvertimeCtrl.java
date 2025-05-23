package com.tencent.qqmini.minigame.screenrecord;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.helper.b;
import com.tencent.qqmini.minigame.ui.ScreenRecordOvertimePreview;
import com.tencent.qqmini.minigame.utils.AlbumUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IScreenRecord;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniToast;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ScreenRecordOvertimeCtrl implements com.tencent.qqmini.minigame.screenrecord.b, ScreenRecordOvertimePreview.a {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f346669a;

    /* renamed from: b, reason: collision with root package name */
    private TritonEngine f346670b;

    /* renamed from: c, reason: collision with root package name */
    private IMiniAppContext f346671c;

    /* renamed from: d, reason: collision with root package name */
    private IScreenRecord f346672d;

    /* renamed from: e, reason: collision with root package name */
    private ScreenRecordOvertimePreview f346673e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.qqmini.minigame.screenrecord.b f346674f;

    /* renamed from: g, reason: collision with root package name */
    private String f346675g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f346676h = new Runnable() { // from class: com.tencent.qqmini.minigame.screenrecord.ScreenRecordOvertimeCtrl.4
        @Override // java.lang.Runnable
        public void run() {
            ScreenRecordOvertimeCtrl.this.remove();
        }
    };

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements ScreenShotCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.triton.engine.ScreenShotCallback
        public void onGetScreenShot(@NonNull Object obj) {
            Bitmap bitmap;
            if (obj instanceof Bitmap) {
                bitmap = (Bitmap) obj;
            } else {
                bitmap = null;
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                ScreenRecordOvertimeCtrl.this.q(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements b.c {
        b() {
        }

        @Override // com.tencent.qqmini.minigame.helper.b.c
        public void a(boolean z16) {
            if (!z16) {
                return;
            }
            AlbumUtils.g(ScreenRecordOvertimeCtrl.this.f346675g, ScreenRecordOvertimeCtrl.this.f346671c.getAttachedActivity());
        }
    }

    public ScreenRecordOvertimeCtrl(ViewGroup viewGroup) {
        this.f346669a = viewGroup;
    }

    private c l() {
        return new c(this.f346669a);
    }

    private ScreenRecordOvertimePreview m() {
        return new ScreenRecordOvertimePreview(this.f346669a.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ThreadManager.getUIHandler().postDelayed(this.f346676h, 5000L);
    }

    private void o() {
        ScreenRecordOvertimePreview screenRecordOvertimePreview = this.f346673e;
        if (screenRecordOvertimePreview == null) {
            return;
        }
        screenRecordOvertimePreview.setVisibility(8);
        this.f346673e = null;
    }

    private void p() {
        ViewGroup viewGroup;
        if (this.f346671c != null && (viewGroup = this.f346669a) != null) {
            Context context = viewGroup.getContext();
            MiniToast.makeText(context, context.getResources().getString(R.string.mini_game_screen_record_max_time_3min), 1).show();
            com.tencent.qqmini.minigame.helper.b bVar = new com.tencent.qqmini.minigame.helper.b((Activity) this.f346669a.getContext(), new b(), QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            MiniAppInfo miniAppInfo = this.f346671c.getMiniAppInfo();
            if (miniAppInfo == null) {
                AlbumUtils.g(this.f346675g, this.f346671c.getAttachedActivity());
            } else {
                bVar.c(miniAppInfo.name, miniAppInfo.iconUrl, this.f346669a.getContext().getString(R.string.mini_sdk_permission_dialog_write_album_title), this.f346669a.getContext().getString(R.string.mini_sdk_permission_dialog_write_album_content));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final Bitmap bitmap) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.screenrecord.ScreenRecordOvertimeCtrl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ScreenRecordOvertimeCtrl.this.f346669a.addView(ScreenRecordOvertimeCtrl.this.f346673e, new RelativeLayout.LayoutParams(-1, -1));
                    ScreenRecordOvertimeCtrl.this.f346673e.setScreenSnapshot(bitmap);
                    ScreenRecordOvertimeCtrl.this.n();
                } catch (Throwable th5) {
                    QMLog.e("ScreenRecordOvertimeView", th5.getMessage());
                }
            }
        });
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public void a(IMiniAppContext iMiniAppContext, TritonEngine tritonEngine, IScreenRecord iScreenRecord) {
        this.f346671c = iMiniAppContext;
        this.f346670b = tritonEngine;
        this.f346672d = iScreenRecord;
    }

    @Override // com.tencent.qqmini.minigame.ui.ScreenRecordOvertimePreview.a
    public void b() {
        o();
        IScreenRecord iScreenRecord = this.f346672d;
        if (iScreenRecord != null) {
            iScreenRecord.prepareAndStartRecord(2);
        }
    }

    @Override // com.tencent.qqmini.minigame.ui.ScreenRecordOvertimePreview.a
    public void c() {
        if (this.f346674f != null) {
            return;
        }
        o();
    }

    @Override // com.tencent.qqmini.minigame.ui.ScreenRecordOvertimePreview.a
    public void d() {
        ThreadManager.getUIHandler().removeCallbacks(this.f346676h);
        o();
        c l3 = l();
        this.f346674f = l3;
        l3.a(this.f346671c, this.f346670b, this.f346672d);
        this.f346674f.e(this.f346675g, true);
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public boolean e(String str, boolean z16) {
        if (this.f346670b != null && this.f346669a != null) {
            this.f346675g = str;
            p();
            ScreenRecordOvertimePreview m3 = m();
            this.f346673e = m3;
            m3.setClickListener(this);
            this.f346670b.takeScreenShot(new a());
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public boolean remove() {
        boolean z16;
        ViewGroup viewGroup;
        ScreenRecordOvertimePreview screenRecordOvertimePreview = this.f346673e;
        if (screenRecordOvertimePreview != null && (viewGroup = this.f346669a) != null) {
            viewGroup.removeView(screenRecordOvertimePreview);
            this.f346673e = null;
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.qqmini.minigame.screenrecord.b bVar = this.f346674f;
        if (bVar != null) {
            bVar.remove();
            return true;
        }
        return z16;
    }
}
