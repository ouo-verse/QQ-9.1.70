package com.tencent.mobileqq.wifiphoto.impl.album;

import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Window;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFileThumbGeneratorApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wifiphoto.data.WifiPhotoQueryHelper;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoDeletePhotoBatchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoGetAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoGetPhotoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoGetPhotoInfoBatchCallback;
import com.tencent.qqnt.kernel.nativeinterface.PhotoDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.ThumbConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoAlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.cb;
import com.tencent.qqnt.qbasealbum.albumlist.repository.c;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b+\u0010,JP\u0010\t\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0004j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b`\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J>\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2.\u0010\n\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0004j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b`\u0006H\u0002J$\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010\u001a\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001d\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010 \u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010\"\u001a\u00020\u00132\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010!H\u0016R\u001c\u0010&\u001a\n #*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/impl/album/f;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoAlbumAccessDelegate;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mediaIds", "Lkotlin/Pair;", "j", "mediaInfo", "", "Landroid/net/Uri;", "e", "albumId", "", "count", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback;", "cb", "", "getPhotoSimpleInfoForFirstView", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoGetAlbumListCallback;", "getAlbumList", "getAllPhotoSimpleInfo", "photoBatch", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoGetPhotoInfoBatchCallback;", "getPhotoInfoBatch", "photoId", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoGetPhotoCallback;", "getPhoto", "Lcom/tencent/qqnt/kernel/nativeinterface/ThumbConfig;", DownloadInfo.spKey_Config, "getPhotoThumbWithConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoDeletePhotoBatchCallback;", "deletePhotoBatch", "kotlin.jvm.PlatformType", "a", "Landroid/net/Uri;", "fileUri", "Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c;", "b", "Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c;", "albumRepository", "<init>", "()V", "c", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f implements IKernelWiFiPhotoAlbumAccessDelegate {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Uri fileUri;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.qbasealbum.albumlist.repository.c albumRepository;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/impl/album/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wifiphoto.impl.album.f$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wifiphoto/impl/album/f$b", "Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c$a;", "", "Lcom/tencent/qqnt/qbasealbum/model/b;", "albums", "", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IKernelWiFiPhotoGetAlbumListCallback f317622a;

        b(IKernelWiFiPhotoGetAlbumListCallback iKernelWiFiPhotoGetAlbumListCallback) {
            this.f317622a = iKernelWiFiPhotoGetAlbumListCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelWiFiPhotoGetAlbumListCallback);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.albumlist.repository.c.a
        public void a(@Nullable List<com.tencent.qqnt.qbasealbum.model.b> albums) {
            Integer num;
            Collection emptyList;
            List mutableList;
            int collectionSizeOrDefault;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) albums);
                return;
            }
            if (albums != null) {
                num = Integer.valueOf(albums.size());
            } else {
                num = null;
            }
            QLog.d("WifiPhotoAlbumService", 1, "getAlbumList : " + num);
            if (albums == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList<com.tencent.qqnt.qbasealbum.model.b> arrayList = new ArrayList();
                for (Object obj : albums) {
                    if (((com.tencent.qqnt.qbasealbum.model.b) obj).d() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                emptyList = new ArrayList(collectionSizeOrDefault);
                for (com.tencent.qqnt.qbasealbum.model.b bVar : arrayList) {
                    WiFiPhotoAlbumInfo wiFiPhotoAlbumInfo = new WiFiPhotoAlbumInfo();
                    wiFiPhotoAlbumInfo.albumId = String.valueOf(bVar.g());
                    String f16 = bVar.f();
                    Intrinsics.checkNotNull(f16);
                    wiFiPhotoAlbumInfo.albumName = f16;
                    wiFiPhotoAlbumInfo.fileCount = bVar.d();
                    emptyList.add(wiFiPhotoAlbumInfo);
                }
            }
            QLog.d("WifiPhotoAlbumService", 1, "getAlbumList sortedAlbumInfo: " + emptyList);
            IKernelWiFiPhotoGetAlbumListCallback iKernelWiFiPhotoGetAlbumListCallback = this.f317622a;
            if (iKernelWiFiPhotoGetAlbumListCallback != null) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList(emptyList);
                Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoAlbumInfo>");
                iKernelWiFiPhotoGetAlbumListCallback.onResult(0, "", (ArrayList) mutableList);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.fileUri = MediaStore.Files.getContentUri("external");
            this.albumRepository = new com.tencent.qqnt.qbasealbum.albumlist.repository.c();
        }
    }

    private final Collection<Uri> e(ArrayList<Pair<String, String>> mediaInfo) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mediaInfo.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (Intrinsics.areEqual(pair.getSecond(), "image")) {
                arrayList.add(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.parseLong((String) pair.getFirst())));
            } else if (Intrinsics.areEqual(pair.getSecond(), "video")) {
                arrayList.add(ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, Long.parseLong((String) pair.getFirst())));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final f this$0, final ArrayList arrayList, final IKernelWiFiPhotoDeletePhotoBatchCallback iKernelWiFiPhotoDeletePhotoBatchCallback) {
        PendingIntent createDeleteRequest;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 30) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Collection<Uri> e16 = this$0.e(this$0.j(context, arrayList));
            QLog.d("WifiPhotoAlbumService", 1, "deletePhotoBatch uris: " + e16);
            createDeleteRequest = MediaStore.createDeleteRequest(BaseApplication.context.getContentResolver(), e16);
            Intrinsics.checkNotNullExpressionValue(createDeleteRequest, "createDeleteRequest(Mobi\u2026xt.contentResolver, uris)");
            ActivityResultLauncher registerForActivityResult = QBaseActivity.sTopActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.tencent.mobileqq.wifiphoto.impl.album.c
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    f.g(IKernelWiFiPhotoDeletePhotoBatchCallback.this, (ActivityResult) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "sTopActivity.registerFor\u2026esult\")\n                }");
            Intent intent = new Intent();
            intent.setAction("android.intent.action.DELETE");
            intent.putExtra("android.intent.extra.INTENT", createDeleteRequest);
            registerForActivityResult.launch(intent);
            return;
        }
        QQCustomDialog qQCustomDialog = new QQCustomDialog(QBaseActivity.sTopActivity);
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = qQCustomDialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setMessage(R.string.akf);
        qQCustomDialog.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.impl.album.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.h(arrayList, this$0, iKernelWiFiPhotoDeletePhotoBatchCallback, dialogInterface, i3);
            }
        });
        qQCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.impl.album.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.i(dialogInterface, i3);
            }
        });
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(IKernelWiFiPhotoDeletePhotoBatchCallback iKernelWiFiPhotoDeletePhotoBatchCallback, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            iKernelWiFiPhotoDeletePhotoBatchCallback.onResult(0, "");
        } else {
            iKernelWiFiPhotoDeletePhotoBatchCallback.onResult(60008, "\u53d6\u6d88\u5220\u9664");
        }
        QLog.d("WifiPhotoAlbumService", 1, "result = " + activityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ArrayList arrayList, f this$0, IKernelWiFiPhotoDeletePhotoBatchCallback iKernelWiFiPhotoDeletePhotoBatchCallback, DialogInterface dialogInterface, int i3) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        String str = "_id in (" + joinToString$default + ")";
        int e16 = py3.b.e(BaseApplication.context.getContentResolver(), this$0.fileUri, str, null);
        if (e16 > 0) {
            iKernelWiFiPhotoDeletePhotoBatchCallback.onResult(0, "");
        } else {
            iKernelWiFiPhotoDeletePhotoBatchCallback.onResult(60008, "request: " + arrayList.size() + " delete: " + e16);
        }
        QLog.d("WifiPhotoAlbumService", 1, "deletePhotoBatch rows: " + e16 + ", selection: " + str);
    }

    private final ArrayList<Pair<String, String>> j(Context context, ArrayList<String> mediaIds) {
        String joinToString$default;
        String[] strArr = {"_id", JobDbManager.COL_UP_MIME_TYPE};
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(mediaIds, ",", null, null, 0, null, null, 62, null);
        String str = "_id in (" + joinToString$default + ")";
        Cursor query = ContactsMonitor.query(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, str, null, null);
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (query != null) {
            k(arrayList, query);
        }
        Cursor query2 = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, strArr, str, null, null);
        if (query2 != null) {
            k(arrayList, query2);
        }
        return arrayList;
    }

    private static final void k(ArrayList<Pair<String, String>> arrayList, Cursor cursor) {
        boolean startsWith$default;
        boolean startsWith$default2;
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(JobDbManager.COL_UP_MIME_TYPE);
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndexOrThrow);
            String type = cursor.getString(columnIndexOrThrow2);
            Intrinsics.checkNotNullExpressionValue(type, "type");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(type, "image", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(type, "video", false, 2, null);
                if (startsWith$default2) {
                    arrayList.add(new Pair<>(string, "video"));
                }
            } else {
                arrayList.add(new Pair<>(string, "image"));
            }
        }
        cursor.close();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public /* synthetic */ void cancelAllRequestAndClearCache() {
        cb.a(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public void deletePhotoBatch(@Nullable final ArrayList<String> photoBatch, @Nullable final IKernelWiFiPhotoDeletePhotoBatchCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) photoBatch, (Object) cb5);
            return;
        }
        boolean z16 = false;
        if (photoBatch != null && (!photoBatch.isEmpty())) {
            z16 = true;
        }
        if (z16 && cb5 != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.impl.album.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.f(f.this, photoBatch, cb5);
                }
            });
        } else if (cb5 != null) {
            cb5.onResult(60002, "photoBatch is null");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public void getAlbumList(@Nullable IKernelWiFiPhotoGetAlbumListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cb5);
        } else {
            this.albumRepository.e(-1, new b(cb5), TabType.TAB_ALL, true);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public void getAllPhotoSimpleInfo(@Nullable String albumId, @Nullable IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) albumId, (Object) cb5);
            return;
        }
        try {
            WifiPhotoQueryHelper wifiPhotoQueryHelper = WifiPhotoQueryHelper.f317583a;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (albumId == null) {
                albumId = com.tencent.qqnt.qbasealbum.model.a.f361348a.a();
            }
            ArrayList<PhotoSimpleInfo> c16 = wifiPhotoQueryHelper.c(context, -1, albumId);
            if (cb5 != null) {
                cb5.onResult(0, "", c16);
            }
        } catch (Exception e16) {
            QLog.e("WifiPhotoAlbumService", 1, "getAllPhotoSimpleInfo error.", e16);
            if (cb5 != null) {
                cb5.onResult(60002, e16.getMessage(), new ArrayList<>());
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public void getPhoto(@Nullable String albumId, @Nullable String photoId, @Nullable IKernelWiFiPhotoGetPhotoCallback cb5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, albumId, photoId, cb5);
            return;
        }
        if (!TextUtils.isEmpty(photoId) && cb5 != null) {
            WifiPhotoQueryHelper wifiPhotoQueryHelper = WifiPhotoQueryHelper.f317583a;
            Intrinsics.checkNotNull(photoId);
            Pair<String, PhotoDetailInfo> e16 = wifiPhotoQueryHelper.e(photoId);
            if (e16.getFirst().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                cb5.onResult(0, "", e16.getFirst(), e16.getSecond());
                return;
            } else {
                cb5.onResult(60002, "photoId not exists", "", new PhotoDetailInfo());
                return;
            }
        }
        if (cb5 != null) {
            cb5.onResult(60002, "photoId not exists", "", new PhotoDetailInfo());
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public void getPhotoInfoBatch(@Nullable String albumId, @Nullable ArrayList<String> photoBatch, @Nullable IKernelWiFiPhotoGetPhotoInfoBatchCallback cb5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, albumId, photoBatch, cb5);
            return;
        }
        if (!TextUtils.isEmpty(albumId)) {
            if (photoBatch != null && (!photoBatch.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && cb5 != null) {
                try {
                    WifiPhotoQueryHelper wifiPhotoQueryHelper = WifiPhotoQueryHelper.f317583a;
                    Intrinsics.checkNotNull(albumId);
                    ArrayList<PhotoDetailInfo> f16 = wifiPhotoQueryHelper.f(albumId, photoBatch);
                    QLog.d("WifiPhotoAlbumService", 1, "getMediaInfoBatch mediaList: " + f16);
                    cb5.onResult(0, "", f16);
                    return;
                } catch (Exception e16) {
                    QLog.e("WifiPhotoAlbumService", 1, "getPhotoInfoBatch error.", e16);
                    cb5.onResult(60002, e16.getMessage(), new ArrayList<>());
                    return;
                }
            }
        }
        if (cb5 != null) {
            cb5.onResult(60002, "albumId: " + albumId + " or photoBatch: " + photoBatch + " is null", new ArrayList<>());
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public void getPhotoSimpleInfoForFirstView(@Nullable String albumId, int count, @Nullable IKernelWiFiPhotoGetAllPhotoSimpleInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, albumId, Integer.valueOf(count), cb5);
            return;
        }
        try {
            WifiPhotoQueryHelper wifiPhotoQueryHelper = WifiPhotoQueryHelper.f317583a;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (albumId == null) {
                albumId = com.tencent.qqnt.qbasealbum.model.a.f361348a.a();
            }
            ArrayList<PhotoSimpleInfo> c16 = wifiPhotoQueryHelper.c(context, count, albumId);
            if (cb5 != null) {
                cb5.onResult(0, "", c16);
            }
        } catch (Exception e16) {
            QLog.e("WifiPhotoAlbumService", 1, "getPhotoSimpleInfoForFirstView error.", e16);
            if (cb5 != null) {
                cb5.onResult(60002, e16.getMessage(), new ArrayList<>());
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoAlbumAccessDelegate
    public void getPhotoThumbWithConfig(@Nullable String photoId, @Nullable ThumbConfig config, @Nullable IKernelWiFiPhotoGetPhotoCallback cb5) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, photoId, config, cb5);
            return;
        }
        if (!TextUtils.isEmpty(photoId) && config != null && cb5 != null) {
            try {
                WifiPhotoQueryHelper wifiPhotoQueryHelper = WifiPhotoQueryHelper.f317583a;
                Intrinsics.checkNotNull(photoId);
                Pair<String, PhotoDetailInfo> e16 = wifiPhotoQueryHelper.e(photoId);
                IFileThumbGeneratorApi iFileThumbGeneratorApi = (IFileThumbGeneratorApi) QRoute.api(IFileThumbGeneratorApi.class);
                String first = e16.getFirst();
                Integer num2 = config.density;
                if (num2 != null) {
                    Intrinsics.checkNotNullExpressionValue(num2, "config.density");
                    if (num2.intValue() > 0) {
                        int intValue = config.maxSide.intValue();
                        Integer num3 = config.density;
                        Intrinsics.checkNotNullExpressionValue(num3, "config.density");
                        num = Integer.valueOf(intValue * num3.intValue());
                        Intrinsics.checkNotNullExpressionValue(num, "if (config.density != nu\u2026nsity else config.maxSide");
                        cb5.onResult(0, "", iFileThumbGeneratorApi.generateThumb("[thumb-wf]", first, num.intValue()), e16.getSecond());
                        return;
                    }
                }
                num = config.maxSide;
                Intrinsics.checkNotNullExpressionValue(num, "if (config.density != nu\u2026nsity else config.maxSide");
                cb5.onResult(0, "", iFileThumbGeneratorApi.generateThumb("[thumb-wf]", first, num.intValue()), e16.getSecond());
                return;
            } catch (Exception e17) {
                QLog.e("WifiPhotoAlbumService", 1, "getPhotoThumbWithConfig error.", e17);
                cb5.onResult(60002, e17.getMessage(), "", new PhotoDetailInfo());
                return;
            }
        }
        if (cb5 != null) {
            cb5.onResult(60002, "photoId is null", "", new PhotoDetailInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DialogInterface dialogInterface, int i3) {
    }
}
