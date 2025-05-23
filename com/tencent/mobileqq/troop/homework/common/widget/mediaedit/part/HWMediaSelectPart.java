package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.util.InputMethodUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0002>?B\u0011\u0012\b\b\u0002\u00101\u001a\u00020,\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J+\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001dH\u0002J\u001c\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0016H\u0017J\"\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "maxNum", "", "I9", "H9", "filter", "J9", "K9", "", "", "permissions", "Lkotlin/Function0;", "granted", "G9", "([Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "", "F9", "Landroid/content/Intent;", "data", "C9", "B9", "intent", "D9", "E9", "", "size", "maxSizeMB", "A9", "maxSize", "L9", "action", "", "args", "handleBroadcastMessage", "newIntent", "onNewIntent", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart$SourceType;", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart$SourceType;", "getSource", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart$SourceType;", "source", "e", "[Ljava/lang/String;", "storagePermissions", "f", "cameraPermissions", "Landroid/net/Uri;", tl.h.F, "Landroid/net/Uri;", "captureUri", "<init>", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart$SourceType;)V", "i", "a", "SourceType", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWMediaSelectPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SourceType source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] storagePermissions;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] cameraPermissions;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Uri captureUri;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart$SourceType;", "", "(Ljava/lang/String;I)V", "SUBMIT_HW", "HW_NOTICE", "TROOP_INVITE_TEAM", "HW_CLOCK", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class SourceType {
        private static final /* synthetic */ SourceType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SourceType HW_CLOCK;
        public static final SourceType HW_NOTICE;
        public static final SourceType SUBMIT_HW;
        public static final SourceType TROOP_INVITE_TEAM;

        private static final /* synthetic */ SourceType[] $values() {
            return new SourceType[]{SUBMIT_HW, HW_NOTICE, TROOP_INVITE_TEAM, HW_CLOCK};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49598);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            SUBMIT_HW = new SourceType("SUBMIT_HW", 0);
            HW_NOTICE = new SourceType("HW_NOTICE", 1);
            TROOP_INVITE_TEAM = new SourceType("TROOP_INVITE_TEAM", 2);
            HW_CLOCK = new SourceType("HW_CLOCK", 3);
            $VALUES = $values();
        }

        SourceType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static SourceType valueOf(String str) {
            return (SourceType) Enum.valueOf(SourceType.class, str);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart$a;", "", "", "FILE_MAX_MB_MEDIA", "J", "FILE_MAX_MB_NORMAL", "", "KEY_REQ_SELECT_MEDIA", "Ljava/lang/String;", "", "REQ_CAPTURE_MEDIA", "I", "REQ_SELECT_FILE", "REQ_SELECT_MEDIA", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f296816a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49599);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[SourceType.values().length];
            try {
                iArr[SourceType.HW_NOTICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SourceType.TROOP_INVITE_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SourceType.HW_CLOCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SourceType.SUBMIT_HW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f296816a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWMediaSelectPart$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f296817a;

        c(Function0<Unit> function0) {
            this.f296817a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                this.f296817a.invoke();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49610);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWMediaSelectPart(@NotNull SourceType source) {
        Intrinsics.checkNotNullParameter(source, "source");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) source);
            return;
        }
        this.source = source;
        this.storagePermissions = new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
        this.cameraPermissions = new String[]{QQPermissionConstants.Permission.CAMERA};
    }

    private final boolean A9(long size, long maxSizeMB) {
        long j3 = 1024;
        if (size < maxSizeMB * j3 * j3) {
            return true;
        }
        return false;
    }

    private final void B9() {
        boolean z16;
        QLog.i("HW.MediaEdit.HWImageSelectPart", 1, "handleCaptureMediaResult: " + this.captureUri);
        if (this.captureUri == null) {
            QLog.e("HW.MediaEdit.HWImageSelectPart", 1, "onActivityResult, but capture uri is empty!");
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        String path = BaseImageUtil.getRealPathFromContentURI(activity, this.captureUri);
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("HW.MediaEdit.HWImageSelectPart", 1, "onActivityResult, but path is empty!");
        } else {
            if (!NetworkUtil.isNetSupport(activity)) {
                ToastUtil.a().b(R.string.f171375ei3);
                return;
            }
            BaseImageUtil.savePhotoToSysAlbum(activity, path);
            Intrinsics.checkNotNullExpressionValue(path, "path");
            broadcastMessage("select_capture_finish", new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b(path));
        }
    }

    private final void C9(Intent data) {
        FileInfo fileInfo;
        boolean z16;
        int collectionSizeOrDefault;
        Object obj;
        if (data == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = data.getParcelableArrayListExtra("reslut_select_file_info_list");
        ArrayList<FileInfo> arrayList = null;
        if (parcelableArrayListExtra != null) {
            Iterator it = parcelableArrayListExtra.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (!A9(((FileInfo) obj).l(), 100L)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            fileInfo = (FileInfo) obj;
        } else {
            fileInfo = null;
        }
        if (fileInfo != null) {
            L9(100L);
        }
        if (parcelableArrayListExtra != null) {
            arrayList = new ArrayList();
            for (Object obj2 : parcelableArrayListExtra) {
                if (A9(((FileInfo) obj2).l(), 100L)) {
                    arrayList.add(obj2);
                }
            }
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("HW.MediaEdit.HWImageSelectPart", 1, "fileInfoList is empty.");
            return;
        }
        QLog.i("HW.MediaEdit.HWImageSelectPart", 1, "handleSelectFileResult: " + arrayList.size());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (FileInfo fileInfo2 : arrayList) {
            String j3 = fileInfo2.j();
            Intrinsics.checkNotNullExpressionValue(j3, "it.name");
            String k3 = fileInfo2.k();
            Intrinsics.checkNotNullExpressionValue(k3, "it.path");
            arrayList2.add(new f(j3, k3, fileInfo2.l(), fileInfo2.getType()));
        }
        broadcastMessage("select_file_finish", new g(arrayList2));
    }

    private final void D9(Intent intent) {
        boolean z16;
        HashMap hashMap;
        int collectionSizeOrDefault;
        int mediaType;
        long j3;
        boolean z17;
        int i3;
        int i16;
        long j16;
        long j17;
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("HW.MediaEdit.HWImageSelectPart", 1, "selected data is empty.");
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        Object obj = null;
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new LinkedHashMap();
        }
        Iterator<T> it = stringArrayListExtra.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) hashMap.get((String) next);
            if (localMediaInfo != null) {
                j17 = localMediaInfo.fileSize;
            } else {
                j17 = 0;
            }
            if (!A9(j17, 1024L)) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            L9(1024L);
        }
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj2 : stringArrayListExtra) {
            LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) hashMap.get((String) obj2);
            if (localMediaInfo2 != null) {
                j16 = localMediaInfo2.fileSize;
            } else {
                j16 = 0;
            }
            if (A9(j16, 1024L)) {
                arrayList.add(obj2);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (String it5 : arrayList) {
            if (hashMap.containsKey(it5)) {
                mediaType = QAlbumUtil.getMediaType((LocalMediaInfo) hashMap.get(it5));
            } else {
                mediaType = QAlbumUtil.getMediaType(it5);
            }
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            LocalMediaInfo localMediaInfo3 = (LocalMediaInfo) hashMap.get(it5);
            if (localMediaInfo3 != null) {
                j3 = localMediaInfo3.fileSize;
            } else {
                j3 = 0;
            }
            if (mediaType == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            LocalMediaInfo localMediaInfo4 = (LocalMediaInfo) hashMap.get(it5);
            if (localMediaInfo4 != null) {
                i3 = localMediaInfo4.mediaWidth;
            } else {
                i3 = 0;
            }
            LocalMediaInfo localMediaInfo5 = (LocalMediaInfo) hashMap.get(it5);
            if (localMediaInfo5 != null) {
                i16 = localMediaInfo5.mediaHeight;
            } else {
                i16 = 0;
            }
            arrayList2.add(new h(it5, j3, z17, i3, i16));
        }
        QLog.i("HW.MediaEdit.HWImageSelectPart", 1, "handleSelectMediaResult: " + arrayList2.size());
        broadcastMessage("select_media_finish", new i(arrayList2));
    }

    private final void E9(Intent intent) {
        AlbumResult albumResult;
        List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> e16;
        h hVar;
        if (intent == null || (albumResult = (AlbumResult) intent.getParcelableExtra("ALBUM_RESULT")) == null || (e16 = albumResult.e()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = e16.iterator();
        while (true) {
            boolean z16 = true;
            if (it.hasNext()) {
                com.tencent.qqnt.qbasealbum.model.LocalMediaInfo localMediaInfo = (com.tencent.qqnt.qbasealbum.model.LocalMediaInfo) it.next();
                String path = localMediaInfo.getPath();
                if (path != null) {
                    long fileSize = localMediaInfo.getFileSize();
                    if (QAlbumUtil.getMediaType(localMediaInfo.getPath()) != 1) {
                        z16 = false;
                    }
                    hVar = new h(path, fileSize, z16, localMediaInfo.getMediaWidth(), localMediaInfo.getMediaHeight());
                } else {
                    hVar = null;
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
            } else {
                QLog.i("HW.MediaEdit.HWImageSelectPart", 1, "handleSelectMediaResult: " + arrayList.size());
                broadcastMessage("select_media_finish", new i(arrayList));
                return;
            }
        }
    }

    private final boolean F9(String permission, QQPermission qqPermission) {
        if (qqPermission.hasPermission(permission) == 0) {
            return true;
        }
        return false;
    }

    private final void G9(String[] permissions, Function0<Unit> granted) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026,\n            )\n        )");
        int i3 = b.f296816a[this.source.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK_CLOCK));
                    Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026      )\n                )");
                }
            } else {
                qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_INVITE_TEAM));
                Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026      )\n                )");
            }
        } else {
            qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK_NOTICE));
            Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026      )\n                )");
        }
        ArrayList arrayList = new ArrayList(permissions.length);
        for (String str : permissions) {
            arrayList.add(Boolean.valueOf(F9(str, qQPermission)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((Boolean) obj).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.size() == 0) {
            granted.invoke();
        } else {
            qQPermission.requestPermissions(permissions, 2, new c(granted));
        }
    }

    private final void H9() {
        G9(this.cameraPermissions, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart$startCaptureMedia$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWMediaSelectPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HWMediaSelectPart.this.captureUri = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(HWMediaSelectPart.this.getActivity(), 101);
                QLog.i("HW.MediaEdit.HWImageSelectPart", 1, "startCaptureMedia, " + HWMediaSelectPart.this.captureUri);
                InputMethodUtil.hide(HWMediaSelectPart.this.getActivity());
            }
        });
    }

    private final void I9(final int maxNum) {
        G9(this.storagePermissions, new Function0<Unit>(maxNum) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart$startSelectFile$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $maxNum;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$maxNum = maxNum;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWMediaSelectPart.this, maxNum);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList<String> arrayListOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (HWMediaSelectPart.this.getActivity() == null) {
                    return;
                }
                IQQFileSelector iQQFileSelector = (IQQFileSelector) QRoute.api(IQQFileSelector.class);
                Activity activity = HWMediaSelectPart.this.getActivity();
                int i3 = this.$maxNum;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("all");
                iQQFileSelector.fileChooseLaunchForResult(activity, 102, i3, arrayListOf);
            }
        });
    }

    private final void J9(final int maxNum, final int filter) {
        G9(this.storagePermissions, new Function0<Unit>(maxNum, filter) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart$startSelectMedia$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $filter;
            final /* synthetic */ int $maxNum;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$maxNum = maxNum;
                this.$filter = filter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, HWMediaSelectPart.this, Integer.valueOf(maxNum), Integer.valueOf(filter));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                InputMethodUtil.hide(HWMediaSelectPart.this.getActivity());
                ITroopHWApi iTroopHWApi = (ITroopHWApi) QRoute.api(ITroopHWApi.class);
                int i3 = this.$maxNum;
                Activity activity = HWMediaSelectPart.this.getActivity();
                AppInterface e16 = bg.e();
                Intent selectMediaIntent = iTroopHWApi.getSelectMediaIntent(i3, activity, e16 != null ? e16.getCurrentAccountUin() : null);
                selectMediaIntent.putExtra("req_select_media", 100);
                selectMediaIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
                selectMediaIntent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, this.$filter);
                HWMediaSelectPart.this.getActivity().startActivityForResult(selectMediaIntent, 100);
            }
        });
    }

    private final void K9(final int maxNum, final int filter) {
        G9(this.storagePermissions, new Function0<Unit>(maxNum, filter) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart$startSelectMediaV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $filter;
            final /* synthetic */ int $maxNum;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$maxNum = maxNum;
                this.$filter = filter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, HWMediaSelectPart.this, Integer.valueOf(maxNum), Integer.valueOf(filter));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                InputMethodUtil.hide(HWMediaSelectPart.this.getActivity());
                com.tencent.mobileqq.troop.homework.album.a aVar = new com.tencent.mobileqq.troop.homework.album.a();
                int i3 = this.$maxNum;
                Context context = HWMediaSelectPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                HWMediaSelectPart.this.getActivity().startActivityForResult(aVar.e(i3, context, this.$filter == 4), 100);
            }
        });
    }

    private final void L9(long maxSize) {
        ToastUtil.a().e("\u4e0a\u4f20\u9650\u5236\u6700\u5927" + maxSize + "M");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) action, args);
            return;
        }
        if (Intrinsics.areEqual(action, "start_select_media") && (args instanceof k)) {
            if (((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn()) {
                k kVar = (k) args;
                K9(kVar.b(), kVar.a());
                return;
            } else {
                k kVar2 = (k) args;
                J9(kVar2.b(), kVar2.a());
                return;
            }
        }
        if (Intrinsics.areEqual(action, "start_capture_media")) {
            H9();
        } else if (Intrinsics.areEqual(action, "start_select_file") && (args instanceof j)) {
            I9(((j) args).a());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        QLog.i("HW.MediaEdit.HWImageSelectPart", 1, "on activity result: " + requestCode + ", " + resultCode);
        if (resultCode != -1) {
            return;
        }
        switch (requestCode) {
            case 100:
                if (!((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn()) {
                    return;
                }
                E9(data);
                return;
            case 101:
                B9();
                return;
            case 102:
                C9(data);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Deprecated(message = "Deprecated in Java")
    public void onNewIntent(@Nullable Intent newIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newIntent);
            return;
        }
        super.onNewIntent(newIntent);
        if (((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn() || newIntent == null || newIntent.getIntExtra("req_select_media", 0) != 100) {
            return;
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            ToastUtil.a().b(R.string.f171375ei3);
        } else {
            D9(newIntent);
        }
    }
}
