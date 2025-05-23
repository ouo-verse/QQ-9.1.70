package com.tencent.mobileqq.groupvideo.debug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
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
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)JE\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072.\u0010\u0006\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003`\u0005H\u0002\u00a2\u0006\u0004\b\t\u0010\nJT\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\b\u0010\u0018\u001a\u00020\rH\u0014J\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R<\u0010'\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/GroupVideoManualApplyFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "list", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "th", "(Ljava/util/ArrayList;)[Lcom/tencent/mobileqq/widget/listitem/Group;", "", "leftText", "", "leftIcon", "rightText", "Lkotlin/Function0;", "", NodeProps.ON_CLICK, "onExpo", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "uh", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "needImmersive", "needStatusTrans", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "D", "Ljava/util/ArrayList;", "versionList", "<init>", "()V", "E", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GroupVideoManualApplyFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Pair<String, String>> versionList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/GroupVideoManualApplyFragment$a;", "", "", "tag", "Ljava/lang/String;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.debug.GroupVideoManualApplyFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GroupVideoManualApplyFragment() {
        ArrayList<Pair<String, String>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Pair("\u7279\u6027\u7248\u672c", "https://mirrors.tencent.com/repository/generic/groupvideo_android/feature_ci/"), new Pair("\u4e3b\u5e72\u7248\u672c", "https://mirrors.tencent.com/repository/generic/groupvideo_android/master_ci/"), new Pair("\u53d1\u5e03\u7248\u672c", "https://mirrors.tencent.com/repository/generic/groupvideo_android/release_ci/"), new Pair("\u5386\u53f2\u7248\u672c", "https://mirrors.tencent.com/repository/generic/groupvideo_android/"));
            this.versionList = arrayListOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Group[] th(ArrayList<Pair<String, String>> list) {
        boolean z16;
        String str;
        List filterNotNull;
        ArrayList arrayList = new ArrayList();
        Iterator<Pair<String, String>> it = list.iterator();
        while (it.hasNext()) {
            final Pair<String, String> item = it.next();
            Intrinsics.checkNotNullExpressionValue(item, "item");
            arrayList.add(vh(this, item.getFirst(), R.drawable.qui_avatar, "", new Function0<Unit>(item, this) { // from class: com.tencent.mobileqq.groupvideo.debug.GroupVideoManualApplyFragment$createVersionGroups$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Pair<String, String> $obj;
                final /* synthetic */ GroupVideoManualApplyFragment this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$obj = item;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) item, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("url", this.$obj.getSecond());
                    QPublicFragmentActivity.start(this.this$0.getActivity(), intent, GroupVideoVersionListFragment.class);
                    System.out.println((Object) this.$obj.getSecond());
                }
            }, null, 16, null));
        }
        Group[] groupArr = new Group[2];
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        IGroupVideoDebugApi.a debugPluginManager = ((IGroupVideoDebugApi) QRoute.api(IGroupVideoDebugApi.class)).getDebugPluginManager();
        if (debugPluginManager != null && debugPluginManager.isDebugEnabled()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "\u5df2\u542f\u7528";
        } else {
            str = "\u672a\u542f\u7528";
        }
        aVarArr[0] = vh(this, "\u672c\u5730\u63d2\u4ef6", R.drawable.qui_hometown, str, new Function0<Unit>() { // from class: com.tencent.mobileqq.groupvideo.debug.GroupVideoManualApplyFragment$createVersionGroups$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupVideoManualApplyFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QUIListItemAdapter qUIListItemAdapter;
                ArrayList arrayList2;
                Group[] th5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IGroupVideoDebugApi.a debugPluginManager2 = ((IGroupVideoDebugApi) QRoute.api(IGroupVideoDebugApi.class)).getDebugPluginManager();
                if (debugPluginManager2 != null && debugPluginManager2.isDebugEnabled()) {
                    IGroupVideoDebugApi.a debugPluginManager3 = ((IGroupVideoDebugApi) QRoute.api(IGroupVideoDebugApi.class)).getDebugPluginManager();
                    if (debugPluginManager3 != null) {
                        debugPluginManager3.enableDebug(false);
                    }
                } else {
                    IGroupVideoDebugApi.a debugPluginManager4 = ((IGroupVideoDebugApi) QRoute.api(IGroupVideoDebugApi.class)).getDebugPluginManager();
                    if (debugPluginManager4 != null) {
                        debugPluginManager4.enableDebug(true);
                    }
                }
                qUIListItemAdapter = GroupVideoManualApplyFragment.this.adapter;
                if (qUIListItemAdapter != null) {
                    GroupVideoManualApplyFragment groupVideoManualApplyFragment = GroupVideoManualApplyFragment.this;
                    arrayList2 = groupVideoManualApplyFragment.versionList;
                    th5 = groupVideoManualApplyFragment.th(arrayList2);
                    qUIListItemAdapter.t0((Group[]) Arrays.copyOf(th5, th5.length));
                }
            }
        }, null, 16, null);
        groupArr[0] = new Group(aVarArr);
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        Object[] array = filterNotNull.toArray(new x[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        x[] xVarArr = (x[]) array;
        groupArr[1] = new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length));
        return groupArr;
    }

    private final x<x.b.d, x.c.g> uh(CharSequence leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.groupvideo.debug.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupVideoManualApplyFragment.wh(Function0.this, view);
            }
        });
        return xVar;
    }

    static /* synthetic */ x vh(GroupVideoManualApplyFragment groupVideoManualApplyFragment, CharSequence charSequence, int i3, CharSequence charSequence2, Function0 function0, Function0 function02, int i16, Object obj) {
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
        return groupVideoManualApplyFragment.uh(charSequence, i17, charSequence3, function03, function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function0 function0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u7248\u672c\u9009\u62e9");
        ((QIphoneTitleBarFragment) this).mContentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f102545y7);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter;
        if (qUISettingsRecyclerView != null) {
            qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        }
        QUIListItemAdapter qUIListItemAdapter2 = this.adapter;
        if (qUIListItemAdapter2 != null) {
            Group[] th5 = th(this.versionList);
            qUIListItemAdapter2.t0((Group[]) Arrays.copyOf(th5, th5.length));
            Unit unit = Unit.INSTANCE;
        }
    }
}
