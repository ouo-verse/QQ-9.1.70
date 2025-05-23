package com.tencent.biz.qqcircle.immersive.datacardcover.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverFeedPart;
import com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverHintPart;
import com.tencent.biz.qqcircle.immersive.datacardcover.part.j;
import com.tencent.biz.qqcircle.immersive.events.QFSMakeRedPacketEvent;
import com.tencent.biz.qqcircle.immersive.redpacket.part.QFSRedPacketFeedDownloadPart;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QFSSetCoverFeedEvent;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001 \u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\nH\u0014J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001b0\u001aj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001b`\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/fragment/QFSPersonalCoverFeedFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "th", "uh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "getPageId", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "enableAudioFocus", "com/tencent/biz/qqcircle/immersive/datacardcover/fragment/QFSPersonalCoverFeedFragment$finishBroadcastReceiver$1", "E", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/fragment/QFSPersonalCoverFeedFragment$finishBroadcastReceiver$1;", "finishBroadcastReceiver", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/part/QFSPersonalCoverFeedPart;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/immersive/datacardcover/part/QFSPersonalCoverFeedPart;", "feedPart", "<init>", "()V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverFeedFragment extends QFSBaseFragment {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String H = "mqqapi://qcircle/openqqpublish?&input_tabs=ac&hide_edit_become_photo=1&hide_publish_permission=1&return_scheme=" + Uri.encode("mqqapi://qcircle/openpersonalcoverfeedpage");

    @NotNull
    private static final String I = "mqqapi://qcircle/openqqpublish?target=1&input_tabs=ac&hide_edit_become_photo=1&hide_publish_permission=1&tag=QQ\u8d44\u6599\u5c01\u9762\u4f1a\u52a8\u5566&xsj_operation_activity_id=qq_profile_page&return_scheme=" + Uri.encode("mqqapi://qcircle/openpersonalcoverfeedpage");

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final QFSPersonalCoverFeedFragment$finishBroadcastReceiver$1 finishBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedFragment$finishBroadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            QLog.d("QFSPersonalCoverFeedFragment", 1, "finishBroadcastReceiver ");
            FragmentActivity activity = QFSPersonalCoverFeedFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    };

    /* renamed from: F, reason: from kotlin metadata */
    private QFSPersonalCoverFeedPart feedPart;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\u0006\u001a\u00020\u00032&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004R\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/fragment/QFSPersonalCoverFeedFragment$a;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "attr", "a", "DEFAULT_JUMP_SCHEMA", "Ljava/lang/String;", "JUMP_SCHEMA_PREFIX", "TAG", "THIS_PAGE_SCHEMA", "TOPIC", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@Nullable HashMap<String, String> attr) {
            boolean z16;
            if (attr == null) {
                return QFSPersonalCoverFeedFragment.I;
            }
            String str = attr.get("tag");
            if (str == null) {
                str = "";
            }
            String str2 = "qq_dynamicAvatar";
            if (!Intrinsics.areEqual(attr.get("taskid"), "qq_dynamicAvatar")) {
                str2 = "qq_profile_page";
            }
            String str3 = QFSPersonalCoverFeedFragment.H;
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = "QQ\u8d44\u6599\u5c01\u9762\u4f1a\u52a8\u5566";
            }
            String str4 = str3 + "&xsj_operation_activity_id=" + str2 + "&taskid=" + str2 + "&tag=" + ((Object) str) + "&target=1";
            if (attr.containsKey(QCircleScheme.AttrQQPublish.FROM_ENTRANCE)) {
                return str4 + "&dynamic_avatar_from_entrance=" + ((Object) attr.get(QCircleScheme.AttrQQPublish.FROM_ENTRANCE));
            }
            return str4;
        }

        Companion() {
        }
    }

    private final void th() {
        QLog.d("QFSPersonalCoverFeedFragment", 1, "handleMakeRedPacketEvent ");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void uh() {
        QLog.d("QFSPersonalCoverFeedFragment", 1, "handleSetCoverFeedEvent ");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QFSPersonalCoverFeedPart qFSPersonalCoverFeedPart = new QFSPersonalCoverFeedPart(R.id.f241608d);
        this.feedPart = qFSPersonalCoverFeedPart;
        Unit unit = Unit.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new j(0, 0, R.string.f189423zc, 3, null), new QFSPersonalCoverHintPart(), qFSPersonalCoverFeedPart, new QFSRedPacketFeedDownloadPart());
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public boolean enableAudioFocus() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public Map<String, Object> getChildDaTongPageParams() {
        Serializable serializable;
        HashMap<String, String> schemeAttrs;
        Intent intent;
        Map<String, Object> childDaTongPageParams = super.getChildDaTongPageParams();
        if (childDaTongPageParams == null) {
            childDaTongPageParams = new HashMap<>();
        }
        FragmentActivity activity = getActivity();
        QCircleInitBean qCircleInitBean = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializable;
        }
        if (qCircleInitBean != null && (schemeAttrs = qCircleInitBean.getSchemeAttrs()) != null && schemeAttrs.containsKey(QCircleScheme.AttrQQPublish.FROM_ENTRANCE)) {
            childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, schemeAttrs.get(QCircleScheme.AttrQQPublish.FROM_ENTRANCE));
        }
        return childDaTongPageParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gkp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_MY_WORKS_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        eventClass.add(QFSSetCoverFeedEvent.class);
        eventClass.add(QFSMakeRedPacketEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "super.getEventClass().ap\u2026nt::class.java)\n        }");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCoverFeedFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.finishBroadcastReceiver);
        }
        super.onDestroyView();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        super.onReceiveEvent(event);
        if (event instanceof QFSSetCoverFeedEvent) {
            uh();
        } else if (event instanceof QFSMakeRedPacketEvent) {
            th();
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.finishBroadcastReceiver, new IntentFilter(QCircleScheme.AttrQQPublish.BROADCAST_WINK_DYNAMIC_AVATAR_FINISH));
        }
    }
}
