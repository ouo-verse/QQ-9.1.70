package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uq3.k;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReporterAgent {
    private static final String TAG = "QCircleReporterAgent";
    private List<FeedCloudCommon$BytesEntry> mExtraSessionEntryList;
    private int mScene;

    QCircleReporterAgent(int i3) {
        this.mScene = i3;
    }

    private FeedCloudCommon$StCommonExt buildSessionCommonExt(byte[] bArr, byte[] bArr2) {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        ArrayList arrayList = new ArrayList();
        if (bArr != null) {
            arrayList.add(newEntry(QCircleReportHelper.MAP_KEY_SESSION, bArr));
        }
        if (bArr2 != null) {
            arrayList.add(newEntry(QCircleReportHelper.MAP_KEY_SUB_SESSION, bArr2));
        }
        List<FeedCloudCommon$BytesEntry> list = this.mExtraSessionEntryList;
        if (list != null) {
            arrayList.addAll(list);
        }
        if (!k.a().c("sp_key_show_ai_comment_agreement_dialog", false)) {
            arrayList.add(newEntry(QCircleReportHelper.MAP_KEY_SHOW_AI_COMMENT_AGREE_DIALOG, "1".getBytes()));
        }
        if (arrayList.size() > 0) {
            feedCloudCommon$StCommonExt.mapBytesInfo.set(arrayList);
            QLog.d(TAG, 2, "buildSessionCommonExt() valid session and subsession!scene:" + this.mScene);
        } else {
            QLog.e(TAG, 2, "buildSessionCommonExt() no session and subsession!scene:" + this.mScene);
        }
        return feedCloudCommon$StCommonExt;
    }

    private FeedCloudCommon$BytesEntry newEntry(String str, byte[] bArr) {
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
        feedCloudCommon$BytesEntry.key.set(str);
        feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(bArr));
        return feedCloudCommon$BytesEntry;
    }

    public static QCircleReporterAgent obtain(int i3) {
        return new QCircleReporterAgent(i3);
    }

    private void updateSubSession(byte[] bArr) {
        QCircleReportHelper.getInstance().updateSubSession(this.mScene, bArr);
    }

    public void addExtraSessionEntry(FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry) {
        if (feedCloudCommon$BytesEntry != null) {
            if (this.mExtraSessionEntryList == null) {
                this.mExtraSessionEntryList = new ArrayList();
            }
            this.mExtraSessionEntryList.add(feedCloudCommon$BytesEntry);
        }
    }

    public FeedCloudCommon$StCommonExt getSessionCommonExt(boolean z16) {
        byte[] bArr;
        byte[] session = QCircleReportHelper.getInstance().getSession();
        if (!z16) {
            bArr = QCircleReportHelper.getInstance().getSubSession(this.mScene);
        } else {
            bArr = null;
        }
        return buildSessionCommonExt(session, bArr);
    }

    public void removeExtraSessionEntry(String str) {
        if (!TextUtils.isEmpty(str) && this.mExtraSessionEntryList != null) {
            ArrayList arrayList = new ArrayList(this.mExtraSessionEntryList);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = (FeedCloudCommon$BytesEntry) arrayList.get(size);
                if (feedCloudCommon$BytesEntry != null && TextUtils.equals(feedCloudCommon$BytesEntry.key.get(), str)) {
                    arrayList.remove(size);
                    this.mExtraSessionEntryList = arrayList;
                    return;
                }
            }
        }
    }

    public void updateSubSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        byte[] bArr;
        boolean z16;
        QLog.d(TAG, 2, "updateSubSession,scene:" + this.mScene);
        if (feedCloudCommon$StCommonExt != null && feedCloudCommon$StCommonExt.has() && feedCloudCommon$StCommonExt.mapBytesInfo.has()) {
            Iterator<FeedCloudCommon$BytesEntry> it = feedCloudCommon$StCommonExt.mapBytesInfo.get().iterator();
            while (true) {
                if (!it.hasNext()) {
                    bArr = null;
                    z16 = false;
                    break;
                }
                FeedCloudCommon$BytesEntry next = it.next();
                if (next != null && QCircleReportHelper.MAP_KEY_SUB_SESSION.equals(next.key.get())) {
                    bArr = next.value.get().toByteArray();
                    z16 = true;
                    break;
                }
            }
            if (bArr != null) {
                updateSubSession(bArr);
            }
            if (z16) {
                QLog.d(TAG, 1, "find subsession!");
            } else {
                QLog.e(TAG, 1, "can't find subsession!");
            }
        }
    }
}
