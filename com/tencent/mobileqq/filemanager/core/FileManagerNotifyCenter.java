package com.tencent.mobileqq.filemanager.core;

import android.os.Looper;
import android.os.Message;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Observable;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerNotifyCenter extends Observable {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f207341a;

    /* renamed from: b, reason: collision with root package name */
    MqqHandler f207342b = new a(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends MqqHandler {
        a(Looper looper) {
            super(looper);
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            if (message.what == 10001) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "recv Netchang event!");
                }
                FileManagerNotifyCenter.this.f207341a.getFileManagerRSCenter().l(true);
                FileManagerNotifyCenter.this.f207341a.getOnlineFileSessionCenter().n(-1);
                g.h();
            }
        }
    }

    public FileManagerNotifyCenter(QQAppInterface qQAppInterface) {
        this.f207341a = qQAppInterface;
        qQAppInterface.setHandler(getClass(), this.f207342b);
    }

    private void d(FileManagerEntity fileManagerEntity, int i3, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("averageSpeed", String.valueOf(0.0f));
        hashMap.put("peerUin", String.valueOf(fileManagerEntity.peerUin));
        hashMap.put(TagName.FILE_TYPE, q.j(fileManagerEntity.fileName));
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        if (i3 != 10) {
                            switch (i3) {
                                case 61:
                                    str2 = "actFileDisc2Of";
                                    break;
                                case 62:
                                    str2 = "actFileDisc2Disc";
                                    break;
                                case 63:
                                    str2 = "actFileTroop2Of";
                                    break;
                                case 64:
                                    str2 = "actFileTroop2Disc";
                                    break;
                                default:
                                    QLog.e("FileManagerNotifyCenter<FileAssistant>", 1, "what type is report?!nSessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "],may be not report!");
                                    return;
                            }
                        } else {
                            str2 = "actFileFav2Disc";
                        }
                    } else {
                        str2 = "actFileWy2Of";
                    }
                } else {
                    str2 = "actFileOf2Wy";
                }
            } else {
                str2 = "actFileOf2Of";
            }
            FileManagerUtil.reportFilemanagerSuccessInfo(this.f207341a, fileManagerEntity.nSessionId, str2, 1L, str, fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, 0L, 0L, fileManagerEntity.fileSize, 0, null);
        }
    }

    public void a(final FileManagerEntity fileManagerEntity, final int i3, String str) {
        d(fileManagerEntity, i3, str);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter.2
            /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:
            
                if (r0 != 64) goto L44;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                FileManagerEntity fileManagerEntity2;
                Object obj = fileManagerEntity.mContext;
                if (obj != null && (obj instanceof String) && "DeceptiveProgressed".equalsIgnoreCase((String) obj)) {
                    QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "id:" + fileManagerEntity.nSessionId + " DeceptiveProgressed return");
                    return;
                }
                QLog.i("Bug", 1, "id:" + fileManagerEntity.nSessionId + " do DeceptiveProgress");
                FileManagerEntity fileManagerEntity3 = fileManagerEntity;
                fileManagerEntity3.status = 2;
                fileManagerEntity3.fProgress = 0.0f;
                FileManagerNotifyCenter.this.c(fileManagerEntity3.uniseq, fileManagerEntity3.nSessionId, fileManagerEntity3.peerUin, fileManagerEntity3.peerType, 16, null, 14, null);
                do {
                    FileManagerEntity fileManagerEntity4 = fileManagerEntity;
                    float f16 = fileManagerEntity4.fProgress;
                    if (f16 >= 0.95f) {
                        fileManagerEntity4.fProgress = 1.0f;
                    } else {
                        fileManagerEntity4.fProgress = (float) (f16 + 0.05d);
                    }
                    FileManagerNotifyCenter.this.f207341a.getFileManagerNotifyCenter().b(true, 3, null);
                    try {
                        LockMethodProxy.sleep(50L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                    fileManagerEntity2 = fileManagerEntity;
                } while (fileManagerEntity2.fProgress < 1.0f);
                fileManagerEntity2.fProgress = 1.0f;
                fileManagerEntity2.fProgress = 0.0f;
                fileManagerEntity2.status = 1;
                fileManagerEntity2.mContext = new String("DeceptiveProgressed");
                QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "id:" + fileManagerEntity.nSessionId + " set DeceptiveProgressed");
                int i16 = i3;
                if (i16 != 5) {
                    if (i16 != 6) {
                        if (i16 != 7) {
                            if (i16 != 8) {
                                if (i16 != 10) {
                                    if (i16 != 11) {
                                        if (i16 != 63) {
                                        }
                                    }
                                } else {
                                    FileManagerNotifyCenter.this.f207341a.getFileManagerNotifyCenter().b(true, 53, new Object[]{fileManagerEntity.Uuid});
                                    FileManagerNotifyCenter fileManagerNotifyCenter = FileManagerNotifyCenter.this;
                                    FileManagerEntity fileManagerEntity5 = fileManagerEntity;
                                    fileManagerNotifyCenter.c(fileManagerEntity5.uniseq, fileManagerEntity5.nSessionId, fileManagerEntity5.peerUin, fileManagerEntity5.peerType, 14, new Object[]{fileManagerEntity5.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                                }
                            } else {
                                FileManagerNotifyCenter.this.f207341a.getFileManagerNotifyCenter().b(true, 33, new Object[]{fileManagerEntity.Uuid});
                                FileManagerNotifyCenter fileManagerNotifyCenter2 = FileManagerNotifyCenter.this;
                                FileManagerEntity fileManagerEntity6 = fileManagerEntity;
                                fileManagerNotifyCenter2.c(fileManagerEntity6.uniseq, fileManagerEntity6.nSessionId, fileManagerEntity6.peerUin, fileManagerEntity6.peerType, 14, new Object[]{fileManagerEntity6.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                            }
                        } else {
                            FileManagerNotifyCenter fileManagerNotifyCenter3 = FileManagerNotifyCenter.this.f207341a.getFileManagerNotifyCenter();
                            FileManagerEntity fileManagerEntity7 = fileManagerEntity;
                            fileManagerNotifyCenter3.b(true, 34, new Object[]{fileManagerEntity7.WeiYunFileId, Long.valueOf(fileManagerEntity7.nSessionId)});
                        }
                        FileManagerNotifyCenter.this.f207341a.getFileManagerNotifyCenter().b(true, 3, null);
                        FileManagerUtil.delCloseButtonSessionId(fileManagerEntity.nSessionId);
                        fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
                        FileManagerNotifyCenter.this.f207341a.getFileManagerDataCenter().f0(fileManagerEntity);
                    }
                    FileManagerNotifyCenter fileManagerNotifyCenter4 = FileManagerNotifyCenter.this;
                    FileManagerEntity fileManagerEntity8 = fileManagerEntity;
                    fileManagerNotifyCenter4.c(fileManagerEntity8.uniseq, fileManagerEntity8.nSessionId, fileManagerEntity8.peerUin, fileManagerEntity8.peerType, 14, new Object[]{fileManagerEntity8.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                    FileManagerNotifyCenter.this.f207341a.getFileManagerNotifyCenter().b(true, 3, null);
                    FileManagerUtil.delCloseButtonSessionId(fileManagerEntity.nSessionId);
                    fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
                    FileManagerNotifyCenter.this.f207341a.getFileManagerDataCenter().f0(fileManagerEntity);
                }
                fileManagerEntity.setCloudType(3);
                FileManagerEntity fileManagerEntity9 = fileManagerEntity;
                fileManagerEntity9.status = 1;
                FileManagerNotifyCenter.this.c(fileManagerEntity9.uniseq, fileManagerEntity9.nSessionId, fileManagerEntity9.peerUin, fileManagerEntity9.peerType, 14, new Object[]{fileManagerEntity9.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, fileManagerEntity.strServerPath}, 0, null);
                FileManagerNotifyCenter.this.f207341a.getFileManagerNotifyCenter().b(true, 3, null);
                FileManagerUtil.delCloseButtonSessionId(fileManagerEntity.nSessionId);
                fileManagerEntity.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
                FileManagerNotifyCenter.this.f207341a.getFileManagerDataCenter().f0(fileManagerEntity);
            }
        });
    }

    public synchronized void b(boolean z16, int i3, Object obj) {
        setChanged();
        notifyObservers(new Object[]{Integer.valueOf(i3), Boolean.valueOf(z16), obj});
    }

    public void c(long j3, long j16, String str, int i3, int i16, Object obj, int i17, String str2) {
        setChanged();
        if (obj == null) {
            notifyObservers(new Object[]{Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3), Integer.valueOf(i17), str2});
        } else {
            notifyObservers(new Object[]{Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3), obj});
        }
    }
}
