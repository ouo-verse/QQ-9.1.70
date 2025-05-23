package com.tencent.mobileqq.colornote.swipeback.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.smallscreen.o;
import com.tencent.mobileqq.colornote.swipe.PostTable;
import com.tencent.mobileqq.colornote.swipe.SwipeBackLayout;
import com.tencent.mobileqq.colornote.swipe.d;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import ia1.c;

/* loaded from: classes5.dex */
public class SwipePostTableLayoutImpl extends SwipeBackLayout implements c.a, IColorNoteSwipeLayout {
    private static final String TAG = "SwipePostTableLayout";
    private ColorNoteCurd mColorNoteCurd;
    private ga1.a mColorNoteStateNotice;
    private boolean mEnablePostTable;
    private boolean mFirstShow;
    private boolean mFirstVib;
    public boolean mIsSwipeAdd;
    public boolean mIsSwipeBacked;
    private PostTable mPostTable;
    private boolean mPostTableVisible;
    private f mServiceInfo;
    private o mServiceSyncListener;
    private d mTouchStateDetector;
    private Vibrator mVibrator;
    private boolean pendingFinish;
    private boolean pendingScroll;
    private c translucentConvertor;

    /* loaded from: classes5.dex */
    class a implements o {
        a() {
        }

        @Override // com.tencent.mobileqq.colornote.smallscreen.o
        public void onServiceSyncSucc(boolean z16) {
            QLog.d(SwipePostTableLayoutImpl.TAG, 1, "result: " + z16);
            SwipePostTableLayoutImpl.this.enablePostTable();
        }
    }

    /* loaded from: classes5.dex */
    protected class b extends GestureDetector.SimpleOnGestureListener {
        protected b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            boolean z16;
            if (motionEvent != null && motionEvent2 != null) {
                boolean z17 = false;
                if (SwipePostTableLayoutImpl.this.mServiceInfo != null && SwipePostTableLayoutImpl.this.mServiceInfo.getColorNote() != null) {
                    ColorNote colorNote = SwipePostTableLayoutImpl.this.mServiceInfo.getColorNote();
                    z16 = SwipePostTableLayoutImpl.this.mColorNoteCurd.j(colorNote.getServiceType(), colorNote.getSubType());
                } else {
                    z16 = false;
                }
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float y16 = motionEvent.getY() - motionEvent2.getY();
                if (x16 != 0.0f && ((SwipeBackLayout) SwipePostTableLayoutImpl.this).allowedSliding && f16 >= 200.0f) {
                    float abs = Math.abs(y16 / x16);
                    if (SwipePostTableLayoutImpl.this.translucentConvertor == null || SwipePostTableLayoutImpl.this.translucentConvertor.c()) {
                        z17 = true;
                    }
                    if (x16 < 0.0f && abs < 0.5f) {
                        if (z16) {
                            if (!z17) {
                                SwipePostTableLayoutImpl.this.pendingFinish = true;
                                SwipePostTableLayoutImpl.this.translucentConvertor.b();
                            } else {
                                ((SwipeBackLayout) SwipePostTableLayoutImpl.this).mHandler.sendEmptyMessage(1);
                            }
                            SwipePostTableLayoutImpl.this.postInvalidate();
                        } else if (((SwipeBackLayout) SwipePostTableLayoutImpl.this).mContext instanceof Activity) {
                            ((SwipeBackLayout) SwipePostTableLayoutImpl.this).isFling = true;
                            if (z17) {
                                SwipePostTableLayoutImpl.this.scrollRight();
                            } else {
                                SwipePostTableLayoutImpl.this.pendingScroll = true;
                                SwipePostTableLayoutImpl.this.translucentConvertor.b();
                            }
                        } else if (z17) {
                            SwipePostTableLayoutImpl.this.scrollRight();
                        } else {
                            SwipePostTableLayoutImpl.this.pendingScroll = true;
                            SwipePostTableLayoutImpl.this.translucentConvertor.b();
                        }
                    }
                    if (((SwipeBackLayout) SwipePostTableLayoutImpl.this).mOnPageSwipeListener != null) {
                        ((SwipeBackLayout) SwipePostTableLayoutImpl.this).mOnPageSwipeListener.onPageSwipeClose();
                    }
                    return super.onFling(motionEvent, motionEvent2, f16, f17);
                }
                return super.onFling(motionEvent, motionEvent2, f16, f17);
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }
    }

