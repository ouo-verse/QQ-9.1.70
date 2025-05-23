package com.tencent.mobileqq.activity.photo.album.querymedia;

import android.content.Context;
import android.database.StaleDataException;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaQueryHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_EACH_COUNT = 300;
    private static final String[] PERMS_STORAGE;
    public static final String TAG = "QQAlbum";
    private static boolean sHasStorageReadAndWritePermission;
    public int cursorsCount;
    public int cursorsVideoCount;
    public volatile AtomicBoolean isQuerying;
    List<ICursor> mCursors;
    public int mEachCount;
    private int mLimit;
    ICursor.FilterListener mListener;
    private PriorityQueue<MergeSlot> mQueue;
    public boolean mTraversalDone;
    public List<LocalMediaInfo> mediaList;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        String albumId;
        List<ICursor> cursors;
        int eachCount;
        int limit;
        ICursor.FilterListener listener;
        boolean needImage;
        boolean needVideo;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.needImage = true;
            this.needVideo = true;
            this.limit = -1;
            this.eachCount = 300;
            this.cursors = null;
            this.listener = null;
        }

        public MediaQueryHelper build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? build(null) : (MediaQueryHelper) iPatchRedirector.redirect((short) 9, (Object) this);
        }

        public Builder needImage(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
            this.needImage = z16;
            return this;
        }

        public Builder needVideo(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.needVideo = z16;
            return this;
        }

        public Builder setAlbumId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.albumId = str;
            return this;
        }

        public Builder setCursors(List<ICursor> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            }
            this.cursors = list;
            return this;
        }

        public Builder setEachCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.eachCount = i3;
            return this;
        }

        public Builder setLimit(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.limit = i3;
            return this;
        }

        public Builder setListener(ICursor.FilterListener filterListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) filterListener);
            }
            this.listener = filterListener;
            return this;
        }

        public MediaQueryHelper build(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (MediaQueryHelper) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
            }
            if (this.cursors == null && context != null && MediaQueryHelper.isHasStorageReadAndWritePermission(context)) {
                this.cursors = new ArrayList();
                String str = this.albumId;
                if (str != null && str.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID)) {
                    this.needImage = false;
                }
                if (this.needImage) {
                    this.cursors.add(new ImageCursor(context, this.albumId));
                }
                if (this.needVideo) {
                    this.cursors.add(new VideoCursor(context, this.albumId));
                }
            }
            if (this.cursors == null) {
                this.cursors = new ArrayList();
            }
            MediaQueryHelper mediaQueryHelper = new MediaQueryHelper(null);
            mediaQueryHelper.setListener(this.listener);
            mediaQueryHelper.init(this.cursors, this.limit, this.eachCount);
            return mediaQueryHelper;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class DataComparator implements Comparator<MergeSlot> {
        static IPatchRedirector $redirector_;

        DataComparator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ DataComparator(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }

        @Override // java.util.Comparator
        public int compare(MergeSlot mergeSlot, MergeSlot mergeSlot2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mergeSlot, (Object) mergeSlot2)).intValue();
            }
            LocalMediaInfo localMediaInfo = mergeSlot.mImage;
            if (localMediaInfo == null) {
                return 1;
            }
            LocalMediaInfo localMediaInfo2 = mergeSlot2.mImage;
            if (localMediaInfo2 == null) {
                return -1;
            }
            long j3 = localMediaInfo2.modifiedDate;
            long j16 = localMediaInfo.modifiedDate;
            return j3 != j16 ? j3 - j16 > 0 ? 1 : -1 : localMediaInfo2.addedDate - localMediaInfo.addedDate > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class MergeSlot {
        static IPatchRedirector $redirector_;
        private final ICursor mCursor;
        LocalMediaInfo mImage;
        private int mOffset;
        boolean need;

        public MergeSlot(ICursor iCursor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iCursor);
            } else {
                this.mOffset = -1;
                this.mCursor = iCursor;
            }
        }

        public boolean next() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.mOffset >= this.mCursor.getCount() - 1) {
                return false;
            }
            ICursor iCursor = this.mCursor;
            int i3 = this.mOffset + 1;
            this.mOffset = i3;
            boolean moveToPosition = iCursor.moveToPosition(i3);
            if (moveToPosition) {
                LocalMediaInfo makeMediaInfo = this.mCursor.makeMediaInfo();
                this.mImage = makeMediaInfo;
                this.need = this.mCursor.needMedia(makeMediaInfo);
            }
            return moveToPosition;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28006);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            PERMS_STORAGE = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE};
        }
    }

    /* synthetic */ MediaQueryHelper(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) anonymousClass1);
    }

    private boolean checkQueryCondition(int i3, int i16, int i17) {
        if (!this.mTraversalDone && i16 < i3 && (i17 < i3 * 2 || i16 < 150)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init(List<ICursor> list, int i3, int i16) {
        this.mCursors = list;
        if (list != null) {
            Iterator<ICursor> it = list.iterator();
            while (it.hasNext()) {
                it.next().setListener(this.mListener);
            }
        }
        this.mLimit = i3;
        if (i16 > 300) {
            this.mEachCount = i16;
        }
        this.mediaList = new CopyOnWriteArrayList();
        this.mQueue = new PriorityQueue<>(4, new DataComparator(null));
        Iterator<ICursor> it5 = this.mCursors.iterator();
        while (it5.hasNext()) {
            MergeSlot mergeSlot = new MergeSlot(it5.next());
            if (mergeSlot.next()) {
                this.mQueue.add(mergeSlot);
            }
        }
    }

    public static boolean isHasStorageReadAndWritePermission(Context context) {
        boolean z16 = sHasStorageReadAndWritePermission;
        if (!z16 && context != null) {
            String[] strArr = PERMS_STORAGE;
            if (context.checkSelfPermission(strArr[0]) == 0 && context.checkSelfPermission(strArr[1]) == 0) {
                sHasStorageReadAndWritePermission = true;
                return true;
            }
            return z16;
        }
        return z16;
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<ICursor> it = this.mCursors.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    public LocalMediaInfo getFirstInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        List<LocalMediaInfo> list = this.mediaList;
        if (list != null && !list.isEmpty()) {
            return this.mediaList.get(0);
        }
        return null;
    }

    public void queryAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            while (!this.mTraversalDone) {
                queryNext();
            }
        }
    }

    public boolean queryNext(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (this.isQuerying.compareAndSet(false, true)) {
            try {
                if (!this.mTraversalDone) {
                    int i16 = 0;
                    int i17 = 0;
                    while (true) {
                        if (!checkQueryCondition(i3, i16, i17)) {
                            break;
                        }
                        if (this.mLimit > 0 && this.mediaList.size() >= this.mLimit) {
                            this.mTraversalDone = true;
                            break;
                        }
                        MergeSlot poll = this.mQueue.poll();
                        i17++;
                        if (poll == null) {
                            this.mTraversalDone = true;
                            break;
                        }
                        if (poll.need) {
                            i16++;
                            this.mediaList.add(poll.mImage);
                        }
                        if (poll.next()) {
                            this.mQueue.add(poll);
                        }
                    }
                }
            } catch (StaleDataException e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("QQAlbum", 2, "queryNext():" + e16.getMessage());
                }
                this.mTraversalDone = true;
            }
            this.isQuerying.set(false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQAlbum", 2, "nextCount\uff1a" + i3 + ", isQuerying:" + this.isQuerying.get() + ", mTraversalDone:" + this.mTraversalDone + ", MediaQueryHelper" + hashCode());
        }
        return this.mTraversalDone;
    }

    public void setListener(ICursor.FilterListener filterListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) filterListener);
            return;
        }
        this.mListener = filterListener;
        List<ICursor> list = this.mCursors;
        if (list != null) {
            Iterator<ICursor> it = list.iterator();
            while (it.hasNext()) {
                it.next().setListener(filterListener);
            }
        }
    }

    public void upDateCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.cursorsCount == -1 || this.cursorsVideoCount == -1) {
            this.cursorsCount = 0;
            this.cursorsVideoCount = 0;
            for (ICursor iCursor : this.mCursors) {
                int count = iCursor.getCount();
                this.cursorsCount += count;
                if (iCursor instanceof VideoCursor) {
                    this.cursorsVideoCount += count;
                }
            }
        }
    }

    MediaQueryHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTraversalDone = false;
        this.mEachCount = 300;
        this.cursorsCount = -1;
        this.cursorsVideoCount = -1;
        this.isQuerying = new AtomicBoolean(false);
        this.mLimit = -1;
    }

    public boolean queryNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? queryNext(this.mEachCount) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
    }
}
