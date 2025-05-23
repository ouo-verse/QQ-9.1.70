package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.EmosmEmoticonConstant;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.c;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonTabNtUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.report.EmotionManagePageReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.EmojiHomeUiPluginConstant;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.widget.AdapterView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "\u8868\u60c5\u7ba1\u7406\u9875", path = RouterConstants.UI_ROUTE_EMOSM_ACTIVITY)
/* loaded from: classes9.dex */
public class EmosmActivity extends QIphoneTitleBarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "EmosmActivity";
    BaseQQAppInterface app;
    RelativeLayout emoAIContainer;
    FormSwitchItem emoAISwitch;
    EmoticonObserver emosObserver;
    View emosmFavCon;
    View emosmFavIcon;
    TextView emosmFavName;
    View headerView;
    boolean lastEmoAISetBottomOpened;
    WeakReference<Activity> mActivity;
    com.tencent.mobileqq.emosm.c mAdapter;
    private QQBlurView mBottomBlurView;
    IEmoticonManagerService mDBManager;
    Button mDeleteButton;
    EmoticonPackageChangedListener mEPChangeListener;
    EmoticonPackageDownloadListener mEPDownloadListener;
    private EmotionManagePageReportUtil mEmotionManagePageReportUtil;
    ArrayList<CommonTabEmojiInfo> mHeadFixedCommonTabEmojiInfoList;
    boolean mIsChange;
    boolean mIsEdited;
    int mLaunchMode;
    int mLaunchSource;
    DragSortListView mListView;
    boolean mRedirect;
    Runnable mRefreshTask;
    ArrayList<CommonTabEmojiInfo> mShowingCommonTabEmojiInfoList;
    private View mSpaceLine;
    ArrayList<CommonTabEmojiInfo> mTailMagicCommonTabEmojiInfoList;
    TextView mTipFinish;
    TextView mTitleRight;
    boolean newEmoAISetBottomOpened;
    DragSortListView.h onDrop;
    DragSortListView.l onRemove;
    public QQProgressDialog progressDialog;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DragSortListView.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.h
        public void drop(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 != i16) {
                CommonTabEmojiInfo item = EmosmActivity.this.mAdapter.getItem(i3);
                EmosmActivity.this.mAdapter.f(item);
                EmosmActivity.this.mAdapter.g(true);
                EmosmActivity.this.mAdapter.e(item, i16);
                com.tencent.mobileqq.emoticon.b.b().h(i3, i16);
                EmosmActivity emosmActivity = EmosmActivity.this;
                emosmActivity.mIsChange = true;
                ReportController.o(emosmActivity.app, "CliOper", "", "", "EmosSetting", "EpMove", 0, 0, "", "", "", "");
                EmosmActivity emosmActivity2 = EmosmActivity.this;
                if (emosmActivity2.mLaunchMode == 1) {
                    ReportController.o(emosmActivity2.app, "dc00898", "", "", "0X800AB10", "0X800AB10", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(emosmActivity2.app, "dc00898", "", "", "0X800AB18", "0X800AB18", 0, 0, "", "", "", "");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements DragSortListView.l {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.l
        public void remove(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int headerViewsCount = i3 - EmosmActivity.this.mListView.getHeaderViewsCount();
            if (headerViewsCount < 0) {
                return;
            }
            if (!NetworkUtil.isNetSupport(EmosmActivity.this)) {
                QQToast qQToast = new QQToast(EmosmActivity.this);
                qQToast.setToastIcon(R.drawable.hac);
                qQToast.setDuration(1500);
                qQToast.setToastMsg(HardCodeUtil.qqStr(R.string.m6f));
                qQToast.show(0);
                return;
            }
            EmosmActivity emosmActivity = EmosmActivity.this;
            emosmActivity.progressDialog.setMessage(emosmActivity.getString(R.string.axh));
            EmosmActivity.this.progressDialog.show();
            ((EmoticonHandler) EmosmActivity.this.app.getBusinessHandler(EmoticonHandler.F)).E2(EmosmActivity.this.mShowingCommonTabEmojiInfoList.get(headerViewsCount).epId);
            URLDrawable.clearMemoryCache();
            EmosmActivity emosmActivity2 = EmosmActivity.this;
            if (emosmActivity2.mLaunchMode == 1) {
                ReportController.o(emosmActivity2.app, "dc00898", "", "", "0X800AB12", "0X800AB12", 1, 0, "", "", "", "");
            } else {
                ReportController.o(emosmActivity2.app, "dc00898", "", "", "0X800AB15", "0X800AB15", 0, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends EmoticonObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.EmoticonObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            if (i3 == 1) {
                if (z16) {
                    EmosmActivity.this.updatePackageStatus(((EmoticonResp) obj).delEpId);
                } else {
                    EmosmActivity.this.showAuthErrorTips();
                    EmosmActivity.this.reportEmoticonOperateMonitor((EmoticonResp) obj);
                }
                EmosmActivity.this.dismissDialog();
                EmosmActivity.this.mListView.hideDelButtonWithoutAnimation();
                return;
            }
            if (i3 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.i(EmosmActivity.TAG, 2, "emoticon fetch:" + z16);
                }
                if (z16) {
                    EmosmActivity emosmActivity = EmosmActivity.this;
                    emosmActivity.runOnUiThread(emosmActivity.mRefreshTask);
                    return;
                }
                return;
            }
            if (i3 == 17) {
                if (z16) {
                    Iterator<Integer> it = ((EmoticonResp) obj).ids.iterator();
                    while (it.hasNext()) {
                        EmosmActivity.this.updatePackageStatus(it.next().intValue());
                    }
                } else {
                    EmosmActivity.this.showAuthErrorTips();
                    EmosmActivity.this.reportEmoticonOperateMonitor((EmoticonResp) obj);
                }
                EmosmActivity.this.dismissDialog();
                return;
            }
            if ((i3 == 16 || i3 == 4096) && z16) {
                EmosmActivity emosmActivity2 = EmosmActivity.this;
                emosmActivity2.mDBManager.updateNtCommonTabEmojiInfoList(emosmActivity2.getFinalCommonTabEmojiInfoList());
                com.tencent.mobileqq.emoticon.b.b().f();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EmosmActivity emosmActivity = EmosmActivity.this;
                if (!emosmActivity.mIsEdited) {
                    emosmActivity.mTitleRight.setText(R.string.b2e);
                    EmosmActivity.this.mListView.setDragEnabled(true);
                    EmosmActivity.this.mAdapter.o(true);
                    EmosmActivity emosmActivity2 = EmosmActivity.this;
                    emosmActivity2.mIsEdited = true;
                    emosmActivity2.mAdapter.notifyDataSetChanged();
                    EmosmActivity.this.mDeleteButton.setVisibility(0);
                    EmosmActivity.this.mBottomBlurView.setVisibility(0);
                    EmosmActivity.this.mSpaceLine.setVisibility(0);
                    if (EmosmActivity.this.mShowingCommonTabEmojiInfoList.isEmpty()) {
                        EmosmActivity.this.headerView.setVisibility(8);
                    } else {
                        EmosmActivity emosmActivity3 = EmosmActivity.this;
                        if (emosmActivity3.mListView.findHeaderViewPosition(emosmActivity3.headerView) == 0) {
                            EmosmActivity emosmActivity4 = EmosmActivity.this;
                            emosmActivity4.mListView.removeHeaderView(emosmActivity4.headerView);
                        }
                    }
                    EmosmActivity.this.mDeleteButton.setEnabled(false);
                    EmosmActivity emosmActivity5 = EmosmActivity.this;
                    emosmActivity5.setTitle(String.format(emosmActivity5.getResources().getString(R.string.vzo), 0));
                    EmosmActivity.this.mListView.setPadding(0, 0, 0, ViewUtils.dip2px(44.0f));
                    ReportController.o(EmosmActivity.this.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
                    EmosmActivity emosmActivity6 = EmosmActivity.this;
                    if (emosmActivity6.mLaunchMode == 1) {
                        ReportController.o(emosmActivity6.app, "dc00898", "", "", "0X800AB0F", "0X800AB0F", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(emosmActivity6.app, "dc00898", "", "", "0X800AB16", "0X800AB16", 0, 0, "", "", "", "");
                    }
                    if (EmosmActivity.this.mEmotionManagePageReportUtil != null) {
                        EmosmActivity.this.mEmotionManagePageReportUtil.reportManageEmotionClick();
                    }
                } else {
                    int i3 = emosmActivity.mLaunchSource;
                    if (i3 == 2 || i3 == 1) {
                        emosmActivity.mTitleRight.setText(R.string.inh);
                        EmosmActivity.this.mListView.setDragEnabled(false);
                        EmosmActivity.this.mAdapter.o(false);
                        EmosmActivity.this.saveChangeToDB();
                        EmosmActivity emosmActivity7 = EmosmActivity.this;
                        emosmActivity7.mIsEdited = false;
                        emosmActivity7.mAdapter.notifyDataSetChanged();
                        EmosmActivity.this.mAdapter.a();
                        EmosmActivity.this.mDeleteButton.setVisibility(8);
                        EmosmActivity.this.mBottomBlurView.setVisibility(8);
                        EmosmActivity.this.mSpaceLine.setVisibility(8);
                        EmosmActivity emosmActivity8 = EmosmActivity.this;
                        if (emosmActivity8.mListView.findHeaderViewPosition(emosmActivity8.headerView) == -1) {
                            EmosmActivity emosmActivity9 = EmosmActivity.this;
                            emosmActivity9.mListView.addHeaderView(emosmActivity9.headerView);
                        }
                        EmosmActivity.this.headerView.setVisibility(0);
                        EmosmActivity.this.setTitle(R.string.b2n);
                        EmosmActivity.this.mListView.setPadding(0, 0, 0, 0);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EmosmActivity emosmActivity = EmosmActivity.this;
                if (!emosmActivity.mRedirect && com.tencent.mobileqq.emosm.e.G(emosmActivity)) {
                    EmosmActivity.this.mRedirect = true;
                    ((IEmosmService) QRoute.api(IEmosmService.class)).openEmojiHomePage(EmosmActivity.this.mActivity.get(), EmosmActivity.this.app.getAccount(), 2);
                    ReportController.o(EmosmActivity.this.app, "CliOper", "", "", "EmosSetting", "ForwardEmojiHome", 0, 0, "", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            int headerViewsCount;
            boolean z16;
            Intent intent;
            boolean z17;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            EmosmActivity emosmActivity = EmosmActivity.this;
            if (emosmActivity.mRedirect || emosmActivity.progressDialog.isShowing() || (headerViewsCount = i3 - EmosmActivity.this.mListView.getHeaderViewsCount()) < 0) {
                return;
            }
            CommonTabEmojiInfo item = EmosmActivity.this.mAdapter.getItem(headerViewsCount);
            if (item.bottomEmojitabType == 6) {
                return;
            }
            String valueOf = String.valueOf(item.epId);
            EmoticonPackage syncFindEmoticonPackageById = EmosmActivity.this.mDBManager.syncFindEmoticonPackageById(valueOf);
            if (syncFindEmoticonPackageById == null) {
                QLog.e(EmosmActivity.TAG, 1, "onItemClick return, ep is null!");
                return;
            }
            EmosmActivity emosmActivity2 = EmosmActivity.this;
            if (emosmActivity2.mIsEdited) {
                emosmActivity2.mAdapter.h(headerViewsCount);
                EmosmActivity.this.mAdapter.notifyDataSetChanged();
                List<CommonTabEmojiInfo> d16 = EmosmActivity.this.mAdapter.d();
                if (d16 != null && d16.size() > 0) {
                    EmosmActivity.this.mDeleteButton.setEnabled(true);
                } else {
                    EmosmActivity.this.mDeleteButton.setEnabled(false);
                }
                if (d16 != null) {
                    i16 = d16.size();
                } else {
                    i16 = 0;
                }
                EmosmActivity emosmActivity3 = EmosmActivity.this;
                emosmActivity3.setTitle(String.format(emosmActivity3.getResources().getString(R.string.vzo), Integer.valueOf(i16)));
                if (EmosmActivity.this.mAdapter.c(headerViewsCount)) {
                    EmosmActivity emosmActivity4 = EmosmActivity.this;
                    if (emosmActivity4.mLaunchMode == 1) {
                        ReportController.o(emosmActivity4.app, "dc00898", "", "", "0X800AB11", "0X800AB11", 0, 0, "", "", "", "");
                        return;
                    } else {
                        ReportController.o(emosmActivity4.app, "dc00898", "", "", "0X800AB17", "0X800AB17", 0, 0, "", "", "", "");
                        return;
                    }
                }
                return;
            }
            if (!com.tencent.mobileqq.emosm.e.G(emosmActivity2)) {
                return;
            }
            EmosmActivity.this.mRedirect = true;
            int i17 = syncFindEmoticonPackageById.jobType;
            if (i17 == 2) {
                valueOf = syncFindEmoticonPackageById.kinId;
                z16 = true;
            } else {
                z16 = false;
            }
            String str = valueOf;
            if (i17 == 4) {
                intent = new Intent();
                intent.putExtra(EmojiHomeUiPluginConstant.EXTRA_KEY_IS_SMALL_EMOTICON, true);
            } else {
                intent = null;
            }
            Intent intent2 = intent;
            if (syncFindEmoticonPackageById.jobType == 4) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (1 == EmosmActivity.this.getIntent().getExtras().getInt("emojimall_src", 3)) {
                ((IEmosmService) QRoute.api(IEmosmService.class)).openEmojiDetailPage(EmosmActivity.this.mActivity.get(), EmosmActivity.this.app.getAccount(), 8, str, z16, intent2, z17);
            } else {
                ((IEmosmService) QRoute.api(IEmosmService.class)).openEmojiDetailPage(EmosmActivity.this.mActivity.get(), EmosmActivity.this.app.getAccount(), 4, str, z16, intent2, z17);
            }
            ReportController.o(EmosmActivity.this.app, "CliOper", "", "", "ep_mall", "Clk_ep_mine_detail", 0, 0, syncFindEmoticonPackageById.epId, "", "", "");
            EmosmActivity emosmActivity5 = EmosmActivity.this;
            if (emosmActivity5.mLaunchMode == 1) {
                ReportController.o(emosmActivity5.app, "dc00898", "", "", "0X800AB0E", "0X800AB0E", 0, 0, "", "", "", "");
            } else {
                ReportController.o(emosmActivity5.app, "dc00898", "", "", "0X800AB13", "0X800AB13", 0, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class g implements EmoticonPackageChangedListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
        public void onPackageAdded(EmoticonPackage emoticonPackage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonPackage);
                return;
            }
            for (int i3 = 0; i3 < EmosmActivity.this.mShowingCommonTabEmojiInfoList.size(); i3++) {
                if (TextUtils.equals(String.valueOf(EmosmActivity.this.mShowingCommonTabEmojiInfoList.get(i3).epId), emoticonPackage.epId)) {
                    return;
                }
            }
            EmosmActivity emosmActivity = EmosmActivity.this;
            emosmActivity.runOnUiThread(emosmActivity.mRefreshTask);
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
        public void onPackageDataListUpdate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
        public void onPackageDeleted(EmoticonPackage emoticonPackage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonPackage);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
        public void onPackageMoved(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
        public void onPackageSetBottom() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class h extends EmoticonPackageDownloadListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
        public void onCoverComplete(EmoticonPackage emoticonPackage, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (emoticonPackage != null && i3 == 2 && i16 == 0) {
                EmosmActivity emosmActivity = EmosmActivity.this;
                if (emosmActivity.mShowingCommonTabEmojiInfoList == null) {
                    return;
                }
                emosmActivity.runOnUiThread(emosmActivity.mRefreshTask);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
        public void onPackageEnd(EmoticonPackage emoticonPackage, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonPackage, i3);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
        public void onPackageProgress(EmoticonPackage emoticonPackage, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements QueryCallback<List<CommonTabEmojiInfo>> {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(List<CommonTabEmojiInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            EmosmActivity.this.mHeadFixedCommonTabEmojiInfoList.clear();
            EmosmActivity.this.mShowingCommonTabEmojiInfoList.clear();
            EmosmActivity.this.mTailMagicCommonTabEmojiInfoList.clear();
            com.tencent.mobileqq.emosm.c cVar = EmosmActivity.this.mAdapter;
            if (cVar != null) {
                cVar.a();
            }
            if (list != null && list.size() > 0 && EmosmActivity.this.mLaunchMode == 1) {
                for (CommonTabEmojiInfo commonTabEmojiInfo : list) {
                    EmoticonTabNtUtils emoticonTabNtUtils = EmoticonTabNtUtils.INSTANCE;
                    if (emoticonTabNtUtils.isOfficialFixTab(commonTabEmojiInfo)) {
                        EmosmActivity.this.mHeadFixedCommonTabEmojiInfoList.add(commonTabEmojiInfo);
                    } else if (emoticonTabNtUtils.isMarketMaicFace(commonTabEmojiInfo)) {
                        EmosmActivity.this.mTailMagicCommonTabEmojiInfoList.add(commonTabEmojiInfo);
                    } else {
                        EmosmActivity.this.mShowingCommonTabEmojiInfoList.add(commonTabEmojiInfo);
                    }
                }
            }
            EmosmActivity emosmActivity = EmosmActivity.this;
            if (emosmActivity.mLaunchMode == 1) {
                if (!emosmActivity.mIsEdited) {
                    if (emosmActivity.mListView.findHeaderViewPosition(emosmActivity.headerView) == -1) {
                        EmosmActivity emosmActivity2 = EmosmActivity.this;
                        emosmActivity2.mListView.addHeaderView(emosmActivity2.headerView);
                    }
                    EmosmActivity.this.headerView.setVisibility(0);
                }
            } else if (emosmActivity.mShowingCommonTabEmojiInfoList.isEmpty()) {
                EmosmActivity.this.headerView.setVisibility(8);
            } else {
                EmosmActivity emosmActivity3 = EmosmActivity.this;
                emosmActivity3.mListView.removeHeaderView(emosmActivity3.headerView);
            }
            EmosmActivity.this.setTitle(R.string.b2n);
            com.tencent.mobileqq.emosm.c cVar2 = EmosmActivity.this.mAdapter;
            if (cVar2 != null) {
                cVar2.notifyDataSetChanged();
            }
            if (EmosmActivity.this.mEmotionManagePageReportUtil != null) {
                EmosmActivity.this.mEmotionManagePageReportUtil.reportEmoticonPackageExpose(EmosmActivity.this.mShowingCommonTabEmojiInfoList);
            }
        }
    }

    public EmosmActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHeadFixedCommonTabEmojiInfoList = new ArrayList<>();
        this.mShowingCommonTabEmojiInfoList = new ArrayList<>();
        this.mTailMagicCommonTabEmojiInfoList = new ArrayList<>();
        this.mActivity = new WeakReference<>(this);
        this.emosObserver = new c();
        this.onDrop = new a();
        this.onRemove = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<CommonTabEmojiInfo> getFinalCommonTabEmojiInfoList() {
        ArrayList<CommonTabEmojiInfo> arrayList = new ArrayList<>();
        arrayList.addAll(this.mHeadFixedCommonTabEmojiInfoList);
        arrayList.addAll(this.mAdapter.b());
        arrayList.addAll(this.mTailMagicCommonTabEmojiInfoList);
        return arrayList;
    }

    private void initBlur() {
        this.mBottomBlurView = (QQBlurView) findViewById(R.id.ac8);
        this.mBottomBlurView = (QQBlurView) findViewById(R.id.ac8);
        View findViewById = findViewById(R.id.iry);
        this.mSpaceLine = findViewById;
        findViewById.setBackgroundColor(getResources().getColor(R.color.emo_tabitem_divider2));
        this.mBottomBlurView.j(findViewById(R.id.f7l));
        QQBlurView qQBlurView = this.mBottomBlurView;
        qQBlurView.m(qQBlurView);
        Drawable drawable = getResources().getDrawable(R.drawable.skin_setting_strip_bg_unpressed);
        drawable.setAlpha(235);
        this.mBottomBlurView.z(drawable);
        this.mBottomBlurView.k(0);
        this.mBottomBlurView.A(8.0f);
        this.mBottomBlurView.l(4);
        this.mBottomBlurView.x();
    }

    private void initReportUtil() {
        this.mEmotionManagePageReportUtil = new EmotionManagePageReportUtil(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doOnCreate$0(boolean z16, CommonTabEmojiInfo commonTabEmojiInfo) {
        EmoticonHandler emoticonHandler = (EmoticonHandler) this.app.getBusinessHandler(EmoticonHandler.F);
        if (emoticonHandler != null) {
            emoticonHandler.Y2(commonTabEmojiInfo, 0, !z16);
        }
        EmotionManagePageReportUtil emotionManagePageReportUtil = this.mEmotionManagePageReportUtil;
        if (emotionManagePageReportUtil != null) {
            emotionManagePageReportUtil.reportEmoticonPackageClick(commonTabEmojiInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEmoticonOperateMonitor(EmoticonResp emoticonResp) {
        int i3;
        if (emoticonResp != null) {
            for (int i16 = 0; i16 < this.mAdapter.getCount(); i16++) {
                CommonTabEmojiInfo item = this.mAdapter.getItem(i16);
                if (item.epId == emoticonResp.delEpId) {
                    if (EmoticonTabNtUtils.INSTANCE.isMarketMaicFace(item)) {
                        i3 = 5;
                    } else {
                        i3 = 4;
                    }
                    EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus(String.valueOf(emoticonResp.resultcode), i3);
                    return;
                }
            }
        }
    }

    public com.tencent.mobileqq.emosm.view.c buildController(DragSortListView dragSortListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.emosm.view.c) iPatchRedirector.redirect((short) 9, (Object) this, (Object) dragSortListView);
        }
        com.tencent.mobileqq.emosm.view.c cVar = new com.tencent.mobileqq.emosm.view.c(dragSortListView);
        cVar.e(R.id.f165020bq3);
        cVar.d(R.id.ayu);
        cVar.g(true);
        cVar.j(true);
        cVar.f(0);
        cVar.h(0);
        cVar.i(2);
        return cVar;
    }

    void dismissDialog() {
        if (this.mIsEdited) {
            setTitle(String.format(getResources().getString(R.string.vzo), 0));
        }
        this.progressDialog.dismiss();
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168903h81);
        super.setContentBackgroundResource(R.drawable.bg_texture);
        super.setTitle(R.string.b2n);
        this.app = (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        parseOptions();
        TextView textView = this.rightViewText;
        this.mTitleRight = textView;
        textView.setVisibility(0);
        this.mTitleRight.setText(R.string.inh);
        this.mTitleRight.setOnClickListener(new d());
        Button button = (Button) findViewById(R.id.ams);
        this.mDeleteButton = button;
        button.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.c0l);
        this.mTipFinish = textView2;
        textView2.setOnClickListener(new e());
        try {
            DragSortListView dragSortListView = (DragSortListView) findViewById(android.R.id.list);
            this.mListView = dragSortListView;
            com.tencent.mobileqq.emosm.view.c buildController = buildController(dragSortListView);
            this.mListView.setFloatViewManager(buildController);
            this.mListView.setOnTouchListener(buildController);
            this.mListView.setDragEnabled(false);
            this.mListView.setDelImmediately(false);
            View inflate = View.inflate(this.mListView.getContext(), R.layout.f168904h82, null);
            this.headerView = inflate;
            this.emosmFavCon = inflate.findViewById(R.id.f5_);
            this.emosmFavIcon = this.headerView.findViewById(R.id.f5b);
            this.emosmFavName = (TextView) this.headerView.findViewById(R.id.f6d);
            this.emosmFavCon.setOnClickListener(this);
            this.emosmFavCon.setBackgroundDrawable(getResources().getDrawable(R.drawable.b7n));
            RelativeLayout relativeLayout = (RelativeLayout) this.headerView.findViewById(R.id.ut5);
            this.emoAIContainer = relativeLayout;
            relativeLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.b7n));
            initEmoticonSwitch(this, this.app.getCurrentAccountUin());
            this.mListView.addHeaderView(this.headerView);
            this.mDBManager = (IEmoticonManagerService) this.app.getRuntimeService(IEmoticonManagerService.class);
            Intent intent = getIntent();
            this.mLaunchMode = intent.getIntExtra("extra_launch_mode", 1);
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.EmosmActivity.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmosmActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        EmosmActivity.this.fillData();
                    }
                }
            };
            this.mRefreshTask = runnable;
            runnable.run();
            com.tencent.mobileqq.emosm.c cVar = new com.tencent.mobileqq.emosm.c(this, this.mDBManager, this.mShowingCommonTabEmojiInfoList);
            this.mAdapter = cVar;
            this.mListView.setAdapter((ListAdapter) cVar);
            this.mListView.setDropListener(this.onDrop);
            this.mListView.setRemoveListener(this.onRemove);
            this.mListView.setOnItemClickListener(new f());
            this.mAdapter.p(new c.a() { // from class: com.tencent.mobileqq.activity.bt
                @Override // com.tencent.mobileqq.emosm.c.a
                public final void a(boolean z16, CommonTabEmojiInfo commonTabEmojiInfo) {
                    EmosmActivity.this.lambda$doOnCreate$0(z16, commonTabEmojiInfo);
                }
            });
            this.mRedirect = false;
            this.mEPChangeListener = new g();
            com.tencent.mobileqq.emoticon.b.b().a(this.mEPChangeListener);
            this.mEPDownloadListener = new h();
            com.tencent.mobileqq.emoticon.b.b().addEmoticonPackageDownloadListener(this.mEPDownloadListener);
            int intExtra = intent.getIntExtra(EmosmEmoticonConstant.EXTRA_LAUNCH_SOURCE, 2);
            this.mLaunchSource = intExtra;
            if (intExtra == 2 || intExtra == 1) {
                this.mDeleteButton.setVisibility(8);
                this.mIsEdited = false;
                this.mTitleRight.setText(R.string.inh);
                this.mListView.setDragEnabled(false);
                this.mAdapter.o(false);
                this.mAdapter.notifyDataSetChanged();
            }
            initBlur();
            onChangeLaunchMode(1);
            this.progressDialog = new QQProgressDialog(this);
            super.addObserver(this.emosObserver);
            initReportUtil();
            ReportController.o(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
            return true;
        } catch (OutOfMemoryError e16) {
            this.mListView = null;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnDestroy();
        super.removeObserver(this.emosObserver);
        com.tencent.mobileqq.emoticon.b.b().n(this.mEPChangeListener);
        com.tencent.mobileqq.emoticon.b.b().removeEmoticonPackageDownloadListener(this.mEPDownloadListener);
        QQBlurView qQBlurView = this.mBottomBlurView;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "emosm activity ..............onPause");
        }
        super.doOnPause();
        QQBlurView qQBlurView = this.mBottomBlurView;
        if (qQBlurView != null) {
            qQBlurView.onPause();
        }
        EmotionManagePageReportUtil emotionManagePageReportUtil = this.mEmotionManagePageReportUtil;
        if (emotionManagePageReportUtil != null) {
            emotionManagePageReportUtil.reportPageExit();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mRedirect = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "emosm activity ..............onResume");
        }
        ((EmoticonHandler) this.app.getBusinessHandler(EmoticonHandler.F)).g(0, 0);
        QQBlurView qQBlurView = this.mBottomBlurView;
        if (qQBlurView != null) {
            qQBlurView.onResume();
        }
        super.doOnResume();
        EmotionManagePageReportUtil emotionManagePageReportUtil = this.mEmotionManagePageReportUtil;
        if (emotionManagePageReportUtil != null) {
            emotionManagePageReportUtil.reportPageExpose();
        }
    }

    void fillData() {
        Button button = this.mDeleteButton;
        if (button != null && button.getVisibility() == 0) {
            this.mDeleteButton.setEnabled(false);
        }
        this.mDBManager.asyncGetCommonTabEmojiInfoList(0, new i());
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.emoticon.b.b().n(this.mEPChangeListener);
        com.tencent.mobileqq.emoticon.b.b().removeEmoticonPackageDownloadListener(this.mEPDownloadListener);
        this.mAdapter.j();
        super.finish();
    }

    protected void initEmoticonSwitch(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.lastEmoAISetBottomOpened = EmoticonUtils.isEmoAIEntrySetBottom();
        int dip2px = ViewUtils.dip2px(28.0f);
        int dip2px2 = ViewUtils.dip2px(10.0f);
        if (!com.tencent.mobileqq.emosm.h.a()) {
            FormSwitchItem formSwitchItem = new FormSwitchItem(this);
            this.emoAISwitch = formSwitchItem;
            formSwitchItem.setId(R.id.us8);
            this.emoAISwitch.setPadding(dip2px2);
            this.emoAISwitch.setLeftIcon(getDrawable(R.drawable.j6f), dip2px, dip2px);
            this.emoAISwitch.setText(getText(R.string.zum));
            this.emoAISwitch.setOnCheckedChangeListener(this);
            this.emoAISwitch.setChecked(this.lastEmoAISetBottomOpened);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(9);
            this.emoAIContainer.addView(this.emoAISwitch, layoutParams);
            this.emoAIContainer.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.mLaunchMode != 1) {
            if (this.mIsEdited) {
                this.mTitleRight.setText(R.string.inh);
                this.mListView.setDragEnabled(false);
                this.mAdapter.o(false);
                this.mIsEdited = false;
                this.mDeleteButton.setVisibility(8);
            }
            onChangeLaunchMode(1);
            return true;
        }
        if (this.lastEmoAISetBottomOpened != this.newEmoAISetBottomOpened) {
            com.tencent.mobileqq.emoticon.b.b().i();
            EmoticonUtils.setEmoAIEntryBottom(this.newEmoAISetBottomOpened);
        }
        return super.onBackEvent();
    }

    public void onChangeLaunchMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            if (this.mLaunchMode == i3) {
                return;
            }
            this.mLaunchMode = i3;
            this.mIsChange = false;
            runOnUiThread(this.mRefreshTask);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, compoundButton, Boolean.valueOf(z16));
        } else {
            View view = (View) compoundButton.getParent();
            if (view != null && view.getId() == R.id.us8) {
                this.newEmoAISetBottomOpened = z16;
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ams) {
                if (!NetworkUtil.isNetSupport(this)) {
                    QQToast qQToast = new QQToast(this);
                    qQToast.setToastIcon(R.drawable.hac);
                    qQToast.setDuration(1500);
                    qQToast.setToastMsg(HardCodeUtil.qqStr(R.string.m6g));
                    qQToast.show(0);
                } else {
                    this.progressDialog.setMessage(getString(R.string.axh));
                    this.progressDialog.show();
                    List<CommonTabEmojiInfo> d16 = this.mAdapter.d();
                    if (d16.size() > 0) {
                        URLDrawable.clearMemoryCache();
                        EmoticonHandler emoticonHandler = (EmoticonHandler) this.app.getBusinessHandler(EmoticonHandler.F);
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        Iterator<CommonTabEmojiInfo> it = d16.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Integer.valueOf(it.next().epId));
                        }
                        emoticonHandler.G2(arrayList);
                        this.mDeleteButton.setEnabled(false);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "delete packages:" + arrayList.toString());
                        }
                        ReportController.o(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
                        if (this.mLaunchMode == 1) {
                            ReportController.o(this.app, "dc00898", "", "", "0X800AB12", "0X800AB12", arrayList.size(), 0, "", "", "", "");
                        } else {
                            ReportController.o(this.app, "dc00898", "", "", "0X800AB19", "0X800AB19", arrayList.size(), 0, "", "", "", "");
                        }
                    }
                }
            } else if (id5 == R.id.f5_) {
                startActivity(new Intent(this, (Class<?>) FavEmosmManageActivity.class));
                ReportController.o(this.app, "dc00898", "", "", "0X800AB0B", "0X800AB0B", 0, 0, "", "", "", "");
                EmotionManagePageReportUtil emotionManagePageReportUtil = this.mEmotionManagePageReportUtil;
                if (emotionManagePageReportUtil != null) {
                    emotionManagePageReportUtil.reportFavoriteEmotionClick();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "emosm activity ..............onRestart");
        }
        super.onRestart();
    }

    void parseOptions() {
        String stringExtra = getIntent().getStringExtra("options");
        try {
            if (TextUtils.isEmpty(stringExtra)) {
                this.leftView.setText(R.string.zul);
            } else {
                this.leftView.setText(new JSONObject(stringExtra).optString("leftText", getString(R.string.zul)));
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
    }

    public void saveChangeToDB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mIsChange) {
            ArrayList<CommonTabEmojiInfo> finalCommonTabEmojiInfoList = getFinalCommonTabEmojiInfoList();
            ArrayList arrayList = new ArrayList();
            Iterator<CommonTabEmojiInfo> it = finalCommonTabEmojiInfoList.iterator();
            while (it.hasNext()) {
                CommonTabEmojiInfo next = it.next();
                if (EmoticonTabNtUtils.INSTANCE.isMarketFace(next)) {
                    arrayList.add(String.valueOf(next.epId));
                }
            }
            this.mDBManager.reconstructAllTabEmoticonPackage(arrayList, 0);
            EmoticonHandler emoticonHandler = (EmoticonHandler) this.app.getBusinessHandler(EmoticonHandler.F);
            if (emoticonHandler != null) {
                emoticonHandler.X2(finalCommonTabEmojiInfoList, true, 0);
            }
        }
    }

    void showAuthErrorTips() {
        QQToast qQToast = new QQToast(this);
        qQToast.setToastIcon(R.drawable.hac);
        qQToast.setDuration(1500);
        qQToast.setToastMsg(HardCodeUtil.qqStr(R.string.m6h));
        qQToast.show(0);
    }

    void updatePackageStatus(int i3) {
        int i16;
        this.mAdapter.g(true);
        int i17 = 0;
        while (true) {
            if (i17 >= this.mAdapter.getCount()) {
                break;
            }
            CommonTabEmojiInfo item = this.mAdapter.getItem(i17);
            if (item.epId == i3) {
                this.mAdapter.f(item);
                boolean isMarketMaicFace = EmoticonTabNtUtils.INSTANCE.isMarketMaicFace(item);
                if (isMarketMaicFace) {
                    i16 = 5;
                } else {
                    i16 = 4;
                }
                EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("0", i16);
                if (!isMarketMaicFace) {
                    ThreadManager.getFileThreadHandler().post(new Runnable(item) { // from class: com.tencent.mobileqq.activity.EmosmActivity.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ CommonTabEmojiInfo f175703d;

                        {
                            this.f175703d = item;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmosmActivity.this, (Object) item);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            BaseQQAppInterface baseQQAppInterface = null;
                            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                            if (waitAppRuntime instanceof BaseQQAppInterface) {
                                baseQQAppInterface = (BaseQQAppInterface) waitAppRuntime;
                            }
                            if (baseQQAppInterface != null) {
                                IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
                                String valueOf = String.valueOf(this.f175703d.epId);
                                EmoticonTab findEmoticonTabById = iEmoticonManagerService.findEmoticonTabById(valueOf);
                                if (findEmoticonTabById == null || (!findEmoticonTabById.aioHave && !findEmoticonTabById.kandianHave)) {
                                    String str = AppConstants.SDCARD_EMOTICON_SAVE + valueOf;
                                    File file = new File(str);
                                    File file2 = new File(str + "del");
                                    if (file.renameTo(file2)) {
                                        FileUtils.deleteDirectory(file2.getAbsolutePath());
                                    } else {
                                        FileUtils.deleteDirectory(file.getAbsolutePath());
                                    }
                                }
                            }
                        }
                    });
                }
                if (isMarketMaicFace) {
                    ReportController.o(MobileQQ.sMobileQQ.waitAppRuntime(null), "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
                }
            } else {
                i17++;
            }
        }
        this.mDBManager.updateNtCommonTabEmojiInfoList(getFinalCommonTabEmojiInfoList());
    }
}
