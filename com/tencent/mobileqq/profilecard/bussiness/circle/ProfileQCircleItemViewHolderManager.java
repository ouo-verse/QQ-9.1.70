package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileQCircleItemViewHolderManager implements ProfileQCircleItemViewHolder.IProfileQCircleItemPlayListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileQCircleItemViewHolderManager";
    private int mCurPlayPos;
    private final IProfileQCircleItemClickListener mItemClickListener;
    private final ArrayList<ProfileQCircleItemViewHolder> mItemViewHolders;
    private int mVideoPlayCtl;

    /* loaded from: classes16.dex */
    public interface IProfileQCircleItemClickListener {
        void onItemClick(View view, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, BitmapDrawable bitmapDrawable);
    }

    public ProfileQCircleItemViewHolderManager(IProfileQCircleItemClickListener iProfileQCircleItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iProfileQCircleItemClickListener);
            return;
        }
        this.mItemViewHolders = new ArrayList<>();
        this.mCurPlayPos = -1;
        this.mVideoPlayCtl = 0;
        this.mItemClickListener = iProfileQCircleItemClickListener;
    }

    private boolean canAutoPlayVideo() {
        if (this.mVideoPlayCtl == 1) {
            return true;
        }
        return false;
    }

    public void addItemViewHolder(ProfileQCircleItemViewHolder profileQCircleItemViewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) profileQCircleItemViewHolder);
        } else {
            if (profileQCircleItemViewHolder == null || this.mItemViewHolders.contains(profileQCircleItemViewHolder)) {
                return;
            }
            profileQCircleItemViewHolder.setItemPlayListener(this);
            this.mItemViewHolders.add(profileQCircleItemViewHolder);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.IProfileQCircleItemPlayListener
    public void onItemClick(View view, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, BitmapDrawable bitmapDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, Integer.valueOf(i3), feedCloudMeta$StFeed, bitmapDrawable);
            return;
        }
        QLog.d(TAG, 1, "[onItemClick] clickPos:" + i3);
        IProfileQCircleItemClickListener iProfileQCircleItemClickListener = this.mItemClickListener;
        if (iProfileQCircleItemClickListener != null) {
            iProfileQCircleItemClickListener.onItemClick(view, i3, feedCloudMeta$StFeed, bitmapDrawable);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.IProfileQCircleItemPlayListener
    public void onPlayEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        QLog.d(TAG, 1, "[onPlayEnd] endPlayPos:" + i3);
        playTargetVideo(i3 + 1);
    }

    public void pausePlayVideo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (!canAutoPlayVideo()) {
            return;
        }
        QLog.d(TAG, 1, "[pausePlayVideo] size:" + this.mItemViewHolders.size());
        for (int i3 = 0; i3 < this.mItemViewHolders.size(); i3++) {
            ProfileQCircleItemViewHolder profileQCircleItemViewHolder = this.mItemViewHolders.get(i3);
            if (profileQCircleItemViewHolder != null) {
                profileQCircleItemViewHolder.pause(z16);
            }
        }
    }

    public void playTargetVideo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (!canAutoPlayVideo()) {
            return;
        }
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            if (i16 >= this.mItemViewHolders.size()) {
                break;
            }
            ProfileQCircleItemViewHolder profileQCircleItemViewHolder = this.mItemViewHolders.get(i16);
            if (profileQCircleItemViewHolder != null && profileQCircleItemViewHolder.isVideo()) {
                if (profileQCircleItemViewHolder.disableAutoPlay()) {
                    QLog.d(TAG, 1, "[playTargetVideo] disableAutoPlay");
                } else {
                    int position = profileQCircleItemViewHolder.getPosition();
                    if (position >= i3) {
                        QLog.d(TAG, 1, "[playTargetVideo] targetPos:" + i3 + ", findPos:" + position);
                        profileQCircleItemViewHolder.startPlay();
                        this.mCurPlayPos = position;
                        z16 = true;
                        break;
                    }
                }
            }
            i16++;
        }
        if (!z16) {
            this.mCurPlayPos = -1;
        }
    }

    public void releaseAllItemViewHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!canAutoPlayVideo()) {
            return;
        }
        QLog.d(TAG, 1, "[releaseAllItemViewHolder] size:" + this.mItemViewHolders.size());
        for (int i3 = 0; i3 < this.mItemViewHolders.size(); i3++) {
            ProfileQCircleItemViewHolder profileQCircleItemViewHolder = this.mItemViewHolders.get(i3);
            if (profileQCircleItemViewHolder != null) {
                profileQCircleItemViewHolder.release();
            }
        }
    }

    public void removeAllItemViewHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "[removeAllItemViewHolder] size:" + this.mItemViewHolders.size());
        releaseAllItemViewHolder();
        this.mItemViewHolders.clear();
    }

    public void resumePlayVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!canAutoPlayVideo()) {
            return;
        }
        QLog.d(TAG, 1, "[resumePlayVideo] mCurPlayPos:" + this.mCurPlayPos + ", size:" + this.mItemViewHolders.size());
        int i3 = this.mCurPlayPos;
        if (i3 >= 0) {
            playTargetVideo(i3);
        }
    }

    public void setVideoPlayCtl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        int i16 = Build.VERSION.SDK_INT;
        QLog.d(TAG, 1, "[setVideoPlayCtl] videoPlayCtl:" + i3 + ", sdk:" + i16);
        if (i16 != 23 && i16 != 26 && i16 != 27) {
            this.mVideoPlayCtl = i3;
        } else {
            this.mVideoPlayCtl = 0;
        }
    }
}
