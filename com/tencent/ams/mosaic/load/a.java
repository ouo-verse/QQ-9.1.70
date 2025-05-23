package com.tencent.ams.mosaic.load;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static d a() {
        e eVar = new e("https://xsweb.gdt.qq.com/resources/mosaic/quickjs-so/1.1.2/arm64-v8a/libquickjs-android.so", "2c0bb1422cbd73a4827e1096fc1443ae", "libquickjs-android", 0);
        e eVar2 = new e("https://xsweb.gdt.qq.com/resources/mosaic/quickjs-so/1.1.2/armeabi-v7a/libquickjs-android.so", "5000ae6fe389f8dbcbb44b7638b06036", "libquickjs-android", 0);
        e eVar3 = new e("https://xsweb.gdt.qq.com/resources/mosaic/quickjs-so/1.1.2/armeabi/libquickjs-android.so", "d61751163964398ab18cb778ee4f2f81", "libquickjs-android", 0);
        e eVar4 = new e("https://xsweb.gdt.qq.com/resources/mosaic/quickjs-so/1.1.2/x86_64/libquickjs-android.so", "284a78114f8592e7058c6e80240992f3", "libquickjs-android", 0);
        e eVar5 = new e("https://xsweb.gdt.qq.com/resources/mosaic/quickjs-so/1.1.2/x86/libquickjs-android.so", "b2808df37ab69e35ba806349c905e546", "libquickjs-android", 0);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        arrayList.add(eVar);
        arrayList2.add(eVar2);
        arrayList3.add(eVar3);
        arrayList4.add(eVar5);
        arrayList5.add(eVar4);
        return new d("1.1.2", arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }
}
