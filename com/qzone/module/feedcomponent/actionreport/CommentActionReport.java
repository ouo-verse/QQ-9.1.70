package com.qzone.module.feedcomponent.actionreport;

import android.util.Log;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CommentActionReport {
    public static final int FAST_COMMON_TYPE = 3;
    public static final int FORWARD_BUTTON_TYPE = 4;
    public static final int GUIDE_COMMON_TYPE = 2;
    public static final int NORMAL_COMMON_TYPE = 1;
    public static final int REPLY_COMMON_TYPE = 5;
    static CommentActionReport mInstance;
    int mCommonType;
    BusinessFeedData mFeedData;
    int mFeedIndex;
    int pageType = 12;

    public static CommentActionReport getInstance() {
        if (mInstance == null) {
            synchronized (CommentActionReport.class) {
                if (mInstance == null) {
                    mInstance = new CommentActionReport();
                }
            }
        }
        return mInstance;
    }

    public void setCommentReportInfo(BusinessFeedData businessFeedData, int i3, int i16, int i17) {
        this.mFeedData = businessFeedData;
        this.mFeedIndex = i3;
        this.mCommonType = i16;
        this.pageType = i17;
    }

    public void doCommentActionReport(int i3) {
        int i16 = this.mCommonType;
        if (i16 == 0 || this.mFeedData == null) {
            if (i16 == 0) {
                UserActionReportHelper.doQzoneCommentActionReport(i3, this.pageType);
                return;
            }
            return;
        }
        switch (i3) {
            case 25:
                if (i16 == 1) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "normal common input begin");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 4, 2);
                    return;
                }
                if (i16 == 2) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "guide common input begin");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 5, 2);
                    return;
                }
                if (i16 == 3) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "fast common input begin");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 6, 2);
                    return;
                } else if (i16 == 4) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "forward button input begin");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 35, 2);
                    return;
                } else {
                    if (i16 == 5) {
                        if (FeedGlobalEnv.g().isDebug()) {
                            Log.i("FeedClickReport", "reply common input begin");
                        }
                        FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 38, 2);
                        return;
                    }
                    return;
                }
            case 26:
                if (i16 == 1) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "normal common input cancel");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 4, 3);
                } else if (i16 == 2) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "guide common input cancel");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 5, 3);
                } else if (i16 == 3) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "fast common input cancel");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 6, 3);
                } else if (i16 == 4) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "forward button  input cancel");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 35, 3);
                } else if (i16 == 5) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "reply common input cancel");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 38, 3);
                }
                this.mCommonType = 0;
                return;
            case 27:
                if (i16 == 1) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "normal common input finish");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 4, 4);
                } else if (i16 == 2) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "guide common input finish");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 5, 4);
                } else if (i16 == 3) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "fast common input finish");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 6, 4);
                } else if (i16 == 4) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "forward button  input finish");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 35, 4);
                } else if (i16 == 5) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "reply common input finish");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(this.mFeedData, this.mFeedIndex, System.currentTimeMillis(), this.pageType, 38, 4);
                }
                this.mCommonType = 0;
                return;
            default:
                return;
        }
    }
}
