package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWImgCompressHelper;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWUploaderWrapper;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.FileItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001;B!\u0012\u0006\u0010A\u001a\u00020\u0018\u0012\u0006\u0010F\u001a\u00020B\u0012\b\b\u0002\u0010d\u001a\u00020(\u00a2\u0006\u0004\be\u0010fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0002J'\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001bJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0013JU\u0010+\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u00101\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0016J\u0016\u00106\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\b05H\u0016J\u0016\u00108\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020705H\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0016J\b\u0010<\u001a\u00020\u0004H\u0016J\b\u0010=\u001a\u00020\u0004H\u0016R\u0017\u0010A\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010F\u001a\u00020B8\u0006\u00a2\u0006\f\n\u0004\b=\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010KR\u001a\u0010Q\u001a\u00020M8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010T\u001a\u00020(8\u0016X\u0096D\u00a2\u0006\f\n\u0004\bO\u0010\u001c\u001a\u0004\bR\u0010SR\u001a\u0010W\u001a\u00020(8\u0016X\u0096D\u00a2\u0006\f\n\u0004\bU\u0010\u001c\u001a\u0004\bV\u0010SR\u001a\u0010Y\u001a\u00020(8\u0016X\u0096D\u00a2\u0006\f\n\u0004\bD\u0010\u001c\u001a\u0004\bX\u0010SR\u001a\u0010]\u001a\u00020Z8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010[\u001a\u0004\bU\u0010\\R\u0014\u0010_\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010SR\u0014\u0010a\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010SR\u0014\u0010c\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010S\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/PublishMediaEditManager;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/b;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "X", "Z", "a0", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/h;", "info", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ImageItem;", "N", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;", "P", "O", "", "size", "", "H", "updateList", "U", "Y", "", "videoPath", "J", "(Ljava/lang/String;Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeContent;", "E", "D", BdhLogUtil.LogTag.Tag_Conn, "W", "T", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "title", "content", "hintTitle", "hintContent", "", "contentMinHeight", "titleInputMaxLen", BdhLogUtil.LogTag.Tag_Req, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "y", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/a;", "data", "d", "", "r", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/f;", "l", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/b;", "result", "a", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "G", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "M", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWUploaderWrapper;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWUploaderWrapper;", "uploader", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a;", "mediaPlayHelper", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "K", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "dataModel", "o", "()I", "imgOrVideoNumLimit", "L", "g", "audioNumLimit", "v", "fileNumLimit", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "imgQuality", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "canAddImgOrVideoSize", "u", "canAddAudioSize", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "canAddFileSize", "uploadCmd", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class PublishMediaEditManager extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final HWUploaderWrapper uploader;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a mediaPlayHelper;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d dataModel;

    /* renamed from: K, reason: from kotlin metadata */
    private final int imgOrVideoNumLimit;

    /* renamed from: L, reason: from kotlin metadata */
    private final int audioNumLimit;

    /* renamed from: M, reason: from kotlin metadata */
    private final int fileNumLimit;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final HWImgCompressHelper.ImgQuality imgQuality;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/PublishMediaEditManager$a;", "", "", "FILE_MAX_MB", "I", "FILE_MAX_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ PublishMediaEditManager(String str, CoroutineScope coroutineScope, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, coroutineScope, (i16 & 4) != 0 ? 2018 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, coroutineScope, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    private final BaseMediaItem F(h info) {
        BaseMediaItem imageItem;
        if (info.e()) {
            imageItem = new VideoItem();
        } else {
            imageItem = new ImageItem();
        }
        imageItem.setFileSize(info.c());
        imageItem.setLocalFile(true);
        imageItem.setLocalPath(info.b());
        imageItem.setSupportDelete(true);
        imageItem.setWidth(info.d());
        imageItem.setHeight(info.a());
        return imageItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H(long size) {
        if (size < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I(String str, VideoItem videoItem, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                if (frameAtTime == null) {
                    QLog.e("HW.MediaEdit.PublishMediaEditManager", 1, "Generate poster bitmap failed! Path: " + str);
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
                } else {
                    if (videoItem.getWidth() <= 0 && videoItem.getHeight() <= 0) {
                        videoItem.setWidth(frameAtTime.getWidth());
                        videoItem.setHeight(frameAtTime.getHeight());
                        QLog.i("HW.MediaEdit.PublishMediaEditManager", 1, "Generate poster bitmap, set width: " + videoItem.getWidth() + ", height: " + videoItem.getHeight());
                    }
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(ImageInfo.j() + "noticeVideoPoster_" + System.currentTimeMillis() + ".jpg");
                    BaseImageUtil.saveBitmapToFile(frameAtTime, new File(sDKPrivatePath));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Poster file generated at: ");
                    sb5.append(sDKPrivatePath);
                    QLog.i("HW.MediaEdit.PublishMediaEditManager", 1, sb5.toString());
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(sDKPrivatePath));
                }
            } catch (Exception e16) {
                QLog.e("HW.MediaEdit.PublishMediaEditManager", 1, "Error generating poster: " + e16.getMessage());
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J(String str, VideoItem videoItem, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PublishMediaEditManager$generatePoster$2(str, this, videoItem, null), continuation);
    }

    private final void N(ImageItem item) {
        String localPath = item.getLocalPath();
        if (localPath == null) {
            return;
        }
        item.setRawSize(new File(localPath).length());
        QLog.i("HW.MediaEdit.PublishMediaEditManager", 1, "Original image size: " + item.getRawSize() + " bytes");
        item.setState(UploadOrDownloadState.UPLOADING);
        Z(item);
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new PublishMediaEditManager$handleImageItem$1(this, localPath, item, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(VideoItem item) {
        item.setState(UploadOrDownloadState.UPLOAD_ERR);
        QLog.e("HW.MediaEdit.PublishMediaEditManager", 1, "Failure on genPosterFileAndTrySetSize!");
        com.tencent.mobileqq.troop.homework.utils.a.f(-1, "Failure on genPosterFileAndTrySetSize", SystemClock.elapsedRealtime() - item.getStartMillis(), item.getFileSize(), item.getRawSize(), item.getMediaType(), this.troopUin, 0, 0, MsgConstant.KRMFILETHUMBSIZE384, null);
    }

    private final void P(VideoItem item, h info) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getMain(), null, new PublishMediaEditManager$handleVideoItem$1(item, this, info, null), 2, null);
    }

    public static /* synthetic */ void S(PublishMediaEditManager publishMediaEditManager, String str, String str2, String str3, String str4, Integer num, Integer num2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                str = null;
            }
            if ((i3 & 2) != 0) {
                str2 = null;
            }
            if ((i3 & 4) != 0) {
                str3 = null;
            }
            if ((i3 & 8) != 0) {
                str4 = null;
            }
            if ((i3 & 16) != 0) {
                num = null;
            }
            if ((i3 & 32) != 0) {
                num2 = null;
            }
            publishMediaEditManager.R(str, str2, str3, str4, num, num2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initContent");
    }

    private final void U(BaseItem item, boolean updateList) {
        QLog.i("HW.MediaEdit.PublishMediaEditManager", 1, QZoneJsConstants.METHOD_RECORDER_START_UPLOAD);
        this.uploader.i(item);
        if (updateList) {
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void V(PublishMediaEditManager publishMediaEditManager, BaseItem baseItem, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            publishMediaEditManager.U(baseItem, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startUpload");
    }

    private final void X(BaseItem item) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new PublishMediaEditManager$tryFixFileInfo$1(item, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(ImageItem item) {
        if (item.getWidth() <= 0 && item.getHeight() <= 0) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new PublishMediaEditManager$tryFixImgSize$1(item, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(BaseItem item) {
        e().postValue(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        b().postValue(K().q());
    }

    public final boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return K().d();
    }

    public final boolean C() {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(K().k().getContent());
            return isBlank;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
    }

    public final boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (K().k().getContent().length() == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GroupSchoolNoticeContent E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (GroupSchoolNoticeContent) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return K().e();
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        this.uploader.c();
        K().h();
        this.mediaPlayHelper.g();
    }

    @NotNull
    public com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d K() {
        throw null;
    }

    @NotNull
    public HWImgCompressHelper.ImgQuality L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (HWImgCompressHelper.ImgQuality) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.imgQuality;
    }

    @NotNull
    public final CoroutineScope M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.scope;
    }

    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            a0();
        }
    }

    public final void R(@Nullable String title, @Nullable String content, @Nullable String hintTitle, @Nullable String hintContent, @Nullable Integer contentMinHeight, @Nullable Integer titleInputMaxLen) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, title, content, hintTitle, hintContent, contentMinHeight, titleInputMaxLen);
            return;
        }
        if (title != null) {
            K().r().setTitle(title);
        }
        if (content != null) {
            K().k().setContent(content);
        }
        if (hintTitle != null) {
            K().r().setHintText(hintTitle);
        }
        if (hintContent != null) {
            K().k().setHintText(hintContent);
        }
        if (contentMinHeight != null) {
            K().k().setContentMinHeight(contentMinHeight.intValue());
        }
        if (titleInputMaxLen != null) {
            K().r().setInputMaxLen(titleInputMaxLen.intValue());
        }
    }

    public final boolean T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (K().n() + K().i() + K().l() == 0) {
            return true;
        }
        return false;
    }

    public final boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (K().r().getTitle().length() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.c
    public void a(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("HW.MediaEdit.PublishMediaEditManager", 4, "handleCaptureMediaData, " + result.a());
        ImageItem imageItem = new ImageItem();
        imageItem.setLocalFile(true);
        imageItem.setLocalPath(result.a());
        imageItem.setSupportDelete(true);
        Y(imageItem);
        if (K().c(imageItem)) {
            X(imageItem);
            U(imageItem, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.c
    public void d(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("HW.MediaEdit.PublishMediaEditManager", 4, "handleAudioRecordData, " + data);
        AudioItem audioItem = new AudioItem();
        audioItem.setLocalFile(true);
        audioItem.setFileSize(data.b());
        audioItem.setLocalPath(data.a());
        audioItem.setCountTime(data.c());
        audioItem.setSupportDelete(true);
        if (K().a(audioItem)) {
            X(audioItem);
            U(audioItem, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.audioNumLimit;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.a
    public void j(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            V(this, item, false, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.c
    public void l(@NotNull List<com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.f> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        for (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.f fVar : data) {
            FileItem fileItem = new FileItem();
            fileItem.setFileType(fVar.a());
            fileItem.setLocalPath(fVar.c());
            fileItem.setFileName(fVar.b());
            fileItem.setFileSize(fVar.d());
            fileItem.setLocalFile(true);
            fileItem.setSupportDelete(true);
            if (K().b(fileItem)) {
                X(fileItem);
                U(fileItem, true);
            }
        }
    }

    @Override // qs2.a
    public void m(@NotNull BaseItem item, @Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) item, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a.m(this.mediaPlayHelper, item, activity, null, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.imgOrVideoNumLimit;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return o() - K().n();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.c
    public void r(@NotNull List<h> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        for (h hVar : data) {
            BaseMediaItem F = F(hVar);
            if (F instanceof ImageItem) {
                N((ImageItem) F);
            } else if (F instanceof VideoItem) {
                P((VideoItem) F, hVar);
            }
            if (K().c(F)) {
                X(F);
            }
        }
        a0();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return g() - K().i();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.fileNumLimit;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.a
    public void y(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        this.mediaPlayHelper.f(item);
        this.uploader.j(item);
        K().g(item);
        a0();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return v() - K().l();
    }

    public PublishMediaEditManager(@NotNull String troopUin, @NotNull CoroutineScope scope, int i3) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, scope, Integer.valueOf(i3));
            return;
        }
        this.troopUin = troopUin;
        this.scope = scope;
        this.uploader = new HWUploaderWrapper(i3, troopUin, scope, new Function1<BaseItem, Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager$uploader$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishMediaEditManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                invoke2(baseItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable BaseItem baseItem) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) baseItem);
                } else if (baseItem != null) {
                    PublishMediaEditManager.this.Z(baseItem);
                }
            }
        }, new Function1<BaseItem, Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager$uploader$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishMediaEditManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                invoke2(baseItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable BaseItem baseItem) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PublishMediaEditManager.this.a0();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) baseItem);
                }
            }
        });
        this.mediaPlayHelper = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a(new Function1<BaseItem, Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager$mediaPlayHelper$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishMediaEditManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                invoke2(baseItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable BaseItem baseItem) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) baseItem);
                } else if (baseItem != null) {
                    PublishMediaEditManager.this.Z(baseItem);
                }
            }
        });
        this.dataModel = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d();
        this.imgOrVideoNumLimit = 10;
        this.audioNumLimit = 1;
        this.fileNumLimit = 2;
        this.imgQuality = HWImgCompressHelper.ImgQuality.DEFAULT;
    }
}
