package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class EditJumpToPtu extends u {

    /* renamed from: d, reason: collision with root package name */
    public a f67679d;

    /* renamed from: e, reason: collision with root package name */
    private String f67680e;

    /* renamed from: f, reason: collision with root package name */
    QQProgressDialog f67681f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f67682h;

    /* loaded from: classes32.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                if (EditJumpToPtu.this.f67680e != null) {
                    id0.b.h("0X80080E3", id0.b.f407534c);
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    arrayList.add(Uri.parse(EditJumpToPtu.this.f67680e));
                    Intent putParcelableArrayListExtra = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                    putParcelableArrayListExtra.putExtra("big_brother_source_key", "biz_src_jc_editor");
                    EditJumpToPtu.this.mUi.getActivity().startActivityForResult(putParcelableArrayListExtra, 100);
                }
                EditJumpToPtu.this.m0();
                return;
            }
            if (i3 == 2) {
                EditJumpToPtu.this.mParent.e1((Bitmap) message.obj, false);
                EditJumpToPtu.this.f67682h = true;
            } else {
                if (i3 != 3) {
                    return;
                }
                EditJumpToPtu.this.mParent.t(0);
                EditJumpToPtu.this.m0();
            }
        }
    }

    public EditJumpToPtu(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.f67682h = false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        if (this.f67682h) {
            bVar.f400395l.f400420f++;
        }
    }

    public boolean l0(String str) {
        DoodleLayout V = this.mParent.I.V();
        if (V == null) {
            return false;
        }
        Bitmap Y = V.Y(0, false);
        Bitmap S = this.mParent.S();
        if (S == null) {
            return false;
        }
        if (Y != null) {
            S = com.tencent.biz.qqstory.utils.b.j(S, Y);
            V.E(Y);
        }
        return com.tencent.biz.qqstory.utils.b.b(S, str);
    }

    void m0() {
        QQProgressDialog qQProgressDialog = this.f67681f;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            return;
        }
        this.f67681f.dismiss();
    }

    public int n0() {
        return this.mParent.k0() ? this.mParent.l0() ? 3 : 4 : this.mParent.l0() ? 1 : 2;
    }

    public Bitmap o0(String str) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        DisplayMetrics displayMetrics = this.mUi.getActivity().getResources().getDisplayMetrics();
        int m06 = EditPicRawImage.m0(options, displayMetrics.widthPixels, displayMetrics.heightPixels);
        options.inJustDecodeBounds = false;
        options.inSampleSize = m06;
        try {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(str, options);
        } catch (OutOfMemoryError unused) {
            hd0.c.g("EditJumpToPtu", "decodeoom");
            bitmap = null;
        }
        if (bitmap == null) {
            QLog.e("EditJumpToPtu", 1, "decode" + ((Object) null));
            this.mUi.finish(0, null, R.anim.dialog_exit, 0);
            return null;
        }
        hd0.c.a("EditJumpToPtu", "sampleSize" + m06 + " w " + bitmap.getWidth() + " h " + bitmap.getHeight());
        int exifOrientation = BaseImageUtil.getExifOrientation(str);
        if (exifOrientation != 0 && exifOrientation % 90 == 0) {
            hd0.c.a("EditJumpToPtu", "has exif rotate" + exifOrientation);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        this.f67679d.obtainMessage(2, bitmap).sendToTarget();
        return bitmap;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (!EditVideoPartManager.v(this.mParent.C.f204057f, 65536)) {
            this.mParent.t(0);
        }
        if (i3 == 100) {
            if (i16 == -1) {
                Activity activity = this.mParent.d0().getActivity();
                if (activity == null) {
                    return;
                }
                ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).L[n0()].b(activity);
                Bundle bundle = this.mParent.Y;
                if (bundle != null) {
                    bundle.clear();
                }
                try {
                    final String uri = ((Uri) intent.getParcelableExtra("android.intent.extra.STREAM")).toString();
                    hd0.c.a("EditJumpToPtu", "onActivityResult PI_TU, new path " + uri);
                    if (!TextUtils.isEmpty(uri)) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap o06 = EditJumpToPtu.this.o0(uri);
                                if (o06 != null) {
                                    com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().S(o06);
                                }
                            }
                        }, 64, null, true);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                hd0.c.a("EditJumpToPtu", "onActivityResult cancel ");
            }
            if (this.f67680e != null) {
                n0.a.g(new File(this.f67680e));
                this.f67680e = null;
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.f67679d = new a();
    }

    public boolean p0(Context context) {
        if (!PackageUtil.isPackageInstalled(context, "com.tencent.ttpic")) {
            return false;
        }
        try {
            return PackageUtil.getVersionCode(context, "com.tencent.ttpic") >= 490;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    void q0(String str) {
        if (this.f67681f == null) {
            this.f67681f = new QQProgressDialog(getContext(), getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        this.f67681f.setMessage(str);
        this.f67681f.setCancelable(false);
        this.f67681f.show();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 != 10) {
            return;
        }
        id0.b.h("0X80080E2", id0.b.f407534c);
        if (p0(this.mUi.getContext())) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu.1
                @Override // java.lang.Runnable
                public void run() {
                    EditJumpToPtu.this.f67680e = h.f68705a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png";
                    EditJumpToPtu editJumpToPtu = EditJumpToPtu.this;
                    if (!editJumpToPtu.l0(editJumpToPtu.f67680e)) {
                        EditJumpToPtu.this.f67680e = null;
                        hd0.c.g("EditJumpToPtu", "get rawBitmap error!");
                        EditJumpToPtu.this.f67679d.sendEmptyMessage(3);
                        return;
                    }
                    EditJumpToPtu.this.f67679d.sendEmptyMessage(1);
                }
            }, 5, null, true);
            q0(HardCodeUtil.qqStr(R.string.lvp));
            return;
        }
        id0.b.h("0X80080E4", id0.b.f407534c);
        ComponentName componentName = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
        Intent intent = new Intent();
        intent.putExtra("url", "https://tu.qq.com/websites/guide/sticker.html");
        intent.putExtra("big_brother_source_key", "biz_src_jc_editor");
        intent.setComponent(componentName);
        this.mUi.getActivity().startActivityForResult(intent, 101);
    }
}
