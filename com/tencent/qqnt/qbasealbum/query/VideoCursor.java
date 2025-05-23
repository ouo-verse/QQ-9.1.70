package com.tencent.qqnt.qbasealbum.query;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00062\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/VideoCursor;", "Lcom/tencent/qqnt/qbasealbum/query/ICursor;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "", "needSimpleData", "k", "Landroid/content/Context;", "context", "Landroid/database/Cursor;", "c", "", "albumId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class VideoCursor extends ICursor {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final String[] f361489j;

    /* renamed from: k, reason: collision with root package name */
    private static int f361490k;

    /* renamed from: l, reason: collision with root package name */
    private static int f361491l;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/VideoCursor$a;", "", "", "INDEX_BUCKET_ID", "I", "INDEX_DURATION", "", "", "VIDEO_COLUMNS", "[Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.query.VideoCursor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        f361489j = new String[]{"duration", "bucket_id"};
        f361490k = ICursor.h();
        f361491l = ICursor.h() + 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCursor(@NotNull Context context, @Nullable String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r0 == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q(final LocalMediaInfo mediaInfo) {
        int mediaHeight;
        int mediaWidth;
        boolean contains$default;
        boolean z16 = true;
        if (mediaInfo.getMMediaType() == 1) {
            String mMimeType = mediaInfo.getMMimeType();
            MediaMetadataRetriever mediaMetadataRetriever = null;
            int i3 = 0;
            if (mMimeType != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) mMimeType, (CharSequence) "video/mp4", false, 2, (Object) null);
            }
            z16 = false;
            if (z16) {
                long j3 = 0;
                if (com.tencent.qqnt.qbasealbum.ktx.b.f(mediaInfo) != 0 && mediaInfo.getMediaHeight() > 0 && mediaInfo.getMediaWidth() > 0) {
                    return;
                }
                try {
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever2.setDataSource(mediaInfo.getPath());
                            if (com.tencent.qqnt.qbasealbum.ktx.b.f(mediaInfo) == 0) {
                                String extractMetadata = mediaMetadataRetriever2.extractMetadata(9);
                                if (extractMetadata != null) {
                                    j3 = Long.parseLong(extractMetadata);
                                }
                                com.tencent.qqnt.qbasealbum.ktx.b.t(mediaInfo, j3);
                            }
                            String extractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                            if (extractMetadata2 != null) {
                                mediaHeight = Integer.parseInt(extractMetadata2);
                            } else {
                                mediaHeight = mediaInfo.getMediaHeight();
                            }
                            mediaInfo.setMediaHeight(mediaHeight);
                            String extractMetadata3 = mediaMetadataRetriever2.extractMetadata(18);
                            if (extractMetadata3 != null) {
                                mediaWidth = Integer.parseInt(extractMetadata3);
                            } else {
                                mediaWidth = mediaInfo.getMediaWidth();
                            }
                            mediaInfo.setMediaWidth(mediaWidth);
                            String extractMetadata4 = mediaMetadataRetriever2.extractMetadata(24);
                            if (extractMetadata4 != null) {
                                i3 = Integer.parseInt(extractMetadata4);
                            }
                            mediaInfo.setRotation(i3);
                            mediaMetadataRetriever2.release();
                        } catch (Exception e16) {
                            e = e16;
                            mediaMetadataRetriever = mediaMetadataRetriever2;
                            ox3.a.a("QBaseAlbum.MediaQuery", new Function0<String>(e) { // from class: com.tencent.qqnt.qbasealbum.query.VideoCursor$fixVideoInfo$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ Exception $e;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$e = e;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this, (Object) e);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final String invoke() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                                    }
                                    return "get mmr failed:" + LocalMediaInfo.this.getPath() + ", " + this.$e;
                                }
                            });
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            mediaMetadataRetriever = mediaMetadataRetriever2;
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.query.ICursor
    @Nullable
    public Cursor c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Cursor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
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
        String[] strArr = f361489j;
        listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length));
        e16.addAll(listOf);
    }

    @Override // com.tencent.qqnt.qbasealbum.query.ICursor
    @NotNull
    public LocalMediaInfo k(boolean needSimpleData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this, needSimpleData);
        }
        LocalMediaInfo k3 = super.k(needSimpleData);
        boolean z16 = true;
        k3.setMMediaType(1);
        Cursor f16 = f();
        if (f16 == null || f16.isClosed()) {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNull(f());
            com.tencent.qqnt.qbasealbum.ktx.b.t(k3, r0.getInt(f361490k));
            Cursor f17 = f();
            Intrinsics.checkNotNull(f17);
            com.tencent.qqnt.qbasealbum.ktx.b.q(k3, f17.getString(f361491l));
        }
        q(k3);
        return k3;
    }
}
