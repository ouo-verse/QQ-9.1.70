package b60;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.z;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StImageUrl;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends u implements QCircleRichMediaDownLoadManager.e {

    /* renamed from: d, reason: collision with root package name */
    private QCircleShareInfo f27992d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            h.this.D9();
        }
    }

    private void A9() {
        z.b(getActivity(), 2, new a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    private String B9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QCircleShareInfo qCircleShareInfo = this.f27992d;
        String str = "";
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null && !RFSafeListUtils.isEmpty(feedCloudMeta$StFeed.images.get())) {
            QCircleShareInfo qCircleShareInfo2 = this.f27992d;
            FeedCloudMeta$StImage feedCloudMeta$StImage = qCircleShareInfo2.feed.images.get(qCircleShareInfo2.picDownPos);
            if (feedCloudMeta$StImage != null && feedCloudMeta$StImage.vecImageUrl.size() > 0) {
                Iterator<FeedCloudMeta$StImageUrl> it = feedCloudMeta$StImage.vecImageUrl.get().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FeedCloudMeta$StImageUrl next = it.next();
                    if (next.levelType.get() == 4) {
                        str = next.url.get();
                        QLog.d("CommentPicTag", 1, "get pic downLoad url success");
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                QCircleShareInfo qCircleShareInfo3 = this.f27992d;
                String str2 = qCircleShareInfo3.feed.images.get(qCircleShareInfo3.picDownPos).picUrl.get();
                QLog.d("CommentPicTag", 1, "get origin pic downLoad url success");
                return str2;
            }
            return str;
        }
        QLog.e("CommentPicTag", 1, "saveCommentPic images is null. ");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C9(boolean z16) {
        int i3;
        broadcastMessage("rich_media_download_dimiss", null);
        if (z16) {
            i3 = R.string.f188953y3;
        } else {
            i3 = R.string.f1911343z;
        }
        QCircleToast.h(i3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9() {
        QCircleShareInfo qCircleShareInfo = this.f27992d;
        if (qCircleShareInfo != null && qCircleShareInfo.feed != null) {
            broadcastMessage("rich_media_download_show", null);
            QCircleRichMediaDownLoadManager.d dVar = new QCircleRichMediaDownLoadManager.d();
            dVar.h(B9(), 1, this.f27992d.feed.f398449id.get());
            dVar.g(this);
            QCircleRichMediaDownLoadManager.g().f(dVar);
            return;
        }
        QLog.e("CommentPicTag", 1, "saveCommentPic shareInfo is null. ");
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("comment_pic_save".equals(str) && (obj instanceof QCircleShareInfo)) {
            this.f27992d = (QCircleShareInfo) obj;
            A9();
        }
    }

    @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
    public void onProgress(int i3) {
        QLog.d("CommentPicTag", 4, "download progress: " + i3);
        broadcastMessage("rich_meida_download_progress", Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
    public void onStatusChange(final boolean z16) {
        if (z16) {
            broadcastMessage("rich_meida_download_progress", 100);
        }
        getMainHandler().postDelayed(new Runnable() { // from class: b60.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.C9(z16);
            }
        }, 20L);
    }
}
