package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.emoticonview.api.IPanelPopupApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    static final String LOG_TAG = "EmoticonLinearLayout";
    private static Rect tmp;
    EmoticonCallback callback;
    Context context;
    public int emoticonTextColor;
    private boolean hasAttachedToWindow;
    EmoticonAdapter mAdapter;
    Runnable mDelete;
    boolean mHasPerformedLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    View mPointView;
    DataObserver observer;
    private IPanelDependListener panelDependListener;
    public int panelViewType;
    List<RelativeLayout> viewCache;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class CheckForLongPress implements Runnable {
        static IPatchRedirector $redirector_;
        private int mOriginalWindowAttachCount;

        CheckForLongPress() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonLinearLayout.this);
            }
        }

        public void rememberWindowAttachCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.mOriginalWindowAttachCount = EmoticonLinearLayout.this.getWindowAttachCount();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            EmoticonInfo emoticonInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (EmoticonLinearLayout.this.getParent() != null && this.mOriginalWindowAttachCount == EmoticonLinearLayout.this.getWindowAttachCount() && (view = EmoticonLinearLayout.this.mPointView) != null && (emoticonInfo = (EmoticonInfo) view.getTag()) != null) {
                EmoticonCallback emoticonCallback = EmoticonLinearLayout.this.callback;
                if (emoticonCallback != null && emoticonCallback.onLongClick(emoticonInfo)) {
                    EmoticonLinearLayout.this.mPointView = null;
                    return;
                }
                EmoticonLinearLayout emoticonLinearLayout = EmoticonLinearLayout.this;
                emoticonLinearLayout.mHasPerformedLongPress = true;
                emoticonLinearLayout.getParent().requestDisallowInterceptTouchEvent(true);
                EmoticonLinearLayout.this.sendAccessibilityEvent(2);
                if ("delete".equals(emoticonInfo.action)) {
                    EmoticonLinearLayout.this.mDelete.run();
                } else if (!"setting".equals(emoticonInfo.action) && !"add".equals(emoticonInfo.action)) {
                    EmoticonLinearLayout emoticonLinearLayout2 = EmoticonLinearLayout.this;
                    emoticonLinearLayout2.showPopupEmo(emoticonLinearLayout2.mPointView, emoticonInfo);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface DataObserver {
        void onDataChanged();

        void onStructChanged(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class EmoticonAdapter {
        static IPatchRedirector $redirector_ = null;
        public static final String RED_TEXT_INIT = "init";
        EmoticonInfo addEmotion;
        int columnNum;
        boolean deleteIconExists;
        EmoticonInfo favEditEmotion;
        EmoticonInfo funnyPicEmotion;
        boolean hasDeleteBtn;
        boolean hasFavEditButton;
        boolean hasFunnyPicButton;
        boolean hasPlusButton;
        boolean hasPushButton;
        boolean hasSettingButton;
        boolean hasUpdatePage;
        List<EmoticonInfo> list;
        DataObserver mObserver;
        int page;
        int pageTotalNum;
        EmoticonInfo pushEmotion;
        public String redString;
        int rowNum;
        EmoticonInfo settingEmotion;
        EmoticonInfo specEmoticon;

        public EmoticonAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                this.redString = "init";
            }
        }

        public abstract void bindView(int i3, RelativeLayout relativeLayout, ViewGroup viewGroup);

        public int getColumnNum() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
            }
            return this.columnNum;
        }

        public EmoticonInfo getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (EmoticonInfo) iPatchRedirector.redirect((short) 28, (Object) this, i3);
            }
            int realIndex = getRealIndex(i3);
            if (realIndex == -1) {
                return this.specEmoticon;
            }
            if (realIndex == -2) {
                return this.addEmotion;
            }
            if (realIndex == -3) {
                return this.settingEmotion;
            }
            if (realIndex == -4) {
                return this.pushEmotion;
            }
            if (realIndex == -5) {
                return this.favEditEmotion;
            }
            if (realIndex == -6) {
                return this.funnyPicEmotion;
            }
            List<EmoticonInfo> list = this.list;
            if (list != null && realIndex < list.size()) {
                return this.list.get(realIndex);
            }
            return null;
        }

        public List<EmoticonInfo> getList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (List) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            return this.list;
        }

        public int getPage() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
            }
            return this.page;
        }

        public int getRealIndex(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, i3)).intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d(EmoticonLinearLayout.LOG_TAG, 2, "getRealIndex, position:" + i3 + ",pageTotalNum:" + this.pageTotalNum + ",page:" + this.page);
            }
            if (this.hasDeleteBtn) {
                int i16 = this.pageTotalNum;
                if ((i3 + 1) % i16 == 0) {
                    return -1;
                }
                return i3 + (this.page * (i16 - 1));
            }
            if (this.hasFavEditButton) {
                if (i3 == 0 && this.page == 0) {
                    return -5;
                }
                boolean z16 = this.hasFunnyPicButton;
                if (i3 == 1 && this.page == 0 && z16) {
                    return -6;
                }
                int i17 = this.page;
                if (i17 == 0) {
                    return (i3 - 1) - (z16 ? 1 : 0);
                }
                int i18 = this.pageTotalNum;
                return (((i18 - 1) + ((i17 - 1) * i18)) + i3) - (z16 ? 1 : 0);
            }
            int size = this.list.size() - 1;
            boolean z17 = this.hasPushButton;
            int i19 = size + (z17 ? 1 : 0);
            boolean z18 = this.hasPlusButton;
            int i26 = i19 + (z18 ? 1 : 0);
            int i27 = this.page;
            if (i3 + i27 == 0) {
                if (z17) {
                    return -4;
                }
                if (this.list.size() == 0 && this.hasPlusButton) {
                    return -2;
                }
                return 0;
            }
            int i28 = this.pageTotalNum;
            if ((i27 * i28) + i3 == i26) {
                if (z18) {
                    return -2;
                }
                return this.list.size() - 1;
            }
            if (z17) {
                return (i3 + (i27 * i28)) - 1;
            }
            return i3 + (i27 * i28);
        }

        public int getRowNum() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
            }
            return this.rowNum;
        }

        public EmoticonInfo getSpecEmoticon() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (EmoticonInfo) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.specEmoticon;
        }

        public boolean isHasDeleteBtn() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return this.hasDeleteBtn;
        }

        public boolean isHasPlusButton() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return this.hasPlusButton;
        }

        public boolean isSettingButton() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return this.hasSettingButton;
        }

        public void notifyDataChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this);
                return;
            }
            DataObserver dataObserver = this.mObserver;
            if (dataObserver != null) {
                dataObserver.onDataChanged();
            }
        }

        public void setAddEmoticon(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonInfo);
            } else {
                this.addEmotion = emoticonInfo;
            }
        }

        void setDataSetObserver(DataObserver dataObserver) {
            this.mObserver = dataObserver;
        }

        public void setFavEditEmoticon(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonInfo);
            } else {
                this.favEditEmotion = emoticonInfo;
            }
        }

        public void setFunnyPicButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, z16);
            } else {
                this.hasFunnyPicButton = z16;
            }
        }

        public void setFunnyPicEmoticon(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonInfo);
            } else {
                this.funnyPicEmotion = emoticonInfo;
            }
        }

        public void setHasDeleteBtn(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else {
                this.hasDeleteBtn = z16;
            }
        }

        public void setHasFavEditButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, z16);
            } else {
                this.hasFavEditButton = z16;
            }
        }

        public void setHasPlusButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, z16);
            } else {
                this.hasPlusButton = z16;
            }
        }

        public void setHasPushButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, z16);
            } else {
                this.hasPushButton = z16;
            }
        }

        public void setHasSettingButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, z16);
            } else {
                this.hasSettingButton = z16;
            }
        }

        public void setHasUpdatePage(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                this.hasUpdatePage = z16;
            }
        }

        public void setList(List<EmoticonInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) list);
            } else {
                this.list = list;
            }
        }

        public void setPage(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, i3);
            } else {
                this.page = i3;
            }
        }

        public void setPushEmoticon(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonInfo);
            } else {
                this.pushEmotion = emoticonInfo;
            }
        }

        public void setRowColumnNum(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.rowNum = i3;
            this.columnNum = i16;
            this.pageTotalNum = i16 * i3;
            this.mObserver.onStructChanged(i3, i16);
        }

        public void setSettingEmoticon(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonInfo);
            } else {
                this.settingEmotion = emoticonInfo;
            }
        }

        public void setSpecEmoticon(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonInfo);
            } else {
                this.specEmoticon = emoticonInfo;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34622);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            tmp = new Rect();
        }
    }

    public EmoticonLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.panelViewType = 6;
        this.viewCache = new ArrayList();
        this.observer = new DataObserver() { // from class: com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.1
            static IPatchRedirector $redirector_;
            private int column;
            private int row;
            private boolean viewInited;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonLinearLayout.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.DataObserver
            public void onDataChanged() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                int columnNum = EmoticonLinearLayout.this.mAdapter.getColumnNum();
                int rowNum = EmoticonLinearLayout.this.mAdapter.getRowNum();
                int i3 = 0;
                for (int i16 = 0; i16 < rowNum; i16++) {
                    for (int i17 = 0; i17 < columnNum; i17++) {
                        if (EmoticonLinearLayout.this.viewCache.size() <= i3) {
                            return;
                        }
                        RelativeLayout relativeLayout = EmoticonLinearLayout.this.viewCache.get(i3);
                        EmoticonLinearLayout emoticonLinearLayout = EmoticonLinearLayout.this;
                        emoticonLinearLayout.mAdapter.bindView(i3, relativeLayout, emoticonLinearLayout);
                        i3++;
                    }
                }
                EmoticonLinearLayout.this.requestLayout();
                if (QLog.isColorLevel()) {
                    QLog.d(EmoticonLinearLayout.LOG_TAG, 2, "[Performance] EmoticonLinearLayout onDataChanged, bindView duration: " + (System.currentTimeMillis() - currentTimeMillis) + ", type=" + EmoticonLinearLayout.this.panelViewType);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.DataObserver
            public void onStructChanged(int i3, int i16) {
                int i17;
                RelativeLayout relativeLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z16 = true;
                int i18 = 0;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (this.row == i3 && this.column == i16 && this.viewInited) {
                    return;
                }
                this.row = i3;
                this.column = i16;
                long currentTimeMillis = System.currentTimeMillis();
                EmoticonLinearLayout.this.removeAllViews();
                int addedHeight = ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).getAddedHeight();
                if (addedHeight > 0) {
                    i17 = addedHeight / 3;
                } else {
                    i17 = 0;
                }
                if (i17 > 60) {
                    i17 = 60;
                }
                EmoticonLinearLayout.this.setPadding(0, i17, 0, i17);
                int i19 = 0;
                int i26 = 0;
                while (i19 < this.row) {
                    LinearLayout linearLayout = new LinearLayout(EmoticonLinearLayout.this.context);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    float f16 = 1.0f;
                    layoutParams.weight = 1.0f;
                    linearLayout.setOrientation(i18);
                    linearLayout.setPadding(i18, i18, i18, i18);
                    int i27 = i18;
                    while (i27 < this.column) {
                        System.currentTimeMillis();
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                        layoutParams2.weight = f16;
                        if (i26 < EmoticonLinearLayout.this.viewCache.size()) {
                            relativeLayout = EmoticonLinearLayout.this.viewCache.get(i26);
                        } else {
                            relativeLayout = null;
                        }
                        if (relativeLayout == null) {
                            relativeLayout = new RelativeLayout(EmoticonLinearLayout.this.context);
                            URLImageView uRLImageView = new URLImageView(EmoticonLinearLayout.this.context);
                            uRLImageView.setId(R.id.f915355f);
                            if (EmoticonLinearLayout.this.panelViewType != 2007) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(EmoticonLinearLayout.LOG_TAG, 2, "Should not reach here, check your code!!!");
                                }
                                i18 = 0;
                            } else {
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams3.addRule(13, -1);
                                uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                i18 = 0;
                                uRLImageView.setAdjustViewBounds(false);
                                relativeLayout.addView(uRLImageView, layoutParams3);
                            }
                            EmoticonLinearLayout.this.viewCache.add(relativeLayout);
                        } else {
                            ViewGroup viewGroup = (ViewGroup) relativeLayout.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeAllViews();
                            }
                        }
                        linearLayout.addView(relativeLayout, layoutParams2);
                        i26++;
                        i27++;
                        f16 = 1.0f;
                    }
                    EmoticonLinearLayout.this.addView(linearLayout, layoutParams);
                    i19++;
                    z16 = true;
                }
                this.viewInited = z16;
                if (QLog.isColorLevel()) {
                    QLog.d(EmoticonLinearLayout.LOG_TAG, 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - currentTimeMillis) + ", type=" + EmoticonLinearLayout.this.panelViewType);
                }
            }
        };
        this.mDelete = new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonLinearLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                EmoticonCallback emoticonCallback = EmoticonLinearLayout.this.callback;
                if (emoticonCallback != null) {
                    emoticonCallback.delete();
                    EmoticonLinearLayout.this.postDelayed(this, 100L);
                }
            }
        };
        this.context = context;
        this.emoticonTextColor = super.getResources().getColor(R.color.ctf);
        setOrientation(1);
        super.setClickable(true);
        super.setLongClickable(true);
        this.panelDependListener = ((IPanelPopupApi) QRoute.api(IPanelPopupApi.class)).createPanelDependListener();
    }

    private View findPointChild(float f16, float f17) {
        for (int childCount = super.getChildCount() - 1; childCount >= 0; childCount--) {
            LinearLayout linearLayout = (LinearLayout) super.getChildAt(childCount);
            float scrollX = (super.getScrollX() + f16) - linearLayout.getLeft();
            float scrollY = (super.getScrollY() + f17) - linearLayout.getTop();
            if (scrollX >= 0.0f && scrollX <= linearLayout.getWidth() && scrollY >= 0.0f && scrollY < linearLayout.getHeight()) {
                for (int childCount2 = linearLayout.getChildCount() - 1; childCount2 >= 0; childCount2--) {
                    View childAt = linearLayout.getChildAt(childCount2);
                    float scrollX2 = (linearLayout.getScrollX() + scrollX) - childAt.getLeft();
                    float scrollY2 = (linearLayout.getScrollY() + scrollY) - childAt.getTop();
                    if (scrollX2 >= 0.0f && scrollX2 <= childAt.getWidth() && scrollY2 >= 0.0f && scrollY2 < childAt.getHeight()) {
                        return childAt;
                    }
                }
            }
        }
        return null;
    }

    private boolean getChildRect(View view, Rect rect) {
        if (view == null) {
            return false;
        }
        view.getDrawingRect(rect);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        rect.offset(view.getLeft() - viewGroup.getScrollX(), view.getTop() - viewGroup.getScrollY());
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
        rect.offset(viewGroup.getLeft() - viewGroup2.getScrollX(), viewGroup.getTop() - viewGroup2.getScrollY());
        return true;
    }

    private void performClick(View view) {
        EmoticonInfo emoticonInfo;
        if (view != null && (view.getTag() instanceof EmoticonInfo) && (emoticonInfo = (EmoticonInfo) view.getTag()) != null) {
            super.sendAccessibilityEvent(1);
            super.playSoundEffect(0);
            this.callback.send(emoticonInfo);
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.viewCache.clear();
        }
    }

    public EmoticonAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EmoticonAdapter) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mAdapter;
    }

    public void hidePopupWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IPanelDependListener iPanelDependListener = this.panelDependListener;
        if (iPanelDependListener != null) {
            iPanelDependListener.hidePopupWindow(getContext(), this.callback);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.hasAttachedToWindow = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.hasAttachedToWindow = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CheckForLongPress checkForLongPress;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        setPressed(false);
                        CheckForLongPress checkForLongPress2 = this.mPendingCheckForLongPress;
                        if (checkForLongPress2 != null) {
                            removeCallbacks(checkForLongPress2);
                        }
                        removeCallbacks(this.mDelete);
                        hidePopupWindow();
                        this.mPointView = null;
                    }
                } else if (this.mHasPerformedLongPress && (!getChildRect(this.mPointView, tmp) || !tmp.contains((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                    View findPointChild = findPointChild(motionEvent.getX(), motionEvent.getY());
                    this.mPointView = findPointChild;
                    if (findPointChild != null && findPointChild.getTag() != null) {
                        EmoticonInfo emoticonInfo = (EmoticonInfo) this.mPointView.getTag();
                        if (emoticonInfo != null && !"delete".equals(emoticonInfo.action) && !"add".equals(emoticonInfo.action) && !"setting".equals(emoticonInfo.action)) {
                            View view2 = this.mPointView;
                            showPopupEmo(view2, (EmoticonInfo) view2.getTag());
                        }
                    } else {
                        hidePopupWindow();
                    }
                } else if (!this.mHasPerformedLongPress && (view = this.mPointView) != null && (!getChildRect(view, tmp) || !tmp.contains((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                    this.mPointView = null;
                }
            } else {
                if (!this.mHasPerformedLongPress && (checkForLongPress = this.mPendingCheckForLongPress) != null) {
                    removeCallbacks(checkForLongPress);
                }
                View view3 = this.mPointView;
                if (view3 != null && !this.mHasPerformedLongPress) {
                    performClick(view3);
                }
                hidePopupWindow();
                this.mPointView = null;
                super.removeCallbacks(this.mDelete);
            }
        } else {
            this.mHasPerformedLongPress = false;
            View findPointChild2 = findPointChild(motionEvent.getX(), motionEvent.getY());
            this.mPointView = findPointChild2;
            if (findPointChild2 != null) {
                if (this.mPendingCheckForLongPress == null) {
                    this.mPendingCheckForLongPress = new CheckForLongPress();
                }
                this.mPendingCheckForLongPress.rememberWindowAttachCount();
                postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
                EmoticonInfo emoticonInfo2 = (EmoticonInfo) this.mPointView.getTag();
                if (emoticonInfo2 != null && this.callback != null && "delete".equals(emoticonInfo2.action)) {
                    this.callback.delete();
                }
            }
        }
        return true;
    }

    public void setAdapter(EmoticonAdapter emoticonAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonAdapter);
        } else {
            this.mAdapter = emoticonAdapter;
            emoticonAdapter.setDataSetObserver(this.observer);
        }
    }

    public void setCallBack(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonCallback);
        } else {
            this.callback = emoticonCallback;
        }
    }

    public void setPanelViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.panelViewType = i3;
        }
    }

    void showPopupEmo(View view, EmoticonInfo emoticonInfo) {
        if (!this.hasAttachedToWindow) {
            QLog.w(LOG_TAG, 1, "showPopupEmo return, view not attached to window.");
            return;
        }
        IPanelDependListener iPanelDependListener = this.panelDependListener;
        if (iPanelDependListener != null) {
            iPanelDependListener.showPopupEmo(view, emoticonInfo, tmp, getContext(), this.callback);
        }
    }
}
