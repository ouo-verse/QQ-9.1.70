package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;

/* loaded from: classes12.dex */
public class EmotionSearchPanel extends RelativeLayout implements View.OnClickListener, com.tencent.mobileqq.emosm.q {
    static IPatchRedirector $redirector_ = null;
    private static final int ENTER_EXIT_ANIM_DRAUTION = 200;
    static final float EXIT_ANIM_CRITICAL_SHOW_SEARHCONTAINER = 0.99f;
    private static final float MASK_MAX_ALPHA = 0.71f;
    public static final int STATE_EXIT = 3;
    public static final int STATE_INIT = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_SOFT_PANEL_SHOW = 2;
    private static final String TAG = "EmotionSearchPanel";
    public static int keyboardHeight;
    BaseQQAppInterface app;
    View decorView;
    TextView emotionCancelBtn;
    EditText emotionInput;
    RelativeLayout emotionInputAnimLayout;
    int emotionPanelState;
    RelativeLayout emotionSearchBar;
    PopupWindow emotionSearchPanelWindow;
    RelativeLayout emotionSearchRoot;
    int exitWidth;
    private int halfcCancelBtnWidth;
    boolean hasSetVisisble;
    boolean hasWord;
    EmoticonPanelHotPicSearchHelper helper;
    IPanelInteractionListener interactionListener;
    boolean isClearWord;
    boolean isDestory;
    private boolean isExitNeedSearch;
    boolean isVisiableForLast;
    FrameLayout mask;
    View maskBtmView;
    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    float screenWidth;
    ImageView searchCleanImg;
    private int searchRootStartBottomMargin;
    private int searchbarBottomMargin;
    private int upAndDownDistance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49545);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            keyboardHeight = 0;
        }
    }

    public EmotionSearchPanel(Context context) {
        super(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.halfcCancelBtnWidth = ScreenUtil.dip2px(60.0f) / 2;
        this.isExitNeedSearch = false;
        this.isVisiableForLast = false;
        this.isDestory = false;
        this.hasWord = false;
        this.isClearWord = false;
        this.hasSetVisisble = false;
        this.emotionPanelState = 0;
        this.onGlobalLayoutListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doExit() {
        setEmotionStatus(3);
        if (!this.isVisiableForLast) {
            startExitAinm();
        }
        hideSoftInput();
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
        if (emoticonMainPanel != null) {
            EmoticonPanelHotPicSearchHelper emoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6);
            if (this.isExitNeedSearch) {
                emoticonPanelHotPicSearchHelper.setSearchWords(this.emotionInput.getText().toString());
                emoticonPanelHotPicSearchHelper.setNeedPullUp(true);
            }
            emoticonPanelHotPicSearchHelper.setSearchContainerVisibility(4);
        }
        if (this.interactionListener != null) {
            ((IEmosmService) QRoute.api(IEmosmService.class)).showEmoticonPanel(this.interactionListener, 12);
        }
    }

    private int getBgColor() {
        return getContext().getResources().getColor(R.color.emoview_aio_emoji_bkg);
    }

    private int getEnterTextAnimStartPos() {
        return ((this.exitWidth / 2) - getHalfInputTextLen()) - ScreenUtil.dip2px(24.0f);
    }

    private int getExitTextAnimEndPos() {
        return (this.exitWidth / 2) - getHalfInputTextLen();
    }

    private int getHalfInputTextLen() {
        String obj = this.emotionInput.getText().toString();
        if (StringUtil.isEmpty(obj)) {
            obj = this.emotionInput.getHint().toString();
        }
        Rect rect = new Rect();
        this.emotionInput.getPaint().getTextBounds(obj, 0, obj.length(), rect);
        return rect.width() / 2;
    }

    private void hideSoftInput() {
        InputMethodManager inputMethodManager;
        if (getContext() != null && this.emotionInput != null && (inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.emotionInput.getWindowToken(), 0);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "hideSoftInput, ", this.emotionInput.getWindowToken());
            }
        }
    }

    private void initAnimStartParam(String str, int i3, int i16, int i17) {
        this.screenWidth = ScreenUtil.getRealWidth(getContext());
        this.hasSetVisisble = false;
        this.isExitNeedSearch = false;
        this.isDestory = false;
        if (!StringUtil.isEmpty(str)) {
            this.emotionInput.setText(str);
            this.emotionInput.setSelection(str.length());
            this.hasWord = true;
            this.searchCleanImg.setVisibility(0);
        } else {
            this.hasWord = false;
            this.searchCleanImg.setVisibility(8);
        }
        this.exitWidth = i16;
        if (i16 <= 0 || isNeedDoCenterMove(false)) {
            this.exitWidth = ((int) this.screenWidth) - this.halfcCancelBtnWidth;
        }
        if (!isNeedDoCenterMove(false)) {
            setSearchInputLeftMargin(0);
            setSearchInputRootWidth(this.exitWidth);
        }
        this.searchRootStartBottomMargin = i3 + ScreenUtil.dip2px(10.0f);
        if (keyboardHeight > 0) {
            EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
            if (emoticonMainPanel != null) {
                this.upAndDownDistance = keyboardHeight - ((EmoticonPanelExtendHelper) emoticonMainPanel.getEmoController().getHelper(1)).getOriginPanelHeight();
            }
        } else {
            this.upAndDownDistance = i17 - ScreenUtil.dip2px(12.0f);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init initAnimStartParam =" + this.upAndDownDistance + " exitWidth =" + this.exitWidth);
        }
    }

    private void initView() {
        this.emotionInput = (EditText) findViewById(R.id.uts);
        this.emotionCancelBtn = (TextView) findViewById(R.id.utr);
        this.emotionSearchRoot = (RelativeLayout) findViewById(R.id.utt);
        this.emotionSearchBar = (RelativeLayout) findViewById(R.id.utq);
        View findViewById = findViewById(R.id.yxu);
        this.maskBtmView = findViewById;
        findViewById.setBackgroundColor(getBgColor());
        this.emotionSearchBar.setBackgroundColor(getBgColor());
        this.emotionInputAnimLayout = (RelativeLayout) findViewById(R.id.utj);
        ImageView imageView = (ImageView) findViewById(R.id.y8q);
        this.searchCleanImg = imageView;
        imageView.setOnClickListener(this);
        this.mask = (FrameLayout) findViewById(R.id.enc);
        this.emotionCancelBtn.setOnClickListener(this);
        this.mask.setOnClickListener(this);
        this.decorView = ((Activity) getContext()).getWindow().getDecorView();
        this.emotionInput.setBackgroundColor(0);
        this.emotionInput.setCompoundDrawables(EmoticonPanelHotPicSearchHelper.getHotPicSearchInboxBoxIconDrawable(getContext()), null, null, null);
        this.emotionInputAnimLayout.setBackgroundDrawable(getShapeDrawable(EmoticonPanelHotPicSearchHelper.SEARCH_INPUT_BOX_RADIUS_PX));
        this.emotionInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this);
                }
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z17 = false;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
                } else {
                    if (i3 == 3) {
                        if (!StringUtil.isEmpty(EmotionSearchPanel.this.emotionInput.getText().toString())) {
                            EmotionSearchPanel emotionSearchPanel = EmotionSearchPanel.this;
                            ReportController.o(emotionSearchPanel.app, "dc00898", "", "", EmoticonOperateReport.REPORT_TAG_0X800AE28, EmoticonOperateReport.REPORT_TAG_0X800AE28, 0, 0, "2", "", emotionSearchPanel.emotionInput.getText().toString(), "");
                            EmotionSearchPanel.this.isExitNeedSearch = true;
                            EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(EmotionSearchPanel.this.interactionListener);
                            if (emoticonMainPanel != null) {
                                ((EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6)).prepareSearch();
                            }
                        }
                        EmotionSearchPanel.this.doExit();
                        z17 = true;
                    }
                    z16 = z17;
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return z16;
            }
        });
        this.emotionInput.addTextChangedListener(new TextWatcher() { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                } else if (!StringUtil.isEmpty(editable.toString())) {
                    EmotionSearchPanel.this.searchCleanImg.setVisibility(0);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                }
            }
        });
        IPanelInteractionListener iPanelInteractionListener = this.interactionListener;
        if (iPanelInteractionListener != null && iPanelInteractionListener.isCurGuildLiveChannel()) {
            this.emotionInput.setBackgroundDrawable(ViewUtils.getShapeDrawable(Color.parseColor("#2F3033"), ViewUtils.dip2px(18.0f)));
            this.emotionInput.setHintTextColor(Color.parseColor("#C1C1C1"));
            View view = this.maskBtmView;
            view.setBackgroundColor(view.getResources().getColor(R.color.bqf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedDoCenterMove(boolean z16) {
        if (z16) {
            if (this.hasWord || this.isExitNeedSearch) {
                return false;
            }
            return true;
        }
        if (this.hasWord || this.isClearWord) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExitAnimEnd() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onExitAnimEnd");
        }
        if (this.interactionListener != null) {
            ((IEmosmService) QRoute.api(IEmosmService.class)).setEmotionSearchPanelVisible(this.interactionListener, false, 0, false, null, 0);
        }
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
        if (emoticonMainPanel != null) {
            EmoticonPanelHotPicSearchHelper emoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6);
            if (this.isExitNeedSearch) {
                this.isExitNeedSearch = false;
                emoticonPanelHotPicSearchHelper.startSearch(this.emotionInput.getText().toString());
            }
        }
        this.emotionInput.setText("");
    }

    private void removeGlobalistener() {
        View view = this.decorView;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    private void reportCancel(int i3) {
        if (StringUtil.isEmpty(this.emotionInput.getText().toString())) {
            EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE27, i3);
        } else {
            EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE29, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchBarBottomMargin(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.emotionSearchBar.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, i3);
        this.emotionSearchBar.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchContainerVisiable(float f16) {
        if (f16 > EXIT_ANIM_CRITICAL_SHOW_SEARHCONTAINER && !this.hasSetVisisble) {
            this.hasSetVisisble = true;
            EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
            if (emoticonMainPanel != null) {
                ((EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6)).setSearchContainerVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchInputLeftMargin(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.emotionInput.getLayoutParams();
        layoutParams.leftMargin = i3;
        this.emotionInput.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchInputRootWidth(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.emotionInputAnimLayout.getLayoutParams();
        layoutParams.width = i3;
        this.emotionInputAnimLayout.setLayoutParams(layoutParams);
    }

    private void startEnterLeftReduceAnim() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        int enterTextAnimStartPos = getEnterTextAnimStartPos();
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(enterTextAnimStartPos) { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$startPos;

            {
                this.val$startPos = enterTextAnimStartPos;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this, enterTextAnimStartPos);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                EmotionSearchPanel emotionSearchPanel = EmotionSearchPanel.this;
                EmotionSearchPanel.this.setSearchInputRootWidth((int) (emotionSearchPanel.exitWidth - (emotionSearchPanel.halfcCancelBtnWidth * floatValue)));
                EmotionSearchPanel.this.setSearchInputLeftMargin((int) (this.val$startPos * (1.0f - floatValue)));
            }
        });
        setSearchInputLeftMargin(enterTextAnimStartPos);
        ofFloat.start();
    }

    private void startExitRightIncreaseAnim() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        int width = this.emotionInput.getWidth();
        int dip2px = ScreenUtil.dip2px(27.0f);
        int i3 = this.exitWidth - width;
        int exitTextAnimEndPos = getExitTextAnimEndPos() - dip2px;
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(width, i3, exitTextAnimEndPos) { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$endPos;
            final /* synthetic */ int val$rightMoveDis;
            final /* synthetic */ int val$searchinputWidth;

            {
                this.val$searchinputWidth = width;
                this.val$rightMoveDis = i3;
                this.val$endPos = exitTextAnimEndPos;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, EmotionSearchPanel.this, Integer.valueOf(width), Integer.valueOf(i3), Integer.valueOf(exitTextAnimEndPos));
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                EmotionSearchPanel.this.setSearchInputRootWidth((int) (this.val$searchinputWidth + (this.val$rightMoveDis * floatValue)));
                EmotionSearchPanel.this.setSearchInputLeftMargin((int) (this.val$endPos * floatValue));
                EmotionSearchPanel.this.setSearchContainerVisiable(floatValue);
            }
        });
        ofFloat.addListener(new com.tencent.mobileqq.widget.f() { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    EmotionSearchPanel.this.onExitAnimEnd();
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                }
            }
        });
        ofFloat.start();
    }

    public void addOnSoftKeyBoardVisibleListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this);
                    }
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (EmotionSearchPanel.this.isDestory) {
                        return;
                    }
                    Rect rect = new Rect();
                    EmotionSearchPanel.this.decorView.getWindowVisibleDisplayFrame(rect);
                    int i3 = rect.bottom - rect.top;
                    int height = EmotionSearchPanel.this.decorView.getHeight();
                    if (i3 / height < 0.8d) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(EmotionSearchPanel.TAG, 2, NodeProps.VISIBLE + z16 + " isVisiableForLast=" + EmotionSearchPanel.this.isVisiableForLast + " displayHight=" + i3 + " hight=" + height);
                    }
                    EmotionSearchPanel emotionSearchPanel = EmotionSearchPanel.this;
                    if (z16 != emotionSearchPanel.isVisiableForLast) {
                        if (z16) {
                            EmotionSearchPanel.keyboardHeight = height - rect.bottom;
                            if (QLog.isColorLevel()) {
                                QLog.d(EmotionSearchPanel.TAG, 2, "keyboardHeight=" + EmotionSearchPanel.keyboardHeight);
                            }
                            EmotionSearchPanel.this.setSearchBarBottomMargin(EmotionSearchPanel.keyboardHeight);
                            EmotionSearchPanel.this.setEmotionStatus(2);
                            EmotionSearchPanel.this.mask.setAlpha(EmotionSearchPanel.MASK_MAX_ALPHA);
                        } else {
                            if (emotionSearchPanel.emotionPanelState == 2 && emotionSearchPanel.interactionListener != null) {
                                ((IEmosmService) QRoute.api(IEmosmService.class)).showEmoticonPanel(EmotionSearchPanel.this.interactionListener, 12);
                            }
                            EmotionSearchPanel.this.startExitAinm();
                            if (!StringUtil.isEmpty(EmotionSearchPanel.this.emotionInput.getText().toString())) {
                                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE25, 0);
                            }
                        }
                        EmotionSearchPanel.this.isVisiableForLast = z16;
                    }
                }
            };
            this.decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setEmotionStatus,dispatchKeyEvent code=", Integer.valueOf(keyEvent.getKeyCode()));
        }
        if (keyEvent.getKeyCode() == 4) {
            doExit();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void dissmissEmotionSearchWinow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        PopupWindow popupWindow = this.emotionSearchPanelWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    protected Drawable getShapeDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return ViewUtils.getShapeDrawable(getContext().getColor(R.color.qui_common_fill_standard_primary), i3);
    }

    @Override // com.tencent.mobileqq.emosm.q
    public void init(BaseQQAppInterface baseQQAppInterface, IPanelInteractionListener iPanelInteractionListener, int i3, boolean z16, String str, int i16, int i17, com.tencent.mobileqq.emosm.p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, iPanelInteractionListener, Integer.valueOf(i3), Boolean.valueOf(z16), str, Integer.valueOf(i16), Integer.valueOf(i17), pVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init start searchRootStartBottomMargin=" + this.searchRootStartBottomMargin + " upDis=" + i16 + " width=" + i17 + " hasWord=" + this.hasWord + " keyboardHeight= " + keyboardHeight + " startBottom is " + i3 + " upDis is " + i16);
        }
        setEmotionStatus(1);
        this.interactionListener = iPanelInteractionListener;
        this.app = baseQQAppInterface;
        this.isClearWord = z16;
        initView();
        if (z16) {
            str = "";
            this.emotionInput.setText("");
        }
        initAnimStartParam(str, i3, i17, i16);
        this.helper = (EmoticonPanelHotPicSearchHelper) pVar;
        startEntryAinm();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.utr) {
                reportCancel(1);
                this.isExitNeedSearch = false;
                doExit();
            } else if (id5 == R.id.enc) {
                reportCancel(2);
                this.isExitNeedSearch = false;
                doExit();
            } else if (id5 == R.id.y8q) {
                this.emotionInput.setText("");
                this.searchCleanImg.setVisibility(8);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emosm.q
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.isDestory = true;
        removeGlobalistener();
        dissmissEmotionSearchWinow();
        setEmotionStatus(0);
    }

    void setEmotionStatus(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setEmotionStatus,status ", Integer.valueOf(i3));
        }
        this.emotionPanelState = i3;
    }

    @Override // com.tencent.mobileqq.emosm.q
    public void showEmotionSearchWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.emotionSearchPanelWindow == null) {
            this.emotionSearchPanelWindow = new PopupWindow(this, -1, -1);
        }
        this.emotionSearchPanelWindow.setFocusable(true);
        this.emotionSearchPanelWindow.setSoftInputMode(16);
        try {
            this.emotionSearchPanelWindow.setAttachedInDecor(false);
            this.emotionSearchPanelWindow.setClippingEnabled(false);
            this.emotionSearchPanelWindow.showAtLocation(this, 0, 0, 0);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showEmotionSearchWindow,height ", Integer.valueOf(this.emotionSearchPanelWindow.getHeight()));
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5, new Object[0]);
            }
        }
    }

    public void startEntryAinm() {
        int i3;
        int q16;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startEntryAinm =" + this.upAndDownDistance);
        }
        if (this.emotionSearchBar.getMeasuredHeight() == 0) {
            this.emotionSearchBar.measure(0, 0);
        }
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
        if (emoticonMainPanel == null) {
            return;
        }
        int measuredHeight = this.emotionSearchBar.getMeasuredHeight();
        EmoticonPanelExtendHelper emoticonPanelExtendHelper = (EmoticonPanelExtendHelper) emoticonMainPanel.getEmoController().getHelper(1);
        boolean isToggleOn = emoticonPanelExtendHelper.isToggleOn();
        if (this.interactionListener.isScaleChat()) {
            q16 = keyboardHeight;
            if (q16 > 0) {
                i16 = this.searchRootStartBottomMargin;
                i3 = q16 - i16;
            }
            i3 = 0;
        } else if (emoticonPanelExtendHelper.isPanelOpen()) {
            int i18 = keyboardHeight;
            if (i18 > 0 && Math.abs(i18 - emoticonPanelExtendHelper.getOriginPanelHeight()) > 1) {
                i17 = 0;
            } else {
                i17 = keyboardHeight;
            }
            i3 = (-emoticonPanelExtendHelper.getMaxHeightSubNormalHeight(i17)) + measuredHeight;
        } else if (isToggleOn) {
            if (XPanelContainer.q() > 0) {
                q16 = XPanelContainer.q();
                i16 = this.searchRootStartBottomMargin;
                i3 = q16 - i16;
            }
            i3 = 0;
        } else if (keyboardHeight <= 0) {
            i3 = this.upAndDownDistance;
        } else {
            int dip2px = measuredHeight + ScreenUtil.dip2px(3.5f);
            if (emoticonPanelExtendHelper.isExperiment()) {
                i3 = (int) (dip2px + getContext().getResources().getDimension(R.dimen.f158749nw));
            } else {
                i3 = dip2px;
            }
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) valueAnimator);
                    return;
                }
                EmotionSearchPanel emotionSearchPanel = EmotionSearchPanel.this;
                emotionSearchPanel.searchbarBottomMargin = emotionSearchPanel.searchRootStartBottomMargin + ((Integer) valueAnimator.getAnimatedValue()).intValue();
                EmotionSearchPanel emotionSearchPanel2 = EmotionSearchPanel.this;
                emotionSearchPanel2.setSearchBarBottomMargin(emotionSearchPanel2.searchbarBottomMargin);
                EmotionSearchPanel.this.mask.setAlpha(valueAnimator.getAnimatedFraction() * EmotionSearchPanel.MASK_MAX_ALPHA);
            }
        });
        ofInt.addListener(new com.tencent.mobileqq.widget.f() { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmotionSearchPanel.TAG, 2, "upAndDownAnim onAnimationEnd=");
                }
                com.tencent.mobileqq.EmotionUtils.e(EmotionSearchPanel.this.emotionInput);
                EmotionSearchPanel.this.addOnSoftKeyBoardVisibleListener();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmotionSearchPanel.TAG, 2, "upAndDownAnim start animStartBottom=" + EmotionSearchPanel.this.searchRootStartBottomMargin);
                }
                EmotionSearchPanel emotionSearchPanel = EmotionSearchPanel.this;
                emotionSearchPanel.setSearchBarBottomMargin(emotionSearchPanel.searchRootStartBottomMargin);
                EmoticonMainPanel emoticonMainPanel2 = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(EmotionSearchPanel.this.interactionListener);
                if (emoticonMainPanel2 != null) {
                    ((EmoticonPanelHotPicSearchHelper) emoticonMainPanel2.getEmoController().getHelper(6)).setSearchContainerVisibility(4);
                }
            }
        });
        ofInt.start();
        if (isNeedDoCenterMove(false)) {
            startEnterLeftReduceAnim();
        }
    }

    public void startExitAinm() {
        int i3;
        float f16;
        float dimension;
        int originPanelHeight;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
        if (emoticonMainPanel == null) {
            return;
        }
        EmoticonPanelExtendHelper emoticonPanelExtendHelper = (EmoticonPanelExtendHelper) emoticonMainPanel.getEmoController().getHelper(1);
        int measuredHeight = this.emotionSearchBar.getMeasuredHeight();
        boolean isToggleOn = emoticonPanelExtendHelper.isToggleOn();
        if (this.isExitNeedSearch) {
            if (!isToggleOn && !this.interactionListener.isScaleChat()) {
                int i17 = keyboardHeight;
                if (i17 > 0 && Math.abs(i17 - emoticonPanelExtendHelper.getOriginPanelHeight()) > 1) {
                    i16 = 0;
                } else {
                    i16 = keyboardHeight;
                }
                originPanelHeight = emoticonPanelExtendHelper.getMaxHeightSubNormalHeight(i16);
            } else {
                originPanelHeight = emoticonPanelExtendHelper.getOriginPanelHeight() - measuredHeight;
                measuredHeight = keyboardHeight;
            }
            i3 = originPanelHeight - measuredHeight;
        } else if (!isToggleOn && !this.interactionListener.isScaleChat()) {
            if (keyboardHeight <= 0) {
                i3 = emoticonPanelExtendHelper.getOriginPanelHeight() + measuredHeight;
            } else {
                int dip2px = measuredHeight + ScreenUtil.dip2px(3.5f);
                if (emoticonPanelExtendHelper.isExperiment()) {
                    f16 = dip2px;
                    dimension = getContext().getResources().getDimension(R.dimen.f158749nw);
                    i3 = (int) (f16 + dimension);
                } else {
                    i3 = dip2px;
                }
            }
        } else {
            i3 = this.searchbarBottomMargin - this.searchRootStartBottomMargin;
            if (emoticonMainPanel.isTabVisible() && this.isClearWord) {
                f16 = i3;
                dimension = getContext().getResources().getDimension(R.dimen.f158749nw);
                i3 = (int) (f16 + dimension);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startExitAinm isExitNeedSearch =" + this.isExitNeedSearch + " upDis=" + i3 + " upAndDownDistance=" + this.upAndDownDistance);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(isToggleOn) { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.8
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$toggleOn;

            {
                this.val$toggleOn = isToggleOn;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, EmotionSearchPanel.this, Boolean.valueOf(isToggleOn));
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i18;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) valueAnimator);
                    return;
                }
                if (this.val$toggleOn) {
                    i18 = EmotionSearchPanel.this.searchbarBottomMargin;
                } else {
                    i18 = EmotionSearchPanel.keyboardHeight;
                }
                if (EmotionSearchPanel.this.isExitNeedSearch) {
                    EmotionSearchPanel.this.setSearchBarBottomMargin(i18 + ((Integer) valueAnimator.getAnimatedValue()).intValue());
                } else {
                    EmotionSearchPanel.this.setSearchBarBottomMargin(i18 - ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
                EmotionSearchPanel.this.mask.setAlpha((1.0f - valueAnimator.getAnimatedFraction()) * EmotionSearchPanel.MASK_MAX_ALPHA);
            }
        });
        ofInt.addListener(new com.tencent.mobileqq.widget.f() { // from class: com.tencent.mobileqq.emoticonview.EmotionSearchPanel.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionSearchPanel.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                } else if (!EmotionSearchPanel.this.isNeedDoCenterMove(true)) {
                    EmotionSearchPanel.this.setSearchContainerVisiable(1.0f);
                    EmotionSearchPanel.this.onExitAnimEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                }
            }
        });
        ofInt.start();
        if (this.upAndDownDistance < 0) {
            ((EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6)).setSearchContainerVisibility(4);
        }
        if (isNeedDoCenterMove(true)) {
            startExitRightIncreaseAnim();
        }
    }

    public EmotionSearchPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.halfcCancelBtnWidth = ScreenUtil.dip2px(60.0f) / 2;
        this.isExitNeedSearch = false;
        this.isVisiableForLast = false;
        this.isDestory = false;
        this.hasWord = false;
        this.isClearWord = false;
        this.hasSetVisisble = false;
        this.emotionPanelState = 0;
        this.onGlobalLayoutListener = null;
    }

    public EmotionSearchPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.halfcCancelBtnWidth = ScreenUtil.dip2px(60.0f) / 2;
        this.isExitNeedSearch = false;
        this.isVisiableForLast = false;
        this.isDestory = false;
        this.hasWord = false;
        this.isClearWord = false;
        this.hasSetVisisble = false;
        this.emotionPanelState = 0;
        this.onGlobalLayoutListener = null;
    }
}
