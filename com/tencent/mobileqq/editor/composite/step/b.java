package com.tencent.mobileqq.editor.composite.step;

import android.text.TextUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filter.e;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static int f204002c;

    /* renamed from: a, reason: collision with root package name */
    private Object f204003a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f204004b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements com.tencent.mobileqq.videocodec.mediacodec.recorder.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f204005d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.videocodec.mediacodec.encoder.c f204006e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PublishVideoEntry f204007f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.videocodec.mediacodec.a f204008h;

        a(e eVar, com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, PublishVideoEntry publishVideoEntry, com.tencent.mobileqq.videocodec.mediacodec.a aVar) {
            this.f204005d = eVar;
            this.f204006e = cVar;
            this.f204007f = publishVideoEntry;
            this.f204008h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, eVar, cVar, publishVideoEntry, aVar);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeError(int i3, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) th5);
                return;
            }
            hd0.c.h("MergeEditVideo", "encode error errorCode = " + i3 + " Exception = ", th5);
            if (i3 > 10000) {
                synchronized (b.this.f204003a) {
                    b.this.f204004b = true;
                    b.this.f204003a.notifyAll();
                }
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                synchronized (b.this.f204003a) {
                    b.this.f204004b = true;
                    b.this.f204003a.notifyAll();
                }
                e eVar = this.f204005d;
                if (eVar != null) {
                    eVar.e();
                }
                QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (this.f204007f.isCancel) {
                this.f204008h.a();
                QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            e eVar = this.f204005d;
            if (eVar != null) {
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.f204006e;
                eVar.f(cVar.f312559d, cVar.f312560e);
            }
            QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.editor.composite.step.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C7493b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected int f204010a;

        /* renamed from: b, reason: collision with root package name */
        protected PublishVideoEntry f204011b;

        /* renamed from: c, reason: collision with root package name */
        int f204012c;

        /* renamed from: d, reason: collision with root package name */
        int f204013d;

        /* renamed from: e, reason: collision with root package name */
        protected int f204014e;

        /* renamed from: f, reason: collision with root package name */
        protected int f204015f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f204016g;

        public C7493b(int i3, PublishVideoEntry publishVideoEntry) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) publishVideoEntry);
                return;
            }
            this.f204014e = -1;
            this.f204015f = -1;
            this.f204016g = false;
            this.f204010a = i3;
            PublishVideoEntry publishVideoEntry2 = new PublishVideoEntry();
            this.f204011b = publishVideoEntry2;
            publishVideoEntry2.copy(publishVideoEntry);
            d(this.f204011b.saveMode);
        }

        private int b(int i3) {
            return 0;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f204011b.doodlePath = null;
            }
        }

        public int c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
            }
            int i16 = 1;
            if (i3 != 1) {
                i16 = 2;
                if (i3 != 2) {
                    i16 = 3;
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return 4;
                        }
                        if (i3 == 5) {
                            return 5;
                        }
                        return 0;
                    }
                }
            }
            return i16;
        }

        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f204012c = b(i3);
                this.f204013d = c(i3);
            }
        }

        public void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.f204014e = i3;
            }
        }

        public void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.f204015f = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42263);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f204002c = 1280;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f204003a = new Object();
            this.f204004b = false;
        }
    }

    private void c(C7493b c7493b, DecodeConfig decodeConfig, com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, PublishVideoEntry publishVideoEntry) {
        boolean z16;
        boolean booleanExtra = c7493b.f204011b.getBooleanExtra("local_import", false);
        int intExtra = c7493b.f204011b.getIntExtra("video_rotation", 0);
        boolean booleanExtra2 = c7493b.f204011b.getBooleanExtra("landscape_video", false);
        if (c7493b.f204011b.businessId == 14) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MergeEditVideo", 2, "before adjust rotation:", Integer.valueOf(intExtra), ", isLocalImport:", Boolean.valueOf(booleanExtra));
            QLog.d("MergeEditVideo", 2, "before adjust config: " + cVar.toString());
        }
        if (booleanExtra) {
            if (intExtra != 0) {
                cVar.f312569n = intExtra;
                if (z16) {
                    cVar.f312568m = 0;
                } else if (booleanExtra2) {
                    cVar.f312568m = 270;
                } else {
                    cVar.f312568m = 0;
                }
            }
            int i3 = cVar.f312559d;
            int i16 = cVar.f312560e;
            if (c7493b.f204011b.businessId != 14) {
                i3 = Math.min(i3, i16);
                i16 = Math.max(cVar.f312559d, cVar.f312560e);
            } else if (!publishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false) && booleanExtra2) {
                cVar.f312576u = false;
            } else {
                i3 = Math.min(cVar.f312559d, cVar.f312560e);
                i16 = Math.max(cVar.f312559d, cVar.f312560e);
            }
            int i17 = f204002c;
            if (i16 > i17) {
                i3 = (int) ((i3 * i17) / i16);
                i16 = i17;
            }
            cVar.f312559d = com.tencent.mobileqq.editor.composite.util.a.b(i3);
            int b16 = com.tencent.mobileqq.editor.composite.util.a.b(i16);
            cVar.f312560e = b16;
            int i18 = cVar.f312559d;
            decodeConfig.width = i18;
            decodeConfig.height = b16;
            if (cVar.f312574s) {
                int i19 = (int) ((i18 * 16.0f) / 9.0f);
                int i26 = f204002c;
                if (i19 > i26) {
                    i18 = (int) ((i18 * i26) / i19);
                    i19 = i26;
                }
                cVar.f312559d = com.tencent.mobileqq.editor.composite.util.a.b(i18);
                cVar.f312560e = com.tencent.mobileqq.editor.composite.util.a.b(i19);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + cVar.toString());
        }
    }

    public static boolean f(PublishVideoEntry publishVideoEntry) {
        if (publishVideoEntry.isLocalPublish && !publishVideoEntry.isMuteRecordVoice && TextUtils.isEmpty(publishVideoEntry.backgroundMusicPath)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int d(String str, String str2, C7493b c7493b, PublishVideoEntry publishVideoEntry) {
        PublishVideoEntry publishVideoEntry2;
        ArrayList<FilterDesc> arrayList;
        boolean z16;
        int a16;
        e eVar;
        com.tencent.mobileqq.videocodec.mediacodec.a bVar;
        MusicItemInfo musicItemInfo;
        PublishVideoEntry publishVideoEntry3;
        String str3 = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, str3, str2, c7493b, publishVideoEntry)).intValue();
        }
        int i3 = -1;
        if (c7493b == null || (publishVideoEntry2 = c7493b.f204011b) == null) {
            return -1;
        }
        c7493b.d(publishVideoEntry2.saveMode);
        boolean booleanExtra = c7493b.f204011b.getBooleanExtra("hasAVFilter", false);
        JSONArray jSONArrayExtra = c7493b.f204011b.getJSONArrayExtra("jsonAVFilterData");
        String stringExtra = c7493b.f204011b.getStringExtra("transfer_effect_data", null);
        boolean booleanExtra2 = c7493b.f204011b.getBooleanExtra("extra_is_need_gaussion_blur", false);
        if (jSONArrayExtra == null) {
            arrayList = null;
        } else {
            ArrayList<FilterDesc> parse = FilterDesc.parse(jSONArrayExtra);
            if (parse != null && !parse.isEmpty()) {
                arrayList = parse;
                if (c7493b.f204013d == 0 && c7493b.f204012c == 0) {
                    publishVideoEntry3 = c7493b.f204011b;
                    if (publishVideoEntry3.doodlePath == null && publishVideoEntry3.mosaicPath == null && !booleanExtra && stringExtra == null && !booleanExtra2) {
                        z16 = true;
                        d.a aVar = new d.a();
                        a16 = com.tencent.mobileqq.shortvideo.util.d.a(str3, aVar);
                        if (a16 == 0) {
                            return a16;
                        }
                        int[] iArr = aVar.f288248a;
                        int i16 = iArr[0];
                        int i17 = iArr[1];
                        int i18 = iArr[2];
                        if (!e(c7493b, publishVideoEntry, i16, i17, z16)) {
                            QLog.d("MergeEditVideo", 1, "mergeVideo reEncoder false");
                            return -1;
                        }
                        PublishVideoEntry publishVideoEntry4 = c7493b.f204011b;
                        int i19 = publishVideoEntry4.videoRangeStart;
                        int i26 = publishVideoEntry4.videoRangeEnd;
                        if (c7493b.f204013d == 5) {
                            str3 = publishVideoEntry4.mIFrameVideoPath;
                            i19 = 0;
                            i26 = 0;
                        }
                        if (arrayList != null) {
                            JSONObject jSONExtra = publishVideoEntry4.getJSONExtra("jsonMusicData");
                            if (jSONExtra != null) {
                                musicItemInfo = new MusicItemInfo(jSONExtra);
                            } else {
                                musicItemInfo = null;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("MergeEditVideo", 2, "getAVFilterJSONArray " + jSONArrayExtra.toString());
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("getMusicInfo id = ");
                                if (musicItemInfo != null) {
                                    i3 = musicItemInfo.mItemId;
                                }
                                sb5.append(i3);
                                QLog.d("MergeEditVideo", 2, sb5.toString());
                            }
                            eVar = new e(arrayList, musicItemInfo, i16, i17, null);
                        } else {
                            eVar = null;
                        }
                        if (!f(publishVideoEntry) && !publishVideoEntry.isMixOriginal) {
                            bVar = new com.tencent.mobileqq.videocodec.mediacodec.a();
                        } else {
                            QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
                            bVar = new com.tencent.mobileqq.videocodec.mediacodec.b();
                        }
                        com.tencent.mobileqq.videocodec.mediacodec.a aVar2 = bVar;
                        int i27 = c7493b.f204010a;
                        int i28 = c7493b.f204012c;
                        PublishVideoEntry publishVideoEntry5 = c7493b.f204011b;
                        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str2, i16, i17, i27, 1, 30, i28, false, i18, publishVideoEntry5.doodlePath, publishVideoEntry5.mosaicPath, null, c7493b.f204016g);
                        DecodeConfig decodeConfig = new DecodeConfig(str3, c7493b.f204013d, false, true, i19, i26);
                        decodeConfig.width = i16;
                        decodeConfig.height = i17;
                        cVar.f312574s = c7493b.f204011b.getBooleanExtra("extra_is_need_gaussion_blur", false);
                        c(c7493b, decodeConfig, cVar, publishVideoEntry);
                        decodeConfig.isLocal = c7493b.f204011b.getBooleanExtra("local_import", false);
                        decodeConfig.isLandscape = c7493b.f204011b.getBooleanExtra("landscape_video", false);
                        decodeConfig.adjustRotation = i18;
                        cVar.f312572q = c7493b.f204014e;
                        cVar.f312573r = c7493b.f204015f;
                        String stringExtra2 = c7493b.f204011b.getStringExtra("dynamic_Sticker_data", null);
                        if (stringExtra2 != null) {
                            aVar2.e(com.tencent.mobileqq.editor.composite.util.a.d(stringExtra2));
                        }
                        if (stringExtra != null) {
                            aVar2.f(stringExtra);
                        }
                        aVar2.g(decodeConfig, cVar, new a(eVar, cVar, publishVideoEntry, aVar2), eVar);
                        if (!this.f204004b) {
                            synchronized (this.f204003a) {
                                if (!this.f204004b) {
                                    try {
                                        LockMethodProxy.wait(this.f204003a);
                                    } catch (InterruptedException e16) {
                                        e16.printStackTrace();
                                    }
                                }
                            }
                        }
                        if (publishVideoEntry.isCancel) {
                            return -16;
                        }
                        if (aVar2.J != 0) {
                            return 1;
                        }
                        return 0;
                    }
                }
                z16 = false;
                d.a aVar3 = new d.a();
                a16 = com.tencent.mobileqq.shortvideo.util.d.a(str3, aVar3);
                if (a16 == 0) {
                }
            } else {
                arrayList = parse;
            }
        }
        booleanExtra = false;
        if (c7493b.f204013d == 0) {
            publishVideoEntry3 = c7493b.f204011b;
            if (publishVideoEntry3.doodlePath == null) {
                z16 = true;
                d.a aVar32 = new d.a();
                a16 = com.tencent.mobileqq.shortvideo.util.d.a(str3, aVar32);
                if (a16 == 0) {
                }
            }
        }
        z16 = false;
        d.a aVar322 = new d.a();
        a16 = com.tencent.mobileqq.shortvideo.util.d.a(str3, aVar322);
        if (a16 == 0) {
        }
    }

    public boolean e(C7493b c7493b, PublishVideoEntry publishVideoEntry, int i3, int i16, boolean z16) {
        boolean z17;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, c7493b, publishVideoEntry, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
        }
        if (!z16) {
            return true;
        }
        if (!publishVideoEntry.isLocalPublish) {
            return false;
        }
        if (publishVideoEntry.isMuteRecordVoice && TextUtils.isEmpty(publishVideoEntry.backgroundMusicPath)) {
            return true;
        }
        long c16 = com.tencent.mobileqq.editor.composite.util.a.c(publishVideoEntry.mLocalRawVideoDir);
        PublishVideoEntry publishVideoEntry2 = c7493b.f204011b;
        if (publishVideoEntry2.videoRangeStart <= 0 && publishVideoEntry2.videoRangeEnd >= c16) {
            int i18 = publishVideoEntry2.businessId;
            if (i18 != 11 && i18 != 12 && i18 != 14) {
                return false;
            }
            publishVideoEntry2.getBooleanExtra("landscape_video", false);
            if (Math.max(i3, i16) <= f204002c) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && ((i17 = c7493b.f204011b.businessId) == 11 || i17 == 12)) {
                return false;
            }
        }
        return true;
    }
}
