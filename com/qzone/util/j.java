package com.qzone.util;

import android.os.Parcel;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qzonehub.api.IDataUtils;
import cooperation.qzone.cache.CacheManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static final j f59822b = new j();

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, VideoInfo> f59823a = new HashMap<>();

    public j() {
        c();
    }

    public static final j b() {
        return f59822b;
    }

    public VideoInfo a(String str) {
        synchronized (this.f59823a) {
            if (str == null) {
                return null;
            }
            VideoInfo videoInfo = this.f59823a.get(str);
            if (videoInfo != null) {
                videoInfo.lastUseTime = System.currentTimeMillis();
            }
            return videoInfo;
        }
    }

    public void d(String str, VideoInfo videoInfo) {
        synchronized (this.f59823a) {
            if (str != null) {
                if (!this.f59823a.containsKey(str) && videoInfo != null) {
                    videoInfo.lastUseTime = System.currentTimeMillis();
                    this.f59823a.put(str, videoInfo);
                    f();
                }
            }
        }
    }

    public void e(String str) {
        VideoInfo remove;
        synchronized (this.f59823a) {
            if (str != null) {
                if (this.f59823a.containsKey(str) && (remove = this.f59823a.remove(str)) != null) {
                    remove.lastUseTime = 0L;
                    f();
                }
            }
        }
    }

    private void c() {
        BufferedInputStream bufferedInputStream;
        Throwable th5;
        ByteArrayOutputStream byteArrayOutputStream;
        int i3;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(CacheManager.getInternalCacheDir("video_feed_cache"))));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException | Exception unused) {
            } catch (Throwable th6) {
                byteArrayOutputStream = null;
                th5 = th6;
            }
        } catch (FileNotFoundException | Exception unused2) {
            bufferedInputStream = null;
        } catch (Throwable th7) {
            bufferedInputStream = null;
            th5 = th7;
            byteArrayOutputStream = null;
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 4096);
                    if (read <= 0) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                HashMap hashMap = new HashMap();
                obtain.readMap(hashMap, j.class.getClassLoader());
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(hashMap.entrySet());
                int size = arrayList.size();
                if (size > 1) {
                    Collections.sort(arrayList, new a());
                }
                if (size > 100) {
                    size = 100;
                }
                synchronized (this.f59823a) {
                    for (i3 = 0; i3 < size; i3++) {
                        Map.Entry entry = (Map.Entry) arrayList.get(i3);
                        this.f59823a.put((String) entry.getKey(), (VideoInfo) entry.getValue());
                    }
                }
                OaidMonitor.parcelRecycle(obtain);
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(byteArrayOutputStream);
            } catch (FileNotFoundException | Exception unused3) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(byteArrayOutputStream2);
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedInputStream);
            }
            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedInputStream);
        } catch (Throwable th8) {
            th5 = th8;
            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(byteArrayOutputStream);
            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedInputStream);
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        Throwable th5;
        Parcel parcel;
        Parcel parcel2;
        BufferedOutputStream bufferedOutputStream;
        Parcel parcel3 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(CacheManager.getInternalCacheDir("video_feed_cache")), false));
            } catch (Exception unused) {
                parcel2 = null;
            } catch (Throwable th6) {
                th5 = th6;
                parcel = null;
            }
            try {
                parcel3 = Parcel.obtain();
                synchronized (this.f59823a) {
                    parcel3.writeMap(this.f59823a);
                }
                bufferedOutputStream.write(parcel3.marshall());
                bufferedOutputStream.flush();
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                OaidMonitor.parcelRecycle(parcel3);
            } catch (Exception unused2) {
                parcel2 = parcel3;
                parcel3 = bufferedOutputStream;
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(parcel3);
                if (parcel2 != null) {
                    OaidMonitor.parcelRecycle(parcel2);
                }
            } catch (Throwable th7) {
                parcel = parcel3;
                parcel3 = bufferedOutputStream;
                th5 = th7;
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(parcel3);
                if (parcel != null) {
                    try {
                        OaidMonitor.parcelRecycle(parcel);
                        throw th5;
                    } catch (Throwable unused3) {
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (Throwable unused4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Comparator<Map.Entry<String, VideoInfo>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, VideoInfo> entry, Map.Entry<String, VideoInfo> entry2) {
            long j3 = (entry == null || entry.getValue() == null) ? 0L : entry.getValue().lastUseTime;
            long j16 = (entry2 == null || entry2.getValue() == null) ? 0L : entry2.getValue().lastUseTime;
            if (j3 == j16) {
                return 0;
            }
            return j3 - j16 > 0 ? 1 : -1;
        }
    }
}
