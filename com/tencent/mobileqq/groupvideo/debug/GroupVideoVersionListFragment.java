package com.tencent.mobileqq.groupvideo.debug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import mqq.app.Constants;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J2\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t0\bH\u0002JT\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0014J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R&\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/GroupVideoVersionListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", HippyControllerProps.STRING, "", "Fh", "url", OcrConfig.CHINESE, "", "Lkotlin/Pair;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Lkotlin/collections/ArrayList;", "yh", "", "leftText", "", "leftIcon", "rightText", "Lkotlin/Function0;", NodeProps.ON_CLICK, "onExpo", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Ch", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "needImmersive", "needStatusTrans", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "D", "Ljava/lang/String;", "E", "Ljava/util/ArrayList;", "grouplist", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/x;", "currentCfg", "<init>", "()V", "G", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GroupVideoVersionListFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String url;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Group> grouplist;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private x<x.b.d, x.c.g> currentCfg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/GroupVideoVersionListFragment$a;", "", "", "CURRENT_VERSION", "Ljava/lang/String;", "", "DEBUG_DATA_LOCAL", "Z", "DES_DISK_DIR", "PLUGIN_FILE_NAME", "tag", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.debug.GroupVideoVersionListFragment$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GroupVideoVersionListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.grouplist = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(final GroupVideoVersionListFragment this$0) {
        List reversed;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String zh5 = this$0.zh(this$0.url);
        if (zh5 != null) {
            Regex regex = new Regex("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}");
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            Iterator it = Regex.findAll$default(regex, zh5, 0, 2, null).iterator();
            while (it.hasNext()) {
                arrayList.add(((MatchResult) it.next()).getValue());
            }
            Unit unit = Unit.INSTANCE;
            if (arrayList.isEmpty()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.debug.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        GroupVideoVersionListFragment.Bh(GroupVideoVersionListFragment.this);
                    }
                });
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            int i16 = 0;
            for (Object obj : Regex.findAll$default(new Regex(">(\\d.[^\\/]+)/"), zh5, 0, 2, null)) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MatchResult matchResult = (MatchResult) obj;
                String str = matchResult.getGroupValues().get(1);
                Object obj2 = arrayList.get(i16);
                Intrinsics.checkNotNullExpressionValue(obj2, "timeliest[index]");
                String substring = ((String) obj2).substring(5);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                arrayList2.add(new Pair(((Object) str) + "      " + substring, this$0.url + ((Object) matchResult.getGroupValues().get(1)) + "/"));
                i16 = i17;
            }
            Unit unit2 = Unit.INSTANCE;
            reversed = CollectionsKt___CollectionsKt.reversed(arrayList2);
            Intrinsics.checkNotNull(reversed, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Pair<kotlin.String, kotlin.String>>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Pair<kotlin.String, kotlin.String>> }");
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : (ArrayList) reversed) {
                int i18 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj3;
                if (i3 < 30) {
                    arrayList3.add(pair);
                }
                i3 = i18;
            }
            this$0.grouplist = this$0.yh(arrayList3);
            this$0.Fh(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(GroupVideoVersionListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), "\u5185\u90e8\u4f7f\u7528\uff0c\u8bf7\u5f00\u542fMOA\u8fde\u63a5", 0).show();
    }

    private final x<x.b.d, x.c.g> Ch(CharSequence leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.groupvideo.debug.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupVideoVersionListFragment.Eh(Function0.this, view);
            }
        });
        return xVar;
    }

    static /* synthetic */ x Dh(GroupVideoVersionListFragment groupVideoVersionListFragment, CharSequence charSequence, int i3, CharSequence charSequence2, Function0 function0, Function0 function02, int i16, Object obj) {
        Function0 function03;
        Function0 function04;
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            charSequence2 = "";
        }
        CharSequence charSequence3 = charSequence2;
        if ((i16 & 8) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        if ((i16 & 16) != 0) {
            function04 = null;
        } else {
            function04 = function02;
        }
        return groupVideoVersionListFragment.Ch(charSequence, i17, charSequence3, function03, function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function0 function0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(String string) {
        x.c.g gVar;
        if (string != null) {
            x<x.b.d, x.c.g> xVar = this.currentCfg;
            if (xVar != null) {
                gVar = xVar.O();
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.h(string);
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.debug.g
            @Override // java.lang.Runnable
            public final void run() {
                GroupVideoVersionListFragment.Gh(GroupVideoVersionListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(GroupVideoVersionListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIListItemAdapter qUIListItemAdapter = this$0.adapter;
        if (qUIListItemAdapter != null) {
            Object[] array = this$0.grouplist.toArray(new Group[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Group[] groupArr = (Group[]) array;
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
        }
    }

    private final ArrayList<Group> yh(List<Pair<String, String>> list) {
        List filterNotNull;
        ArrayList<Group> arrayListOf;
        String str;
        ArrayList arrayList = new ArrayList();
        String d16 = cl.d(getContext(), "current_version");
        Iterator<Pair<String, String>> it = list.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
                Object[] array = filterNotNull.toArray(new x[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                x[] xVarArr = (x[]) array;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length)));
                return arrayListOf;
            }
            Pair<String, String> next = it.next();
            String first = next.getFirst();
            if (d16 != null && d16.contentEquals(next.getFirst())) {
                IGroupVideoDebugApi.a debugPluginManager = ((IGroupVideoDebugApi) QRoute.api(IGroupVideoDebugApi.class)).getDebugPluginManager();
                if (debugPluginManager == null || !debugPluginManager.isDebugEnabled()) {
                    z16 = false;
                }
                if (z16) {
                    str = "\u5f53\u524d\u5e94\u7528";
                    arrayList.add(Dh(this, first, R.drawable.qui_avatar, str, new GroupVideoVersionListFragment$createVersionGroups$1(this, list, next, next), null, 16, null));
                }
            }
            str = "";
            arrayList.add(Dh(this, first, R.drawable.qui_avatar, str, new GroupVideoVersionListFragment$createVersionGroups$1(this, list, next, next), null, 16, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zh(String url) {
        if (url == null) {
            return null;
        }
        try {
            ResponseBody body = new OkHttpClient().newCall(new Request.Builder().url(url).method("GET", null).build()).execute().body();
            if (body == null) {
                return null;
            }
            return body.string();
        } catch (Exception e16) {
            QLog.i("IphoneTitleBarFragment", 2, "err -" + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e_2;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        Intent intent;
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            str = extras.getString("url");
        } else {
            str = null;
        }
        this.url = str;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.debug.e
            @Override // java.lang.Runnable
            public final void run() {
                GroupVideoVersionListFragment.Ah(GroupVideoVersionListFragment.this);
            }
        }, 128, null, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u7248\u672c\u5217\u8868");
        ((QIphoneTitleBarFragment) this).mContentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f102545y7);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter;
        if (qUISettingsRecyclerView != null) {
            qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        }
    }
}