    public SwipePostTableLayoutImpl(Context context) {
        super(context);
        this.mPostTableVisible = false;
        this.mIsSwipeBacked = false;
        this.mIsSwipeAdd = false;
        this.mEnablePostTable = true;
        this.mFirstShow = true;
        this.mFirstVib = true;
        this.mServiceSyncListener = new a();
        this.mPostTable = new PostTable(context);
        this.mTouchStateDetector = new d(context);
        ColorNoteCurd colorNoteCurd = new ColorNoteCurd();
        this.mColorNoteCurd = colorNoteCurd;
        colorNoteCurd.l(new g());
        ga1.a aVar = new ga1.a();
        this.mColorNoteStateNotice = aVar;
        aVar.f(this.mColorNoteCurd);
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mGestureDetector = new GestureDetector(context, new b());
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).setServiceSyncListener(this.mServiceSyncListener);
        SwipeBackLayout.WEBVIEW_LEFT_SWIPE_SCOPE = x.c(context, 18.0f);
    }

    private ColorNote generateColorNote() {
        f fVar = this.mServiceInfo;
        if (fVar != null) {
            return fVar.getColorNote();
        }
        return null;
    }

    private boolean insertColorNote(ColorNote colorNote) {
        com.tencent.mobileqq.colornote.data.a.d(colorNote);
        Bundle parseBundle = colorNote.parseBundle();
        parseBundle.putInt("color_note_curd_from_type", 1);
        this.mColorNoteCurd.a(parseBundle);
        this.mIsSwipeAdd = true;
        com.tencent.mobileqq.colornote.swipe.a aVar = this.mOnPageSwipeListener;
        if (aVar != null) {
            aVar.onPageSwipeClose();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "add colornote from swipe entrance:\n" + colorNote.mServiceType + "\n" + colorNote.mSubType + "\n" + colorNote.mMainTitle + "\n" + colorNote.mSubTitle + "\n" + colorNote.mPicUrl);
        }
        ReportController.o(null, "dc00898", "", "", "0X800A742", "0X800A742", com.tencent.mobileqq.colornote.a.b(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
        return true;
    }

    private void onActionMove(MotionEvent motionEvent, double d16, ColorNote colorNote, boolean z16) {
        if (this.allowedSliding && com.tencent.mobileqq.colornote.data.a.F(colorNote)) {
            if (!this.mTouchStateDetector.b(motionEvent, getContext())) {
                this.mFirstVib = true;
            } else if (this.mEnablePostTable && this.allowedSliding && this.mFirstVib && !z16) {
                this.mVibrator.vibrate(50L);
                this.mFirstVib = false;
            }
            if (this.mEnablePostTable && this.allowedSliding) {
                if (d16 > 1.0E-8d) {
                    if (!z16) {
                        int rawX = (int) motionEvent.getRawX();
                        if (rawX - this.downX > this.mTouchSlop && Math.abs(((int) motionEvent.getRawY()) - this.downY) < this.mTouchSlop) {
                            this.isSilding = true;
                        }
                        if (rawX - this.downX > 0 && this.isSilding) {
                            if (!this.mPostTableVisible) {
                                this.mPostTable.setVisibility(0);
                                this.mPostTableVisible = true;
                            }
                            if (this.mColorNoteCurd.d()) {
                                if (this.mTouchStateDetector.b(motionEvent, getContext())) {
                                    this.mPostTable.g();
                                } else {
                                    this.mPostTable.i();
                                }
                            } else {
                                this.mPostTable.h();
                            }
                            this.mPostTable.b(d16);
                            if (this.mFirstShow) {
                                ReportController.o(null, "dc00898", "", "", "0X800A741", "0X800A741", com.tencent.mobileqq.colornote.a.b(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
                                this.mFirstShow = false;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.mPostTable.setVisibility(4);
                this.mPostTableVisible = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean onActionUp(MotionEvent motionEvent, ColorNote colorNote, boolean z16) {
        boolean z17;
        PostTable postTable;
        this.mFirstShow = true;
        this.mFirstVib = true;
        if (this.mEnablePostTable && this.allowedSliding) {
            if (this.mTouchStateDetector.b(motionEvent, getContext()) && !z16 && colorNote != null && com.tencent.mobileqq.colornote.data.a.F(colorNote)) {
                if (this.mColorNoteCurd.d()) {
                    z17 = insertColorNote(colorNote);
                    if (((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).getFloatingWindowPosition().x < this.screenWidth / 2) {
                        fastScrollOrigin();
                    }
                    postTable = this.mPostTable;
                    if (postTable != null) {
                        postTable.setVisibility(4);
                        this.mPostTableVisible = false;
                    }
                    if (motionEvent.getRawX() - this.downX >= this.screenWidth / 2) {
                        this.mIsSwipeBacked = true;
                        com.tencent.mobileqq.colornote.swipe.a aVar = this.mOnPageSwipeListener;
                        if (aVar != null) {
                            aVar.onPageSwipeClose();
                        }
                    }
                    if ((z17 && !z16) || motionEvent.getRawX() - this.downX < this.screenWidth / 2) {
                        return false;
                    }
                    this.mHandler.sendEmptyMessage(1);
                    postInvalidate();
                    return true;
                }
                this.mPostTable.b(0.0d);
                scrollOrigin();
                com.tencent.mobileqq.colornote.data.a.E(getContext());
                ReportController.o(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
                return true;
            }
        }
        z17 = false;
        if (((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).getFloatingWindowPosition().x < this.screenWidth / 2) {
        }
        postTable = this.mPostTable;
        if (postTable != null) {
        }
        if (motionEvent.getRawX() - this.downX >= this.screenWidth / 2) {
        }
        if (z17) {
        }
        this.mHandler.sendEmptyMessage(1);
        postInvalidate();
        return true;
    }

    @Override // com.tencent.mobileqq.colornote.swipe.SwipeBackLayout, com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void attachToActivity(Activity activity) {
        super.attachToActivity(activity);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.mPostTable);
        this.mPostTable.setVisibility(4);
        this.mPostTable.b(0.0d);
        this.mPostTableVisible = false;
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void bringButtonToFront(Activity activity) {
        ViewGroup viewGroup;
        if (activity != null && (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) != null && viewGroup.getChildCount() > 1 && !(viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof PostTable)) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                if (viewGroup.getChildAt(i3) instanceof PostTable) {
                    viewGroup.getChildAt(i3).bringToFront();
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void disablePostTable() {
        this.mEnablePostTable = false;
        this.mColorNoteStateNotice.g(false);
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void enablePostTable() {
        this.mEnablePostTable = true;
        this.mColorNoteStateNotice.g(true);
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public boolean getIsSwipeAdd() {
        return this.mIsSwipeAdd;
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public boolean getIsSwipeBacked() {
        return this.mIsSwipeBacked;
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void noticeRecentColorNote() {
        this.mColorNoteStateNotice.b();
    }

    @Override // com.tencent.mobileqq.colornote.swipe.SwipeBackLayout, com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.colornote.swipe.SwipeBackLayout, com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void onPause() {
        super.onPause();
        this.mColorNoteStateNotice.d();
    }

    @Override // com.tencent.mobileqq.colornote.swipe.SwipeBackLayout, com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void onResume() {
        super.onResume();
        this.mColorNoteStateNotice.e();
    }

    @Override // com.tencent.mobileqq.colornote.swipe.SwipeBackLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mColorNoteCurd.i()) {
            disablePostTable();
        }
        double c16 = this.mTouchStateDetector.c(motionEvent);
        this.mColorNoteCurd.d();
        f fVar = this.mServiceInfo;
        if (fVar == null) {
            return super.onTouchEvent(motionEvent);
        }
        ColorNote colorNote = fVar.getColorNote();
        if (colorNote != null && this.mContentView.getScrollX() != 0 && !TextUtils.isEmpty(colorNote.mSubType)) {
            boolean j3 = this.mColorNoteCurd.j(colorNote.getServiceType(), colorNote.getSubType());
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    onActionMove(motionEvent, c16, colorNote, j3);
                }
            } else if (onActionUp(motionEvent, colorNote, j3)) {
                return true;
            }
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(true);
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                requestDisallowInterceptTouchEvent(false);
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // ia1.c.a
    public void onTranslucentConversionComplete(boolean z16) {
        if (this.pendingFinish) {
            this.pendingFinish = false;
            this.mHandler.sendEmptyMessage(1);
        }
        if (this.pendingScroll) {
            this.pendingScroll = false;
            scrollRight();
        }
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void setLeftScope(int i3) {
        this.leftSwipeScope = i3;
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void setOnColorNoteCurdListener(g gVar) {
        this.mColorNoteCurd.l(gVar);
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void setOnPageSwipeListener(com.tencent.mobileqq.colornote.swipe.a aVar) {
        this.mOnPageSwipeListener = aVar;
    }

    @Override // com.tencent.mobileqq.colornote.swipe.SwipeBackLayout, com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void setOnSwipeListener(SwipeBackLayout.b bVar) {
        super.setOnSwipeListener(bVar);
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void setServiceInfo(f fVar) {
        if (fVar != null) {
            this.mServiceInfo = fVar;
            this.mColorNoteStateNotice.i(fVar);
            ColorNote colorNote = fVar.getColorNote();
            if (colorNote != null && colorNote.mServiceType == 16908288) {
                this.leftSwipeScope = SwipeBackLayout.WEBVIEW_LEFT_SWIPE_SCOPE;
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
    public void setTranslucentConvertor(c cVar) {
        this.translucentConvertor = cVar;
        cVar.a(this);
    }
}
