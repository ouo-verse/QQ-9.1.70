package com.qzone.business.tianshu;

import android.text.TextUtils;
import com.qzone.business.plusunion.plusoperation.PlusMenuContainerNew;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class o extends b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile o f44885c;

    /* renamed from: b, reason: collision with root package name */
    private QZoneBubbleInfo f44886b;

    public static o i() {
        if (f44885c == null) {
            synchronized (o.class) {
                if (f44885c == null) {
                    f44885c = new o();
                }
            }
        }
        return f44885c;
    }

    @Override // com.qzone.business.tianshu.b
    int b() {
        return 990;
    }

    @Override // com.qzone.business.tianshu.b
    List<Integer> c() {
        return null;
    }

    @Override // com.qzone.business.tianshu.b
    protected void f(int i3) {
        List<TianShuAccess.MapEntry> list = this.f44856a.argList.get();
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        QZoneBubbleInfo qZoneBubbleInfo = new QZoneBubbleInfo(this.f44856a);
        this.f44886b = qZoneBubbleInfo;
        qZoneBubbleInfo.setId(String.valueOf(this.f44856a.iAdId.get()));
        this.f44886b.setWords((String) hashMap.get("words"));
        this.f44886b.setMaxTimes(com.qzone.album.util.o.a((String) hashMap.get("max"), 1));
        long b16 = com.qzone.album.util.o.b((String) hashMap.get("startTime"), 0L);
        this.f44886b.setStartTime(b16);
        long b17 = com.qzone.album.util.o.b((String) hashMap.get("endTime"), 0L);
        this.f44886b.setEndTime(b17);
        this.f44886b.setBackgroundUrl((String) hashMap.get("pic1"));
        this.f44886b.setWordsIsTag(TextUtils.equals((CharSequence) hashMap.get("is_tag"), "1"));
        this.f44886b.setArrowUrl((String) hashMap.get("pic2"));
        PlusMenuContainerNew.setShowTemplateRedDot(this.f44886b.getId(), com.qzone.album.util.o.a((String) hashMap.get("showTemplateRedDot"), 0) == 1, b16, b17);
    }

    public QZoneBubbleInfo j() {
        return this.f44886b;
    }
}
