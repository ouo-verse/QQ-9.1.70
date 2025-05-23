package com.tencent.mobileqq.mutualmark.nt;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mutualmark/nt/i;", "", "", "friendUin", "Ljava/util/ArrayList;", "Lcom/tencent/image/URLDrawable;", "Lkotlin/collections/ArrayList;", "drawableList", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f252210a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/mutualmark/nt/i$a", "Lcom/tencent/image/URLDrawable$DownloadListener;", "", "onFileDownloadStarted", "", "fileSize", "onFileDownloadSucceed", "", "errorCode", "onFileDownloadFailed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements URLDrawable.DownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f252211d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f252212e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f252213f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f252214h;

        a(String str, URLDrawable uRLDrawable, Ref.IntRef intRef, int i3) {
            this.f252211d = str;
            this.f252212e = uRLDrawable;
            this.f252213f = intRef;
            this.f252214h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, uRLDrawable, intRef, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, errorCode);
                return;
            }
            QLog.e("MutualMarkResourceLoader", 1, "onFileDownloadFailed, uin = " + this.f252211d + " errCode=" + errorCode + " drawable.url=" + this.f252212e.getURL());
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkResourceLoader", 2, "onFileDownloadStarted,uin = " + this.f252211d + " drawable.url=" + this.f252212e.getURL());
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long fileSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, fileSize);
                return;
            }
            this.f252213f.element++;
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkResourceLoader", 2, "onFileDownloadSucceed, uin = " + this.f252211d + "drawable.url=" + this.f252212e.getURL() + ", " + this.f252213f.element + "/" + this.f252214h);
            }
            if (this.f252213f.element == this.f252214h) {
                f.f252196a.p(this.f252211d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59150);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f252210a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String friendUin, @NotNull ArrayList<URLDrawable> drawableList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) friendUin, (Object) drawableList);
            return;
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(drawableList, "drawableList");
        int size = drawableList.size();
        Ref.IntRef intRef = new Ref.IntRef();
        Iterator<URLDrawable> it = drawableList.iterator();
        while (it.hasNext()) {
            URLDrawable next = it.next();
            if (next != null) {
                next.setDownloadListener(new a(friendUin, next, intRef, size));
            }
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("mutualmark_download_9_0_30", true)) {
                if (next != null) {
                    next.downloadImediatly();
                }
            } else if (next != null) {
                next.startDownload();
            }
        }
    }
}
