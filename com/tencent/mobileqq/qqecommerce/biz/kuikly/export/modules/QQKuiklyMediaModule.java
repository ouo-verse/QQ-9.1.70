package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0002H\u0002JN\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0002J?\u0010\u001c\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016R'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyMediaModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "i", "videoPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Bitmap;", "l", "", "clipMaskType", "clipWidth", "clipHeight", "clipOutputWidth", "clipOutputHeight", "Ljava/util/ArrayList;", "imagePaths", "", "picIndexList", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lorg/json/JSONObject;", "p", "method", "call", "", "", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "d", "Lkotlin/Lazy;", "j", "()Ljava/util/Map;", "uploadTaskMap", "e", "Ljava/util/List;", "cropMediaPathList", "<init>", "()V", "f", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyMediaModule extends i01.e {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadTaskMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<String> cropMediaPathList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyMediaModule$a;", "", "", "filePath", "a", "b", "CHOOSE_MEDIA", "Ljava/lang/String;", "", "CROP_MAX_COUNT", "I", "CROP_MIN_COUNT", "MODULE_NAME", "STOP_UPLOAD_MEDIA", "TAG", "UPLOAD_MEDIA", "UPLOAD_PEER_UIN", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyMediaModule$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        
            r0 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r9, '.', 0, false, 6, (java.lang.Object) null);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String a(String filePath) {
            int lastIndexOf$default;
            if (TextUtils.isEmpty(filePath) || lastIndexOf$default <= 0) {
                return "";
            }
            String substring = filePath.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }

        public final String b(String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            String a16 = a(filePath);
            if (TextUtils.isEmpty(a16)) {
                return "";
            }
            return "." + a16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyMediaModule$c", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f262913a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f262914b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262915c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ITransFileController f262916d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQKuiklyMediaModule f262917e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j3, String str, Function1<Object, Unit> function1, ITransFileController iTransFileController, QQKuiklyMediaModule qQKuiklyMediaModule, Looper looper) {
            super(looper);
            this.f262913a = j3;
            this.f262914b = str;
            this.f262915c = function1;
            this.f262916d = iTransFileController;
            this.f262917e = qQKuiklyMediaModule;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Object valueOf;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
            FileMsg fileMsg = (FileMsg) obj;
            if (fileMsg.fileType != 24) {
                return;
            }
            if (this.f262913a != fileMsg.uniseq) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQKuiklyMediaModule", 2, "uploadImage--uniqueSeq not same,uniqueSeq:" + this.f262913a + ",uniseq:" + fileMsg.uniseq);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQKuiklyMediaModule", 2, "uploadImage--transProcessorHandler--handleMessage: what=" + msg2.what);
            }
            switch (msg2.what) {
                case 1002:
                    JSONObject jSONObject = new JSONObject();
                    String str = this.f262914b;
                    long j3 = this.f262913a;
                    jSONObject.put("state", "onProgress");
                    jSONObject.put("path", str);
                    jSONObject.put("uploadSeq", j3);
                    JSONObject jSONObject2 = new JSONObject();
                    long j16 = fileMsg.fileSize;
                    if (j16 <= 0) {
                        valueOf = 0;
                    } else {
                        valueOf = Float.valueOf((((float) fileMsg.transferedSize) * 1.0f) / ((float) j16));
                    }
                    jSONObject2.put("progress", valueOf);
                    Unit unit = Unit.INSTANCE;
                    jSONObject.put("data", jSONObject2);
                    this.f262915c.invoke(jSONObject);
                    return;
                case 1003:
                    Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                    try {
                        uploadPicExtInfo.mergeFrom(fileMsg.bdhExtendInfo);
                        uploadPicExtInfo.bytes_file_resid.get().toStringUtf8();
                        String stringUtf8 = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                        String stringUtf82 = uploadPicExtInfo.bytes_thumb_download_url.get().toStringUtf8();
                        if (QLog.isColorLevel()) {
                            QLog.i("QQKuiklyMediaModule", 2, "handleMessage imagePath[" + this.f262914b + "],imageUrl[" + stringUtf8 + "], imageThumbUrl" + stringUtf82 + ",uniqueSeq:" + this.f262913a + ",file-uniseq" + fileMsg.uniseq + "]");
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        String str2 = this.f262914b;
                        long j17 = this.f262913a;
                        jSONObject3.put("state", "onFinish");
                        jSONObject3.put("path", str2);
                        jSONObject3.put("url", stringUtf8);
                        jSONObject3.put("uploadSeq", j17);
                        this.f262915c.invoke(jSONObject3);
                    } catch (Exception e16) {
                        QLog.e("QQKuiklyMediaModule", 1, e16, new Object[0]);
                    }
                    this.f262916d.removeHandle(this);
                    this.f262917e.j().remove(Long.valueOf(this.f262913a));
                    return;
                case 1004:
                case 1005:
                    JSONObject jSONObject4 = new JSONObject();
                    String str3 = this.f262914b;
                    long j18 = this.f262913a;
                    jSONObject4.put("state", "onFail");
                    jSONObject4.put("path", str3);
                    jSONObject4.put("uploadSeq", j18);
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("errorCode", fileMsg.errorCode);
                    Unit unit2 = Unit.INSTANCE;
                    jSONObject4.put("data", jSONObject5);
                    this.f262915c.invoke(jSONObject4);
                    this.f262916d.removeHandle(this);
                    this.f262917e.j().remove(Long.valueOf(this.f262913a));
                    return;
                default:
                    return;
            }
        }
    }

    public QQKuiklyMediaModule() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Map<Long, TransferRequest>>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyMediaModule$uploadTaskMap$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<Long, TransferRequest> invoke() {
                return new LinkedHashMap();
            }
        });
        this.uploadTaskMap = lazy;
        this.cropMediaPathList = new ArrayList();
    }

    private final void i(String params, Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyMediaModule", 1, "chooseMedia");
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        int optInt = k06.optInt("maxCount");
        int optInt2 = k06.optInt("mediaType");
        boolean optBoolean = k06.optBoolean("needClip");
        int optInt3 = k06.optInt("clipMaskType");
        int dpToPx = ViewUtils.dpToPx(k06.optInt("clipWidth"));
        int dpToPx2 = ViewUtils.dpToPx(k06.optInt("clipHeight"));
        int dpToPx3 = ViewUtils.dpToPx(k06.optInt("clipOutputWidth"));
        int dpToPx4 = ViewUtils.dpToPx(k06.optInt("clipOutputHeight"));
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getActivity(), IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 60);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).getPhotoListCustomizationAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).getPhotoPreviewCustomizationAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, "com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO");
        activityURIRequest.extra().putBoolean(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, true);
        activityURIRequest.extra().putBoolean(PeakConstants.ALBUM_SHOW_ORI_BUTTON, false);
        activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        activityURIRequest.extra().putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, false);
        activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, optInt2);
        Bundle extra = activityURIRequest.extra();
        if (optInt < 0) {
            optInt = 1;
        }
        extra.putInt("PhotoConst.MAXUM_SELECTED_NUM", optInt);
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1061);
        Bundle extra2 = activityURIRequest.extra();
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        extra2.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putBoolean(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        activityURIRequest.extra().putBoolean(QAlbumConstants.ALBUM_ENTER_DIRECTLY, true);
        activityURIRequest.setRequestCode(10026);
        activityURIRequest.setFlags(603979776);
        if (callback != null) {
            addKuiklyRenderLifecycleCallback(new b(callback, optBoolean, optInt3, dpToPx, dpToPx2, dpToPx3, dpToPx4));
            QRoute.startUri(activityURIRequest);
            QAlbumUtil.anim(getActivity(), false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Long, TransferRequest> j() {
        return (Map) this.uploadTaskMap.getValue();
    }

    private final Bitmap l(String videoPath) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(videoPath);
        Bitmap bitmap = null;
        try {
            bitmap = mediaMetadataRetriever.getFrameAtTime(500L, 2);
            if (bitmap == null) {
                bitmap = mediaMetadataRetriever.getFrameAtTime(500L, 0);
            }
            if (bitmap == null) {
                bitmap = mediaMetadataRetriever.getFrameAtTime(500L, 3);
            }
        } catch (Exception e16) {
            QLog.e("QQKuiklyMediaModule", 1, "getVideoCoverBitmap exception:", e16);
        } catch (OutOfMemoryError e17) {
            QLog.e("QQKuiklyMediaModule", 1, "getVideoCoverBitmap oom:", e17);
        }
        mediaMetadataRetriever.release();
        if (bitmap == null) {
            QLog.e("QQKuiklyMediaModule", 1, "getVideoCoverBitmap bitmap null");
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m(String videoPath) {
        Bitmap l3 = l(videoPath);
        if (l3 == null) {
            QLog.e("QQKuiklyMediaModule", 1, "getVideoCoverImgPath bitmap null");
            return null;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("kuikly/qqgame/cover_" + MD5.toMD5(videoPath) + ".tmp");
        File parentFile = new File(sDKPrivatePath).getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        QLog.d("QQKuiklyMediaModule", 1, "getVideoCoverImgPath result: " + com.tencent.biz.qqstory.utils.b.b(l3, sDKPrivatePath));
        return sDKPrivatePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int clipMaskType, int clipWidth, int clipHeight, int clipOutputWidth, int clipOutputHeight, ArrayList<String> imagePaths, List<Integer> picIndexList) {
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", clipMaskType);
        intent.putExtra(PeakConstants.CLIP_WIDTH, clipWidth);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, clipHeight);
        intent.putExtra(PeakConstants.TARGET_WIDTH, clipOutputWidth);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, clipOutputHeight);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        this.cropMediaPathList.clear();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (imagePaths != null) {
            int i3 = 0;
            for (Object obj : imagePaths) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                if (picIndexList.contains(Integer.valueOf(i3))) {
                    arrayList.add(str);
                    String cropImagePath = VFSAssistantUtils.getSDKPrivatePath("kuikly/qqgame/" + System.currentTimeMillis() + "_" + i3 + ".tmp");
                    arrayList2.add(cropImagePath);
                    List<String> list = this.cropMediaPathList;
                    Intrinsics.checkNotNullExpressionValue(cropImagePath, "cropImagePath");
                    list.add(cropImagePath);
                } else {
                    this.cropMediaPathList.add(str);
                }
                i3 = i16;
            }
        }
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList);
        intent.putStringArrayListExtra(PeakConstants.TARGET_PATH, arrayList2);
        IMetaDreamApi iMetaDreamApi = (IMetaDreamApi) QRoute.api(IMetaDreamApi.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        iMetaDreamApi.openImageCropFragment(activity, intent, 10027);
    }

    private final JSONObject p(String params, Function1<Object, Unit> callback) {
        long optLong = KRCSSViewExtensionKt.k0(params).optLong("uploadSeq");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null && (getActivity() instanceof AppActivity)) {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type mqq.app.AppActivity");
            peekAppRuntime = ((AppActivity) activity).getAppRuntime();
        }
        if (peekAppRuntime == null) {
            QLog.e("QQKuiklyMediaModule", 1, "stopUploadMedia appRuntime is null");
            return new JSONObject();
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITransFileController.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ITransFileController iTransFileController = (ITransFileController) runtimeService;
        TransferRequest transferRequest = j().get(Long.valueOf(optLong));
        if (transferRequest == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", "-1");
            jSONObject.put("message", "no task");
            return jSONObject;
        }
        iTransFileController.stop(transferRequest);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ret", 0);
        return jSONObject2;
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1698152435) {
            if (hashCode != 544732417) {
                if (hashCode == 1047923299 && method.equals("uploadMedia")) {
                    q(params, callback);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("stopUploadMedia")) {
                return p(params, callback);
            }
        } else if (method.equals("chooseMedia")) {
            i(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    private final void q(String params, Function1<Object, Unit> callback) {
        if (callback != null) {
            JSONObject k06 = KRCSSViewExtensionKt.k0(params);
            int optInt = k06.optInt("commandId");
            String optString = k06.optString("richTag");
            String imagePath = k06.optString("mediaPath");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null && (getActivity() instanceof AppActivity)) {
                Activity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type mqq.app.AppActivity");
                peekAppRuntime = ((AppActivity) activity).getAppRuntime();
            }
            AppRuntime appRuntime = peekAppRuntime;
            if (appRuntime == null) {
                QLog.e("QQKuiklyMediaModule", 1, "uploadMedia appRuntime is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() + ((long) (Math.random() * 10000));
            IRuntimeService runtimeService = appRuntime.getRuntimeService(ITransFileController.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            ITransFileController iTransFileController = (ITransFileController) runtimeService;
            c cVar = new c(currentTimeMillis, imagePath, callback, iTransFileController, this, ThreadManagerV2.getQQCommonThreadLooper());
            cVar.addFilter(BDHCommonUploadProcessor.class);
            iTransFileController.addHandle(cVar);
            TransferRequest transferRequest = new TransferRequest();
            transferRequest.mIsUp = true;
            transferRequest.mLocalPath = imagePath;
            transferRequest.mFileType = 24;
            transferRequest.mCommandId = optInt;
            transferRequest.mRichTag = optString;
            transferRequest.mPeerUin = "0";
            transferRequest.mUniseq = currentTimeMillis;
            transferRequest.mSelfUin = appRuntime.getCurrentAccountUin();
            Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
            commFileExtReq.uint32_action_type.set(0);
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
            String b16 = companion.b(imagePath);
            QLog.i("QQKuiklyMediaModule", 1, "[uploadMedia] imagePath:" + imagePath);
            commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + b16));
            transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
            iTransFileController.transferAsync(transferRequest);
            j().put(Long.valueOf(currentTimeMillis), transferRequest);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyMediaModule$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.kuikly.core.render.android.c {
        final /* synthetic */ int C;
        final /* synthetic */ int D;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262908e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f262909f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f262910h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f262911i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f262912m;

        b(Function1<Object, Unit> function1, boolean z16, int i3, int i16, int i17, int i18, int i19) {
            this.f262908e = function1;
            this.f262909f = z16;
            this.f262910h = i3;
            this.f262911i = i16;
            this.f262912m = i17;
            this.C = i18;
            this.D = i19;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            boolean z16;
            c.a.a(this, requestCode, resultCode, data);
            QLog.d("QQKuiklyMediaModule", 1, "onActivityResult requestCode:" + requestCode + ", resultCode" + resultCode);
            if (10026 != requestCode) {
                if (10027 == requestCode) {
                    if (resultCode == -1) {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        List<String> list = QQKuiklyMediaModule.this.cropMediaPathList;
                        QQKuiklyMediaModule qQKuiklyMediaModule = QQKuiklyMediaModule.this;
                        for (String str : list) {
                            File file = new File(str);
                            if ((str.length() > 0) && file.exists() && file.length() > 0) {
                                jSONArray.mo162put(str);
                                if (com.tencent.mobileqq.filemanager.util.ah.o0(str) == 2) {
                                    String m3 = qQKuiklyMediaModule.m(str);
                                    if (!(m3 == null || m3.length() == 0)) {
                                        jSONObject.put(str, m3);
                                    }
                                }
                            }
                        }
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("imagePaths", jSONArray);
                            jSONObject2.put("coverInfo", jSONObject);
                            this.f262908e.invoke(jSONObject2);
                        }
                        QQKuiklyMediaModule.this.cropMediaPathList.clear();
                    }
                    QQKuiklyMediaModule.this.removeKuiklyRenderLifeCycleCallback(this);
                    return;
                }
                return;
            }
            if (data != null) {
                boolean z17 = this.f262909f;
                QQKuiklyMediaModule qQKuiklyMediaModule2 = QQKuiklyMediaModule.this;
                int i3 = this.f262910h;
                int i16 = this.f262911i;
                int i17 = this.f262912m;
                int i18 = this.C;
                int i19 = this.D;
                Function1<Object, Unit> function1 = this.f262908e;
                ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra(PeakConstants.INPULT_FULL_SCREEN_RESULT);
                ArrayList arrayList = new ArrayList();
                if (z17 && stringArrayListExtra != null) {
                    int i26 = 0;
                    for (Object obj : stringArrayListExtra) {
                        int i27 = i26 + 1;
                        if (i26 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        if (com.tencent.mobileqq.filemanager.util.ah.o0((String) obj) != 2) {
                            arrayList.add(Integer.valueOf(i26));
                        }
                        i26 = i27;
                    }
                }
                boolean z18 = z17 && arrayList.size() >= 1 && arrayList.size() <= 5;
                QLog.d("QQKuiklyMediaModule", 1, "onActivityResult isClipAvailable:" + z18);
                if (z18) {
                    qQKuiklyMediaModule2.o(i3, i16, i17, i18, i19, stringArrayListExtra, arrayList);
                } else {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject4 = new JSONObject();
                    if (stringArrayListExtra != null) {
                        for (String path : stringArrayListExtra) {
                            jSONArray2.mo162put(path);
                            if (com.tencent.mobileqq.filemanager.util.ah.o0(path) == 2) {
                                Intrinsics.checkNotNullExpressionValue(path, "path");
                                String m16 = qQKuiklyMediaModule2.m(path);
                                if (!(m16 == null || m16.length() == 0)) {
                                    jSONObject4.put(path, m16);
                                }
                            }
                        }
                    }
                    jSONObject3.put("imagePaths", jSONArray2);
                    jSONObject3.put("coverInfo", jSONObject4);
                    function1.invoke(jSONObject3);
                }
                z16 = z18;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            QQKuiklyMediaModule.this.removeKuiklyRenderLifeCycleCallback(this);
        }
    }
}
