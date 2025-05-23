package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IPopupEmotionSearchManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonTabNtUtils;
import com.tencent.mobileqq.emoticonview.SearchHotPicAdapter;
import com.tencent.mobileqq.emoticonview.SearchOprAdapter;
import com.tencent.mobileqq.emoticonview.SearchTagAdapter;
import com.tencent.mobileqq.emoticonview.SearchTagTitleAdapter;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsEmoRuntimeServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.PopupEmotionSearchManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.agent.util.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsItemType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsSceneType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicHotWordsItem;
import com.tencent.qqnt.kernel.nativeinterface.HotPicInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetHotPicInfoListCallback;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b(*\u0002\f)\u0018\u0000 a2\u00020\u0001:\u0004abcdB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J\u0019\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108J#\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001062\b\u00103\u001a\u0004\u0018\u000104H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020=J\b\u0010>\u001a\u000202H\u0002J\b\u0010?\u001a\u000202H\u0002J\b\u0010@\u001a\u000202H\u0014J\u0006\u0010A\u001a\u000202J\u0006\u0010B\u001a\u000202J\u0018\u0010C\u001a\u0002022\u0006\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\tH\u0002J\u000e\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020\tJ\u0010\u0010H\u001a\u0002022\b\u0010I\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010J\u001a\u0002022\u0006\u0010K\u001a\u00020\u0011J\u0010\u0010L\u001a\u0002022\b\u0010M\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020\u001aJ\u0016\u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\tJ\u0016\u0010S\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\tJ\u001a\u0010T\u001a\u0002022\b\u0010U\u001a\u0004\u0018\u00010\u00162\u0006\u0010V\u001a\u00020\u001aH\u0002J0\u0010W\u001a\u0002022\u0006\u0010X\u001a\u00020\u001a2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001062\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000106H\u0002J\u0010\u0010[\u001a\u0002022\u0006\u0010V\u001a\u00020\u001aH\u0002J\u000e\u0010\\\u001a\u0002022\u0006\u0010]\u001a\u00020\u001aJ\u000e\u0010^\u001a\u0002022\u0006\u0010V\u001a\u00020\u001aJ\u000e\u0010_\u001a\u0002022\u0006\u0010`\u001a\u00020=R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010*R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hotTagsCallback", "com/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$hotTagsCallback$1", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$hotTagsCallback$1;", "mCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$HeaderViewCb;", "mEmoticonCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "mEmotionCancelIcon", "Landroid/widget/Button;", "mEmotionInputRoot", "mEmotionSearchInput", "Landroid/widget/EditText;", "mEmotionSearchTabBar", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "mFinishInit", "", "mFirstShown", "mHotTagsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mInfoAndActionCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;", "mInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "mSearchClearIv", "Landroid/widget/ImageView;", "mSearchTagAdapter", "Lcom/tencent/mobileqq/emoticonview/SearchTagAdapter;", "mShowComposite", "Ljava/lang/Boolean;", "oprCallback", "com/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$oprCallback$1", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$oprCallback$1;", "searchIcon", "Landroid/graphics/drawable/Drawable;", "getSearchIcon", "()Landroid/graphics/drawable/Drawable;", "getCurAccountNick", "", "getDefaultPageData", "", "mainPanelApp", "Lcom/tencent/mobileqq/emoticonview/ipc/QQEmoticonMainPanelApp;", "getHotPicList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/HotPicInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHotTagList", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicHotWordsItem;", "(Lcom/tencent/mobileqq/emoticonview/ipc/QQEmoticonMainPanelApp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchWords", "", "init", "notifyInitFinish", NodeProps.ON_ATTACHED_TO_WINDOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onShow", "reportTabBtn", "eventId", "tabType", "selectTab", "index", IECSearchBar.METHOD_SET_CALLBACK, "headerViewCb", "setEmotionEventCallback", "emoticonCallback", "setInfoAndActionCb", "infoAndActionCb", "setShowComposite", "showComposite", "touchInHeaderViewArea", HippyTKDListViewAdapter.X, "y", "touchInHeaderViewInputArea", "updateCursor", "editText", "show", "updateDefaultPage", "newStyle", "hotPicList", "hotTagList", "updateHeaderVisibility", "updateSearchInputFocus", "needFocus", "updateSearchTabBarVisibility", "updateSearchWords", "searchWords", "Companion", "HeaderViewCb", "InputEditorActionListener", "InputTextWatcher", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchEmoHeaderView extends RelativeLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int COMPOSITE_TAB_INDEX = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int RECOMMEND_TAB_INDEX = 0;
    private static final int SPAN_COUNT_TAG = 2;

    @NotNull
    private static final String TAG = "SearchEmoHeaderView";

    @NotNull
    private final SearchEmoHeaderView$hotTagsCallback$1 hotTagsCallback;

    @Nullable
    private HeaderViewCb mCallback;

    @Nullable
    private IEmoticonEventCallback mEmoticonCallback;

    @Nullable
    private Button mEmotionCancelIcon;

    @Nullable
    private RelativeLayout mEmotionInputRoot;

    @Nullable
    private EditText mEmotionSearchInput;

    @Nullable
    private QUIPageTabBar mEmotionSearchTabBar;
    private boolean mFinishInit;
    private boolean mFirstShown;

    @Nullable
    private RecyclerView mHotTagsRecyclerView;

    @Nullable
    private InfoAndActionCb mInfoAndActionCb;

    @Nullable
    private InputMethodManager mInputMethodManager;

    @Nullable
    private ImageView mSearchClearIv;

    @Nullable
    private SearchTagAdapter mSearchTagAdapter;

    @Nullable
    private Boolean mShowComposite;

    @NotNull
    private final SearchEmoHeaderView$oprCallback$1 oprCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$Companion;", "", "()V", "COMPOSITE_TAB_INDEX", "", "RECOMMEND_TAB_INDEX", "SPAN_COUNT_TAG", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$HeaderViewCb;", "", "enterSearchWords", "", "getEnterSearchWords", "()Ljava/lang/String;", "isInMultiWindowMode", "", "()Z", "keyboardVisible", "getKeyboardVisible", "clickCancelIcon", "", "initViewsFinish", "pageTabChanged", "position", "", "fromUserClick", "searchWordsChanged", "searchWords", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface HeaderViewCb {
        void clickCancelIcon();

        @NotNull
        String getEnterSearchWords();

        boolean getKeyboardVisible();

        void initViewsFinish();

        boolean isInMultiWindowMode();

        void pageTabChanged(int position, boolean fromUserClick);

        void searchWordsChanged(@NotNull CharSequence searchWords);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$InputEditorActionListener;", "Landroid/widget/TextView$OnEditorActionListener;", "(Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView;)V", "onEditorAction", "", "v", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public final class InputEditorActionListener implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        public InputEditorActionListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@Nullable TextView v3, int actionId, @Nullable KeyEvent event) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, v3, Integer.valueOf(actionId), event)).booleanValue();
            } else {
                if (actionId == 3) {
                    if (SearchEmoHeaderView.this.mInputMethodManager == null) {
                        SearchEmoHeaderView searchEmoHeaderView = SearchEmoHeaderView.this;
                        Object systemService = searchEmoHeaderView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        searchEmoHeaderView.mInputMethodManager = (InputMethodManager) systemService;
                    }
                    InputMethodManager inputMethodManager = SearchEmoHeaderView.this.mInputMethodManager;
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(SearchEmoHeaderView.this.getWindowToken(), 0);
                    }
                } else {
                    z17 = false;
                }
                z16 = z17;
            }
            EventCollector.getInstance().onEditorAction(v3, actionId, event);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView$InputTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoHeaderView;)V", "mBeforeText", "", "getMBeforeText", "()Ljava/lang/String;", "setMBeforeText", "(Ljava/lang/String;)V", "afterTextChanged", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public final class InputTextWatcher implements TextWatcher {
        static IPatchRedirector $redirector_;

        @Nullable
        private String mBeforeText;

        public InputTextWatcher() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) s16);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            ImageView imageView = SearchEmoHeaderView.this.mSearchClearIv;
            if (imageView != null) {
                if (TextUtils.isEmpty(s16)) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                imageView.setVisibility(i3);
            }
            SearchEmoHeaderView.this.updateHeaderVisibility(TextUtils.isEmpty(s16));
            if (Intrinsics.areEqual(SearchEmoHeaderView.this.mShowComposite, Boolean.TRUE)) {
                SearchEmoHeaderView.this.updateSearchTabBarVisibility(!TextUtils.isEmpty(s16));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
                this.mBeforeText = s16.toString();
            }
        }

        @Nullable
        public final String getMBeforeText() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mBeforeText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            HeaderViewCb headerViewCb;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            if (SearchEmoHeaderView.this.mCallback == null) {
                QLog.d(SearchEmoHeaderView.TAG, 1, "onTextChanged params illegal, return");
            } else if (!TextUtils.equals(s16, this.mBeforeText) && (headerViewCb = SearchEmoHeaderView.this.mCallback) != null) {
                headerViewCb.searchWordsChanged(s16);
            }
        }

        public final void setMBeforeText(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.mBeforeText = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22164);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$hotTagsCallback$1] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$oprCallback$1] */
    public SearchEmoHeaderView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.hotTagsCallback = new IHotTagsCallback() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$hotTagsCallback$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
                
                    r0 = r3.this$0.mEmotionSearchTabBar;
                 */
                @Override // com.tencent.mobileqq.emoticonview.searchemo.IHotTagsCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void clickTag(@NotNull EmojiHotPicHotWordsItem item) {
                    EditText editText;
                    EditText editText2;
                    EditText editText3;
                    int length;
                    QUIPageTabBar qUIPageTabBar;
                    boolean z16;
                    QUIPageTabBar qUIPageTabBar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) item);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (item.itemType == EmojiHotPicGetHotWordsItemType.KCOMPOSE.ordinal()) {
                        qUIPageTabBar = SearchEmoHeaderView.this.mEmotionSearchTabBar;
                        if (qUIPageTabBar != null && qUIPageTabBar.getCurrentPosition() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && qUIPageTabBar2 != null) {
                            qUIPageTabBar2.setCurrentPosition(1, false);
                        }
                    }
                    editText = SearchEmoHeaderView.this.mEmotionSearchInput;
                    if (editText != null) {
                        editText.setText(item.word);
                    }
                    editText2 = SearchEmoHeaderView.this.mEmotionSearchInput;
                    if (editText2 != null) {
                        if (TextUtils.isEmpty(item.word)) {
                            length = 0;
                        } else {
                            length = item.word.length();
                        }
                        editText2.setSelection(length);
                    }
                    SearchEmoHeaderView searchEmoHeaderView = SearchEmoHeaderView.this;
                    editText3 = searchEmoHeaderView.mEmotionSearchInput;
                    searchEmoHeaderView.updateCursor(editText3, false);
                }
            };
            this.oprCallback = new IOprCallback() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$oprCallback$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.IOprCallback
                public void clickEmoticonSetting() {
                    InfoAndActionCb infoAndActionCb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                        infoAndActionCb = SearchEmoHeaderView.this.mInfoAndActionCb;
                        if (infoAndActionCb != null) {
                            infoAndActionCb.clickEmoticonSetting();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.IOprCallback
                public void clickEmoticonShop() {
                    InfoAndActionCb infoAndActionCb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        infoAndActionCb = SearchEmoHeaderView.this.mInfoAndActionCb;
                        if (infoAndActionCb != null) {
                            infoAndActionCb.clickEmoticonShop();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            };
        }
    }

    private final String getCurAccountNick() {
        String str;
        ArrayList<String> arrayListOf;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUid();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf, TAG);
        if (friendSimpleInfoWithUid == null) {
            return "";
        }
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : friendSimpleInfoWithUid) {
            if (Intrinsics.areEqual(dVar.getUid(), str)) {
                String p16 = dVar.p();
                if (p16 == null) {
                    return "";
                }
                return p16;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getHotPicList(Continuation<? super List<HotPicInfo>> continuation) {
        Continuation intercepted;
        BaseQQAppInterface baseQQAppInterface;
        List emptyList;
        Object coroutine_suspended;
        List emptyList2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getHotTagList");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            QLog.e(TAG, 1, "getHotPicTagsData is error! baseQQAppInterface is invalid!");
            Result.Companion companion = Result.INSTANCE;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            safeContinuation.resumeWith(Result.m476constructorimpl(emptyList2));
        } else {
            w msgService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService == null) {
                QLog.e(TAG, 1, "getHotPicTagsData is error! msgService is null!");
                Result.Companion companion2 = Result.INSTANCE;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                safeContinuation.resumeWith(Result.m476constructorimpl(emptyList));
            } else {
                msgService.getHotPicInfoListSearchString("", "", 8, 1, false, new IGetHotPicInfoListCallback(safeContinuation) { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$getHotPicList$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Continuation<List<HotPicInfo>> $continuation;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.$continuation = safeContinuation;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) safeContinuation);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetHotPicInfoListCallback
                    public final void onGetHotPicInfoList(int i3, String str, ArrayList<HotPicInfo> arrayList) {
                        List emptyList3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                            return;
                        }
                        QLog.i("SearchEmoHeaderView", 1, "getHotPicInfoListSearchString result:" + i3 + " errMsg:" + str);
                        if (i3 == 0 && arrayList != null) {
                            this.$continuation.resumeWith(Result.m476constructorimpl(arrayList));
                            return;
                        }
                        Continuation<List<HotPicInfo>> continuation2 = this.$continuation;
                        Result.Companion companion3 = Result.INSTANCE;
                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                        continuation2.resumeWith(Result.m476constructorimpl(emptyList3));
                    }
                });
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getHotTagList(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, Continuation<? super List<EmojiHotPicHotWordsItem>> continuation) {
        Continuation intercepted;
        String str;
        long j3;
        long j16;
        long j17;
        List emptyList;
        Object coroutine_suspended;
        List emptyList2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getHotTagList");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getHotPicTagsData is error! appRuntime is invalid!");
            Result.Companion companion = Result.INSTANCE;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            safeContinuation.resumeWith(Result.m476constructorimpl(emptyList2));
        } else if (qQEmoticonMainPanelApp == null) {
            QLog.e(TAG, 1, "getHotPicTagsData is error! mMainPanelApp is null!");
            Result.Companion companion2 = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            safeContinuation.resumeWith(Result.m476constructorimpl(emptyList));
        } else {
            AbsEmoRuntimeServiceProxy<? extends IRuntimeService> runtimeService = qQEmoticonMainPanelApp.getRuntimeService(IPopupEmotionSearchManagerService.class);
            Intrinsics.checkNotNull(runtimeService, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.ipc.proxy.PopupEmotionSearchManagerServiceProxy");
            PopupEmotionSearchManagerServiceProxy popupEmotionSearchManagerServiceProxy = (PopupEmotionSearchManagerServiceProxy) runtimeService;
            AIOContact aioContact = popupEmotionSearchManagerServiceProxy.getAioContact(getContext());
            String curAccountNick = getCurAccountNick();
            long longAccountUin = peekAppRuntime.getLongAccountUin();
            int ordinal = EmojiHotPicGetHotWordsSceneType.KMAGNIFIER.ordinal();
            int aioType = popupEmotionSearchManagerServiceProxy.getAioType(aioContact.e());
            if (popupEmotionSearchManagerServiceProxy.isC2COrTempChat(aioContact.e())) {
                str = aioContact.j();
            } else {
                str = "";
            }
            String str2 = str;
            if (popupEmotionSearchManagerServiceProxy.isGroupOrGuildGroup(aioContact.e())) {
                j3 = o.c(aioContact.j());
            } else {
                j3 = 0;
            }
            if (popupEmotionSearchManagerServiceProxy.isGuildOrGuildGroup(aioContact.e())) {
                j16 = o.c(aioContact.f());
            } else {
                j16 = 0;
            }
            if (aioContact.e() == 4) {
                j17 = o.c(aioContact.j());
            } else {
                j17 = 0;
            }
            popupEmotionSearchManagerServiceProxy.getHotPicTagsData(new EmojiHotPicGetHotWordsReqBody(longAccountUin, 0, 0, ordinal, aioType, str2, j3, j16, j17, curAccountNick), new IEmotionSearchManagerService.b(safeContinuation) { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$getHotTagList$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Continuation<List<EmojiHotPicHotWordsItem>> $continuation;
                private boolean isResumed;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$continuation = safeContinuation;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) safeContinuation);
                    }
                }

                public final boolean isResumed() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    return this.isResumed;
                }

                @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.b
                public void onResult(@Nullable ArrayList<EmojiHotPicHotWordsItem> hotPicTags) {
                    List list;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) hotPicTags);
                        return;
                    }
                    if (this.isResumed) {
                        return;
                    }
                    this.isResumed = true;
                    Continuation<List<EmojiHotPicHotWordsItem>> continuation2 = this.$continuation;
                    Result.Companion companion3 = Result.INSTANCE;
                    if (hotPicTags != null) {
                        list = CollectionsKt___CollectionsKt.toList(hotPicTags);
                    } else {
                        list = null;
                    }
                    continuation2.resumeWith(Result.m476constructorimpl(list));
                }

                public final void setResumed(boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, z16);
                    } else {
                        this.isResumed = z16;
                    }
                }
            });
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final Drawable getSearchIcon() {
        Drawable drawable = getResources().getDrawable(R.drawable.jlv);
        int dip2px = ViewUtils.dip2px(18.0f);
        drawable.setBounds(0, 0, dip2px, dip2px);
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    private final void init() {
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        this.mInputMethodManager = (InputMethodManager) systemService;
        View findViewById = findViewById(R.id.utj);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        relativeLayout.setBackground(ContextCompat.getDrawable(relativeLayout.getContext(), R.drawable.jlw));
        this.mEmotionInputRoot = relativeLayout;
        View findViewById2 = findViewById(R.id.y8q);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById2;
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchEmoHeaderView.init$lambda$2$lambda$1(SearchEmoHeaderView.this, view);
            }
        });
        this.mSearchClearIv = imageView;
        View findViewById3 = findViewById(R.id.uts);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.EditText");
        final EditText editText = (EditText) findViewById3;
        editText.setCompoundDrawables(getSearchIcon(), null, null, null);
        editText.setOnEditorActionListener(new InputEditorActionListener());
        editText.addTextChangedListener(new InputTextWatcher());
        editText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchEmoHeaderView.init$lambda$5$lambda$3(SearchEmoHeaderView.this, editText, view);
            }
        });
        try {
            editText.setEditableFactory(QQTextBuilder.EMOTION_INPUT_FACTORY);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "input set error", e16);
        }
        editText.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean init$lambda$5$lambda$4;
                init$lambda$5$lambda$4 = SearchEmoHeaderView.init$lambda$5$lambda$4(editText, view, motionEvent);
                return init$lambda$5$lambda$4;
            }
        });
        EmotionDaTongReportUtil.INSTANCE.setElementId(editText, EmotionDaTongReportUtil.EM_BAS_EXPRESSION_SEARCH_BOX);
        this.mEmotionSearchInput = editText;
        HeaderViewCb headerViewCb = this.mCallback;
        if (headerViewCb != null) {
            QLog.i(TAG, 1, "isInMultiWindowMode\uff1a" + headerViewCb.isInMultiWindowMode() + ", enterSearchWords\uff1a" + headerViewCb.getEnterSearchWords());
            if (headerViewCb.isInMultiWindowMode()) {
                updateCursor(this.mEmotionSearchInput, TextUtils.isEmpty(headerViewCb.getEnterSearchWords()));
            } else {
                updateCursor(this.mEmotionSearchInput, headerViewCb.getKeyboardVisible());
            }
        }
        View findViewById4 = findViewById(R.id.utr);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById4;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchEmoHeaderView.init$lambda$8$lambda$7(SearchEmoHeaderView.this, view);
            }
        });
        this.mEmotionCancelIcon = button;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.utk);
        updateHeaderVisibility(false);
        this.mHotTagsRecyclerView = recyclerView;
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) findViewById(R.id.utl);
        qUIPageTabBar.setTabData(new String[]{qUIPageTabBar.getResources().getString(R.string.f224286ii), qUIPageTabBar.getResources().getString(R.string.f224386is)});
        qUIPageTabBar.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.emoticonview.searchemo.h
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                SearchEmoHeaderView.init$lambda$11$lambda$10(SearchEmoHeaderView.this, i3, z16);
            }
        });
        qUIPageTabBar.setVisibility(8);
        this.mEmotionSearchTabBar = qUIPageTabBar;
        this.mFinishInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$11$lambda$10(SearchEmoHeaderView this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HeaderViewCb headerViewCb = this$0.mCallback;
        if (headerViewCb != null) {
            headerViewCb.pageTabChanged(i3, z16);
        }
        if (z16) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this$0.reportTabBtn("dt_clck", 2);
                    return;
                }
                return;
            }
            this$0.reportTabBtn("dt_clck", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2$lambda$1(SearchEmoHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mEmotionSearchInput;
        if (editText != null) {
            editText.setText("");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$5$lambda$3(SearchEmoHeaderView this$0, EditText this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.updateCursor(this_apply, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r4.getAction() == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean init$lambda$5$lambda$4(EditText this_apply, View view, MotionEvent motionEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (motionEvent != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            EmotionDaTongReportUtil.reportClick$default(EmotionDaTongReportUtil.INSTANCE, this_apply, null, 2, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$8$lambda$7(SearchEmoHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HeaderViewCb headerViewCb = this$0.mCallback;
        if (headerViewCb != null) {
            headerViewCb.clickCancelIcon();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void notifyInitFinish() {
        HeaderViewCb headerViewCb = this.mCallback;
        if (headerViewCb != null) {
            headerViewCb.initViewsFinish();
        }
    }

    private final void reportTabBtn(String eventId, int tabType) {
        Map<String, Object> map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null && (map = pageInfo.pageParams) != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.remove("qq_pgid");
        linkedHashMap.put("dt_pgid", EmotionDaTongReportUtil.PG_BAS_MAGNIFYING_GLASS_EMOJI_SEARCH);
        linkedHashMap.put("dt_eid", EmotionDaTongReportUtil.EM_TAB_BTN);
        linkedHashMap.put(EmotionDaTongReportUtil.EM_PARAMS_EMOJI_TAB_TYPE, Integer.valueOf(tabType));
        VideoReport.reportEvent(eventId, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCursor(EditText editText, boolean show) {
        QLog.e(TAG, 1, "show ?" + show + ", mFinishInit:" + this.mFinishInit);
        if (editText != null) {
            editText.setCursorVisible(show);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDefaultPage(boolean newStyle, List<HotPicInfo> hotPicList, List<EmojiHotPicHotWordsItem> hotTagList) {
        Integer num;
        Integer num2;
        boolean z16;
        Editable text;
        String str = null;
        if (hotTagList != null) {
            num = Integer.valueOf(hotTagList.size());
        } else {
            num = null;
        }
        if (hotPicList != null) {
            num2 = Integer.valueOf(hotPicList.size());
        } else {
            num2 = null;
        }
        boolean z17 = true;
        QLog.i(TAG, 1, "updateDefaultPage hotTagList:" + num + ", hotPicList:" + num2);
        RecyclerView recyclerView = this.mHotTagsRecyclerView;
        if (recyclerView != null) {
            final RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RecyclerView.Adapter[0]);
            List<EmojiHotPicHotWordsItem> list = hotTagList;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                rFWConcatAdapter.addAdapter(new SearchTagTitleAdapter());
                SearchTagAdapter searchTagAdapter = new SearchTagAdapter(hotTagList, true, this.hotTagsCallback);
                this.mSearchTagAdapter = searchTagAdapter;
                rFWConcatAdapter.addAdapter(searchTagAdapter);
            }
            if (newStyle) {
                if (hotPicList != null && hotPicList.size() >= 8) {
                    rFWConcatAdapter.addAdapter(0, new SearchHotPicAdapter(hotPicList, this.mEmoticonCallback, this.mInfoAndActionCb));
                }
                rFWConcatAdapter.addAdapter(new SearchOprAdapter(true, this.oprCallback));
            } else {
                rFWConcatAdapter.addAdapter(0, new SearchOprAdapter(false, this.oprCallback));
            }
            recyclerView.setAdapter(rFWConcatAdapter);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2, 1, false);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$updateDefaultPage$1$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RFWConcatAdapter.this);
                    }
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int pos) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, pos)).intValue();
                    }
                    Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = RFWConcatAdapter.this.getWrappedAdapterAndPosition(pos);
                    Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "concatAdapter.getWrappedAdapterAndPosition(pos)");
                    if (!(wrappedAdapterAndPosition.first instanceof SearchTagAdapter)) {
                        return 2;
                    }
                    return 1;
                }
            });
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$updateDefaultPage$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int newState) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView2, newState);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    if (newState == 0) {
                        VideoReport.traversePage(recyclerView2);
                    }
                }
            });
            if (hotTagList != null) {
                Iterator<EmojiHotPicHotWordsItem> it = hotTagList.iterator();
                while (it.hasNext()) {
                    ReportController.o(null, "dc00898", "", "", "0X800C521", "0X800C521", 0, 0, "", "", it.next().word, "");
                }
            }
            EditText editText = this.mEmotionSearchInput;
            if (editText != null && (text = editText.getText()) != null) {
                str = text.toString();
            }
            if (str != null && str.length() != 0) {
                z17 = false;
            }
            updateHeaderVisibility(z17);
            EmotionDaTongReportUtil.INSTANCE.setElementId(recyclerView, EmotionDaTongReportUtil.EM_BAS_WORD_MODULE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHeaderVisibility(boolean show) {
        boolean z16;
        RecyclerView recyclerView = this.mHotTagsRecyclerView;
        boolean z17 = true;
        int i3 = 0;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && show) {
            ReportController.o(null, "dc00898", "", "", "0X800C520", "0X800C520", 0, 0, "", "", "", "");
            EmotionDaTongReportUtil.reportImp$default(EmotionDaTongReportUtil.INSTANCE, this.mHotTagsRecyclerView, null, 2, null);
        } else {
            RecyclerView recyclerView2 = this.mHotTagsRecyclerView;
            if (recyclerView2 == null || recyclerView2.getVisibility() != 8) {
                z17 = false;
            }
            if (!z17 && !show) {
                EmotionDaTongReportUtil.reportImpEnd$default(EmotionDaTongReportUtil.INSTANCE, this.mHotTagsRecyclerView, null, 2, null);
            }
        }
        RecyclerView recyclerView3 = this.mHotTagsRecyclerView;
        if (recyclerView3 != null) {
            if (!show) {
                i3 = 8;
            }
            recyclerView3.setVisibility(i3);
        }
    }

    public final void getDefaultPageData(@Nullable QQEmoticonMainPanelApp mainPanelApp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) mainPanelApp);
            return;
        }
        boolean isMergeHotPicExperiment = EmoticonTabNtUtils.INSTANCE.isMergeHotPicExperiment();
        QLog.i(TAG, 1, "getDefaultPageData  isExperiment:" + isMergeHotPicExperiment);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new SearchEmoHeaderView$getDefaultPageData$1(isMergeHotPicExperiment, this, mainPanelApp, null), 14, null);
        }
    }

    @NotNull
    public final CharSequence getSearchWords() {
        Editable editable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CharSequence) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        EditText editText = this.mEmotionSearchInput;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        if (editable == null) {
            return "";
        }
        return editable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        init();
        notifyInitFinish();
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        EmotionDaTongReportUtil emotionDaTongReportUtil = EmotionDaTongReportUtil.INSTANCE;
        EmotionDaTongReportUtil.reportImpEnd$default(emotionDaTongReportUtil, this.mEmotionSearchInput, null, 2, null);
        RecyclerView recyclerView = this.mHotTagsRecyclerView;
        boolean z16 = false;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            EmotionDaTongReportUtil.reportImpEnd$default(emotionDaTongReportUtil, this.mHotTagsRecyclerView, null, 2, null);
        }
    }

    public final void onShow() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        EditText editText = this.mEmotionSearchInput;
        boolean z17 = true;
        if (editText != null) {
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "it.text");
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                EmotionUtils.e(editText);
            }
        }
        EmotionDaTongReportUtil emotionDaTongReportUtil = EmotionDaTongReportUtil.INSTANCE;
        EmotionDaTongReportUtil.reportImp$default(emotionDaTongReportUtil, this.mEmotionSearchInput, null, 2, null);
        RecyclerView recyclerView = this.mHotTagsRecyclerView;
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            z17 = false;
        }
        if (z17) {
            EmotionDaTongReportUtil.reportImp$default(emotionDaTongReportUtil, this.mHotTagsRecyclerView, null, 2, null);
        }
    }

    public final void selectTab(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, index);
            return;
        }
        QUIPageTabBar qUIPageTabBar = this.mEmotionSearchTabBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setCurrentPosition(index, true);
        }
    }

    public final void setCallback(@Nullable HeaderViewCb headerViewCb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) headerViewCb);
        } else {
            this.mCallback = headerViewCb;
        }
    }

    public final void setEmotionEventCallback(@NotNull IEmoticonEventCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonCallback);
        } else {
            Intrinsics.checkNotNullParameter(emoticonCallback, "emoticonCallback");
            this.mEmoticonCallback = emoticonCallback;
        }
    }

    public final void setInfoAndActionCb(@Nullable InfoAndActionCb infoAndActionCb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) infoAndActionCb);
        } else {
            this.mInfoAndActionCb = infoAndActionCb;
        }
    }

    public final void setShowComposite(boolean showComposite) {
        QUIPageTabBar qUIPageTabBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, showComposite);
            return;
        }
        if (this.mShowComposite == null) {
            this.mShowComposite = Boolean.valueOf(showComposite);
            if (showComposite && (qUIPageTabBar = this.mEmotionSearchTabBar) != null) {
                qUIPageTabBar.setVisibility(0);
            }
        }
    }

    public final boolean touchInHeaderViewArea(int x16, int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(x16), Integer.valueOf(y16))).booleanValue();
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], getMeasuredWidth() + i3, iArr[1] + getMeasuredHeight()).contains(x16, y16);
    }

    public final boolean touchInHeaderViewInputArea(int x16, int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(x16), Integer.valueOf(y16))).booleanValue();
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.utj);
        if (relativeLayout == null) {
            return false;
        }
        int[] iArr = new int[2];
        relativeLayout.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], relativeLayout.getMeasuredWidth() + i3, iArr[1] + relativeLayout.getMeasuredHeight()).contains(x16, y16);
    }

    public final void updateSearchInputFocus(boolean needFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, needFocus);
            return;
        }
        if (this.mFinishInit) {
            HeaderViewCb headerViewCb = this.mCallback;
            boolean z16 = false;
            if (headerViewCb != null && headerViewCb.isInMultiWindowMode()) {
                z16 = true;
            }
            if (!z16) {
                updateCursor(this.mEmotionSearchInput, needFocus);
            }
        }
    }

    public final void updateSearchTabBarVisibility(boolean show) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, show);
            return;
        }
        QUIPageTabBar qUIPageTabBar = this.mEmotionSearchTabBar;
        if (qUIPageTabBar != null) {
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qUIPageTabBar.setVisibility(i3);
        }
        if (show && !this.mFirstShown) {
            this.mFirstShown = true;
            reportTabBtn("dt_imp", 1);
            reportTabBtn("dt_imp", 2);
        }
    }

    public final void updateSearchWords(@NotNull CharSequence searchWords) {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) searchWords);
            return;
        }
        Intrinsics.checkNotNullParameter(searchWords, "searchWords");
        EditText editText = this.mEmotionSearchInput;
        if (editText != null) {
            editText.setText(searchWords);
        }
        EditText editText2 = this.mEmotionSearchInput;
        if (editText2 != null) {
            if (TextUtils.isEmpty(searchWords)) {
                length = 0;
            } else {
                length = searchWords.length();
            }
            editText2.setSelection(length);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$hotTagsCallback$1] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$oprCallback$1] */
    public SearchEmoHeaderView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.hotTagsCallback = new IHotTagsCallback() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$hotTagsCallback$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
                
                    r0 = r3.this$0.mEmotionSearchTabBar;
                 */
                @Override // com.tencent.mobileqq.emoticonview.searchemo.IHotTagsCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void clickTag(@NotNull EmojiHotPicHotWordsItem item) {
                    EditText editText;
                    EditText editText2;
                    EditText editText3;
                    int length;
                    QUIPageTabBar qUIPageTabBar;
                    boolean z16;
                    QUIPageTabBar qUIPageTabBar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) item);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (item.itemType == EmojiHotPicGetHotWordsItemType.KCOMPOSE.ordinal()) {
                        qUIPageTabBar = SearchEmoHeaderView.this.mEmotionSearchTabBar;
                        if (qUIPageTabBar != null && qUIPageTabBar.getCurrentPosition() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && qUIPageTabBar2 != null) {
                            qUIPageTabBar2.setCurrentPosition(1, false);
                        }
                    }
                    editText = SearchEmoHeaderView.this.mEmotionSearchInput;
                    if (editText != null) {
                        editText.setText(item.word);
                    }
                    editText2 = SearchEmoHeaderView.this.mEmotionSearchInput;
                    if (editText2 != null) {
                        if (TextUtils.isEmpty(item.word)) {
                            length = 0;
                        } else {
                            length = item.word.length();
                        }
                        editText2.setSelection(length);
                    }
                    SearchEmoHeaderView searchEmoHeaderView = SearchEmoHeaderView.this;
                    editText3 = searchEmoHeaderView.mEmotionSearchInput;
                    searchEmoHeaderView.updateCursor(editText3, false);
                }
            };
            this.oprCallback = new IOprCallback() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$oprCallback$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.IOprCallback
                public void clickEmoticonSetting() {
                    InfoAndActionCb infoAndActionCb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                        infoAndActionCb = SearchEmoHeaderView.this.mInfoAndActionCb;
                        if (infoAndActionCb != null) {
                            infoAndActionCb.clickEmoticonSetting();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.IOprCallback
                public void clickEmoticonShop() {
                    InfoAndActionCb infoAndActionCb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        infoAndActionCb = SearchEmoHeaderView.this.mInfoAndActionCb;
                        if (infoAndActionCb != null) {
                            infoAndActionCb.clickEmoticonShop();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$hotTagsCallback$1] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$oprCallback$1] */
    public SearchEmoHeaderView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.hotTagsCallback = new IHotTagsCallback() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$hotTagsCallback$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
                
                    r0 = r3.this$0.mEmotionSearchTabBar;
                 */
                @Override // com.tencent.mobileqq.emoticonview.searchemo.IHotTagsCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void clickTag(@NotNull EmojiHotPicHotWordsItem item) {
                    EditText editText;
                    EditText editText2;
                    EditText editText3;
                    int length;
                    QUIPageTabBar qUIPageTabBar;
                    boolean z16;
                    QUIPageTabBar qUIPageTabBar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) item);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (item.itemType == EmojiHotPicGetHotWordsItemType.KCOMPOSE.ordinal()) {
                        qUIPageTabBar = SearchEmoHeaderView.this.mEmotionSearchTabBar;
                        if (qUIPageTabBar != null && qUIPageTabBar.getCurrentPosition() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && qUIPageTabBar2 != null) {
                            qUIPageTabBar2.setCurrentPosition(1, false);
                        }
                    }
                    editText = SearchEmoHeaderView.this.mEmotionSearchInput;
                    if (editText != null) {
                        editText.setText(item.word);
                    }
                    editText2 = SearchEmoHeaderView.this.mEmotionSearchInput;
                    if (editText2 != null) {
                        if (TextUtils.isEmpty(item.word)) {
                            length = 0;
                        } else {
                            length = item.word.length();
                        }
                        editText2.setSelection(length);
                    }
                    SearchEmoHeaderView searchEmoHeaderView = SearchEmoHeaderView.this;
                    editText3 = searchEmoHeaderView.mEmotionSearchInput;
                    searchEmoHeaderView.updateCursor(editText3, false);
                }
            };
            this.oprCallback = new IOprCallback() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$oprCallback$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoHeaderView.this);
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.IOprCallback
                public void clickEmoticonSetting() {
                    InfoAndActionCb infoAndActionCb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                        infoAndActionCb = SearchEmoHeaderView.this.mInfoAndActionCb;
                        if (infoAndActionCb != null) {
                            infoAndActionCb.clickEmoticonSetting();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                }

                @Override // com.tencent.mobileqq.emoticonview.searchemo.IOprCallback
                public void clickEmoticonShop() {
                    InfoAndActionCb infoAndActionCb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        infoAndActionCb = SearchEmoHeaderView.this.mInfoAndActionCb;
                        if (infoAndActionCb != null) {
                            infoAndActionCb.clickEmoticonShop();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            };
        }
    }
}
