package com.tencent.mobileqq.setting.search;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.setting.search.FunctionSearchFragment;
import com.tencent.mobileqq.setting.utils.SearchResult;
import com.tencent.mobileqq.setting.utils.SettingNodeSearchUtil;
import com.tencent.mobileqq.setting.utils.j;
import com.tencent.mobileqq.setting.utils.o;
import com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.g;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jq2.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002JB\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u0011j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f`\u0012H\u0002J-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0002H\u0002J&\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)J\u0006\u0010,\u001a\u00020\u0005J\u0016\u00100\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0016R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR0\u0010P\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0011j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010L\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/setting/search/FunctionSearchFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Kh", "Jh", "", "isVisible", "Th", "Lh", "Rh", "Ph", "Mh", "Ljq2/c;", "node", "", "", "parentTitles", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeMap", "Eh", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/setting/utils/k;", "Lkotlin/collections/ArrayList;", "searchResultList", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", OcrConfig.CHINESE, "(Ljava/util/ArrayList;)[Lcom/tencent/mobileqq/widget/listitem/Group;", "hideInputMethod", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", ReportConstant.COSTREPORT_PREFIX, "Gh", "finish", "Landroid/content/Context;", "context", "clickNode", "Sh", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "D", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "E", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/widget/immersive/ImmersiveTitleBar2;", UserInfo.SEX_FEMALE, "Lcom/tencent/widget/immersive/ImmersiveTitleBar2;", "titleBar", "G", "Landroid/view/View;", "root", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", "emptyPage", "I", "Ljq2/c;", "searchRootNode", "J", "Ljava/lang/String;", "searchContent", "K", "Ljava/util/HashMap;", "webNodeMap", "L", "webConfig", "<init>", "()V", "M", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FunctionSearchFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private SettingOverScrollRecyclerView recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    private QUISearchBar searchBar;

    /* renamed from: E, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: F, reason: from kotlin metadata */
    private ImmersiveTitleBar2 titleBar;

    /* renamed from: G, reason: from kotlin metadata */
    private View root;

    /* renamed from: H, reason: from kotlin metadata */
    private FrameLayout emptyPage;

    /* renamed from: I, reason: from kotlin metadata */
    private jq2.c searchRootNode;

    /* renamed from: J, reason: from kotlin metadata */
    private String searchContent;

    /* renamed from: K, reason: from kotlin metadata */
    private final HashMap<String, String> webNodeMap = new HashMap<>();

    /* renamed from: L, reason: from kotlin metadata */
    private String webConfig = "\n            {\n              \"webNodes\":[\n                {\n                  \"parent\":\"\u627e\u5230\u6211\u7684\u65b9\u5f0f\",\n                  \"subNodes\":[\"QQ\u53f7\",\"\u6635\u79f0\",\"\u624b\u673a\u53f7\",\"\u53ef\u80fd\u8ba4\u8bc6\u7684\u4eba\",\"\u8d44\u6599\u4fe1\u606f\"],\n                  \"subNodeIds\":[\"QQ\",\"nick\",\"phone\",\"may-know\",\"message\"]\n                },\n                {\n                  \"parent\":\"\u52a0\u6211\u4e3a\u597d\u53cb\u7684\u65b9\u5f0f\",\n                  \"subNodes\":[\"\u7981\u6b62\u52a0\u6211\u4e3a\u597d\u53cb\",\"\u5141\u8bb8\u4efb\u4f55\u4eba\",\"\u9700\u8981\u9a8c\u8bc1\u4fe1\u606f\",\"\u9700\u8981\u6b63\u786e\u56de\u7b54\u95ee\u9898\",\"\u9700\u8981\u6b63\u786e\u56de\u7b54\u95ee\u9898\u5e76\u7531\u6211\u786e\u8ba4\",\"\u4e34\u65f6\u4f1a\u8bdd\",\"\u7fa4\u804a\",\"\u6211\u7684\u4e8c\u7ef4\u7801\",\"\u597d\u53cb\u53d1\u9001\u7684\u540d\u7247\",\"\u901a\u8baf\u5f55\",\"\u817e\u8baf\u9891\u9053\",\"\u8d85\u7ea7QQ\u79c0\",\"\u597d\u53cb\u514b\u9686\u6743\u9650\"],\n                  \"subNodeIds\":[\"add-prohibit\",\"anyone\",\"need-verify\",\"need-answer\",\"need-confirm\",\"session\",\"group\",\"qrcode\",\"business-card\",\"contacts\",\"channel\",\"QQshow\",\"clone\"]\n                },\n                {\n                  \"parent\":\"\u4e2a\u4eba\u4fe1\u606f\u4fdd\u62a4\u8bbe\u7f6e\",\n                  \"subNodes\":[\"\u4e2a\u4eba\u4fe1\u606f\u67e5\u8be2\u4e0e\u7ba1\u7406\",\"\u4e2a\u6027\u5316\u63a8\u8350\u8bbe\u7f6e\",\"\u5e7f\u544a\u63a8\u8350\u8bbe\u7f6e\",\"\u9690\u79c1\u4fdd\u62a4\u6307\u5f15\",\"\u5e94\u7528\u6743\u9650\u8bf4\u660e\",\"\u5e7f\u544a\u5e94\u7528\u4e0b\u8f7d\u6e05\u5355\"],\n                  \"subNodeIds\":[\"information-inquiry\",\"personalization\",\"advertise\",\"privacy\",\"permissions\",\"download-checklist\"]\n                },\n                {\n                  \"parent\":\"\u4e2a\u4eba\u4fe1\u606f\u6536\u96c6\u6e05\u5355\",\n                  \"subNodes\":[\"\u7528\u6237\u57fa\u672c\u4fe1\u606f\",\"\u7528\u6237\u79c1\u5bc6\u4fe1\u606f\",\"\u5176\u4ed6\u80cc\u666f\u5ba1\u6838\u8d44\u6599\",\"\u7528\u6237\u7f51\u7edc\u8eab\u4efd\u6807\u8bc6\u548c\u9274\u6743\u4fe1\u606f\",\"\u7528\u6237\u4f7f\u7528\u4fe1\u606f\",\"\u8054\u7cfb\u4eba\u4fe1\u606f\",\"\u8bbe\u5907\u5c5e\u6027\u4fe1\u606f\"],\n                  \"subNodeIds\":[\"basic-information\",\"private-message\",\"backgrounds\",\"mark\",\"usage-information\",\"contacts\",\"device\"]\n                }\n              ]\n            }    \n        ";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(FunctionSearchFragment this$0, SearchResult searchNode, CharSequence spannable, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchNode, "$searchNode");
        Intrinsics.checkNotNullParameter(spannable, "$spannable");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            this$0.Sh(activity, searchNode);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("set_entry_name", spannable.toString());
        o oVar = o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        oVar.f(it, "em_bas_search_result_entry", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(CharSequence spannable, View it) {
        Intrinsics.checkNotNullParameter(spannable, "$spannable");
        Intrinsics.checkNotNullParameter(it, "it");
        HashMap hashMap = new HashMap();
        hashMap.put("set_entry_name", spannable.toString());
        o.f286768a.h(it, "em_bas_search_result_entry", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(FunctionSearchFragment this$0, SearchResult searchNode, CharSequence spannable, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchNode, "$searchNode");
        Intrinsics.checkNotNullParameter(spannable, "$spannable");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            this$0.Sh(activity, searchNode);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("set_entry_name", spannable.toString());
        o oVar = o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        oVar.f(it, "em_bas_search_result_entry", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(CharSequence spannable, View it) {
        Intrinsics.checkNotNullParameter(spannable, "$spannable");
        Intrinsics.checkNotNullParameter(it, "it");
        HashMap hashMap = new HashMap();
        hashMap.put("set_entry_name", spannable.toString());
        o.f286768a.l(it, "em_bas_search_result_entry", hashMap, false);
    }

    private final void Eh(jq2.c node, List<String> parentTitles, HashMap<String, jq2.c> nodeMap) {
        String title = node.getTitle();
        if (parentTitles.contains(title)) {
            nodeMap.put(title, node);
        }
        Iterator<jq2.c> it = node.d().iterator();
        while (it.hasNext()) {
            jq2.c subNode = it.next();
            Intrinsics.checkNotNullExpressionValue(subNode, "subNode");
            Eh(subNode, parentTitles, nodeMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(FunctionSearchFragment this$0) {
        QuickPinyinEditText inputWidget;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideInputMethod();
        QUISearchBar qUISearchBar = this$0.searchBar;
        if (qUISearchBar != null && (inputWidget = qUISearchBar.getInputWidget()) != null) {
            inputWidget.setText("");
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, R.anim.f155053hw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(final com.tencent.qqnt.avatar.meta.refresh.c contextWeakReference, final FunctionSearchFragment this$0, final ArrayList it) {
        Intrinsics.checkNotNullParameter(contextWeakReference, "$contextWeakReference");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: hq2.f
            @Override // java.lang.Runnable
            public final void run() {
                FunctionSearchFragment.Ih(com.tencent.qqnt.avatar.meta.refresh.c.this, it, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Ih(com.tencent.qqnt.avatar.meta.refresh.c contextWeakReference, ArrayList it, FunctionSearchFragment this$0) {
        Intrinsics.checkNotNullParameter(contextWeakReference, "$contextWeakReference");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FunctionSearchFragment functionSearchFragment = (FunctionSearchFragment) contextWeakReference.get();
        if (functionSearchFragment == null) {
            return;
        }
        if (it.size() == 0) {
            QLog.d("FunctionSearchFragment", 1, "have no search result content: " + this$0.searchContent);
            functionSearchFragment.Th(true);
            SettingOverScrollRecyclerView settingOverScrollRecyclerView = functionSearchFragment.recyclerView;
            if (settingOverScrollRecyclerView == null) {
                return;
            }
            settingOverScrollRecyclerView.setVisibility(8);
            return;
        }
        SettingOverScrollRecyclerView settingOverScrollRecyclerView2 = functionSearchFragment.recyclerView;
        if (settingOverScrollRecyclerView2 != null) {
            settingOverScrollRecyclerView2.setVisibility(0);
        }
        functionSearchFragment.Th(false);
        QUIListItemAdapter qUIListItemAdapter = functionSearchFragment.adapter;
        if (qUIListItemAdapter != null) {
            Group[] zh5 = functionSearchFragment.zh(it);
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(zh5, zh5.length));
        }
        QUIListItemAdapter qUIListItemAdapter2 = functionSearchFragment.adapter;
        if (qUIListItemAdapter2 != null) {
            qUIListItemAdapter2.notifyDataSetChanged();
        }
    }

    private final void Jh() {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        this.emptyPage = (FrameLayout) view.findViewById(R.id.f73683u8);
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(9).setBackgroundColorType(0).setTitle("\u6ca1\u6709\u66f4\u591a\u641c\u7d22\u7ed3\u679c").setHalfScreenState(true).setAutoCenter(false).build();
        FrameLayout frameLayout = this.emptyPage;
        if (frameLayout != null) {
            frameLayout.addView(build);
        }
    }

    private final void Kh() {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        this.recyclerView = (SettingOverScrollRecyclerView) view.findViewById(R.id.search_result_list);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth, false, true, 2, null);
        this.adapter = qUIListItemAdapter;
        SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
        if (settingOverScrollRecyclerView == null) {
            return;
        }
        settingOverScrollRecyclerView.setAdapter(qUIListItemAdapter);
    }

    private final void Lh() {
        QuickPinyinEditText inputWidget;
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.f81294ds);
        this.searchBar = qUISearchBar;
        if (qUISearchBar != null) {
            qUISearchBar.setActionCallback(new b());
        }
        QUISearchBar qUISearchBar2 = this.searchBar;
        if (qUISearchBar2 != null && (inputWidget = qUISearchBar2.getInputWidget()) != null) {
            inputWidget.addTextChangedListener(new c());
        }
        Rh();
    }

    private final void Mh() {
        JSONArray jSONArray;
        jq2.b bVar = new jq2.b();
        int i3 = 0;
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("105693", new byte[0]), Charsets.UTF_8);
        if (!TextUtils.isEmpty(str)) {
            QLog.d("FunctionSearchFragment", 2, "config:" + str);
            this.webConfig = str;
        }
        int i16 = 1;
        try {
            JSONArray jSONArray2 = new JSONObject(this.webConfig).getJSONArray("webNodes");
            HashMap<String, jq2.c> hashMap = new HashMap<>();
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            for (int i17 = 0; i17 < length; i17++) {
                Object obj = jSONArray2.get(i17);
                JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                Object obj2 = jSONObject != null ? jSONObject.get(HippyNestedScrollComponent.PRIORITY_PARENT) : null;
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            Eh(bVar, arrayList, hashMap);
            int length2 = jSONArray2.length();
            int i18 = 0;
            while (i18 < length2) {
                Object obj3 = jSONArray2.get(i18);
                JSONObject jSONObject2 = obj3 instanceof JSONObject ? (JSONObject) obj3 : null;
                Object obj4 = jSONObject2 != null ? jSONObject2.get(HippyNestedScrollComponent.PRIORITY_PARENT) : null;
                String str3 = obj4 instanceof String ? (String) obj4 : null;
                if (str3 != null) {
                    JSONObject jSONObject3 = obj3 instanceof JSONObject ? (JSONObject) obj3 : null;
                    JSONArray jSONArray3 = jSONObject3 != null ? jSONObject3.getJSONArray("subNodes") : null;
                    if (jSONArray3 != null) {
                        JSONObject jSONObject4 = obj3 instanceof JSONObject ? (JSONObject) obj3 : null;
                        JSONArray jSONArray4 = jSONObject4 != null ? jSONObject4.getJSONArray("subNodeIds") : null;
                        if (jSONArray4 != null) {
                            if (jSONArray3.length() != jSONArray4.length()) {
                                QLog.e("FunctionSearchFragment", i16, "parentTitle:" + str3 + " subNodes length:" + jSONArray3.length() + ", subNodeIds length:" + jSONArray4.length());
                            } else {
                                int length3 = jSONArray3.length();
                                int i19 = i3;
                                while (i19 < length3) {
                                    Object obj5 = jSONArray3.get(i19);
                                    String str4 = obj5 instanceof String ? (String) obj5 : null;
                                    if (str4 != null) {
                                        Object obj6 = jSONArray4.get(i19);
                                        String str5 = obj6 instanceof String ? (String) obj6 : null;
                                        if (str5 != null) {
                                            jq2.c cVar = hashMap.get(str3);
                                            if (cVar != null) {
                                                jSONArray = jSONArray2;
                                                cVar.a(new a(str4));
                                            } else {
                                                jSONArray = jSONArray2;
                                            }
                                            this.webNodeMap.put(str4, str5);
                                            i19++;
                                            jSONArray2 = jSONArray;
                                        }
                                    }
                                    jSONArray = jSONArray2;
                                    i19++;
                                    jSONArray2 = jSONArray;
                                }
                            }
                        }
                    }
                }
                i18++;
                jSONArray2 = jSONArray2;
                i3 = 0;
                i16 = 1;
            }
        } catch (JSONException e16) {
            QLog.e("FunctionSearchFragment", 1, "initSearchNode error:" + e16);
        }
        this.searchRootNode = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(FunctionSearchFragment this$0) {
        QuickPinyinEditText inputWidget;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("FunctionSearchFragment", 2, "enterAnim finish!!! ");
        QUISearchBar qUISearchBar = this$0.searchBar;
        if (qUISearchBar == null || (inputWidget = qUISearchBar.getInputWidget()) == null) {
            return;
        }
        inputWidget.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Oh(FunctionSearchFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideInputMethod();
        return false;
    }

    private final void Ph() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: hq2.e
            @Override // java.lang.Runnable
            public final void run() {
                FunctionSearchFragment.Qh(FunctionSearchFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(FunctionSearchFragment this$0) {
        QuickPinyinEditText inputWidget;
        QuickPinyinEditText inputWidget2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISearchBar qUISearchBar = this$0.searchBar;
        if (qUISearchBar != null && (inputWidget2 = qUISearchBar.getInputWidget()) != null) {
            inputWidget2.requestFocus();
        }
        QUISearchBar qUISearchBar2 = this$0.searchBar;
        if (qUISearchBar2 != null && (inputWidget = qUISearchBar2.getInputWidget()) != null) {
            InputMethodUtil.show(inputWidget);
        }
        QUISearchBar qUISearchBar3 = this$0.searchBar;
        QuickPinyinEditText inputWidget3 = qUISearchBar3 != null ? qUISearchBar3.getInputWidget() : null;
        if (inputWidget3 == null) {
            return;
        }
        inputWidget3.setCursorVisible(true);
    }

    private final void Rh() {
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar != null) {
            o oVar = o.f286768a;
            o.m(oVar, qUISearchBar, "em_bas_search_box", null, false, 8, null);
            TextView cancelView = qUISearchBar.getCancelView();
            if (cancelView != null) {
                Intrinsics.checkNotNullExpressionValue(cancelView, "cancelView");
                o.m(oVar, cancelView, "em_bas_cancel", null, false, 8, null);
            }
            ImageView clearView = qUISearchBar.getClearView();
            if (clearView != null) {
                Intrinsics.checkNotNullExpressionValue(clearView, "clearView");
                o.m(oVar, clearView, "em_bas_delete", null, false, 8, null);
            }
        }
    }

    private final void hideInputMethod() {
        QuickPinyinEditText inputWidget;
        QuickPinyinEditText inputWidget2;
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar != null && (inputWidget2 = qUISearchBar.getInputWidget()) != null) {
            InputMethodUtil.hide(inputWidget2);
        }
        QUISearchBar qUISearchBar2 = this.searchBar;
        if (qUISearchBar2 == null || (inputWidget = qUISearchBar2.getInputWidget()) == null) {
            return;
        }
        inputWidget.clearFocus();
    }

    private final Group[] zh(ArrayList<SearchResult> searchResultList) {
        List list;
        ArrayList arrayList = new ArrayList();
        for (final SearchResult searchResult : searchResultList) {
            RichTextHelper.RichTextData richTextData = new RichTextHelper.RichTextData(searchResult.getSearchContent(), (View.OnClickListener) null, true);
            String title = searchResult.getResultNode().getTitle();
            FragmentActivity activity = getActivity();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(richTextData);
            Unit unit = Unit.INSTANCE;
            final SpannableString buildSpannable = RichTextHelper.buildSpannable(title, activity, false, arrayList2);
            Intrinsics.checkNotNullExpressionValue(buildSpannable, "buildSpannable(\n        \u2026          }\n            )");
            if (searchResult.b().size() > 1) {
                com.tencent.mobileqq.widget.listitem.c cVar = new com.tencent.mobileqq.widget.listitem.c(new c.a.g(buildSpannable, searchResult.getDescription()), new c.b.C8995c("", false, false, 6, null));
                cVar.x(new View.OnClickListener() { // from class: hq2.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FunctionSearchFragment.Ah(FunctionSearchFragment.this, searchResult, buildSpannable, view);
                    }
                });
                cVar.w(new g() { // from class: hq2.h
                    @Override // com.tencent.mobileqq.widget.listitem.g
                    public final void M(View view) {
                        FunctionSearchFragment.Bh(buildSpannable, view);
                    }
                });
                arrayList.add(cVar);
            } else {
                x xVar = new x(new x.b.d(buildSpannable), new x.c.g("", false, false, 6, null));
                xVar.x(new View.OnClickListener() { // from class: hq2.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FunctionSearchFragment.Ch(FunctionSearchFragment.this, searchResult, buildSpannable, view);
                    }
                });
                xVar.w(new g() { // from class: hq2.j
                    @Override // com.tencent.mobileqq.widget.listitem.g
                    public final void M(View view) {
                        FunctionSearchFragment.Dh(buildSpannable, view);
                    }
                });
                arrayList.add(xVar);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        Object[] array = list.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    public final void Gh(CharSequence s16) {
        this.searchContent = String.valueOf(s16);
        if (TextUtils.isEmpty(String.valueOf(s16))) {
            SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
            if (settingOverScrollRecyclerView != null) {
                settingOverScrollRecyclerView.setVisibility(8);
            }
            Th(false);
            return;
        }
        if (this.searchRootNode == null) {
            Mh();
        }
        final com.tencent.qqnt.avatar.meta.refresh.c cVar = new com.tencent.qqnt.avatar.meta.refresh.c(this);
        SettingNodeSearchUtil settingNodeSearchUtil = SettingNodeSearchUtil.f286734a;
        String valueOf = String.valueOf(s16);
        jq2.c cVar2 = this.searchRootNode;
        Intrinsics.checkNotNull(cVar2);
        settingNodeSearchUtil.a(valueOf, cVar2, new j() { // from class: hq2.d
            @Override // com.tencent.mobileqq.setting.utils.j
            public final void onSuccess(ArrayList arrayList) {
                FunctionSearchFragment.Hh(com.tencent.qqnt.avatar.meta.refresh.c.this, this, arrayList);
            }
        });
    }

    public final void Sh(Context context, SearchResult clickNode) {
        Object last;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clickNode, "clickNode");
        QLog.d("FunctionSearchFragment", 2, "startRouteToPage");
        if (clickNode.b().size() > 1) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) clickNode.b());
            ((jq2.c) last).f(clickNode.getResultNode().getTitle(), context, this.webNodeMap.get(clickNode.getResultNode().getTitle()));
        } else {
            jq2.c.g(clickNode.getResultNode(), clickNode.getResultNode().getTitle(), context, null, 4, null);
        }
    }

    public final boolean finish() {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        iq2.c.l((ViewGroup) view, this.searchBar, this.recyclerView, new Runnable() { // from class: hq2.a
            @Override // java.lang.Runnable
            public final void run() {
                FunctionSearchFragment.Fh(FunctionSearchFragment.this);
            }
        });
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            qBaseActivity.mNeedStatusTrans = true;
        }
        View inflate = inflater.inflate(R.layout.h4j, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026agment, container, false)");
        this.root = inflate;
        Lh();
        Kh();
        Jh();
        View view2 = this.root;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view2 = null;
        }
        this.titleBar = (ImmersiveTitleBar2) view2.findViewById(R.id.jo9);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            o oVar = o.f286768a;
            View view3 = this.root;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                view = null;
            } else {
                view = view3;
            }
            o.o(oVar, activity2, view, "pg_bas_set_search_results", null, 8, null);
        }
        View view4 = this.root;
        if (view4 != null) {
            return view4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(this.searchContent)) {
            return;
        }
        this.searchRootNode = null;
        Gh(this.searchContent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Window window2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.root;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view2 = null;
        }
        iq2.c.k((ViewGroup) view2, this.searchBar, this.recyclerView, new Runnable() { // from class: hq2.b
            @Override // java.lang.Runnable
            public final void run() {
                FunctionSearchFragment.Nh(FunctionSearchFragment.this);
            }
        });
        SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
        if (settingOverScrollRecyclerView != null) {
            settingOverScrollRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: hq2.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view4, MotionEvent motionEvent) {
                    boolean Oh;
                    Oh = FunctionSearchFragment.Oh(FunctionSearchFragment.this, view4, motionEvent);
                    return Oh;
                }
            });
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window2 = activity.getWindow()) != null) {
            window2.setSoftInputMode(16);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (window = activity2.getWindow()) != null) {
            view3 = window.getDecorView();
        }
        if (view3 != null) {
            view3.setSystemUiVisibility(1024);
        }
        Ph();
    }

    private final void Th(boolean isVisible) {
        if (isVisible) {
            FrameLayout frameLayout = this.emptyPage;
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(0);
            return;
        }
        FrameLayout frameLayout2 = this.emptyPage;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.setVisibility(8);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/setting/search/FunctionSearchFragment$b", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements QUISearchBar.ActionCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            FunctionSearchFragment.this.finish();
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/setting/search/FunctionSearchFragment$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
            FunctionSearchFragment.this.Gh(s16);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
        }
    }
}
