package com.tencent.now.app.music.model.manager;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.model.player.MusicPlaySetting;
import com.tencent.util.f;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class MusicPlayMgr {

    /* renamed from: m, reason: collision with root package name */
    private static MusicPlayMgr f338006m;

    /* renamed from: a, reason: collision with root package name */
    protected MusicPlaySetting f338007a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.now.app.music.controller.b f338008b;

    /* renamed from: c, reason: collision with root package name */
    protected List<MusicItem> f338009c;

    /* renamed from: e, reason: collision with root package name */
    protected zl3.b f338011e;

    /* renamed from: g, reason: collision with root package name */
    protected MusicItem f338013g;

    /* renamed from: h, reason: collision with root package name */
    protected String f338014h;

    /* renamed from: k, reason: collision with root package name */
    private b f338017k;

    /* renamed from: d, reason: collision with root package name */
    protected List<MusicItem> f338010d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    protected int f338012f = 0;

    /* renamed from: i, reason: collision with root package name */
    protected int f338015i = 0;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f338016j = true;

    /* renamed from: l, reason: collision with root package name */
    private List<MusicItem> f338018l = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements zl3.a {
        a() {
        }

        @Override // zl3.a
        public void a(MusicItem musicItem, String str, String str2, String str3, String str4) {
            Activity activity;
            LogUtil.i("MusicPlayMgr", "download complete", new Object[0]);
            com.tencent.now.app.music.controller.b bVar = MusicPlayMgr.this.f338008b;
            if (bVar != null) {
                bVar.onProgressUpdate(1, 1);
                MusicPlayMgr.this.f338008b.f(musicItem);
                activity = MusicPlayMgr.this.f338008b.o();
            } else {
                activity = null;
            }
            MusicPlayMgr musicPlayMgr = MusicPlayMgr.this;
            if (musicPlayMgr.f338007a != null) {
                int s16 = musicPlayMgr.s();
                LogUtil.i("MusicPlayMgr", "sdktype:" + s16 + " isShouldPlay:" + MusicPlayMgr.this.f338016j, new Object[0]);
                MusicPlayMgr.this.f338007a.q(s16);
                MusicPlayMgr musicPlayMgr2 = MusicPlayMgr.this;
                if (!musicPlayMgr2.f338016j) {
                    return;
                }
                if (musicPlayMgr2.f338007a.j(activity, str2, str4)) {
                    if (MusicPlayMgr.this.f338008b != null) {
                        long uid = ul3.b.b().getUid();
                        MusicPlayMgr.this.M(com.tencent.hy.common.store.a.c("bgm_vol_key" + uid, 50));
                        MusicPlayMgr.this.L(com.tencent.hy.common.store.a.c("voice_vol_key" + uid, 50));
                        MusicPlayMgr.this.f338008b.i(musicItem);
                        MusicPlayMgr.this.f338008b.s();
                    }
                    LogUtil.w("MusicPlayMgr", "play success", new Object[0]);
                    return;
                }
                com.tencent.now.app.music.controller.b bVar2 = MusicPlayMgr.this.f338008b;
                if (bVar2 != null) {
                    bVar2.e("\u64ad\u653e\u5931\u8d25");
                }
                LogUtil.w("MusicPlayMgr", "play failure", new Object[0]);
                return;
            }
            com.tencent.now.app.music.controller.b bVar3 = musicPlayMgr.f338008b;
            if (bVar3 != null) {
                bVar3.e("\u64ad\u653e\u5931\u8d25");
            }
            LogUtil.i("MusicPlayMgr", "mMusicPlaySetting = null,play error ", new Object[0]);
        }

        @Override // zl3.a
        public void b(MusicItem musicItem, String str, int i3, int i16) {
            com.tencent.now.app.music.controller.b bVar = MusicPlayMgr.this.f338008b;
            if (bVar != null) {
                bVar.onProgressUpdate(i3, i16);
            }
        }

        @Override // zl3.a
        public void c(MusicItem musicItem, String str, int i3, String str2) {
            if (i3 == 403) {
                LogUtil.i("MusicPlayMgr", "downloadMusicFromCgi", new Object[0]);
                MusicPlayMgr.this.m(musicItem, this);
                return;
            }
            LogUtil.i("MusicPlayMgr", "download failed", new Object[0]);
            UIUtil.g("\u4e0b\u8f7d\u5931\u8d25", false);
            com.tencent.now.app.music.controller.b bVar = MusicPlayMgr.this.f338008b;
            if (bVar != null) {
                bVar.r(i3, str2);
            }
            MusicPlayMgr.this.z();
        }
    }

    /* loaded from: classes22.dex */
    public interface b {
        void a(MusicItem musicItem);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00d1: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:210), block:B:19:0x00d1 */
    public MusicPlayMgr() {
        ObjectInputStream objectInputStream;
        Exception e16;
        ObjectInputStream objectInputStream2;
        zl3.b bVar;
        ObjectInputStream objectInputStream3 = null;
        this.f338009c = null;
        try {
            try {
                this.f338009c = new ArrayList();
                this.f338014h = ul3.b.d().getFilesDir() + File.separator + "MusicPlayMgr";
                File file = new File(this.f338014h);
                if (file.exists()) {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        this.f338009c = new ArrayList(Arrays.asList((MusicItem[]) objectInputStream.readObject()));
                        LogUtil.i("MusicPlayMgr", "init mMusicList.size:" + this.f338009c.size(), new Object[0]);
                        objectInputStream3 = objectInputStream;
                    } catch (Exception e17) {
                        e16 = e17;
                        LogUtil.e("MusicPlayMgr", "MusicPlayMgr() error:" + e16, new Object[0]);
                        f.a(objectInputStream);
                        this.f338007a = new MusicPlaySetting(this);
                        bVar = new zl3.b();
                        this.f338011e = bVar;
                        this.f338007a.n(false);
                    }
                }
                f.a(objectInputStream3);
                this.f338007a = new MusicPlaySetting(this);
                bVar = new zl3.b();
            } catch (Exception e18) {
                objectInputStream = null;
                e16 = e18;
            } catch (Throwable th5) {
                th = th5;
                f.a(objectInputStream3);
                this.f338007a = new MusicPlaySetting(this);
                this.f338011e = new zl3.b();
                this.f338007a.n(false);
                throw th;
            }
            this.f338011e = bVar;
            this.f338007a.n(false);
        } catch (Throwable th6) {
            th = th6;
            objectInputStream3 = objectInputStream2;
            f.a(objectInputStream3);
            this.f338007a = new MusicPlaySetting(this);
            this.f338011e = new zl3.b();
            this.f338007a.n(false);
            throw th;
        }
    }

    private void K(boolean z16) {
        com.tencent.now.app.music.controller.b bVar = this.f338008b;
        if (bVar != null) {
            if (!z16) {
                bVar.setNoLyricsMode();
                LogUtil.i("MusicPlayMgr", "setLyricsVisible()->setNoLyricsMode()", new Object[0]);
                return;
            } else {
                bVar.c();
                LogUtil.i("MusicPlayMgr", "setLyricsVisible()->selectLyricsMode()", new Object[0]);
                return;
            }
        }
        LogUtil.w("MusicPlayMgr", "setLyricsVisible().musicControl.is.null!", new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0089, code lost:
    
        if (r0 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c8, code lost:
    
        r9.f338011e = null;
        r9.f338008b = null;
        com.tencent.now.app.music.model.manager.MusicPlayMgr.f338006m = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ce, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c3, code lost:
    
        r0.d();
        r9.f338007a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
    
        if (r0 == null) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void R() {
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream2;
        FileOutputStream fileOutputStream2;
        MusicPlaySetting musicPlaySetting;
        MusicPlaySetting musicPlaySetting2;
        try {
            this.f338007a.s();
            zl3.b bVar = this.f338011e;
            if (bVar != null) {
                bVar.g();
            }
            File file = new File(this.f338014h);
            LogUtil.i("MusicPlayMgr", "writeMusicListToLocalFile, size:" + this.f338009c.size(), new Object[0]);
            if (this.f338009c.size() == 0) {
                file.delete();
                f.b(null);
                f.b(null);
                MusicPlaySetting musicPlaySetting3 = this.f338007a;
                if (musicPlaySetting3 != null) {
                    musicPlaySetting3.d();
                    this.f338007a = null;
                }
                this.f338011e = null;
                this.f338008b = null;
                f338006m = null;
                return;
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (Exception e16) {
                e = e16;
                fileOutputStream2 = fileOutputStream;
                objectOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
            }
            try {
                MusicItem[] musicItemArr = new MusicItem[this.f338009c.size()];
                for (int i3 = 0; i3 < this.f338009c.size(); i3++) {
                    musicItemArr[i3] = this.f338009c.get(i3);
                }
                objectOutputStream.writeObject(musicItemArr);
                f.b(objectOutputStream);
                f.b(fileOutputStream);
                musicPlaySetting2 = this.f338007a;
            } catch (Exception e17) {
                objectOutputStream2 = objectOutputStream;
                e = e17;
                fileOutputStream2 = fileOutputStream;
                try {
                    LogUtil.e("MusicPlayMgr", "onDestroy() error:" + e, new Object[0]);
                    f.b(objectOutputStream2);
                    f.b(fileOutputStream2);
                    musicPlaySetting2 = this.f338007a;
                } catch (Throwable th6) {
                    th = th6;
                    objectOutputStream = objectOutputStream2;
                    fileOutputStream = fileOutputStream2;
                    f.b(objectOutputStream);
                    f.b(fileOutputStream);
                    musicPlaySetting = this.f338007a;
                    if (musicPlaySetting != null) {
                        musicPlaySetting.d();
                        this.f338007a = null;
                    }
                    this.f338011e = null;
                    this.f338008b = null;
                    f338006m = null;
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                f.b(objectOutputStream);
                f.b(fileOutputStream);
                musicPlaySetting = this.f338007a;
                if (musicPlaySetting != null) {
                }
                this.f338011e = null;
                this.f338008b = null;
                f338006m = null;
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            objectOutputStream2 = null;
            fileOutputStream2 = null;
        } catch (Throwable th8) {
            th = th8;
            objectOutputStream = null;
            fileOutputStream = null;
        }
    }

    private void d(MusicItem musicItem) {
        Iterator<MusicItem> it = this.f338009c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().equals(musicItem)) {
                this.f338009c.remove(musicItem);
                break;
            }
        }
        this.f338009c.add(musicItem);
    }

    private void e(MusicItem musicItem) {
        if (musicItem.isEmpty()) {
            return;
        }
        this.f338010d.add(0, musicItem);
        for (int i3 = 0; i3 < this.f338010d.size(); i3++) {
            if (this.f338010d.get(i3).equals(this.f338013g)) {
                this.f338012f = i3;
                return;
            }
        }
    }

    private void g(String str) {
        j(str);
        i(str);
    }

    private void h(final MusicItem musicItem) {
        ThreadCenter.postLogicTask(new Runnable() { // from class: com.tencent.now.app.music.model.manager.MusicPlayMgr.2
            @Override // java.lang.Runnable
            public void run() {
                File g16;
                File g17;
                if (musicItem == null) {
                    return;
                }
                LogUtil.i("MusicPlayMgr", "deleteFile", new Object[0]);
                if (!TextUtils.isEmpty(musicItem.originalUrl) && (g17 = f3.f.j().g(musicItem.originalUrl)) != null && g17.exists()) {
                    LogUtil.i("MusicPlayMgr", "deleteFile originalUrl:" + musicItem.songName, new Object[0]);
                    g17.delete();
                }
                if (!TextUtils.isEmpty(musicItem.accompanyUrl) && (g16 = f3.f.j().g(musicItem.accompanyUrl)) != null && g16.exists()) {
                    LogUtil.i("MusicPlayMgr", "deleteFile accompanyUrl:" + musicItem.songName, new Object[0]);
                    g16.delete();
                }
            }
        });
    }

    private void i(String str) {
        MusicItem q16 = q(str, this.f338009c);
        LogUtil.i("MusicPlayMgr", "deleteFromMusicList, delete:" + q16, new Object[0]);
        if (q16 == null) {
            return;
        }
        Iterator<MusicItem> it = this.f338009c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MusicItem next = it.next();
            if (next != null && next.equals(q16)) {
                this.f338009c.remove(next);
                break;
            }
        }
        h(q16);
    }

    private void j(String str) {
        MusicItem q16 = q(str, this.f338010d);
        LogUtil.i("MusicPlayMgr", "deleteFromPlayList, delete:" + q16, new Object[0]);
        if (q16 == null) {
            return;
        }
        Iterator<MusicItem> it = this.f338010d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MusicItem next = it.next();
            if (q16.equals(next)) {
                this.f338010d.remove(next);
                break;
            }
        }
        if (q16.equals(this.f338013g)) {
            this.f338012f--;
            this.f338013g = null;
            com.tencent.now.app.music.controller.b bVar = this.f338008b;
            if (bVar != null) {
                bVar.d(false);
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < this.f338010d.size(); i3++) {
            if (this.f338010d.get(i3).equals(this.f338013g)) {
                this.f338012f = i3;
                return;
            }
        }
    }

    public static MusicPlayMgr o() {
        if (f338006m == null) {
            synchronized (MusicPlayMgr.class) {
                if (f338006m == null) {
                    f338006m = new MusicPlayMgr();
                }
            }
        }
        return f338006m;
    }

    private MusicItem q(String str, List<MusicItem> list) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (MusicItem musicItem : list) {
            if (musicItem != null && str.equals(musicItem.songId)) {
                return musicItem;
            }
        }
        return null;
    }

    private MusicItem r() {
        MusicItem musicItem;
        LogUtil.i("MusicPlayMgr", "playMode:" + this.f338015i + " mCurrentPlayMusicIndex:" + this.f338012f, new Object[0]);
        if (this.f338010d.size() == 0) {
            return null;
        }
        if (this.f338015i == 1 && (musicItem = this.f338013g) != null) {
            return musicItem;
        }
        int i3 = this.f338012f + 1;
        this.f338012f = i3;
        if (i3 >= this.f338010d.size()) {
            this.f338012f = 0;
        }
        return this.f338010d.get(this.f338012f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(zl3.a aVar, MusicItem musicItem, QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            MusicItem parseGetMusicInfoRsp = MusicItem.parseGetMusicInfoRsp((oq4.b) qQLiveResponse.getRsp());
            if (!parseGetMusicInfoRsp.isEmpty() && this.f338011e != null) {
                LogUtil.w("MusicPlayMgr", "downloadMusicFromCgi downloadNowMusic, songId:" + parseGetMusicInfoRsp.songId, new Object[0]);
                d(parseGetMusicInfoRsp);
                this.f338011e.j(parseGetMusicInfoRsp, aVar);
                return;
            }
            LogUtil.w("MusicPlayMgr", "downloadMusicFromCgi onDownLoadFailed, songId:" + parseGetMusicInfoRsp.songId, new Object[0]);
            if (aVar != null) {
                aVar.c(musicItem, "", 1, "\u4e0b\u8f7d\u5931\u8d25");
                return;
            }
            return;
        }
        LogUtil.e("MusicPlayMgr", "downloadMusicFromCgi failed, retCode=" + qQLiveResponse.getRetCode() + ", msg=" + qQLiveResponse.getErrMsg(), new Object[0]);
        aVar.c(musicItem, "", 1, "\u4e0b\u8f7d\u5931\u8d25");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        x();
        R();
    }

    private void x() {
        List<MusicItem> list = this.f338009c;
        if (list != null && list.size() >= 50) {
            int size = this.f338009c.size() - 50;
            LogUtil.i("MusicPlayMgr", "limitDownloadFileSize, mMusicList.size():" + this.f338009c.size() + ", needDeleteSongSize:" + size, new Object[0]);
            if (size <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f338009c.size(); i3++) {
                MusicItem musicItem = this.f338009c.get(i3);
                if (!this.f338018l.contains(musicItem)) {
                    arrayList.add(musicItem);
                    if (arrayList.size() == size) {
                        break;
                    }
                }
            }
            this.f338018l.clear();
            LogUtil.i("MusicPlayMgr", "limitDownloadFileSize, readyDeleteList.size():" + arrayList.size(), new Object[0]);
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                i(((MusicItem) arrayList.get(i16)).songId);
            }
        }
    }

    protected void A(MusicItem musicItem) {
        if (musicItem == null) {
            return;
        }
        P();
        boolean z16 = !musicItem.equals(this.f338013g);
        this.f338013g = musicItem;
        b bVar = this.f338017k;
        if (bVar != null && z16) {
            bVar.a(musicItem);
        }
        this.f338016j = true;
        if (this.f338008b != null) {
            LogUtil.w("MusicPlayMgr", "playmusic showMusicControl", new Object[0]);
            this.f338008b.q();
            this.f338018l.add(this.f338013g);
        }
        LogUtil.i("MusicPlayMgr", MusicPlayMgr.class.getSimpleName() + ": play music", new Object[0]);
        l(musicItem, new a());
    }

    public void B(@NonNull List<MusicItem> list, int i3) {
        LogUtil.i("MusicPlayMgr", "playMusic, playList.size:" + list.size() + ", startIndex:" + i3, new Object[0]);
        if (i3 >= 0 && i3 < list.size()) {
            com.tencent.now.app.music.controller.b bVar = this.f338008b;
            if (bVar != null) {
                bVar.setMusicPlayMgr(this);
            }
            LogUtil.w("MusicPlayMgr", "\u6253\u5f00\u4f34\u594f,startIndex:" + i3, new Object[0]);
            O(list, i3);
            this.f338012f = i3;
            if (this.f338013g != null && list.get(i3).equals(this.f338013g)) {
                LogUtil.w("MusicPlayMgr", "\u6b63\u5728\u64ad\u653e\u8fd4\u56de" + this.f338013g.songId, new Object[0]);
                return;
            }
            A(list.get(i3));
            return;
        }
        LogUtil.a("MusicPlayMgr", "\u4f34\u594f\u6253\u5f00\u5931\u8d25", new Object[0]);
    }

    public void C() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("playPause:");
        if (this.f338007a == null) {
            str = "true";
        } else {
            str = "false";
        }
        sb5.append(str);
        LogUtil.w("MusicPlayMgr", sb5.toString(), new Object[0]);
        if (this.f338007a != null) {
            LogUtil.w("MusicPlayMgr", "playPause", new Object[0]);
            this.f338007a.k();
        }
    }

    public void D() {
        if (this.f338007a != null) {
            LogUtil.w("MusicPlayMgr", "playResume", new Object[0]);
            this.f338007a.l();
        }
    }

    public void E() {
        com.tencent.now.app.music.controller.b bVar = this.f338008b;
        if (bVar != null) {
            bVar.m();
        }
    }

    public void F(b bVar) {
        this.f338017k = bVar;
    }

    public void G() {
        MusicPlaySetting musicPlaySetting = this.f338007a;
        if (musicPlaySetting != null) {
            musicPlaySetting.t(2);
        }
    }

    public void H() {
        this.f338015i = 0;
    }

    public void I() {
        MusicPlaySetting musicPlaySetting = this.f338007a;
        if (musicPlaySetting != null) {
            musicPlaySetting.t(1);
        }
    }

    public void J() {
        this.f338015i = 1;
    }

    public void L(int i3) {
        MusicPlaySetting musicPlaySetting = this.f338007a;
        if (musicPlaySetting != null) {
            if (i3 > 50) {
                musicPlaySetting.o((((i3 - 50.0f) / 50.0f) * 29.0f) + 1.0f);
            } else {
                musicPlaySetting.o(i3 / 50.0f);
            }
        }
    }

    public void M(int i3) {
        MusicPlaySetting musicPlaySetting = this.f338007a;
        if (musicPlaySetting != null) {
            if (i3 > 50) {
                musicPlaySetting.p((((i3 - 50.0f) / 50.0f) * 29.0f) + 1.0f);
            } else {
                musicPlaySetting.p(i3 / 50.0f);
            }
        }
    }

    public void N(com.tencent.now.app.music.controller.b bVar) {
        this.f338008b = bVar;
        if (bVar != null) {
            bVar.setMusicPlayMgr(this);
        }
    }

    public void O(List<MusicItem> list, int i3) {
        this.f338010d.clear();
        this.f338012f = i3;
        Iterator<MusicItem> it = list.iterator();
        while (it.hasNext()) {
            this.f338010d.add(it.next());
        }
    }

    public void P() {
        this.f338016j = false;
        this.f338013g = null;
        if (this.f338007a != null) {
            LogUtil.i("MusicPlayMgr", QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, new Object[0]);
            this.f338007a.s();
        }
    }

    public void Q() {
        this.f338017k = null;
    }

    public void f(MusicItem musicItem) {
        e(musicItem);
        d(musicItem);
        zl3.b bVar = this.f338011e;
        if (bVar != null) {
            bVar.f(musicItem);
        }
    }

    public void k(String str) {
        LogUtil.i("MusicPlayMgr", "deleteMusic, music:" + str, new Object[0]);
        g(str);
    }

    public void l(MusicItem musicItem, zl3.a aVar) {
        MusicItem q16 = q(musicItem.songId, this.f338009c);
        if (q16 != null && this.f338011e != null) {
            LogUtil.w("MusicPlayMgr", "downloadNowMusic", new Object[0]);
            this.f338011e.j(q16, aVar);
        } else {
            LogUtil.w("MusicPlayMgr", "downloadMusicFromCgi", new Object[0]);
            m(musicItem, aVar);
        }
    }

    protected void m(final MusicItem musicItem, final zl3.a aVar) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetMusicInfoRequest(musicItem.getIntSongId(), musicItem.mId), new ILiveNetRequest.Callback() { // from class: com.tencent.now.app.music.model.manager.b
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                MusicPlayMgr.this.v(aVar, musicItem, qQLiveResponse);
            }
        });
    }

    public MusicItem n() {
        return this.f338013g;
    }

    public com.tencent.now.app.music.controller.b p() {
        return this.f338008b;
    }

    public int t() {
        MusicPlaySetting musicPlaySetting = this.f338007a;
        if (musicPlaySetting != null) {
            return musicPlaySetting.f();
        }
        return 1;
    }

    public int u() {
        MusicPlaySetting musicPlaySetting = this.f338007a;
        if (musicPlaySetting == null) {
            return 0;
        }
        return musicPlaySetting.g();
    }

    public void y() {
        if (this.f338009c == null) {
            return;
        }
        ThreadCenter.postLogicTask(new Runnable() { // from class: com.tencent.now.app.music.model.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                MusicPlayMgr.this.w();
            }
        });
    }

    public void z() {
        LogUtil.i("MusicPlayMgr", "->playFinish().", new Object[0]);
        MusicItem r16 = r();
        if (r16 != null) {
            LogUtil.i("MusicPlayMgr", "->playFinish()->getNextPlayMusic().", new Object[0]);
            K(true);
            A(r16);
        } else {
            LogUtil.i("MusicPlayMgr", "->playFinish()->getNextPlayMusic().item.isnull.", new Object[0]);
            K(false);
        }
    }
}
