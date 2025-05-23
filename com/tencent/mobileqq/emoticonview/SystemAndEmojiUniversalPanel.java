package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmojiConstants;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes12.dex */
public class SystemAndEmojiUniversalPanel extends RelativeLayout implements View.OnClickListener, IEmoticonPanel {
    static IPatchRedirector $redirector_ = null;
    private static final int PRELOAD_LINE_NUM = 5;
    private static final String TAG = "EmoticonUniversalPanel";
    private float density;
    private boolean ignoreUIToken;
    private IEmoticonMainPanelApp mApp;
    private EmoticonCallback mCallback;
    private ImageButton mDeleteButton;
    private ISystemAndEmojiPanelService.b mDispatchKeyEventListener;
    private EmotionPanelListView mEmotionPanelListView;
    private boolean mFilterSysFaceBeyond255Enable;
    private boolean mForeSplitLottieSticker;
    private EditText mInputEdit;
    private EmotionPanelInfo mPanelInfo;
    private boolean mShowDescribeInPreview;
    private SystemAndEmojiAdapter mSystemAndEmojiAdapter;
    private int mainPanelWidth;
    private boolean multiWindowMode;
    private int rowCount;
    private boolean showCommonUsedSystemEmoji;
    private TextWatcher textWatcher;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ int val$columnNum;
        final /* synthetic */ boolean val$iPC;

