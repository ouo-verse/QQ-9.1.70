package com.tencent.upload.uinterface.data;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PhotoWallUploadTask extends AbstractUploadTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PhotoWallUploadTask";
    public boolean autoRotate;
    public String clientIp;
    public int iUploadType;
    public boolean mDeleteFileAfterUpload;

    /* renamed from: op, reason: collision with root package name */
    public int f383923op;
    public int source;
    public String title;

    public PhotoWallUploadTask(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.autoRotate = false;
            this.iUploadType = 0;
        }
    }

    private byte[] createDescInfor(PhotoWallUploadTask photoWallUploadTask) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("op", photoWallUploadTask.f383923op);
        jSONObject.put("source", photoWallUploadTask.source);
        if (!TextUtils.isEmpty(photoWallUploadTask.clientIp)) {
            jSONObject.put("ip", photoWallUploadTask.clientIp);
        }
        if (!TextUtils.isEmpty(photoWallUploadTask.title)) {
            jSONObject.put("title", photoWallUploadTask.title);
        }
        return jSONObject.toString().getBytes();
    }

    private PhotoWallUploadResult decodeUploadResult(String str) throws JSONException {
        PhotoWallUploadResult photoWallUploadResult = new PhotoWallUploadResult();
        photoWallUploadResult.flowId = this.flowId;
        JSONObject jSONObject = new JSONObject(str);
        photoWallUploadResult.burl = jSONObject.getString("burl");
        photoWallUploadResult.ctime = jSONObject.getInt("ctime");
        photoWallUploadResult.filekey = jSONObject.getString("filekey");
        photoWallUploadResult.publish_code = jSONObject.getInt("publish_code");
        photoWallUploadResult.surl = jSONObject.getString("surl");
        photoWallUploadResult.murl = jSONObject.getString("murl");
        photoWallUploadResult.url = jSONObject.getString("url");
        return photoWallUploadResult;
    }

    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public byte[] buildExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.upload.task.UploadTask
    public TaskTypeConfig getUploadTaskType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TaskTypeConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TaskTypeConfig.PhotoWallUploadTaskType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.uinterface.AbstractUploadTask
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.mDeleteFileAfterUpload) {
            FileUtils.deleteTempFile(this.mFilePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.task.UploadTask
    public void processFileUploadFinishRsp(byte[] bArr) {
        String stackTraceString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "photowall upload task response is null");
            return;
        }
        PhotoWallUploadResult photoWallUploadResult = null;
        try {
            stackTraceString = null;
            photoWallUploadResult = decodeUploadResult(new String(bArr));
        } catch (Exception e16) {
            stackTraceString = Log.getStackTraceString(e16);
            UploadLog.e(TAG, "decode photowallUpload result err", e16);
        }
        if (photoWallUploadResult == null) {
            if (TextUtils.isEmpty(stackTraceString)) {
                stackTraceString = "unpack PhotoWallUploadResult==null. " + bArr;
            }
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), stackTraceString);
            return;
        }
        IUploadTaskCallback iUploadTaskCallback = this.uploadTaskCallback;
        if (iUploadTaskCallback != null) {
            iUploadTaskCallback.onUploadSucceed(this, photoWallUploadResult);
        }
        super.processFileUploadFinishRsp(bArr);
    }
}
