package com.tencent.mobileqq.zplan.avatar.upload;

import android.graphics.BitmapFactory;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.api.IRuntimeService;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J:\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J \u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/upload/a;", "", "", "zplanAvatarType", "", "a", "type", "f", "Lcom/tencent/mobileqq/util/ProfileCardUtil$a;", "avatarUploadResult", "", "d", "Lcom/tencent/common/app/AppInterface;", "app", "filePath", "", TagName.FILE_TYPE, "", "isSyncQZone", "isApngAvatar", "Lcom/tencent/mobileqq/zplan/avatar/upload/a$a;", "zplanAvatarInfo", "e", "c", "avatarFilePath", "needCheckWh", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f331975a = new a();

    a() {
    }

    private final String a(byte zplanAvatarType) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("NoPush", zplanAvatarType == 1 ? 1 : 0);
        } catch (JSONException e16) {
            QLog.e("ZPlanAvatarUploadUtils", 1, "buildUploadZplanOutboundAvatarExtJsonInfo ", e16);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    private final void d(ProfileCardUtil.a avatarUploadResult) {
        QLog.i("ZPlanAvatarUploadUtils", 1, "onAvatarChanged, reason = [" + avatarUploadResult.f306431b + "], code = [" + avatarUploadResult.f306430a + "]");
    }

    private final byte f(byte type) {
        boolean z16;
        if (type >= 0 && type < 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return (byte) 0;
        }
        return type;
    }

    public final ProfileCardUtil.a b(AppInterface app, String avatarFilePath, boolean needCheckWh) {
        Intrinsics.checkNotNullParameter(app, "app");
        ProfileCardUtil.a aVar = new ProfileCardUtil.a();
        if (!NetworkUtil.isNetSupport(app.getApp())) {
            aVar.f306430a = -10001;
            aVar.f306431b = "network error";
            d(aVar);
            return aVar;
        }
        if (avatarFilePath == null || avatarFilePath.length() == 0) {
            aVar.f306430a = -10000;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST;
            d(aVar);
            return aVar;
        }
        File file = new File(avatarFilePath);
        if (!file.exists()) {
            aVar.f306430a = -10000;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST;
            d(aVar);
            return aVar;
        }
        long length = file.length();
        if (length <= 0) {
            aVar.f306430a = -10000;
            aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL;
            d(aVar);
            return aVar;
        }
        if (needCheckWh) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(avatarFilePath, options);
            int i3 = options.outWidth;
            if (i3 != options.outHeight || i3 <= 0 || i3 > 1080) {
                aVar.f306430a = -10000;
                aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL;
                d(aVar);
                return aVar;
            }
        }
        QLog.d("Q.profilecard.Avatar", 1, "onAvatarChanged|start upload : size = " + length);
        aVar.f306430a = 0;
        aVar.f306431b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        return aVar;
    }

    public final void e(AppInterface app, String filePath, int fileType, boolean isSyncQZone, boolean isApngAvatar, ZplanAvatarInfo zplanAvatarInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = filePath;
        transferRequest.mFileType = fileType;
        transferRequest.mUniseq = System.currentTimeMillis();
        pu.a aVar = new pu.a();
        aVar.c(isSyncQZone ? (byte) 1 : (byte) 0);
        aVar.c((byte) (isApngAvatar ? 5 : 0));
        if (zplanAvatarInfo != null) {
            byte f16 = f(zplanAvatarInfo.getZplanAvatarType());
            aVar.c(f16);
            QLog.i("ZPlanAvatarUploadUtils", 1, "transValidZplanAvatarType = " + ((int) f16) + ", background id: " + zplanAvatarInfo.getZplanAvatarBgUrlId());
            if (f16 > 1) {
                transferRequest.mCommandId = 90;
                aVar.c((byte) ((zplanAvatarInfo.getZplanAvatarBgUrlId() >> 8) & 255));
                aVar.c((byte) (zplanAvatarInfo.getZplanAvatarBgUrlId() & 255));
                aVar.c(zplanAvatarInfo.getZplanAvatarClipPercent());
            } else {
                aVar.c((byte) 0);
                aVar.c((byte) 0);
                aVar.c((byte) 0);
                if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn()) {
                    String a16 = a(f16);
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = a16.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    if (bytes != null) {
                        int length = bytes.length;
                        if (1 <= length && length < 501) {
                            int length2 = bytes.length;
                            QLog.i("ZPlanAvatarUploadUtils", 2, "requestUploadAvatar extInfoJson[" + length2 + "] json: " + a16);
                            aVar.c((byte) ((length2 >> 8) & 255));
                            aVar.c((byte) (length2 & 255));
                            byte[] bytes2 = a16.getBytes(charset);
                            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                            for (byte b16 : bytes2) {
                                aVar.c(b16);
                            }
                        }
                    }
                }
            }
        }
        transferRequest.mExtentionInfo = aVar.a();
        IRuntimeService runtimeService = app.getRuntimeService(ITransFileController.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        QLog.i("ZPlanEditAvatarManager-ZPlanAvatarUploadUtils", 2, "requestUploadAvatar " + transferRequest.getKeyForTransfer());
        ((ITransFileController) runtimeService).transferAsync(transferRequest);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/upload/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "B", "c", "()B", "zplanAvatarType", "b", "I", "()I", "zplanAvatarBgUrlId", "zplanAvatarClipPercent", "<init>", "(BIB)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.upload.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class ZplanAvatarInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final byte zplanAvatarType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int zplanAvatarBgUrlId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final byte zplanAvatarClipPercent;

        public ZplanAvatarInfo(byte b16, int i3, byte b17) {
            this.zplanAvatarType = b16;
            this.zplanAvatarBgUrlId = i3;
            this.zplanAvatarClipPercent = b17;
        }

        /* renamed from: a, reason: from getter */
        public final int getZplanAvatarBgUrlId() {
            return this.zplanAvatarBgUrlId;
        }

        /* renamed from: b, reason: from getter */
        public final byte getZplanAvatarClipPercent() {
            return this.zplanAvatarClipPercent;
        }

        /* renamed from: c, reason: from getter */
        public final byte getZplanAvatarType() {
            return this.zplanAvatarType;
        }

        public int hashCode() {
            return (((this.zplanAvatarType * 31) + this.zplanAvatarBgUrlId) * 31) + this.zplanAvatarClipPercent;
        }

        public String toString() {
            byte b16 = this.zplanAvatarType;
            return "ZplanAvatarInfo(zplanAvatarType=" + ((int) b16) + ", zplanAvatarBgUrlId=" + this.zplanAvatarBgUrlId + ", zplanAvatarClipPercent=" + ((int) this.zplanAvatarClipPercent) + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZplanAvatarInfo)) {
                return false;
            }
            ZplanAvatarInfo zplanAvatarInfo = (ZplanAvatarInfo) other;
            return this.zplanAvatarType == zplanAvatarInfo.zplanAvatarType && this.zplanAvatarBgUrlId == zplanAvatarInfo.zplanAvatarBgUrlId && this.zplanAvatarClipPercent == zplanAvatarInfo.zplanAvatarClipPercent;
        }
    }

    public final String c(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return filePath;
        }
        CompressInfo compressInfo = new CompressInfo(filePath, 0);
        compressInfo.K = 0;
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        return compressInfo.H;
    }
}
