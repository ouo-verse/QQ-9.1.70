package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.f;
import com.tencent.aelight.camera.aioeditor.capture.text.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DynamicTextBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final String f66866d = "DynamicTextBuilder";

    /* renamed from: e, reason: collision with root package name */
    private static final Map<Integer, List<String>> f66867e;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Typeface> f66868a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Bitmap> f66869b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private DynamicTextConfigManager f66870c;

    static {
        HashMap hashMap = new HashMap();
        f66867e = hashMap;
        hashMap.put(0, Collections.singletonList(HardCodeUtil.qqStr(R.string.ymh)));
        hashMap.put(1, Collections.singletonList("Hi (\u2022\u03c9\u2022)"));
        hashMap.put(3, Collections.singletonList(HardCodeUtil.qqStr(R.string.luk)));
        hashMap.put(4, Collections.singletonList(HardCodeUtil.qqStr(R.string.lux)));
        hashMap.put(5, Arrays.asList(HardCodeUtil.qqStr(R.string.lu9), "MY JOURNEY"));
        hashMap.put(7, Collections.singletonList(HardCodeUtil.qqStr(R.string.lu8)));
        hashMap.put(8, Collections.singletonList(HardCodeUtil.qqStr(R.string.luu)));
        hashMap.put(11, Collections.singletonList(HardCodeUtil.qqStr(R.string.lup)));
        hashMap.put(15, Collections.singletonList(HardCodeUtil.qqStr(R.string.luq)));
        hashMap.put(16, Collections.singletonList(HardCodeUtil.qqStr(R.string.luc)));
        hashMap.put(17, Collections.singletonList(HardCodeUtil.qqStr(R.string.f171917lv0)));
        hashMap.put(19, Collections.singletonList(HardCodeUtil.qqStr(R.string.luv)));
        hashMap.put(20, Collections.singletonList("superich"));
        hashMap.put(21, Collections.singletonList(HardCodeUtil.qqStr(R.string.lul)));
        hashMap.put(24, Collections.singletonList("\u8857\u5934\uff0c\n\u827a\u672f\u5bb6\u3002"));
        hashMap.put(26, Collections.singletonList(HardCodeUtil.qqStr(R.string.lud)));
        hashMap.put(27, Arrays.asList("\u60a0\u95f2\u7684\n\u4e0b\u5348\u3002", "jenny"));
        hashMap.put(31, Collections.singletonList(HardCodeUtil.qqStr(R.string.ymk)));
        hashMap.put(30, Collections.singletonList(HardCodeUtil.qqStr(R.string.ymg)));
        hashMap.put(32, Collections.singletonList(HardCodeUtil.qqStr(R.string.ymj)));
        hashMap.put(33, Collections.singletonList(HardCodeUtil.qqStr(R.string.ymi)));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder.1
            @Override // java.lang.Runnable
            public void run() {
                String currentNickname = fr.b.a().getCurrentNickname();
                DynamicTextBuilder.f66867e.put(5, Arrays.asList(HardCodeUtil.qqStr(R.string.luj), "MY JOURNEY \n" + currentNickname));
                DynamicTextBuilder.f66867e.put(27, Arrays.asList("\u60a0\u95f2\u7684\n\u4e0b\u5348\u3002", currentNickname));
            }
        }, 5, null, false);
    }

    public static String d(int i3, int i16) {
        List<String> e16 = e(i3);
        if (e16 != null && i16 >= 0 && i16 < e16.size()) {
            return e16.get(i16);
        }
        return "";
    }

    public static List<String> e(int i3) {
        Map<Integer, List<String>> map = f66867e;
        if (map.containsKey(Integer.valueOf(i3))) {
            return map.get(Integer.valueOf(i3));
        }
        return null;
    }

    public static int f(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "getIconDrawable type is: " + i3);
        }
        switch (i3) {
            case 0:
            case 2:
            case 6:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 18:
            case 22:
            case 23:
            case 25:
            case 28:
            case 29:
            default:
                return R.drawable.ede;
            case 1:
                return R.drawable.f161659ed3;
            case 3:
                return R.drawable.ed5;
            case 4:
                return R.drawable.ed7;
            case 5:
                return R.drawable.ed6;
            case 7:
                return R.drawable.edi;
            case 8:
                return R.drawable.f161660ed4;
            case 11:
                return R.drawable.ecw;
            case 15:
                return R.drawable.ed9;
            case 16:
                return R.drawable.edc;
            case 17:
                return R.drawable.ed_;
            case 19:
                return R.drawable.f161658ed2;
            case 20:
                return R.drawable.edj;
            case 21:
                return R.drawable.edf;
            case 24:
                return R.drawable.edg;
            case 26:
                return R.drawable.eda;
            case 27:
                return R.drawable.edh;
            case 30:
                return R.drawable.ncq;
            case 31:
                return R.drawable.nct;
            case 32:
                return R.drawable.ncs;
            case 33:
                return R.drawable.ncr;
        }
    }

    public static List<String> h(List<String> list, DynamicTextItem dynamicTextItem) {
        ArrayList<String> s16 = dynamicTextItem.s();
        if (!s16.isEmpty()) {
            if (!TextUtils.isEmpty(s16.get(0))) {
                Iterator<String> it = s16.iterator();
                if (it.hasNext()) {
                    it.next();
                    int i3 = 1;
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next != null && next.equals(d(dynamicTextItem.v(), i3))) {
                            it.remove();
                        }
                        i3++;
                    }
                }
                if (list != null && !list.isEmpty()) {
                    int size = s16.size();
                    int size2 = list.size();
                    int min = Math.min(size, dynamicTextItem.o());
                    for (int i16 = 0; i16 < min && i16 < size2; i16++) {
                        if (s16.get(i16).equals(d(dynamicTextItem.v(), i16))) {
                            s16.set(i16, list.get(i16));
                        }
                    }
                    while (min < size2) {
                        s16.add(list.get(min));
                        min++;
                    }
                }
                return s16;
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends DynamicTextItem> T b(int i3, List<String> list) {
        Typeface typeface;
        DynamicTextConfigManager.DynamicTextConfigBean.a aVar;
        T wVar;
        T iVar;
        Typeface createFromFile;
        Typeface createFromFile2;
        Typeface typeface2;
        Typeface createFromFile3;
        List e16;
        if (this.f66870c == null) {
            this.f66870c = (DynamicTextConfigManager) fr.f.c(7);
        }
        List arrayList = new ArrayList();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        List list2 = (!arrayList.isEmpty() || (e16 = e(i3)) == null) ? arrayList : e16;
        DynamicTextConfigManager.DynamicTextConfigBean g16 = this.f66870c.g(String.valueOf(i3));
        Typeface typeface3 = null;
        if (g16 != null) {
            DynamicTextConfigManager.DynamicTextConfigBean.a aVar2 = g16.fontInfos.isEmpty() ? null : g16.fontInfos.get(0);
            typeface = aVar2 != null ? this.f66868a.get(aVar2.f66881c) : null;
            aVar = aVar2;
        } else {
            typeface = null;
            aVar = null;
        }
        switch (i3) {
            case 0:
                wVar = new w(i3, list2);
                break;
            case 1:
                Bitmap bitmap = this.f66869b.get(Integer.valueOf(R.drawable.eiz));
                if (typeface == null || bitmap == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e17) {
                        QLog.i(f66866d, 2, Log.getStackTraceString(e17));
                    }
                    bitmap = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.eiz);
                    this.f66869b.put(Integer.valueOf(R.drawable.eiz), bitmap);
                }
                iVar = new i(i3, list2, typeface, bitmap);
                wVar = iVar;
                break;
            case 2:
            case 6:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 18:
            case 22:
            case 23:
            case 25:
            case 28:
            case 29:
            default:
                String str = "invalid text type" + i3;
                if (QLog.isColorLevel()) {
                    QLog.i(f66866d, 2, "DynamicTextBuilder : " + str);
                }
                wVar = new w(i3, list2);
                break;
            case 3:
                Bitmap bitmap2 = this.f66869b.get(Integer.valueOf(R.drawable.edk));
                Bitmap bitmap3 = this.f66869b.get(Integer.valueOf(R.drawable.edl));
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e18) {
                        QLog.i(f66866d, 2, Log.getStackTraceString(e18));
                    }
                    bitmap2 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.edk);
                    bitmap3 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.edl);
                    this.f66869b.put(Integer.valueOf(R.drawable.edk), bitmap2);
                    this.f66869b.put(Integer.valueOf(R.drawable.edl), bitmap3);
                }
                Typeface typeface4 = typeface;
                iVar = new m(i3, list2, typeface4, bitmap2, bitmap3);
                typeface = typeface4;
                wVar = iVar;
                break;
            case 4:
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e19) {
                        QLog.i(f66866d, 2, Log.getStackTraceString(e19));
                    }
                }
                wVar = new ac(BaseApplication.getContext(), i3, list2, typeface);
                break;
            case 5:
                Bitmap bitmap4 = this.f66869b.get(Integer.valueOf(R.drawable.eg6));
                Bitmap bitmap5 = this.f66869b.get(Integer.valueOf(R.drawable.eg5));
                if (bitmap4 == null) {
                    bitmap4 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.eg6);
                    bitmap5 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.eg5);
                }
                iVar = new p(i3, list2, bitmap4, bitmap5);
                wVar = iVar;
                break;
            case 7:
                Bitmap bitmap6 = this.f66869b.get(Integer.valueOf(R.drawable.ej5));
                if (bitmap6 == null) {
                    bitmap6 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.ej5);
                    this.f66869b.put(Integer.valueOf(R.drawable.ej5), bitmap6);
                }
                Bitmap bitmap7 = this.f66869b.get(Integer.valueOf(R.drawable.ej6));
                if (bitmap7 == null) {
                    bitmap7 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.ej6);
                    this.f66869b.put(Integer.valueOf(R.drawable.ej6), bitmap7);
                }
                Bitmap bitmap8 = this.f66869b.get(Integer.valueOf(R.drawable.ej7));
                if (bitmap8 == null) {
                    bitmap8 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.ej7);
                    this.f66869b.put(Integer.valueOf(R.drawable.ej7), bitmap8);
                }
                ArrayList arrayList2 = new ArrayList(3);
                arrayList2.add(bitmap6);
                arrayList2.add(bitmap7);
                arrayList2.add(bitmap8);
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e26) {
                        if (QLog.isColorLevel()) {
                            QLog.i(f66866d, 2, e26.getMessage(), e26);
                        }
                    }
                }
                wVar = new ae(i3, typeface, list2, arrayList2);
                break;
            case 8:
                Bitmap bitmap9 = this.f66869b.get(Integer.valueOf(R.drawable.efs));
                if (bitmap9 == null) {
                    bitmap9 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.efs);
                    this.f66869b.put(Integer.valueOf(R.drawable.efs), bitmap9);
                }
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (RuntimeException e27) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f66866d, 2, Log.getStackTraceString(e27));
                        }
                    }
                }
                iVar = new k(i3, list2, typeface, bitmap9);
                wVar = iVar;
                break;
            case 11:
                Bitmap bitmap10 = this.f66869b.get(Integer.valueOf(R.drawable.ecx));
                Bitmap bitmap11 = this.f66869b.get(Integer.valueOf(R.drawable.ecz));
                Bitmap bitmap12 = this.f66869b.get(Integer.valueOf(R.drawable.ecy));
                if (bitmap10 == null) {
                    bitmap10 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.ecx);
                    bitmap11 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.ecz);
                    bitmap12 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.ecy);
                }
                Bitmap bitmap13 = bitmap11;
                Bitmap bitmap14 = bitmap12;
                if (typeface == null) {
                    try {
                        createFromFile = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e28) {
                        QLog.i(f66866d, 2, Log.getStackTraceString(e28));
                    }
                    typeface = createFromFile;
                    wVar = new b(i3, list2, createFromFile, bitmap10, bitmap13, bitmap14);
                    break;
                }
                createFromFile = typeface;
                typeface = createFromFile;
                wVar = new b(i3, list2, createFromFile, bitmap10, bitmap13, bitmap14);
            case 15:
                Bitmap bitmap15 = this.f66869b.get(Integer.valueOf(R.drawable.ed8));
                if (bitmap15 == null) {
                    bitmap15 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.ed8);
                    this.f66869b.put(Integer.valueOf(R.drawable.ed8), bitmap15);
                }
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e29) {
                        QLog.i(f66866d, 2, Log.getStackTraceString(e29));
                    }
                }
                iVar = new l(i3, list2, typeface, bitmap15);
                wVar = iVar;
                break;
            case 16:
                Bitmap bitmap16 = this.f66869b.get(Integer.valueOf(R.drawable.edb));
                if (bitmap16 == null) {
                    bitmap16 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.edb);
                    this.f66869b.put(Integer.valueOf(R.drawable.edb), bitmap16);
                }
                Bitmap bitmap17 = bitmap16;
                if (typeface == null) {
                    try {
                        createFromFile2 = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e36) {
                        QLog.i(f66866d, 2, Log.getStackTraceString(e36));
                    }
                    if (g16 != null && g16.fontInfos.size() > 1 && g16.fontInfos.get(1) != null && !TextUtils.isEmpty(g16.fontInfos.get(1).f66881c) && (typeface3 = this.f66868a.get(g16.fontInfos.get(1).f66881c)) == null) {
                        try {
                            typeface2 = Typeface.createFromFile(this.f66870c.k(g16.fontInfos.get(1)) + "dynamic_text.ttf");
                        } catch (Exception e37) {
                            QLog.i(f66866d, 2, Log.getStackTraceString(e37));
                        }
                        wVar = new q(i3, list2, createFromFile2, typeface2, bitmap17);
                        typeface = createFromFile2;
                        break;
                    }
                    typeface2 = typeface3;
                    wVar = new q(i3, list2, createFromFile2, typeface2, bitmap17);
                    typeface = createFromFile2;
                }
                createFromFile2 = typeface;
                if (g16 != null) {
                    typeface2 = Typeface.createFromFile(this.f66870c.k(g16.fontInfos.get(1)) + "dynamic_text.ttf");
                    wVar = new q(i3, list2, createFromFile2, typeface2, bitmap17);
                    typeface = createFromFile2;
                }
                typeface2 = typeface3;
                wVar = new q(i3, list2, createFromFile2, typeface2, bitmap17);
                typeface = createFromFile2;
            case 17:
                Bitmap bitmap18 = this.f66869b.get(Integer.valueOf(R.drawable.f161668ej0));
                if (bitmap18 == null) {
                    bitmap18 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161668ej0);
                    this.f66869b.put(Integer.valueOf(R.drawable.f161668ej0), bitmap18);
                }
                Bitmap bitmap19 = this.f66869b.get(Integer.valueOf(R.drawable.f161669ej1));
                if (bitmap19 == null) {
                    bitmap19 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161669ej1);
                    this.f66869b.put(Integer.valueOf(R.drawable.f161669ej1), bitmap19);
                }
                ArrayList arrayList3 = new ArrayList(3);
                arrayList3.add(bitmap18);
                arrayList3.add(bitmap19);
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e38) {
                        QLog.i(f66866d, 2, Log.getStackTraceString(e38));
                    }
                }
                wVar = new n(i3, list2, typeface, arrayList3);
                break;
            case 19:
                if (typeface == null) {
                    if (com.tencent.mobileqq.filemanager.util.q.p(this.f66870c.k(aVar) + "dynamic_text.ttf")) {
                        try {
                            typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                        } catch (Exception e39) {
                            QLog.i(f66866d, 2, Log.getStackTraceString(e39));
                        }
                    }
                }
                wVar = new h(i3, list2, typeface);
                break;
            case 20:
                if (typeface == null) {
                    if (com.tencent.mobileqq.filemanager.util.q.p(this.f66870c.k(aVar) + "dynamic_text.ttf")) {
                        try {
                            typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                        } catch (Exception e46) {
                            if (QLog.isColorLevel()) {
                                QLog.i(f66866d, 2, e46.toString());
                            }
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i(f66866d, 2, "added new rich super : ");
                }
                wVar = new ah(i3, list2, typeface);
                break;
            case 21:
                Bitmap bitmap20 = this.f66869b.get(Integer.valueOf(R.drawable.f161670ej2));
                if (bitmap20 == null) {
                    bitmap20 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161670ej2);
                    this.f66869b.put(Integer.valueOf(R.drawable.f161670ej2), bitmap20);
                }
                Bitmap bitmap21 = this.f66869b.get(Integer.valueOf(R.drawable.f161671ej3));
                if (bitmap21 == null) {
                    bitmap21 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161671ej3);
                    this.f66869b.put(Integer.valueOf(R.drawable.f161671ej3), bitmap21);
                }
                Bitmap bitmap22 = this.f66869b.get(Integer.valueOf(R.drawable.f161672ej4));
                if (bitmap22 == null) {
                    bitmap22 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161672ej4);
                    this.f66869b.put(Integer.valueOf(R.drawable.f161672ej4), bitmap22);
                }
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e47) {
                        if (QLog.isColorLevel()) {
                            QLog.i(f66866d, 2, e47.getMessage(), e47);
                        }
                    }
                }
                f b16 = new f.a().e(10.0f, 12.0f).d(bitmap20).f(41.0f, 36.0f, 1, 1).g(typeface).b();
                f b17 = new f.a().e(12.0f, 21.0f).d(bitmap21).f(123.0f, 33.0f, 7, 2).g(typeface).b();
                f b18 = new f.a().e(10.0f, 27.0f).d(bitmap22).f(192.0f, 43.0f, 10, 8).g(typeface).b();
                g.b bVar = new g.b();
                bVar.a(b16);
                bVar.a(b17);
                bVar.a(b18);
                bVar.d(typeface);
                bVar.c(-16777216);
                wVar = bVar.b(i3, list2);
                break;
            case 24:
                if (typeface == null) {
                    try {
                        typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e48) {
                        if (QLog.isColorLevel()) {
                            QLog.i(f66866d, 2, e48.getMessage(), e48);
                        }
                    }
                }
                wVar = new ab(i3, list2, typeface);
                break;
            case 26:
                Bitmap bitmap23 = this.f66869b.get(Integer.valueOf(R.drawable.f161657ed1));
                if (bitmap23 == null) {
                    bitmap23 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161657ed1);
                    this.f66869b.put(Integer.valueOf(R.drawable.f161657ed1), bitmap23);
                }
                Bitmap bitmap24 = this.f66869b.get(Integer.valueOf(R.drawable.f161656ed0));
                if (bitmap24 == null) {
                    bitmap24 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161656ed0);
                    this.f66869b.put(Integer.valueOf(R.drawable.f161656ed0), bitmap24);
                }
                if (typeface == null) {
                    try {
                        createFromFile3 = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                    } catch (Exception e49) {
                        if (QLog.isColorLevel()) {
                            QLog.i(f66866d, 2, e49.getMessage(), e49);
                        }
                    }
                    typeface = createFromFile3;
                    wVar = new o(i3, list2, bitmap24, bitmap23, createFromFile3);
                    break;
                }
                createFromFile3 = typeface;
                typeface = createFromFile3;
                wVar = new o(i3, list2, bitmap24, bitmap23, createFromFile3);
            case 27:
                if (typeface == null) {
                    if (com.tencent.mobileqq.filemanager.util.q.p(this.f66870c.k(aVar) + "dynamic_text.ttf")) {
                        try {
                            typeface = Typeface.createFromFile(this.f66870c.k(aVar) + "dynamic_text.ttf");
                        } catch (Exception e56) {
                            if (QLog.isColorLevel()) {
                                QLog.i(f66866d, 2, e56.toString());
                            }
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i(f66866d, 2, "added new rich super : ");
                }
                wVar = new ad(i3, list2, typeface);
                break;
            case 30:
                wVar = new s(i3, list2);
                break;
            case 31:
                wVar = new t(i3, list2);
                break;
            case 32:
                wVar = new v(i3, list2);
                break;
            case 33:
                wVar = new u(i3, list2);
                break;
        }
        if (typeface != null && this.f66868a.get(Integer.valueOf(i3)) == null && aVar != null) {
            this.f66868a.put(aVar.f66881c, typeface);
        }
        return wVar;
    }

    public int g(DynamicTextItem dynamicTextItem) {
        if (w.class.isInstance(dynamicTextItem)) {
            if (dynamicTextItem instanceof t) {
                return 31;
            }
            if (dynamicTextItem instanceof v) {
                return 32;
            }
            if (dynamicTextItem instanceof s) {
                return 30;
            }
            if (u.class.isInstance(dynamicTextItem)) {
                return 33;
            }
        } else {
            if (i.class.isInstance(dynamicTextItem)) {
                return 1;
            }
            if (m.class.isInstance(dynamicTextItem)) {
                return 3;
            }
            if (ac.class.isInstance(dynamicTextItem)) {
                return 4;
            }
            if (p.class.isInstance(dynamicTextItem)) {
                return 5;
            }
            if (ae.class.isInstance(dynamicTextItem)) {
                return 7;
            }
            if (k.class.isInstance(dynamicTextItem)) {
                return 8;
            }
            if (b.class.isInstance(dynamicTextItem)) {
                return 11;
            }
            if (n.class.isInstance(dynamicTextItem)) {
                return 17;
            }
            if (l.class.isInstance(dynamicTextItem)) {
                return 15;
            }
            if (q.class.isInstance(dynamicTextItem)) {
                return 16;
            }
            if (h.class.isInstance(dynamicTextItem)) {
                return 19;
            }
            if (o.class.isInstance(dynamicTextItem)) {
                return 26;
            }
            if (ah.class.isInstance(dynamicTextItem)) {
                return 20;
            }
            if (ab.class.isInstance(dynamicTextItem)) {
                return 24;
            }
            if (ad.class.isInstance(dynamicTextItem)) {
                return 27;
            }
            if (g.class.isInstance(dynamicTextItem)) {
                return ((g) dynamicTextItem).v();
            }
        }
        return 0;
    }

    public static String c(int i3) {
        switch (i3) {
            case 0:
                return HardCodeUtil.qqStr(R.string.lun);
            case 1:
                return "Hi";
            case 2:
            case 6:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 18:
            case 22:
            case 23:
            case 25:
            default:
                return null;
            case 3:
                return HardCodeUtil.qqStr(R.string.lum);
            case 4:
                return HardCodeUtil.qqStr(R.string.lut);
            case 5:
                return HardCodeUtil.qqStr(R.string.luo);
            case 7:
                return HardCodeUtil.qqStr(R.string.lus);
            case 8:
                return HardCodeUtil.qqStr(R.string.lur);
            case 11:
                return HardCodeUtil.qqStr(R.string.lue);
            case 15:
                return HardCodeUtil.qqStr(R.string.lub);
            case 16:
                return HardCodeUtil.qqStr(R.string.luz);
            case 17:
                return HardCodeUtil.qqStr(R.string.lu_);
            case 19:
                return HardCodeUtil.qqStr(R.string.luh);
            case 20:
                return "superich";
            case 21:
                return HardCodeUtil.qqStr(R.string.lug);
            case 24:
                return HardCodeUtil.qqStr(R.string.lui);
            case 26:
                return HardCodeUtil.qqStr(R.string.luw);
            case 27:
                return HardCodeUtil.qqStr(R.string.luf);
        }
    }
}
