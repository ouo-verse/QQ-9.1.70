package com.tencent.qqnt.qbasealbum.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/MediaTypeHelper;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "a", "", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "MEDIA_TYPE_MAPS", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MediaTypeHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MediaTypeHelper f361628a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> MEDIA_TYPE_MAPS;

    static {
        HashMap<String, Integer> hashMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f361628a = new MediaTypeHelper();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("image", 0), TuplesKt.to("video", 1), TuplesKt.to(com.tencent.mobileqq.activity.photo.MimeHelper.MIME_TYPE_MOBILEQQ, 2));
        MEDIA_TYPE_MAPS = hashMapOf;
    }

    MediaTypeHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(@Nullable final LocalMediaInfo info) {
        final String[] a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info)).intValue();
        }
        if (info == null) {
            return -1;
        }
        String mMimeType = info.getMMimeType();
        if (mMimeType == null || (a16 = MimeHelper.f361630a.a(mMimeType)) == null) {
            return 0;
        }
        Integer num = MEDIA_TYPE_MAPS.get(a16[0]);
        if (num == null) {
            ox3.a.a("MediaTypeHelper", new Function0<String>(a16) { // from class: com.tencent.qqnt.qbasealbum.utils.MediaTypeHelper$getMediaType$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String[] $mimeStrings;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$mimeStrings = a16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this, (Object) a16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "getMediaType fail : " + LocalMediaInfo.this.getMMimeType() + "-" + this.$mimeStrings + "[0]";
                }
            });
            return -1;
        }
        return num.intValue();
    }

    public final boolean b(@Nullable LocalMediaInfo info) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) info)).booleanValue();
        }
        if (info != null) {
            str = info.getMMimeType();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "image/gif");
    }
}
