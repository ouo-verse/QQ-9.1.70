package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.tencent.image.AbstractGifImage;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes12.dex */
public class EmoticonPanelExtendHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> implements com.tencent.qqnt.aio.shortcutbar.g, EmotionPanelListView.PullAndFastScrollListener, IEmoticonPanelExtendHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "EmoticonPanelExtendHelper";
    private static int sMaxPanelHeight;
    private com.tencent.aio.api.runtime.a aioContext;
    private QQEmoticonMainPanelApp app;
    private float mDowny;
    private IPanelInteractionListener mInteractionListener;
    private int mOriginPanelHeight;
    private int mStartHeight;
    private TextWatcher textWatcher;

    public EmoticonPanelExtendHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
        } else {
            this.textWatcher = new TextWatcher() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelExtendHelper.this);
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) editable);
                    } else {
                        EmoticonPanelExtendHelper.this.updateDeleteBtnVisibility(editable.toString());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }
            };
        }
    }

    private void changeEmoticonPanel(int i3, String str) {
        int curPanelHeight = getCurPanelHeight();
        int i16 = this.mOriginPanelHeight;
        int i17 = (curPanelHeight - i16) + (-i3) + i16;
        int i18 = sMaxPanelHeight;
        if (i17 > i18) {
            i16 = i18;
        } else if (i17 >= i16) {
            i16 = i17;
        }
        if (i16 != curPanelHeight) {
            AbstractGifImage.pauseAll();
            setPanelHeight(i16 - this.mOriginPanelHeight);
        }
    }

    private void doPanelAnim(int i3, int i16, final int i17) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i16, i17);
        ofInt.setDuration(i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.emoticonview.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmoticonPanelExtendHelper.this.lambda$doPanelAnim$1(i17, valueAnimator);
            }
        });
        ofInt.start();
    }

    private int getCurPanelHeight() {
        h.b bVar;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null || (bVar = (h.b) aVar.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d)) == null) {
            return 750;
        }
        return bVar.a();
    }

    private int getDefaultPanelHeight() {
        h.b bVar;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null || (bVar = (h.b) aVar.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d)) == null) {
            return 750;
        }
        return bVar.b();
    }

    private void initMaxPanelHeight() {
        if (this.app.getApp().getResources().getConfiguration().orientation == 2) {
            QLog.d(LOG_TAG, 2, "devices on ORIENTATION_LANDSCAPE");
            sMaxPanelHeight = (int) (this.mOriginPanelHeight * 1.1d);
        } else {
            QLog.d(LOG_TAG, 2, "devices on ORIENTATION_PORTRAIT");
            sMaxPanelHeight = (int) (this.app.getApp().getResources().getDisplayMetrics().heightPixels * 0.64d);
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null && iPanelInteractionListener.isScaleChat()) {
            sMaxPanelHeight = (int) (sMaxPanelHeight * 0.8f);
        }
        int i3 = this.mOriginPanelHeight;
        if (i3 > sMaxPanelHeight) {
            sMaxPanelHeight = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doPanelAnim$1(int i3, ValueAnimator valueAnimator) {
        if (this.mInteractionListener == null) {
            return;
        }
        setPanelHeight(((Integer) valueAnimator.getAnimatedValue()).intValue() - this.mOriginPanelHeight);
        if (i3 == this.mOriginPanelHeight && getCurPanelHeight() == this.mOriginPanelHeight) {
            abortFling();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleTouchEvent$0(int i3, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue == i3) {
            AbstractGifImage.resumeAll();
        }
        setPanelHeight(intValue - this.mOriginPanelHeight);
    }

    private boolean needExtendPanel() {
        if (supportExtendPanel() && sMaxPanelHeight > this.mOriginPanelHeight && isShowExtendPanel()) {
            return true;
        }
        return false;
    }

    private void reportPanelUpDown(String str) {
        int i3;
        if (((EmoticonPanelController) this.mPanelController).getPanelDataList() != null && (i3 = BasePanelModel.sLastSelectedSecondTabIndex) >= 0 && i3 < ((EmoticonPanelController) this.mPanelController).getPanelDataList().size()) {
            int i16 = ((EmoticonPanelController) this.mPanelController).getPanelDataList().get(BasePanelModel.sLastSelectedSecondTabIndex).type;
            if (i16 == 7) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", str, str, 1, 0, "", "", "", "");
                return;
            }
            if (i16 == 4) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", str, str, 2, 0, "", "", "", "");
                return;
            }
            if (i16 == 11) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", str, str, 3, 0, "", "", "", "");
                return;
            }
            if (i16 == 8) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", str, str, 4, 0, "", "", "", "");
                return;
            }
            if (i16 == 10) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", str, str, 5, 0, "", "", "", "");
            } else if (i16 == 9 || i16 == 6) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", str, str, 6, 0, "", "", "", "");
            }
        }
    }

    private void setPanelHeight(int i3) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            return;
        }
        aVar.e().h(new PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent(LOG_TAG, i3, true));
    }

    private boolean showEmotionDeleteButton() {
        T t16 = this.mPanelController;
        if (t16 != 0 && ((EmoticonPanelController) t16).getParams() != null) {
            return ((EmoticonPanelController) this.mPanelController).getParams().showEmotionPanelDeleteButton;
        }
        return false;
    }

    protected void abortFling() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (((EmoticonPanelController) this.mPanelController).getPageAdapter() != null && ((EmoticonPanelController) this.mPanelController).getPanelDataList() != null && (i3 = BasePanelModel.sLastSelectedSecondTabIndex) >= 0 && i3 < ((EmoticonPanelController) this.mPanelController).getPanelDataList().size()) {
            BaseEmotionAdapter adapterFromCache = ((EmoticonPanelController) this.mPanelController).getPageAdapter().getAdapterFromCache(((EmoticonPanelController) this.mPanelController).getPanelDataList().get(BasePanelModel.sLastSelectedSecondTabIndex));
            if (adapterFromCache != null && adapterFromCache.getCurrentListView() != null) {
                adapterFromCache.getCurrentListView().abortFling();
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public void followHand(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent);
        }
    }

    protected BaseEmotionAdapter getEmoticonPanelBaseEmotionAdapter() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (BaseEmotionAdapter) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (((EmoticonPanelController) this.mPanelController).getPageAdapter() != null && ((EmoticonPanelController) this.mPanelController).getPanelDataList() != null && (i3 = BasePanelModel.sLastSelectedSecondTabIndex) >= 0 && i3 < ((EmoticonPanelController) this.mPanelController).getPanelDataList().size()) {
            BaseEmotionAdapter adapterFromCache = ((EmoticonPanelController) this.mPanelController).getPageAdapter().getAdapterFromCache(((EmoticonPanelController) this.mPanelController).getPanelDataList().get(BasePanelModel.sLastSelectedSecondTabIndex));
            if (adapterFromCache != null && adapterFromCache.getCurrentListView() != null && (adapterFromCache.getCurrentListView().getOnScrollListener() instanceof EmoticonPanelOnScrollListener)) {
                return adapterFromCache;
            }
            return null;
        }
        return null;
    }

    public CharSequence getInputText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (CharSequence) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            return "";
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(new InputEvent.GetInputString());
        if (!(k3 instanceof d.C7264d)) {
            return "";
        }
        CharSequence a16 = ((d.C7264d) k3).a();
        if (a16 instanceof QQTextBuilder) {
            return new QQTextBuilder(a16, 3);
        }
        return String.valueOf(a16);
    }

    public int getMaxHeightSubNormalHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        int i16 = sMaxPanelHeight;
        if (i3 <= 0) {
            i3 = this.mOriginPanelHeight;
        }
        return i16 - i3;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelExtendHelper
    public int getOriginPanelHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mOriginPanelHeight;
    }

    public int getSearchAnimHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return sMaxPanelHeight + ViewUtils.dip2px(35.0f);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return LOG_TAG;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r0 != 3) goto L47;
     */
    @Override // com.tencent.qqnt.aio.shortcutbar.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!needExtendPanel()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float y16 = motionEvent.getY();
                int i16 = (int) ((y16 - this.mDowny) + 0.5f);
                QLog.d(LOG_TAG, 2, "handleTouchEvent MOVE, y=" + y16 + ", dst=" + i16);
                changeEmoticonPanel(i16, "TouchEvent");
            }
            return true;
        }
        int curPanelHeight = getCurPanelHeight();
        final int i17 = sMaxPanelHeight;
        if (curPanelHeight != i17 && curPanelHeight != (i3 = this.mOriginPanelHeight)) {
            int i18 = this.mStartHeight;
            if (curPanelHeight <= i18) {
                i17 = i3;
            }
            if (Math.abs(curPanelHeight - i18) > 100) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i17 = this.mStartHeight;
            }
            if (z16 && i17 == this.mOriginPanelHeight) {
                reportPanelUpDown("0X800A847");
                if (QLog.isColorLevel()) {
                    QLog.i(LOG_TAG, 2, "report panel close");
                }
            } else if (z16 && i17 == sMaxPanelHeight) {
                reportPanelUpDown("0X800A846");
                if (QLog.isColorLevel()) {
                    QLog.i(LOG_TAG, 2, "report panel open");
                }
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(curPanelHeight, i17);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.emoticonview.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EmoticonPanelExtendHelper.this.lambda$handleTouchEvent$0(i17, valueAnimator);
                }
            });
            ofInt.start();
        } else {
            AbstractGifImage.resumeAll();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initBefore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mInteractionListener = ((EmoticonPanelController) this.mPanelController).getInteractionListener();
        T t16 = this.mPanelController;
        this.app = ((EmoticonPanelController) t16).app;
        this.aioContext = ((EmoticonPanelController) t16).getParams().ntAioContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initPanelExtendHeight() {
        int panelTargetHeight;
        if (supportExtendPanel()) {
            panelTargetHeight = getDefaultPanelHeight();
        } else {
            panelTargetHeight = this.mInteractionListener.getPanelTargetHeight();
        }
        this.mOriginPanelHeight = panelTargetHeight;
        QLog.e(LOG_TAG, 2, "originPanelHeight has value is " + this.mOriginPanelHeight);
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.g
    public boolean interceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!needExtendPanel()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                if (((EmoticonPanelController) this.mPanelController).getPanel().getParent() == null) {
                    return false;
                }
                ((EmoticonPanelController) this.mPanelController).getPanel().getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            float y16 = motionEvent.getY();
            int i3 = (int) ((y16 - this.mDowny) + 0.5f);
            if (!isShowExtendPanel() || this.mInteractionListener == null || Math.abs(i3) <= this.mInteractionListener.getPanelIconsBarHeight() * 0.6f) {
                return false;
            }
            this.mDowny = y16;
            QLog.d(LOG_TAG, 2, "interceptTouchEvent MOVE, mDownY=" + this.mDowny);
            return true;
        }
        this.mDowny = motionEvent.getY();
        QLog.d(LOG_TAG, 2, "interceptTouchEvent DOWN, mDownY=" + this.mDowny);
        this.mStartHeight = getCurPanelHeight();
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (int[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return new int[]{10, 9, 4, 5, 1, 3, 11, 12};
    }

    public boolean isExperiment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null && iPanelInteractionListener.isExperiment()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public boolean isPanelOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (getCurPanelHeight() == sMaxPanelHeight) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowExtendPanel() {
        if (this.mInteractionListener != null && !((EmoticonPanelController) this.mPanelController).getParams().kanDianBiu && this.mInteractionListener.isHostSafe()) {
            return true;
        }
        return false;
    }

    public boolean isToggleOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null && !iPanelInteractionListener.supportExtendPanel()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (isShowExtendPanel() || showEmotionDeleteButton()) {
            this.mInteractionListener.getEditText().addTextChangedListener(this.textWatcher);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (isShowExtendPanel() || showEmotionDeleteButton()) {
            this.mInteractionListener.getEditText().removeTextChangedListener(this.textWatcher);
            if (this.mOriginPanelHeight != sMaxPanelHeight && supportExtendPanel()) {
                setPanelHeight(0);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else if (isShowExtendPanel()) {
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onHide.");
            }
            this.mInteractionListener.setPaneliconsInterceptListener(null);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null && iPanelInteractionListener.getEditText() != null) {
            updateDeleteBtnVisibility(this.mInteractionListener.getEditText().getText().toString());
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullDown() {
        int curPanelHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (needExtendPanel() && (curPanelHeight = getCurPanelHeight()) == sMaxPanelHeight) {
            doPanelAnim(250, curPanelHeight, this.mOriginPanelHeight);
            reportPanelUpDown("0X800A847");
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onPullDown");
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullUp() {
        int curPanelHeight;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (needExtendPanel() && (curPanelHeight = getCurPanelHeight()) != (i3 = sMaxPanelHeight)) {
            doPanelAnim(150, curPanelHeight, i3);
            reportPanelUpDown("0X800A846");
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onPullUp");
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (isShowExtendPanel()) {
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onShow.");
            }
            initPanelExtendHeight();
            initMaxPanelHeight();
            this.mInteractionListener.setPaneliconsInterceptListener(this);
        }
    }

    public void refreshPanel(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent);
        } else {
            changeEmoticonPanel((int) (motionEvent.getY() + 0.5f), "refreshPanel");
        }
    }

    public boolean supportExtendPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null && !iPanelInteractionListener.supportExtendPanel()) {
            return false;
        }
        return true;
    }

    public void updateDeleteBtnVisibility(CharSequence charSequence) {
        int i3;
        ImageButton deleteButtonFromCache;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) charSequence);
            return;
        }
        EmotionPanelViewPagerAdapter pageAdapter = ((EmoticonPanelController) this.mPanelController).getPageAdapter();
        List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) this.mPanelController).getPanelDataList();
        if (pageAdapter != null && panelDataList != null && (i3 = BasePanelModel.sLastSelectedSecondTabIndex) >= 0 && i3 < panelDataList.size() && (deleteButtonFromCache = pageAdapter.getDeleteButtonFromCache(BasePanelModel.sLastSelectedSecondTabIndex)) != null) {
            if (TextUtils.isEmpty(charSequence)) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            deleteButtonFromCache.setVisibility(i16);
        }
    }
}
