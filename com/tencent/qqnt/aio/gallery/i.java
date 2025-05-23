package com.tencent.qqnt.aio.gallery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R3\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\f\u0010\u000fR#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/i;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "elementIdToMediaId", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/filemanager/core/k;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "()Ljava/util/concurrent/ConcurrentHashMap;", "downloaderMap", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "d", "videoDownloadMap", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "e", "videoDownloadStateMap", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f350003a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, String> elementIdToMediaId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.mobileqq.filemanager.core.k> downloaderMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, RFWLayerItemMediaInfo> videoDownloadMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, RFWLayerFileDownloadState.FileState> videoDownloadStateMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f350003a = new i();
        elementIdToMediaId = new HashMap<>();
        downloaderMap = new ConcurrentHashMap<>();
        videoDownloadMap = new ConcurrentHashMap<>();
        videoDownloadStateMap = new ConcurrentHashMap<>();
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, com.tencent.mobileqq.filemanager.core.k> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return downloaderMap;
    }

    @NotNull
    public final HashMap<Long, String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return elementIdToMediaId;
    }

    @NotNull
    public final ConcurrentHashMap<String, RFWLayerItemMediaInfo> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return videoDownloadMap;
    }

    @NotNull
    public final ConcurrentHashMap<String, RFWLayerFileDownloadState.FileState> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return videoDownloadStateMap;
    }
}
