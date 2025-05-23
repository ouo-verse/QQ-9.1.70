package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f321099a = Collections.synchronizedList(new ArrayList());

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(long j3);

        void b(long j3, long j16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j3) {
        Iterator<a> it = this.f321099a.iterator();
        while (it.hasNext()) {
            it.next().a(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j3, int i3) {
        Iterator<a> it = this.f321099a.iterator();
        while (it.hasNext()) {
            it.next().b(j3, i3);
        }
    }

    public void c(a aVar) {
        if (aVar == null) {
            ms.a.i("LyricScrollHelper", "registerListener() lyricScrollListener == null.");
            return;
        }
        List<a> list = this.f321099a;
        if (list == null) {
            ms.a.i("LyricScrollHelper", "registerListener() mScrollListener == null.");
        } else {
            list.add(aVar);
        }
    }
}
