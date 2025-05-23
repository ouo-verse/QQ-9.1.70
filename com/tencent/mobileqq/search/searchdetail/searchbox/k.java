package com.tencent.mobileqq.search.searchdetail.searchbox;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail.WXMinGameMoreDetailFragment;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartScrollingView;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartSearchEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListPart;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.SoftKeyboardStateHelper;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.SearchController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.KeyWordChangeEvent;
import rp2.UnifySearchTabInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001Z\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0002abB\u0011\u0012\b\b\u0002\u00106\u001a\u000203\u00a2\u0006\u0004\b^\u0010_J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u001f\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J*\u0010(\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0016J*\u0010*\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0012\u0010,\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010.\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00102\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0005000/j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000500`1H\u0016R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010@R\u0018\u0010G\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001d\u0010U\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/k;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "Landroid/text/TextWatcher;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "keywordFrom", "", "keyword", "", "H9", "reason", "Q9", "L9", "G9", "(Ljava/lang/String;)Lkotlin/Unit;", "O9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "action", "", "args", "getMessage", "handleBroadcastMessage", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "", ReportConstant.COSTREPORT_PREFIX, "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "d", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "searchPageType", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "e", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "I9", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "P9", "(Lcom/tencent/mobileqq/widget/search/QUISearchBar;)V", "searchBar", "f", "Ljava/lang/String;", tl.h.F, "lastSearchedKeyword", "i", "hint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Integer;", "userSource", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isFirstSearch", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "D", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "mKeyboardStateHelper", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", "E", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/k$b;", "J9", "()Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", "searchBoxViewModel", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "requestJob", "com/tencent/mobileqq/search/searchdetail/searchbox/k$c", "G", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/k$c;", "actionCallback", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;)V", "H", "a", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k extends Part implements SoftKeyboardStateHelper.SoftKeyboardStateListener, TextWatcher, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFirstSearch;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private SoftKeyboardStateHelper mKeyboardStateHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b searchBoxViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b requestJob;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final c actionCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchPageType searchPageType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public QUISearchBar searchBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String keyword;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String lastSearchedKeyword;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String hint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer userSource;
    static final /* synthetic */ KProperty<Object>[] I = {Reflection.property1(new PropertyReference1Impl(k.class, "searchBoxViewModel", "getSearchBoxViewModel()Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", 0))};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/k$b;", "Lkotlin/properties/ReadOnlyProperty;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/SearchBoxViewModel;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements ReadOnlyProperty<Part, SearchBoxViewModel> {
        @Override // kotlin.properties.ReadOnlyProperty
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SearchBoxViewModel getValue(@NotNull Part thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            Object partHost = thisRef.getPartHost();
            if ((partHost instanceof Fragment) && !((Fragment) partHost).isAdded()) {
                QLog.e("QQSearch.NetDetail.SearchBoxPart", 1, "host is not add " + partHost);
                return null;
            }
            return (SearchBoxViewModel) thisRef.getViewModel(SearchBoxViewModel.class);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/searchdetail/searchbox/k$c", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements QUISearchBar.ActionCallback {
        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onBack() {
            boolean z16;
            boolean isBlank;
            if (Intrinsics.areEqual(k.this.broadcastGetMessage("MESSAGE_GET_IS_CONTAINER_SHOEING", null), Boolean.TRUE)) {
                String str = k.this.lastSearchedKeyword;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z16 = true;
                        if (z16) {
                            k kVar = k.this;
                            kVar.broadcastMessage("MESSAGE_HIDE_SEARCH_FRAME", kVar.I9().getInputWidget().getText().toString());
                            String str2 = k.this.lastSearchedKeyword;
                            if (str2 != null) {
                                k.this.handleBroadcastMessage("MESSAGE_UPDATETEXT", new KeyWordChangeEvent(str2, 7, null, null, 12, null));
                            }
                            return true;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            QUISearchBar I9 = k.this.I9();
            SearchController.defaultCancelAction(I9, I9.getSearchController(), true);
            InputMethodUtil.hide(k.this.I9().getInputWidget());
            SearchController.defaultBackAction(k.this.I9(), k.this.I9().getSearchController());
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            k.this.I9().getInputWidget().requestFocus();
            k.this.I9().getInputWidget().setCursorVisible(true);
            InputMethodUtil.show(k.this.I9().getInputWidget());
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            boolean isBlank;
            String str;
            int i3;
            boolean isBlank2;
            String obj = k.this.I9().getInputWidget().getText().toString();
            isBlank = StringsKt__StringsJVMKt.isBlank(obj);
            if (isBlank) {
                str = k.this.hint;
                if (str != null) {
                    k.this.I9().getInputWidget().setText(str);
                } else {
                    str = "";
                }
                i3 = 21;
            } else {
                str = obj;
                i3 = 1;
            }
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                SearchUtils.i1(str);
                k.this.lastSearchedKeyword = str;
                k.this.broadcastMessage("MESSAGE_HIDE_SEARCH_FRAME", obj);
                k.this.broadcastMessage("startSearch", new SearchDetailTabListPart.StartSearchEntity(str, i3));
                k.this.H9(i3, str);
                k.this.O9(obj);
                k.this.I9().getInputWidget().setCursorVisible(false);
                k.this.I9().getInputWidget().clearFocus();
                return;
            }
            QLog.e("QQSearch.NetDetail.SearchBoxPart", 1, "empty key word, return");
        }
    }

    public k() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Unit G9(String keyword) {
        boolean z16;
        SearchDetailTabListViewModel.TabInfo tabInfo;
        Integer num;
        int i3;
        String str;
        long j3;
        Job f16;
        Job f17;
        int i16 = 0;
        if (keyword.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
        if (z16) {
            broadcastMessage("MESSAGE_SHOW_SEARCH_FRAME", keyword);
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = this.requestJob;
            if (bVar2 != null && (f17 = bVar2.f()) != null) {
                Job.DefaultImpls.cancel$default(f17, (CancellationException) null, 1, (Object) null);
            }
            SearchBoxViewModel J9 = J9();
            if (J9 == null) {
                return null;
            }
            J9.W1();
            return Unit.INSTANCE;
        }
        SearchPageType searchPageType = this.searchPageType;
        SearchPageType searchPageType2 = SearchPageType.PAGE_NET_SEARCH_MINI_GAME_MORE;
        if (searchPageType == searchPageType2) {
            broadcastMessage("MESSAGE_HIDE_SEARCH_FRAME", keyword);
        } else {
            broadcastMessage("MESSAGE_SHOW_SEARCH_FRAME", keyword);
        }
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar3 = this.requestJob;
        if (bVar3 != null && (f16 = bVar3.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        Object broadcastGetMessage = broadcastGetMessage("getTabInfo", null);
        if (broadcastGetMessage instanceof SearchDetailTabListViewModel.TabInfo) {
            tabInfo = (SearchDetailTabListViewModel.TabInfo) broadcastGetMessage;
        } else {
            tabInfo = null;
        }
        Object broadcastGetMessage2 = broadcastGetMessage("getQuerySource", null);
        if (broadcastGetMessage2 instanceof Integer) {
            num = (Integer) broadcastGetMessage2;
        } else {
            num = null;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (tabInfo == null && this.searchPageType == searchPageType2) {
            tabInfo = WXMinGameMoreDetailFragment.INSTANCE.a();
        }
        SearchBoxViewModel J92 = J9();
        if (J92 != null) {
            if (tabInfo == null || (str = tabInfo.getTabName()) == null) {
                str = "\u5168\u90e8";
            }
            if (tabInfo != null) {
                j3 = tabInfo.getTabMask();
            } else {
                j3 = 1;
            }
            UnifySearchTabInfo unifySearchTabInfo = new UnifySearchTabInfo(str, j3);
            Integer num2 = this.userSource;
            if (num2 != null) {
                i16 = num2.intValue();
            }
            bVar = J92.R1(keyword, unifySearchTabInfo, i3, i16);
        }
        this.requestJob = bVar;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(int keywordFrom, String keyword) {
        int i3;
        int i16;
        if (SearchPageType.PAGE_NET_SEARCH_MINI_GAME_MORE == this.searchPageType) {
            if (keywordFrom == 21) {
                i3 = com.tencent.mobileqq.search.searchdetail.e.f284431a.a();
            } else {
                i3 = 2;
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            StartSearchEvent startSearchEvent = new StartSearchEvent(keyword, SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue(), i3, RefreshType.TYPE_USER_INPUT_SEARCH, "", "", com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.b(com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.f284375a, i3, null, 2, null), null, 128, null);
            Activity activity = getActivity();
            if (activity != null) {
                i16 = activity.hashCode();
            } else {
                i16 = 0;
            }
            startSearchEvent.mHashCode = i16;
            simpleEventBus.dispatchEvent(startSearchEvent);
        }
    }

    private final SearchBoxViewModel J9() {
        return this.searchBoxViewModel.getValue(this, I[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9("receive message show keyboard");
    }

    private final void L9() {
        I9().getInputWidget().setCursorVisible(false);
        I9().getInputWidget().clearFocus();
        InputMethodUtil.hide(I9().getInputWidget());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M9(k this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1 && !Intrinsics.areEqual(this$0.broadcastGetMessage("MESSAGE_GET_IS_CONTAINER_SHOEING", null), Boolean.TRUE)) {
            this$0.G9(this$0.I9().getInputWidget().getText().toString());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9().getInputWidget().setCursorVisible(false);
        this$0.I9().getInputWidget().clearFocus();
        InputMethodUtil.hide(this$0.I9().getInputWidget());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(String keyword) {
        long j3;
        if (this.isFirstSearch) {
            SearchDetailTabListViewModel.TabInfo tabInfo = null;
            Object broadcastGetMessage = broadcastGetMessage("getTabInfo", null);
            if (broadcastGetMessage instanceof SearchDetailTabListViewModel.TabInfo) {
                tabInfo = (SearchDetailTabListViewModel.TabInfo) broadcastGetMessage;
            }
            f fVar = f.f284591a;
            long currentTimeMillis = System.currentTimeMillis();
            if (tabInfo != null) {
                j3 = tabInfo.getTabMask();
            } else {
                j3 = -1;
            }
            fVar.i(currentTimeMillis, keyword, false, j3);
            this.isFirstSearch = false;
        }
    }

    private final void Q9(String reason) {
        af afVar = af.f284993a;
        if (QLog.isDebugVersion()) {
            QLog.d("QS.QQSearch.NetDetail.SearchBoxPart", 2, "showKeyboard " + I9().getInputWidget().isCursorVisible() + " reason=" + reason, (Throwable) null);
        }
        if (!I9().getInputWidget().isCursorVisible()) {
            I9().getInputWidget().setCursorVisible(true);
            I9().getInputWidget().requestFocus();
            Object systemService = I9().getInputWidget().getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(I9().getInputWidget(), 2);
        }
    }

    @NotNull
    public final QUISearchBar I9() {
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar != null) {
            return qUISearchBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        return null;
    }

    public final void P9(@NotNull QUISearchBar qUISearchBar) {
        Intrinsics.checkNotNullParameter(qUISearchBar, "<set-?>");
        this.searchBar = qUISearchBar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s16) {
        String str;
        String obj;
        if (s16 != null) {
            str = s16.toString();
        } else {
            str = null;
        }
        QLog.e("QQSearch.NetDetail.SearchBoxPart", 2, "afterTextChanged " + str);
        if (s16 != null && (obj = s16.toString()) != null) {
            G9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(StartScrollingView.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "MESSAGE_GET_CURRENT_KEYWORD")) {
            return I9().getInputWidget().getText().toString();
        }
        return super.getMessage(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (action != null) {
            KeyWordChangeEvent keyWordChangeEvent = null;
            switch (action.hashCode()) {
                case -2111231354:
                    if (!action.equals("MESSAGE_ON_LIST_SCROLL")) {
                        return;
                    }
                    break;
                case -1286567956:
                    if (!action.equals("MESSAGE_HIDE_KEYBOARD")) {
                        return;
                    }
                    break;
                case 13893838:
                    if (action.equals("MESSAGE_UPDATETEXT")) {
                        Logger.f235387a.d().d("QQSearch.NetDetail.SearchBoxPart", 1, " MESSAGE_UPDATE_SEARCH_TEXT " + args);
                        if (args instanceof KeyWordChangeEvent) {
                            keyWordChangeEvent = (KeyWordChangeEvent) args;
                        }
                        if (keyWordChangeEvent != null) {
                            if (keyWordChangeEvent.getKeyWordFrom() != 4 && keyWordChangeEvent.getKeyWordFrom() != 5 && keyWordChangeEvent.getKeyWordFrom() != 6 && keyWordChangeEvent.getKeyWordFrom() != 7 && keyWordChangeEvent.getKeyWordFrom() != 22) {
                                I9().getInputWidget().setText(keyWordChangeEvent.getKeyword());
                                O9(keyWordChangeEvent.getKeyword());
                            } else {
                                I9().getInputWidget().removeTextChangedListener(this);
                                I9().getInputWidget().setText(keyWordChangeEvent.getKeyword());
                                I9().getInputWidget().addTextChangedListener(this);
                                if (keyWordChangeEvent.getKeyWordFrom() == 22) {
                                    broadcastMessage("MESSAGE_HIDE_SEARCH_FRAME", I9().getInputWidget().getText().toString());
                                }
                            }
                            if (keyWordChangeEvent.getKeyWordFrom() != 7) {
                                SearchUtils.i1(keyWordChangeEvent.getKeyword());
                                this.lastSearchedKeyword = keyWordChangeEvent.getKeyword();
                            }
                            H9(keyWordChangeEvent.getKeyWordFrom(), keyWordChangeEvent.getKeyword());
                        }
                        L9();
                        return;
                    }
                    return;
                case 155217108:
                    if (action.equals("MESSAGE_ON_SEARCH_BAR_GET_FOCUS") && !Intrinsics.areEqual(broadcastGetMessage("MESSAGE_GET_IS_CONTAINER_SHOEING", null), Boolean.TRUE)) {
                        G9(I9().getInputWidget().getText().toString());
                        return;
                    }
                    return;
                case 2117979281:
                    if (action.equals("MESSAGE_SHOW_KEYBOARD")) {
                        I9().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                k.K9(k.this);
                            }
                        }, 300L);
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (I9().getInputWidget().isCursorVisible()) {
                L9();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    @Override // com.tencent.biz.richframework.part.Part
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInitView(@Nullable View rootView) {
        boolean z16;
        String str;
        Window window;
        Window window2;
        Window window3;
        boolean isBlank;
        boolean isBlank2;
        super.onInitView(rootView);
        boolean z17 = true;
        if (rootView == null) {
            QLog.e("QQSearch.NetDetail.SearchBoxPart", 1, "rootView is null");
            return;
        }
        View findViewById = rootView.findViewById(R.id.f166395zp4);
        Intrinsics.checkNotNull(findViewById);
        P9((QUISearchBar) findViewById);
        I9().bindSearchChain(false);
        I9().getInputWidget().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean M9;
                M9 = k.M9(k.this, view, motionEvent);
                return M9;
            }
        });
        I9().setActionCallback(this.actionCallback);
        if (this.mKeyboardStateHelper == null) {
            SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(rootView);
            softKeyboardStateHelper.addSoftKeyboardStateListener(this);
            this.mKeyboardStateHelper = softKeyboardStateHelper;
        }
        String str2 = this.hint;
        if (str2 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                z16 = true;
                if (z16) {
                    I9().getInputWidget().setHint(this.hint);
                }
                str = this.keyword;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z17 = false;
                    }
                }
                if (!z17) {
                    I9().getInputWidget().requestFocus();
                } else {
                    InputMethodUtil.hide(I9().getInputWidget());
                    I9().getInputWidget().setCursorVisible(false);
                    I9().getInputWidget().clearFocus();
                    if (Build.VERSION.SDK_INT < 28) {
                        Activity activity = getActivity();
                        if (activity != null && (window3 = activity.getWindow()) != null) {
                            window3.setSoftInputMode(16);
                        }
                        Activity activity2 = getActivity();
                        if (activity2 != null && (window2 = activity2.getWindow()) != null) {
                            window2.setSoftInputMode(2);
                        }
                        Activity activity3 = getActivity();
                        if (activity3 != null && (window = activity3.getWindow()) != null) {
                            window.setSoftInputMode(3);
                        }
                        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.j
                            @Override // java.lang.Runnable
                            public final void run() {
                                k.N9(k.this);
                            }
                        }, 200L);
                    }
                    I9().getInputWidget().setText(this.keyword);
                }
                I9().getInputWidget().addTextChangedListener(this);
            }
        }
        z16 = false;
        if (z16) {
        }
        str = this.keyword;
        if (str != null) {
        }
        if (!z17) {
        }
        I9().getInputWidget().addTextChangedListener(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if ((!r12) == true) goto L25;
     */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        boolean z16;
        long currentTimeMillis;
        long j3;
        Intent intent;
        Intent intent2;
        boolean isBlank;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        super.onPartCreate(activity, savedInstanceState);
        Integer num = null;
        if (activity != null && (intent5 = activity.getIntent()) != null) {
            str = intent5.getStringExtra("keyword");
        } else {
            str = null;
        }
        this.keyword = str;
        if (activity != null && (intent4 = activity.getIntent()) != null) {
            str2 = intent4.getStringExtra("hint");
        } else {
            str2 = null;
        }
        this.hint = str2;
        if (activity != null && (intent3 = activity.getIntent()) != null) {
            num = Integer.valueOf(intent3.getIntExtra("user_source", 0));
        }
        this.userSource = num;
        String str3 = this.keyword;
        if (str3 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str3);
            z16 = true;
        }
        z16 = false;
        if (z16) {
            SearchUtils.i1(this.keyword);
            this.lastSearchedKeyword = this.keyword;
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                currentTimeMillis = intent2.getLongExtra("start_search_stamp", System.currentTimeMillis());
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            long j16 = currentTimeMillis;
            if (activity != null && (intent = activity.getIntent()) != null) {
                j3 = intent.getLongExtra("tab_mask", 0L);
            } else {
                j3 = -1;
            }
            long j17 = j3;
            f fVar = f.f284591a;
            String str4 = this.keyword;
            if (str4 == null) {
                str4 = "";
            }
            fVar.i(j16, str4, true, j17);
            this.isFirstSearch = false;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SoftKeyboardStateHelper softKeyboardStateHelper = this.mKeyboardStateHelper;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.removeSoftKeyboardStateListener(this);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof StartScrollingView) {
            handleBroadcastMessage("MESSAGE_ON_LIST_SCROLL", null);
        }
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardClosed() {
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchBoxPart", 1, "onSoftKeyboardClosed " + this.lastSearchedKeyword);
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchBoxPart", 1, "onSoftKeyboardOpened " + this.lastSearchedKeyword);
    }

    public k(@NotNull SearchPageType searchPageType) {
        Intrinsics.checkNotNullParameter(searchPageType, "searchPageType");
        this.searchPageType = searchPageType;
        this.isFirstSearch = true;
        this.searchBoxViewModel = new b();
        this.actionCallback = new c();
    }

    public /* synthetic */ k(SearchPageType searchPageType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? SearchPageType.PAGE_NET_SEARCH_DETAIL : searchPageType);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
    }
}
