package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ScreenshotManager {

    /* renamed from: e, reason: collision with root package name */
    public static final String f106544e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f106545f;

    /* renamed from: a, reason: collision with root package name */
    private ImageView f106546a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f106547b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f106548c = GameCenterSpUtils.readBoolFromSp("gamecenter_shot_switch");

    /* renamed from: d, reason: collision with root package name */
    private boolean f106549d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ScreenshotManager f106555a = new ScreenshotManager();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        void a(int i3, String str);
    }

    static {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("Tencent/MobileQQ/gamecenter" + File.separator);
        f106544e = sDKPrivatePath;
        f106545f = VFSAssistantUtils.getSDKPrivatePath(sDKPrivatePath + "gamecenter_screenshot");
    }

    public static ScreenshotManager m() {
        return a.f106555a;
    }

    public static Bitmap o(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void p(Context context, final String str, final b bVar) {
        if (q.p(f106545f + str)) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.gamecenter.common.util.ScreenshotManager.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    if (!TextUtils.isEmpty(str)) {
                        ScreenshotManager screenshotManager = ScreenshotManager.this;
                        if (screenshotManager.f106547b != null) {
                            bitmap = ScreenshotManager.this.f106547b;
                        } else {
                            bitmap = BitmapFactory.decodeFile(ScreenshotManager.f106545f + str);
                        }
                        screenshotManager.f106547b = bitmap;
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(304, "load to mem");
                        }
                    }
                }
            });
        }
    }

    public void f(final WebView webView) {
        if (!h(null)) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.common.util.ScreenshotManager.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("ScreenshotManager", 1, "addMaskAsync mRemoveCall=" + ScreenshotManager.this.f106549d);
                if (ScreenshotManager.this.f106547b != null && !ScreenshotManager.this.f106549d) {
                    try {
                        if (ScreenshotManager.this.f106546a == null) {
                            ScreenshotManager.this.f106546a = new ImageView(webView.getContext());
                            ScreenshotManager.this.f106546a.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                        ScreenshotManager.this.f106546a.setImageBitmap(ScreenshotManager.this.f106547b);
                        ScreenshotManager.this.l();
                        ((ViewGroup) webView.getParent()).addView(ScreenshotManager.this.f106546a, new FrameLayout.LayoutParams(-1, -1));
                        ScreenshotManager.this.f106546a.setVisibility(0);
                    } catch (Throwable th5) {
                        QLog.e("ScreenshotManager", 1, "addMaskAsync e=" + th5.toString());
                    }
                }
            }
        });
    }

    public void g(WebView webView, String str, b bVar) {
        if (!h(bVar)) {
            return;
        }
        if (this.f106547b == null) {
            bVar.a(-300, "preloadMask not init");
            p(webView.getContext(), str, bVar);
            QLog.e("ScreenshotManager", 1, "preloadMask not init");
            return;
        }
        ImageView imageView = new ImageView(webView.getContext());
        this.f106546a = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f106546a.setImageBitmap(this.f106547b);
        this.f106549d = false;
        try {
            l();
            ((ViewGroup) webView.getParent()).addView(this.f106546a, new FrameLayout.LayoutParams(this.f106547b.getWidth(), this.f106547b.getHeight()));
            this.f106546a.setVisibility(0);
            bVar.a(0, MeasureConst.SLI_TYPE_SUCCESS);
        } catch (Throwable th5) {
            QLog.e("ScreenshotManager", 1, "addShot error =" + th5.toString());
            bVar.a(-301, "add view error");
        }
    }

    public boolean h(b bVar) {
        if (!GameCenterSpUtils.readBoolFromSp("gamecenter_shot_switch")) {
            if (bVar != null) {
                bVar.a(-1, "shot switch is false");
                return false;
            }
            return false;
        }
        return true;
    }

    public void i(b bVar) {
        QLog.i("ScreenshotManager", 1, "closeShot");
        if (GameCenterSpUtils.writeToSpBool("gamecenter_shot_switch", false)) {
            this.f106548c = false;
            bVar.a(0, "closeShot succ");
        } else {
            bVar.a(LightConstants.ErrorCode.HEAD_INSET_RESOURCE_NOT_SUPPORT, "closeShot fail");
        }
    }

    public void j(b bVar) {
        if (q.d(f106544e)) {
            bVar.a(0, "delShotFile succ");
        } else {
            bVar.a(LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT, "delShotFile fail");
        }
    }

    public void k() {
        this.f106546a = null;
    }

    public void l() {
        try {
            if (this.f106546a.getParent() != null) {
                ((ViewGroup) this.f106546a.getParent()).removeView(this.f106546a);
                this.f106546a.setVisibility(4);
                QLog.i("ScreenshotManager", 1, "forceRemoveMask call");
            }
        } catch (Throwable th5) {
            QLog.e("ScreenshotManager", 1, "forceRemoveMask e=" + th5.toString());
        }
    }

    public boolean n() {
        ImageView imageView = this.f106546a;
        if (imageView != null && imageView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void q(b bVar) {
        QLog.i("ScreenshotManager", 1, "open");
        if (GameCenterSpUtils.writeToSpBool("gamecenter_shot_switch", true)) {
            this.f106548c = true;
            bVar.a(0, "openShot succ");
        } else {
            bVar.a(LightConstants.ErrorCode.HEAD_INSET_RESOURCE_NOT_SUPPORT, "openShot fail");
        }
    }

    public void r(String str, b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, GameCenterSpUtils.readBoolFromSp("gamecenter_shot_switch"));
            jSONObject.put("fileExist", q.p(f106544e + str));
            bVar.a(0, jSONObject.toString());
        } catch (Exception unused) {
            bVar.a(LightConstants.ErrorCode.OPENGL_NOT_SUPPORT, "queryShotInfo error");
        }
    }

    public void s(WebView webView, b bVar) {
        if (!h(bVar)) {
            return;
        }
        this.f106549d = true;
        ImageView imageView = this.f106546a;
        if (imageView != null && imageView.getVisibility() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ScreenshotManager", 2, "removeShotMask call");
            }
            try {
                ((ViewGroup) webView.getParent()).removeView(this.f106546a);
                this.f106546a.setVisibility(4);
                bVar.a(0, "removeShotMask succ");
                return;
            } catch (Throwable unused) {
                bVar.a(LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY, "removeShotMask fail");
                return;
            }
        }
        bVar.a(0, "removeShotMask no visible");
    }

    public boolean t(Bitmap bitmap, String str) {
        if (bitmap != null) {
            try {
                String str2 = f106545f + str;
                com.tencent.biz.qqstory.utils.d.c(f106544e);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } catch (Exception e16) {
                QLog.e("ScreenshotManager", 1, "screenShot saveBitmap error=" + e16.toString());
            }
        }
        return false;
    }

    public void u(WebView webView, final String str, final b bVar) {
        if (!h(bVar)) {
            return;
        }
        this.f106547b = o(webView);
        QLog.i("ScreenshotManager", 1, "screenShot view.w =" + webView.getWidth() + " view.h=" + webView.getHeight() + " mask.w = " + this.f106547b.getWidth() + " mask.h=" + this.f106547b.getHeight());
        if (this.f106546a == null) {
            ImageView imageView = new ImageView(webView.getContext());
            this.f106546a = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        this.f106546a.setImageBitmap(this.f106547b);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.gamecenter.common.util.ScreenshotManager.2
            @Override // java.lang.Runnable
            public void run() {
                ScreenshotManager screenshotManager = ScreenshotManager.this;
                if (screenshotManager.t(screenshotManager.f106547b, str)) {
                    bVar.a(0, MeasureConst.SLI_TYPE_SUCCESS);
                    GameCenterSpUtils.writeToSp("gamecenter_shot_key", str);
                } else {
                    bVar.a(-200, "save file fail");
                }
            }
        });
    }
}