        AnonymousClass1(boolean z16, int i3) {
            this.val$iPC = z16;
            this.val$columnNum = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SystemAndEmojiUniversalPanel.this, Boolean.valueOf(z16), Integer.valueOf(i3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<EmotionPanelData> universalEmoticonListFromConfig;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.val$iPC) {
                universalEmoticonListFromConfig = SystemAndEmojiEmoticonInfo.getUniversalEmoticonListFromConfig(SystemAndEmojiUniversalPanel.this.mApp, this.val$columnNum, SystemAndEmojiUniversalPanel.this.showCommonUsedSystemEmoji, true, SystemAndEmojiUniversalPanel.this.mFilterSysFaceBeyond255Enable, SystemAndEmojiUniversalPanel.this.mForeSplitLottieSticker);
            } else {
                universalEmoticonListFromConfig = SystemAndEmojiEmoticonInfo.getUniversalEmoticonListFromConfig(this.val$columnNum, SystemAndEmojiUniversalPanel.this.showCommonUsedSystemEmoji, true, SystemAndEmojiUniversalPanel.this.mFilterSysFaceBeyond255Enable);
            }
            ThreadManager.getUIHandler().post(new Runnable(universalEmoticonListFromConfig) { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ List val$panelData;

                {
                    this.val$panelData = universalEmoticonListFromConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) universalEmoticonListFromConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SystemAndEmojiUniversalPanel.this.mEmotionPanelListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC75031.this);
                            }
                        }

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 3)) {
                                iPatchRedirector3.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                            }
                        }

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScrollStateChanged(AbsListView absListView, int i3) {
                            EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) absListView, i3);
                                return;
                            }
                            if (i3 != 0 && i3 != 2) {
                                URLDrawable.pause();
                                return;
                            }
                            URLDrawable.resume();
                            RunnableC75031 runnableC75031 = RunnableC75031.this;
                            SystemAndEmojiUniversalPanel systemAndEmojiUniversalPanel = SystemAndEmojiUniversalPanel.this;
                            systemAndEmojiUniversalPanel.preloadSystemEmotion(runnableC75031.val$panelData, systemAndEmojiUniversalPanel.mEmotionPanelListView);
                        }
                    });
                    if (this.val$panelData != null) {
                        SystemAndEmojiUniversalPanel.this.mSystemAndEmojiAdapter.setData(this.val$panelData);
                    }
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private boolean ignoreUIToken;
        private Context mContext;
        private ISystemAndEmojiPanelService.b mDispatchKeyEventListener;
        private EditText mEditText;
        private EmoticonCallback mEmoticonCallback;
        private boolean mFilterSysFaceBeyond255Enable;
        private boolean mForeSplitLottieSticker;
        private boolean mShowCommonUsedSystemEmoji;
        private boolean mShowDescribeInPreview;
        private int mainPanelWidth;
        private int rowCount;

        public Builder(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            this.mShowCommonUsedSystemEmoji = false;
            this.mFilterSysFaceBeyond255Enable = false;
            this.mShowDescribeInPreview = false;
            this.rowCount = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;
            this.ignoreUIToken = false;
            this.mForeSplitLottieSticker = false;
            this.mContext = context;
        }

        public SystemAndEmojiUniversalPanel create(IEmoticonMainPanelApp iEmoticonMainPanelApp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? create(iEmoticonMainPanelApp, false) : (SystemAndEmojiUniversalPanel) iPatchRedirector.redirect((short) 12, (Object) this, (Object) iEmoticonMainPanelApp);
        }

        public void into(SystemAndEmojiUniversalPanel systemAndEmojiUniversalPanel, IEmoticonMainPanelApp iEmoticonMainPanelApp, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, systemAndEmojiUniversalPanel, iEmoticonMainPanelApp, Boolean.valueOf(z16));
                return;
            }
            if (systemAndEmojiUniversalPanel == null) {
                return;
            }
            systemAndEmojiUniversalPanel.setEmoticonCallback(this.mEmoticonCallback);
            systemAndEmojiUniversalPanel.setDispatchKeyEventListener(this.mDispatchKeyEventListener);
            systemAndEmojiUniversalPanel.setShowDeleteButton(this.mEditText);
            systemAndEmojiUniversalPanel.setShowCommonUsedSystemEmoji(this.mShowCommonUsedSystemEmoji);
            systemAndEmojiUniversalPanel.setFilterSysFaceBeyond255Enable(this.mFilterSysFaceBeyond255Enable);
            systemAndEmojiUniversalPanel.setForeSplitLottieSticker(this.mForeSplitLottieSticker);
            systemAndEmojiUniversalPanel.setShowDescribeInPreview(this.mShowDescribeInPreview);
            systemAndEmojiUniversalPanel.setRowCount(this.rowCount);
            systemAndEmojiUniversalPanel.setMainPanelWidth(this.mainPanelWidth);
            systemAndEmojiUniversalPanel.setIgnoreUIToken(this.ignoreUIToken);
            systemAndEmojiUniversalPanel.init(iEmoticonMainPanelApp, z16);
        }

        public Builder setDispatchKeyEventListener(ISystemAndEmojiPanelService.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            }
            this.mDispatchKeyEventListener = bVar;
            return this;
        }

        public Builder setEmoticonCallback(EmoticonCallback emoticonCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonCallback);
            }
            this.mEmoticonCallback = emoticonCallback;
            return this;
        }

        public Builder setFilterSysFaceBeyond255Enable(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            this.mFilterSysFaceBeyond255Enable = z16;
            return this;
        }

        public Builder setForeSplitLottieSticker(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            this.mForeSplitLottieSticker = z16;
            return this;
        }

        public Builder setIgnoreUIToken(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, z16);
            }
            this.ignoreUIToken = z16;
            return this;
        }

        public Builder setMainPanelWidth(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.mainPanelWidth = i3;
            return this;
        }

        public Builder setRowCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.rowCount = i3;
            return this;
        }

        public Builder setShowCommonUsedSystemEmoji(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.mShowCommonUsedSystemEmoji = z16;
            return this;
        }

        public Builder setShowDeleteButton(EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) editText);
            }
            this.mEditText = editText;
            return this;
        }

        public Builder setShowDescribeInPreview(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.mShowDescribeInPreview = z16;
            return this;
        }

        public SystemAndEmojiUniversalPanel create(IEmoticonMainPanelApp iEmoticonMainPanelApp, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (SystemAndEmojiUniversalPanel) iPatchRedirector.redirect((short) 13, this, iEmoticonMainPanelApp, Boolean.valueOf(z16));
            }
            SystemAndEmojiUniversalPanel systemAndEmojiUniversalPanel = (SystemAndEmojiUniversalPanel) View.inflate(this.mContext, R.layout.hrn, null);
            into(systemAndEmojiUniversalPanel, iEmoticonMainPanelApp, z16);
            return systemAndEmojiUniversalPanel;
        }
    }

    public SystemAndEmojiUniversalPanel(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void asyncLoadData(int i3, boolean z16) {
        ThreadManagerV2.post(new AnonymousClass1(z16, i3), 5, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColumnNum() {
        int i3 = this.mPanelInfo.columnNum;
        if (this.multiWindowMode) {
            i3 = Math.max(1, (i3 * 4) / 7);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "multiWindowMode: " + this.mPanelInfo.columnNum + "->" + i3);
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastItemAddPaddingBottom() {
        if (!isShowDeleteButton()) {
            return 0;
        }
        if (this.mDeleteButton.getMeasuredHeight() == 0) {
            this.mDeleteButton.measure(0, 0);
        }
        return this.mDeleteButton.getMeasuredHeight();
    }

    private boolean isShowDeleteButton() {
        ImageButton imageButton = this.mDeleteButton;
        if (imageButton != null && imageButton.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDetachedFromWindow$0() {
        ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).saveSystemEmojiInfoToFile(this.mApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadSystemEmotion(List<EmotionPanelData> list, ListView listView) {
        URLDrawable uRLDrawable;
        URLDrawable uRLDrawable2;
        if (listView != null && list != null && list.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onScrollStateChanged preload systemEmotion");
            }
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            int i3 = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;
            int i16 = i3 * 5;
            int i17 = i3 * (lastVisiblePosition + 1);
            for (int i18 = i17; i18 < i17 + i16 && i18 < list.size(); i18++) {
                EmotionPanelData emotionPanelData = list.get(i18);
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                    if (systemAndEmojiEmoticonInfo.type != 3 && systemAndEmojiEmoticonInfo.code != -1) {
                        Drawable drawable = systemAndEmojiEmoticonInfo.getDrawable(false);
                        if ((drawable instanceof URLDrawable) && (uRLDrawable2 = (URLDrawable) drawable) != null && uRLDrawable2.getStatus() != 1) {
                            uRLDrawable2.startDownload();
                        }
                    }
                }
            }
            int i19 = (EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI * firstVisiblePosition) - 1;
            for (int i26 = i19; i26 >= 0 && i26 > i19 - i16 && i26 < list.size(); i26--) {
                EmotionPanelData emotionPanelData2 = list.get(i26);
                if (emotionPanelData2 instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo2 = (SystemAndEmojiEmoticonInfo) emotionPanelData2;
                    if (systemAndEmojiEmoticonInfo2.type != 3 && systemAndEmojiEmoticonInfo2.code != -1) {
                        Drawable drawable2 = systemAndEmojiEmoticonInfo2.getDrawable(getContext(), this.density);
                        if ((drawable2 instanceof URLDrawable) && (uRLDrawable = (URLDrawable) drawable2) != null && uRLDrawable.getStatus() != 1) {
                            uRLDrawable.startDownload();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMainPanelWidth(int i3) {
        this.mainPanelWidth = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowDescribeInPreview(boolean z16) {
        this.mShowDescribeInPreview = z16;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) keyEvent)).booleanValue();
        }
        ISystemAndEmojiPanelService.b bVar = this.mDispatchKeyEventListener;
        if (bVar != null && bVar.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public IEmoticonMainPanelApp getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (IEmoticonMainPanelApp) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mApp;
    }

    protected int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return R.layout.hrn;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanel
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this;
    }

    public void init(IEmoticonMainPanelApp iEmoticonMainPanelApp, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, iEmoticonMainPanelApp, Boolean.valueOf(z16));
            return;
        }
        setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_bg);
        this.density = getResources().getDisplayMetrics().density;
        this.mPanelInfo = new EmotionPanelInfo(7, this.rowCount, null);
        ImageButton imageButton = (ImageButton) findViewById(R.id.bfq);
        this.mDeleteButton = imageButton;
        if (this.mInputEdit != null) {
            imageButton.setVisibility(0);
            this.mDeleteButton.setEnabled(!TextUtils.isEmpty(this.mInputEdit.getText()));
        }
        if (QQTheme.isNowThemeIsNight()) {
            this.mDeleteButton.setBackgroundResource(R.drawable.j6_);
        } else {
            this.mDeleteButton.setBackgroundResource(R.drawable.f160110ho);
        }
        this.mDeleteButton.setOnClickListener(this);
        EmotionPanelListView emotionPanelListView = (EmotionPanelListView) findViewById(R.id.utm);
        this.mEmotionPanelListView = emotionPanelListView;
        emotionPanelListView.setDivider(null);
        this.mEmotionPanelListView.setSelector(R.drawable.loo);
        int columnNum = getColumnNum();
        SystemAndEmojiAdapter systemAndEmojiAdapter = new SystemAndEmojiAdapter(iEmoticonMainPanelApp, null, getContext(), columnNum, 1, this.mPanelInfo.type, this.mCallback, 0);
        this.mSystemAndEmojiAdapter = systemAndEmojiAdapter;
        systemAndEmojiAdapter.setLastItemAddPaddingBottom(getLastItemAddPaddingBottom());
        this.mSystemAndEmojiAdapter.setShowDescribeInPreview(this.mShowDescribeInPreview);
        this.mSystemAndEmojiAdapter.setWidthPixels(this.mainPanelWidth);
        SystemAndEmojiAdapter systemAndEmojiAdapter2 = this.mSystemAndEmojiAdapter;
        systemAndEmojiAdapter2.curPanelInfo = this.mPanelInfo;
        systemAndEmojiAdapter2.setCurrentListView(this.mEmotionPanelListView);
        SystemAndEmojiAdapter systemAndEmojiAdapter3 = this.mSystemAndEmojiAdapter;
        systemAndEmojiAdapter3.ignoreUIToken = this.ignoreUIToken;
        this.mEmotionPanelListView.setAdapter((ListAdapter) systemAndEmojiAdapter3);
        this.mApp = iEmoticonMainPanelApp;
        asyncLoadData(columnNum, z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        EditText editText = this.mInputEdit;
        if (editText != null) {
            editText.addTextChangedListener(this.textWatcher);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmoticonCallback emoticonCallback;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
        } else if (view.getId() == R.id.bfq && (emoticonCallback = this.mCallback) != null) {
            emoticonCallback.delete();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanel
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        EditText editText = this.mInputEdit;
        if (editText != null) {
            editText.removeTextChangedListener(this.textWatcher);
        }
        if (this.mApp != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ax
                @Override // java.lang.Runnable
                public final void run() {
                    SystemAndEmojiUniversalPanel.this.lambda$onDetachedFromWindow$0();
                }
            }, 64, null, false);
            this.mApp = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onInterceptTouchEvent failed", e16);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int measuredWidth = getMeasuredWidth();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i17 = this.mainPanelWidth;
        if (measuredWidth != i17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onMeasure: oldWidth=" + i17 + " newWidth=" + measuredWidth);
            }
            EmotionPanelViewPool.getInstance().destory();
            EmotionPanelViewPool.widthPixels = measuredWidth;
            if (measuredWidth / displayMetrics.widthPixels >= 0.66f) {
                z16 = false;
            }
            this.multiWindowMode = z16;
            this.mainPanelWidth = measuredWidth;
            if (this.mSystemAndEmojiAdapter != null && this.mDeleteButton != null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemAndEmojiUniversalPanel.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        SystemAndEmojiUniversalPanel.this.mDeleteButton.measure(0, 0);
                        SystemAndEmojiUniversalPanel.this.mSystemAndEmojiAdapter.setLastItemAddPaddingBottom(SystemAndEmojiUniversalPanel.this.getLastItemAddPaddingBottom());
                        SystemAndEmojiUniversalPanel.this.mSystemAndEmojiAdapter.columnNum = SystemAndEmojiUniversalPanel.this.getColumnNum();
                        SystemAndEmojiUniversalPanel.this.mSystemAndEmojiAdapter.setWidthPixels(SystemAndEmojiUniversalPanel.this.mainPanelWidth);
                        SystemAndEmojiUniversalPanel.this.mEmotionPanelListView.setAdapter((ListAdapter) SystemAndEmojiUniversalPanel.this.mSystemAndEmojiAdapter);
                    }
                });
            }
        }
    }

    public void setDispatchKeyEventListener(ISystemAndEmojiPanelService.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
        } else {
            this.mDispatchKeyEventListener = bVar;
        }
    }

    public void setEmoticonCallback(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonCallback);
        } else {
            this.mCallback = emoticonCallback;
        }
    }

    public void setFilterSysFaceBeyond255Enable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mFilterSysFaceBeyond255Enable = z16;
        }
    }

    public void setForeSplitLottieSticker(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mForeSplitLottieSticker = z16;
        }
    }

    public void setIgnoreUIToken(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.ignoreUIToken = z16;
        }
    }

    public void setRowCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.rowCount = i3;
        }
    }

    public void setShowCommonUsedSystemEmoji(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.showCommonUsedSystemEmoji = z16;
        }
    }

    public void setShowDeleteButton(EditText editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) editText);
        } else {
            this.mInputEdit = editText;
        }
    }

    public SystemAndEmojiUniversalPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SystemAndEmojiUniversalPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.showCommonUsedSystemEmoji = false;
        this.mFilterSysFaceBeyond255Enable = false;
        this.mShowDescribeInPreview = false;
        this.rowCount = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;
        this.mForeSplitLottieSticker = false;
        this.mApp = null;
        this.ignoreUIToken = false;
        this.textWatcher = new TextWatcher() { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemAndEmojiUniversalPanel.this);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) editable);
                } else if (SystemAndEmojiUniversalPanel.this.mDeleteButton != null) {
                    SystemAndEmojiUniversalPanel.this.mDeleteButton.setEnabled(!TextUtils.isEmpty(editable));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i16, int i17, int i18) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, charSequence, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i16, int i17, int i18) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, charSequence, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                }
            }
        };
    }
}
