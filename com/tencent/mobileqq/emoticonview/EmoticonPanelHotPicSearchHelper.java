package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.data.AIOContact;
import com.tencent.image.AbstractGifImage;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmotionSearchDialogUtil;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportHelper;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emoticonview.searchemo.IEmoticonEventCallback;
import com.tencent.mobileqq.emoticonview.searchemo.IHotTagsCallback;
import com.tencent.mobileqq.emoticonview.searchemo.ISearchEmoticonMgrApi;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoUtil;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.emotion.api.IEmoticonMarketFace;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicEmojiType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsItemType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsSceneType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicHotWordsItem;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchSceneType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextMallEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.qqnt.kernel.nativeinterface.HotPicInfo;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class EmoticonPanelHotPicSearchHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> implements AbsListView.OnScrollListener, View.OnClickListener, IEmotionSearchManagerService.a, com.tencent.mobileqq.emosm.emosearch.c, com.tencent.mobileqq.emosm.p, IHotTagsCallback {
    static IPatchRedirector $redirector_ = null;
    public static final int ITEM_TYPE_LOAD_INIT = 0;
    public static final int SEARCH_INPUT_BOX_RADIUS_PX;
    public static final int SEARCH_INPUT_BOX_SEARCH_ICON_SIZE_PX;
    public static final String TAG = "EmoticonPanelHotPicSearchHelper";
    protected static int sLastShowPageType;
    protected static boolean sNeedPullUp;
    private static boolean sNeedSwitchToTab;
    protected static boolean sPrepareSearch;
    protected static int sSearchVisibility;
    protected static String sSearchWord;
    protected List<EmojiHotPicHotWordsItem> mEmoticonTags;
    private EmotionDaTongReportHelper mEmotionDaTongReportHelper;
    protected View mFooterView;
    protected View mHeaderView;
    protected IPanelInteractionListener mInteractionListener;
    private boolean mIsAnonymousState;
    protected boolean mIsClearWords;
    protected int mLastScrollState;
    protected ViewGroup mLayoutEmoticonSearch;
    protected ListView mListView;
    protected boolean mLoadMore;
    protected View mLoadingEmptyView;
    protected int mLoadingStatus;
    protected RecyclerView mRvKeyword;
    protected BaseEmotionAdapter mSearchAdapter;
    private EmotionDaTongReportHelper mSearchEmotionDaTongReportHelper;
    protected View mSearchView;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49194);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 63)) {
            redirector.redirect((short) 63);
            return;
        }
        SEARCH_INPUT_BOX_RADIUS_PX = ViewUtils.dip2px(8.0f);
        SEARCH_INPUT_BOX_SEARCH_ICON_SIZE_PX = ViewUtils.dip2px(18.0f);
        sSearchWord = null;
        sNeedPullUp = false;
        sSearchVisibility = 0;
        sNeedSwitchToTab = false;
        sLastShowPageType = 1;
        sPrepareSearch = false;
    }

    public EmoticonPanelHotPicSearchHelper(IPanelInteractionListener iPanelInteractionListener) {
        super(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iPanelInteractionListener);
            return;
        }
        this.mLoadingStatus = 0;
        this.mLoadMore = false;
        this.mLastScrollState = 0;
        this.mIsClearWords = false;
        this.mInteractionListener = iPanelInteractionListener;
    }

    private void addHeader(EmotionPanelListView emotionPanelListView) {
        ViewParent parent = emotionPanelListView.getParent();
        if (parent instanceof ViewGroup) {
            View view = this.mSearchView;
            if (view == null) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h8a, (ViewGroup) parent, false);
                this.mSearchView = inflate;
                initHeader(inflate);
            } else if (view.getParent() != null) {
                ((ViewGroup) this.mSearchView.getParent()).removeView(this.mSearchView);
            }
            ((ViewGroup) parent).addView(this.mSearchView, 0);
        }
    }

    private void dtBindViewReport(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static Drawable getHotPicSearchInboxBoxIconDrawable(Context context) {
        Drawable o16 = ie0.a.f().o(context, R.drawable.qui_search, R.color.qui_common_icon_secondary, 1000);
        int i3 = SEARCH_INPUT_BOX_SEARCH_ICON_SIZE_PX;
        o16.setBounds(0, 0, i3, i3);
        return o16;
    }

    private List<EmojiHotPicHotWordsItem> getHotPicTags() {
        List<EmojiHotPicHotWordsItem> list = this.mEmoticonTags;
        if (list != null && !list.isEmpty()) {
            QLog.i(TAG, 1, "getHotPicTags emoticonTags is valid!");
            return this.mEmoticonTags;
        }
        QLog.i(TAG, 1, "getHotPicTags emoticonTags is null or empty!");
        getHotPicTagsData(getApp(), new IEmotionSearchManagerService.b() { // from class: com.tencent.mobileqq.emoticonview.r
            @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.b
            public final void onResult(ArrayList arrayList) {
                EmoticonPanelHotPicSearchHelper.this.lambda$getHotPicTags$2(arrayList);
            }
        });
        ArrayList arrayList = new ArrayList();
        for (String str : getContext().getResources().getStringArray(R.array.f155234cd)) {
            arrayList.add(new EmojiHotPicHotWordsItem(str, 0, EmojiHotPicGetHotWordsItemType.KSEARCH.ordinal()));
        }
        return arrayList;
    }

    private com.tencent.qqnt.msg.data.g getPicExtBizInfo(EmotionSearchItem emotionSearchItem) {
        if (emotionSearchItem == null || TextUtils.isEmpty(emotionSearchItem.appid) || !TextUtils.isDigitsOnly(emotionSearchItem.appid)) {
            return null;
        }
        int parseInt = Integer.parseInt(emotionSearchItem.appid);
        com.tencent.qqnt.msg.data.g gVar = new com.tencent.qqnt.msg.data.g();
        gVar.h(new EmojiMall(parseInt, 0));
        gVar.j(1);
        return gVar;
    }

    private Drawable getSearchIcon() {
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.jlv);
        int dip2px = ViewUtils.dip2px(16.0f);
        drawable.setBounds(0, 0, dip2px, dip2px);
        return drawable;
    }

    private void initEmotionDaTongReportHelper() {
        EmotionDaTongReportHelper emotionDaTongReportHelper = new EmotionDaTongReportHelper(getContext());
        this.mEmotionDaTongReportHelper = emotionDaTongReportHelper;
        emotionDaTongReportHelper.initPage(EmotionDaTongReportUtil.PG_BAS_HEAT_MAP);
        ArrayList arrayList = new ArrayList();
        arrayList.add(EmotionDaTongReportUtil.EM_BAS_EXPRESSION_SEARCH_BOX);
        arrayList.add(EmotionDaTongReportUtil.EM_BAS_WORD_MODULE);
        arrayList.add(EmotionDaTongReportUtil.EM_BAS_SEARCH_FOR_RECOMMENDATION_WORDS);
        arrayList.add(EmotionDaTongReportUtil.EM_BAS_EMOTICON_SEARCH_RESULTS);
        this.mEmotionDaTongReportHelper.initElement(arrayList);
    }

    private void initSearchEmotionDaTongReportHelper(String str) {
        this.mSearchEmotionDaTongReportHelper = new EmotionDaTongReportHelper(getContext());
        HashMap hashMap = new HashMap();
        hashMap.put("query", str);
        hashMap.put("traceid", "traceid");
        this.mSearchEmotionDaTongReportHelper.initPage(EmotionDaTongReportUtil.PG_BAS_EMOJI_SEARCH_RESULTS, hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add(EmotionDaTongReportUtil.EM_BAS_EMOTICON_SEARCH_RESULTS);
        this.mSearchEmotionDaTongReportHelper.initElement(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getHotPicTags$2(ArrayList arrayList) {
        this.mEmoticonTags = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendHotPic$0() {
        QQToast.makeText(BaseApplication.getContext(), R.string.fkh, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendHotPic$1(String str, int i3, EmotionSearchItem emotionSearchItem) {
        ((EmoticonPanelController) this.mPanelController).getParams().ntAioContext.e().h(new AIOMsgSendEvent.PicEmotionSendEvent(str, i3, null, getPicExtBizInfo(emotionSearchItem), emotionSearchItem.originalMD5));
    }

    public static boolean needSwitchToTab() {
        return sNeedSwitchToTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void sendHotPic(@NonNull EmoticonInfo emoticonInfo) {
        Pair<Integer, Integer> pair;
        final String str;
        if (((EmoticonPanelController) this.mPanelController).getParams().sessionType == 10014) {
            T t16 = this.mPanelController;
            if (((EmoticonPanelController) t16).callback != null) {
                ((EmoticonPanelController) t16).callback.send(emoticonInfo);
                return;
            } else {
                QLog.i(TAG, 1, "sendHotPic mPanelController.callback is null");
                return;
            }
        }
        final int i3 = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isHotPicFromSearchType(emoticonInfo) ? 13 : 2;
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emoticonInfo;
        final EmotionSearchItem emotionSearchItem = hotPicSearchEmoticonInfo.mSearchItem;
        File diskFile = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(emotionSearchItem.originalUrl);
        if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
            String absolutePath = diskFile.getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "senHotPic, urlHotPicOriginal = " + emotionSearchItem.originalUrl + ", paths = " + absolutePath);
            }
            str = absolutePath;
            pair = new Pair<>(Integer.valueOf(emotionSearchItem.originalWidth), Integer.valueOf(emotionSearchItem.originalHeight));
        } else {
            if (((IHotPicPageApi) QRoute.api(IHotPicPageApi.class)).checkAndDownLoadHotPic(emotionSearchItem) == 0) {
                File diskFile2 = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(emotionSearchItem.url);
                r7 = diskFile2 != null ? diskFile2.getAbsolutePath() : null;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "senHotPic, urlHotPic = " + emotionSearchItem.url + ", paths = " + r7);
                }
            }
            pair = new Pair<>(Integer.valueOf(emotionSearchItem.width), Integer.valueOf(emotionSearchItem.height));
            str = r7;
        }
        if (str == null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.p
                @Override // java.lang.Runnable
                public final void run() {
                    EmoticonPanelHotPicSearchHelper.lambda$sendHotPic$0();
                }
            });
            return;
        }
        Context context = getContext();
        if (!(context instanceof FragmentActivity)) {
            QLog.i(TAG, 1, "sendHotPic context is not FragmentActivity, return");
            return;
        }
        if (((EmoticonPanelController) this.mPanelController).getParams().ntAioContext == null) {
            QLog.i(TAG, 1, "sendHotPic ntAioContext is null, return");
            return;
        }
        if (emotionSearchItem.emojiType == EmojiHotPicEmojiType.KMALL.ordinal()) {
            if (emotionSearchItem.mallEmojiInfo != null) {
                IEmoticonMarketFace iEmoticonMarketFace = (IEmoticonMarketFace) QRoute.api(IEmoticonMarketFace.class);
                com.tencent.aio.api.runtime.a aVar = ((EmoticonPanelController) this.mPanelController).getParams().ntAioContext;
                EmojiHotPicSearchTextMallEmojiInfo emojiHotPicSearchTextMallEmojiInfo = emotionSearchItem.mallEmojiInfo;
                iEmoticonMarketFace.sendMarketFace(aVar, emojiHotPicSearchTextMallEmojiInfo.mallEmojiPackId, emojiHotPicSearchTextMallEmojiInfo.mallEmojiPicId);
                return;
            }
            QLog.i(TAG, 1, "is mall emoticon but info is null");
            return;
        }
        if (emotionSearchItem.textComposeInfo != null) {
            if (TextUtils.isEmpty(hotPicSearchEmoticonInfo.mSearchWord)) {
                QLog.i(TAG, 1, "sendHotPic  is not HotPicSearchEmoticonInfo, return");
                return;
            }
            Typeface typeface = SearchEmoUtil.INSTANCE.getTypeface();
            if (typeface == null) {
                QLog.i(TAG, 1, "sendHotPic  typeface is null, return");
                return;
            } else {
                ((IEmotionSearchDialogUtil) QRoute.api(IEmotionSearchDialogUtil.class)).sendCompositePic((FragmentActivity) context, emotionSearchItem, hotPicSearchEmoticonInfo.mSearchWord, str, pair, i3, typeface);
                return;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.q
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonPanelHotPicSearchHelper.this.lambda$sendHotPic$1(str, i3, emotionSearchItem);
            }
        });
    }

    public static void setNeedSwitchToTab(boolean z16) {
        sNeedSwitchToTab = z16;
    }

    public void addHeaderAndFooterView(EmotionPanelListView emotionPanelListView, BaseEmotionAdapter baseEmotionAdapter, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, emotionPanelListView, baseEmotionAdapter, Integer.valueOf(i3));
            return;
        }
        if (emotionPanelListView != null && i3 == 14) {
            attach(emotionPanelListView, baseEmotionAdapter);
            addHeader(emotionPanelListView);
            View footerView = getFooterView();
            if (footerView.getParent() == null) {
                emotionPanelListView.addFooterView(footerView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attach(ListView listView, BaseEmotionAdapter baseEmotionAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listView, (Object) baseEmotionAdapter);
        } else {
            this.mListView = listView;
            this.mSearchAdapter = baseEmotionAdapter;
        }
    }

    protected void clearReportedMD5List() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        BaseEmotionAdapter baseEmotionAdapter = this.mSearchAdapter;
        if (baseEmotionAdapter instanceof EmotionHotPicSearchAdapter) {
            ((EmotionHotPicSearchAdapter) baseEmotionAdapter).clearReportedMD5List();
        }
    }

    public void clearSearchWords() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
        } else {
            sSearchWord = null;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.IHotTagsCallback
    public void clickTag(@androidx.annotation.NonNull EmojiHotPicHotWordsItem emojiHotPicHotWordsItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) emojiHotPicHotWordsItem);
        } else {
            popUpSearchDialog(emojiHotPicHotWordsItem.word, 2);
        }
    }

    protected int dip2px(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, i3)).intValue();
        }
        return ViewUtils.dip2px(i3);
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (Context) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        T t16 = this.mPanelController;
        if (t16 == 0) {
            return BaseApplication.getContext();
        }
        return ((EmoticonPanelController) t16).context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFooterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (this.mFooterView == null) {
            View inflate = View.inflate(getContext(), R.layout.h8_, null);
            this.mFooterView = inflate;
            inflate.setBackgroundColor(0);
            this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dip2px(74.0f)));
        }
        notifyFooterViewChange();
        return this.mFooterView;
    }

    protected void getHotPicTagsData(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, IEmotionSearchManagerService.b bVar) {
        String str;
        long j3;
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) qQEmoticonMainPanelApp, (Object) bVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getHotPicTagsData ");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getHotPicTagsData is error! appRuntime is invalid!");
            return;
        }
        EmotionSearchManagerServiceProxy emotionSearchManagerServiceProxy = (EmotionSearchManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmotionSearchManagerService.class);
        AIOContact aioContact = emotionSearchManagerServiceProxy.getAioContact(getContext());
        long longAccountUin = peekAppRuntime.getLongAccountUin();
        int ordinal = EmojiHotPicGetHotWordsSceneType.KHOTPICPANEL.ordinal();
        int aioType = emotionSearchManagerServiceProxy.getAioType(aioContact.e());
        if (emotionSearchManagerServiceProxy.isC2COrTempChat(aioContact.e())) {
            str = aioContact.j();
        } else {
            str = "";
        }
        String str2 = str;
        if (emotionSearchManagerServiceProxy.isGroupOrGuildGroup(aioContact.e())) {
            j3 = com.tencent.open.agent.util.o.c(aioContact.j());
        } else {
            j3 = 0;
        }
        if (emotionSearchManagerServiceProxy.isGuildOrGuildGroup(aioContact.e())) {
            j16 = com.tencent.open.agent.util.o.c(aioContact.f());
        } else {
            j16 = 0;
        }
        if (aioContact.e() == 4) {
            j17 = com.tencent.open.agent.util.o.c(aioContact.j());
        } else {
            j17 = 0;
        }
        emotionSearchManagerServiceProxy.getHotPicTagsData(new EmojiHotPicGetHotWordsReqBody(longAccountUin, 0, 0, ordinal, aioType, str2, j3, j16, j17, ""), bVar);
    }

    public int getPageType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return 1;
    }

    public String getSearchWord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return sSearchWord;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initBefore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mInteractionListener = ((EmoticonPanelController) this.mPanelController).mInteractionListener;
        }
    }

    protected void initHeader(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        EmotionDaTongReportUtil.INSTANCE.reportPageIn(view, EmotionDaTongReportUtil.PG_BAS_HEAT_MAP);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.ye8);
        this.mLayoutEmoticonSearch = viewGroup;
        dtBindViewReport(viewGroup, EmotionDaTongReportUtil.EM_BAS_EXPRESSION_SEARCH_BOX);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f790448p);
        this.mRvKeyword = recyclerView;
        dtBindViewReport(recyclerView, EmotionDaTongReportUtil.EM_BAS_WORD_MODULE);
        this.mLayoutEmoticonSearch.setOnClickListener(this);
        ((TextView) view.findViewById(R.id.ute)).setCompoundDrawables(getSearchIcon(), null, null, null);
        setSearchContainerVisibility(sSearchVisibility);
        this.mRvKeyword.setAdapter(new SearchTagAdapter(getHotPicTags(), false, this));
        this.mRvKeyword.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mRvKeyword.addItemDecoration(new SpaceHorizontalItemDecoration(ViewUtils.dip2px(6.0f)));
    }

    protected void initListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        ListView listView = this.mListView;
        if (listView == null) {
            return;
        }
        listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelHotPicSearchHelper.this);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i3) {
                EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) absListView, i3);
                    return;
                }
                if (i3 != 0 && i3 != 2) {
                    AbstractGifImage.pauseAll();
                } else {
                    AbstractGifImage.resumeAll();
                }
                EmoticonPanelHotPicSearchHelper.this.mLastScrollState = i3;
            }
        });
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new int[]{8, 4, 5, 3, 1, 13};
    }

    protected boolean isInEmoticonSearchPanel() {
        T t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (getPageType() == 1 && (t16 = this.mPanelController) != 0 && ((EmoticonPanelController) t16).findIndexByPanelType(12) == BasePanelModel.sLastSelectedSecondTabIndex) {
            return true;
        }
        return false;
    }

    protected boolean isInRichTextSearchPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        int c16 = com.tencent.mobileqq.core.util.b.c(getContext(), getApp().getCurrentAccountUin());
        if (getPageType() == 2 && c16 == ((IEmosmService) QRoute.api(IEmosmService.class)).getRichTextChatManagerEmoSearchConfig()) {
            return true;
        }
        return false;
    }

    public boolean isInSearchPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        return !StringUtil.isEmpty(getSearchWord());
    }

    @Override // com.tencent.mobileqq.emosm.p
    public void loadHotPicData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        setLoadingStatus(0);
        sNeedPullUp = false;
        sPrepareSearch = false;
        clearReportedMD5List();
        clearSearchWords();
        notifyFooterViewChange();
        notifyHeaderViewChange();
        updateLoadingView();
        updateAllTabs();
        pushEmotionSearchTask(getApp(), new IEmotionSearchManagerService.EmotionSearchTask(0), this);
    }

    public void loadPicData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "start loadPicData word is null: " + TextUtils.isEmpty(getSearchWord()) + " sPrepareSearch: " + sPrepareSearch);
        }
        if (TextUtils.isEmpty(getSearchWord())) {
            loadHotPicData();
            return;
        }
        if (!sPrepareSearch) {
            onSearchPullUp();
            loadSearchPicData();
        } else if (this.mLoadingStatus != 5) {
            setLoadingStatus(5);
            notifyHeaderViewChange();
            notifyFooterViewChange();
            updateLoadingView();
            onSearchPullUp();
        }
    }

    public void loadSearchPicData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(getSearchWord())) {
            return;
        }
        if (isInSearchPage() && isInEmoticonSearchPanel()) {
            ReportController.o(null, "dc00898", "", "", EmoticonOperateReport.REPORT_TAG_0X800AE2A, EmoticonOperateReport.REPORT_TAG_0X800AE2A, 0, 0, "", "", "", getSearchWord());
        }
        sNeedPullUp = false;
        sPrepareSearch = false;
        clearReportedMD5List();
        setLoadingStatus(5);
        notifyFooterViewChange();
        notifyHeaderViewChange();
        updateAllTabs();
        updateLoadingView();
        pushEmotionSearchTask(getApp(), new IEmotionSearchManagerService.EmotionSearchTask(1, getSearchWord()), this);
    }

    protected void notifyFooterViewChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (this.mFooterView != null && this.mInteractionListener != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyFooterViewChange.");
            }
            TextView textView = (TextView) this.mFooterView.findViewById(R.id.d98);
            textView.setTextSize(12.0f);
            View findViewById = this.mFooterView.findViewById(R.id.d97);
            TextView textView2 = (TextView) this.mFooterView.findViewById(R.id.efo);
            textView2.setTextSize(12.0f);
            textView.setOnClickListener(this);
            ViewGroup.LayoutParams layoutParams = this.mFooterView.getLayoutParams();
            int dip2px = dip2px(74);
            if (layoutParams.height != dip2px) {
                layoutParams.height = dip2px;
                this.mFooterView.setLayoutParams(layoutParams);
            }
            int i3 = this.mLoadingStatus;
            if (i3 != 1 && i3 != 0) {
                if (i3 == 7) {
                    textView.setVisibility(0);
                    textView.setText(R.string.yq6);
                    findViewById.setVisibility(4);
                    reportRequestErrorExposed();
                    return;
                }
                if (i3 != 2 && (i3 != 4 || dip2px(XPanelContainer.o()) < XPanelContainer.f384714h0 || !TAG.equals(getTag()))) {
                    textView.setVisibility(8);
                    findViewById.setVisibility(8);
                    layoutParams.height = -2;
                    this.mFooterView.setLayoutParams(layoutParams);
                    return;
                }
                textView.setVisibility(0);
                textView.setText(R.string.yq7);
                findViewById.setVisibility(4);
                reportRequestErrorExposed();
                return;
            }
            findViewById.setVisibility(0);
            textView2.setText(R.string.f170217yq2);
            textView.setVisibility(4);
            reportLoading();
        }
    }

    protected void notifyHeaderViewChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.mHeaderView == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "notifyHeaderViewChange loadingStatus:" + this.mLoadingStatus);
        }
        setSearchContainerVisibility(sSearchVisibility);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.afr) {
                clearSearchWords();
                onPullDown();
                loadHotPicData();
                report(EmoticonOperateReport.REPORT_TAG_0X800AE30, 0);
            } else if (id5 == R.id.d98) {
                if (this.mLoadingStatus == 4) {
                    loadPicData();
                    reportNetworkErrorClickEvent();
                } else {
                    setLoadingStatus(1);
                    notifyFooterViewChange();
                    onLoadMore();
                }
            } else if (id5 == R.id.usk) {
                loadPicData();
                reportNetworkErrorClickEvent();
            } else if (id5 == R.id.ye8) {
                popUpSearchDialog(((EmoticonPanelExtendHelper) ((EmoticonPanelController) this.mPanelController).getHelper(1)).getInputText(), 2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "onDestory.");
        }
        clearReportedMD5List();
        clearSearchWords();
        resetEmoticonSearch();
        sSearchVisibility = 0;
        sPrepareSearch = false;
        this.mLoadMore = false;
        this.mSearchAdapter = null;
        this.mListView = null;
        this.mEmoticonTags = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: onHandleResult, reason: merged with bridge method [inline-methods] */
    public void lambda$onSearchCallBack$3(IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) emotionSearchResult);
            return;
        }
        if (this.mSearchAdapter != null && emotionSearchResult != null) {
            if (emotionSearchResult.getResult() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onSearchCallBack success isHasMore: " + emotionSearchResult.isHasMore());
                }
                IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask = emotionSearchResult.searchTask;
                int i3 = emotionSearchTask.taskType;
                int i16 = 1;
                if (i3 == 0) {
                    BaseEmotionAdapter baseEmotionAdapter = this.mSearchAdapter;
                    if (baseEmotionAdapter instanceof EmotionHotPicSearchAdapter) {
                        ((EmotionHotPicSearchAdapter) baseEmotionAdapter).setEmotionDaTongReportHelper(this.mEmotionDaTongReportHelper);
                    }
                } else if (i3 == 1) {
                    initSearchEmotionDaTongReportHelper(emotionSearchTask.searchKeyWords);
                    EmotionDaTongReportUtil.INSTANCE.reportPageExpose(this.mSearchEmotionDaTongReportHelper);
                    BaseEmotionAdapter baseEmotionAdapter2 = this.mSearchAdapter;
                    if (baseEmotionAdapter2 instanceof EmotionHotPicSearchAdapter) {
                        ((EmotionHotPicSearchAdapter) baseEmotionAdapter2).setEmotionDaTongReportHelper(this.mSearchEmotionDaTongReportHelper);
                    }
                }
                List<EmotionSearchItem> itemList = emotionSearchResult.getItemList();
                if (itemList != null && !itemList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    this.mIsAnonymousState = ((IEmosmService) QRoute.api(IEmosmService.class)).getCurAnonymousState(this.mInteractionListener.getCurFriendUin());
                    for (EmotionSearchItem emotionSearchItem : itemList) {
                        if (emotionSearchItem != null) {
                            arrayList.add(new HotPicSearchEmoticonInfo(getPageType(), arrayList.size() + 1, getSearchWord(), emotionSearchItem));
                        }
                    }
                    int i17 = this.mLoadingStatus;
                    if (i17 == 0 || i17 == 5) {
                        initListener();
                    }
                    if (!emotionSearchResult.isHasMore()) {
                        i16 = 3;
                    }
                    setLoadingStatus(i16);
                    notifyHeaderViewChange();
                    notifyFooterViewChange();
                    this.mSearchAdapter.setData(arrayList);
                    updateLoadingView();
                } else {
                    if (isInSearchPage() && isInEmoticonSearchPanel()) {
                        EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE2B, 0);
                    }
                    setLoadingStatus(8);
                    this.mSearchAdapter.setData(new ArrayList());
                    updateLoadingView();
                    notifyHeaderViewChange();
                    notifyFooterViewChange();
                    return;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onSearchCallBack fail");
                }
                onRequestFail(emotionSearchResult);
            }
            this.mLoadMore = false;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "onHide.");
        }
        sLastShowPageType = getPageType();
        clearReportedMD5List();
        EmotionDaTongReportUtil.INSTANCE.reportPageOut(this.mListView, EmotionDaTongReportUtil.PG_BAS_HEAT_MAP);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onItemTabClick(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        T t16 = this.mPanelController;
        if (t16 == 0) {
            return;
        }
        List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) t16).getPanelDataList();
        if (panelDataList != null && i3 < panelDataList.size()) {
            if (12 == panelDataList.get(i3).type) {
                ReportController.o(null, "dc00898", "", "", "0X800C51E", "0X800C51E", 0, 0, "", "", "", "");
                return;
            } else {
                if (18 == panelDataList.get(i3).type) {
                    popUpSearchDialog(((EmoticonPanelExtendHelper) ((EmoticonPanelController) this.mPanelController).getHelper(1)).getInputText(), 1);
                    ReportController.o(null, "dc00898", "", "", "0X800C51C", "0X800C51C", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
        }
        QLog.e(TAG, 1, "onItemTabClick, panelDataList = " + panelDataList + ", position = " + i3);
    }

    protected void onLoadMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "start onLoadMore");
        }
        if (isInRichTextSearchPanel()) {
            reportEvent("0X800AE37");
        } else if (isInEmoticonSearchPanel()) {
            if (isInSearchPage()) {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE2C, 0);
            } else {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE21, 0);
            }
        }
        IEmotionSearchManagerService iEmotionSearchManagerService = (IEmotionSearchManagerService) getApp().getService(IEmotionSearchManagerService.class);
        if (iEmotionSearchManagerService == null) {
            return;
        }
        iEmotionSearchManagerService.loadMore();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        updateAllTabs();
        T t16 = this.mPanelController;
        if (t16 != 0) {
            if (BasePanelModel.sLastSelectedSecondTabIndex == ((EmoticonPanelController) t16).findIndexByPanelType(12)) {
                reportItemExposed();
            }
            if (!((EmoticonPanelController) this.mPanelController).isEmoticonOnShow(12) && needSwitchToTab()) {
                QLog.d(TAG, 4, "need switch to hot pic tab");
                if (this.mInteractionListener != null) {
                    ((IEmosmService) QRoute.api(IEmosmService.class)).showEmoticonPanel(this.mInteractionListener, 12);
                }
                setNeedSwitchToTab(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
            return;
        }
        T t16 = this.mPanelController;
        if (t16 == 0) {
            return;
        }
        ((EmoticonPanelExtendHelper) ((EmoticonPanelController) t16).getHelper(1)).onPullDown();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
            return;
        }
        T t16 = this.mPanelController;
        if (t16 == 0) {
            return;
        }
        ((EmoticonPanelExtendHelper) ((EmoticonPanelController) t16).getHelper(1)).onPullUp();
    }

    protected void onRequestFail(IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) emotionSearchResult);
            return;
        }
        int i3 = this.mLoadingStatus;
        if (i3 != 0 && i3 != 5) {
            if (emotionSearchResult.getResult() != -102 && emotionSearchResult.getResult() != -100) {
                if (emotionSearchResult.getResult() == -104) {
                    setLoadingStatus(3);
                } else {
                    setLoadingStatus(2);
                }
            } else {
                setLoadingStatus(7);
            }
        } else {
            setLoadingStatus(4);
        }
        notifyHeaderViewChange();
        updateLoadingView();
        notifyFooterViewChange();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if ((i3 != 0 || i16 != 0) && i3 + i16 >= i17 && this.mLoadingStatus == 1 && !this.mLoadMore) {
            this.mLoadMore = true;
            if ((absListView instanceof EmotionPanelListView) && this.mLastScrollState == 2) {
                ((EmotionPanelListView) absListView).abortFling();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "firstVisibleItem: " + i3 + " visibleItemCount: " + i16 + " totalItemCount: " + i17);
            }
            onLoadMore();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) absListView, i3);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.a
    public void onSearchCallBack(final IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) emotionSearchResult);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSearchCallBack ");
        }
        if (this.mSearchAdapter != null && this.mListView != null) {
            if (emotionSearchResult == null) {
                this.mLoadMore = false;
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSearchCallBack result\uff1a " + emotionSearchResult.getResult());
            }
            if (emotionSearchResult.getResult() != -101 && emotionSearchResult.getResult() != -103) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmoticonPanelHotPicSearchHelper.this.lambda$onSearchCallBack$3(emotionSearchResult);
                    }
                });
                return;
            } else {
                this.mLoadMore = false;
                return;
            }
        }
        this.mLoadMore = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSearchPullUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else if (sNeedPullUp) {
            sNeedPullUp = false;
            onPullUp();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onShow() {
        boolean z16;
        boolean z17;
        boolean curAnonymousState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "onShow ");
        }
        boolean z18 = true;
        if (isInEmoticonSearchPanel() && (curAnonymousState = ((IEmosmService) QRoute.api(IEmosmService.class)).getCurAnonymousState(this.mInteractionListener.getCurFriendUin())) != this.mIsAnonymousState) {
            this.mIsAnonymousState = curAnonymousState;
            z16 = true;
        } else {
            z16 = false;
        }
        if (sLastShowPageType == getPageType() && getPageType() != 2) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17 && ((sLastShowPageType == getPageType() || !isInEmoticonSearchPanel()) && !this.mIsClearWords)) {
            z18 = false;
        }
        if (z18 && this.mListView != null && this.mSearchAdapter != null) {
            if (TextUtils.isEmpty(getSearchWord())) {
                loadHotPicData();
            } else {
                boolean z19 = sNeedPullUp;
                onSearchPullUp();
                if (!z19) {
                    loadSearchPicData();
                }
            }
        }
        this.mIsClearWords = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "anonymousStateChanged: " + z16 + ", changeShow: " + z18);
        }
        if (!z18 && z16 && this.mSearchAdapter != null && TextUtils.isEmpty(getSearchWord())) {
            this.mSearchAdapter.setData(new ArrayList());
            loadHotPicData();
        }
        ReportController.o(null, "dc00898", "", "", "0X800C51B", "0X800C51B", 0, 0, "", "", "", "");
        ReportController.o(null, "dc00898", "", "", "0X800C51D", "0X800C51D", 0, 0, "", "", "", "");
        initEmotionDaTongReportHelper();
    }

    void popUpSearchDialog(CharSequence charSequence, int i3) {
        popUpSearchDialog(charSequence, i3, 0);
    }

    void popUpSearchWindow(String str, boolean z16) {
        if (z16) {
            if (!TextUtils.isEmpty(str)) {
                ((IEmosmService) QRoute.api(IEmosmService.class)).showSearchEmoticonPanel(this.mInteractionListener, str, false);
                return;
            }
            return;
        }
        ((IEmosmService) QRoute.api(IEmosmService.class)).showSearchEmoticonPanel(this.mInteractionListener, str, false);
    }

    public void prepareSearch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
        } else {
            sPrepareSearch = true;
            setLoadingStatus(5);
        }
    }

    protected void pushEmotionSearchTask(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask, IEmotionSearchManagerService.a aVar) {
        String str;
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, qQEmoticonMainPanelApp, emotionSearchTask, aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pushEmotionSearchTask ");
        }
        EmotionSearchManagerServiceProxy emotionSearchManagerServiceProxy = (EmotionSearchManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmotionSearchManagerService.class);
        emotionSearchManagerServiceProxy.resetData();
        emotionSearchManagerServiceProxy.setSearchCallBack(aVar);
        emotionSearchTask.setFirstTimePullCount(32);
        emotionSearchTask.sceneType = EmojiHotPicSearchSceneType.KHOTPICPANEL.ordinal();
        int chatType = emotionSearchManagerServiceProxy.getChatType(getContext());
        emotionSearchTask.chatType = chatType;
        emotionSearchTask.aioType = emotionSearchManagerServiceProxy.getAioType(chatType);
        AIOContact aioContact = emotionSearchManagerServiceProxy.getAioContact(getContext());
        if (emotionSearchManagerServiceProxy.isC2COrTempChat(aioContact.e())) {
            str = aioContact.j();
        } else {
            str = "";
        }
        emotionSearchTask.guestUid = str;
        long j17 = 0;
        if (emotionSearchManagerServiceProxy.isGroupOrGuildGroup(aioContact.e())) {
            j3 = com.tencent.open.agent.util.o.c(aioContact.j());
        } else {
            j3 = 0;
        }
        emotionSearchTask.groupCode = j3;
        if (emotionSearchManagerServiceProxy.isGuildOrGuildGroup(aioContact.e())) {
            j16 = com.tencent.open.agent.util.o.c(aioContact.f());
        } else {
            j16 = 0;
        }
        emotionSearchTask.guildId = j16;
        if (aioContact.e() == 4) {
            j17 = com.tencent.open.agent.util.o.c(aioContact.j());
        }
        emotionSearchTask.channelId = j17;
        emotionSearchManagerServiceProxy.pushEmotionSearchTask(emotionSearchTask);
    }

    public void removeHeaderAndFooterView(EmotionPanelListView emotionPanelListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) emotionPanelListView);
            return;
        }
        View view = this.mHeaderView;
        if (view != null) {
            emotionPanelListView.removeHeaderView(view);
        }
        View view2 = this.mFooterView;
        if (view2 != null) {
            emotionPanelListView.removeFooterView(view2);
        }
    }

    protected void report(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) str, i3);
        } else {
            EmoticonUtils.report(str, i3);
        }
    }

    protected void reportClickEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        } else {
            ReportController.o(getApp().getQQAppInterface(), "dc00898", "", "", str, str, 0, 0, "2", "", "", "");
        }
    }

    protected void reportEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        } else {
            ReportController.o(getApp().getQQAppInterface(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.emosm.emosearch.c
    public void reportItemExposed() {
        ListView listView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
            return;
        }
        BaseEmotionAdapter baseEmotionAdapter = this.mSearchAdapter;
        if (baseEmotionAdapter != null && (listView = this.mListView) != null && (baseEmotionAdapter instanceof EmotionHotPicSearchAdapter)) {
            ((EmotionHotPicSearchAdapter) this.mSearchAdapter).reportDefaultExposeEvent(listView.getFirstVisiblePosition(), this.mListView.getLastVisiblePosition(), this.mListView.getHeaderViewsCount());
        }
    }

    protected void reportLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
            return;
        }
        if (isInEmoticonSearchPanel()) {
            if (isInSearchPage()) {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE31, 0);
                return;
            } else {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE22, 0);
                return;
            }
        }
        if (isInRichTextSearchPanel()) {
            reportEvent("0X800AE38");
        }
    }

    protected void reportNetworkErrorClickEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        if (isInRichTextSearchPanel()) {
            reportEvent("0X800AE3A");
        } else if (isInEmoticonSearchPanel()) {
            if (isInSearchPage()) {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE33, 0);
            } else {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE24, 0);
            }
        }
    }

    protected void reportRequestErrorExposed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (isInRichTextSearchPanel()) {
            reportEvent("0X800AE39");
        } else if (isInEmoticonSearchPanel()) {
            if (isInSearchPage()) {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE32, 0);
            } else {
                EmoticonUtils.report(EmoticonOperateReport.REPORT_TAG_0X800AE23, 0);
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.emosearch.c
    public void resetEmoticonSearch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        IEmotionSearchManagerService iEmotionSearchManagerService = (IEmotionSearchManagerService) getApp().getService(IEmotionSearchManagerService.class);
        if (iEmotionSearchManagerService == null) {
            return;
        }
        iEmotionSearchManagerService.resetData();
    }

    @Override // com.tencent.mobileqq.emosm.emosearch.c
    public void setEmptyView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
        } else {
            this.mLoadingEmptyView = view;
        }
    }

    @Override // com.tencent.mobileqq.emosm.emosearch.c
    public void setLoadingStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.mLoadingStatus = i3;
        }
    }

    public void setNeedPullUp(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            sNeedPullUp = z16;
        }
    }

    public void setSearchContainerVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel() && sSearchVisibility != i3) {
            QLog.d(TAG, 4, "setSearchContainerVisibility visibility= " + i3 + " mLoadingStatus: " + this.mLoadingStatus);
        }
        sSearchVisibility = i3;
    }

    public void setSearchWords(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
            return;
        }
        sSearchWord = str;
        if (sNeedPullUp) {
            notifyHeaderViewChange();
        }
    }

    @Override // com.tencent.mobileqq.emosm.emosearch.c
    public void startSearch(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) str);
            return;
        }
        sPrepareSearch = false;
        if (!TextUtils.isEmpty(str) && this.mSearchAdapter != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "startSearch.");
            }
            setSearchWords(str);
            this.mSearchAdapter.setData(new ArrayList());
            loadSearchPicData();
            onPullUp();
        }
    }

    protected void updateAllTabs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        if (this.mPanelController == 0) {
            return;
        }
        if (isInEmoticonSearchPanel() && !TextUtils.isEmpty(getSearchWord())) {
            ((EmoticonPanelController) this.mPanelController).hideAllTabs();
            ((EmoticonPanelController) this.mPanelController).getViewPager().setLeftScrollDisEnable(true);
            ((EmoticonPanelController) this.mPanelController).getViewPager().setRightScrollDisEnable(true);
        } else {
            ((EmoticonPanelController) this.mPanelController).showAllTabs();
            ((EmoticonPanelController) this.mPanelController).mPanelTabSortHelper.updateViewPagerScrollEnable(BasePanelModel.sLastSelectedSecondTabIndex);
        }
    }

    protected boolean updateEmptyViewLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (TAG.equals(getTag())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLoadingEmptyView.getLayoutParams();
            if (layoutParams == null) {
                return true;
            }
            int i3 = layoutParams.topMargin;
            int dip2px = ViewUtils.dip2px(60.0f);
            layoutParams.topMargin = dip2px;
            if (dip2px != i3) {
                this.mLoadingEmptyView.setLayoutParams(layoutParams);
                return false;
            }
            return false;
        }
        return false;
    }

    protected void updateLoadingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this.mListView != null && this.mLoadingEmptyView != null && this.mInteractionListener != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateLoadingView.");
            }
            if (updateEmptyViewLayoutParams()) {
                return;
            }
            TextView textView = (TextView) this.mLoadingEmptyView.findViewById(R.id.usk);
            View findViewById = this.mLoadingEmptyView.findViewById(R.id.usl);
            this.mLoadingEmptyView.setVisibility(0);
            if (this.mLoadingStatus == 4 && (ViewUtils.dip2px(XPanelContainer.o()) < XPanelContainer.f384714h0 || getPageType() == 2)) {
                findViewById.setVisibility(8);
                textView.setText(R.string.yq7);
                textView.setOnClickListener(this);
                reportRequestErrorExposed();
                return;
            }
            int i3 = this.mLoadingStatus;
            if (i3 == 5) {
                findViewById.setVisibility(0);
                textView.setText(R.string.f170217yq2);
                reportLoading();
            } else if (i3 == 8) {
                findViewById.setVisibility(8);
                textView.setText(R.string.yq5);
            } else {
                this.mLoadingEmptyView.setVisibility(8);
            }
        }
    }

    @Override // 
    public QQEmoticonMainPanelApp getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (QQEmoticonMainPanelApp) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        T t16 = this.mPanelController;
        if (t16 == 0) {
            return new QQEmoticonMainPanelApp(MobileQQ.sMobileQQ.waitAppRuntime(null));
        }
        return ((EmoticonPanelController) t16).app;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popUpSearchDialog(CharSequence charSequence, int i3, int i16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISearchEmoticonMgrApi) QRoute.api(ISearchEmoticonMgrApi.class)).showSearchEmoticonDialog(getContext(), peekAppRuntime, new AnonymousClass1(), charSequence, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements IEmoticonEventCallback {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonPanelHotPicSearchHelper.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendEmotion$0(EmoticonInfo emoticonInfo) {
            EmoticonPanelHotPicSearchHelper.this.sendHotPic(emoticonInfo);
        }

        @Override // com.tencent.mobileqq.emoticonview.searchemo.IEmoticonEventCallback
        public void sendEmotion(@androidx.annotation.NonNull final EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonInfo);
                return;
            }
            if (!((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isHotPicType(emoticonInfo)) {
                QLog.i(EmoticonPanelHotPicSearchHelper.TAG, 1, "emotionInfo is not HotPicType, return");
            } else if (!(emoticonInfo instanceof HotPicSearchEmoticonInfo)) {
                QLog.i(EmoticonPanelHotPicSearchHelper.TAG, 1, "is not HotPicSearchEmoticonInfo, return");
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmoticonPanelHotPicSearchHelper.AnonymousClass1.this.lambda$sendEmotion$0(emoticonInfo);
                    }
                }, 16, null, false);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.searchemo.IEmoticonEventCallback
        public void showPanel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            Context context = EmoticonPanelHotPicSearchHelper.this.getContext();
            if (context instanceof FragmentActivity) {
                com.tencent.qqnt.aio.utils.c.f352293a.b((FragmentActivity) context, "", new PanelContainerMsgIntent.ShowPanelMsgIntent("SearchEmotionDialog", 1001, true));
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.searchemo.IEmoticonEventCallback
        public void sendEmotion(int i3, @androidx.annotation.NonNull HotPicInfo hotPicInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                EmoticonPanelHotPicSearchHelper.this.sendHotPic(i3, hotPicInfo);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) hotPicInfo);
            }
        }
    }

    public EmoticonPanelHotPicSearchHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPanelController);
            return;
        }
        this.mLoadingStatus = 0;
        this.mLoadMore = false;
        this.mLastScrollState = 0;
        this.mIsClearWords = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void sendHotPic(int i3, @NonNull HotPicInfo hotPicInfo) {
        if (((EmoticonPanelController) this.mPanelController).callback == null) {
            QLog.i(TAG, 1, "sendHotPic mPanelController.callback is null");
            return;
        }
        ((EmoticonPanelController) this.mPanelController).callback.send(new HotPicSearchEmoticonInfo(getPageType(), i3 + 1, null, com.tencent.mobileqq.util.an.f306578a.b(hotPicInfo)));
    }
}
