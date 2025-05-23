package com.tencent.mobileqq.wink.picker.core.repository;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.repository.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes21.dex */
public class h extends a {

    /* renamed from: c, reason: collision with root package name */
    private final MediaType f324658c;

    /* renamed from: d, reason: collision with root package name */
    private final MediaFilter f324659d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, MediaQueryHelper> f324660e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f324661f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f324662g = new AtomicBoolean(false);

    public h(MediaType mediaType, MediaFilter mediaFilter) {
        this.f324658c = mediaType;
        this.f324659d = mediaFilter;
    }

    private MediaQueryHelper e(String str) {
        boolean z16;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        MediaQueryHelper.Builder eachCount = new MediaQueryHelper.Builder().setAlbumId(str).setEachCount(50);
        boolean z17 = true;
        if (this.f324658c == MediaType.LOCAL_VIDEO) {
            z16 = false;
        } else {
            z16 = true;
        }
        MediaQueryHelper.Builder needImage = eachCount.needImage(z16);
        if (this.f324658c == MediaType.LOCAL_IMAGE) {
            z17 = false;
        }
        MediaQueryHelper.Builder listener = needImage.needVideo(z17).setListener(new i(this.f324659d));
        if (QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(str)) {
            listener.needImage(false);
        }
        MediaQueryHelper build = listener.build(applicationContext);
        this.f324660e.put(str, build);
        return build;
    }

    private MediaQueryHelper f(String str) {
        if (this.f324660e.get(str) != null) {
            return this.f324660e.get(str);
        }
        return e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str, Map map, int i3) {
        List<LocalMediaInfo> list;
        MediaQueryHelper f16 = f(str);
        if (f16 != null && (list = f16.mediaList) != null) {
            if (f16.mTraversalDone && !list.isEmpty()) {
                a.b bVar = this.mediaQueryListener;
                if (bVar != null) {
                    bVar.b(new b(str, f16.mediaList, true, false, map));
                }
                w53.b.f("WinkLocalMediaRepository", String.format("[queryMediaNext] onQueryNextFinish: albumId=%s, payload=%s", str, map));
                this.f324661f.set(false);
                return;
            }
            int size = f16.mediaList.size();
            try {
                w53.b.f("WinkLocalMediaRepository", String.format("[queryMediaNext] before: albumId=%s, payload=%s", str, map));
                f16.queryNext(i3);
                w53.b.f("WinkLocalMediaRepository", String.format("[queryMediaNext] after: albumId=%s, payload=%s", str, map));
            } catch (Exception e16) {
                w53.b.d("WinkLocalMediaRepository", String.format("[queryMediaNext] exception: albumId=%s, payload=%s", str, map), e16);
            }
            this.f324661f.set(false);
            if (this.f324662g.getAndSet(false)) {
                w53.b.f("WinkLocalMediaRepository", "realReleaseResources");
                i();
            }
            int size2 = f16.mediaList.size();
            if (f16.mTraversalDone && size == 0 && size2 == 0 && this.mediaQueryListener != null) {
                w53.b.c("WinkLocalMediaRepository", "[queryMediaNext] media list empty, mTraversalDone = true, prevSize = " + size + " newSize = " + size2);
                this.mediaQueryListener.b(new b(str, Collections.emptyList(), true, false, map));
                return;
            }
            if ((size2 == 0 || size > size2) && this.mediaQueryListener != null) {
                w53.b.c("WinkLocalMediaRepository", "[queryMediaNext] failed prevSize = " + size + " newSize = " + size2);
                this.mediaQueryListener.b(new b(str, Collections.emptyList(), false, false, map));
                return;
            }
            a.b bVar2 = this.mediaQueryListener;
            if (bVar2 != null) {
                bVar2.b(new b(str, f16.mediaList.subList(size, size2), true, !f16.mTraversalDone, map));
                return;
            } else {
                w53.b.c("WinkLocalMediaRepository", String.format("[queryMediaNext] mediaQueryListener is null: albumId=%s, payload=%s", str, map));
                return;
            }
        }
        w53.b.c("WinkLocalMediaRepository", "[queryMediaNext] helper query failed, helper is null");
        this.f324661f.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        Iterator<Map.Entry<String, MediaQueryHelper>> it = this.f324660e.entrySet().iterator();
        while (it.hasNext()) {
            MediaQueryHelper value = it.next().getValue();
            if (value != null) {
                value.close();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.repository.a
    public void a(@NotNull final String str, final int i3, @Nullable final Map<String, Object> map) {
        w53.b.f("WinkLocalMediaRepository", String.format("[queryMediaNext] enter: albumId=%s, payload=%s", str, map));
        this.f324661f.set(true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.repository.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.g(str, map, i3);
            }
        }, 32, null, true);
    }

    public void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.repository.f
            @Override // java.lang.Runnable
            public final void run() {
                h.this.h();
            }
        }, 64, null, false);
    }

    public void j() {
        if (!this.f324661f.get()) {
            w53.b.f("WinkLocalMediaRepository", "releaseResources");
            i();
        } else {
            this.f324662g.set(true);
        }
    }
}
