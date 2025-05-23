package cooperation.qlink;

import com.tencent.mobileqq.filemanager.util.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QlAndQQInterface {

    /* renamed from: a, reason: collision with root package name */
    public static String f390427a = "TRANS_DATA";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class DailogClickInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public int type;

        public DailogClickInfo(int i3) {
            this.type = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class InsertFMFileInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public boolean bSend;
        public String filePath;
        public int fileType = -1;
        public long sessionId;
        public String thumbPath;
        public int transSeq;
        public String uin;

        public InsertFMFileInfo(String str, boolean z16, long j3, String str2, String str3, int i3) {
            this.uin = str;
            this.bSend = z16;
            this.sessionId = j3;
            this.filePath = l.d(str2);
            this.thumbPath = str3;
            this.transSeq = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ReportInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public Serializable data;
        public int type;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ReportPerformanceInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public long mDuration;
        public HashMap<String, String> mParams;
        public long mSize;
        public boolean mSuccess;
        public String mTagName;
        public String mUin;

        public ReportPerformanceInfo(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap) {
            this.mUin = str;
            this.mTagName = str2;
            this.mSuccess = z16;
            this.mDuration = j3;
            this.mSize = j16;
            this.mParams = hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class SendFileInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String filePath;
        public long fileSize;
        public int msgseq;
        public int msgtime;
        public long msguid;
        public long sessionid;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class SendFileInfos implements Serializable {
        private static final long serialVersionUID = 1;
        public ArrayList<SendFileInfo> infos = new ArrayList<>();
        public String strUin;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class UserInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public boolean isFriend;
        public String nick;
        public String uin;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class WorkState implements Serializable {
        private static final long serialVersionUID = 1;
        public boolean mForIphone;
        public int mMode;
        public String mPeerNick;
        public String mPeerUin;
        public int mState;
        public int mTransferingCount;
        public boolean mWorking;

        public WorkState() {
            this.mWorking = false;
            this.mState = 0;
            this.mPeerUin = "0";
            this.mPeerNick = "";
            this.mMode = 0;
            this.mTransferingCount = 0;
            this.mForIphone = false;
        }

        public String toString() {
            return " mWorking:" + this.mWorking + " mState:" + this.mState + " mPeerUin:" + this.mPeerUin + " mPeerNick:" + this.mPeerNick + " mMode:" + this.mMode + " mTransferingCount:" + this.mTransferingCount + " mForIphone:" + this.mForIphone;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WorkState m465clone() {
            try {
                return (WorkState) super.clone();
            } catch (CloneNotSupportedException e16) {
                WorkState workState = new WorkState();
                e16.printStackTrace();
                return workState;
            }
        }

        public WorkState(boolean z16, int i3, String str, String str2, int i16, int i17, boolean z17) {
            this.mWorking = z16;
            this.mState = i3;
            this.mPeerUin = str;
            this.mPeerNick = str2;
            this.mMode = i16;
            this.mTransferingCount = i17;
            this.mForIphone = z17;
        }
    }
}
