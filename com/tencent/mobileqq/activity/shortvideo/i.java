package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.l;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a, reason: collision with root package name */
    String f186366a;

    /* renamed from: b, reason: collision with root package name */
    String f186367b;

    /* renamed from: c, reason: collision with root package name */
    long f186368c;

    /* renamed from: d, reason: collision with root package name */
    long f186369d;

    /* renamed from: e, reason: collision with root package name */
    String f186370e;

    /* renamed from: f, reason: collision with root package name */
    int f186371f;

    /* renamed from: g, reason: collision with root package name */
    String f186372g;

    /* renamed from: h, reason: collision with root package name */
    String f186373h;

    /* renamed from: i, reason: collision with root package name */
    String f186374i;

    /* renamed from: j, reason: collision with root package name */
    int f186375j;

    /* renamed from: k, reason: collision with root package name */
    int f186376k;

    /* renamed from: l, reason: collision with root package name */
    String f186377l;

    /* renamed from: m, reason: collision with root package name */
    int f186378m;

    /* renamed from: n, reason: collision with root package name */
    int f186379n;

    /* renamed from: o, reason: collision with root package name */
    Bitmap f186380o;

    /* renamed from: p, reason: collision with root package name */
    int f186381p;

    /* renamed from: q, reason: collision with root package name */
    boolean f186382q;

    public i(Intent intent) {
        this.f186367b = intent.getExtras().getString("file_send_path");
        this.f186369d = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_DURATION);
        this.f186368c = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_SIZE);
        this.f186370e = intent.getExtras().getString("uin");
        this.f186371f = intent.getIntExtra("uintype", -1);
        this.f186372g = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
        this.f186366a = intent.getExtras().getString(ShortVideoConstants.ACTIVITY_BEFORE_ENTER_SEND_VIDEO);
        this.f186382q = intent.getExtras().getBoolean(PeakConstants.SEND_IN_BACKGROUND);
        this.f186381p = intent.getExtras().getInt(ShortVideoConstants.MSG_TAIL_TYPE);
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.f186367b + ", mDuration:" + this.f186369d + ", mFileSize:" + this.f186368c + ",mUin" + this.f186370e + ",mUinType:" + this.f186371f + ",mFileSource:" + this.f186372g + ",mSendBackground = " + this.f186382q + ",mMsgTailType=" + this.f186381p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        return Integer.valueOf(c(BaseApplicationImpl.getApplication()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (num.intValue() == 1) {
            Intent intent = new Intent();
            try {
                this.f186373h = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(this.f186367b), this.f186368c));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SendVideoActivity", 2, "", e16);
                }
            }
            intent.putExtra("uin", this.f186370e);
            intent.putExtra("uintype", this.f186371f);
            intent.putExtra("file_send_path", this.f186367b);
            intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, this.f186368c);
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) (this.f186369d / 1000));
            intent.putExtra(ShortVideoConstants.FILE_SOURCE, this.f186372g);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, this.f186374i);
            intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, this.f186373h);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, this.f186375j);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, this.f186376k);
            intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, this.f186377l);
            intent.putExtra(ShortVideoConstants.FILE_WIDTH, this.f186378m);
            intent.putExtra(ShortVideoConstants.FILE_HEIGHT, this.f186379n);
            intent.putExtra(ShortVideoConstants.MSG_TAIL_TYPE, this.f186381p);
            intent.putExtra(ShortVideoConstants.FILE_SEND_BUSINESS_TYPE, 0);
            v b16 = com.tencent.mobileqq.shortvideo.h.b(0, 0);
            b16.e(l.b(0, intent, b16));
            l.e(b16, (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
    }

    int c(Context context) {
        FileInputStream fileInputStream;
        String[] split;
        if (context == null) {
            return 5;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lvcc.name(), IDPCApiConstant.LONG_VIDEO_COMPRESS_CONFIG_DEFAULT);
                int i3 = 0;
                if (featureValue != null && featureValue.length() > 0 && (split = featureValue.split("\\|")) != null && split.length > 0) {
                    try {
                        i3 = Integer.valueOf(split[0]).intValue();
                    } catch (NumberFormatException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb -> get DpcConfig Erro", e16);
                        }
                    }
                }
                Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(context, this.f186367b, i3);
                if (videoThumbnail == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SendVideoActivity", 2, "processThumb: create thumbnail fail");
                    }
                    videoThumbnail = this.f186380o;
                    if (videoThumbnail == null) {
                        return 2;
                    }
                }
                this.f186375j = videoThumbnail.getWidth();
                int height = videoThumbnail.getHeight();
                this.f186376k = height;
                if (this.f186375j != 0 && height != 0) {
                    String l3 = j.l("" + System.currentTimeMillis(), "jpg");
                    FileUtils.createFileIfNotExits(j.k() + ".nomedia");
                    File file = new File(l3);
                    File file2 = new File(file.getParent());
                    if (!file2.exists() || !file2.isDirectory()) {
                        file2.mkdirs();
                    }
                    if (!file.exists() || !file.isFile()) {
                        file.createNewFile();
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        videoThumbnail.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                        bufferedOutputStream2.flush();
                        fileInputStream = new FileInputStream(file);
                        try {
                            long length = file.length();
                            String bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(MD5.toMD5Byte(fileInputStream, length));
                            this.f186377l = bytes2HexStr;
                            if (TextUtils.isEmpty(bytes2HexStr)) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SendVideoActivity", 2, "processThumb: mThumbMd5 is empty, " + this.f186377l);
                                }
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException unused) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                                return 5;
                            }
                            String l16 = j.l(this.f186377l, "jpg");
                            this.f186374i = l16;
                            if (!FileUtils.rename(l3, l16)) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException unused3) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused4) {
                                }
                                return 5;
                            }
                            String formatFileSize = Formatter.formatFileSize(context, length);
                            if (QLog.isColorLevel()) {
                                QLog.e("SendVideoActivity", 2, "processThumb: mThumbFile Size:" + formatFileSize);
                            }
                            if (this.f186369d == 0) {
                                this.f186369d = ShortVideoUtils.getDuration(this.f186367b);
                            }
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused5) {
                            }
                            try {
                                fileInputStream.close();
                                return 1;
                            } catch (IOException unused6) {
                                return 1;
                            }
                        } catch (IOException e17) {
                            e = e17;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (QLog.isColorLevel()) {
                                QLog.e("SendVideoActivity", 2, "processThumb failure", e);
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return 3;
                                } catch (IOException unused8) {
                                    return 3;
                                }
                            }
                            return 3;
                        } catch (Exception e18) {
                            e = e18;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (QLog.isColorLevel()) {
                                QLog.e("SendVideoActivity", 2, "processThumb failure", e);
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused9) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused10) {
                                }
                            }
                            return 5;
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (QLog.isColorLevel()) {
                                QLog.e("SendVideoActivity", 2, "processThumb OutOfMemoryError", e);
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused11) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return 4;
                                } catch (IOException unused12) {
                                    return 4;
                                }
                            }
                            return 4;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused13) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    throw th;
                                } catch (IOException unused14) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e26) {
                        e = e26;
                        fileInputStream = null;
                    } catch (Exception e27) {
                        e = e27;
                        fileInputStream = null;
                    } catch (OutOfMemoryError e28) {
                        e = e28;
                        fileInputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = null;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("SendVideoActivity", 2, "processThumb: resize thumbnail fail");
                }
                return 2;
            } catch (IOException e29) {
                e = e29;
                fileInputStream = null;
            } catch (Exception e36) {
                e = e36;
                fileInputStream = null;
            } catch (OutOfMemoryError e37) {
                e = e37;
                fileInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
