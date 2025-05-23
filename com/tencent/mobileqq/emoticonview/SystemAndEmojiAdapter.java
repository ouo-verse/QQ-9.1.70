package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.api.IApolloDependApi;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SystemAndEmojiAdapter extends BaseEmotionAdapter implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final int EMOJI_LARGE_WIDTH = 35;
    public static final int EMOJI_WIDTH = 30;
    public static final int ITEM_TYPE_PIC = 1;
    public static final int ITEM_TYPE_TITLE = 0;
    public static final int MARGIN_HORIZONTAL = 18;
    public static final String TAG = "SystemAndEmojiAdapter";
    private int apolloEmoticonRow;
    private int businessType;
    protected int emojiWidth;
    public boolean isOnlySysEmotion;
    private int lastItemAddPaddingBottom;
    int mEmotionType;
    int mLocalId;

    @Nullable
    private rg2.a mPanelController;
    private IPanelListener mPanelListener;
    private boolean mPopupGuideHided;
    private int originItemAddPaddingBottom;
    private boolean showDescribeInPreview;
    public boolean showTitleLightColor;
    protected int spaceWidth;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class SystemAndEmojiHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        EmoticonImageView[] contentViews;
        TextView titleTxt;

        public SystemAndEmojiHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SystemAndEmojiAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelListener iPanelListener, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback, int i18) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback, Integer.valueOf(i18));
            return;
        }
        this.apolloEmoticonRow = -1;
        this.mLocalId = -1;
        this.mEmotionType = -1;
        this.isOnlySysEmotion = false;
        this.showDescribeInPreview = false;
        this.showTitleLightColor = false;
        this.businessType = i18;
        this.mPanelListener = iPanelListener;
        this.emojiWidth = (int) (this.density * 35.0f);
    }

    private int findEmoticonIndex(List<EmotionPanelData> list, int i3) {
        return findEmoticonIndex(list, -1, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getEmotionView$0(List list) {
        AppRuntime appRuntime = this.app.getAppRuntime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ReportController.o(appRuntime, "dc00898", "", "", "0X800BB9D", "0X800BB9D", ((Integer) it.next()).intValue(), 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int calculateSpaceWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = this.widthPixels - (((int) (this.density * 18.0f)) * 2);
        int i16 = this.emojiWidth;
        int i17 = this.columnNum;
        return (i3 - (i16 * i17)) / (i17 - 1);
    }

    public List<EmotionPanelData> getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo;
        int i16;
        View view4;
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo2;
        String str;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 12;
        int i18 = 2;
        ?? r56 = 0;
        ?? r65 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        this.spaceWidth = calculateSpaceWidth();
        SystemAndEmojiHolder systemAndEmojiHolder = (SystemAndEmojiHolder) viewHolder;
        float f17 = 18.0f;
        if (getItemViewType(i3) == 0) {
            if (view == null) {
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i3 == 0) {
                    i17 = 6;
                }
                float f18 = this.density;
                layoutParams.topMargin = (int) (i17 * f18);
                layoutParams.leftMargin = (int) (f18 * 18.0f);
                TextView textView = new TextView(this.mContext);
                if (SimpleUIUtil.isNowElderMode()) {
                    f16 = 20.0f;
                } else {
                    f16 = 10.0f;
                }
                textView.setTextSize(f16);
                if (this.ignoreUIToken) {
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.skin_gray2_theme_version2));
                } else if (this.showTitleLightColor) {
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.bil));
                } else {
                    textView.setTextColor(this.mContext.getColorStateList(R.color.qui_common_text_primary).getDefaultColor());
                }
                linearLayout.addView(textView, layoutParams);
                systemAndEmojiHolder.titleTxt = textView;
                linearLayout.setTag(systemAndEmojiHolder);
                view4 = linearLayout;
            } else {
                view4 = view;
            }
            EmotionPanelData emotionPanelData = this.data.get(this.columnNum * i3);
            if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                systemAndEmojiEmoticonInfo2 = (SystemAndEmojiEmoticonInfo) emotionPanelData;
            } else {
                systemAndEmojiEmoticonInfo2 = null;
            }
            if (systemAndEmojiEmoticonInfo2 != null) {
                str = systemAndEmojiEmoticonInfo2.title;
            } else {
                str = "";
            }
            systemAndEmojiHolder.titleTxt.setText(str);
            view3 = view4;
            if (systemAndEmojiEmoticonInfo2 != null) {
                reportItemTypeTitle(systemAndEmojiEmoticonInfo2.code);
                view3 = view4;
            }
        } else {
            int i19 = 8;
            if (view == null) {
                view2 = EmotionPanelViewPool.getInstance().getView(this.panelType);
                if (view2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from inflater");
                    }
                    IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper = ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).createEmoticonPanelLayoutHelper(this.mContext, this.mPanelListener);
                    createEmoticonPanelLayoutHelper.setShowDescribeInPreview(this.showDescribeInPreview);
                    EmoticonPanelLinearLayout emoticonPanelLinearLayout = new EmoticonPanelLinearLayout(this.mContext, createEmoticonPanelLayoutHelper, this.businessType);
                    emoticonPanelLinearLayout.setPanelType(0);
                    emoticonPanelLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                    emoticonPanelLinearLayout.setOrientation(0);
                    int i26 = 0;
                    while (i26 < this.columnNum) {
                        EmoticonImageView emoticonImageView = new EmoticonImageView(this.mContext);
                        int i27 = this.spaceWidth / i18;
                        float f19 = this.density;
                        int i28 = (int) (f19 * 6.0f);
                        if (i26 == 0) {
                            i16 = i27;
                            i27 = (int) (f19 * f17);
                        } else if (i26 == this.columnNum - 1) {
                            i16 = (int) (f19 * f17);
                        } else {
                            i16 = i27;
                        }
                        int i29 = this.emojiWidth;
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i29 + i27 + i16, i29 + (i28 * 2));
                        emoticonImageView.setPadding(i27, i28, i16, i28);
                        emoticonImageView.setLayoutParams(layoutParams2);
                        emoticonImageView.setVisibility(8);
                        emoticonImageView.setScaleType(ImageView.ScaleType.FIT_START);
                        emoticonImageView.setAdjustViewBounds(false);
                        emoticonImageView.setFocusable(true);
                        emoticonImageView.setFocusableInTouchMode(true);
                        emoticonPanelLinearLayout.addView(emoticonImageView);
                        i26++;
                        i18 = 2;
                        f17 = 18.0f;
                    }
                    view2 = emoticonPanelLinearLayout;
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from cache");
                }
                ((EmoticonPanelLinearLayout) view2).setCallBack(this.callback);
                recycleView(this.panelType, view2);
                ViewGroup viewGroup2 = (ViewGroup) view2;
                systemAndEmojiHolder.contentViews = new EmoticonImageView[this.columnNum];
                for (int i36 = 0; i36 < this.columnNum; i36++) {
                    systemAndEmojiHolder.contentViews[i36] = (EmoticonImageView) viewGroup2.getChildAt(i36);
                }
                view2.setTag(systemAndEmojiHolder);
            } else {
                view2 = view;
            }
            final ArrayList arrayList = new ArrayList();
            int i37 = 0;
            while (true) {
                int i38 = this.columnNum;
                if (i37 >= i38) {
                    break;
                }
                int i39 = (i38 * i3) + i37;
                EmoticonImageView emoticonImageView2 = systemAndEmojiHolder.contentViews[i37];
                if (emoticonImageView2 == 0) {
                    Object[] objArr = new Object[2];
                    objArr[r56] = "[getEmotionView] error, imgView is null. index=";
                    objArr[r65] = Integer.valueOf(i37);
                    QLog.e(TAG, (int) r65, objArr);
                } else {
                    emoticonImageView2.setTag(null);
                    if (i39 > this.data.size() - r65) {
                        emoticonImageView2.setVisibility(i19);
                    } else {
                        EmotionPanelData emotionPanelData2 = this.data.get(i39);
                        if (emotionPanelData2 instanceof SystemAndEmojiEmoticonInfo) {
                            systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData2;
                        } else {
                            systemAndEmojiEmoticonInfo = null;
                        }
                        if (systemAndEmojiEmoticonInfo == null) {
                            emoticonImageView2.setVisibility(i19);
                        } else {
                            emoticonImageView2.setTag(systemAndEmojiEmoticonInfo);
                            if (systemAndEmojiEmoticonInfo.code == -1) {
                                emoticonImageView2.setVisibility(i19);
                            } else {
                                emoticonImageView2.setVisibility(r56);
                                if (emotionPanelData2 != emoticonImageView2.getTag(R.id.kxb)) {
                                    emoticonImageView2.setTag(R.id.kxb, emotionPanelData2);
                                    if (((IApolloDependApi) QRoute.api(IApolloDependApi.class)).shouldShowNewIcon(systemAndEmojiEmoticonInfo.code)) {
                                        emoticonImageView2.setNewIconVisible(r65);
                                        ((IApolloDependApi) QRoute.api(IApolloDependApi.class)).onEmoticonNewIconShown(systemAndEmojiEmoticonInfo.code);
                                        if (this.mPanelController != null && !this.mPopupGuideHided) {
                                            this.mPopupGuideHided = r65;
                                            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter.2
                                                static IPatchRedirector $redirector_;

                                                {
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemAndEmojiAdapter.this);
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                                    } else {
                                                        SystemAndEmojiAdapter.this.mPanelController.removePopupGuide();
                                                    }
                                                }
                                            }, 100L);
                                        }
                                    } else {
                                        emoticonImageView2.setNewIconVisible(r56);
                                    }
                                    emoticonImageView2.setImageDrawable(getEmotionViewFaceDrawable(systemAndEmojiEmoticonInfo));
                                    int i46 = systemAndEmojiEmoticonInfo.emotionType;
                                    if (i46 == 1) {
                                        String faceDescription = QQSysFaceUtil.getFaceDescription(systemAndEmojiEmoticonInfo.code);
                                        if (faceDescription != null && faceDescription.startsWith("/") && faceDescription.length() > 1) {
                                            faceDescription = faceDescription.substring(1);
                                        }
                                        if (faceDescription != null) {
                                            emoticonImageView2.setContentDescription(faceDescription);
                                        }
                                    } else if (i46 == 2) {
                                        emoticonImageView2.setContentDescription(QQEmojiUtil.getEmojiDescription(systemAndEmojiEmoticonInfo.code));
                                    } else {
                                        emoticonImageView2.setContentDescription(HardCodeUtil.qqStr(R.string.f230296yr));
                                    }
                                    rg2.a aVar = this.mPanelController;
                                    if (aVar != null && aVar.isInAIO()) {
                                        emoticonImageView2.setOnClickListener(this);
                                        emoticonImageView2.setClickable(false);
                                        EmotionReportDtImpl.bindSystemAndEmojiFaceView(emoticonImageView2, systemAndEmojiEmoticonInfo, i39, this.columnNum);
                                    }
                                    if (systemAndEmojiEmoticonInfo.emotionType == 1) {
                                        arrayList.add(Integer.valueOf(QQSysFaceUtil.convertToServer(systemAndEmojiEmoticonInfo.code)));
                                    }
                                }
                            }
                            i37++;
                            r56 = 0;
                            r65 = 1;
                            i19 = 8;
                        }
                    }
                }
                i37++;
                r56 = 0;
                r65 = 1;
                i19 = 8;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.aw
                @Override // java.lang.Runnable
                public final void run() {
                    SystemAndEmojiAdapter.this.lambda$getEmotionView$0(arrayList);
                }
            }, 16, null, false);
            view3 = view2;
        }
        if (i3 == getCount() - 1 && this.lastItemAddPaddingBottom != 0) {
            int paddingBottom = view3.getPaddingBottom();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "convertView.getPaddingBottom()=" + paddingBottom + "lastItemAddPaddingBottom=" + this.lastItemAddPaddingBottom);
            }
            int i47 = paddingBottom + this.lastItemAddPaddingBottom;
            int i48 = this.originItemAddPaddingBottom;
            if (i47 > i48) {
                i47 = i48;
            }
            view3.setPadding(view3.getPaddingLeft(), view3.getPaddingTop(), view3.getPaddingRight(), i47);
        } else {
            view3.setPadding(0, 0, 0, 0);
        }
        return view3;
    }

    protected Drawable getEmotionViewFaceDrawable(@NonNull SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this, (Object) systemAndEmojiEmoticonInfo);
        }
        return systemAndEmojiEmoticonInfo.getDrawable(false);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        EmotionPanelData emotionPanelData = this.data.get(i3 * this.columnNum);
        if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
            systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
        } else {
            systemAndEmojiEmoticonInfo = null;
        }
        if (systemAndEmojiEmoticonInfo != null) {
            if (systemAndEmojiEmoticonInfo.emotionType == 3) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return new SystemAndEmojiHolder();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "SystemAndEmojiAdapter itemView onClicked");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void refreshPanelData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.refreshPanelData();
        this.data = this.dataHasWhiteFace;
        notifyDataSetChanged();
    }

    protected void reportItemTypeTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter
    public void setData(List<EmotionPanelData> list) {
        int i3;
        List<Integer> list2;
        int findEmoticonIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        super.setData(list);
        this.dataHasWhiteFace = list;
        refreshPanelData();
        HashMap<String, List<Integer>> hashMap = SystemEmoticonInfo.sNewApolloEmoticonMap;
        String str = AppSetting.f99551k;
        if (hashMap.containsKey(str) && (list2 = SystemEmoticonInfo.sNewApolloEmoticonMap.get(str)) != null && list2.size() > 0 && (findEmoticonIndex = findEmoticonIndex(list, list2.get(0).intValue())) != -1) {
            this.apolloEmoticonRow = findEmoticonIndex / this.columnNum;
        }
        int i16 = this.mLocalId;
        if (i16 != -1 && (i3 = this.mEmotionType) != -1 && this.currentView != null) {
            setSelectionToEmoticonByLocalId(i3, i16);
            this.mLocalId = -1;
            this.mEmotionType = -1;
        }
    }

    public void setLastItemAddPaddingBottom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        if (this.lastItemAddPaddingBottom == 0) {
            this.originItemAddPaddingBottom = i3;
        }
        this.lastItemAddPaddingBottom = i3;
    }

    public void setPanelController(rg2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.mPanelController = aVar;
        }
    }

    public void setSelectionToApolloEmoticon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            setSelectionToEmoticon(this.apolloEmoticonRow);
        }
    }

    public void setSelectionToEmoticon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        EmotionPanelListView emotionPanelListView = this.currentView;
        if (emotionPanelListView != null && i3 >= 0) {
            if (i3 < 0) {
                i3 = 0;
            }
            emotionPanelListView.abortFling();
            this.currentView.setSelection(i3);
        }
    }

    public void setSelectionToEmoticonByLocalId(int i3, int i16) {
        int findEmoticonIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (i16 != -1 && this.currentView != null && (findEmoticonIndex = findEmoticonIndex(this.data, i3, i16)) != -1) {
            this.currentView.post(new Runnable(findEmoticonIndex / this.columnNum) { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$locEmoticonRow;

                {
                    this.val$locEmoticonRow = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemAndEmojiAdapter.this, r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SystemAndEmojiAdapter.this.setSelectionToEmoticon(this.val$locEmoticonRow);
                    }
                }
            });
        }
    }

    public void setShowDescribeInPreview(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.showDescribeInPreview = z16;
        }
    }

    private int findEmoticonIndex(List<EmotionPanelData> list, int i3, int i16) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                EmotionPanelData emotionPanelData = list.get(i17);
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                    if (!systemAndEmojiEmoticonInfo.isCommonUsed && systemAndEmojiEmoticonInfo.code == i16 && (i3 == -1 || i3 == systemAndEmojiEmoticonInfo.emotionType)) {
                        return i17;
                    }
                }
            }
        }
        return -1;
    }
}
