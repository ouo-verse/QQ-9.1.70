package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MultiEmotionSaveManager implements Manager, Handler.Callback {
    private a C;

    /* renamed from: d, reason: collision with root package name */
    private BaseQQAppInterface f204113d;

    /* renamed from: f, reason: collision with root package name */
    private volatile CopyOnWriteArrayList<g> f204115f = new CopyOnWriteArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private volatile ConcurrentLinkedQueue<g> f204116h = new ConcurrentLinkedQueue<>();

    /* renamed from: i, reason: collision with root package name */
    private volatile int f204117i = 0;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f204118m = 0;
    private boolean D = false;
    private boolean E = false;
    private long F = 0;

    /* renamed from: e, reason: collision with root package name */
    private Handler f204114e = new Handler(Looper.getMainLooper(), this);

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b(int i3);

        void c();

        void d(g gVar);
    }

    public MultiEmotionSaveManager(BaseQQAppInterface baseQQAppInterface) {
        this.f204113d = baseQQAppInterface;
    }

    private void c() {
        if (QLog.isColorLevel()) {
            QLog.i("MultiEmotionSaveManager", 2, "clearCatch");
        }
        this.f204116h.clear();
        this.f204115f.clear();
        this.F = 0L;
        this.f204118m = 0;
        this.D = false;
        this.E = false;
        this.f204117i = 0;
        this.f204114e.removeCallbacksAndMessages(null);
    }

    private void d() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.c();
        }
    }

    private void e() {
        if (this.F != 0 && this.C != null) {
            int i3 = (int) ((this.f204118m * 100.0d) / this.F);
            if (this.f204118m == this.F) {
                i3 = 100;
            }
            a aVar = this.C;
            if (aVar != null) {
                aVar.b(i3);
            }
        }
    }

    private void f(g gVar) {
        h(gVar.f204362b, System.nanoTime() + "", gVar);
    }

    private void h(final String str, String str2, final g gVar) {
        int i3;
        final File file;
        this.f204117i++;
        int i16 = 0;
        if (TextUtils.isEmpty(str)) {
            i3 = 10001;
        } else if (TextUtils.isEmpty(str2)) {
            i3 = 10002;
        } else if (!FileUtils.fileExists(str)) {
            i3 = 10003;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiEmotionSaveManager", 2, "realSaveEmo failed! errorCode = " + i3);
            }
            if (gVar != null) {
                gVar.f204364d = -1;
                gVar.f204365e = i3;
                gVar.f204366f = com.tencent.mobileqq.multimsg.save.b.a(i3);
                Message obtainMessage = this.f204114e.obtainMessage(2);
                obtainMessage.obj = gVar;
                this.f204114e.sendMessage(obtainMessage);
                return;
            }
            return;
        }
        String str3 = str2;
        do {
            if (i16 > 0) {
                str3 = str2 + "_" + i16;
            }
            if (!str3.contains(".")) {
                str3 = str3 + "." + FileUtils.estimateFileType(str);
            }
            file = new File(f.f204297a, str3);
            i16++;
        } while (file.exists());
        final File file2 = new File(str);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1
            /* JADX WARN: Removed duplicated region for block: B:22:0x00f2  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00f8  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                File file3;
                int i17 = 1;
                int i18 = 0;
                try {
                    if (file != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...destFile=" + file);
                        }
                        if (!file.getParentFile().exists()) {
                            boolean mkdir = file.getParentFile().mkdir();
                            if (QLog.isColorLevel()) {
                                QLog.i("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=" + mkdir);
                            }
                        }
                    }
                    file3 = file;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("MultiEmotionSaveManager", 2, "save exception = " + e16.getMessage());
                    }
                    g gVar2 = gVar;
                    gVar2.f204365e = 10005;
                    gVar2.f204366f = com.tencent.mobileqq.multimsg.save.b.a(10005);
                }
                if (file3 != null && FileUtils.copyFile(file2, file3)) {
                    if (QLog.isColorLevel()) {
                        QLog.e("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...path=" + str);
                    }
                    BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), file.getAbsolutePath());
                    z16 = true;
                    if (!z16) {
                    }
                    g gVar3 = gVar;
                    if (!z16) {
                    }
                    gVar3.f204364d = i18;
                    Message obtainMessage2 = MultiEmotionSaveManager.this.f204114e.obtainMessage(i17);
                    obtainMessage2.obj = gVar;
                    MultiEmotionSaveManager.this.f204114e.sendMessage(obtainMessage2);
                }
                if (QLog.isColorLevel() && file != null) {
                    QLog.e("MultiEmotionSaveManager", 2, "copyFile error destFile = " + file.getAbsolutePath());
                }
                g gVar4 = gVar;
                gVar4.f204365e = 10004;
                gVar4.f204366f = com.tencent.mobileqq.multimsg.save.b.a(10004);
                z16 = false;
                if (!z16) {
                    i17 = 2;
                }
                g gVar32 = gVar;
                if (!z16) {
                    i18 = -1;
                }
                gVar32.f204364d = i18;
                Message obtainMessage22 = MultiEmotionSaveManager.this.f204114e.obtainMessage(i17);
                obtainMessage22.obj = gVar;
                MultiEmotionSaveManager.this.f204114e.sendMessage(obtainMessage22);
            }
        });
    }

    public void b() {
        if (QLog.isColorLevel()) {
            QLog.i("MultiEmotionSaveManager", 2, "cancelMultiEmoSave");
        }
        c();
        a aVar = this.C;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void g() {
        this.C = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g gVar;
        int i3;
        Object obj = message.obj;
        if ((obj instanceof g) && (gVar = (g) obj) != null && ((i3 = message.what) == 1 || i3 == 2)) {
            this.f204117i--;
            if (message.what == 2) {
                this.D = true;
                if (QLog.isColorLevel()) {
                    QLog.i("MultiEmotionSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + gVar.f204365e + ", errorMsg = " + gVar.f204366f);
                }
            } else {
                this.E = true;
            }
            this.f204118m++;
            e();
            g poll = this.f204116h.poll();
            if (poll != null) {
                f(poll);
            } else if (this.f204117i == 0) {
                g gVar2 = new g();
                if (this.E) {
                    gVar2.f204364d = 0;
                } else {
                    gVar2.f204364d = -1;
                    gVar2.f204365e = gVar.f204365e;
                    gVar2.f204366f = gVar.f204366f;
                }
                i(gVar2);
            }
        }
        return false;
    }

    public void i(g gVar) {
        if (QLog.isColorLevel()) {
            QLog.i("MultiEmotionSaveManager", 2, "saveComplete");
        }
        a aVar = this.C;
        if (aVar != null) {
            aVar.d(gVar);
        }
        c();
    }

    public void j(List<EmoticonInfo> list) {
        if (list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList count is :" + list.size());
            }
            c();
            for (EmoticonInfo emoticonInfo : list) {
                if (emoticonInfo instanceof BaseFavoriteEmoticonInfo) {
                    BaseFavoriteEmoticonInfo baseFavoriteEmoticonInfo = (BaseFavoriteEmoticonInfo) emoticonInfo;
                    g gVar = new g();
                    gVar.f204361a = baseFavoriteEmoticonInfo.resID;
                    gVar.f204362b = baseFavoriteEmoticonInfo.path;
                    this.f204115f.add(gVar);
                } else if (QLog.isColorLevel()) {
                    QLog.d("MultiEmotionSaveManager", 2, "temp is not CustomEmoticonInfoBase class is " + emoticonInfo.getClass());
                }
            }
            if (this.f204115f.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList is empty!");
                }
                g gVar2 = new g();
                gVar2.f204364d = -1;
                gVar2.f204365e = 10006;
                gVar2.f204366f = com.tencent.mobileqq.multimsg.save.b.a(10006);
                i(gVar2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList count is :" + this.f204115f.size());
            }
            d();
            this.F = this.f204115f.size();
            Iterator<g> it = this.f204115f.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (this.f204117i < 1) {
                    f(next);
                } else {
                    this.f204116h.add(next);
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList is empty!");
        }
        g gVar3 = new g();
        gVar3.f204364d = -1;
        gVar3.f204365e = 10006;
        gVar3.f204366f = com.tencent.mobileqq.multimsg.save.b.a(10006);
        i(gVar3);
    }

    public void k(a aVar) {
        this.C = aVar;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.i("MultiEmotionSaveManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        c();
    }
}
