package cr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n15.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* compiled from: P */
    /* renamed from: cr.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10136a {

        /* renamed from: a, reason: collision with root package name */
        String f391682a;

        /* renamed from: b, reason: collision with root package name */
        int f391683b;

        /* renamed from: c, reason: collision with root package name */
        long f391684c;

        public C10136a(String str, int i3, long j3) {
            this.f391682a = str;
            this.f391684c = j3;
            this.f391683b = i3;
        }
    }

    public Bitmap a(String str, long j3, int i3) {
        try {
            return c.f418006a.c(str, j3, i3);
        } catch (Exception unused) {
            return b(str, j3);
        }
    }

    public Bitmap b(String str, long j3) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        Bitmap createBitmap = Bitmap.createBitmap(mediaMetadataRetriever.getFrameAtTime(j3, 3));
        mediaMetadataRetriever.release();
        return createBitmap;
    }

    public List<Bitmap> c(List<C10136a> list, List<Long> list2, int i3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<C10136a> it = list.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().f391684c;
            arrayList2.add(Long.valueOf(j3));
        }
        if (list2 != null && !list2.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(list2);
            int i16 = 0;
            for (int i17 = 0; i17 < arrayList3.size(); i17++) {
                while (((Long) arrayList2.get(i16)).longValue() <= ((Long) arrayList3.get(i17)).longValue() && (i16 = i16 + 1) < arrayList2.size()) {
                }
                if (i16 >= arrayList2.size()) {
                    break;
                }
                if (((Long) arrayList2.get(i16)).longValue() > ((Long) arrayList3.get(i17)).longValue()) {
                    if (list.get(i16).f391683b == 2) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        int i18 = 1;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(list.get(i16).f391682a, options);
                        int i19 = options.outWidth;
                        int i26 = options.outHeight;
                        if (i3 > 0) {
                            if (i26 > i19) {
                                if (i26 > i3) {
                                    i18 = i26 / i3;
                                }
                            } else if (i19 > i3) {
                                i18 = i19 / i3;
                            }
                        }
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inJustDecodeBounds = false;
                        options2.inSampleSize = i18;
                        arrayList.add(BitmapFactory.decodeFile(list.get(i16).f391682a, options2));
                    } else {
                        arrayList.add(a(list.get(i16).f391682a, ((Long) arrayList3.get(i17)).longValue(), i3));
                    }
                }
            }
        }
        return arrayList;
    }
}
