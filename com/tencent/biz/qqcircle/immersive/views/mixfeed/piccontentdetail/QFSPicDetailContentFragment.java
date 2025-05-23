package com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail;

import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.adapter.QFSCommentBlock;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragmentFix;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerAlbumPanelPart;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSNewContentDetailBodyCommentPart;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.e;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.l;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.n;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0015J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0014J(\u0010\u0018\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u0014j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015`\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/QFSPicDetailContentFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragmentFix;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "", "", "getChildDaTongPageParams", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "enableAudioFocus", "", "getContentLayoutId", "getLogTag", "getPageId", "getDaTongPageId", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "rh", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "E", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPicDetailContentFragment extends QFSBaseFragmentFix {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private QCircleInitBean mInitBean;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/QFSPicDetailContentFragment$a;", "", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Landroid/os/Bundle;", "c", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/QFSPicDetailContentFragment;", "fragment", "a", "b", "", "KEY_BLOCK_BUNDLE_INIT_BEAN", "Ljava/lang/String;", "KEY_INIT_BEAN", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail.QFSPicDetailContentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QCircleInitBean a(@NotNull QFSPicDetailContentFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Serializable serializable = fragment.requireArguments().getSerializable("key_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.biz.qqcircle.beans.QCircleInitBean");
            return (QCircleInitBean) serializable;
        }

        @NotNull
        public final QFSPicDetailContentFragment b(@NotNull QCircleInitBean initBean) {
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            QFSPicDetailContentFragment qFSPicDetailContentFragment = new QFSPicDetailContentFragment(null);
            qFSPicDetailContentFragment.setArguments(QFSPicDetailContentFragment.INSTANCE.c(initBean));
            return qFSPicDetailContentFragment;
        }

        @NotNull
        public final Bundle c(@NotNull QCircleInitBean initBean) {
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_bean", initBean);
            return bundle;
        }

        Companion() {
        }
    }

    public /* synthetic */ QFSPicDetailContentFragment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        getReportBean().setDtPageId(QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_PICTEXT_PAGE);
        getReportBean().setDtFromPageId(QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_PICTEXT_PAGE);
        QCircleInitBean qCircleInitBean = null;
        QFSCommentBlock qFSCommentBlock = new QFSCommentBlock(null);
        QCircleInitBean qCircleInitBean2 = this.mInitBean;
        if (qCircleInitBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean2 = null;
        }
        QFSNewContentDetailBodyCommentPart qFSNewContentDetailBodyCommentPart = new QFSNewContentDetailBodyCommentPart(qFSCommentBlock, qCircleInitBean2);
        Bundle bundle = new Bundle();
        QCircleInitBean qCircleInitBean3 = this.mInitBean;
        if (qCircleInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean3 = null;
        }
        bundle.putSerializable("key_block_bundle_bean", qCircleInitBean3);
        Part[] partArr = new Part[10];
        QCircleInitBean qCircleInitBean4 = this.mInitBean;
        if (qCircleInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean4 = null;
        }
        n nVar = new n(qCircleInitBean4);
        nVar.setReportBean(getReportBean());
        Unit unit = Unit.INSTANCE;
        partArr[0] = nVar;
        QCircleInitBean qCircleInitBean5 = this.mInitBean;
        if (qCircleInitBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean5 = null;
        }
        l lVar = new l(qCircleInitBean5);
        lVar.setReportBean(getReportBean());
        partArr[1] = lVar;
        QFSSharePart qFSSharePart = new QFSSharePart();
        qFSSharePart.setReportBean(getReportBean());
        partArr[2] = qFSSharePart;
        partArr[3] = new QFSPersonalPanelPart();
        partArr[4] = new QCircleRichMediaDownLoadPart();
        partArr[5] = new QCircleLightInteractListPart();
        partArr[6] = new com.tencent.biz.qqcircle.immersive.part.push.a();
        partArr[7] = new QFSLayerAlbumPanelPart();
        partArr[8] = qFSNewContentDetailBodyCommentPart;
        QCircleInitBean qCircleInitBean6 = this.mInitBean;
        if (qCircleInitBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean6 = null;
        }
        e eVar = new e(qCircleInitBean6);
        eVar.setReportBean(getReportBean());
        com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.b bVar = new com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.b(bundle, qFSNewContentDetailBodyCommentPart);
        bVar.setReportBean(getReportBean());
        QCircleInitBean qCircleInitBean7 = this.mInitBean;
        if (qCircleInitBean7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        } else {
            qCircleInitBean = qCircleInitBean7;
        }
        partArr[9] = new b(R.id.f47241wr, eVar, bVar, qCircleInitBean);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public boolean enableAudioFocus() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        if (r1 == null) goto L20;
     */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Object> getChildDaTongPageParams() {
        String str;
        PBRepeatMessageField<FeedCloudMeta$StTagInfo> pBRepeatMessageField;
        List<FeedCloudMeta$StTagInfo> list;
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
            qCircleInitBean3 = null;
        }
        String str2 = qCircleInitBean3.getFeed().poster.f398463id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "mInitBean.feed.poster.id.get()");
        linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        QCircleInitBean qCircleInitBean4 = this.mInitBean;
        if (qCircleInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        } else {
            qCircleInitBean2 = qCircleInitBean4;
        }
        FeedCloudMeta$StFeed feed = qCircleInitBean2.getFeed();
        if (feed != null && (pBRepeatMessageField = feed.tagInfos) != null && (list = pBRepeatMessageField.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(list, "get()");
            str = CollectionsKt___CollectionsKt.joinToString$default(list, "|", null, null, 0, null, new Function1<FeedCloudMeta$StTagInfo, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail.QFSPicDetailContentFragment$getChildDaTongPageParams$1$topicName$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
                    String str3 = feedCloudMeta$StTagInfo.tagName.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "it.tagName.get()");
                    return str3;
                }
            }, 30, null);
        }
        str = "";
        linkedHashMap.put("xsj_topic_name", str);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @Deprecated(message = "Deprecated in Java")
    public int getContentLayoutId() {
        return R.layout.gjv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_PICTEXT_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPicDetailContentFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QCircleInitBean a16 = INSTANCE.a(this);
        this.mInitBean = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            a16 = null;
        }
        QCircleReportBean fromReportBean = a16.getFromReportBean();
        if (fromReportBean == null) {
            fromReportBean = new QCircleReportBean();
            fromReportBean.setDtPageId(QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_PICTEXT_PAGE);
        }
        setReportBean(fromReportBean);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QCircleFeedEvent) && ((QCircleFeedEvent) simpleBaseEvent).mState == 3 && !getHostActivity().isFinishing()) {
            getHostActivity().finish();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragmentFix
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> rh() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleFeedEvent.class);
        return arrayListOf;
    }

    QFSPicDetailContentFragment() {
    }
}
