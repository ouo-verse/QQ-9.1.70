package com.tencent.biz.videostory.widget.easylyric;

import android.text.TextUtils;
import com.tencent.oskplayer.util.Singleton;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    private static a f97216c = new a();

    /* renamed from: a, reason: collision with root package name */
    private b f97217a = new com.tencent.biz.videostory.widget.easylyric.a();

    /* renamed from: b, reason: collision with root package name */
    private b f97218b = new g();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a extends Singleton<e> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.oskplayer.util.Singleton
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createInstance() {
            return new e();
        }
    }

    public static e b() {
        return f97216c.getInstance();
    }

    public com.tencent.mobileqq.lyric.data.d a(com.tencent.mobileqq.lyric.data.b bVar, long j3) {
        List<com.tencent.mobileqq.lyric.data.d> h16;
        int size;
        int i3;
        com.tencent.mobileqq.lyric.data.d dVar = null;
        if (bVar == null || (h16 = bVar.h()) == null || (size = h16.size()) < 1) {
            return null;
        }
        int i16 = 0;
        while (true) {
            i3 = size - 1;
            if (i16 >= i3) {
                break;
            }
            com.tencent.mobileqq.lyric.data.d dVar2 = h16.get(i16);
            i16++;
            com.tencent.mobileqq.lyric.data.d dVar3 = h16.get(i16);
            if (j3 >= dVar2.f243149b && dVar3.f243149b >= j3) {
                dVar = dVar2;
                break;
            }
        }
        if (dVar == null) {
            return h16.get(i3);
        }
        return dVar;
    }

    public com.tencent.mobileqq.lyric.data.b c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (LyricParseHelper.LYRIC_FROMAT_LRC.equals(str2.toUpperCase())) {
            return this.f97217a.a(str);
        }
        if (!LyricParseHelper.LYRIC_FROMAT_QRC.equals(str2.toUpperCase())) {
            return null;
        }
        return this.f97218b.a(str);
    }
}
