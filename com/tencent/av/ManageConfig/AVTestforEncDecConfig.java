package com.tencent.av.ManageConfig;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.av.ManageConfig.a;
import com.tencent.av.utils.e;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVTestforEncDecConfig extends QAVConfigBase<a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        HashMap<Integer, c> f72796a = new HashMap<>();

        public String toString() {
            return "size[" + this.f72796a.size() + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f72797a;

        /* renamed from: b, reason: collision with root package name */
        public String f72798b;

        /* renamed from: c, reason: collision with root package name */
        public String f72799c;

        /* renamed from: d, reason: collision with root package name */
        public int f72800d;

        /* renamed from: e, reason: collision with root package name */
        public int f72801e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f72802f;

        /* renamed from: g, reason: collision with root package name */
        public int f72803g;

        /* renamed from: h, reason: collision with root package name */
        public int f72804h;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Sample{");
            stringBuffer.append("md5='");
            stringBuffer.append(this.f72797a);
            stringBuffer.append('\'');
            stringBuffer.append(", url=");
            stringBuffer.append(this.f72798b);
            stringBuffer.append(", exp=");
            stringBuffer.append(this.f72799c);
            stringBuffer.append(", w=");
            stringBuffer.append(this.f72800d);
            stringBuffer.append(", h=");
            stringBuffer.append(this.f72801e);
            stringBuffer.append(", upload=");
            stringBuffer.append(this.f72802f);
            stringBuffer.append(", bitrate=");
            stringBuffer.append(this.f72803g);
            stringBuffer.append(", fps = ");
            stringBuffer.append(this.f72804h);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: h, reason: collision with root package name */
        public HashMap<String, b> f72812h;

        /* renamed from: a, reason: collision with root package name */
        public int f72805a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f72806b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f72807c = 0;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<Integer> f72808d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f72809e = 0;

        /* renamed from: f, reason: collision with root package name */
        public String f72810f = null;

        /* renamed from: g, reason: collision with root package name */
        public int f72811g = 0;

        /* renamed from: i, reason: collision with root package name */
        public boolean f72813i = false;

        /* renamed from: j, reason: collision with root package name */
        public long f72814j = 0;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("TestInfo{");
            stringBuffer.append("taskId='");
            stringBuffer.append(this.f72805a);
            stringBuffer.append('\'');
            stringBuffer.append(", codec=");
            stringBuffer.append(this.f72806b);
            stringBuffer.append(", min_sdk=");
            stringBuffer.append(this.f72807c);
            stringBuffer.append(", async_min_sdk=");
            stringBuffer.append(this.f72809e);
            stringBuffer.append(", min_version=");
            stringBuffer.append(this.f72810f);
            stringBuffer.append(", test_ver=");
            stringBuffer.append(this.f72811g);
            if (this.f72808d != null) {
                stringBuffer.append(", disable_sdks=");
                stringBuffer.append(Arrays.toString(this.f72808d.toArray()));
            }
            HashMap<String, b> hashMap = this.f72812h;
            if (hashMap != null) {
                for (Map.Entry<String, b> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    b value = entry.getValue();
                    stringBuffer.append(", codecKey=");
                    stringBuffer.append(key);
                    stringBuffer.append(", codecValue=");
                    stringBuffer.append(value);
                }
            }
            stringBuffer.append(", upload = ");
            stringBuffer.append(this.f72813i);
            stringBuffer.append(", expdate = ");
            stringBuffer.append(this.f72814j);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public AVTestforEncDecConfig() {
        super(431);
    }

    static c d(a.C0728a c0728a) {
        long j3;
        ArrayList<Integer> arrayList;
        ArrayList<Integer> arrayList2;
        int i3 = c0728a.f72819b;
        int i16 = 4;
        int i17 = 1;
        if (i3 != 1 && i3 != 2 && i3 != 4 && i3 != 8) {
            return null;
        }
        int i18 = c0728a.f72820c;
        if (i18 <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.w("QAVConfig_431", 1, "min_sdk\u4e0d\u5408\u6cd5, codec[" + i3 + "], min_sdk[" + i18 + "]");
            }
            return null;
        }
        int i19 = c0728a.f72821d;
        if (i19 < 0) {
            if (QLog.isDevelopLevel()) {
                QLog.w("QAVConfig_431", 1, "async_min_sdk\u4e0d\u5408\u6cd5, codec[" + i3 + "], async_min_sdk[" + i19 + "]");
            }
            return null;
        }
        String str = c0728a.f72818a;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isDevelopLevel()) {
                QLog.w("QAVConfig_431", 1, "min_version\u4e0d\u5408\u6cd5, codec[" + i3 + "], min_version[" + str + "]");
            }
            return null;
        }
        int i26 = c0728a.f72824g;
        if (i26 <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.w("QAVConfig_431", 1, "test_ver\u4e0d\u5408\u6cd5, codec[" + i3 + "], test_ver[" + i26 + "]");
            }
            return null;
        }
        List<a.C0728a.C0729a> list = c0728a.f72825h;
        if (list != null && list.size() != 0) {
            try {
                String str2 = c0728a.f72826i;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
                j3 = simpleDateFormat.parse(str2).getTime();
            } catch (Exception unused) {
                QLog.w("QAVConfig_431", 1, "\u6ca1\u6709\u8fc7\u671f\u65f6\u95f4, codec[" + i3 + "], expdate[" + c0728a.f72826i + "]");
                j3 = 0;
            }
            HashMap<String, b> hashMap = new HashMap<>();
            for (a.C0728a.C0729a c0729a : c0728a.f72825h) {
                if (!TextUtils.isEmpty(c0729a.f72831e) && !TextUtils.isEmpty(c0729a.f72830d)) {
                    if (i3 != i17 && i3 != i16) {
                        if ((i3 == 2 || i3 == 8) && (c0729a.f72827a == 0 || c0729a.f72828b == 0)) {
                            QLog.w("QAVConfig_431", i17, "w/h \u4e3a\u7a7a, codec[" + i3 + "]");
                            i16 = 4;
                        }
                        b bVar = new b();
                        bVar.f72798b = c0729a.f72830d;
                        bVar.f72799c = c0729a.f72829c;
                        String str3 = c0729a.f72831e;
                        bVar.f72797a = str3;
                        bVar.f72800d = c0729a.f72827a;
                        bVar.f72801e = c0729a.f72828b;
                        bVar.f72802f = c0728a.f72822e;
                        hashMap.put(str3, bVar);
                        i16 = 4;
                        i17 = 1;
                    } else if (TextUtils.isEmpty(c0729a.f72829c)) {
                        QLog.w("QAVConfig_431", i17, "exp \u4e3a\u7a7a, codec[" + i3 + "]");
                        i16 = 4;
                    } else {
                        b bVar2 = new b();
                        bVar2.f72798b = c0729a.f72830d;
                        bVar2.f72799c = c0729a.f72829c;
                        String str32 = c0729a.f72831e;
                        bVar2.f72797a = str32;
                        bVar2.f72800d = c0729a.f72827a;
                        bVar2.f72801e = c0729a.f72828b;
                        bVar2.f72802f = c0728a.f72822e;
                        hashMap.put(str32, bVar2);
                        i16 = 4;
                        i17 = 1;
                    }
                }
            }
            if (hashMap.size() == 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.w("QAVConfig_431", 1, "\u6837\u672c\u4e0d\u591f, codec[" + i3 + "]");
                    return null;
                }
                return null;
            }
            List<Integer> list2 = c0728a.f72823f;
            if (list2 != null && list2.size() > 0) {
                ArrayList<Integer> arrayList3 = null;
                for (int i27 = 0; i27 < c0728a.f72823f.size(); i27++) {
                    int intValue = c0728a.f72823f.get(i27).intValue();
                    if (intValue > 0) {
                        if (arrayList3 == null) {
                            arrayList2 = new ArrayList<>();
                        } else {
                            arrayList2 = arrayList3;
                        }
                        arrayList2.add(Integer.valueOf(intValue));
                        arrayList3 = arrayList2;
                    }
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            c cVar = new c();
            cVar.f72812h = hashMap;
            cVar.f72808d = arrayList;
            cVar.f72807c = i18;
            cVar.f72809e = i19;
            cVar.f72806b = i3;
            cVar.f72810f = str;
            cVar.f72811g = i26;
            cVar.f72813i = c0728a.f72822e;
            cVar.f72814j = j3;
            return cVar;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("QAVConfig_431", 1, "\u6ca1\u6709\u6837\u672c, codec[" + i3 + "]");
            return null;
        }
        return null;
    }

    public static c e(int i3) {
        String str;
        HashMap<Integer, c> hashMap = ((a) am.s().x(431)).f72796a;
        if (hashMap == null) {
            return null;
        }
        c cVar = hashMap.get(Integer.valueOf(i3));
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadTestInfo, content[");
            if (cVar != null) {
                str = cVar.toString();
            } else {
                str = "";
            }
            sb5.append(str);
            sb5.append("]");
            QLog.w("QAVConfig_431", 1, sb5.toString());
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + i3 + "]");
        }
        return new a();
    }

    @Override // com.tencent.av.ManageConfig.QAVConfigBase, com.tencent.mobileqq.config.l
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        super.onUpdate(aVar);
        int g16 = am.s().g(431, "");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", ((QQAppInterface) runtime).getCurrentAccountUin());
            hashMap.put("ver", g16 + "");
            hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
            int[] iArr = {1, 2, 4, 8};
            for (int i3 = 0; i3 < 4; i3++) {
                int i16 = iArr[i3];
                c cVar = aVar.f72796a.get(Integer.valueOf(i16));
                if (cVar != null) {
                    int b16 = uu.a.b(cVar);
                    hashMap.put("test" + i16, "1");
                    hashMap.put("test" + i16 + "_ver", cVar.f72811g + "");
                    hashMap.put("test" + i16 + "_flag", b16 + "");
                }
            }
            UserAction.onUserAction("qav_codec_config", true, -1L, -1L, hashMap, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ManageConfig.QAVConfigBase
    @Nullable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a parsed(ai[] aiVarArr) throws Exception {
        boolean z16;
        a aVar = new a();
        for (ai aiVar : aiVarArr) {
            com.tencent.av.ManageConfig.a a16 = com.tencent.av.ManageConfig.a.a(aiVar.f202268b);
            if (a16 != null && a16.f72817a != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (e.k()) {
                QLog.w("QAVConfig_431", 1, "parsed, taskId[" + aiVar.f202267a + "], suc[" + z16 + "], oldVersion[" + a() + "], content[" + aiVar.f202268b + "]");
            }
            if (z16) {
                for (a.C0728a c0728a : a16.f72817a) {
                    c d16 = d(c0728a);
                    if (d16 == null) {
                        if (e.k()) {
                            QLog.w("QAVConfig_431", 1, "parsed, \u6570\u636e\u4e0d\u5408\u6cd5");
                        }
                    } else {
                        if (aVar.f72796a.containsKey(Integer.valueOf(c0728a.f72819b))) {
                            c cVar = aVar.f72796a.get(Integer.valueOf(c0728a.f72819b));
                            QLog.w("QAVConfig_431", 1, "parsed, \u6570\u636e\u5df2\u5b58\u5728, codec[" + c0728a.f72819b + "], _taskId[" + cVar.f72805a + "], _test_ver[" + cVar.f72811g + "], taskId[" + aiVar.f202267a + "], test_ver[" + d16.f72811g + "]");
                            if (d16.f72811g <= cVar.f72811g) {
                            }
                        }
                        d16.f72805a = aiVar.f202267a;
                        aVar.f72796a.put(Integer.valueOf(c0728a.f72819b), d16);
                    }
                }
            }
        }
        return aVar;
    }
}
