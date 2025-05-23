package com.tencent.mobileqq.wink.publish.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetRecommendTagRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.publish.fs.request.FSGetAssociateTagRequest;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.winkpublish.model.ExtendExifInterface;
import com.tencent.mobileqq.winkpublish.util.ExifUtil;
import com.tencent.mobileqq.winkpublish.util.WinkHostLbsHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.LabelInfo;
import feedcloud.FeedCloudMeta$StExifInfo;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudRead$StGetPublishPageRecomTagListRsp;
import feedcloud.FeedCloudTagcategorysvr$PicRecTags;
import feedcloud.FeedCloudTagcategorysvr$PicRecomEntry;
import feedcloud.FeedCloudTagcategorysvr$StTagCategoryRecomRsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 b2\u00020\u0001:\u0002cdB\u0007\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J:\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013H\u0002J4\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0015j\b\u0012\u0004\u0012\u00020\u0019`\u00172\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\u001f\u001a\u00020\u00042\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017J\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0004J\b\u0010%\u001a\u00020\u000bH\u0016R$\u0010+\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0018\u00103\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010(RB\u00109\u001a.\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b05\u0018\u000104j\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b05\u0018\u0001`68\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020;0?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010H\u001a\u0012\u0012\u0004\u0012\u00020E0\u0015j\b\u0012\u0004\u0012\u00020E`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR$\u0010K\u001a\u0012\u0012\u0004\u0012\u00020I0\u0015j\b\u0012\u0004\u0012\u00020I`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010GR(\u0010N\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020E\u0018\u0001050L0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010=R+\u0010Q\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020E\u0018\u0001050L0?8\u0006\u00a2\u0006\f\n\u0004\bO\u0010A\u001a\u0004\bP\u0010CR$\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010(\u001a\u0004\bS\u0010*\"\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010(R\u0016\u0010Z\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/content/Intent;", "intent", "", "f2", "e2", "", "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/FeedCloudTagcategorysvr$StTagCategoryRecomRsp;", "rsp", "U1", "Lcom/tencent/mobileqq/wink/publish/fs/request/FSGetAssociateTagRequest;", "req", FeedManager.LOAD_MORE, "Lfeedcloud/FeedCloudRead$StGetPublishPageRecomTagListRsp;", "T1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "mediaInfos", "Lfeedcloud/FeedCloudTagcategorysvr$PicRecomEntry;", SemanticAttributes.DbSystemValues.H2, "Lfeedcloud/FeedCloudMeta$StGPSV2;", "P1", "W1", "localMediaInfoHashMap", "c2", "Z1", "query", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "N1", "getLogTag", "<set-?>", "i", "Ljava/lang/String;", "S1", "()Ljava/lang/String;", "tagsJoinedFromIntent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "tagsFromIntent", BdhLogUtil.LogTag.Tag_Conn, "tagsFromChallenge", "D", "musicMid", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "labelsFromEditor", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel$b;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_tagDataLiveData", "Landroidx/lifecycle/LiveData;", "G", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "tagDataLiveData", "Lfeedcloud/FeedCloudMeta$StTagInfo;", "H", "Ljava/util/ArrayList;", "recommendTagInfoSet", "Lcooperation/qzone/model/LabelInfo;", "I", "mLabelInfos", "Lcom/tencent/richframework/data/base/UIStateData;", "J", "_associateLabelState", "K", "O1", "associateLabelState", "L", "Q1", "g2", "(Ljava/lang/String;)V", "M", "attachInfo", "N", "Z", "isFirstAttachAssociate", "P", "Lkotlin/Lazy;", "X1", "()Z", "isFrameTagExperiment", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishTagViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public String tagsFromChallenge;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String musicMid;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private HashMap<String, List<String>> labelsFromEditor;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TagData> _tagDataLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<TagData> tagDataLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<FeedCloudMeta$StTagInfo> recommendTagInfoSet;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<LabelInfo> mLabelInfos;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<FeedCloudMeta$StTagInfo>>> _associateLabelState;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<FeedCloudMeta$StTagInfo>>> associateLabelState;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String query;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private String attachInfo;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFirstAttachAssociate;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy isFrameTagExperiment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tagsJoinedFromIntent = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> tagsFromIntent = new ArrayList();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcooperation/qzone/model/LabelInfo;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "tagInfoSet", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "tagTips", "d", "tagTipsJumpUrl", "I", "()I", "recomType", "e", "updateSize", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;II)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class TagData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<LabelInfo> tagInfoSet;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tagTips;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tagTipsJumpUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int recomType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int updateSize;

        /* JADX WARN: Multi-variable type inference failed */
        public TagData(@NotNull List<? extends LabelInfo> tagInfoSet, @NotNull String tagTips, @NotNull String tagTipsJumpUrl, int i3, int i16) {
            Intrinsics.checkNotNullParameter(tagInfoSet, "tagInfoSet");
            Intrinsics.checkNotNullParameter(tagTips, "tagTips");
            Intrinsics.checkNotNullParameter(tagTipsJumpUrl, "tagTipsJumpUrl");
            this.tagInfoSet = tagInfoSet;
            this.tagTips = tagTips;
            this.tagTipsJumpUrl = tagTipsJumpUrl;
            this.recomType = i3;
            this.updateSize = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getRecomType() {
            return this.recomType;
        }

        @NotNull
        public final List<LabelInfo> b() {
            return this.tagInfoSet;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTagTips() {
            return this.tagTips;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTagTipsJumpUrl() {
            return this.tagTipsJumpUrl;
        }

        /* renamed from: e, reason: from getter */
        public final int getUpdateSize() {
            return this.updateSize;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TagData)) {
                return false;
            }
            TagData tagData = (TagData) other;
            if (Intrinsics.areEqual(this.tagInfoSet, tagData.tagInfoSet) && Intrinsics.areEqual(this.tagTips, tagData.tagTips) && Intrinsics.areEqual(this.tagTipsJumpUrl, tagData.tagTipsJumpUrl) && this.recomType == tagData.recomType && this.updateSize == tagData.updateSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.tagInfoSet.hashCode() * 31) + this.tagTips.hashCode()) * 31) + this.tagTipsJumpUrl.hashCode()) * 31) + this.recomType) * 31) + this.updateSize;
        }

        @NotNull
        public String toString() {
            return "TagData(tagInfoSet=" + this.tagInfoSet + ", tagTips=" + this.tagTips + ", tagTipsJumpUrl=" + this.tagTipsJumpUrl + ", recomType=" + this.recomType + ", updateSize=" + this.updateSize + ")";
        }
    }

    public PublishTagViewModel() {
        Lazy lazy;
        MutableLiveData<TagData> mutableLiveData = new MutableLiveData<>();
        this._tagDataLiveData = mutableLiveData;
        this.tagDataLiveData = mutableLiveData;
        this.recommendTagInfoSet = new ArrayList<>();
        this.mLabelInfos = new ArrayList<>();
        MutableLiveData<UIStateData<List<FeedCloudMeta$StTagInfo>>> mutableLiveData2 = new MutableLiveData<>();
        this._associateLabelState = mutableLiveData2;
        this.associateLabelState = mutableLiveData2;
        this.isFirstAttachAssociate = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel$isFrameTagExperiment$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_qqvideo_topicguid_1505"));
            }
        });
        this.isFrameTagExperiment = lazy;
    }

    private final FeedCloudMeta$StGPSV2 P1() {
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        LbsDataV2.GpsInfo currGps = WinkHostLbsHelper.getCurrGps("qqcircle");
        if (currGps != null) {
            feedCloudMeta$StGPSV2.alt.set(currGps.alt);
            feedCloudMeta$StGPSV2.lat.set(currGps.lat);
            feedCloudMeta$StGPSV2.lon.set(currGps.lon);
            feedCloudMeta$StGPSV2.eType.set(currGps.gpsType);
            QLog.i("PublishTagViewModel", 2, "[getCurrentGps] longitude:" + currGps.lon + ", latitude" + currGps.lat);
        }
        return feedCloudMeta$StGPSV2;
    }

    private final void T1(FSGetAssociateTagRequest req, boolean loadMore, boolean isSuccess, long retCode, String errMsg, FeedCloudRead$StGetPublishPageRecomTagListRsp rsp) {
        UIStateData<List<FeedCloudMeta$StTagInfo>> msg2;
        String str;
        PBStringField pBStringField;
        if (isSuccess && retCode == 0 && rsp != null) {
            boolean z16 = false;
            this.isFirstAttachAssociate = false;
            this.attachInfo = rsp.attachInfo.get();
            List<FeedCloudMeta$StTagInfo> list = rsp.tagInfos.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.tagInfos.get()");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                boolean z17 = true;
                if (!it.hasNext()) {
                    break;
                }
                FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = (FeedCloudMeta$StTagInfo) it.next();
                if (feedCloudMeta$StTagInfo != null && (pBStringField = feedCloudMeta$StTagInfo.tagName) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z17 = false;
                }
                if (z17) {
                    feedCloudMeta$StTagInfo = null;
                }
                if (feedCloudMeta$StTagInfo != null) {
                    arrayList.add(feedCloudMeta$StTagInfo);
                }
            }
            String str2 = req.getmReq().word.get();
            if (arrayList.isEmpty()) {
                msg2 = UIStateData.obtainEmpty().setLoadMore(loadMore).setMsg(str2);
            } else {
                UIStateData data = UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(loadMore, arrayList);
                if (rsp.isOver.get() == 1) {
                    z16 = true;
                }
                msg2 = data.setFinish(z16).setMsg(str2);
            }
            this._associateLabelState.postValue(msg2);
            return;
        }
        this._associateLabelState.postValue(UIStateData.obtainError(errMsg).setLoadMore(loadMore));
    }

    private final void U1(boolean isSuccess, long retCode, String errMsg, FeedCloudTagcategorysvr$StTagCategoryRecomRsp rsp) {
        PBRepeatMessageField<FeedCloudMeta$StTagInfo> pBRepeatMessageField;
        boolean z16;
        LabelInfo labelInfo;
        QLog.i("PublishTagViewModel", 1, "[handleRecommendTagRsp] isSuccess:" + isSuccess + " retCode:" + retCode + " errMsg:" + errMsg);
        if (!isSuccess) {
            return;
        }
        PBRepeatMessageField<FeedCloudMeta$StTagInfo> pBRepeatMessageField2 = null;
        if (rsp != null) {
            pBRepeatMessageField = rsp.tagList;
        } else {
            pBRepeatMessageField = null;
        }
        if (pBRepeatMessageField == null) {
            if (rsp != null) {
                pBRepeatMessageField2 = rsp.tagList;
            }
            QLog.i("PublishTagViewModel", 1, "[handleRecommendTagRsp] rsp=" + rsp + ", rsp.tagList=" + pBRepeatMessageField2);
            return;
        }
        try {
            List<FeedCloudMeta$StTagInfo> tagList = rsp.tagList.get();
            this.recommendTagInfoSet.clear();
            this.recommendTagInfoSet.addAll(tagList);
            Intrinsics.checkNotNullExpressionValue(tagList, "tagList");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = tagList.iterator();
            while (true) {
                boolean z17 = false;
                if (!it.hasNext()) {
                    break;
                }
                FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = (FeedCloudMeta$StTagInfo) it.next();
                if (feedCloudMeta$StTagInfo.tagId != null && feedCloudMeta$StTagInfo.tagName != null) {
                    labelInfo = new LabelInfo();
                    labelInfo.f390867id = feedCloudMeta$StTagInfo.tagId.get();
                    labelInfo.name = feedCloudMeta$StTagInfo.tagName.get();
                    labelInfo.rank = String.valueOf(feedCloudMeta$StTagInfo.medal.rank.get());
                    if (feedCloudMeta$StTagInfo.isSelected.get() == 1) {
                        z17 = true;
                    }
                    labelInfo.hasSelected = z17;
                    labelInfo.type = feedCloudMeta$StTagInfo.tagType.get();
                    labelInfo.iconUrl = feedCloudMeta$StTagInfo.operateIconUrl.get();
                    QLog.i("PublishTagViewModel", 1, "[handleRecommendTagRsp] labelInfo=" + labelInfo);
                } else {
                    labelInfo = null;
                }
                if (labelInfo != null) {
                    arrayList.add(labelInfo);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                LabelInfo labelInfo2 = (LabelInfo) obj;
                if (!this.mLabelInfos.contains(labelInfo2) && !this.tagsFromIntent.contains(labelInfo2.name)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            this.mLabelInfos.addAll(arrayList2);
            ArrayList<LabelInfo> arrayList3 = this.mLabelInfos;
            String str = rsp.toast.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.toast.get()");
            String str2 = rsp.jumpURL.get();
            Intrinsics.checkNotNullExpressionValue(str2, "rsp.jumpURL.get()");
            this._tagDataLiveData.postValue(new TagData(arrayList3, str, str2, rsp.recomType.get(), arrayList2.size()));
            QLog.d("PublishTagViewModel", 1, "[handleRecommendTagRsp] tag recomType=" + rsp.recomType.get());
            if (X1()) {
                com.tencent.mobileqq.wink.editor.recommend.a.f321459a.f(WinkContext.INSTANCE.d().getTraceId(), null, rsp);
            }
        } catch (Exception e16) {
            QLog.e("PublishTagViewModel", 1, "[handleRecommendTagRsp] parse response data failed!", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(PublishTagViewModel this$0, FSGetAssociateTagRequest request, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String errMsg, FeedCloudRead$StGetPublishPageRecomTagListRsp feedCloudRead$StGetPublishPageRecomTagListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        QLog.i("PublishTagViewModel", 1, "[requestAssociateLabel] onReceive isSuccess:" + z17 + " retCode:" + j3 + " errMsg:" + errMsg);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.T1(request, z16, z17, j3, errMsg, feedCloudRead$StGetPublishPageRecomTagListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(PublishTagViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String errMsg, FeedCloudTagcategorysvr$StTagCategoryRecomRsp feedCloudTagcategorysvr$StTagCategoryRecomRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.U1(z16, j3, errMsg, feedCloudTagcategorysvr$StTagCategoryRecomRsp);
    }

    private final void e2() {
        ArrayList arrayList;
        ArrayList<WinkEditData> editDatas;
        boolean isBlank;
        String str;
        ArrayList arrayList2 = new ArrayList();
        WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(WinkContext.INSTANCE.d().getMissionId());
        String str2 = null;
        if (d16 != null && (editDatas = d16.getEditDatas()) != null) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = editDatas.iterator();
            while (it.hasNext()) {
                InteractiveModel challengeData = ((WinkEditData) it.next()).getChallengeData();
                if (challengeData != null) {
                    str = challengeData.getTagName();
                } else {
                    str = null;
                }
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            arrayList = new ArrayList();
            for (Object obj : arrayList3) {
                isBlank = StringsKt__StringsJVMKt.isBlank((String) obj);
                if (!isBlank) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        TagRetriever.f326413a.a(arrayList2, arrayList);
        if (arrayList2.size() >= 1) {
            str2 = (String) arrayList2.get(0);
        }
        this.tagsFromChallenge = str2;
        QLog.i("PublishTagViewModel", 1, "retrieveChallengeTags... " + str2);
    }

    private final void f2(Intent intent) {
        TagRetriever tagRetriever = TagRetriever.f326413a;
        List<String> e16 = tagRetriever.e(intent);
        this.tagsFromIntent.addAll(e16);
        this.tagsJoinedFromIntent = tagRetriever.g(e16);
    }

    private final ArrayList<FeedCloudTagcategorysvr$PicRecomEntry> h2(ArrayList<LocalMediaInfo> mediaInfos) {
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        HashMap<String, String> exifToHashMapForKey;
        Set<Map.Entry<String, String>> entrySet;
        int collectionSizeOrDefault2;
        boolean contains$default;
        List<String> list;
        int collectionSizeOrDefault3;
        ArrayList arrayList = null;
        if (mediaInfos != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaInfos, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo localMediaInfo : mediaInfos) {
                FeedCloudTagcategorysvr$PicRecomEntry feedCloudTagcategorysvr$PicRecomEntry = new FeedCloudTagcategorysvr$PicRecomEntry();
                QLog.i("PublishTagViewModel", 1, "[toPicRecomEntry] path=" + localMediaInfo.path + ", aiTextLabel=" + localMediaInfo.aiTextLabel);
                ArrayList<String> arrayList3 = localMediaInfo.aiTextLabel;
                boolean z18 = false;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    feedCloudTagcategorysvr$PicRecomEntry.recomTags.set(localMediaInfo.aiTextLabel);
                }
                String str = localMediaInfo.materialID;
                if (str != null && str.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    feedCloudTagcategorysvr$PicRecomEntry.materialId.set(localMediaInfo.materialID);
                }
                HashMap<String, List<String>> hashMap = this.labelsFromEditor;
                if (hashMap != null && (list = hashMap.get(localMediaInfo.path)) != null) {
                    List<String> list2 = list;
                    collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
                    for (String str2 : list2) {
                        FeedCloudTagcategorysvr$PicRecTags feedCloudTagcategorysvr$PicRecTags = new FeedCloudTagcategorysvr$PicRecTags();
                        feedCloudTagcategorysvr$PicRecTags.recomTags.set(str2);
                        arrayList4.add(feedCloudTagcategorysvr$PicRecTags);
                    }
                    if (!arrayList4.isEmpty()) {
                        feedCloudTagcategorysvr$PicRecomEntry.tags.set(arrayList4);
                    }
                }
                try {
                    if (!JpegExifReader.isCrashJpeg(localMediaInfo.path)) {
                        String mMimeType = localMediaInfo.mMimeType;
                        if (mMimeType != null) {
                            Intrinsics.checkNotNullExpressionValue(mMimeType, "mMimeType");
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) mMimeType, (CharSequence) "video", false, 2, (Object) null);
                            if (!contains$default) {
                                z18 = true;
                            }
                        }
                        if (z18 && (exifToHashMapForKey = ExifUtil.getExifToHashMapForKey(new ExtendExifInterface(localMediaInfo.path))) != null && (entrySet = exifToHashMapForKey.entrySet()) != null) {
                            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
                            ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
                            for (Map.Entry<String, String> it : entrySet) {
                                com.tencent.mobileqq.wink.report.f fVar = com.tencent.mobileqq.wink.report.f.f326266a;
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                arrayList5.add(fVar.c(it));
                            }
                            if (!arrayList5.isEmpty()) {
                                FeedCloudMeta$StExifInfo feedCloudMeta$StExifInfo = new FeedCloudMeta$StExifInfo();
                                feedCloudMeta$StExifInfo.kvs.set(arrayList5);
                                feedCloudTagcategorysvr$PicRecomEntry.exifInfo.set(feedCloudMeta$StExifInfo);
                            }
                        }
                    }
                } catch (Exception unused) {
                    QLog.e("PublishTagViewModel", 1, "read pic exif error");
                }
                arrayList2.add(feedCloudTagcategorysvr$PicRecomEntry);
            }
            arrayList = arrayList2;
        }
        ArrayList<FeedCloudTagcategorysvr$PicRecomEntry> arrayList6 = new ArrayList<>();
        if (arrayList != null) {
            arrayList6.addAll(arrayList);
        }
        return arrayList6;
    }

    public final void N1() {
        this.mLabelInfos.clear();
    }

    @NotNull
    public final LiveData<UIStateData<List<FeedCloudMeta$StTagInfo>>> O1() {
        return this.associateLabelState;
    }

    @Nullable
    /* renamed from: Q1, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    @NotNull
    public final LiveData<TagData> R1() {
        return this.tagDataLiveData;
    }

    @NotNull
    /* renamed from: S1, reason: from getter */
    public final String getTagsJoinedFromIntent() {
        return this.tagsJoinedFromIntent;
    }

    public final void W1(@Nullable Intent intent) {
        HashMap<String, List<String>> hashMap;
        if (intent == null) {
            return;
        }
        this.musicMid = intent.getStringExtra(QQWinkConstants.PUBLISH_MUSIC_MID);
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.PUBLISH_EDIT_MEDIA_LABEL_DATA);
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        this.labelsFromEditor = hashMap;
        f2(intent);
        e2();
    }

    public final boolean X1() {
        return ((Boolean) this.isFrameTagExperiment.getValue()).booleanValue();
    }

    public final void Z1() {
        int i3;
        TagData value = this.tagDataLiveData.getValue();
        if (value != null) {
            i3 = value.getRecomType();
        } else {
            i3 = 0;
        }
        if ((!this.recommendTagInfoSet.isEmpty()) && i3 == 1) {
            this._associateLabelState.postValue(UIStateData.obtainSuccess(true).setData(false, this.recommendTagInfoSet).setFinish(true).setMsg(""));
        } else {
            a2("", false);
        }
    }

    public final void a2(@NotNull String query, final boolean isLoadMore) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(query, "query");
        if (!isLoadMore) {
            this.query = query;
            this.attachInfo = null;
        }
        final FSGetAssociateTagRequest fSGetAssociateTagRequest = new FSGetAssociateTagRequest(this.attachInfo, query);
        if (this.isFirstAttachAssociate && (!this.recommendTagInfoSet.isEmpty())) {
            PBRepeatField<String> pBRepeatField = fSGetAssociateTagRequest.getmReq().matchTagNameList;
            ArrayList<FeedCloudMeta$StTagInfo> arrayList = this.recommendTagInfoSet;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((FeedCloudMeta$StTagInfo) it.next()).tagName.get());
            }
            pBRepeatField.set(arrayList2);
        }
        VSNetworkHelper.getInstance().sendRequest(fSGetAssociateTagRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.t
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                PublishTagViewModel.b2(PublishTagViewModel.this, fSGetAssociateTagRequest, isLoadMore, baseRequest, z16, j3, str, (FeedCloudRead$StGetPublishPageRecomTagListRsp) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c2(@Nullable ArrayList<LocalMediaInfo> localMediaInfoHashMap) {
        int i3;
        List<byte[]> list;
        com.tencent.mobileqq.wink.editor.recommend.a aVar;
        if (!this.mLabelInfos.isEmpty()) {
            QLog.d("PublishTagViewModel", 1, "[requestBasicRecommendTags] already have tags");
            return;
        }
        Integer num = null;
        if (X1()) {
            try {
                aVar = com.tencent.mobileqq.wink.editor.recommend.a.f321459a;
            } catch (Exception e16) {
                QLog.e("PublishTagViewModel", 1, "[requestBasicRecommendTags] ", e16);
            }
            if (Intrinsics.areEqual(aVar.d(), WinkContext.INSTANCE.d().getTraceId())) {
                FeedCloudTagcategorysvr$StTagCategoryRecomRsp c16 = aVar.c();
                if (c16 != null && c16.tagList.size() > 0) {
                    QLog.i("PublishTagViewModel", 1, "[requestBasicRecommendTags] use stored tags");
                    U1(true, 0L, "", c16);
                    return;
                }
                i3 = 3;
                list = aVar.b();
                if (list != null) {
                    num = Integer.valueOf(list.size());
                }
                QLog.d("PublishTagViewModel", 1, "[requestBasicRecommendTags] buffer size=" + num);
                VSNetworkHelper.getInstance().sendRequest(new QCircleGetRecommendTagRequest(P1(), h2(localMediaInfoHashMap), this.musicMid, list, i3), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.s
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        PublishTagViewModel.d2(PublishTagViewModel.this, baseRequest, z16, j3, str, (FeedCloudTagcategorysvr$StTagCategoryRecomRsp) obj);
                    }
                });
            }
            QLog.d("PublishTagViewModel", 1, "[requestBasicRecommendTags] different traceId");
            aVar.a();
            i3 = 3;
        } else {
            i3 = 1;
        }
        list = null;
        if (list != null) {
        }
        QLog.d("PublishTagViewModel", 1, "[requestBasicRecommendTags] buffer size=" + num);
        VSNetworkHelper.getInstance().sendRequest(new QCircleGetRecommendTagRequest(P1(), h2(localMediaInfoHashMap), this.musicMid, list, i3), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.s
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                PublishTagViewModel.d2(PublishTagViewModel.this, baseRequest, z16, j3, str, (FeedCloudTagcategorysvr$StTagCategoryRecomRsp) obj);
            }
        });
    }

    public final void g2(@Nullable String str) {
        this.query = str;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublishTagViewModel";
    }
}
