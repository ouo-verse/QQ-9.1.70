package com.tencent.videocut.render.repository;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.utils.o;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.extension.MediaClipUseType;
import com.tencent.videocut.render.g;
import com.tencent.videocut.render.t;
import e93.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/videocut/render/repository/a;", "", "", "Lcom/tencent/videocut/picker/MediaData;", "mediaDatas", "Lcom/tencent/videocut/model/MediaModel;", "b", "Lcom/tencent/videocut/model/MediaClip;", "clips", "c", "mediaData", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "d", "", "imagePath", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final a f384196a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f384196a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ List e(a aVar, List list, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 1.0f;
        }
        return aVar.d(list, f16);
    }

    @Nullable
    public final MediaClip a(@NotNull String imagePath) {
        List<String> mutableListOf;
        Object firstOrNull;
        List mutableListOf2;
        Object firstOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MediaClip) iPatchRedirector.redirect((short) 6, (Object) this, (Object) imagePath);
        }
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        o oVar = o.f326724a;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(imagePath);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) oVar.i(mutableListOf));
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) firstOrNull;
        if (localMediaInfo != null) {
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(i.d(localMediaInfo, 2500000L));
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) e(this, mutableListOf2, 0.0f, 2, null));
            return (MediaClip) firstOrNull2;
        }
        return null;
    }

    @NotNull
    public final MediaModel b(@NotNull List<MediaData> mediaDatas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MediaModel) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaDatas);
        }
        Intrinsics.checkNotNullParameter(mediaDatas, "mediaDatas");
        return c(e(this, mediaDatas, 0.0f, 2, null));
    }

    @NotNull
    public final MediaModel c(@NotNull List<? extends MediaClip> clips) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MediaModel) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clips);
        }
        Intrinsics.checkNotNullParameter(clips, "clips");
        return new MediaModel(UUID.randomUUID().toString(), null, null, null, null, null, clips, null, null, g.e(clips, 0.0f, null, 6, null), null, null, null, null, null, null, null, null, null, null, null, 2096574, null);
    }

    @NotNull
    public final List<MediaClip> d(@NotNull List<MediaData> mediaData, float r322) {
        boolean z16;
        MediaType mediaType;
        Map mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, mediaData, Float.valueOf(r322));
        }
        Intrinsics.checkNotNullParameter(mediaData, "mediaData");
        ArrayList arrayList = new ArrayList();
        for (MediaData mediaData2 : mediaData) {
            long b16 = mediaData2.b();
            String a16 = mediaData2.a();
            if (a16 == null) {
                a16 = " ";
            }
            if (a16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                a16 = mediaData2.c();
            }
            String str = a16;
            String uuid = UUID.randomUUID().toString();
            if (mediaData2.getType() == 1) {
                mediaType = MediaType.IMAGE;
            } else {
                mediaType = MediaType.VIDEO;
            }
            SizeF sizeF = new SizeF(mediaData2.getWidth(), mediaData2.getHeight(), null, 4, null);
            long e16 = mediaData2.e();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("MEDIA_CLIP_USE_TYPE", MediaClipUseType.NORMAL.getType()));
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            arrayList.add(new MediaClip(new ResourceModel(uuid, str, b16, 0L, b16, e16, b16, mediaType, sizeF, r322, mapOf, null, null, null, null, 0.0f, null, 129024, null), t.a(), null, null, null, null, null, 124, null));
        }
        return arrayList;
    }
}
