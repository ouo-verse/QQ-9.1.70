package com.tencent.mobileqq.resourcesgrab;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<String> f281267a;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<String> f281268b;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Action1<com.tencent.mobileqq.resourcesgrab.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashSet f281269d;

        a(HashSet hashSet) {
            this.f281269d = hashSet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) hashSet);
            }
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(com.tencent.mobileqq.resourcesgrab.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabModel", 2, "ResourceNameOnClickListener subscribe call :" + cVar);
            }
            b.this.t(cVar, this.f281269d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.resourcesgrab.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8513b implements Action1<Throwable> {
        static IPatchRedirector $redirector_;

        C8513b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
            } else {
                QLog.d("ResourceGrabModel", 1, th5, new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements Action0 {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f281272d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashSet f281273e;

        c(e eVar, HashSet hashSet) {
            this.f281272d = eVar;
            this.f281273e = hashSet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, eVar, hashSet);
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            e eVar = this.f281272d;
            if (eVar != null) {
                eVar.a(this.f281273e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements Func1<com.tencent.mobileqq.resourcesgrab.c, String> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // rx.functions.Func1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(com.tencent.mobileqq.resourcesgrab.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            }
            return cVar.f281277b.mFileName;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void a(HashSet<String> hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f281267a = new SparseArray<>();
            this.f281268b = new SparseArray<>();
        }
    }

    private File k(String str) {
        return new File(BaseApplication.getContext().getExternalCacheDir(), "bitmapResource/" + str);
    }

    private File l(String str) {
        return new File(BaseApplication.getContext().getExternalCacheDir(), "xmlResource/" + str);
    }

    private Bitmap m(com.tencent.mobileqq.resourcesgrab.c cVar) {
        if (cVar != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            if (!ThemeUtil.isDefaultTheme() && !TextUtils.isEmpty(cVar.f281277b.mFilePath)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ResourceGrabModel", 2, "get theme package resource");
                }
                return BitmapFactory.decodeFile(cVar.f281277b.mFilePath, options);
            }
            String str = cVar.f281277b.mFileName;
            String substring = str.substring(0, str.indexOf("."));
            BaseApplication context = BaseApplication.getContext();
            int identifier = context.getResources().getIdentifier(substring, "drawable", context.getPackageName());
            if (identifier > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("ResourceGrabModel", 2, "get system resource");
                }
                return BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), identifier, options);
            }
            return null;
        }
        return null;
    }

    private boolean p(l lVar, int i3, boolean z16) {
        int[] iArr;
        if (z16) {
            iArr = lVar.f78568b;
        } else {
            iArr = lVar.f78569c;
        }
        if (iArr != null && iArr.length > 0) {
            for (int i16 = 0; i16 < iArr.length - 1; i16 += 2) {
                if (i3 > iArr[i16] && i3 <= iArr[i16 + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void q(com.tencent.mobileqq.resourcesgrab.c cVar, HashSet<String> hashSet) {
        Bitmap m3 = m(cVar);
        if (m3 != null) {
            Bitmap s16 = s(m3, cVar.f281277b.mFileName);
            File k3 = k(cVar.f281277b.mFileName);
            hashSet.add(k3.getAbsolutePath());
            try {
                if (!k3.exists()) {
                    if (!k3.getParentFile().exists()) {
                        k3.getParentFile().mkdir();
                    }
                    k3.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(k3);
                s16.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e16) {
                QLog.d("ResourceGrabModel", 1, e16, new Object[0]);
            }
        }
    }

    private void r(com.tencent.mobileqq.resourcesgrab.c cVar, HashSet<String> hashSet) {
        int[] iArr;
        StringBuilder sb5 = new StringBuilder();
        int[][] iArr2 = cVar.f281278c;
        if (iArr2 != null && (iArr = cVar.f281279d) != null && iArr2.length == iArr.length) {
            sb5.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
            sb5.append("<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">\n");
            for (int i3 = 0; i3 < cVar.f281279d.length; i3++) {
                sb5.append("    <item ");
                int i16 = 0;
                while (true) {
                    int[] iArr3 = cVar.f281278c[i3];
                    if (i16 < iArr3.length) {
                        String str = this.f281267a.get(iArr3[i16]);
                        if (!TextUtils.isEmpty(str)) {
                            sb5.append(str);
                            sb5.append(" ");
                        }
                        i16++;
                    }
                }
                int i17 = cVar.f281279d[i3];
                sb5.append("android:color=\"");
                sb5.append("#");
                sb5.append(Integer.toHexString(i17).toUpperCase());
                sb5.append("\"");
                sb5.append(" />\n");
            }
            sb5.append("</selector>");
        }
        v(sb5.toString(), hashSet, cVar.f281277b.mFileName);
    }

    private Bitmap s(Bitmap bitmap, String str) {
        l b16;
        if (str.endsWith(".9.png") && NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk()) && (b16 = l.b(bitmap.getNinePatchChunk())) != null) {
            int width = bitmap.getWidth() + 2;
            int height = bitmap.getHeight() + 2;
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(1.0f, 1.0f);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
            Rect rect = b16.f78570d;
            int i3 = rect.left;
            int i16 = rect.right;
            int i17 = rect.top;
            int i18 = rect.bottom;
            for (int i19 = 1; i19 < Math.max(height, width) - 1; i19++) {
                if (p(b16, i19, true)) {
                    createBitmap.setPixel(i19, 0, -16777216);
                }
                if (i19 > i3 && i19 < (width - 1) - i16) {
                    createBitmap.setPixel(i19, height - 1, -16777216);
                }
                if (p(b16, i19, false)) {
                    createBitmap.setPixel(0, i19, -16777216);
                }
                if (i19 > i17 && i19 < (height - 1) - i18) {
                    createBitmap.setPixel(width - 1, i19, -16777216);
                }
            }
            return createBitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.tencent.mobileqq.resourcesgrab.c cVar, HashSet<String> hashSet) {
        if (cVar.f281276a == 3) {
            r(cVar, hashSet);
        } else {
            q(cVar, hashSet);
        }
    }

    private void v(String str, HashSet<String> hashSet, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabModel", 2, "recoverColorXml content: \n " + str);
            }
            File l3 = l(str2);
            hashSet.add(l3.getAbsolutePath());
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    if (!l3.exists()) {
                        if (!l3.getParentFile().exists()) {
                            l3.getParentFile().mkdir();
                        }
                        l3.createNewFile();
                    }
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(l3), "utf-8");
                    try {
                        outputStreamWriter2.write(str);
                        outputStreamWriter2.flush();
                        outputStreamWriter2.close();
                        try {
                            outputStreamWriter2.close();
                        } catch (Exception e16) {
                            QLog.d("ResourceGrabModel", 1, e16, new Object[0]);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        outputStreamWriter = outputStreamWriter2;
                        QLog.d("ResourceGrabModel", 1, e, new Object[0]);
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception e18) {
                                QLog.d("ResourceGrabModel", 1, e18, new Object[0]);
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception e19) {
                                QLog.d("ResourceGrabModel", 1, e19, new Object[0]);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n(int i3) {
        String str = this.f281268b.get(i3);
        if (TextUtils.isEmpty(str)) {
            return String.valueOf(i3);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f281267a.put(R.attr.state_window_focused, "android:state_window_focused=\"true\"");
        this.f281267a.put(-16842909, "android:state_window_focused=\"false\"");
        this.f281267a.put(R.attr.state_selected, "android:state_selected=\"true\"");
        this.f281267a.put(-16842913, "android:state_selected=\"false\"");
        this.f281267a.put(R.attr.state_focused, "android:state_focused=\"true\"");
        this.f281267a.put(-16842908, "android:state_focused=\"false\"");
        this.f281267a.put(R.attr.state_enabled, "android:state_enabled=\"true\"");
        this.f281267a.put(-16842910, "android:state_enabled=\"false\"");
        this.f281267a.put(R.attr.state_pressed, "android:state_pressed=\"true\"");
        this.f281267a.put(-16842919, "android:state_pressed=\"false\"");
        this.f281267a.put(R.attr.state_checked, "android:state_checked=\"true\"");
        this.f281267a.put(-16842912, "android:state_checked=\"false\"");
        this.f281267a.put(R.attr.state_activated, "android:state_activated=\"true\"");
        this.f281267a.put(-16843518, "android:state_activated=\"false\"");
        this.f281267a.put(R.attr.state_accelerated, "android:state_accelerated=\"true\"");
        this.f281267a.put(-16843547, "android:state_accelerated=\"false\"");
        this.f281267a.put(R.attr.state_hovered, "android:state_hovered=\"true\"");
        this.f281267a.put(-16843623, "android:state_hovered=\"false\"");
        this.f281267a.put(R.attr.state_drag_can_accept, "android:state_drag_can_accept=\"true\"");
        this.f281267a.put(-16843624, "android:state_drag_can_accept=\"false\"");
        this.f281267a.put(R.attr.state_drag_hovered, "android:state_drag_hovered=\"true\"");
        this.f281267a.put(-16843625, "android:state_drag_hovered=\"false\"");
        this.f281268b.put(0, "background");
        this.f281268b.put(1, "image_drawable");
        this.f281268b.put(2, "compound_drawables");
        this.f281268b.put(3, "text_color");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(List<com.tencent.mobileqq.resourcesgrab.c> list, e eVar) {
        if (!list.isEmpty()) {
            HashSet hashSet = new HashSet();
            Observable.from(list).distinct(new d()).subscribeOn(Schedulers.io()).subscribe(new a(hashSet), new C8513b(), new c(eVar, hashSet));
        }
    }
}
