package com.tencent.qqnt.qbasealbum.inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.edit.EditActivity;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ0\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/c;", "", "Landroid/content/Intent;", "intent", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "localMediaInfo", "", "qualityRaw", "business", "", "l", "i", "Landroid/os/Bundle;", "data", DomainData.DOMAIN_NAME, "comment", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "listener", tl.h.F, "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface c {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/c$a;", "", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.inject.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f361233a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39030);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f361233a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class b {
        public static void a(@NotNull c cVar, @NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean z16, @Nullable String str) {
            ArrayList<String> arrayListOf;
            HashMap hashMapOf;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            if (com.tencent.qqnt.qbasealbum.ktx.b.n(localMediaInfo)) {
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) EditActivity.class);
            intent.putExtra("goEdit", true);
            intent.putExtra("editFromPage", 1);
            String path = localMediaInfo.getPath();
            LocalMediaInfo b16 = com.tencent.qqnt.qbasealbum.ktx.b.b(localMediaInfo);
            b16.setPath("/storage/emulated/0/Android/data/com.tencent.qbasealbumdemo/edit_video_output.mp4");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(localMediaInfo.getPath());
            b16.setMOriginPath(arrayListOf);
            Intrinsics.checkNotNull(path);
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(path, b16));
            intent.putExtra(QAlbumConstants.ALL_MEDIA_PATHS, hashMapOf);
            activity.startActivity(intent);
        }

        public static void b(@NotNull c cVar, @NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean z16, @Nullable String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            Intent intent = new Intent(activity, (Class<?>) EditActivity.class);
            intent.putExtra("goEdit", true);
            intent.putExtra("editFromPage", 2);
            if (com.tencent.qqnt.qbasealbum.ktx.b.n(localMediaInfo)) {
                intent.putExtra(PeakConstants.SEND_PICTURE_ORIGIN, false);
                intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", "/storage/emulated/0/Android/data/com.tencent.qbasealbumdemo/edit_image_output.jpg");
                intent.putExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH, localMediaInfo.getPath());
                activity.startActivityForResult(intent, 10000);
                return;
            }
            intent.putExtra(PeakConstants.VIDEO_EDIT_OLD_MEDIA, (Parcelable) localMediaInfo);
            LocalMediaInfo b16 = com.tencent.qqnt.qbasealbum.ktx.b.b(localMediaInfo);
            b16.setPath("/storage/emulated/0/Android/data/com.tencent.qbasealbumdemo/edit_video_output.mp4");
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.os.Parcelable");
            intent.putExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA, (Parcelable) b16);
            activity.startActivityForResult(intent, 10000);
        }

        public static void c(@NotNull c cVar, @NotNull Activity activity, @NotNull String comment, @NotNull com.tencent.qqnt.qbasealbum.preview.fragment.a listener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void d(@NotNull c cVar, @NotNull Activity activity, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Nullable
        public static HashMap<String, LocalMediaInfo> e(@NotNull c cVar, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return (HashMap) intent.getSerializableExtra(QAlbumConstants.ALL_MEDIA_PATHS);
        }

        @Nullable
        public static LocalMediaInfo f(@NotNull c cVar, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return (LocalMediaInfo) intent.getParcelableExtra(PeakConstants.VIDEO_EDIT_OLD_MEDIA);
        }

        @Nullable
        public static LocalMediaInfo g(@NotNull c cVar, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return (LocalMediaInfo) intent.getParcelableExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA);
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39035), (Class<?>) c.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f361233a;
        }
    }

    @Nullable
    LocalMediaInfo c(@NotNull Intent intent);

    @Nullable
    LocalMediaInfo d(@NotNull Intent intent);

    void h(@NotNull Activity activity, @NotNull String comment, @NotNull com.tencent.qqnt.qbasealbum.preview.fragment.a listener);

    void i(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean qualityRaw, @Nullable String business);

    void l(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean qualityRaw, @Nullable String business);

    @Nullable
    HashMap<String, LocalMediaInfo> m(@NotNull Intent intent);

    void n(@NotNull Activity activity, @NotNull Bundle data);
}
