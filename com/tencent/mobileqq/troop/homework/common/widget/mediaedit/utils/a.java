package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/utils/a;", "", "", "url", "c", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/widget/ImageView;", "imgIv", "Lkotlin/Function0;", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "optionGet", "", "b", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f296840a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49633);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f296840a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c(String url) {
        boolean startsWith$default;
        String replaceFirst$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http:", false, 2, null);
        if (startsWith$default) {
            replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(url, "http:", HippyBridge.URI_SCHEME_FILE, false, 4, (Object) null);
            return replaceFirst$default;
        }
        return HippyBridge.URI_SCHEME_FILE + url;
    }

    public final void a(@NotNull BaseMediaItem item) {
        String posterHttpUrl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof ImageItem) {
            if (item.isLocalFile()) {
                posterHttpUrl = item.getLocalPath();
            } else {
                posterHttpUrl = item.getHttpUrl();
            }
        } else if (item instanceof VideoItem) {
            if (item.isLocalFile()) {
                posterHttpUrl = ((VideoItem) item).getPosterLocalPath();
            } else {
                posterHttpUrl = ((VideoItem) item).getPosterHttpUrl();
            }
            if (posterHttpUrl == null) {
                return;
            }
        } else {
            return;
        }
        if (item.getReqDrawableW() != 0 && item.getReqDrawableH() != 0) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mKeyAddWHSuffix = true;
            obtain.mRequestWidth = item.getReqDrawableW();
            obtain.mRequestHeight = item.getReqDrawableH();
            URLDrawable.removeMemoryCacheByUrl(posterHttpUrl, obtain);
            return;
        }
        URLDrawable.removeMemoryCacheByUrl(posterHttpUrl);
    }

    public final void b(@NotNull BaseMediaItem item, @NotNull ImageView imgIv, @NotNull Function0<? extends URLDrawable.URLDrawableOptions> optionGet) {
        String posterHttpUrl;
        boolean z16;
        URLDrawable uRLDrawable;
        String str;
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, item, imgIv, optionGet);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(imgIv, "imgIv");
        Intrinsics.checkNotNullParameter(optionGet, "optionGet");
        if (item instanceof ImageItem) {
            if (item.isLocalFile()) {
                posterHttpUrl = item.getLocalPath();
            } else {
                posterHttpUrl = item.getHttpUrl();
            }
        } else if (item instanceof VideoItem) {
            if (item.isLocalFile()) {
                posterHttpUrl = ((VideoItem) item).getPosterLocalPath();
            } else {
                posterHttpUrl = ((VideoItem) item).getPosterHttpUrl();
            }
        } else {
            return;
        }
        if (posterHttpUrl != null && posterHttpUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            imgIv.setImageDrawable(optionGet.invoke().mFailedDrawable);
            return;
        }
        Drawable drawable = imgIv.getDrawable();
        if (drawable instanceof URLDrawable) {
            uRLDrawable = (URLDrawable) drawable;
        } else {
            uRLDrawable = null;
        }
        if (uRLDrawable == null || (url = uRLDrawable.getURL()) == null || (str = url.toString()) == null) {
            str = "";
        }
        if (Intrinsics.areEqual(str, c(posterHttpUrl))) {
            return;
        }
        URLDrawable.URLDrawableOptions invoke = optionGet.invoke();
        if (item.isLocalFile()) {
            imgIv.setImageDrawable(URLDrawable.getFileDrawable(posterHttpUrl, invoke));
        } else {
            imgIv.setImageDrawable(URLDrawable.getDrawable(posterHttpUrl, invoke));
        }
        item.setReqDrawableW(invoke.mRequestWidth);
        item.setReqDrawableH(invoke.mRequestHeight);
    }
}
