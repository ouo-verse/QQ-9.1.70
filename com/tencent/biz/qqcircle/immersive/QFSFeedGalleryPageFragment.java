package com.tencent.biz.qqcircle.immersive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.part.bj;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u001c\u0010\u001c\u001a\u0016\u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/QFSFeedGalleryPageFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragmentFix;", "Lcom/tencent/biz/qqcircle/events/QCircleFeedEvent;", "feedEvent", "", "th", "sh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", "onResume", "", "", "", "getChildDaTongPageParams", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "getLogTag", "getPageId", "getDaTongPageId", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "rh", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "E", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "", UserInfo.SEX_FEMALE, "Z", "mAutoPlay", "<init>", "()V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFeedGalleryPageFragment extends QFSBaseFragmentFix {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private QCircleInitBean mInitBean;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mAutoPlay;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/QFSFeedGalleryPageFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "bean", "", "b", "Landroid/os/Bundle;", "arguments", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.QFSFeedGalleryPageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QCircleInitBean a(@NotNull Bundle arguments) {
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            Serializable serializable = arguments.getSerializable("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.biz.qqcircle.beans.QCircleInitBean");
            return (QCircleInitBean) serializable;
        }

        @JvmStatic
        public final void b(@NotNull Context context, @NotNull QCircleInitBean bean) {
            Class<?> cls;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intent intent = new Intent();
            intent.putExtra("public_fragment_class", QFSFeedGalleryPageFragment.class.getName());
            intent.putExtra("key_bundle_common_init_bean", bean);
            intent.addFlags(268435456);
            intent.addFlags(65536);
            if (uq3.c.A()) {
                cls = QCircleTransFragmentActivity.class;
            } else {
                cls = QCircleFragmentActivity.class;
            }
            intent.setClass(context, cls);
            QCircleLauncherUtil.o(context, intent);
        }

        Companion() {
        }
    }

    private final void sh() {
        requireActivity().finish();
        requireActivity().overridePendingTransition(0, 0);
    }

    private final void th(QCircleFeedEvent feedEvent) {
        if (feedEvent.mState != 3) {
            return;
        }
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean = null;
        }
        if (TextUtils.equals(feedEvent.mTargetId, qCircleInitBean.getFeed().f398449id.get())) {
            sh();
        }
    }

    @JvmStatic
    public static final void uh(@NotNull Context context, @NotNull QCircleInitBean qCircleInitBean) {
        INSTANCE.b(context, qCircleInitBean);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayListOf;
        Part[] partArr = new Part[3];
        QCircleInitBean qCircleInitBean = this.mInitBean;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (qCircleInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean = null;
        }
        FeedCloudMeta$StFeed feed = qCircleInitBean.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed, "mInitBean.getFeed()");
        partArr[0] = new bj(feed, false, 2, defaultConstructorMarker);
        partArr[1] = new QFSSharePart();
        partArr[2] = new QCircleRichMediaDownLoadPart();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(partArr);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public Map<String, Object> getChildDaTongPageParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        QCircleInitBean qCircleInitBean = this.mInitBean;
        QCircleInitBean qCircleInitBean2 = null;
        if (qCircleInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean = null;
        }
        String feedId = qCircleInitBean.getFeedId();
        Intrinsics.checkNotNullExpressionValue(feedId, "mInitBean.feedId");
        linkedHashMap.put("xsj_feed_id", feedId);
        QCircleInitBean qCircleInitBean3 = this.mInitBean;
        if (qCircleInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        } else {
            qCircleInitBean2 = qCircleInitBean3;
        }
        String str = qCircleInitBean2.getFeed().poster.f398463id.get();
        Intrinsics.checkNotNullExpressionValue(str, "mInitBean.feed.poster.id.get()");
        linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168672gb2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_ATLAS_LAYER_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSGalleryFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 101;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            sh();
            return;
        }
        this.mInitBean = INSTANCE.a(arguments);
        w20.a j3 = w20.a.j();
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean = null;
        }
        this.mAutoPlay = j3.d(qCircleInitBean.getFeed().f398449id.get());
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QCirclePluginUtil.setIsGalleryPageOnShow(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleFeedEvent) {
            th((QCircleFeedEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RFWThemeUtil.setStatusBarColor(getActivity(), QCircleSkinHelper.getInstance().getColor(R.color.cje));
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QCirclePluginUtil.setIsGalleryPageOnShow(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragmentFix
    @Nullable
    public ArrayList<Class<? extends SimpleBaseEvent>> rh() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleFeedEvent.class);
        return arrayListOf;
    }
}
