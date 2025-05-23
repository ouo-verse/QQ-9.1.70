package fs;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes38.dex */
public class t extends o<b, b> {

    /* renamed from: i, reason: collision with root package name */
    public static ThreadLocal<SimpleDateFormat> f400469i = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    private final EditVideoParams f400470h;

    public t(EditVideoParams editVideoParams) {
        this.f400470h = editVideoParams;
    }

    public static SimpleDateFormat b() {
        SimpleDateFormat simpleDateFormat = f400469i.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
        f400469i.set(simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static String c() {
        return b().format(new Date(NetConnInfoCenter.getServerTimeMillis()));
    }

    public static String d() {
        return "fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02ec  */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSegment(JobContext jobContext, b bVar) {
        byte b16;
        hd0.c.k("Q.qqstory.publish.edit.PublishVideoSegment", "PublishVideoSegment.");
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        publishVideoEntry.publishFrom = this.f400470h.k();
        publishVideoEntry.businessId = this.f400470h.f204055d;
        publishVideoEntry.fakeVid = d();
        publishVideoEntry.mLocalDate = c();
        publishVideoEntry.timeZoneOffset = TimeZone.getDefault().getRawOffset();
        if (publishVideoEntry.createTime == 0) {
            publishVideoEntry.createTime = NetConnInfoCenter.getServerTimeMillis();
        }
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish date:%s and time:%d,", publishVideoEntry.mLocalDate, Long.valueOf(publishVideoEntry.createTime));
        publishVideoEntry.publishState = 1;
        publishVideoEntry.videoUploadTempDir = bVar.f400399p;
        publishVideoEntry.putExtra("extra_capture_mode", Integer.valueOf(this.f400470h.f204056e));
        publishVideoEntry.isLocalPublish = this.f400470h.q();
        publishVideoEntry.hwEncodeRecordVideo = this.f400470h.s();
        publishVideoEntry.isPicture = this.f400470h.r();
        EditVideoParams.EditSource editSource = bVar.f400386c;
        if (editSource instanceof EditTakeVideoSource) {
            EditTakeVideoSource editTakeVideoSource = (EditTakeVideoSource) editSource;
            publishVideoEntry.mLocalRawVideoDir = editTakeVideoSource.getSourcePath();
            long j3 = editTakeVideoSource.f204052e.mDuration;
            publishVideoEntry.recordTime = j3;
            publishVideoEntry.recordFrames = ((int) j3) * 30;
            publishVideoEntry.mAudioFilePath = editTakeVideoSource.f204053f;
            publishVideoEntry.mbgmAudioFilePath = editTakeVideoSource.f204054h;
            if (com.tencent.biz.qqstory.utils.k.e(editTakeVideoSource.getSourcePath()) % 180 > 0) {
                publishVideoEntry.videoWidth = editTakeVideoSource.getHeight();
                publishVideoEntry.videoHeight = editTakeVideoSource.getWidth();
            } else {
                publishVideoEntry.videoWidth = editTakeVideoSource.getWidth();
                publishVideoEntry.videoHeight = editTakeVideoSource.getHeight();
            }
            publishVideoEntry.videoDuration = a(publishVideoEntry.saveMode, editTakeVideoSource.f204052e.mDuration);
            if (publishVideoEntry.saveMode == 5 && !com.tencent.biz.qqstory.utils.d.k(publishVideoEntry.mIFrameVideoPath)) {
                super.notifyError(new ErrorMessage(-1, "back mode but iframe file is empty"));
                return;
            }
            publishVideoEntry.videoCreateTime = editTakeVideoSource.f204052e.addedDate;
        } else if (editSource instanceof EditLocalVideoSource) {
            publishVideoEntry.putExtra("video_type", Integer.valueOf(this.f400470h.c("extra_is_slide_show_video", false) ? 2 : 0));
            EditLocalVideoSource editLocalVideoSource = (EditLocalVideoSource) bVar.f400386c;
            publishVideoEntry.mLocalRawVideoDir = editLocalVideoSource.getSourcePath();
            long j16 = editLocalVideoSource.f204044e.mDuration;
            publishVideoEntry.recordTime = j16;
            publishVideoEntry.recordFrames = ((int) j16) * 30;
            if (com.tencent.biz.qqstory.utils.k.e(editLocalVideoSource.getSourcePath()) % 180 > 0) {
                publishVideoEntry.videoWidth = editLocalVideoSource.getHeight();
                publishVideoEntry.videoHeight = editLocalVideoSource.getWidth();
            } else {
                publishVideoEntry.videoWidth = editLocalVideoSource.getWidth();
                publishVideoEntry.videoHeight = editLocalVideoSource.getHeight();
            }
            publishVideoEntry.videoDuration = a(publishVideoEntry.saveMode, editLocalVideoSource.f204044e.mDuration);
            publishVideoEntry.videoCreateTime = editLocalVideoSource.f204044e.addedDate;
        } else {
            if (!(editSource instanceof EditTakePhotoSource) && !(editSource instanceof EditLocalPhotoSource)) {
                super.notifyError(new ErrorMessage(-1, "illegal argument " + bVar.f400386c));
                return;
            }
            String sourcePath = editSource.getSourcePath();
            EditVideoParams.EditSource editSource2 = bVar.f400386c;
            if (editSource2 instanceof EditLocalPhotoSource) {
                publishVideoEntry.videoCreateTime = ((EditLocalPhotoSource) editSource2).f204042e.addedDate;
            }
            String str = publishVideoEntry.thumbPath;
            if (str != null) {
                publishVideoEntry.mLocalRawVideoDir = str;
            } else {
                g gVar = bVar.f400395l;
                if (!gVar.f400422h && gVar.f400421g) {
                    sourcePath = gVar.f400416b;
                }
                publishVideoEntry.mLocalRawVideoDir = sourcePath;
            }
            if (editSource2 instanceof EditTakePhotoSource) {
                publishVideoEntry.mLocalRawPicPath = bVar.f400395l.f400415a;
            }
            publishVideoEntry.recordTime = 5000.0d;
            publishVideoEntry.recordFrames = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_LEBA_SETTING_ENTRY;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(publishVideoEntry.mLocalRawVideoDir, options);
            publishVideoEntry.videoWidth = options.outWidth;
            publishVideoEntry.videoHeight = options.outHeight;
            publishVideoEntry.videoDuration = 5000L;
            b16 = false;
            if (b16 != false) {
                com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().K(publishVideoEntry);
            }
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", bVar.f400386c);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fake vid = %s", publishVideoEntry.fakeVid);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : mLocalRawVideoDir = %s", publishVideoEntry.mLocalRawVideoDir);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : width = %d, height = %d", Integer.valueOf(publishVideoEntry.videoWidth), Integer.valueOf(publishVideoEntry.videoHeight));
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : duration = %d, recordTime = %d", Integer.valueOf((int) publishVideoEntry.videoDuration), Integer.valueOf((int) publishVideoEntry.recordTime));
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : businessId = %d", Integer.valueOf(publishVideoEntry.businessId));
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : thumbPath = %s", publishVideoEntry.thumbPath);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleImagePath = %s", publishVideoEntry.doodlePath);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleRawImagePath = %s", publishVideoEntry.doodleRawPath);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : atDoodleImagePath = %s", publishVideoEntry.atDoodlePath);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragmentGroupId = %s", publishVideoEntry.multiFragmentGroupId);
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : isLocalPublish = %s", Boolean.valueOf(publishVideoEntry.isLocalPublish));
            hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : publishFrom = %d", Integer.valueOf(publishVideoEntry.publishFrom));
            publishVideoEntry.putExtra("composite_key_merge_thumb_cost", Long.valueOf(System.currentTimeMillis() - bVar.f400400q));
            if (this.f400470h.e() == 14) {
                publishVideoEntry.putExtra("VIDEO_STORY_JUMP_TO_TYPE", Integer.valueOf(this.f400470h.l("VIDEO_STORY_JUMP_TO_TYPE", 0)));
            }
            if (!TextUtils.isEmpty(publishVideoEntry.mLocalRawVideoDir)) {
                super.notifyError(new ErrorMessage(-1, "mLocalRawVideoDir is empty"));
                return;
            }
            if (publishVideoEntry.thumbPath != null) {
                File file = new File(publishVideoEntry.thumbPath);
                if (!file.exists() || !file.isFile() || file.length() <= 0) {
                    super.notifyError(new ErrorMessage(-1, "thumbFile is invalid : " + file));
                    return;
                }
            }
            if (publishVideoEntry.doodlePath != null) {
                File file2 = new File(publishVideoEntry.doodlePath);
                if (!file2.exists() || !file2.isFile() || file2.length() <= 0) {
                    super.notifyError(new ErrorMessage(-1, "doodleFile is invalid : " + file2));
                    return;
                }
            }
            if (publishVideoEntry.mosaicPath != null) {
                File file3 = new File(publishVideoEntry.mosaicPath);
                if (!file3.exists() || !file3.isFile() || file3.length() <= 0) {
                    super.notifyError(new ErrorMessage(-1, "mosaicfile is invalid : " + file3));
                    return;
                }
            }
            if (publishVideoEntry.doodleRawPath != null) {
                File file4 = new File(publishVideoEntry.doodleRawPath);
                if (!file4.exists() || !file4.isFile() || file4.length() <= 0) {
                    super.notifyError(new ErrorMessage(-1, "doodleRawFile is invalid : " + file4));
                    return;
                }
            }
            hd0.c.k("Q.qqstory.publish.edit.PublishVideoSegment", "before persist or replace.");
            try {
                QQStoryContext.h().e().createEntityManager().persistOrReplace(publishVideoEntry);
            } catch (Throwable th5) {
                QLog.e("Q.qqstory.publish.edit.PublishVideoSegment", 1, "persist publishVideoEntry in DB failed:", th5);
            }
            hd0.c.k("Q.qqstory.publish.edit.PublishVideoSegment", "after persist or replace.");
            int i3 = bVar.f400387d.saveMode != 0 ? 1 : 0;
            if (bVar.f400390g) {
                i3 = 1;
            }
            if (publishVideoEntry.isMuteRecordVoice) {
                i3 = 1;
            }
            if (publishVideoEntry.backgroundMusicPath != null) {
                i3 = 1;
            }
            if (publishVideoEntry.doodlePath != null) {
                i3 = 1;
            }
            if (publishVideoEntry.doodleRawPath != null) {
                i3 = 1;
            }
            int i16 = bVar.f400391h ? 1 : i3;
            if (i16 == 0) {
                id0.b.i("0X80076BD");
            }
            bVar.f400396m = new PublishParam(publishVideoEntry.fakeVid, publishVideoEntry.thumbPath, publishVideoEntry.doodlePath, publishVideoEntry.videoLabel, publishVideoEntry.videoDoodleDescription, publishVideoEntry.videoAddress, publishVideoEntry.videoWidth, publishVideoEntry.videoHeight, publishVideoEntry.videoDuration, publishVideoEntry.videoMaxrate, publishVideoEntry.videoMinrate, i16, publishVideoEntry.saveMode, publishVideoEntry.recordFrames, publishVideoEntry.atDoodlePath, publishVideoEntry.atJsonData, publishVideoEntry.isPicture ? 1 : 0, publishVideoEntry.hwEncodeRecordVideo ? 1 : 0, publishVideoEntry.mLocalRawVideoDir, publishVideoEntry.mAudioFilePath, publishVideoEntry.mIFrameVideoPath, publishVideoEntry.mosaicPath, bVar.f400388e, publishVideoEntry.isLocalPublish, publishVideoEntry.videoLocationDescription, publishVideoEntry.videoLongitude, publishVideoEntry.videoLatitude);
            super.notifyResult(bVar);
            return;
        }
        b16 = true;
        if (b16 != false) {
        }
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", bVar.f400386c);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fake vid = %s", publishVideoEntry.fakeVid);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : mLocalRawVideoDir = %s", publishVideoEntry.mLocalRawVideoDir);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : width = %d, height = %d", Integer.valueOf(publishVideoEntry.videoWidth), Integer.valueOf(publishVideoEntry.videoHeight));
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : duration = %d, recordTime = %d", Integer.valueOf((int) publishVideoEntry.videoDuration), Integer.valueOf((int) publishVideoEntry.recordTime));
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : businessId = %d", Integer.valueOf(publishVideoEntry.businessId));
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : thumbPath = %s", publishVideoEntry.thumbPath);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleImagePath = %s", publishVideoEntry.doodlePath);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleRawImagePath = %s", publishVideoEntry.doodleRawPath);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : atDoodleImagePath = %s", publishVideoEntry.atDoodlePath);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragmentGroupId = %s", publishVideoEntry.multiFragmentGroupId);
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : isLocalPublish = %s", Boolean.valueOf(publishVideoEntry.isLocalPublish));
        hd0.c.v("Q.qqstory.publish.edit.PublishVideoSegment", "publish : publishFrom = %d", Integer.valueOf(publishVideoEntry.publishFrom));
        publishVideoEntry.putExtra("composite_key_merge_thumb_cost", Long.valueOf(System.currentTimeMillis() - bVar.f400400q));
        if (this.f400470h.e() == 14) {
        }
        if (!TextUtils.isEmpty(publishVideoEntry.mLocalRawVideoDir)) {
        }
    }

    public static long a(int i3, long j3) {
        if (i3 == 1) {
            return j3 / 2;
        }
        return i3 == 2 ? j3 * 2 : i3 == 4 ? j3 * 4 : i3 == 3 ? ((float) j3) / 1.5f : j3;
    }
}
