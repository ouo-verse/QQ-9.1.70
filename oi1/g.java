package oi1;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EmojiUseInfo;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import oi1.g;

/* compiled from: P */
/* loaded from: classes13.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private long f422730a;

    /* renamed from: b, reason: collision with root package name */
    private final List<EmotionPanelData> f422731b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<a> f422732c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private int f422733d = 10000;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f422734a;

        /* renamed from: b, reason: collision with root package name */
        SystemAndEmojiEmoticonInfo f422735b;

        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static g f422736a = new g();
    }

    g() {
        int[] iArr = {283, 319, 277, FilterEnum.MIC_PTU_BAIXI, 76, 124, 13, 265, 267, 63, 269, 30, 29, 38, 111, 212, 176, 306, 98, 299, 2, 116, 4, 311, 67, 122, 14};
        for (int i3 = 0; i3 < 27; i3++) {
            int i16 = iArr[i3];
            int convertToLocal = QQSysFaceUtil.convertToLocal(i16);
            QLog.d("RecentEmojiDataSource", 1, "serverId=" + i16 + ", localId=" + convertToLocal);
            if (!((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).isInFilterList(1L, String.valueOf(convertToLocal))) {
                this.f422731b.add(new SystemAndEmojiEmoticonInfo(7, 1, convertToLocal, "", false));
            }
        }
    }

    private void d(ArrayList<EmojiUseInfo> arrayList) {
        int size = arrayList.size();
        QLog.d("RecentEmojiDataSource", 1, "convertToEmoticonInfo size=" + size);
        for (int i3 = 0; i3 < size; i3++) {
            EmojiUseInfo emojiUseInfo = arrayList.get(i3);
            try {
                int emojiType = emojiUseInfo.getEmojiType();
                int localId = QQSysAndEmojiResMgr.getInstance().getResImpl(emojiType).getLocalId(Integer.parseInt(emojiUseInfo.getEmojiId()));
                if (!((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).isInFilterList(emojiType, String.valueOf(localId))) {
                    a aVar = new a();
                    aVar.f422734a = emojiUseInfo.getUsedCount();
                    aVar.f422735b = new SystemAndEmojiEmoticonInfo(7, emojiType, localId, "", false);
                    this.f422732c.add(aVar);
                }
            } catch (Exception e16) {
                QLog.d("RecentEmojiDataSource", 1, "Exception", e16);
            }
        }
    }

    public static g e() {
        return b.f422736a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(a aVar, a aVar2) {
        return aVar2.f422734a - aVar.f422734a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(a aVar, a aVar2) {
        return aVar2.f422734a - aVar.f422734a;
    }

    public boolean c() {
        if (System.currentTimeMillis() < this.f422730a) {
            return true;
        }
        return false;
    }

    public List<EmotionPanelData> f() {
        if (!c()) {
            return this.f422731b;
        }
        if (this.f422732c.size() < 6) {
            return this.f422731b;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f422732c.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f422735b);
        }
        return arrayList;
    }

    public void i(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        boolean z16;
        Iterator<a> it = this.f422732c.iterator();
        while (true) {
            if (it.hasNext()) {
                a next = it.next();
                if (systemAndEmojiEmoticonInfo.code == next.f422735b.code) {
                    next.f422734a++;
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            a aVar = new a();
            aVar.f422734a = 1;
            aVar.f422735b = systemAndEmojiEmoticonInfo;
            this.f422732c.add(aVar);
        }
        Collections.sort(this.f422732c, new Comparator() { // from class: oi1.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g16;
                g16 = g.g((g.a) obj, (g.a) obj2);
                return g16;
            }
        });
    }

    public void j(ArrayList<EmojiUseInfo> arrayList) {
        this.f422732c.clear();
        d(arrayList);
        Collections.sort(this.f422732c, new Comparator() { // from class: oi1.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int h16;
                h16 = g.h((g.a) obj, (g.a) obj2);
                return h16;
            }
        });
        this.f422730a = System.currentTimeMillis() + this.f422733d;
    }
}
