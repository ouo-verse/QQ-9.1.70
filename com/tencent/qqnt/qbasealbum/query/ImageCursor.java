package com.tencent.qqnt.qbasealbum.query;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/ImageCursor;", "Lcom/tencent/qqnt/qbasealbum/query/ICursor;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "i", "", "needSimpleData", "k", "info", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "Landroid/database/Cursor;", "c", "", "albumId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class ImageCursor extends ICursor {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final String[] f361453j;

    /* renamed from: k, reason: collision with root package name */
    private static int f361454k;

    /* renamed from: l, reason: collision with root package name */
    private static int f361455l;

    /* renamed from: m, reason: collision with root package name */
    private static int f361456m;

    /* renamed from: n, reason: collision with root package name */
    private static int f361457n;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/ImageCursor$a;", "", "", "", "IMAGE_COLUMNS", "[Ljava/lang/String;", "", "INDEX_BUCKET_ID", "I", "INDEX_LATITUDE", "INDEX_LONGITUDE", "INDEX_ORIENTATION", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.query.ImageCursor$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        f361453j = new String[]{"orientation", "latitude", "longitude", "bucket_id"};
        f361454k = ICursor.h();
        f361455l = ICursor.h() + 1;
        f361456m = ICursor.h() + 2;
        f361457n = ICursor.h() + 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCursor(@NotNull Context context, @Nullable String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
    
        if (r0 == true) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q(LocalMediaInfo mediaInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        if (Intrinsics.areEqual("*/*", mediaInfo.getMMimeType()) || Intrinsics.areEqual("image/*", mediaInfo.getMMimeType())) {
            String path = mediaInfo.getPath();
            boolean z26 = true;
            if (path != null) {
                contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) path, (CharSequence) ".jpg", false, 2, (Object) null);
                if (contains$default5) {
                    z16 = true;
                    if (!z16) {
                        String path2 = mediaInfo.getPath();
                        if (path2 != null) {
                            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) path2, (CharSequence) ".jpeg", false, 2, (Object) null);
                            if (contains$default4) {
                                z17 = true;
                                if (!z17) {
                                    String path3 = mediaInfo.getPath();
                                    if (path3 != null) {
                                        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) path3, (CharSequence) QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, (Object) null);
                                        if (contains$default3) {
                                            z18 = true;
                                            if (!z18) {
                                                mediaInfo.setMMimeType("image/gif");
                                                return;
                                            }
                                            String path4 = mediaInfo.getPath();
                                            if (path4 != null) {
                                                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) path4, (CharSequence) ".bmp", false, 2, (Object) null);
                                                if (contains$default2) {
                                                    z19 = true;
                                                    if (!z19) {
                                                        mediaInfo.setMMimeType(MimeHelper.IMAGE_BMP);
                                                        return;
                                                    }
                                                    String path5 = mediaInfo.getPath();
                                                    if (path5 != null) {
                                                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) path5, (CharSequence) ".png", false, 2, (Object) null);
                                                    }
                                                    z26 = false;
                                                    if (z26) {
                                                        mediaInfo.setMMimeType("image/png");
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            z19 = false;
                                            if (!z19) {
                                            }
                                        }
                                    }
                                    z18 = false;
                                    if (!z18) {
                                    }
                                }
                            }
                        }
                        z17 = false;
                        if (!z17) {
                        }
                    }
                    mediaInfo.setMMimeType("image/jpeg");
                }
            }
            z16 = false;
            if (!z16) {
            }
            mediaInfo.setMMimeType("image/jpeg");
        }
    }

    private final void r(final LocalMediaInfo mediaInfo) {
        if (mediaInfo.getMediaWidth() <= 0 || mediaInfo.getMediaHeight() <= 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int[] iArr = new int[2];
            b.f361494a.d(mediaInfo.getPath(), options, iArr);
            mediaInfo.setMediaWidth(iArr[0]);
            mediaInfo.setMediaHeight(iArr[1]);
            if (mediaInfo.getMediaWidth() <= 0 || mediaInfo.getMediaHeight() <= 0) {
                ox3.a.a("QBaseAlbum.MediaQuery", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.query.ImageCursor$updateWHByPath$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "image, height=" + LocalMediaInfo.this.getMediaHeight() + ", width=" + LocalMediaInfo.this.getMediaWidth() + ", path=" + LocalMediaInfo.this.getPath();
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.query.ICursor
    @Nullable
    public Cursor c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Cursor) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        Object[] array = e().toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return ContactsMonitor.query(contentResolver, uri, (String[]) array, g(), null, com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.ORDER_BY_DATE_MODIFIED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qbasealbum.query.ICursor
    public void i() {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.i();
        ArrayList<String> e16 = e();
        String[] strArr = f361453j;
        listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length));
        e16.addAll(listOf);
    }

    @Override // com.tencent.qqnt.qbasealbum.query.ICursor
    @NotNull
    public LocalMediaInfo k(boolean needSimpleData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this, needSimpleData);
        }
        LocalMediaInfo k3 = super.k(needSimpleData);
        Cursor f16 = f();
        if (f16 != null && !f16.isClosed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            k3.setMMediaType(0);
            Cursor f17 = f();
            Intrinsics.checkNotNull(f17);
            com.tencent.qqnt.qbasealbum.ktx.b.q(k3, f17.getString(f361457n));
            if (!needSimpleData) {
                Cursor f18 = f();
                Intrinsics.checkNotNull(f18);
                k3.setOrientation(f18.getInt(f361454k));
                Cursor f19 = f();
                Intrinsics.checkNotNull(f19);
                k3.setLatitude(f19.getInt(f361455l));
                Cursor f26 = f();
                Intrinsics.checkNotNull(f26);
                k3.setLongitude(f26.getInt(f361456m));
            }
        }
        q(k3);
        r(k3);
        return k3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.qqnt.qbasealbum.query.ICursor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(@NotNull LocalMediaInfo info) {
        boolean z16;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (!super.n(info)) {
            return false;
        }
        String mMimeType = info.getMMimeType();
        if (mMimeType != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) mMimeType, (CharSequence) "image", false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
                if (z16) {
                    return false;
                }
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
