package com.tencent.mobileqq.colornote.api.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.d;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder;
import com.tencent.mobileqq.colornote.list.g;
import com.tencent.mobileqq.colornote.list.i;
import com.tencent.mobileqq.colornote.settings.e;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.smallscreen.o;
import com.tencent.mobileqq.colornote.swipe.SwipeBackLayout;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.colornote.swipeback.impl.SwipePostTableLayoutImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ia1.c;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteControllerImpl implements SwipeBackLayout.b, IColorNoteController, c.a {
    private static final String TAG = "ColorNoteController";
    private static SparseArrayCompat<g> itemBuilders;
    private static final Map<Integer, fa1.b> launchers = new TreeMap();
    private boolean hasPendingExitAnim;
    private ga1.a mColorNoteStateNotice;
    private EnterExitAnimHelper mEnterExitAnimHelper;
    private ha1.a mOnColorNoteAnimFinishListener;
    private ga1.b mShareEntrance;
    private IColorNoteSwipeLayout mSwipePostTableLayout;
    private c translucentConvertor;
    private boolean mShowToast = true;
    private boolean hasShareEntr = true;
    private Runnable forceCloseRunnable = new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl.1
        @Override // java.lang.Runnable
        public void run() {
            ColorNoteControllerImpl.this.exitAnimation(true);
        }
    };
    private boolean mAutoRecentNote = false;

    static {
        try {
            Iterator<Class<? extends fa1.b>> it = d.f201388a.iterator();
            while (it.hasNext()) {
                fa1.b newInstance = it.next().newInstance();
                launchers.put(Integer.valueOf(newInstance.getType()), newInstance);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[static]", e16);
        }
    }

    public static g getItemBuilder(ColorNote colorNote) {
        if (itemBuilders == null) {
            initItemBuilders();
        }
        g gVar = itemBuilders.get(colorNote.getServiceType());
        if (gVar == null) {
            return itemBuilders.get(65536);
        }
        return gVar;
    }

    private static void initItemBuilders() {
        SparseArrayCompat<g> sparseArrayCompat = new SparseArrayCompat<>();
        itemBuilders = sparseArrayCompat;
        sparseArrayCompat.put(65536, new DefaultItemBuilder());
        itemBuilders.put(R.id.checkbox, new i());
    }

    public static boolean isRecentlyViewedSwitchOn(AppRuntime appRuntime) {
        return ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).isRecentColorNoteTurnOn(appRuntime);
    }

    public static boolean launch(Context context, ColorNote colorNote) {
        return launch(context, colorNote, null);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void addHistoryNote() {
        ga1.b bVar = this.mShareEntrance;
        if (bVar != null) {
            com.tencent.mobileqq.colornote.settings.c.a(bVar.d());
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void addToRecentNote() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.noticeRecentColorNote();
            return;
        }
        ga1.a aVar = this.mColorNoteStateNotice;
        if (aVar != null) {
            aVar.b();
        } else {
            QLog.d(TAG, 1, "[addToRecentNote] mColorNoteStateNotice is null.");
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void attachToActivity(Activity activity) {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.attachToActivity(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        View findViewById = viewGroup.findViewById(R.id.content);
        if (findViewById == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "can not find content view");
            }
        } else {
            childAt = findViewById;
        }
        this.mShareEntrance.j(childAt);
        EnterExitAnimHelper enterExitAnimHelper = new EnterExitAnimHelper(childAt);
        this.mEnterExitAnimHelper = enterExitAnimHelper;
        enterExitAnimHelper.b();
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).registerBroadcast();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean canAddColorNote() {
        ga1.b bVar = this.mShareEntrance;
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void deleteColorNote() {
        ga1.b bVar = this.mShareEntrance;
        if (bVar != null) {
            bVar.b();
            ColorNote colorNote = this.mShareEntrance.e().getColorNote();
            if (colorNote != null) {
                ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(colorNote.mServiceType, colorNote.mSubType, false);
                if (this.mShowToast) {
                    BaseApplication context = BaseApplication.getContext();
                    QQToast.makeText(context, 2, context.getString(com.tencent.mobileqq.R.string.imc), 2000).show();
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "delete color note from share entrance: " + colorNote.getServiceType() + ", " + colorNote.mSubType + ", " + colorNote.mMainTitle);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean detectCacheFull(AppRuntime appRuntime, int i3) {
        return com.tencent.mobileqq.colornote.settings.c.c(appRuntime, i3);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void disableAutoRecentNote() {
        this.mAutoRecentNote = false;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void disablePostTable() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.disablePostTable();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void disableSwipe() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.disableSwipe();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void disableToast() {
        this.mShowToast = false;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void dispatchRecentViewSwitchChanged(boolean z16) {
        e.a(z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void doSetPropertiesFromWebView(String str) {
        int a16 = com.tencent.mobileqq.colornote.data.a.a(str);
        if (com.tencent.mobileqq.colornote.data.a.q(a16)) {
            setShareEntr(false);
        } else {
            setShareEntr(true);
        }
        if (com.tencent.mobileqq.colornote.data.a.p(a16)) {
            disablePostTable();
        } else {
            enablePostTable();
        }
    }

    public void enableAutoRecentNote() {
        this.mAutoRecentNote = true;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void enablePostTable() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.enablePostTable();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void enableSwipe() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.enableSwipe();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void exitAnimation() {
        exitAnimation(false);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public IColorNoteSwipeLayout getSwipePostTableLayout() {
        return this.mSwipePostTableLayout;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean hasShareEntr() {
        return this.hasShareEntr;
    }

    public void init(Context context, boolean z16, boolean z17, IColorNoteSwipeLayout iColorNoteSwipeLayout) {
        init(context, z16, z17, iColorNoteSwipeLayout, false, false, com.tencent.mobileqq.R.color.f156954am1);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void insertColorNote() {
        ga1.b bVar = this.mShareEntrance;
        if (bVar != null) {
            bVar.f();
            ColorNote colorNote = this.mShareEntrance.e().getColorNote();
            if (colorNote != null) {
                ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(colorNote.mServiceType, colorNote.mSubType, true);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "insert color note from share entrance: " + colorNote.getServiceType() + ", " + colorNote.mSubType + ", " + colorNote.mMainTitle);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean isColorNoteExist() {
        ga1.b bVar = this.mShareEntrance;
        if (bVar != null) {
            return bVar.g();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean isFirstCloseRecentNote() {
        return com.tencent.mobileqq.colornote.e.c();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean isSwipeBackExit() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            return iColorNoteSwipeLayout.getIsSwipeBacked();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void onCannotAdd() {
        ga1.b bVar = this.mShareEntrance;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void onDestroy() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.onDestroy();
        }
        ga1.a aVar = this.mColorNoteStateNotice;
        if (aVar != null) {
            aVar.c(this.mAutoRecentNote);
        }
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).unregisterBroadcast();
        this.mShareEntrance = null;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public ColorNote onGetColorNote(int i3, String str, String str2, String str3, String str4, byte[] bArr) {
        return new ColorNote.a().g(i3).i(str).d(str2).h(str3).e(str4).f(bArr).a();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void onPause() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.onPause();
        }
        ga1.a aVar = this.mColorNoteStateNotice;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void onResume() {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.onResume();
        }
        ga1.a aVar = this.mColorNoteStateNotice;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.tencent.mobileqq.colornote.swipe.SwipeBackLayout.b
    public void onSwipe(boolean z16) {
        c cVar;
        if (z16 && (cVar = this.translucentConvertor) != null) {
            cVar.b();
        }
    }

    @Override // ia1.c.a
    public void onTranslucentConversionComplete(boolean z16) {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.setReadyToSlide(true);
        }
        if (this.hasPendingExitAnim) {
            exitAnimation();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void refreshPostTable(Activity activity) {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.bringButtonToFront(activity);
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void registerBroadcast() {
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).registerBroadcast();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setCustomNightMode(Context context, boolean z16) {
        ColorNoteSmallScreenUtil.m(context, 6, z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setFirstCloseRecentNote(AppRuntime appRuntime) {
        com.tencent.mobileqq.colornote.e.f(appRuntime);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setLeftSwipeScope(int i3) {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.setLeftScope(i3);
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setOnColorNoteAnimFinishListener(ha1.a aVar) {
        this.mOnColorNoteAnimFinishListener = aVar;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setOnColorNoteCurdListener(com.tencent.mobileqq.colornote.g gVar) {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.setOnColorNoteCurdListener(gVar);
        }
        ga1.a aVar = this.mColorNoteStateNotice;
        if (aVar != null) {
            aVar.h(gVar);
        }
        ga1.b bVar = this.mShareEntrance;
        if (bVar != null) {
            bVar.k(gVar);
        }
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).setColorNoteCurdListener(gVar);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setOnPageSwipeListener(com.tencent.mobileqq.colornote.swipe.a aVar) {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.setOnPageSwipeListener(aVar);
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setRecentlyViewedSwitch(AppRuntime appRuntime, boolean z16) {
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).setRecentColorNoteSwitch(appRuntime, z16);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setServiceInfo(f fVar) {
        IColorNoteSwipeLayout iColorNoteSwipeLayout = this.mSwipePostTableLayout;
        if (iColorNoteSwipeLayout != null) {
            iColorNoteSwipeLayout.setServiceInfo(fVar);
        }
        ga1.a aVar = this.mColorNoteStateNotice;
        if (aVar != null) {
            aVar.i(fVar);
        }
        this.mShareEntrance.l(fVar);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setServiceSyncListener(o oVar) {
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).setServiceSyncListener(oVar);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setShareEntr(boolean z16) {
        this.hasShareEntr = z16;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void setSmallScreenShouldShow(boolean z16, int i3) {
        ColorNoteSmallScreenService.L(z16, i3);
    }

    public void setSwipePostTableLayout(IColorNoteSwipeLayout iColorNoteSwipeLayout) {
        this.mSwipePostTableLayout = iColorNoteSwipeLayout;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean shouldDisplayColorNote() {
        return ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).getSyncState();
    }

    public void unregisterBroadcast() {
        ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).unregisterBroadcast();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void updateColorNote(ColorNote colorNote) {
        ga1.b bVar;
        if (colorNote != null && (bVar = this.mShareEntrance) != null) {
            bVar.m(colorNote);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "update color note from share entrance: " + colorNote.getServiceType() + ", " + colorNote.mSubType + ", " + colorNote.mMainTitle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitAnimation(boolean z16) {
        f e16;
        ColorNote colorNote;
        IColorNoteSwipeLayout iColorNoteSwipeLayout;
        if (this.mEnterExitAnimHelper != null) {
            Object obj = this.mSwipePostTableLayout;
            if (obj != null) {
                ((View) obj).removeCallbacks(this.forceCloseRunnable);
            }
            if (((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).getFloatingWindowPosition() != null) {
                this.mEnterExitAnimHelper.d(r0.x, r0.y);
            }
            if (!isColorNoteExist() && ((iColorNoteSwipeLayout = this.mSwipePostTableLayout) == null || !iColorNoteSwipeLayout.getIsSwipeAdd())) {
                this.mOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
                return;
            }
            c cVar = this.translucentConvertor;
            if (cVar == null || cVar.c()) {
                this.hasPendingExitAnim = false;
                ga1.b bVar = this.mShareEntrance;
                boolean z17 = (bVar == null || (e16 = bVar.e()) == null || (colorNote = e16.getColorNote()) == null || colorNote.mServiceType != 16842752) ? false : true;
                EnterExitAnimHelper enterExitAnimHelper = this.mEnterExitAnimHelper;
                ha1.a aVar = this.mOnColorNoteAnimFinishListener;
                IColorNoteSwipeLayout iColorNoteSwipeLayout2 = this.mSwipePostTableLayout;
                enterExitAnimHelper.a(aVar, z17, iColorNoteSwipeLayout2 != null ? iColorNoteSwipeLayout2.getScrollX() : 0);
                return;
            }
            if (z16) {
                this.mOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
                return;
            }
            this.hasPendingExitAnim = true;
            this.translucentConvertor.b();
            Object obj2 = this.mSwipePostTableLayout;
            if (obj2 != null) {
                ((View) obj2).postDelayed(this.forceCloseRunnable, 500L);
            }
        }
    }

    public static boolean launch(Context context, ColorNote colorNote, Bundle bundle) {
        fa1.b bVar = launchers.get(Integer.valueOf(com.tencent.mobileqq.colornote.data.a.k(colorNote.getServiceType())));
        if (bVar == null) {
            return false;
        }
        bVar.onCreate(context, colorNote, bundle);
        if (!com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
            ReportController.o(null, "dc00898", "", "", "0X800A749", "0X800A749", com.tencent.mobileqq.colornote.a.b(colorNote.getServiceType()), 0, "", "", "", "");
        }
        if (com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
            colorNote = com.tencent.mobileqq.colornote.data.a.j(colorNote);
        }
        bVar.launch(context, colorNote);
        return true;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void init(Context context, boolean z16, boolean z17, IColorNoteSwipeLayout iColorNoteSwipeLayout, boolean z18, boolean z19, int i3) {
        init(context, z16, z17, iColorNoteSwipeLayout, z18, false, z19, i3);
    }

    public static void addHistoryNote(ColorNote colorNote) {
        com.tencent.mobileqq.colornote.settings.c.a(colorNote);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void init(Context context, boolean z16, boolean z17, IColorNoteSwipeLayout iColorNoteSwipeLayout, boolean z18, boolean z19, boolean z26, int i3) {
        if (z16) {
            if (iColorNoteSwipeLayout == null) {
                this.mSwipePostTableLayout = new SwipePostTableLayoutImpl(context);
            } else {
                this.mSwipePostTableLayout = iColorNoteSwipeLayout;
            }
            if (z18) {
                if (com.tencent.mobileqq.colornote.swipe.c.d() && (!z19 || Build.VERSION.SDK_INT != 26)) {
                    c cVar = new c((Activity) context, !z18);
                    this.translucentConvertor = cVar;
                    cVar.a(this);
                    this.mSwipePostTableLayout.setTranslucentConvertor(this.translucentConvertor);
                    if (z26) {
                        this.mSwipePostTableLayout.setOnSwipeListener(this);
                        this.mSwipePostTableLayout.setReadyToSlide(false);
                    } else {
                        ((View) this.mSwipePostTableLayout).post(new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ColorNoteControllerImpl.this.translucentConvertor.b();
                            }
                        });
                    }
                } else {
                    this.mSwipePostTableLayout.setBackgroundResource(i3);
                }
            }
        }
        this.hasShareEntr = z17;
        if (z17 && !z16) {
            this.mColorNoteStateNotice = new ga1.a();
        }
        this.mShareEntrance = new ga1.b(context);
        QRoute.api(IColorNoteProcessState.class);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public boolean isColorNoteExist(ColorNote colorNote) {
        ga1.b bVar;
        if (colorNote == null || (bVar = this.mShareEntrance) == null) {
            return false;
        }
        return bVar.h(colorNote.getServiceType(), colorNote.getSubType());
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void init(Context context, boolean z16, boolean z17) {
        init(context, z16, z17, null);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteController
    public void init(Context context, boolean z16, boolean z17, boolean z18, boolean z19, int i3) {
        init(context, z16, z17, null, z18, z19, i3);
    }
}
