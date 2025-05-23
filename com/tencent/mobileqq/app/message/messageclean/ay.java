package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.app.message.messageclean.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR(\u0010\t\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/ay;", "Lcom/tencent/mobileqq/app/message/messageclean/x;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "kotlin.jvm.PlatformType", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "cachePathList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ay implements x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ay f196162a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> cachePathList;

    static {
        ArrayList arrayListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f196162a = new ay();
        com.tencent.mobileqq.app.message.filescan.d dVar = com.tencent.mobileqq.app.message.filescan.d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.d() + "/Tencent/Qzone/VoiceMoodAudio", dVar.k() + "/Tencent/Qzone/AlbumAutoVConvGif", dVar.d() + "/Tencent/Qzone/cache", dVar.d() + "/qzone/feeds", dVar.d() + "/qzone/file", dVar.d() + "/qzone/MaxVideo", dVar.d() + "/Tencent/MobileQQ/qzone/thumbs", dVar.d() + "/Tencent/Qzone/qzonedynamicalbum", dVar.d() + "/ix.jpg", dVar.d() + "/qzone/imageV2", dVar.d() + "/qzone/video", dVar.d() + "/qzone/video_cache", dVar.d() + "/qzone/image_sr", dVar.a() + "/cache/qzone/qzone_temp_image_share", dVar.d() + "/qzone/personalise_font", dVar.d() + "/qzone/react", dVar.d() + "/qzone/offline", dVar.d() + "/qzone/zip_cache", dVar.d() + "/qzone/qzone_widgetai", dVar.d() + "/qzone/avatar", dVar.d() + "/qzone/personality_canvas", dVar.d() + "/qzone/batch_image", dVar.d() + "/qzone/gift_fullscreen", dVar.d() + "/qzone/moodlistIcons", dVar.d() + "/qzone/head_drop_operaion", dVar.d() + "/qzone/surprise", dVar.d() + "/qzone/smart_beautify", dVar.d() + "/qzone/audio");
        cachePathList = new CopyOnWriteArrayList<>(arrayListOf);
    }

    ay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    @NotNull
    public CopyOnWriteArrayList<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return cachePathList;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            x.a.a(this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.x
    public long getCacheSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return x.a.b(this);
    }
}
